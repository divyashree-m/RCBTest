package tests;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utils.JsonUtils;

public class RcbTest {
	// Test validates that the team has four players
		@Test
		public void foreignPlayersTest() throws IOException, ParseException {
			// parse JSON File
			JSONObject jsonObject = JsonUtils
					.readJSONFile(System.getProperty("user.dir") + "/src/test/java/testData/testData.json");
			JSONArray player = (JSONArray) jsonObject.get("player");
			// list to add the foregin players
			List<String> listForeignPlayerNames = new ArrayList<String>();
			// iterate through player list
			for (int i = 0; i < player.size(); i++) {
				JSONObject players = (JSONObject) player.get(i);
				String country = (String) players.get("country");
				// check if country is not India
				if (!country.equals("India")) {
					// get foregin player Name
					String name = (String) players.get("name");
					// add the name in the list
					listForeignPlayerNames.add(name);
				}

			}
			Assert.assertEquals(listForeignPlayerNames.size(), 4);
		}

		// Test to validate it has atleast one wicket keeper
		@Test
		public void wicketKeeperTest() throws IOException, ParseException {
			// parse JSON File
			JSONObject jsonObject = JsonUtils.readJSONFile("src/test/java/testData/testData.json");
			JSONArray player = (JSONArray) jsonObject.get("player");
			// list to add wicket-keeper Name
			List<String> listWicketKeeperName = new ArrayList<String>();
			// iterate through player list
			for (int i = 0; i < player.size(); i++) {
				JSONObject players = (JSONObject) player.get(i);
				String role = (String) players.get("role");
				// check if role matches wicket-keeper
				if (role.equals("Wicket-keeper")) {
					// get wicket keeper Name
					String name = (String) players.get("name");
					// add the name in the list
					listWicketKeeperName.add(name);
					break;
				}
			}
			Assert.assertNotNull(listWicketKeeperName);
		}
}
