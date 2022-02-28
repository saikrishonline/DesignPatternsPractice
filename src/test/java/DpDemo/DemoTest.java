package DpDemo;


import DpDemo.MainPageObjects.TravelHomePage;
import DpDemo.Utilities.Base;

import DpDemo.Utilities.DataReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DemoTest extends Base {

    public WebDriver driver;
    public String URL;
    TravelHomePage thp;

    @BeforeTest
    public void initialize() throws IOException {
        driver = browserInit();
        thp = new TravelHomePage(driver);
    }

    @Test (dataProvider = "getData")
    public void testFlight(HashMap<String,String> reservationDetails) throws InterruptedException, IOException {


        URL = prop.getProperty("getURL");
        thp.getTo(URL);
        System.out.println(thp.getFooterNavigationBar().selectFlightsInFooterSection());
        System.out.println(thp.getNavigationBar().selectFlightLinkFromHeader());
        System.out.println(thp.getFooterNavigationBar().getLinkCount());
        System.out.println(thp.getNavigationBar().getHeaderLinkCount());


        thp.setBookingStrategy("multitrip");
        //thp.setBookingStrategy(new RoundTrip());
        thp.checkAvailability(reservationDetails);


    }



    @DataProvider
    public Object[][] getData() throws IOException {

        String jsonPath = ("//Users//saimaster//Documents//workspace4intellij//IdeaProjects//DesignPatternsPractice//src//test//java//DpDemo//DataLoads//reservationDetails.json");
        DataReader dr = new DataReader();
        List<HashMap<String,String>> l = dr.getJsonData(jsonPath);


        return new Object[][] {
                {l.get(0)},{l.get(1)}
        };


    }


        @AfterTest
        public void tearDown(){

        driver.quit();
        }




}
