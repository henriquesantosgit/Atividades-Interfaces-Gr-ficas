package br.edu.fatecpg.gui.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.fatecpg.gui.model.CadastroForm;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;

public class Main extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txt_nome;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblBemVindo = new JLabel("Bem Vindo!");
        lblBemVindo.setFont(new Font("Bitstream Charter", Font.BOLD, 16));
        lblBemVindo.setBounds(27, 12, 230, 15);
        contentPane.add(lblBemVindo);

      
        txt_nome = new JTextField();
        txt_nome.setBounds(27, 39, 114, 19);
        contentPane.add(txt_nome);
        txt_nome.setColumns(10);

    
        JSpinner idade = new JSpinner();
        idade.setBounds(27, 70, 66, 25);
        contentPane.add(idade);

    
        JRadioButton radio_masc = new JRadioButton("Masculino");
        radio_masc.setBounds(27, 109, 149, 23);
        contentPane.add(radio_masc);

        JRadioButton radio_fem = new JRadioButton("Feminino");
        radio_fem.setBounds(27, 136, 149, 23);
        contentPane.add(radio_fem);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radio_masc);
        grupo.add(radio_fem);

   
        JButton btn_enviar = new JButton("Enviar");
        btn_enviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                String nome = txt_nome.getText();
                int idadeValor = (Integer) idade.getValue();
                String sexo = radio_masc.isSelected() ? "Masculino" : (radio_fem.isSelected() ? "Feminino" : null);

               
                if (nome.isEmpty() || sexo == null || idadeValor <= 0) {
                    JOptionPane.showMessageDialog(btn_enviar, "Preencha todos os campos corretamente!");
                } else {
                   
                    CadastroForm cadastro = new CadastroForm(nome, idadeValor, sexo);

                    JOptionPane.showMessageDialog(btn_enviar, cadastro.exibirResumo());
                    lblBemVindo.setText("Bem Vindo, " + nome);
                }
            }
        });
        btn_enviar.setBounds(27, 165, 117, 25);
        contentPane.add(btn_enviar);
    }
}
