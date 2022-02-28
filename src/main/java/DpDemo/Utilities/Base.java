package DpDemo.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public Properties prop;
    public String projectPath;
    public String URL;
    public String browserType;
    public String driverPath;
    WebDriver driver;



    public WebDriver browserInit() throws IOException {

        projectPath = System.getProperty("user.dir");
        prop= new Properties();
        FileInputStream fis = new FileInputStream(projectPath+"//src//main//java//DpDemo//resources//data.properties");
        prop.load(fis);
        browserType = prop.getProperty("browser");


        if(browserType.equalsIgnoreCase("chrome")) {
            driverPath = prop.getProperty("chromeDriverPath");
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
        }

        else if(browserType.equalsIgnoreCase("firefox")) {
            driverPath = prop.getProperty("firefoxDriverPath");
            System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
        }

        return driver;
    }




}
