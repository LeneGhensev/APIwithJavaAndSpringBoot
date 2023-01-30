package med.voll.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long>{ //recebe o tipo da entidade trabalhada pelo repository(Medico) e o tipo do atributo da chave primária da entidade(Long)
    //essa interface JPARepository tem todos os métodos para fazer um CRUD (criar, ler, atualizar, deletar).
    //como estamos herdando essa classe, não precisa implementar mais nada.
    
}
