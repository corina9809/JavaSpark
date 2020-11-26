import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;

import java.io.Serializable;

public class JSONtoDataSet {

    public static class Employee implements Serializable {
        public int RecordNumber;
        public int Zipcode;
        public String ZipCodeType;
        public String City ;
        public String State ;
        public String LocationType ;
        public double Lat ;
        public double Long ;
        public double Xaxis ;
        public double Yaxis ;
        public double Zaxis ;
        public String WorldRegion ;
        public String Country ;
        public String LocationText ;
        public String Location ;
        public boolean Decommisioned ;
    }

    public static void main(String[] args) {
        // configure spark
        SparkSession spark = SparkSession
                .builder()
                .appName("Read JSON File to DataSet")
                .master("local[2]")
                .getOrCreate();

        // Java Bean (data class) used to apply schema to JSON data
        Encoder<Employee> employeeEncoder = Encoders.bean(Employee.class);

        String jsonPath = "src/main/data/zipcodes.json";

        // read JSON file to Dataset
        Dataset<Employee> ds = spark.read().json(jsonPath).as(employeeEncoder);
        ds.show();
    }
}
