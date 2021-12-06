package xuxejo.pot.zarthelyi.Controller.ControllerDTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import xuxejo.pot.zarthelyi.Service.ServiceDTO.Recept;

public class ReceptCreate {
    @NotEmpty
    private String hozzavalo1;
    @NotNull
    private double mennyiseg1;
    @NotEmpty
    private String hozzavalo2;
    @NotNull
    private double mennyiseg2;
    @NotEmpty
    private String hozzavalo3;
    @NotNull
    private double mennyiseg3;
    @NotEmpty
    private String hozzavalo4;
    @NotNull
    private double mennyiseg4;

    public ReceptCreate(String hozzavalo1, double mennyiseg1, String hozzavalo2, double mennyiseg2, String hozzavalo3, double mennyiseg3, String hozzavalo4, double mennyiseg4) {
        this.hozzavalo1 = hozzavalo1;
        this.mennyiseg1 = mennyiseg1;
        this.hozzavalo2 = hozzavalo2;
        this.mennyiseg2 = mennyiseg2;
        this.hozzavalo3 = hozzavalo3;
        this.mennyiseg3 = mennyiseg3;
        this.hozzavalo4 = hozzavalo4;
        this.mennyiseg4 = mennyiseg4;
    }

    public ReceptCreate() {

    }

    public Recept toServiceDTO() {
        return new Recept(null, hozzavalo1, mennyiseg1, hozzavalo2, mennyiseg2,
                hozzavalo3, mennyiseg3, hozzavalo4, mennyiseg4);
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
