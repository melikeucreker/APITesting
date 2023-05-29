package TestDatas;

import org.json.JSONObject;

public class TestDataHerokuApp {
    /*
    firstname": "Ahmet",
"lastname": "Bulut",
"totalprice": 500,
"depositpaid": false,
"bookingdates": {
"checkin": "2021-06-01",
"checkout": "2021-06-10"
     */
    public static JSONObject jsonRequestBodyOlustur(String firstname,String lastname,int totalprice,boolean depositpaid){
        JSONObject requestBody=new JSONObject();
        JSONObject bookindDatesBody=new JSONObject();
        bookindDatesBody.put("checkin","2021-06-01");
        bookindDatesBody.put("checkout","2021-06-10");
        requestBody.put("firstname",firstname);
        requestBody.put("lastname",lastname);
        requestBody.put("depositpaid",depositpaid);
        requestBody.put("bookiddates",bookindDatesBody);
        requestBody.put("additionalneeds","wi_fi");
        return requestBody;


    }
    public static JSONObject JsonResponseBodyOlustur(){
        JSONObject responseBody=new JSONObject();
        JSONObject bookingBody=jsonRequestBodyOlustur("Ahmet","Bulut",500,false);
        responseBody.put("bookingid",24);
        responseBody.put("booking",bookingBody);
        return responseBody;

    }

}
