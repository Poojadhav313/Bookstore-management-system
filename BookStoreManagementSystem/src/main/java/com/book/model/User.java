package com.book.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class User {
	@Id
	private int id;
	private String username;
    private String password;
    private String role;
    
 // Add a Cart field to the User class
    @Transient
    private Cart cart;

    // Default constructor
    public User() {
        this.cart = new Cart(); // Initialize the cart when the user is created
    }

    // Getter and Setter for Cart
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    // Getter and Setter for other fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Constructor with parameters
    public User(int id, String username, String password, String role) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.cart = new Cart(); // Initialize the cart for the user
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + "]";
    }
	
	
	

}
