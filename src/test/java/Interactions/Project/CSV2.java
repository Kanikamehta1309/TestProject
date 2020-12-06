package Interactions.Project;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV2 {

	public static List<String> value = new ArrayList<String>();

	public static void main(String[] args) throws IOException {

	}

	public static List<String> getAPIValue() throws IOException {
		RestAssured.baseURI = "https://samples.openweathermap.org";
		String response = given().queryParam("q", "London,UK").queryParam("appid", "b1b15e88fa797225412429c1c50c122a1")
				.when().get("data/2.5/history/city").then().extract().asString();

		// System.out.println(response);

		try {
			List<String> list = CSV1.getColumnName();
			JsonPath js = new JsonPath(response);
			List<String> li = js.getList("list");

			// System.out.println(li.size());
			// System.out.println(js.get("list[0].main.temp").toString());
			for (int j = 0; j < li.size(); j++) {
				for (int i = 0; i < list.size(); i++) {
					// System.out.println(list.get(i));
					value.add(js.get("list[" + j + "].main." + list.get(i)).toString());

				}

			}
			return value;
		} catch (NullPointerException e) {
			value.add("0");
			return value;
		}
	}
}
