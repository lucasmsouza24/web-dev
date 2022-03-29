package sptech.projetojpa01.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import sptech.projetojpa01.entidade.Salgadinho;
import sptech.projetojpa01.resposta.SalgadinhoSimplesResposta;

public interface SalgadinhoRepository
        extends JpaRepository<Salgadinho, Integer> {

                @Query("SELECT new sptech.projetojpa01.resposta.SalgadinhoSimplesResposta(s.codigo, s.nome) FROM Salgadinho s")
                public List<SalgadinhoSimplesResposta> listaSimples();

                @Transactional
                @Modifying
                @Query("UPDATE Salgadinho s SET s.preco = ?2 WHERE s.codigo = ?1")
                public void atualizarPreco(Integer codigo, Double novoPreco);

                @Transactional
                @Modifying
                @Query("UPDATE Salgadinho s SET s.preco = ?2, s.apimentado = ?3 WHERE s.codigo = ?1")
                public void atualizarPrecoApimentado(int codigo, Double preco, Boolean apimentado);
}
