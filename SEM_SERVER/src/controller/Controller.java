/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Kola;
import domen.Mesto;
import domen.PoslovniPartner;
import domen.Zaposleni;
import java.util.List;
import operacija.kola.DodajKolaSO;
import operacija.kola.ObrisiKolaSO;
import operacija.kola.UcitajKolaSO;
import operacija.login.LoginOperacija;
import operacija.mesto.UcitajMestaSO;
import operacija.partner.AzurirajPartneraSO;
import operacija.partner.DodajPartneraSO;
import operacija.partner.ObrisiPartneraSO;
import operacija.partner.UcitajPartnereSO;

/**
 *
 * @author User
 */
public class Controller {
    
    private static Controller instance;
    public static Controller getInstance(){
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    private Controller() {
    }

    public Zaposleni login(Zaposleni z) {
        LoginOperacija lo = new LoginOperacija();
        lo.izvrsi(z, null);
        System.out.println("Controller provera: " + lo.getZaposleni());
        return lo.getZaposleni();
    }

    public List<Kola> ucitajSvaKola() {
        UcitajKolaSO uk = new UcitajKolaSO();
        uk.izvrsi(null, null);
        System.out.println("Sva kola controller: " + uk.getSvaKola());
        return uk.getSvaKola();
    }

    public void obrisiKola(Kola k) {
        ObrisiKolaSO ok = new ObrisiKolaSO();
        ok.izvrsi(k, null);
        
    }

    public void dodajKola(Kola k) {
        
        DodajKolaSO dks = new DodajKolaSO();
        dks.izvrsi(k, null);
        
    }

    public List<PoslovniPartner> ucitajSvePartnere() {
        UcitajPartnereSO up = new UcitajPartnereSO();
        up.izvrsi(null, null);
        System.out.println("Svi partneri controller: " + up.getSviPartneri());
        return up.getSviPartneri();
    }

    public void obrisiPartnera(PoslovniPartner pp) {
        ObrisiPartneraSO op = new ObrisiPartneraSO();
        op.izvrsi(pp, null);
    }

    public List<Mesto> ucitajSvaMesta() {
        UcitajMestaSO um = new UcitajMestaSO();
        um.izvrsi(null, null);
        System.out.println("Sva mesta controller: " + um.getSvaMesta());
        return um.getSvaMesta();
    }

    public void dodajPartnera(PoslovniPartner pp) {
        
        DodajPartneraSO dp = new DodajPartneraSO();
        dp.izvrsi(pp, null);
        
    }

    public void azurirajPartnera(PoslovniPartner partner) {
        AzurirajPartneraSO ap = new AzurirajPartneraSO();
        ap.izvrsi(partner, null);
    }
    
    
    
}
