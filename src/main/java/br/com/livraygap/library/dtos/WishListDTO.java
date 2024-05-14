package br.com.livraygap.library.dtos;

import br.com.livraygap.library.entities.Book;
import br.com.livraygap.library.entities.User;
import br.com.livraygap.library.entities.WishList;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WishListDTO {
    Long id;
    User user;
    Book book;
    Long keyUser;
    Long keyBook;

    public WishListDTO(WishList wishList) {
        this.id = wishList.getId();
        this.user = wishList.getUser();
        this.book = wishList.getBook();
    }
}
