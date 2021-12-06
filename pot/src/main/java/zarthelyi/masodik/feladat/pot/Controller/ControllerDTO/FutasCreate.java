package zarthelyi.masodik.feladat.pot.Controller.ControllerDTO;

import org.hibernate.validator.constraints.Range;
import zarthelyi.masodik.feladat.pot.Enums.Erzes;
import zarthelyi.masodik.feladat.pot.Service.ServiceDTO.Futas;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class FutasCreate {
    @NotNull
    private int ido;
    @Range(max = 3, min = 1)
    private int futasTipus;
    @Min(5)
    private float tav;
    private Erzes erzes;

    public FutasCreate() {

    }

    public FutasCreate(int ido, int futasTipus, float tav, Erzes erzes) {
        this.ido = ido;
        this.futasTipus = futasTipus;
        this.tav = tav;
        this.erzes = erzes;
    }

    public Futas toServiceDTO() {
        return new zarthelyi.masodik.feladat.pot.Service.ServiceDTO.Futas(null, ido, futasTipus, tav, erzes);
    }

    public int getIdo() {
        return ido;
    }

    public void setIdo(int ido) {
        this.ido = ido;
    }

    public int getFutasTipus() {
        return futasTipus;
    }

    public void setFutasTipus(int futasTipus) {
        this.futasTipus = futasTipus;
    }

    public float getTav() {
        return tav;
    }

    public void setTav(float tav) {
        this.tav = tav;
    }

    public Erzes getErzes() {
        return erzes;
    }

    public void setErzes(Erzes erzes) {
        this.erzes = erzes;
    }
}
