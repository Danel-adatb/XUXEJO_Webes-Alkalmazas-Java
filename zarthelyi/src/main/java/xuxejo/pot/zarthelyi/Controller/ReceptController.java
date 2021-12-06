package xuxejo.pot.zarthelyi.Controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import xuxejo.pot.zarthelyi.Controller.ControllerDTO.Recept;
import xuxejo.pot.zarthelyi.Controller.ControllerDTO.ReceptCreate;
import xuxejo.pot.zarthelyi.Service.ReceptService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recept")
public class ReceptController {
    private final ReceptService receptService;

    public ReceptController(ReceptService receptService) {
        this.receptService = receptService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Recept save(@RequestBody @Valid ReceptCreate receptCreate) {
        return new Recept(receptService.createRecept(receptCreate.toServiceDTO()));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        receptService.deleteReceptById(id);
    }

    @PutMapping
    public void updateRecept(@RequestBody @Valid Recept recept){
        receptService.updateRecept(recept.toServiceDTO());
    }

    @GetMapping
    public List<Recept> getAllFutas(){
        List<Recept> receptList = new ArrayList<>();
        for(xuxejo.pot.zarthelyi.Service.ServiceDTO.Recept recept : receptService.getAllRecept()){
            receptList.add(new Recept(recept));
        }
        return receptList;
    }

    @GetMapping("/{hozzavalo1}")
    public Recept getReceptByHozzavalo(@PathVariable("hozzavalo1") String hozzavalo1) {
        return new Recept(receptService.getReceptByHozzavalo(hozzavalo1));
    }

}
