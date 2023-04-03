package com.macgregor.backend.model;

import com.macgregor.backend.dto.UserDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "User")
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @NotBlank(message = ("CPF é obrigatório"))
    private String cpf;
    private String endereco;
    @NotBlank(message = ("Email é obrigatório"))
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;

    public static User convert(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setNome(userDTO.getNome());
        user.setEndereco(userDTO.getEndereco());
        user.setCpf(userDTO.getCpf());
        user.setEmail(userDTO.getEmail());
        user.setTelefone(userDTO.getTelefone());
        user.setDataCadastro(userDTO.getDataCadastro());
        return user;
    }

}
