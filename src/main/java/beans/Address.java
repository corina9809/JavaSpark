package beans;

import java.util.ArrayList;
import java.util.List;

public class Address {
    private String building;
    List<Float> coord = new ArrayList<Float>();
    private String street;
    private String zipcode;


    // Getter Methods

    public String getBuilding() {
        return building;
    }
    public List<Float> getCoords() {
        return coord;
    }

    public String getStreet() {
        return street;
    }
    public String getZipcode() {
        return zipcode;
    }

    // Setter Methods
    public void setBuilding(String building) {
        this.building = building;
    }
    public void setCoord(List<Float> coord) {
        this.coord = coord;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}


