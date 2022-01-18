package Test;

public class Payloads {

	public static String authApibody() {
		return "{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}";
	}
	public static String postApiBody() {
		return "{\r\n"
				+ "    \"firstname\" : \"Akash\",\r\n"
				+ "    \"lastname\" : \"Ram\",\r\n"
				+ "    \"totalprice\" : 5000,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2021-07-29\",\r\n"
				+ "        \"checkout\" : \"2021-07-30\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"dinner\"\r\n"
				+ "}";
	}
	public static String putApiBody() {
		return "{\r\n"
				+ "    \"firstname\" : \"sheetal\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";
	}
}
