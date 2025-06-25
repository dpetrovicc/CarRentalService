/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import cordinator.Cordinator;
import domen.Kola;
import domen.Mesto;
import domen.PoslovniPartner;
import domen.Zaposleni;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Komunikacija {

    private Socket soket;
    private Posiljalac posiljalac;
    private Primalac primalac;
    private static Komunikacija instance;

    public static Komunikacija getInstance() {
        if (instance == null) {
            instance = new Komunikacija();
        }
        return instance;
    }

    private Komunikacija() {
        //soket = new Socket("localhost", 9000);
    }

    public void konekcija() {
        try {
            soket = new Socket("localhost", 9000);
            posiljalac = new Posiljalac(soket);
            primalac = new Primalac(soket);
        } catch (IOException ex) {
            System.out.println("greska sa povezivanjem servera");
        }
    }

    public Zaposleni login(String username, String password) {
        Zaposleni z = new Zaposleni();
        z.setUsername(username);
        z.setPassword(password);
        Zahtev zahtev = new Zahtev(Operacija.LOGIN, z);
        posiljalac.posalji(zahtev);
        Odgovor odg = (Odgovor) primalac.primi();
        System.out.println(odg.getOdgovor());
        z = (Zaposleni) odg.getOdgovor();
        return z;

    }

    public List<Kola> ucitajKola() {

        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_KOLA, null);
        List<Kola> kola = new ArrayList<>();
        posiljalac.posalji(zahtev);

        Odgovor odg = (Odgovor) primalac.primi();
        kola = (List<Kola>) odg.getOdgovor();

        return kola;
    }

    public void obrisiKola(Kola k) {
        Zahtev zahtev = new Zahtev(Operacija.OBRISI_KOLA, k);
        posiljalac.posalji(zahtev);

        Odgovor odg = (Odgovor) primalac.primi();
        if (odg.getOdgovor() == null) {
            System.out.println("Sistem je obrisao kola");
        } else {
            System.out.println("Sistem ne može da obriše kola");
            ((Exception) odg.getOdgovor()).printStackTrace();
            try {
                throw new Exception("Sistem ne može da obriše kola");
            } catch (Exception ex) {
                Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void dodajKola(Kola k) {
        Zahtev zahtev = new Zahtev(Operacija.DODAJ_KOLA, k);
        posiljalac.posalji(zahtev);

        Odgovor odg = (Odgovor) primalac.primi();

        if (odg.getOdgovor() == null) {
            System.out.println("Sistem je dodao kola");
        } else {
            System.out.println("Sistem ne može da doda kola");
            ((Exception) odg.getOdgovor()).printStackTrace();
            try {
                throw new Exception("Sistem ne može da doda kola");
            } catch (Exception ex) {
                Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<PoslovniPartner> ucitajPartnere() {
        List<PoslovniPartner> partneri = new ArrayList<>();
        
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_PARTNERE, null);
        posiljalac.posalji(zahtev);
        
        
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        partneri = (List<PoslovniPartner>) odgovor.getOdgovor();
        
        return partneri;
    }

    public void obrisiPartnera(PoslovniPartner pp) {
        Zahtev zahtev = new Zahtev(Operacija.OBRISI_PARTNERA, pp);
        posiljalac.posalji(zahtev);

        Odgovor odg = (Odgovor) primalac.primi();
        if (odg.getOdgovor() == null) {
            System.out.println("Sistem je obrisao poslovnog partnera");
        } else {
            System.out.println("Sistem ne može da obriše poslovnog partnera");
            ((Exception) odg.getOdgovor()).printStackTrace();
            try {
                throw new Exception("Sistem ne može da obriše poslovnog partnera");
            } catch (Exception ex) {
                Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Mesto> ucitajMesta() {
        List<Mesto> mesta = new ArrayList<>();
        
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_MESTA, null);
        posiljalac.posalji(zahtev);
        
        
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        mesta = (List<Mesto>) odgovor.getOdgovor();
        
        return mesta;
    }

    public void dodajPartnera(PoslovniPartner pp) {
        Zahtev z = new Zahtev(Operacija.DODAJ_PARTNERA, pp);
        posiljalac.posalji(z);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        
        if (odgovor.getOdgovor() == null) {
            System.out.println("Sistem je kreirao poslovnog partnera");
        } else {
            System.out.println("Sistem ne može da kreira poslovnog partnera");
            ((Exception) odgovor.getOdgovor()).printStackTrace();
            try {
                throw new Exception("Sistem ne može da kreira poslovnog partnera");
            } catch (Exception ex) {
                Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }

    public void azurirajPartnera(PoslovniPartner pp) {
        Zahtev z = new Zahtev(Operacija.AZURIRAJ_PARTNERA, pp);
        posiljalac.posalji(z);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        
        if (odgovor.getOdgovor() == null) {
            System.out.println("Sistem je zapamtio poslovnog partnera KOMUNIKACIJA");
            Cordinator.getInstance().osveziFormu();
        } else {
            System.out.println("Sistem ne može da zapamti poslovnog partnera");
            ((Exception) odgovor.getOdgovor()).printStackTrace();
            try {
                throw new Exception("Sistem ne može da zapamti poslovnog partnera");
            } catch (Exception ex) {
                Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    

}
