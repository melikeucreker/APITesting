package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_GetRequest_ResponseBilgilerininManuelTestEdilmesi {
    @Test
    public void test01(){
        String url="https://restful-booker.herokuapp.com/booking/10";

        Response response=given().when().get(url);
        System.out.println("Status Code: "+response.getStatusCode()+"\nContent Type: "+response.getContentType()+
                "\nServer Header Value: "+response.getHeader("Server")+"\nStatus line Value: "+response.getStatusLine()
                +"\nResponse Time: "+response.getTime()+"ms");



    }
}
