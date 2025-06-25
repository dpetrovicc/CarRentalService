/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Iznajmljivanje implements ApstraktniDomenskiObjekat{
    private int idIznajmljivanje;
    private double ukupanIznos;
    private Zaposleni zaposleni;
    private PoslovniPartner poslovniPartner;
    private List<StavkaIznajmljivanja> stavke = new ArrayList<>();

    public Iznajmljivanje() {
    }

    public Iznajmljivanje(int idIznajmljivanje, double ukupanIznos, Zaposleni zaposleni, PoslovniPartner poslovniPartner) {
        this.idIznajmljivanje = idIznajmljivanje;
        this.ukupanIznos = ukupanIznos;
        this.zaposleni = zaposleni;
        this.poslovniPartner = poslovniPartner;
    }

    public int getIdIznajmljivanje() {
        return idIznajmljivanje;
    }

    public void setIdIznajmljivanje(int idIznajmljivanje) {
        this.idIznajmljivanje = idIznajmljivanje;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public PoslovniPartner getPoslovniPartner() {
        return poslovniPartner;
    }

    public void setPoslovniPartner(PoslovniPartner poslovniPartner) {
        this.poslovniPartner = poslovniPartner;
    }

    public List<StavkaIznajmljivanja> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaIznajmljivanja> stavke) {
        this.stavke = stavke;
    }

    @Override
    public String toString() {
        return "Iznajmljivanje{" + "ukupanIznos=" + ukupanIznos + ", zaposleni=" + zaposleni.getIme() + ", poslovniPartner=" + poslovniPartner.getImePrezime() + '}';
    }

    @Override
    public String vratiNazivTabele() {
        return "iznajmljivanje";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ukupanIznos, zaposleni, poslovniPartner";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return ukupanIznos + ", " + zaposleni.getIdZaposleni() + ", "
                + poslovniPartner.getIdPoslovniPartner();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "iznajmljivanje.idIznajmljivanje= " + idIznajmljivanje;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekteIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ukupanIznos= " + ukupanIznos + ", zaposleni= " + zaposleni.getIdZaposleni()
                + ", poslovniPartner= " + poslovniPartner.getIdPoslovniPartner();
    }
    
    
    
    
}
