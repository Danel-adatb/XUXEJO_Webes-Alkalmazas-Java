package zarthelyi.masodik.feladat.pot.Entity;

import zarthelyi.masodik.feladat.pot.Enums.Erzes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Futas {
    @Id
    @GeneratedValue
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
}
