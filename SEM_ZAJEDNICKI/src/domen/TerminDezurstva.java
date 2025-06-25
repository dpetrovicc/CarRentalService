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
public class TerminDezurstva implements ApstraktniDomenskiObjekat {
    private int idTerminDezurstva;
    private String vreme;

    public TerminDezurstva() {
    }

    public TerminDezurstva(int idTerminDezurstva, String vreme) {
        this.idTerminDezurstva = idTerminDezurstva;
        this.vreme = vreme;
    }

    public int getIdTerminDezurstva() {
        return idTerminDezurstva;
    }

    public void setIdTerminDezurstva(int idTerminDezurstva) {
        this.idTerminDezurstva = idTerminDezurstva;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    @Override
    public String toString() {
        return "TerminDezurstva{" + "vreme=" + vreme + '}';
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
        final TerminDezurstva other = (TerminDezurstva) obj;
        if (this.idTerminDezurstva != other.idTerminDezurstva) {
            return false;
        }
        return Objects.equals(this.vreme, other.vreme);
    }

    @Override
    public String vratiNazivTabele() {
        return "termindezurstva";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        
        while (rs.next()) {            
            int idT = rs.getInt("termindezurstva.idTerminDezurstva");
            String vremeT = rs.getString("termindezurstva.vreme");
            
            TerminDezurstva td = new TerminDezurstva(idT, vremeT);
            lista.add(td);
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "vreme";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + vreme + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "termindezurstva.idTerminDezurstva= " + idTerminDezurstva;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekteIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "vreme= '" + vreme + "'";
    }
    
    
}
