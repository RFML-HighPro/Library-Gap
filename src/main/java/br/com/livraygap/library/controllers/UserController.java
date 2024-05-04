package br.com.livraygap.library.controllers;

import br.com.livraygap.library.entities.User;
import br.com.livraygap.library.services.UserService;
import br.com.livraygap.library.utils.FormatDates;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/API/USER")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/CREATE")
    public ResponseEntity<Object> saveUser(@RequestBody User newUser){
        service.saveUser(newUser);
        return ResponseEntity.ok("Usuário Salvo com Sucesso!");
    }

    @GetMapping("/All-USERS")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = service.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/GET-USER/{id}")
    public ResponseEntity<Optional<User>> getAllUsers(@PathVariable Long id){
        Optional<User> user = service.getUser(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/DEL-USER/{id}")
    public ResponseEntity<Object> delUser(@PathVariable Long id){
        service.delUser(id);
        return ResponseEntity.ok("Usuário Deletado com Sucesso!");
    }

    @PutMapping("/PUT-USER/{id}")
    public ResponseEntity<Object> updUser(@PathVariable Long id, @RequestBody User user){
        try{
            service.updUser(user, id);
            return ResponseEntity.ok("Usuário Atualizado com Sucesso!");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
