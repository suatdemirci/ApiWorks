package test;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C08_JSONObjectVerileriCagirma {
    /*
    {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
                },
    "phoneNumbers": [
                    {
                        "type": "iPhone",
                        "number": "0123-4567-8888"
                    },
                    {
                        "type": "home",
                        "number": "0123-4567-8910"
                    }
                    ]
    }
     */

    @Test
    public void getJsonObje01(){

        JSONObject cepTel=new JSONObject();
        cepTel.put( "type","IPhone" );
        cepTel.put( "number","0123-4567-8888" );

        JSONObject homeTel=new JSONObject();
        homeTel.put( "type","home" );
        homeTel.put( "number","0123-4567-8910" );

        JSONArray phoneNumbers=new JSONArray();
        phoneNumbers.put( 0,cepTel );
        phoneNumbers.put( 1,homeTel );

        JSONObject address=new JSONObject();
        address.put( "streetAddress","naist street" );
        address.put( "city", "Nara" );
        address.put(  "postalCode", "630-0192" );

        JSONObject reqBody=new JSONObject();
        reqBody.put( "firstName", "John" );
        reqBody.put( "lastName", "doe" );
        reqBody.put( "age", 26 );
        reqBody.put( "address",address );
        reqBody.put( "phoneNumbers", phoneNumbers );

        System.out.println("Isim :"+ reqBody.get( "firstName" ) );
        System.out.println("Soyisim :"+ reqBody.get( "lastName" ) );
        System.out.println("Yas :"+ reqBody.get( "age" ) );
        System.out.println("Cadde adi :" + reqBody.getJSONObject( "address" ).get( "streetAddress" ) );
        System.out.println("Sehir adi :" + reqBody.getJSONObject( "address" ).get( "city" ) );
        System.out.println("Posta kodu :" + reqBody.getJSONObject( "address" ).get( "postalCode" ) );

        System.out.println("Telefon tipi :" + reqBody.getJSONArray( "phoneNumbers" )
                .getJSONObject( 0 )
                .get( "type" ) );
        System.out.println("Telefon Numarasi :" + reqBody.getJSONArray( "phoneNumbers" )
                .getJSONObject( 0 )
                .get( "number" ) );
        System.out.println("Telefon tipi :" + reqBody.getJSONArray( "phoneNumbers" )
                .getJSONObject( 1 )
                .get( "type" ) );
        System.out.println("Telefon Numarasi :" + reqBody.getJSONArray( "phoneNumbers" )
                .getJSONObject( 1 )
                .get( "number" ) );






    }

}
