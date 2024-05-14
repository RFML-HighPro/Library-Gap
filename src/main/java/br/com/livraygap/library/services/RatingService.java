package br.com.livraygap.library.services;

import br.com.livraygap.library.dtos.RatingDTO;
import br.com.livraygap.library.entities.Book;
import br.com.livraygap.library.entities.Rating;
import br.com.livraygap.library.entities.User;
import br.com.livraygap.library.repositories.RatingRepository;
import br.com.livraygap.library.utils.FormatDates;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository repository;
    private final UserService userService;
    private final BookService bookService;

    private void saveOrUpdateRating(Rating rating){
        repository.save(rating);
    }

    public List<Rating> getAllRatings(){
        return repository.findAll();
    }

    private List<Rating> getRatingsByBook(Book book){
        return repository.findByBook(book);
    }

    private Rating getRating(Long id){
        return repository.findById(id).get();
    }

    public void deleteRating(Long id){
        repository.deleteById(id);
    }

    public List<RatingDTO> getRatings(Long idBook){
        Book book = bookService.getBookById(idBook);
        return getRatingsByBook(book).stream().map(RatingDTO::new).toList();
    }

    public void updateRating(RatingDTO ratingDTO, Long id){
        Rating rating = getRating(id);

        rating.setRating(ratingDTO.getRating());
        rating.setReviews(ratingDTO.getReviews());
        rating.setUpdatedAt(FormatDates.getDataByYearMonthDay(new Date()));

        saveOrUpdateRating(rating);
    }

    public void createRating(RatingDTO ratingDTO){
        Rating rating = new Rating();

        Book book = bookService.getBookById(ratingDTO.getKeyBook());
        User user = userService.getUserById(ratingDTO.getKeyUser());

        rating.setBook(book);
        rating.setUser(user);
        rating.setReviews(ratingDTO.getReviews());
        rating.setRating(ratingDTO.getRating());;
        rating.setCreatedAt(FormatDates.getDataByYearMonthDay(new Date()));

        saveOrUpdateRating(rating);
    }
}
