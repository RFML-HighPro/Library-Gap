package br.com.livraygap.library.dtos;

import br.com.livraygap.library.entities.User;
import br.com.livraygap.library.enums.UserEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    Long id;
    String name;
    String lastname;
    String contact;
    String email;
    String cpf;
    String createdAt;
    String updatedAt;
    Boolean deletedAt;
    UserEnum typeUser;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.lastname = user.getLastname();
        this.contact = user.getContact();
        this.email = user.getEmail();
        this.cpf = user.getCpf();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
        this.deletedAt = user.getDeletedAt();
        this.typeUser = user.getTypeUser();
    }
}
