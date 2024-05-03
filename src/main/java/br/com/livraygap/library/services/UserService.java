package br.com.livraygap.library.services;

import br.com.livraygap.library.entities.User;
import br.com.livraygap.library.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    private void saveOrUpdate(User user) {
        repository.save(user);
    }

    public void saveUser(User newUser) {
        saveOrUpdate(newUser);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUser(Long id) {
        return repository.findById(id);
    }

    public void updUser(User user, Long id) {
        user.setId(id);
        saveOrUpdate(user);
    }

}
