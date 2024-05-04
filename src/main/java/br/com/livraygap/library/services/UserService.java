package br.com.livraygap.library.services;

import br.com.livraygap.library.entities.User;
import br.com.livraygap.library.repositories.UserRepository;
import br.com.livraygap.library.utils.FormatDates;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    private void saveOrUpdatedOrDelete(User user) {
        repository.save(user);
    }

    public boolean existsUser(Long id) {
        return repository.existsById(id);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUser(Long id) {
        return repository.findById(id);
    }

    public void saveUser(User newUser) {
        newUser.setCreated_at(FormatDates.getDataByYearMonthDay(new Date()));
        saveOrUpdatedOrDelete(newUser);
    }

    public void delUser(Long id) {
        User userGetted = getUser(id).get();
        userGetted.setDeleted_at(true);
        saveOrUpdatedOrDelete(userGetted);
    }

    public void updUser(User user, Long id) throws Exception {
        if (existsUser(id)) {
            user.setUpdated_at(FormatDates.getDataByYearMonthDay(new Date()));
            user.setId(id);
            saveOrUpdatedOrDelete(user);
        } else {
            throw new Exception("Usuário não encontrado");
        }
    }
}

