package Serialization;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class CreateBooking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		
		Pojoclass p=new Pojoclass();
		p.setFirstname("Amulya");
		p.setLastname("kumar");
		p.setTotalprice("2000");
		p.setDepositpaid(true);
	

		Bookingdates b=new Bookingdates();
		b.setCheckin("2021-07-29");
		b.setCheckout("2021-07-30");
		p.setBookingdates(b);
		p.setAdditionalneeds("party");
		given().body(p).header("Content-Type","application/json").
		
		
		
		when().post("/booking").
		then().log().all().assertThat().statusCode(200);

	}

}
