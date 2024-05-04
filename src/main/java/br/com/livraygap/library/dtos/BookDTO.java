package br.com.livraygap.library.dtos;

import br.com.livraygap.library.entities.User;

import java.math.BigInteger;
import java.util.Date;

public record BookDTO(
        String title,
        String author,
        String publisher,
        int pages,
        User.EnumTypeUser genre,
        BigInteger isbn,
        Double price,
        Date release_date,
        Date created_at,
        Date updated_at,
        Boolean deleted_at
) {
}

