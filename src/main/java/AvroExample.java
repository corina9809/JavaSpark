import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.*;
//import org.apache.spark.sql.DataFrame;
import scala.collection.Iterator;
import scala.collection.immutable.Seq;
import scala.collection.mutable.ArrayBuffer;


public class AvroExample {

    public static void main(String[] args) {
        // configure spark
        SparkSession spark = SparkSession
                .builder()
                .appName("Spark Example")
                .master("local[2]")
                .getOrCreate();



        SQLContext sqlContext = new SQLContext(spark);


        DataFrameReader dr =   sqlContext.read().format("com.databricks.spark.avro");


        dr.load("src/main/data/zipcodes.avro").show();

        dr.load("src/main/data/zipcodes.avro").getRows(1,3);

        dr.load("src/main/data/zipcodes.avro").getRows(1,5).iterator().next();


        for (Iterator iterator = dr.load("src/main/data/zipcodes.avro").getRows(1,5).iterator(); iterator.hasNext(); ) {

            //ArrayBuffer ab = (ArrayBuffer) iterator.next();

            System.out.println(iterator.next());
        }


        int test1 = 7878;


    }
}
