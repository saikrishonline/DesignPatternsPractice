package DpDemo.PageComponents;

import DpDemo.AbstractComponents.AbstractComponent;
import DpDemo.AbstractComponents.SearchFlightAvailability;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class RoundTrip extends AbstractComponent implements SearchFlightAvailability {

    private By rdo = By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']");
    private By from = By.cssSelector("input[id='ctl00_mainContent_ddl_originStation1_CTXT']");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By rdiaf = By.id("ctl00_mainContent_chk_IndArm");
    private String origin;

    private String destination;

    private By searchBtn = By.xpath("(//input[@value='Search'])[1]");



    public RoundTrip(WebDriver driver, By sectionElements) {
        super(driver, sectionElements);
    }


    @Override
    public void checkAvailability(HashMap<String,String> reservationDetails) {

        System.out.print("I am inside roundTrip");


        makeStateReady(s->selectOriginCity(reservationDetails.get("origin")));
        selectDestCity(reservationDetails.get("destination"));
        findElement(rdiaf).click();
        findElement(searchBtn).click();
    }

    public void selectOriginCity(String origin){

        findElement(from).click();
        By selectOriginCity = By.xpath("//a[@value='"+origin+"']");
       // findElement(By.xpath("//a[@value='"+origin+"']")).click();
        findElement(selectOriginCity).click();
        System.out.println("test");

    }

    public void selectDestCity(String destination)  {

        findElement(to).click();
        By selectDestCity = By.xpath("(//a[@value='"+destination+"'])[2]");
        findElement(selectDestCity).click();
        System.out.println("inside selectDestCity");

        //findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();


    }

    public void makeStateReady(Consumer<RoundTrip> consumer) {

        findElement(rdo).click();
        consumer.accept(this);

    }

}
