package br.com.livraygap.library.services;

import br.com.livraygap.library.dtos.WishListDTO;
import br.com.livraygap.library.entities.Book;
import br.com.livraygap.library.entities.WishList;
import br.com.livraygap.library.entities.User;
import br.com.livraygap.library.repositories.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WishListService {
    private final WishListRepository repository;
    private final BookService bookService;
    private final UserService userService;

    private void saveWishList(WishList WishList){
        repository.save(WishList);
    }

    public void delWishList(Long id){
        repository.deleteById(id);
    }

    public WishList getWishListById(Long id){
        return repository.findById(id).get();
    }

    public List<WishList> getWishListsByUser(User user){
        return repository.findByUser(user);
    }

    public WishListDTO getItemOfWishList(Long id){
        return new WishListDTO(getWishListById(id));
    }

    public List<WishListDTO> getWishLists(Long id){
        User user = userService.getUserById(id);
        return getWishListsByUser(user).stream().map(WishListDTO::new).toList();
    }

    public void saveBook(WishListDTO wishListDTO){
        User user = userService.getUserById(wishListDTO.getKeyUser());
        Book book = bookService.getBookById(wishListDTO.getKeyBook());

        WishList wishList = new WishList();
        wishList.setUser(user);
        wishList.setBook(book);

        saveWishList(wishList);
    }
}
