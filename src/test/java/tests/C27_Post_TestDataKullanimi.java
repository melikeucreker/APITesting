package tests;

import TestDatas.TestDataHerokuApp;
import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C27_Post_TestDataKullanimi extends BaseUrlHerokuapp {
    /*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
Response Body
{
"bookingid": 24,
"booking": {
"firstname": "Ahmet",
"lastname": "Bulut",
"totalprice": 500,
"depositpaid": false,
"bookingdates": {
"checkin": "2021-06-01",
"checkout": "2021-06-10"
},
"additionalneeds": "wi-fi"
} }
Request body
{
"firstname" : "Ahmet",
"lastname" : “Bulut",
"totalprice" : 500,
"depositpaid" : false,
"bookingdates" : {
"checkin" : "2021-06-01",
"checkout" : "2021-06-10"
},
"additionalneeds" : "wi-fi"
     */
    @Test
    public void test01(){
        specHerokuapp.pathParams("pp1","booking");
        JSONObject requestBody= TestDataHerokuApp.jsonRequestBodyOlustur("Ahmet","Bulut",500,false);
        JSONObject expectedData=TestDataHerokuApp.jsonRequestBodyOlustur("Ahmet","Bulut",500,false);
        //System.out.println(expectedData);
        Response response=given().spec(specHerokuapp).contentType(ContentType.JSON).when().body(requestBody.toString()).post("{pp1}");
      response.prettyPrint();
        JsonPath ressponseJsonPath=response.jsonPath();
        // System.out.println(expectedData);
        assertEquals(expectedData.getJSONObject("booking").getString("firstname")

                ,ressponseJsonPath.get("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").getString("lastname")
                ,ressponseJsonPath.get("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").getString("totalprice")
                ,ressponseJsonPath.getString("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").getString("depositpaid"),
                ressponseJsonPath.getString("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").getString("additionalneeds"),
                ressponseJsonPath.getString("booking.additionalneeds"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                ressponseJsonPath.get("booking.bookingdates.checkin"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                ressponseJsonPath.get("booking.bookingdates.checkout"));




    }
}
