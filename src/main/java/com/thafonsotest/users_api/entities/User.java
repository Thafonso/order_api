package com.thafonsotest.users_api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



@Entity
@Table(name = "tb_user") // create a table User in the db
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // chose the strategy that is genarates ID automatically
    private Long ID;

    private String name;
    private String phone;

    @Column(unique = true)
    private String email;

    @Column(length = 11)
    private String cpf;
    private String password;

    @JsonIgnore // fix the request looping
    @OneToMany(mappedBy = "client")
    List<Order> orders = new ArrayList<>();

    public  User(){

    }

    public User(Long ID, String name, String phone, String email, String cpf, String password) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(ID, user.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ID);
    }
}
