/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Kola;
import forme.PrikazKolaForma;
import forme.model.ModelTabeleKola;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author User
 */
public class PrikazKolaController {

    private final PrikazKolaForma pfk;

    public PrikazKolaController(PrikazKolaForma pfk) {
        this.pfk = pfk;
        addActionListeners();
    }

    private void addActionListeners() {
        pfk.addBtnObrisiActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = pfk.getjTableKola().getSelectedRow();
                if (red == -1) {
                    JOptionPane.showMessageDialog(pfk, "Nije selektovan red", "Greska red", JOptionPane.ERROR_MESSAGE);
                } else {
                    ModelTabeleKola mtk = (ModelTabeleKola) pfk.getjTableKola().getModel();
                    Kola k = mtk.getLista().get(red);
                    try {
                        Komunikacija.getInstance().obrisiKola(k);
                        JOptionPane.showMessageDialog(pfk, "Sistem je obrisao kola", "Uspešno", JOptionPane.INFORMATION_MESSAGE);
                        pripremiFormu();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(pfk, "Sistem ne može da obriše kola", "Greška", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });
    }

    public void otvoriFormu() {
        pripremiFormu();
        pfk.setVisible(true);
    }

    public void pripremiFormu() {
        List<Kola> kola = Komunikacija.getInstance().ucitajKola();
        System.out.println("Lista kola i prikaz kola controller: " + kola);
        ModelTabeleKola mtk = new ModelTabeleKola(kola);
        pfk.getjTableKola().setModel(mtk);

    }

}
