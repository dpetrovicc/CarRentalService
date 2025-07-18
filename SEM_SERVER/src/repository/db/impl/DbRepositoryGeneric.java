/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domen.ApstraktniDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;
import repository.db.DbConnectionFactory;
import repository.db.DbRepository;
import java.sql.*;

/**
 *
 * @author User
 */
public class DbRepositoryGeneric implements DbRepository<ApstraktniDomenskiObjekat> {

    @Override
    public List<ApstraktniDomenskiObjekat> getAll(ApstraktniDomenskiObjekat param, String uslov) throws Exception {
            
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        
        String upit = "SELECT * FROM " + param.vratiNazivTabele();
        if (uslov != null) {
            upit += uslov;
        }
        
        System.out.println(upit);
        
        Statement st = DbConnectionFactory.getInstance().getConnection().createStatement();
        ResultSet rs = st.executeQuery(upit);
        
        lista = param.vratiListu(rs);
        rs.close();
        st.close();
        
        return lista;
        
    }

    @Override
    public void add(ApstraktniDomenskiObjekat param) throws Exception {
        String upit = "INSERT INTO " + param.vratiNazivTabele() + " ( " + 
                param.vratiKoloneZaUbacivanje() + " ) VALUES ( " + 
                param.vratiVrednostiZaUbacivanje() + " )";
        
        System.out.println(upit);
        
        Statement st = DbConnectionFactory.getInstance().getConnection().createStatement();
        int br = st.executeUpdate(upit);
        st.close();
    }

    @Override
    public void edit(ApstraktniDomenskiObjekat param) throws Exception {
        String upit = "UPDATE " + param.vratiNazivTabele() + " SET " + 
                param.vratiVrednostiZaIzmenu() + " WHERE " + param.vratiPrimarniKljuc();
        
        System.out.println(upit);
        
        Statement st = DbConnectionFactory.getInstance().getConnection().createStatement();
        int br = st.executeUpdate(upit);
        st.close();
    }

    @Override
    public void delete(ApstraktniDomenskiObjekat param) throws Exception {
        String upit = "DELETE FROM " + param.vratiNazivTabele() + " WHERE " +
                param.vratiPrimarniKljuc();
        
        System.out.println(upit);
        
        Statement st = DbConnectionFactory.getInstance().getConnection().createStatement();
        int br = st.executeUpdate(upit);
        st.close();
    }

    @Override
    public List<ApstraktniDomenskiObjekat> getAll() {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        
        //String upit = "SELECT * FROM " + 
        
        return lista;
    }
    
}
