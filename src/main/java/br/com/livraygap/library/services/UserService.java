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

    private List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.findById(id).get();
    }

    private void saveOrUpdatedOrDelete(User user) {
        repository.save(user);
    }

    public List<UserDTO> getUsers() {
        return getAllUsers().stream().map(UserDTO::new).toList();
    }

    public UserDTO getUser(Long id) {
        User user = getUserById(id);
        return new UserDTO(user);
    }

    public void delUser(Long id) {
        User userGetted = getUserById(id);
        userGetted.setDeletedAt(true);
        saveOrUpdatedOrDelete(userGetted);
    }

    public void saveUser(UserDTO userDTO) {
        User user = new User();

        user.setName(userDTO.getName());
        user.setLastname(userDTO.getLastname());
        user.setContact(userDTO.getContact());
        user.setEmail(userDTO.getEmail());
        user.setCpf(userDTO.getCpf());
        user.setUpdatedAt(userDTO.getUpdatedAt());
        user.setDeletedAt(userDTO.getDeletedAt());
        user.setTypeUser(userDTO.getTypeUser());
        user.setCreatedAt(FormatDates.getDataByYearMonthDay(new Date()));

        saveOrUpdatedOrDelete(user);
    }

    public void updUser(UserDTO userDTO, Long id) {
        User user = getUserById(id);

        user.setName(userDTO.getName());
        user.setLastname(userDTO.getLastname());
        user.setContact(userDTO.getContact());
        user.setEmail(userDTO.getEmail());
        user.setCpf(userDTO.getCpf());
        user.setUpdatedAt(userDTO.getUpdatedAt());
        user.setDeletedAt(userDTO.getDeletedAt());
        user.setTypeUser(userDTO.getTypeUser());
        user.setCreatedAt(userDTO.getCreatedAt());
        user.setDeletedAt(userDTO.getDeletedAt());
        user.setUpdatedAt(FormatDates.getDataByYearMonthDay(new Date()));

        saveOrUpdatedOrDelete(user);
    }
}

