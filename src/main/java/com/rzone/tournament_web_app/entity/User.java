package com.rzone.tournament_web_app.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private double balance;
    private boolean isItAdmin;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 500;
        this.isItAdmin = false;
    }

    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public double getBalance() { return balance; }
    public boolean getIsItAdmin() { return isItAdmin; }

    public void setBalance(double balance) { this.balance = balance; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", isItAdmin=" + (isItAdmin ? "Admin" : "User") +
                '}';
    }
}
