package xuxejo.pot.zarthelyi.Service;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import xuxejo.pot.zarthelyi.Exceptions.NoSuchEntity;
import xuxejo.pot.zarthelyi.Repository.ReceptRepository;
import xuxejo.pot.zarthelyi.Service.ServiceDTO.Recept;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReceptServiceImpl implements ReceptService{
    private final ReceptRepository receptRepository;

    public ReceptServiceImpl(ReceptRepository receptRepository) {
        this.receptRepository = receptRepository;
    }

    @Override
    public List<Recept> getAllRecept() {
        List<Recept> receptList = new ArrayList<>();
        for (xuxejo.pot.zarthelyi.Entity.Recept recept : receptRepository.findAll()) {
            receptList.add(new Recept(recept));
        }

        return receptList;
    }

    @Override
    public Recept createRecept(Recept toRecept) {
        return new Recept(receptRepository.save(toRecept.toEntity()));
    }

    @Override
    public void deleteReceptById(Long id) {
        try {
            receptRepository.deleteById(id);
        } catch(EmptyResultDataAccessException ex) {
            throw new NoSuchEntity();
        }
    }

    @Override
    public void updateRecept(Recept recept) {
        Optional<xuxejo.pot.zarthelyi.Entity.Recept> receptById = receptRepository.findById(recept.getId());
        if(receptById.isEmpty()) {
            throw new NoSuchEntity();
        } else {
            receptRepository.save(recept.toEntity());
        }
    }

    @Override
    public Recept getReceptByHozzavalo(String hozzavalo1) {
        Optional<xuxejo.pot.zarthelyi.Entity.Recept> receptByHozzavalo = receptRepository.findAllByHozzavalo1Equals(hozzavalo1);
        if(receptByHozzavalo.isEmpty()) {
            throw new NoSuchEntity();
        }

        return new Recept(receptByHozzavalo);
    }
}
