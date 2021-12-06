package zarthelyi.masodik.feladat.pot.Controller.ControllerDTO;

import org.hibernate.validator.constraints.Range;
import zarthelyi.masodik.feladat.pot.Enums.Erzes;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Futas {
    private Long id;
    @NotNull
    private int ido;
    @Range(max = 3, min = 1)
    private int futasTipus;
    @Min(5)
    private float tav;
    private Erzes erzes;

    public Futas() {

    }

    public zarthelyi.masodik.feladat.pot.Service.ServiceDTO.Futas toServiceDTO() {
        return new zarthelyi.masodik.feladat.pot.Service.ServiceDTO.Futas(id, ido, futasTipus, tav, erzes);
    }

    public Futas(zarthelyi.masodik.feladat.pot.Service.ServiceDTO.Futas futas) {
        this.id = futas.getId();
        this.ido = futas.getIdo();
        this.futasTipus = futas.getFutasTipus();
        this.tav = futas.getTav();
        this.erzes = futas.getErzes();
    }

    public Futas(Long id, int ido, int futasTipus, float tav, Erzes erzes) {
        this.id = id;
        this.ido = ido;
        this.futasTipus = futasTipus;
        this.tav = tav;
        this.erzes = erzes;
    }

    public Long getId() {
        return id;
    }

    public int getIdo() {
        return ido;
    }

    public int getFutasTipus() {
        return futasTipus;
    }

    public float getTav() {
        return tav;
    }

    public Erzes getErzes() {
        return erzes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdo(int ido) {
        this.ido = ido;
    }

    public void setFutasTipus(int futasTipus) {
        this.futasTipus = futasTipus;
    }

    public void setTav(float tav) {
        this.tav = tav;
    }

    public void setErzes(Erzes erzes) {
        this.erzes = erzes;
    }
}
