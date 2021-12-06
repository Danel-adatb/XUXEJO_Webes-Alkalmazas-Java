package zarthelyi.masodik.feladat.pot.Service.ServiceDTO;

import zarthelyi.masodik.feladat.pot.Enums.Erzes;

import java.util.Optional;

public class Futas {
    private Long id;
    private int ido;
    private int futasTipus;
    private float tav;
    private Erzes erzes;

    public Futas() {

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

    public void setId(Long id) {
        this.id = id;
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

    public Futas(zarthelyi.masodik.feladat.pot.Entity.Futas futas) {
        this.id = futas.getId();
        this.ido = futas.getIdo();
        this.futasTipus = futas.getFutasTipus();
        this.tav = futas.getTav();
        this.erzes = futas.getErzes();
    }

    public Futas(Optional<zarthelyi.masodik.feladat.pot.Entity.Futas> futas) {
        this.id = futas.get().getId();
        this.ido = futas.get().getIdo();
        this.futasTipus = futas.get().getFutasTipus();
        this.tav = futas.get().getTav();
        this.erzes = futas.get().getErzes();
    }

    public zarthelyi.masodik.feladat.pot.Entity.Futas toEntity() {
        return new zarthelyi.masodik.feladat.pot.Entity.Futas(id, ido, futasTipus, tav, erzes);
    }
}
