package DpDemo.PageComponents;

import DpDemo.AbstractComponents.AbstractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends AbstractComponent {

    By headerFlightsLink = By.cssSelector("a[title='Flights']");
    By links = By.cssSelector("a");

    public NavigationBar(WebDriver driver, By headerElements) {

        super(driver, headerElements);
    }

    public String selectFlightLinkFromHeader() {

       return findElement(headerFlightsLink).getAttribute("class");


    }

    public int getHeaderLinkCount() {

       return findElements(links).size();
    }
}
