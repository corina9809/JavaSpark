import org.apache.spark.SparkConf;

import org.apache.spark.api.java.JavaRDD;

import org.apache.spark.api.java.JavaSparkContext;

import java.util.ArrayList;

import java.util.List;

public class MainRunner {

    public static void main(String[] args) {

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(23.44);
        doubleList.add(26.43);
        doubleList.add(75.35);
        doubleList.add(245.767);
        doubleList.add(398.445);
        doubleList.add(94.72);

        SparkConf sparkConf = new SparkConf().setAppName("spark_first").setMaster("local[*]");

        JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);

        JavaRDD<Double> javaRDD = sparkContext.parallelize(doubleList);
        //map
        JavaRDD<Integer> mappedRDD = javaRDD.map(val -> (int)Math.round(val));
        mappedRDD.collect().forEach(System.out::println);
        //reduce
        int reducedResult = mappedRDD.reduce(Integer::sum);
        System.out.println(reducedResult);
        sparkContext.close();
    }
}


