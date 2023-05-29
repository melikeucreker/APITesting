package tests;

import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class C1_GetRequest_ResponseBodyYazdirma {
    @Test
    public void get01() {

        //https://restful-booker.herokuapp.com/booking/10 url'ine gidin ve bir GET request gonderdigimizde donen
        //response'ı yazdirin.
        //1-request body ve endpoint hazırlama
        String url = "https://restful-booker.herokuapp.com/booking/10";


        //2-expected data hazırlama

        //3-request gönderip dönen response'ı kaydetme
        Response response = given().when().get(url);
        response.prettyPrint();


        //4-Assertion islemleri

    }
}

