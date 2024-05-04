package br.com.livraygap.library.dtos;

import br.com.livraygap.library.entities.User;

public record UserDTO (
        Long id,
        String name,
        String lastname,
        String contact,
        String email,
        String cpf,
        User.EnumTypeUser type_user) {
}
