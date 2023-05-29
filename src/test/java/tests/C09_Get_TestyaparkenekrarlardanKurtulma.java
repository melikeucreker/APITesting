package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*; // bu su dmk matchers classındaki tüm mthodları import et

public class C09_Get_TestyaparkenekrarlardanKurtulma {
    @Test
    public void test01(){
        /*
        https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde
donen Response’un,
status code’unun 200,
ve content type’inin application-json,
ve response body’sindeki
"firstname“in, "Susan",
ve "lastname“in, "Jackson",
ve "totalprice“in, 612,
ve "depositpaid“in, false,
ve "additionalneeds“in, "Breakfast"
oldugunu test edin
         */
        //1-end point ve request body hazırlama
        String url="   https://restful-booker.herokuapp.com/booking/10 ";
        //2-expected data olustur
        //3-request gönderip,donen response ı kaydetmek
        Response response=given().when().get(url);
        //4-assertion
        response.prettyPrint();
       /* response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body("Firstname", Matchers.equalTo("Sally")).
                body("lastname",Matchers.equalTo("Wilson"))
                .body("totalprice",Matchers.lessThan(1000))
                .body("depositpaid",Matchers.equalTo( true))
                .body("additionalneeds",Matchers.notNullValue());
        */
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body("Firstname",equalTo(null),"lastname",equalTo("Jones"),"totalprice"
                        ,lessThan(1000),"depositpaid",equalTo(false));


    }
}
