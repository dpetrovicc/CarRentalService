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
public class PoslovniPartner implements ApstraktniDomenskiObjekat {
    private int idPoslovniPartner;
    private String imePrezime;
    private Mesto mesto;

    public PoslovniPartner() {
    }

    public PoslovniPartner(int idPoslovniPartner, String imePrezime, Mesto mesto) {
        this.idPoslovniPartner = idPoslovniPartner;
        this.imePrezime = imePrezime;
        this.mesto = mesto;
    }

    public int getIdPoslovniPartner() {
        return idPoslovniPartner;
    }

    public void setIdPoslovniPartner(int idPoslovniPartner) {
        this.idPoslovniPartner = idPoslovniPartner;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return "PoslovniPartner{" + "idPoslovniPartner=" + idPoslovniPartner + ", imePrezime=" + imePrezime + ", mesto=" + mesto + '}';
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
        final PoslovniPartner other = (PoslovniPartner) obj;
        return this.idPoslovniPartner == other.idPoslovniPartner;
    }

    @Override
    public String vratiNazivTabele() {
        return "poslovnipartner";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        
        while (rs.next()) {            
            int idPP = rs.getInt("poslovnipartner.idPoslovniPartner");
            String imePrezimePP = rs.getString("poslovnipartner.imePrezime");
            int mestoIdPP = rs.getInt("poslovnipartner.mesto");
            Mesto m = new Mesto(mestoIdPP, null, null, null);
            
            PoslovniPartner pp = new PoslovniPartner(idPP, imePrezimePP, m);
            lista.add(pp);
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "imePrezime, mesto";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + imePrezime + "', " + mesto.getIdMesto();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "poslovnipartner.idPoslovniPartner= " + idPoslovniPartner;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekteIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "imePrezime= '" + imePrezime + "', mesto= " + mesto.getIdMesto();
    }
    
    
    
    
}
