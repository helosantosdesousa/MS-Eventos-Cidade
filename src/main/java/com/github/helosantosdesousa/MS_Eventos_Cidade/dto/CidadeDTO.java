package com.github.helosantosdesousa.MS_Eventos_Cidade.dto;

import com.github.helosantosdesousa.MS_Eventos_Cidade.entities.Cidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CidadeDTO {
    private Long id;
    @NotBlank(message = "O nome não pode ser nulo")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank (message = "O estado não pode ser nulo")
    @Size(min =3, max=100, message = "O estado deve ter entre 3 e 100 caracteres")
    private String estado;

    @NotBlank(message = "O estado não pode ser nulo")
    @Size(min =2, max = 2, message="O uf deve ter 2 caracteres")
    private String uf;

    public CidadeDTO(Cidade entity){
        id = entity.getId();
        nome = entity.getNome();
        estado = entity.getEstado();
        uf = entity.getUf();
    }

}
