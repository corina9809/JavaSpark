import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.*;
//import org.apache.spark.sql.DataFrame;
import scala.collection.immutable.Seq;


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

        dr.load("src/main/data/zipcodes.avro").getRows(1,3).iterator().next();


        int test1 = 7878;

// Saves the subset of the Avro records read in
       /* df.filter($"age > 5").write()
                .format("com.databricks.spark.avro")
                .save("/tmp/output"); */


    }
}
