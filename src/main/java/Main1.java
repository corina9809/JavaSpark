

import org.apache.spark.SparkConf;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;


import java.util.Arrays;

public class Main1 {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();


        SparkConf conf = new SparkConf().setAppName("SparkByExamples.com").setMaster("local[3]");
        JavaSparkContext sc = new JavaSparkContext(conf);

		/*-------------------------------------------------------------------
		 * Loading and Storing Data
		 -------------------------------------------------------------------*/

        // Create a RDD from a file
        JavaRDD<String> lines = sc.textFile("zipcodes-noheader.csv");
        System.out.println("Total Records in Iris : " + lines.count());
        for (String s : lines.take(11)) {
            System.out.println(s);
        }
        System.out.println("-----------------------------------------------------------------------------------");

        JavaRDD<String> irisTsvData = lines
                .map(str -> str.replace(",", "\t"));
        System.out.println("Spark Operations : MAP");
        for (String s : irisTsvData.take(11)) {
            System.out.println(s);
        }
        System.out.println("-----------------------------------------------------------------------------------");
        // remove header example
        String header = lines.first();
        JavaRDD<String> irisData = lines.filter(s -> !s.equals(header));
        System.out.println("Spark Operations : remove header");
        for (String s : irisData.take(11)) {
            System.out.println(s);
        }
        System.out.println("-----------------------------------------------------------------------------------");


        // Filter example
        JavaRDD<String> toyotaData = irisData.filter(str -> str.contains("HOLDER"));
        System.out.println("Versicolor word counts : " + toyotaData.count());
        System.out.println("Spark Operations : FILTER");
        for (String s : toyotaData.take(11)) {
            System.out.println(s);
        }
        System.out.println("-----------------------------------------------------------------------------------");

        // Distinct example
//        System.out.println("Spark distinct example : " + xxxx.distinct().collect());

        // FlatMap
        JavaRDD<String> words = toyotaData.flatMap((FlatMapFunction<String, String>) s -> Arrays.asList(s.split(",")).iterator());
        System.out.println("Toyota word counts : " + words.count());
        for (String s : words.take(11)) {
            System.out.println(s);
        }
        System.out.println("-----------------------------------------------------------------------------------");




        // Functions for Map
        String shortest = irisData.reduce((Function2<String, String, String>) (v1, v2) -> (v1.length() < v2.length() ? v1 : v2));
        System.out.println("The shortest string is : " + shortest);


    }
}