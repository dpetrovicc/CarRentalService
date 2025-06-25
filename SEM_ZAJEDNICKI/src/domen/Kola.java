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
public class Kola implements ApstraktniDomenskiObjekat {

    private int idKola;
    private String marka;
    private String model;
    private double kilometraza;
    private double cena;

    public Kola() {
    }

    public Kola(int idKola, String marka, String model, double kilometraza, double cena) {
        this.idKola = idKola;
        this.marka = marka;
        this.model = model;
        this.kilometraza = kilometraza;
        this.cena = cena;
    }

    public int getIdKola() {
        return idKola;
    }

    public void setIdKola(int idKola) {
        this.idKola = idKola;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getKilometraza() {
        return kilometraza;
    }

    public void setKilometraza(double kilometraza) {
        this.kilometraza = kilometraza;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Kola{" + "marka=" + marka + ", model=" + model + ", kilometraza=" + kilometraza + ", cena=" + cena + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Kola other = (Kola) obj;
        return this.idKola == other.idKola;
    }

    @Override
    public String vratiNazivTabele() {
        return "kola";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        
        while (rs.next()) { 
            int kolaId = rs.getInt("kola.idKola");
            String markaK = rs.getString("kola.marka");
            String modelK = rs.getString("kola.model");
            double kilometrazaK = rs.getDouble("kola.kilometraza");
            double cenaK = rs.getDouble("kola.cena");
            
            Kola k = new Kola(kolaId, markaK, modelK, kilometrazaK, cenaK);
            lista.add(k);
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "marka, model, kilometraza, cena";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + marka + "', '" + model + "', " + kilometraza + ", " + cena;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "kola.idKola= " + idKola;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekteIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "marka= '" + marka + "', model= '" + model + "', kilometraza= " + kilometraza + ", cena= " + cena;

    }

}
