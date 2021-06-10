package dev.stephantromer.kafka.model;

import lombok.Data;

@Data
public class Order {
    private String name;
    private float price;
}
