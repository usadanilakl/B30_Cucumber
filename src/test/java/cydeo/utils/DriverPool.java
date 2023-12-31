package cydeo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;

public class DriverPool {
    private DriverPool(){}

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    public static WebDriver getDriver(){
        if(driverPool.get()==null){
            if(System.getProperty("BROWSER")==null){
                switch (PropertyToGet.is("browser")){
                    case "chrome":
                        driverPool.set(new ChromeDriver());
                        break;

                    case "edge":
                        driverPool.set(new EdgeDriver());
                        break;
                    case "headless":
                        ChromeOptions op = new ChromeOptions();
                        op.addArguments("--headless");
                        driverPool.set(new ChromeDriver(op));
                        break;
                    case "remote":
                        try{
                            String grid = "54.237.209.202";
                            URL url = new URL("http://"+grid+":4444/wd/hub");
                            DesiredCapabilities dc = new DesiredCapabilities();
                            dc.setBrowserName("chrome");
                            driverPool.set(new RemoteWebDriver(url,dc));
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        break;
                }
            }


        }
        driverPool.get().manage().window().maximize();
        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driverPool.get();
    }

    public static void terminate(){
        if(driverPool.get() !=null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
