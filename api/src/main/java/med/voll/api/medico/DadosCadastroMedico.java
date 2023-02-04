package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

//O Bean Validation, a partir das anotações, vai verificar se as informações que chegam estão de acordo com as anotações.

public record DadosCadastroMedico(
    @NotBlank //informa que é um campo obrigatório, não pode ser nulo e nem vazio  
    String nome,

    @NotBlank //informa que é um campo obrigatório, não pode ser nulo e nem vazio  
    @Email
    String email, 
    
    @NotBlank
    @Pattern(regexp = "\\d{4,6}") //informa que deverá ser um número de 4 a 6 dígitos
    String crm, 

    @NotNull //informa que não pode ser nulo e nem vazio  
    Especialidade especialidade, 

    @NotNull
    @Valid //para fazer a validação do dto
    DadosEndereco endereco) {
    // O record faz o Java criar uma classe imutável, em que cada um desses campos vai virar atributos com os métodos getters e setters e com os construtores, sem precisarmos fazer isso manualmente pois o Spring cria automaticamente. 
}
