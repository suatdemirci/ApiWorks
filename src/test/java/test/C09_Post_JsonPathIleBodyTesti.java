package test;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class C09_Post_JsonPathIleBodyTesti extends HerokuAppBaseUrl {

    /*
            https://restful-booker.herokuapp.com/booking
            url’ine asagidaki body'ye sahip
            bir POST request gonderdigimizde
                       {
                            "firstname" : "Ali",
                            "lastname" : "Bak",
                            "totalprice" : 500,
                            "depositpaid" : false,
                            "bookingdates" : {
                                            "checkin" : "2021-06-01",
                                            "checkout" : "2021-06-10"
                                             },
                            "additionalneeds" : "wi-fi"
                        }
            donen Response’un,
            status code’unun 200,
            ve content type’inin application/json; charset=utf-8,
            ve response body’sindeki
                "firstname“in,"Ali",
                ve "lastname“in, "Bak",
                ve "totalprice“in,500,
                ve "depositpaid“in,false,
                ve "checkin" tarihinin 2021-06-01
                ve "checkout" tarihinin 2021-06-10
                ve "additionalneeds“in,"wi-fi"
            oldugunu test edin
     */

    @Test
    public void path01(){

        String url="https://restful-booker.herokuapp.com/booking";

        JSONObject bookingDate=new JSONObject();
        bookingDate.put( "checkin","2021-06-01" );
        bookingDate.put( "checkout", "2021-06-10" );

        JSONObject outerLayer=new JSONObject();
        outerLayer.put( "firstname" , "Ali" );
        outerLayer.put( "lastname" , "Bak" );
        outerLayer.put("totalprice" , 500 );
        outerLayer.put( "depositpaid" , false );
        outerLayer.put( "bookingdates" , bookingDate );
        outerLayer.put( "additionalneeds" , "wi-fi" );

        Response response=given().contentType( ContentType.JSON ).when( ).body(outerLayer.toString()).post(url);

        response.then()
                .assertThat()
                .statusCode( 200 )
                .contentType( "application/json; charset=utf-8" )
                .body("booking.firstname",equalTo("Ali"  ),
                  "booking.lastname",equalTo( "Bak" ),
                          "booking.totalprice",equalTo( 500 ),
                          "booking.depositpaid",equalTo( false ),
                          "booking.bookingdates.checkin",equalTo( "2021-06-01"  ),
                          "booking.bookingdates.checkout",equalTo("2021-06-10"  ),
                          "booking.additionalneeds",equalTo( "wi-fi" ));


    }
}
