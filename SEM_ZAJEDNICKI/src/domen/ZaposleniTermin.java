/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author User
 */
public class ZaposleniTermin implements ApstraktniDomenskiObjekat {
    private Zaposleni zaposleni;
    private TerminDezurstva termin;
    private Date datumDezurstva;

    public ZaposleniTermin() {
    }

    public ZaposleniTermin(Zaposleni zaposleni, TerminDezurstva termin, Date datumDezurstva) {
        this.zaposleni = zaposleni;
        this.termin = termin;
        this.datumDezurstva = datumDezurstva;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public TerminDezurstva getTermin() {
        return termin;
    }

    public void setTermin(TerminDezurstva termin) {
        this.termin = termin;
    }

    public Date getDatumDezurstva() {
        return datumDezurstva;
    }

    public void setDatumDezurstva(Date datumDezurstva) {
        this.datumDezurstva = datumDezurstva;
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
        final ZaposleniTermin other = (ZaposleniTermin) obj;
        if (!Objects.equals(this.zaposleni, other.zaposleni)) {
            return false;
        }
        return Objects.equals(this.termin, other.termin);
    }

    @Override
    public String toString() {
        return "zaposleni=" + zaposleni + ", termin=" + termin + ", datumDezurstva=" + datumDezurstva + '}';
    }

    @Override
    public String vratiNazivTabele() {
        return "zaposlenitermin";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "zaposleni, termin, datumDezurstva";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return zaposleni.getIdZaposleni() + ", " + termin.getIdTerminDezurstva() + ", '" + datumDezurstva + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "zaposlenitermin.zaposleni= " + zaposleni.getIdZaposleni() + " AND zaposlenitermin.termin=" + termin.getIdTerminDezurstva();
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekteIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "zaposleni= " + zaposleni.getIdZaposleni() + ", termin= " + termin.getIdTerminDezurstva() +
                ", datumDezurstva= '" + datumDezurstva + "'";
    }
    
    
}
