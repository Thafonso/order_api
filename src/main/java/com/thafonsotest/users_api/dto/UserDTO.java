package com.thafonsotest.users_api.dto;

import com.thafonsotest.users_api.entities.User;
import com.thafonsotest.users_api.validations.CpfValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;

public class UserDTO  {

    private Long Id;

    @NotBlank(message = "Username is required")
    private String name;

    @NotNull
    private String phone;

    @Email(message = "Email is required")
    private String email;

    @CpfValid
    private String cpf;

    public UserDTO() {

    }

    public UserDTO(User user) {
        this.Id = user.getID();
        this.name = user.getName();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.cpf = user.getCpf();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(Id, userDTO.Id) && Objects.equals(name, userDTO.name) && Objects.equals(email, userDTO.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, email);
    }
}
