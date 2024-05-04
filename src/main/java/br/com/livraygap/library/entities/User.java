package br.com.livraygap.library.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "user_of_lib")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String name;

    @Column
    String lastname;

    @Column
    String contact;

    @Column
    String email;

    @Column
    String cpf;

    @Column
    @Enumerated(EnumType.STRING)
    EnumTypeUser type_user;

    @Column
    Boolean deleted_at;

    @Column
    String created_at;

    @Column
    String updated_at;

    public enum EnumTypeUser {
        commom, admin
    }
}




