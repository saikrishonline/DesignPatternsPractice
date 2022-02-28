package DpDemo.PageComponents;


import DpDemo.AbstractComponents.AbstractComponent;
import DpDemo.AbstractComponents.SearchFlightAvailability;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvailability {

    private By rdm = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By multiModeAlert = By.id("MultiCityModelAlert");
    private By from = By.cssSelector("input[id='ctl00_mainContent_ddl_originStation1_CTXT']");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By from2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By searchBtn = By.xpath("(//input[@value='Search'])[1]");
    WebDriver driver;

    public MultiTrip(WebDriver driver, By sectionElements) {

        super(driver, sectionElements);
        this.driver = driver;
    }

    @Override
    public void checkAvailability(HashMap<String, String> reserverationDetails) {

        System.out.print("I am inside multiTrip");
        makeStateReady(s->selectOriginCity(reserverationDetails.get("origin")));
        selectDestCity(reserverationDetails.get("destination"));
        selectOrigin2(reserverationDetails.get("origin2"));
        findElement(searchBtn).click();


    }
    public void selectOriginCity(String origin){

        findElement(from).click();
        By selectOriginCity = By.xpath("//a[@value='"+origin+"']");
        findElement(selectOriginCity).click();

    }

    public void selectDestCity(String destination)  {

        findElement(to).click();
        By selectDestCity = By.xpath("(//a[@value='"+destination+"'])[2]");
        findElement(selectDestCity).click();




    }

    public void selectOrigin2(String origin2)  {

        findElement(from2).click();
        By origin2city = By.xpath("(//a[@value='"+origin2+"'])[3]");
        findElement(origin2city).click();

        //findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();


    }

    public void makeStateReady(Consumer<MultiTrip> consumer) {
        findElement(rdm).click();
        findElement(multiModeAlert).click();
        waitForElementToDisappear(multiModeAlert); //Abstract method
        consumer.accept(this);
        System.out.println("I am inside makeStateReady method");


        //Execute Around pattern
        /*
        Common prerequisite code
        Execute actual function
        add tear down method if needed
        */

    }


}
