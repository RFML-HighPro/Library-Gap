package br.com.livraygap.library.entities;

import br.com.livraygap.library.enums.UserEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "lastname")
    String lastname;

    @Column(name = "contact")
    String contact;

    @Column(name = "email")
    String email;

    @Column(name = "cpf")
    String cpf;

    @Column(name = "typeUser")
    @Enumerated(EnumType.STRING)
    UserEnum typeUser;

    @Column(name = "deletedAt")
    Boolean deletedAt;

    @Column(name = "createdAt")
    String createdAt;

    @Column(name = "updatedAt")
    String updatedAt;

    @OneToMany(mappedBy = "user")
    List<WishList> listBookDesired;
}



