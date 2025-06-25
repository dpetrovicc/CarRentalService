/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import controller.Controller;
import domen.Kola;
import domen.Mesto;
import domen.PoslovniPartner;
import domen.Zaposleni;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Odgovor;
import komunikacija.Posiljalac;
import komunikacija.Primalac;
import komunikacija.Zahtev;

/**
 *
 * @author User
 */
public class ObradaKlijentskihZahteva extends Thread {
    Socket socket;
    Primalac primalac;
    Posiljalac posiljalac;
    boolean kraj = false;

    public ObradaKlijentskihZahteva() {
    }
    
    public ObradaKlijentskihZahteva(Socket socket) {
        this.socket = socket;
        posiljalac = new Posiljalac(socket);
        primalac = new Primalac(socket);
    }
    
    public ObradaKlijentskihZahteva(Socket socket, Primalac primalac, Posiljalac posiljalac, Runnable target) {
        super(target);
        this.socket = socket;
        this.primalac = primalac;
        this.posiljalac = posiljalac;
    }
    
    

    public ObradaKlijentskihZahteva(Socket socket, Primalac primalac, Posiljalac posiljalac) {
        this.socket = socket;
        this.primalac = primalac;
        this.posiljalac = posiljalac;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Primalac getPrimalac() {
        return primalac;
    }

    public void setPrimalac(Primalac primalac) {
        this.primalac = primalac;
    }

    public Posiljalac getPosiljalac() {
        return posiljalac;
    }

    public void setPosiljalac(Posiljalac posiljalac) {
        this.posiljalac = posiljalac;
    }
    
    

    @Override
    public void run() {
        while (!kraj) {            
            Zahtev zahtev = (Zahtev) primalac.primi();
            Odgovor odgovor = new Odgovor();
            
            switch (zahtev.getOperacija()) {
                case LOGIN:
                    Zaposleni z = (Zaposleni) zahtev.getParametar();
                    z = Controller.getInstance().login(z);
                    odgovor.setOdgovor(z);
                    System.out.println("prosao okz login");
                    break;
                case UCITAJ_KOLA:
                    List<Kola> kola = Controller.getInstance().ucitajSvaKola();
                    
                    odgovor.setOdgovor(kola);
                    System.out.println("prosao okz kola");
                    break;
                case OBRISI_KOLA:
                    try {
                    Kola k = (Kola) zahtev.getParametar();
                    Controller.getInstance().obrisiKola(k);
                    odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                    
                    break;
                case DODAJ_KOLA:
                    
                    Kola k = (Kola) zahtev.getParametar();
                    Controller.getInstance().dodajKola(k);
                    odgovor.setOdgovor(null);
                    
                    break;
                    
                case UCITAJ_PARTNERE:
                    
                    List<PoslovniPartner> partneri = Controller.getInstance().ucitajSvePartnere();
                    
                    odgovor.setOdgovor(partneri);
                    System.out.println("prosao okz partneri");
                    
                    break;
                    
                case OBRISI_PARTNERA:
                    
                    try {
                    PoslovniPartner pp = (PoslovniPartner) zahtev.getParametar();
                    Controller.getInstance().obrisiPartnera(pp);
                    odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                    
                    break;
                    
                case UCITAJ_MESTA:
                    
                    List<Mesto> mesta = Controller.getInstance().ucitajSvaMesta();
                    
                    odgovor.setOdgovor(mesta);
                    System.out.println("prosao okz mesta");
                    
                    break;
                    
                case DODAJ_PARTNERA:
                    
                    PoslovniPartner pp = (PoslovniPartner) zahtev.getParametar();
                    Controller.getInstance().dodajPartnera(pp);
                    odgovor.setOdgovor(null);
                    
                    break;
                case AZURIRAJ_PARTNERA:
                    
                    PoslovniPartner partner = (PoslovniPartner) zahtev.getParametar();
                    Controller.getInstance().azurirajPartnera(partner);
                    odgovor.setOdgovor(null);
                    
                    break;
                default:
                    System.out.println("Greska switch default");;
            }
            posiljalac.posalji(odgovor);
        }
    }
    
    public void prekini(){
        kraj = true;
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        interrupt();
    }
    
    
    
}
