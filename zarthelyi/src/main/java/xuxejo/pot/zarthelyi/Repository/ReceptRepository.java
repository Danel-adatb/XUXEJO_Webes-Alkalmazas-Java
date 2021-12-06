package xuxejo.pot.zarthelyi.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import xuxejo.pot.zarthelyi.Entity.Recept;

import java.util.Optional;

@Repository
public interface ReceptRepository extends PagingAndSortingRepository<Recept, Long> {
    Optional<Recept> findAllByHozzavalo1Equals(String hozzavalo1);
}
