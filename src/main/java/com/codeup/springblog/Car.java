package com.codeup.springblog;

import javax.persistence.*;

@Entity
//The following annotation allows for the creation of a new table with the name provided
@Table(name="cars")
public class Car {

    @Id
//    The following line allows for the auto-incrementing of id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String make;

    @Column(nullable = false, length = 50)
    private String model;

    public void setId(long id) {
        this.id = id;
    }


    public long getId() {
        return id;
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
}
