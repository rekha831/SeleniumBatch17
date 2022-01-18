package Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RestTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";

		// Auth API
		String res = given().log().all().body(Payloads.authApibody()).header("Content-Type", "application/json").when()
				.post("/auth").then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(res);

		JsonPath js1 = ReusableMethods.jsonToVal(res);

		String token = js1.getString("token");

		System.out.println("post API............");
		
		byte[] bytefromJson=Files.readAllBytes(Paths.get("myJosn.json"));
		String var=new String(bytefromJson);
		String res1 = given().body(var).header("Content-Type", "application/json").when()
				.post("/booking").then().log().all().extract().response().asString();
		System.out.println(res1);

		JsonPath js = ReusableMethods.jsonToVal(res1);

		String bookingid = js.getString("bookingid");
	String firtNameis=	js.getString("booking.firstname");
	System.out.println("the first name is:"+firtNameis);

		System.out.println("GET API...............");

		given().when().get("/booking/" + bookingid).then().log().all().extract().response().asString();

//Put
		System.out.println("put method........................");
		System.out.println("testing merge  and PR........");
		String tokentrue = "token=" + token;
		System.out.println(tokentrue);
		given().body(Payloads.putApiBody()).header("Content-Type", "application/json")
				.header("Accept", "application/json").header("Cookie", tokentrue).when().put("/booking/" + bookingid)
				.then().log().all().assertThat().statusCode(200);
		

	}

}
