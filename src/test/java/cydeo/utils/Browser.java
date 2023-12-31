package cydeo.utils;
import org.junit.Assert;

import static cydeo.utils.Driver.*;

public class Browser {
    public static void TitleContains(String title){
       Assert.assertTrue(driver().getTitle().contains(title));
    }
    public static void TitleEquals(String title){
        Assert.assertEquals(title,driver().getTitle());
    }

    public static void sleep(int sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void urlContains(String containsWhat){
        Assert.assertTrue(driver().getCurrentUrl().contains(containsWhat));
    }
}
