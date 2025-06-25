/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import cordinator.Cordinator;
import domen.Mesto;
import domen.PoslovniPartner;
import forme.DodajPartneraForma;
import forme.FormaMod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author User
 */
public class DodajPartneraController {
    
    private final DodajPartneraForma dpf;

    public DodajPartneraController(DodajPartneraForma dpf) {
        this.dpf = dpf;
        addActionListener();
    }
    
    

    
    
    public void otvoriFormu(FormaMod mod){
        pripremiFormu(mod);
        dpf.setVisible(true);
    }

    private void addActionListener() {
        
        dpf.dodajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodaj(e);
            }

            private void dodaj(ActionEvent e) {
                String imePrezime = dpf.getjTextFieldimePrezime().getText().trim();
                Mesto m = (Mesto) dpf.getjComboBoxMesta().getSelectedItem();
                
                PoslovniPartner pp = new PoslovniPartner(-1, imePrezime, m);
                
                try {
                    Komunikacija.getInstance().dodajPartnera(pp);
                    JOptionPane.showMessageDialog(dpf, "Sistem je kreirao poslovnog partnera", "Uspešno", JOptionPane.INFORMATION_MESSAGE);
                    dpf.dispose();
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dpf, "Sistem ne može da kreira poslovnog partnera", "Greska", JOptionPane.ERROR_MESSAGE);
                }
                
                
                
            }
        });
        
        dpf.azurirajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                azuriraj(e);
            }

            private void azuriraj(ActionEvent e) {
                int id = Integer.parseInt(dpf.getjTextFieldID().getText());
                String imePrezime = dpf.getjTextFieldimePrezime().getText().trim();
                Mesto m = (Mesto) dpf.getjComboBoxMesta().getSelectedItem();
                
                PoslovniPartner pp = new PoslovniPartner(id, imePrezime, m);
                
                try {
                    System.out.println("Ovo je poslovni partner u dodajPartneraController");
                    System.out.println(pp);
                    Komunikacija.getInstance().azurirajPartnera(pp);
                    JOptionPane.showMessageDialog(dpf, "Sistem je zapamtio poslovnog partnera", "Uspešno", JOptionPane.INFORMATION_MESSAGE);
                    dpf.dispose();
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dpf, "Sistem ne može da zapamti poslovnog partnera", "Greska", JOptionPane.ERROR_MESSAGE);
                }
                
                
                
            }
        });
        
    }

    private void pripremiFormu(FormaMod mod) {
        List<Mesto> mesta = Komunikacija.getInstance().ucitajMesta();
        System.out.println("Lista mssta dpc: " + mesta);
        for (Mesto m : mesta) {
            dpf.getjComboBoxMesta().addItem(m);
        }
        
        switch (mod) {
            case DODAJ:
                dpf.getjButtonAzuriraj().setVisible(false);
                dpf.getjTextFieldID().setVisible(false);
                break;
            case AZURIRAJ:
                dpf.getjButtonDodaj().setVisible(false);
                PoslovniPartner pp = (PoslovniPartner) Cordinator.getInstance().vratiParametar("poslovniPartner");
                dpf.getjTextFieldID().setText(String.valueOf(pp.getIdPoslovniPartner()));
                dpf.getjTextFieldimePrezime().setText(pp.getImePrezime());
                dpf.getjComboBoxMesta().setSelectedItem(pp.getMesto());
                break;
            default:
                throw new AssertionError();
        }

    }
    
    
    
}
