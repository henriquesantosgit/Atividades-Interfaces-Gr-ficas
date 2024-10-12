package br.edu.fatecpg.user.view;

import br.edu.fatecpg.user.model.PreferenciasUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private PreferenciasUsuario preferenciasUsuario; 

    
    private JComboBox<String> comboTema;
    private JCheckBox checkNotificacoes;
    private JSlider sliderVolume;
    private JTextArea textAreaPreferencias;

    public Main() {
        preferenciasUsuario = new PreferenciasUsuario(); 

        
        setTitle("Configurações de Preferências do Usuário");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

       
        JLabel lblTema = new JLabel("Tema:");
        lblTema.setBounds(30, 20, 80, 25);
        getContentPane().add(lblTema);

        
        String[] temas = {"Claro", "Escuro"};
        comboTema = new JComboBox<>(temas);
        comboTema.setBounds(100, 20, 150, 25);
        getContentPane().add(comboTema);

        
        JLabel lblNotificacoes = new JLabel("Notificações:");
        lblNotificacoes.setBounds(30, 60, 100, 25);
        getContentPane().add(lblNotificacoes);

        
        checkNotificacoes = new JCheckBox("Habilitar Notificações");
        checkNotificacoes.setBounds(140, 60, 180, 25);
        getContentPane().add(checkNotificacoes);

       
        JLabel lblVolume = new JLabel("Volume:");
        lblVolume.setBounds(30, 100, 80, 25);
        getContentPane().add(lblVolume);

    
        sliderVolume = new JSlider(0, 100);
        sliderVolume.setBounds(100, 100, 200, 50);
        sliderVolume.setPaintTicks(true);
        sliderVolume.setPaintLabels(true);
        sliderVolume.setMajorTickSpacing(20);
        sliderVolume.setMinorTickSpacing(5);
        getContentPane().add(sliderVolume);

       
        JButton btnSalvar = new JButton("Salvar Preferências");
        btnSalvar.setBounds(120, 160, 150, 30);
        getContentPane().add(btnSalvar);

       
        textAreaPreferencias = new JTextArea();
        textAreaPreferencias.setBounds(30, 200, 340, 50);
        textAreaPreferencias.setEditable(false);
        getContentPane().add(textAreaPreferencias);

    
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarPreferencias(); 
            }
        });

      
        comboTema.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                alterarTema(); 
            }
        });
    }

  
    private void salvarPreferencias() {
        String temaSelecionado = (String) comboTema.getSelectedItem();
        boolean notificacoesHabilitadas = checkNotificacoes.isSelected();
        int volumeSelecionado = sliderVolume.getValue();

        
        preferenciasUsuario.setTema(temaSelecionado);
        preferenciasUsuario.setNotificacoes(notificacoesHabilitadas);
        preferenciasUsuario.setVolume(volumeSelecionado);

       
        textAreaPreferencias.setText(preferenciasUsuario.exibirPreferencias());
    }

   
    private void alterarTema() {
        String temaSelecionado = (String) comboTema.getSelectedItem();
        if ("Escuro".equals(temaSelecionado)) {
            getContentPane().setBackground(Color.DARK_GRAY);
            textAreaPreferencias.setBackground(Color.GRAY);
            textAreaPreferencias.setForeground(Color.WHITE);
        } else {
            getContentPane().setBackground(Color.LIGHT_GRAY);
            textAreaPreferencias.setBackground(Color.WHITE);
            textAreaPreferencias.setForeground(Color.BLACK);
        }
    }

 
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
}
