package br.com.livraygap.library.services;

import br.com.livraygap.library.dtos.UserDTO;
import br.com.livraygap.library.entities.User;
import br.com.livraygap.library.repositories.UserRepository;
import br.com.livraygap.library.utils.FormatDates;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    private boolean existsUser(Long id) {
        return repository.existsById(id);
    }

    private List<User> getAllUsers() {
        return repository.findAll();
    }

    private User getUser(Long id) {
        return repository.findById(id).get();
    }

    private void saveOrUpdatedOrDelete(User user) {
        repository.save(user);
    }

    private UserDTO getDtoUser(User user){
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

    public void saveUser(User user) {
        user.setCreatedAt(FormatDates.getDataByYearMonthDay(new Date()));
        saveOrUpdatedOrDelete(user);
    }

    public UserDTO getUserConfigured(Long id) {
        User user = getUser(id);
        return getDtoUser(user);
    }

    public List<UserDTO> getAllUserConfigured() {
;       List<User> users = getAllUsers();
        return users.stream().map(this::getDtoUser).toList();
    }

    public void delUser(Long id) {
        User userGetted = getUser(id);
        userGetted.setDeletedAt(true);
        saveOrUpdatedOrDelete(userGetted);
    }

    public void updUser(User user, Long id) {
        Long userId = getUser(id).getId();
        user.setUpdatedAt(FormatDates.getDataByYearMonthDay(new Date()));
        user.setId(userId);
        saveOrUpdatedOrDelete(user);
    }
}

