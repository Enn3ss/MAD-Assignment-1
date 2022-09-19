package com.example.mad_assignment_1.databases.food;

public class Food {
    String id;
    String name;
    double price;
    String description;
    String restaurantId;
    int image;

    public Food(String id, String name, double price, String description, String restaurantId, int image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.restaurantId = restaurantId;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public int getImage() {
        return image;
    }
}