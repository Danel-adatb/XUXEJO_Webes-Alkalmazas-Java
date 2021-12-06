package xuxejo.pot.zarthelyi.Service;

import xuxejo.pot.zarthelyi.Service.ServiceDTO.Recept;

import java.util.List;

public interface ReceptService {
    List<Recept> getAllRecept();
    Recept createRecept(Recept toRecept);
    void deleteReceptById(Long id);
    void updateRecept(Recept recept);
    Recept getReceptByHozzavalo(String hozzavalo1);
}
