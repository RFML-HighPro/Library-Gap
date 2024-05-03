package br.com.livraygap.library.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.SQLRestriction;

import java.util.Date;

@Entity
@Table(name = "user_of_lib")
@Data
@SQLRestriction("closed <> true")
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
    EnumTypeUser typeUser;

    @Column
    Boolean closed;

    @Column
    Date created_at;

    @Column
    Date updated_at;

    @Column
    Date deleted_at;

    public enum EnumTypeUser {
        commom, admin
    }

}




