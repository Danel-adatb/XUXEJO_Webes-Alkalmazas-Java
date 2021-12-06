package xuxejo.pot.zarthelyi.Service.ServiceDTO;

import java.util.Optional;

public class Recept {
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

    public Recept(xuxejo.pot.zarthelyi.Entity.Recept recept) {
        this.id = recept.getId();
        this.hozzavalo1 = recept.getHozzavalo1();
        this.mennyiseg1 = recept.getMennyiseg1();
        this.hozzavalo2 = recept.getHozzavalo2();
        this.mennyiseg2 = recept.getMennyiseg2();
        this.hozzavalo3 = recept.getHozzavalo3();
        this.mennyiseg3 = recept.getMennyiseg3();
        this.hozzavalo4 = recept.getHozzavalo4();
        this.mennyiseg4 = recept.getMennyiseg4();
    }

    public Recept(Optional<xuxejo.pot.zarthelyi.Entity.Recept> recept) {
        this.id = recept.get().getId();
        this.hozzavalo1 = recept.get().getHozzavalo1();
        this.mennyiseg1 = recept.get().getMennyiseg1();
        this.hozzavalo2 = recept.get().getHozzavalo2();
        this.mennyiseg2 = recept.get().getMennyiseg2();
        this.hozzavalo3 = recept.get().getHozzavalo3();
        this.mennyiseg3 = recept.get().getMennyiseg3();
        this.hozzavalo4 = recept.get().getHozzavalo4();
        this.mennyiseg4 = recept.get().getMennyiseg4();
    }

    public xuxejo.pot.zarthelyi.Entity.Recept toEntity() {
        return new xuxejo.pot.zarthelyi.Entity.Recept(id, hozzavalo1, mennyiseg1, hozzavalo2, mennyiseg2,
                hozzavalo3, mennyiseg3, hozzavalo4, mennyiseg4);
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
