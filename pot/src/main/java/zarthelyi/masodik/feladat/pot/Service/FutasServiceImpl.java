package zarthelyi.masodik.feladat.pot.Service;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import zarthelyi.masodik.feladat.pot.Exceptions.NoSuchEntity;
import zarthelyi.masodik.feladat.pot.Repository.FutasRepository;
import zarthelyi.masodik.feladat.pot.Service.ServiceDTO.Futas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FutasServiceImpl implements FutasService{
    private final FutasRepository futasRepository;

    public FutasServiceImpl(FutasRepository futasRepository) {
        this.futasRepository = futasRepository;
    }

    @Override
    public List<Futas> getAllFutas() {
        List<Futas> futasList = new ArrayList<>();
        for (zarthelyi.masodik.feladat.pot.Entity.Futas futas : futasRepository.findAll()) {
            futasList.add(new Futas(futas));
        }

        return futasList;
    }

    @Override
    public Futas create(Futas toFutas) {
        return new Futas(futasRepository.save(toFutas.toEntity()));
    }

    @Override
    public void deleteById(Long id) {
        try{
            futasRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new NoSuchEntity();
        }
    }

    @Override
    public void update(Futas futas) {
        Optional<zarthelyi.masodik.feladat.pot.Entity.Futas> futasById = futasRepository.findById(futas.getId());
        if(futasById.isEmpty()) {
            throw new NoSuchEntity();
        } else {
            futasRepository.save(futas.toEntity());
        }
    }

    @Override
    public Futas getBestFutas(int futasTipus) {
        Optional<zarthelyi.masodik.feladat.pot.Entity.Futas> futasByTipus = futasRepository.getFirstByFutasTipusOrderByTavDesc(futasTipus);
        if(futasByTipus.isEmpty()) {
            throw new NoSuchEntity();
        }
        return new Futas(futasByTipus);
    }
}
