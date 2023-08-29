package test;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C16_BaseUrlHerokuapp extends HerokuAppBaseUrl {
    /*
    Class icinde 2 test metodu olusturun ve asagidaki testleri yapin
    1-https://restful-booker.herokuapp.com/booking endpointine bir GET
    request gonderdigimizde donen response'un status code'unun 200 oldugunu ve
    Response'ta 12 booking oldugunu test edin

    2-https://restful-booker.herokuapp.com/booking endpointine asagidaki body'ye sahip bir
    POST request gonderdigimizde donen response'un status code'unun 200 oldugunu ve
    "firstname" degerinin " Ahmet" oldugunu test edin

     {
        "firstname":"Ahmet",
        "lastname":"Bulut",
        "totalprice": 500,
        "depositpaid":false,
        "bookingdates":{
              "checkin":"2021-06-01",
              "checkout":"2021-06-10"
                 },
         "additionalneeds":"wi-fi"
       }
     */

    @Test
    public void get01(){
        //1-Url hazirla
        specHerokuApp.pathParam("pp1","booking"  );
        //2-Expected Data hazirla
        //3-Response Kaydet

        Response response=given().spec(specHerokuApp ).when().get("/{pp1}");

        //4-Assertion

        response.then()
                .assertThat()
                .statusCode( 200 )
                .body("id", Matchers.hasSize(12) );
    }

    @Test
    public void post01(){
        //1-Url hazirla
        specHerokuApp.pathParam("pp1","booking"  );

        JSONObject bookingdates=new JSONObject();
        bookingdates.put( "checkin","2021-06-01" );
        bookingdates.put( "checkout","2021-06-10" );

        JSONObject reqBody=new JSONObject();
        reqBody.put( "firstname","Ahmet" );
        reqBody.put( "lastname","Ahmet" );
        reqBody.put( "totalprice",500 );
        reqBody.put( "depositpaid",false );
        reqBody.put( "bookingdates",bookingdates );
        reqBody.put( "additionalneeds","wi-fi" );


        //2-Expected Data hazirla
        //3-Response Kaydet

        Response response=given().contentType( ContentType.JSON ).spec(specHerokuApp ).when().post("/{pp1}");

        //4-Assertion
        response.then()
                .assertThat()
                .statusCode( 200 )
                .body( "firstname",Matchers.equalTo( "Ahmet" ) );

    }
}
