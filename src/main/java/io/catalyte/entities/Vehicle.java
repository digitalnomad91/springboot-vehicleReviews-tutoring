package io.catalyte.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    private String type;
    private String make;
    private String model;
    private Long year;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Review> reviews = new HashSet<>();
    public Vehicle() {
    }

    public Vehicle(Long id, String type, String make, String model, Long year) {
        this.id = id;
        this.type = type;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public String getMake() {
        return make;
    }


    public void setMake(String make) {
        this.make = make;
    }


    public String getModel() {
        return model;
    }


    public void setModel(String model) {
        this.model = model;
    }


    public Long getYear() {
        return year;
    }


    public void setYear(Long year) {
        this.year = year;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> players) {
        this.reviews = reviews;
    }
    @Override
    public String toString() {
        return "Vehicle{" +
            "id=" + id +
            ", type='" + type + '\'' +
            ", make='" + make + '\'' +
            ", model='" + model + '\'' +
            ", year=" + year +
            '}';
    }
}


