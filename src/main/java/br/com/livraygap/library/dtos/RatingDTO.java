package br.com.livraygap.library.dtos;

import br.com.livraygap.library.entities.Book;
import br.com.livraygap.library.entities.Rating;
import br.com.livraygap.library.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RatingDTO {
    Long id;
    Book book;
    User user;
    String reviews;
    Double rating;
    String createdAt;
    String updatedAt;
    Long keyUser;
    Long keyBook;

    public RatingDTO(Rating rating) {
        this.id = rating.getId();
        this.book = rating.getBook();
        this.user = rating.getUser();
        this.reviews = rating.getReviews();
        this.rating = rating.getRating();
        this.createdAt = rating.getCreatedAt();
        this.updatedAt = rating.getUpdatedAt();
    }
}