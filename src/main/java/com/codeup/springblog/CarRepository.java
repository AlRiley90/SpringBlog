package com.codeup.springblog;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//JpaRepository needs the type of the object and the ype of the id
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findByMake(String make);
    List<Car> findAllByMake(String make);
}
