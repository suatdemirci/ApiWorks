package test;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion extends HerokuAppBaseUrl {
    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
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
                    }
                        Response Body - Expected Body
                   {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }
                    }
*/
    @Test
    public void post01() {

        //1-Url ve request body hazirla
        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject bookingDate=new JSONObject();

        bookingDate.put( "checkin","2021-06-01" );
        bookingDate.put( "checkout","2021-06-10");

        JSONObject reqBody=new JSONObject();

        reqBody.put("firstname","Ahmet"  );
        reqBody.put("lastname","Bulut"  );
        reqBody.put("totalprice",500  );
        reqBody.put("depositpaid",false );
        reqBody.put("bookingdates",bookingDate  );
        reqBody.put( "additionalneeds","wi-fi"  );

        //2-Expected Data hazirla


        JSONObject expectedData=new JSONObject();
        expectedData.put( "bookingId",24 );
        expectedData.put( "booking",reqBody );

        //3-Response kaydet

        Response response=given().contentType( ContentType.JSON ).when().body( reqBody.toString() ).post(url);

        //4-Assertion
        JsonPath respJP=response.jsonPath();

        assertEquals(expectedData.getJSONObject("booking").get("firstname"),respJP.get("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").get("lastname"),respJP.get("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").get("totalprice"),respJP.get("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").get("depositpaid"),respJP.get("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"),respJP.get("booking.additionalneeds"));
        assertEquals(expectedData.getJSONObject("booking").get("firstname"),respJP.get("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),respJP.get("booking.bookingdates.checkin"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),respJP.get("booking.bookingdates.checkout"));






    }

}
