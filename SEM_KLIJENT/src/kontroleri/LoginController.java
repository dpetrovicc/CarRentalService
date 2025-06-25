/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import cordinator.Cordinator;
import domen.Zaposleni;
import forme.LoginForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author User
 */
public class LoginController {
    private final LoginForma lf;

    public LoginController(LoginForma lf) {
        this.lf = lf;
        addActionListeners();
    }

    private void addActionListeners() {
        lf.loginAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prijava(e);
            }

            private void prijava(ActionEvent e) {
                String username = lf.getjTextFieldUsername().getText().trim();
                String password = String.valueOf(lf.getjPasswordField1().getPassword());
                
                Komunikacija.getInstance().konekcija();
                Zaposleni ulogovani = Komunikacija.getInstance().login(username, password);
                
                if(ulogovani == null){
                    JOptionPane.showMessageDialog(lf, "Nema tog zaposlenog u bazi", "Neuspesno logovanje", JOptionPane.ERROR_MESSAGE);
                }else{
                    Cordinator.getInstance().setUlogovani(ulogovani);
                    JOptionPane.showMessageDialog(lf, "Uspesno ste se prijavili", "Uspesno logovanje", JOptionPane.INFORMATION_MESSAGE);
                    Cordinator.getInstance().otvoriGF();
                    lf.dispose();
                }
                
            }
        });
    }

    public void otvoriFormu() {
        lf.setVisible(true);
    }
    
    
    
    
}
