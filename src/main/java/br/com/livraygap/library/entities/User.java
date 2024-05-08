package br.com.livraygap.library.entities;

import br.com.livraygap.library.enums.UserEnum;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_of_lib")
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

    @Column(name = "type_user")
    @Enumerated(EnumType.STRING)
    UserEnum typeUser;

    @Column(name = "deleted_at")
    Boolean deletedAt;

    @Column(name = "created_at")
    String createdAt;

    @Column(name = "updated_at")
    String updatedAt;
}
