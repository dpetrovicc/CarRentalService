/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public class StavkaIznajmljivanja implements ApstraktniDomenskiObjekat {

    private Iznajmljivanje iznajmljivanje;
    private int rb;
    private String opisStavke;
    private Date datumOd;
    private Date datumDo;
    private int brojDana;
    private double cenaPoDanu;
    private double iznos;
    private Kola kola;

    public StavkaIznajmljivanja() {
    }

    public StavkaIznajmljivanja(Iznajmljivanje iznajmljivanje, int rb, String opisStavke, Date datumOd, Date datumDo, int brojDana, double cenaPoDanu, double iznos, Kola kola) {
        this.iznajmljivanje = iznajmljivanje;
        this.rb = rb;
        this.opisStavke = opisStavke;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.brojDana = brojDana;
        this.cenaPoDanu = cenaPoDanu;
        this.iznos = iznos;
        this.kola = kola;
    }

    public Iznajmljivanje getIznajmljivanje() {
        return iznajmljivanje;
    }

    public void setIznajmljivanje(Iznajmljivanje iznajmljivanje) {
        this.iznajmljivanje = iznajmljivanje;
    }

    public Kola getKola() {
        return kola;
    }

    public void setKola(Kola kola) {
        this.kola = kola;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public String getOpisStavke() {
        return opisStavke;
    }

    public void setOpisStavke(String opisStavke) {
        this.opisStavke = opisStavke;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public int getBrojDana() {
        return brojDana;
    }

    public void setBrojDana(int brojDana) {
        this.brojDana = brojDana;
    }

    public double getCenaPoDanu() {
        return cenaPoDanu;
    }

    public void setCenaPoDanu(double cenaPoDanu) {
        this.cenaPoDanu = cenaPoDanu;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StavkaIznajmljivanja other = (StavkaIznajmljivanja) obj;
        return this.rb == other.rb;
    }

    @Override
    public String vratiNazivTabele() {
        return "stavkaiznajmljivanja";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "iznajmljivanje, datumOd, datumDo, brojDana, iznos, opisStavke, kola";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return iznajmljivanje.getIdIznajmljivanje() + ", '" + datumOd + "', '" + datumDo + "', "
                + brojDana + ", " + iznos + ", '" + opisStavke.replace("'", "''") + "', " + kola.getIdKola();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "stavkaiznajmljivanja.rb= " + rb + " AND stavkaiznajmljivanja.iznajmljivanje= " + iznajmljivanje.getIdIznajmljivanje();
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekteIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "datumOd= '" + datumOd + "', datumDo= '" + datumDo + "', brojDana= " + brojDana +
                ", iznos= " + iznos + ", opisStavke= '" + opisStavke + "', kola= " + kola.getIdKola();
    }

}
