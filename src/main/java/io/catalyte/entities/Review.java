package io.catalyte.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity


public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private String description;
    private int rating;
    private String date;
    private String userName;
    private Long vehicleIds;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Vehicle vehicle;

    public Review() {
    }

    public Review(Long id, String title, String description, int rating, String date,
                  String userName, Long vehicleId,  @NotNull(message = "Vehicle is Required") Vehicle vehicle) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.date = date;
        this.userName = userName;
        this.vehicleIds = vehicleIds;
        this.vehicle = vehicle;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public int getRating() {
        return rating;
    }


    public void setRating(int rating) {
        this.rating = rating;
    }


    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonIgnore
    public Long getVehicleIds() {
        return vehicleIds;
    }

    @JsonIgnore
    public void setVehicleId(Long vehicleIds) {
        this.vehicleIds = vehicleIds;
    }
    public Vehicle getVehicle(){return vehicle;}

    public void setVehicle(Vehicle vehicle) {this.vehicle = vehicle;}

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", date='" + date + '\'' +
                ", userName='" + userName + '\'' +
                ", vehicleId=" + vehicleIds +
                '}';
    }

}
