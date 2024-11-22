
package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ViewLogin {

	private JFrame frame;
	private JTextField txtLogin;
	private JPasswordField txtSenha;

	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        	System.err.println(ex);
        }

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin window = new ViewLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewLogin() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 490, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(98, 78, 67, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(98, 103, 253, 30);
		frame.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(98, 144, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(98, 169, 253, 30);
		frame.getContentPane().add(txtSenha);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkLogin(txtLogin.getText(), new String(txtSenha.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Bem-vindo ao JavaFit!");
					
					// Abre a tela ViewPrimeiraTela ap�s login 
					ViewPrimeiraTela primeiraTela = new ViewPrimeiraTela();
                    primeiraTela.setVisible(true);
                    
                    // Fecha a janela de login
                    frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Dados inv�lidos!", "Tente novamente", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(179, 220, 88, 30);
		frame.getContentPane().add(btnNewButton);
	}

	// Parada para verificar login
	public boolean checkLogin(String login, String senha) {
		return login.equals("usuario") && senha.equals("123");
	}
}