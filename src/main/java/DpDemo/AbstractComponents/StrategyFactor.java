package DpDemo.AbstractComponents;


import DpDemo.PageComponents.MultiTrip;
import DpDemo.PageComponents.RoundTrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StrategyFactor {

    WebDriver driver;
    By sectionElement = By.id("flightSearchContainer");

    public StrategyFactor(WebDriver driver) {

        this.driver =  driver;
    }


    public SearchFlightAvailability createStrategy(String strategyType) {

        if (strategyType.equalsIgnoreCase("multitrip")) {

            return new MultiTrip(driver, sectionElement);
        }

        else if (strategyType.equalsIgnoreCase("roundtrip")) {

            return new RoundTrip(driver, sectionElement);

        }
        return null;



    }


}
