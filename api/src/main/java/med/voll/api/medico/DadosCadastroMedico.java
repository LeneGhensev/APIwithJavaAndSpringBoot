package med.voll.api.medico;

import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {
    // O record faz o Java criar uma classe imutável, em que cada um desses campos vai virar atributos com os métodos getters e setters e com os construtores, sem precisarmos fazer isso manualmente pois o Spring cria automaticamente. 
}
