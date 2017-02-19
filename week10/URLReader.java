import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class URLReader {

	public static void main(String[] args) throws Exception {

		URL oracle = new URL(
				"http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1");
		BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

		String inputLine;

		StringBuilder sb = new StringBuilder();

		while ((inputLine = in.readLine()) != null) {

			sb.append(inputLine);
			System.out.println(inputLine);

		}

		in.close();

		JSONObject jsonObjectBig = new JSONObject(sb.toString());
		JSONObject object = jsonObjectBig.getJSONObject("main");

		System.out.println();

		System.out.println(object.get("temp"));

	}

}
