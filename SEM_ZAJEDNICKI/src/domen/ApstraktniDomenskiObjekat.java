/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.*;
import java.util.List;

/**
 *
 * @author User
 */
public interface ApstraktniDomenskiObjekat extends Serializable {
    
    public String vratiNazivTabele();
    
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception;
    
    public String vratiKoloneZaUbacivanje();
    
    public String vratiVrednostiZaUbacivanje();
    
    public String vratiPrimarniKljuc();
    
    public ApstraktniDomenskiObjekat vratiObjekteIzRS(ResultSet rs) throws Exception;
    
    public String vratiVrednostiZaIzmenu();
    
}
