package DeserializationTest;

import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.given;

import Test.Payloads;
import Test.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetResponse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";

		// Auth API
		String res = given().log().all().body(Payloads.authApibody()).header("Content-Type", "application/json").when()
				.post("/auth").then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(res);

		JsonPath js1 = ReusableMethods.jsonToVal(res);

		String token = js1.getString("token");

		System.out.println("post API............");
		String res1 = given().body(Payloads.postApiBody()).header("Content-Type", "application/json").when()
				.post("/booking").then().log().all().extract().response().asString();
		System.out.println(res1);

		JsonPath js = ReusableMethods.jsonToVal(res1);

		String bookingid = js.getString("bookingid");
		String firtNameis = js.getString("booking.firstname");

		// Get API....
		PoJoClassGetBody pj = given().when().get("/booking/" + bookingid).as(PoJoClassGetBody.class);

		String firstName = pj.getFirstname();
	String lastName=	pj.getLastname();
		System.out.println("the first name is"+firstName);
		System.out.println("The last name is"+lastName);

	}

}
