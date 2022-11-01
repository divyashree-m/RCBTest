package Utils;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtils {

	public static JSONObject readJSONFile(String FilePath) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		Reader reader = new FileReader(FilePath);
		JSONObject jsonObject = (JSONObject) parser.parse(reader);
		return jsonObject;
	}
}
