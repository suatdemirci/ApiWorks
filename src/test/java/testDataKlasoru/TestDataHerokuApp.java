package testDataKlasoru;

import org.json.JSONObject;

import java.util.HashMap;

public class TestDataHerokuApp {

    public int basariliStatusCode = 200;

    public static JSONObject expectedbookingdatesOlustur() {
        JSONObject bookingdates=new JSONObject();
        bookingdates.put( "checkin","2021-06-01" );
        bookingdates.put( "checkout","2021-06-10" );

        return bookingdates;

    }
    public static JSONObject expectedBookingOlustur() {

        JSONObject expBooking=new JSONObject();
        expBooking.put( "firstname","Ali" );
        expBooking.put( "lastname","Bak" );
        expBooking.put( "totalprice",500 );
        expBooking.put("depositpaid",false);
        expBooking.put( "bookingdates",expectedbookingdatesOlustur() );
        expBooking.put( "additionalneeds","wi-fi" );

        return expBooking;

    }
    public static JSONObject expectedDataBodyOlustur() {
        JSONObject expData=new JSONObject();
        expData.put( "bookingId",24 );
        expData.put( "booking",expectedBookingOlustur() );

        return expData;
    }




    /*
        {
	      "firstname" : "Ali",
	      "lastname" : “Bak",
	      "totalprice" : 500,
	      "depositpaid" : false,
	      "bookingdates" : {
                      "checkin" : "2021-06-01",
                      "checkout" : "2021-06-10"
                        },
	      "additionalneeds" : "wi-fi"
	       }
         */

    public static JSONObject bookingdatesOlusturJSON(){

        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin" , "2021-06-01");
        bookingdates.put("checkout" , "2021-06-10");

        return bookingdates;
    }

    public static JSONObject bookingOlusturJSON(){

        JSONObject booking = new JSONObject();

        booking.put("firstname" , "Ali");
        booking.put("lastname" , "Bak");
        booking.put("totalprice" , 500);
        booking.put("depositpaid" ,false);
        booking.put("additionalneeds" , "wi-fi");
        booking.put("bookingdates" , bookingdatesOlusturJSON());

        return booking;
    }

    /*
    {
    "bookingid":24,
    "booking":{
            "firstname":"Ali",
            "lastname":"Bak",
            "totalprice":500,
            "depositpaid":false,
            "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                            },
            "additionalneeds":"wi-fi"
               }
    }
     */

    public JSONObject expectedBodyOlusturJSON(){

        JSONObject expData = new JSONObject();

        expData.put("bookingid" , 24);
        expData.put("booking" , bookingOlusturJSON());

        return expData;
    }
    public HashMap bookingdatesMap(){

        HashMap<String,Object> bookingdates = new HashMap<>();

        bookingdates.put("checkin" , "2021-06-01");
        bookingdates.put("checkout" , "2021-06-10");

        return bookingdates;
    }
    /*
         Request body
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
         */
    public HashMap reqBodyMap(){

        HashMap<String,Object> booking = new HashMap<>();

        booking.put("firstname" , "Ali");
        booking.put("lastname" , "Bak");
        booking.put("totalprice" , 500.0);
        booking.put("depositpaid" , false);
        booking.put("additionalneeds" , "wi-fi");
        booking.put("bookingdates" , bookingdatesMap());

        return booking;
    }
    /*
      Response Body
       {
       "bookingid":24,
       "booking":{
           "firstname":"Ali",
           "lastname":"Bak",
           "totalprice":500,
           "depositpaid":false,
           "bookingdates":{
               "checkin":"2021-06-01",
               "checkout":"2021-06-10"
           },
           "additionalneeds":"wi-fi"
           }
       }
     */
    public HashMap expBodyMap(){

        HashMap<String,Object> expBody = new HashMap<>();

        expBody.put("bookingid" , 24);
        expBody.put("booking" , reqBodyMap());

        return expBody;
    }
}
