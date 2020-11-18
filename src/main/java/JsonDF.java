import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;

import java.util.Arrays;
import java.util.List;

public class JsonDF {

    SparkSession sparkSession;

    public static void main(String[] args) {


        SparkConf conf = new SparkConf();
        conf.setMaster("local[2]");


        SparkSession spark = SparkSession
                .builder()
                .appName("Dataset-json")
                .master("local[4]")
                .getOrCreate();
        System.out.println("Session created");
        String str = "{\n" +
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
        List<String> data = Arrays.asList(str);

        Dataset<String> ds = spark.createDataset(data, Encoders.STRING());
        spark.read().json(ds).show(false);


    }
}


