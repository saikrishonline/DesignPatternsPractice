package DpDemo.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class AbstractComponent {


    WebElement sectionElements;

    WebDriver driver;
    public AbstractComponent(WebDriver driver, By sectionElements) {

        this.driver = driver;
        this.sectionElements = driver.findElement(sectionElements);

    }

    public WebElement findElement(By findElementBy) {

        return sectionElements.findElement(findElementBy);

    }

    public List<WebElement> findElements(By findElementBy) {

        return sectionElements.findElements(findElementBy);
    }

    public void waitForElementToDisappear(By findBy) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }

}
