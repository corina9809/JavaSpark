import java.io.File;
import java.util.ArrayList;
import java.util.List;

import beans.AddressDetails;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ReadJsonFile {

    public static void main(String args[]){

        ObjectMapper mapper = new ObjectMapper();

        String json = "{\n" +
                "  \"address\": {\n" +
                "    \"building\": \"1007\",\n" +
                "    \"coord\": [\n" +
                "      -73.856077,\n" +
                "      40.848447\n" +
                "    ],\n" +
                "    \"street\": \"Morris Park Ave\",\n" +
                "    \"zipcode\": \"10462\"\n" +
                "  },\n" +
                "  \"borough\": \"Bronx\",\n" +
                "  \"cuisine\": \"Bakery\",\n" +
                "  \"grades\": [\n" +
                "    {\n" +
                "      \"date\": {\n" +
                "        \"$date\": 1393804800000\n" +
                "      },\n" +
                "      \"grade\": \"A\",\n" +
                "      \"score\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": {\n" +
                "        \"$date\": 1378857600000\n" +
                "      },\n" +
                "      \"grade\": \"A\",\n" +
                "      \"score\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": {\n" +
                "        \"$date\": 1358985600000\n" +
                "      },\n" +
                "      \"grade\": \"A\",\n" +
                "      \"score\": 10\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": {\n" +
                "        \"$date\": 1322006400000\n" +
                "      },\n" +
                "      \"grade\": \"A\",\n" +
                "      \"score\": 9\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": {\n" +
                "        \"$date\": 1299715200000\n" +
                "      },\n" +
                "      \"grade\": \"B\",\n" +
                "      \"score\": 14\n" +
                "    }\n" +
                "  ],\n" +
                "  \"name\": \"Morris Park Bake Shop\",\n" +
                "  \"restaurant_id\": \"30075445\"\n" +
                "}";

        AddressDetails value = null;
        try {
            value = mapper.readValue(json, AddressDetails.class);
            // For converting a json file to object use below code
            //value = mapper.readValue(new File("result.json"), AddressDetails.class);
            // Use getter methods to Access any fields on the object
            System.out.println("Restaurant ID " +value.getRestaurant_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


