package com.macgregor.backend.dto;

import com.macgregor.backend.model.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;

    public static UserDTO convert(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setNome(user.getNome());
        userDto.setEndereco(user.getEndereco());
        userDto.setCpf(user.getCpf());
        userDto.setEmail(user.getEmail());
        userDto.setTelefone(user.getTelefone());
        userDto.setDataCadastro(user.getDataCadastro());
        return userDto;
    }
}
