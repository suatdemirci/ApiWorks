package test;

import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObjesiOlusturma {

     /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1
    }
    */

    @Test
    public void jsonObje01(){

        JSONObject ilkJsonObject=new JSONObject( );

        ilkJsonObject.put( "title","Ahmet" );
        ilkJsonObject.put( "body","Merhaba" );
        ilkJsonObject.put( "userId",1 );

        System.out.println("Ilk Json Objemiz: " + ilkJsonObject );


        }

        /*
                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                    },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */

    @Test
    public void nestedJsonObjeYazma(){
        JSONObject bookingDates=new JSONObject();

        bookingDates.put( "checkin","2018-01-01" );
        bookingDates.put( "checkout","2019-01-01" );

        JSONObject outerJson=new JSONObject();

        outerJson.put("firstname","Jim");
        outerJson.put( "additionalneeds","Breakfast" );
        outerJson.put( "bookingdates",bookingDates );
        outerJson.put( "totalprice",111 );
        outerJson.put( "depositpaid",true);
        outerJson.put( "lastname","Brown" );

        System.out.println(outerJson );


    }

}
