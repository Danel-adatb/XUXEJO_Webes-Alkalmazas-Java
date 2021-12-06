package zarthelyi.masodik.feladat.pot.Controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import zarthelyi.masodik.feladat.pot.Controller.ControllerDTO.Futas;
import zarthelyi.masodik.feladat.pot.Controller.ControllerDTO.FutasCreate;
import zarthelyi.masodik.feladat.pot.Service.FutasService;

import javax.validation.Valid;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/futas")
public class FutasController {
    private final FutasService futasService;

    public FutasController(FutasService futasService) {
        this.futasService = futasService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Futas save(@RequestBody @Valid FutasCreate futasCreate) {
        return new Futas(futasService.create(futasCreate.toServiceDTO()));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        futasService.deleteById(id);
    }

    @PutMapping
    public void update(@RequestBody @Valid Futas futas) {
        futasService.update(futas.toServiceDTO());
    }

    @GetMapping
    public List<Futas> getAllFutas() {
        List<Futas> futasList = new ArrayList<>();
        for (zarthelyi.masodik.feladat.pot.Service.ServiceDTO.Futas futas : futasService.getAllFutas()) {
            futasList.add(new Futas(futas));
        }

        return futasList;
    }

    @GetMapping("/best")
    public Futas getBest(@RequestParam int type) {
        return new Futas(futasService.getBestFutas(type));
    }
}
