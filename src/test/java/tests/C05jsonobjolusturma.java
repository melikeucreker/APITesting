package tests;

import org.json.JSONObject;
import org.junit.Test;

public class C05jsonobjolusturma {
    @Test
    public void test01(){
        //once inner json objesini olusturalım,sonra outer json objesini olustutup geri yeri geldiginde inner objeyi
        //koyalım.
        //
       JSONObject dateJsonObject=new JSONObject();
   dateJsonObject.put("checkin","2018-01-01");
   dateJsonObject.put("checkout","2019-01-01");

   JSONObject requestBody=new JSONObject();
   requestBody.put("firstname","jim");
   requestBody.put("additionalneeds","breakfeast");
   requestBody.put("bookingdates",dateJsonObject);
   requestBody.put("totalprice",111);
   requestBody.put("depositpaid",true);
   requestBody.put("lastname","Brown");
        System.out.println(requestBody);
        /*
        {"firstname":"jim",
        "additionalneeds":"breakfeast",
        "bookingdates":{"checkin":"2018-01-01","checkout":"2019-01-01"},
        "totalprice":111,
        "depositpaid":true,
        "lastname":"Brown"}

         */



    }
}
