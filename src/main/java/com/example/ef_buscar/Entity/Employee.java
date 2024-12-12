package com.example.ef_buscar.Entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Employee implements Serializable {

    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;


}
