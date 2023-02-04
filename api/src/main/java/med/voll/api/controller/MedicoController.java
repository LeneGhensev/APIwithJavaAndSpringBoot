package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired //define o local onde quer que o Spring injete a dependência. O Spring entende que ele que irá instanciar esse atributo.
    private MedicoRepository repository; //como precisou chamar essa classe no método, declara-se o repository como atributo aqui.
    
    @PostMapping //o PostMapping mapeia requisições post para a url com /medicos
    // public void cadastrar(@RequestBody String json) - o RequestBody diz que os parâmetros devem ser lidos do corpo da requisição.
    // System.out.println(dados); Dessa forma ("String json" acima) ele trás todos os campos juntos como uma única String, o ideia então é criar uma classe para separar os parâmetros
    @Transactional //por ser um método de escrita, precisa ter transação ativa com o banco de dados.
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {    
        repository.save(new Medico(dados)); //os parâmetros que estão vindo da requisição serão passados aqui.
        //esses dados é do construtor que está na classe Medico
        // adiciona o @Valid para se integrar com o bean validation e fazer as validações
    }
}
