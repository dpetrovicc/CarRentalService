/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author User
 */
public class Mesto implements ApstraktniDomenskiObjekat {
    
    private int idMesto;
    private String naziv;
    private String drzava;
    private String ptt;

    public Mesto() {
    }

    public Mesto(int idMesto, String naziv, String drzava, String ptt) {
        this.idMesto = idMesto;
        this.naziv = naziv;
        this.drzava = drzava;
        this.ptt = ptt;
    }

    public int getIdMesto() {
        return idMesto;
    }

    public void setIdMesto(int idMesto) {
        this.idMesto = idMesto;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getPtt() {
        return ptt;
    }

    public void setPtt(String ptt) {
        this.ptt = ptt;
    }

    @Override
    public String toString() {
        return naziv + ", " + drzava;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Mesto other = (Mesto) obj;
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.drzava, other.drzava)) {
            return false;
        }
        return Objects.equals(this.ptt, other.ptt);
    }

    @Override
    public String vratiNazivTabele() {
        return "mesto";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        
        while (rs.next()) {            
            int idM = rs.getInt("mesto.idMesto");
            String nazivM = rs.getString("mesto.naziv");
            String drzavaM = rs.getString("mesto.drzava");
            String pttM = rs.getString("mesto.ptt");
            
            Mesto m = new Mesto(idM, nazivM, drzavaM, pttM);
            lista.add(m);
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv, drzava, ptt";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + naziv + "', '" + drzava + "', '" + ptt + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "mesto.idMesto= " + idMesto;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekteIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv= '" + naziv + "', drzava= '" + drzava+ "', ptt= '" + ptt + "'";
    }
    
    
    
    
}
