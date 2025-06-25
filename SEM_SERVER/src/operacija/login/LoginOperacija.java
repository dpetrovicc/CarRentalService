/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.login;

import domen.Zaposleni;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import operacija.ApstraktnaGenerickaOperacija;
import repository.Repository;

/**
 *
 * @author User
 */
public class LoginOperacija extends ApstraktnaGenerickaOperacija {

    Zaposleni zaposleni;

    @Override
    protected void preduslovi(Object param) {
        
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) {
        try {
            List<Zaposleni> sviZaposleni = broker.getAll((Zaposleni) param, null);
            System.out.println("LoginOperacija: " + sviZaposleni);
            
            for (Zaposleni z : sviZaposleni) {
                if (z.equals((Zaposleni)param)) {
                    zaposleni = z;
                    return;
                }
            }
            //zaposleni = null;
            
        } catch (Exception ex) {
            Logger.getLogger(LoginOperacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }
    
    
    
}
