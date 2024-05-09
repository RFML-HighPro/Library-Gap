package br.com.livraygap.library.dtos;

import br.com.livraygap.library.entities.User;
import br.com.livraygap.library.enums.UserEnum;

public record UserDTO(
        Long id,
        String name,
        String lastname,
        String contact,
        String email,
        String cpf,
        String created_at,
        String updated_at,
        UserEnum typeUser
) {
    public static UserDTO getDtoUser(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getLastname(),
                user.getContact(),
                user.getEmail(),
                user.getCpf(),
                user.getCreatedAt(),
                user.getUpdatedAt(),
                user.getTypeUser()
        );
    }
}
