package xuxejo.pot.zarthelyi.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Recept {
    @Id
    @GeneratedValue
    private Long id;
    private String hozzavalo1;
    private double mennyiseg1;
    private String hozzavalo2;
    private double mennyiseg2;
    private String hozzavalo3;
    private double mennyiseg3;
    private String hozzavalo4;
    private double mennyiseg4;

    public Recept(Long id, String hozzavalo1, double mennyiseg1, String hozzavalo2, double mennyiseg2, String hozzavalo3, double mennyiseg3, String hozzavalo4, double mennyiseg4) {
        this.id = id;
        this.hozzavalo1 = hozzavalo1;
        this.mennyiseg1 = mennyiseg1;
        this.hozzavalo2 = hozzavalo2;
        this.mennyiseg2 = mennyiseg2;
        this.hozzavalo3 = hozzavalo3;
        this.mennyiseg3 = mennyiseg3;
        this.hozzavalo4 = hozzavalo4;
        this.mennyiseg4 = mennyiseg4;
    }

    public Recept() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHozzavalo1() {
        return hozzavalo1;
    }

    public void setHozzavalo1(String hozzavalo1) {
        this.hozzavalo1 = hozzavalo1;
    }

    public double getMennyiseg1() {
        return mennyiseg1;
    }

    public void setMennyiseg1(double mennyiseg1) {
        this.mennyiseg1 = mennyiseg1;
    }

    public String getHozzavalo2() {
        return hozzavalo2;
    }

    public void setHozzavalo2(String hozzavalo2) {
        this.hozzavalo2 = hozzavalo2;
    }

    public double getMennyiseg2() {
        return mennyiseg2;
    }

    public void setMennyiseg2(double mennyiseg2) {
        this.mennyiseg2 = mennyiseg2;
    }

    public String getHozzavalo3() {
        return hozzavalo3;
    }

    public void setHozzavalo3(String hozzavalo3) {
        this.hozzavalo3 = hozzavalo3;
    }

    public double getMennyiseg3() {
        return mennyiseg3;
    }

    public void setMennyiseg3(double mennyiseg3) {
        this.mennyiseg3 = mennyiseg3;
    }

    public String getHozzavalo4() {
        return hozzavalo4;
    }

    public void setHozzavalo4(String hozzavalo4) {
        this.hozzavalo4 = hozzavalo4;
    }

    public double getMennyiseg4() {
        return mennyiseg4;
    }

    public void setMennyiseg4(double mennyiseg4) {
        this.mennyiseg4 = mennyiseg4;
    }
}
