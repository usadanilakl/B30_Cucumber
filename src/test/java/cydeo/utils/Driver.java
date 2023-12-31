package cydeo.utils;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;
import java.time.Duration;

public class Driver {
   //private static WebDriver driver;
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    private Driver(){    }
    public static WebDriver driver(){
        if(driverPool.get()==null){
            String browser = PropertyToGet.is("browser");
            if(System.getProperty("BROWSER")!=null){
                browser = System.getProperty("BROWSER");
            }
            switch(browser){
                case "chrome":
                   // WebDriverManager.chromedriver(); // this now is included with Selenium
                    driverPool.set(new ChromeDriver());
                    break;
                case "edge":
                 //   WebDriverManager.edgedriver();
                    driverPool.set(new EdgeDriver()) ;
                    break;
                case "firefox":
                   // WebDriverManager.firefoxdriver();
                    driverPool.set(new FirefoxDriver());
                    break;
                case "safari":
                   // WebDriverManager.safaridriver();
                    driverPool.set(new SafariDriver()) ;
                    break;
                case "headless":
                    ChromeOptions op = new ChromeOptions();
                    op.addArguments("--headless");
                    driverPool.set(new ChromeDriver(op));
                    break;
                case "remote":
                    try{
                        String grid = "44.202.100.36";
                        URL url = new URL("http://"+grid+":4444/wd/hub");
                        DesiredCapabilities dc = new DesiredCapabilities();
                        dc.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url,dc));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                default:
                    throw new RuntimeException("Browser " + PropertyToGet.is("browser") + " is not supported. Supported options are: chrome, edge, firefox, safari");
            }
            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driverPool.get();
    }
    public static void terminate(){
        if(driverPool.get()!=null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
