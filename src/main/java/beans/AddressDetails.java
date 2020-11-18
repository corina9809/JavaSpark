package beans;

import java.util.ArrayList;
import java.util.List;

public class AddressDetails {

    Address address = new Address();
    private String borough;
    private String cuisine;
    List<Grade> grades = new ArrayList<Grade>();
    private String name;
    private String restaurant_id;

    //Setters
    public List<Grade> getGrades() {
        return grades;
    }
    public Address getAddress() {
        return address;
    }
    public String getBorough() {
        return borough;
    }
    public String getCuisine() {
        return cuisine;
    }
    public String getName() {
        return name;
    }
    public String getRestaurant_id() {
        return restaurant_id;
    }

    //Getters
    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public void setBorough(String borough) {
        this.borough = borough;
    }
    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRestaurant_id(String restaurant_id) {
        this.restaurant_id = restaurant_id;
    }
}
