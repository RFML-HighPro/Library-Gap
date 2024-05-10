package br.com.livraygap.library.controllers;

import br.com.livraygap.library.dtos.UserDTO;
import br.com.livraygap.library.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/USER")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/CREATE")
    public ResponseEntity<Object> saveUser(@RequestBody UserDTO newUser) {
        service.saveUser(newUser);
        return ResponseEntity.ok("Usuário Salvo com Sucesso!");
    }

    @GetMapping("/All-USERS")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = service.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/GET-USER/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        UserDTO user = service.getUser(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/DEL-USER/{id}")
    public ResponseEntity<Object> delUser(@PathVariable Long id) {
        service.delUser(id);
        return ResponseEntity.ok("Usuário Deletado com Sucesso!");
    }

    @PutMapping("/PUT-USER/{id}")
    public ResponseEntity<Object> updUser(@PathVariable Long id, @RequestBody UserDTO user) {
        service.updUser(user, id);
        return ResponseEntity.ok("Usuário Atualizado com Sucesso!");
    }
}
