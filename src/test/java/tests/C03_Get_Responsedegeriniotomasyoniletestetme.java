package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C03_Get_Responsedegeriniotomasyoniletestetme {
    @Test

    public void test01() {
        /*Status Code: 200
        Content Type: application/json; charset=utf-8
        Server Header Value: Cowboy
        Status line Value: HTTP/1.1 200 OK
        oldugunu test edin.


  */
        String url="https://restful-booker.herokuapp.com/booking/10";
        Response response=given().when().get(url);
        response
                .then()
                .assertThat().statusCode(200).contentType("application/json; charset=utf-8")
                .header("Server","Cowboy")
                .statusLine("HTTP/1.1 200 OK");


    }



}
