package com.macgregor.backend.controller;

import com.macgregor.backend.dto.UserDTO;
import com.macgregor.backend.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    public static List<UserDTO> usuarios = new ArrayList<UserDTO>();
    private final UserService userService;

    @GetMapping("/")
    public String getMensagem(){
        return "Spring Boot is working";
    }

    @GetMapping
    public List<UserDTO> getUsers(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDTO getUsersFiltro(@PathVariable long id) {
        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO inserir(@RequestBody @Valid UserDTO userDTO){
        return userService.save(userDTO);
    }

    @GetMapping("/cpf/{cpf}")
    public UserDTO findByCpf(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        userService.delete(id);
    }

    @GetMapping("/search")
    public List<UserDTO> queryByName(@RequestParam(name="nome", required = true) String nome) {
        return userService.queryByName(nome);
    }

    @PatchMapping("/{id}")
    public UserDTO editUser(@PathVariable Long id, @RequestBody UserDTO userDto){
        return userService.editUser(id, userDto);
    }

    @GetMapping("/pageable")
    public Page<UserDTO> getUsersPage(Pageable pageable){
        return userService.getAllPage(pageable);
    }

}
