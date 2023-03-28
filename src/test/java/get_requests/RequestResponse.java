package get_requests;

import io.restassured.response.Response;


import static io.restassured.RestAssured.given;


public class RequestResponse {
    /*
    1)Postman manuel API testi için kullanilir.
    2)API otomasyonu için Rest-Assured Library kullanacagiz.
    3)Otomasyon kodlarının yazımı için şu adımları izliyoruz:
        a) Gereksinimleri anlama
        b) Test case i yazma:
         -Test case i yazmak için "Gherkin Language" kullaniyoruz.
         x) Given: Ön koşullar  --> Endpoint, body
         y) When : İşlemlee --> Get,Put,Delete... hareketli kısım
         z) Then : Dönütler --> Assert
         t) And --> Çoklu işlemlerin art arda yazilacağı yerlerde kullanilir.
        c) Test kodunu yazarken şu adımları izleriz:
           i)    Set the URL
           ii)   Set the expected data   (nasıl bir data bekliyorum post yaparken gonderdigim ve donuste bekledigim data
           iii)  Send the request and get the response   (reuest i gonder response al )
           iv)   Do assertion

           ii) json datasını java ıbjesıne cevirmeye calısacagız
     */

    public static void main(String[] args) {
        String url="https://restful-booker.herokuapp.com/booking/55"; //andpoint

        //get request nasil yapilir   get i restassured den ımport ettik
        Response response =given().when().get(url);
        //bu get methodu bze  response dşye bir data donduruyor o yuzden response konteynirina koydum

        response.prettyPrint(); //prettyPrint() methodu response datayı yazdırır.   json formatinda yazdırır

        //asagıdakıler meta datalar header ksımından aldıgımı data ile ilgili olan datalarımız
        /*
        data definition language meta datalar  data hakkında data kısmı
        data manipulation language  json data kısmı
         */
        //status code nasıl yazdırılır
        System.out.println("status code: "+response.statusCode());

        //Content Type nasil yazdirilir?
        System.out.println("Content Type: " + response.contentType());

        //status line nasıl yazdirilir    -basarı kodu anlamına geliyor-
        System.out.println("status line: "+response.statusLine());

        //header nasıl yazdirilir
        System.out.println(response.header("Connection"));
        System.out.println(response.header("Server"));

        //Headers nasıl yazdırılır:
        //System.out.println(response.headers());
        System.out.println(response.getHeaders());

        //Time nasıl yazdırılır
        System.out.println("Time: "+response.getTime());

        //test frenwork olusturmak icin yani assertion yapabilmak icin pomxml dependisleri ekledim
        //assertion yapmabimek icin test anoteşinlar  kullanacagız run yapabilecegiz
    }
}