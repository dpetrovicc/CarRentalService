/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import cordinator.Cordinator;
import domen.Kola;
import domen.Zaposleni;
import forme.DodajKolaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author User
 */
public class DodajKolaController {
    
    private final DodajKolaForma dkf;

    public DodajKolaController(DodajKolaForma dkf) {
        this.dkf = dkf;
        addActionListener();
    }
    
    public void otvoriFormu(){
        dkf.setVisible(true);
    }

    private void addActionListener() {
        dkf.dodajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodaj(e);
            }

            private void dodaj(ActionEvent e) {
                String marka = dkf.getjTextFieldMarka1().getText().trim();
                String model = dkf.getjTextFieldModel().getText().trim();
                double cena = Double.parseDouble(dkf.getjTextFieldCena().getText());
                double kilometraza = Double.parseDouble(dkf.getjTextFieldKilometraza().getText());

                
                
                Kola k = new Kola(-1, marka, model, cena, kilometraza);
                

                try {
                    Komunikacija.getInstance().dodajKola(k);
                    JOptionPane.showMessageDialog(dkf, "Sistem je dodao kola", "Uspešno", JOptionPane.INFORMATION_MESSAGE);
                    dkf.dispose();
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dkf, "Sistem ne može da doda kola", "Greska", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
    }
    
    
    
    
    
}
