package school.sptech.projeto04.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.projeto04.entidade.Salgadinho;

public interface SalgadinhoRepository extends JpaRepository<Salgadinho, Integer> {
    
}
