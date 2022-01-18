package Test;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {
	
	public static JsonPath jsonToVal(String res) {
		JsonPath js =new JsonPath(res);
			return js;
	}

}
