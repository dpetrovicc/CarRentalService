/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cordinator;

import domen.Zaposleni;
import forme.DodajKolaForma;
import forme.DodajPartneraForma;
import forme.FormaMod;
import forme.GlavnaForma;
import forme.LoginForma;
import forme.PrikazKolaForma;
import forme.PrikazPoslovniPartnerForma;
import java.util.HashMap;
import java.util.Map;
import kontroleri.DodajKolaController;
import kontroleri.DodajPartneraController;
import kontroleri.GlavnaFormaController;
import kontroleri.LoginController;
import kontroleri.PrikazKolaController;
import kontroleri.PrikazPoslovniPartnerController;

/**
 *
 * @author User
 */
public class Cordinator {
    
    private Zaposleni ulogovani;
    
    private static Cordinator instance;
    private GlavnaFormaController gfController;
    private LoginController loginController;
    private PrikazKolaController pkController;
    private DodajKolaController dkController;
    private PrikazPoslovniPartnerController pppController;
    private DodajPartneraController dpController;
    private Map<String, Object> parametri;
    
    public static Cordinator getInstance(){
        if (instance == null) {
            instance = new Cordinator();
        }
        return instance;
    }
    
    
    private Cordinator() {
        parametri = new HashMap<>();
    }

    public Zaposleni getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(Zaposleni ulogovani) {
        this.ulogovani = ulogovani;
    }
    
    

    public void otvoriLoginFormu() {
        loginController = new LoginController(new LoginForma());
        loginController.otvoriFormu();
    }

    public void otvoriGF() {
        gfController = new GlavnaFormaController(new GlavnaForma());
        gfController.otvoriFormu();
    }

    public void otvoriPrikazKolaFormu() {
        pkController = new PrikazKolaController(new PrikazKolaForma());
        pkController.otvoriFormu();
    }

    public void otvoriDodajKolaFormu() {
        dkController = new DodajKolaController(new DodajKolaForma());
        dkController.otvoriFormu();
    }

    public void otvoriPrikazPoslovniPartnerFormu() {
        pppController = new PrikazPoslovniPartnerController(new PrikazPoslovniPartnerForma());
        pppController.otvoriFormu();
    }

    public void otvoriDodajPartneraFormu() {
        dpController = new DodajPartneraController(new DodajPartneraForma());
        dpController.otvoriFormu(FormaMod.DODAJ);
    }

    public void dodajParametar(String s, Object o){
        parametri.put(s, o);
    }
    
    public Object vratiParametar(String s){
        return parametri.get(s);
    }

    public void otvoriAzurirajPartneraFormu() {
        dpController = new DodajPartneraController(new DodajPartneraForma());
        dpController.otvoriFormu(FormaMod.AZURIRAJ);
    }

    public void osveziFormu() {
        pppController.osveziFormu();
    }
    
    
}
