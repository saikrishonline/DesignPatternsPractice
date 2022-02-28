package DpDemo.MainPageObjects;

import DpDemo.AbstractComponents.SearchFlightAvailability;
import DpDemo.AbstractComponents.StrategyFactor;
import DpDemo.PageComponents.FooterNavigationBar;
import DpDemo.PageComponents.NavigationBar;
import DpDemo.Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TravelHomePage extends Base {


    By footerElements = By.id("traveller-home");
    By headerElements = By.className("search-buttons-heading");
    WebDriver driver;

    SearchFlightAvailability searchFlightAvailability;

    public TravelHomePage(WebDriver driver)  {


        this.driver = driver;
    }

    public void getTo(String URL) {

        driver.get(URL);
    }



    public NavigationBar getNavigationBar() {

        return new NavigationBar(driver, headerElements);

    }


    public FooterNavigationBar getFooterNavigationBar() {

        return new FooterNavigationBar(driver,footerElements);

    }

    public void setBookingStrategy(String strategyType) {

        StrategyFactor sf = new StrategyFactor(driver);
        searchFlightAvailability =  sf.createStrategy(strategyType);
       // this.searchFlightAvailability = searchFlightAvailability;


    }



    public void checkAvailability(HashMap<String,String> reservationDetails)  {

        searchFlightAvailability.checkAvailability(reservationDetails);
    }
}
