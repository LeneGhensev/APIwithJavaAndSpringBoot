package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor //gera o construtor sem argumentos, exigido pelo JPA
@AllArgsConstructor //cria construtor que recebe todos os campos
@EqualsAndHashCode(of = "id") //gera o equals hashcode em cima do id
public class Medico {

    //faz a geração automática dos códigos via anotações
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded //Endereço fica numa classe separada, mas faz parte da mesma tabela de Médicos, no BD. E add outra anotação lá na classe.
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }
}
