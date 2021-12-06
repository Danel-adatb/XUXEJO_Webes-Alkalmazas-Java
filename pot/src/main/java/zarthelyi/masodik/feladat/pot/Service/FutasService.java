package zarthelyi.masodik.feladat.pot.Service;

import zarthelyi.masodik.feladat.pot.Service.ServiceDTO.Futas;

import java.util.List;

public interface FutasService {
    List<Futas> getAllFutas();
    Futas create(Futas toFutas);
    void deleteById(Long id);
    void update(Futas futas);
    Futas getBestFutas(int futasTipus);
}
