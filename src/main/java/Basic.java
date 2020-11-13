import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import java.util.Arrays;
import java.util.List;

public class Basic {

    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("SparkByExamples.com").setMaster("local[3]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> lines = sc.textFile("data.txt");
        JavaRDD<Integer> lineLengths = lines.map(s -> s.length());
        int totalLength = lineLengths.reduce((a, b) -> a + b);
        System.out.println("length: " + totalLength);

        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
        JavaRDD<Integer> distData = sc.parallelize(data);

    }
}
