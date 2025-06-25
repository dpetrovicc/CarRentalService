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
public class Zaposleni implements ApstraktniDomenskiObjekat {
    
    private int idZaposleni;
    private String ime;
    private String drzavljanstvo;
    private String cv;
    private String username;
    private String password;

    public Zaposleni() {
    }

    public Zaposleni(int idZaposleni, String ime, String drzavljanstvo, String cv, String username, String password) {
        this.idZaposleni = idZaposleni;
        this.ime = ime;
        this.drzavljanstvo = drzavljanstvo;
        this.cv = cv;
        this.username = username;
        this.password = password;
    }

    

    public int getIdZaposleni() {
        return idZaposleni;
    }

    public void setIdZaposleni(int idZaposleni) {
        this.idZaposleni = idZaposleni;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getDrzavljanstvo() {
        return drzavljanstvo;
    }

    public void setDrzavljanstvo(String drzavljanstvo) {
        this.drzavljanstvo = drzavljanstvo;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    @Override
    public String toString() {
        return ime;
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
        final Zaposleni other = (Zaposleni) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }

    

    @Override
    public String vratiNazivTabele() {
        return "zaposleni";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        
        while (rs.next()) {            
            int idZ = rs.getInt("zaposleni.idZaposleni");
            String imeZ = rs.getString("zaposleni.ime");
            String drzavljanstvoZ = rs.getString("zaposleni.drzavljanstvo");
            String cvZ = rs.getString("zaposleni.cv");
            String usernameZ = rs.getString("zaposleni.username");
            String passwordZ = rs.getString("zaposleni.password");
            
            Zaposleni z = new Zaposleni(idZ, imeZ, drzavljanstvoZ, cvZ, usernameZ, passwordZ);
            lista.add(z);
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ime, drzavljanstvo, cv, username, password";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + ime + "', '" + drzavljanstvo + "', '" + cv + "', '" + username + "', '" + password + "'" ;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "zaposleni.idZaposleni= " + idZaposleni;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekteIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ime= '" + ime + "', drzavljanstvo= '"
                + drzavljanstvo + "', cv= '" + cv + "', username='" + username +
                "', password='" + password + "'";
                
    }
    
    
    
    
    
}
