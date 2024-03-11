package ru.ivanov.arh4lab.controllers;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;
import ru.ivanov.arh4lab.models.Car;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarController {
    private List<Car> cars = new ArrayList<>();
    {
        cars.add(Car.builder().color("red")
                .price(1000000.0)
                .name("mazda")
                .speed(250.0)
                .build());
        cars.add(Car.builder().color("white")
                .price(10000000.0)
                .name("bmw")
                .speed(350.0)
                .build());
    }
    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return cars;
    }
    @GetMapping("/cars/{id}")
    public Car getCar(@PathVariable int id) {
        return cars.get(id);
    }

    @PostMapping("/cars")
    public void saveCar(HttpServletResponse response, @PathParam("color") String color,
                        @PathParam("speed") double speed,
                        @PathParam("price") double price,
                        @PathParam("name") String name) throws Exception{
        cars.add(Car.builder()
                .speed(speed)
                .price(price)
                .name(name)
                .color(color)
                .build());
        response.sendRedirect("/cars/" + (cars.size() - 1));
    }

    @PutMapping("/cars/{id}")
    public void updateCar(@PathVariable int id, HttpServletResponse response, @PathParam("color") String color,
                          @PathParam("speed") double speed,
                          @PathParam("price") double price,
                          @PathParam("name") String name) throws Exception {
        cars.set(id, Car.builder()
                .speed(speed)
                .price(price)
                .name(name)
                .color(color)
                .build());
        response.sendRedirect("/cars/" + id);
    }

    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable int id, HttpServletResponse response) throws Exception{
        cars.remove(id);
        response.sendRedirect("/cars");
    }
}
