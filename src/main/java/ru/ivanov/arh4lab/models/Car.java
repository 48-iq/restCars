package ru.ivanov.arh4lab.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {
    private String name;
    private Double price;
    private String color;
    private Double speed;
}
