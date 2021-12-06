package zarthelyi.masodik.feladat.pot.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import zarthelyi.masodik.feladat.pot.Entity.Futas;

import java.util.Optional;

@Repository
public interface FutasRepository extends PagingAndSortingRepository<Futas, Long> {
    Optional<Futas> getFirstByFutasTipusOrderByTavDesc(int futasTipus);
}
