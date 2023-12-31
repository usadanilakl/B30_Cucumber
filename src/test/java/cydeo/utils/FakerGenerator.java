package cydeo.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FakerGenerator {
    public static void main(String[] args) {
        SimpleDateFormat dt = new SimpleDateFormat("MM/yy");
        Faker f = new Faker();
        System.out.println(
                "|product|quantity|name|street|city|state|zipCode|paymentMethod|card|exparation|"
        );

        for(int i = 0; i<10; i++){
            Date date = f.date().future(3000, TimeUnit.DAYS);
            System.out.println(
                    "||"+f.numerify("##")+
                            "|"+f.name().fullName()+
                            "|"+f.address().streetAddress()+
                            "|"+f.address().city()+
                            "|"+f.address().state()+
                            "|"+f.address().zipCode()+
                            "||"+f.numerify("################") +
                            "|"+dt.format(date)+"|"

            );
        }
    }
}
