package DpDemo.PageComponents;

import DpDemo.AbstractComponents.AbstractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNavigationBar extends AbstractComponent {

    //WebDriver driver;

    //method to handle footer options
    //when selenium executes any method in this class, it should search only in that section


    By flightsLink = By.cssSelector("a[title='Flights']");
    By links = By.cssSelector("a");

    public FooterNavigationBar(WebDriver driver, By footerElements) {
        super(driver, footerElements); //When you inherit parent class - you should invoke parent class constructor
                // in your child class
    }

    public String selectFlightsInFooterSection() {
        //create custom findElement so that the search will be restricted to the footer section.
            return findElement(flightsLink).getAttribute("class");

    }

    public int getLinkCount(){

       return findElements(links).size();
    }



}
