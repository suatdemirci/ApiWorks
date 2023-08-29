package test;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C07_Get_BodyTekrarlardanKurtulma extends HerokuAppBaseUrl {
    /*
                https://restful-booker.herokuapp.com/booking/10 url’ine
                bir GET request gonderdigimizde donen Response’un,
                status code’unun 200,
                ve content type’inin application/json; charset=utf-8,
                ve response body’sindeki
                    "firstname“in,"Jim",
                    ve "lastname“in, "Wilson",
                    ve "totalprice“in, 609,
                    ve "depositpaid“in,false,
                    ve "additionalneeds“in,"Breakfast"
                oldugunu test edin
         */
    @Test
    public void get01(){

        String url="https://restful-booker.herokuapp.com/booking/10";

        Response response=given().when().get( url );

        response.prettyPrint();

        response
                .then()
                .assertThat()
                .statusCode( 200 )
                .contentType("application/json; charset=utf-8"  )
                .body( "firstname", equalTo( "Eric" ),
                        "lastname", equalTo( "Ericsson" ),
                         "totalprice", equalTo( 358 ),
                        "depositpaid", equalTo( true ),
                        "additionalneeds", equalTo( "Breakfast" ));

    }
}
