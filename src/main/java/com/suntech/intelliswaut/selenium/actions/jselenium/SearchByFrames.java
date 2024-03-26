package com.suntech.intelliswaut.selenium.actions.jselenium;

import static org.openqa.selenium.support.ui.ExpectedConditions.frameToBeAvailableAndSwitchToIt;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;


public class SearchByFrames {
    private final WebDriver driver;
    private final Supplier<WebElement> supplier;

    static SearchByFrames of(By locator, WebDriver driver) {
        return new SearchByFrames(locator, driver);
    }

    static SearchByFrames of(Supplier<WebElement> supplier, WebDriver driver) {
        return new SearchByFrames(supplier, driver);
    }

    private SearchByFrames(By locator, WebDriver driver) {
        this(() -> driver.findElement(locator), driver);
    }

    private SearchByFrames(Supplier<WebElement> supplier, WebDriver driver) {
        this.driver = driver;
        this.supplier = supplier;
    }

    /**
     * Method will jump through each frame and try to find element, using invoke of method {@link WebElement#isEnabled}
     * if this invoke throws {@link NoSuchElementException} or {@link StaleElementReferenceException} or timeout exceeds
     * method returns {@link Optional#empty()}.
     * <b>NOTICE</b>:<p>
     * If element was not found after ONE iteration of all found frames, this method returns immediately after ONE iteration was done.<p>
     * If you need to iterate through frames during some timeout, it is YOUR responsibility to make such a sync logic.
     *
     * @return Optional whether element was found or not.
     */
    public Optional<WebElement> getElem() {
        return findElementByFrames();
    }

    private Optional<WebElement> findElementByFrames() {
        switchToTop();
        List<WebElement> frames = findFrames();
        if (!frames.isEmpty()) {
            return lookThroughFrames(frames);
        } else {
            return Optional.empty();
        }
    }

    private Optional<WebElement> lookThroughFrames(List<WebElement> frames) {
        for (int i = 0; i < frames.size(); i++) {
            if (i != 0) {
                driver.switchTo().parentFrame();
            }
            if (switchedToFrame(findFrames().get(i))) {
                Optional<WebElement> result = lookElem();
                if (result.isPresent()) {
                    return result;
                } else {
                    List<WebElement> childFrames = findFrames();
                    if (!childFrames.isEmpty()) {
                        Optional<WebElement> webElement = lookThroughFrames(childFrames);
                        if (webElement.isPresent()) {
                            return webElement;
                        }
                    }
                }
            } else {
                return Optional.empty();
            }
        }

        driver.switchTo().parentFrame();
        return Optional.empty();

    }

    private Optional<WebElement> lookElem() {
        try {
            WebElement element = supplier.get();
            return isExist(element);
        } catch (StaleElementReferenceException | NoSuchElementException | AssertionError e) {
            return Optional.empty();
        }
    }

    private Optional<WebElement> isExist(WebElement element) {
        try {
            element.isEnabled();
            return Optional.of(element);
        } catch (StaleElementReferenceException | NoSuchElementException | AssertionError e) {
            return Optional.empty();
        }
    }

    private boolean switchedToFrame(WebElement WebElement) {
        try {
            new FluentWait<>(driver)
                    .withTimeout(Duration.ofMillis(300))
                    .pollingEvery(Duration.ofMillis(100))
                    .until(frameToBeAvailableAndSwitchToIt(WebElement));
            return true;
        } catch (TimeoutException timeout) {
            return false;
        }
    }

    private List<WebElement> findFrames() {
        return driver.findElements(By.tagName("iframe"));
    }

    private void switchToTop() {
        driver.switchTo().defaultContent();
    }
}