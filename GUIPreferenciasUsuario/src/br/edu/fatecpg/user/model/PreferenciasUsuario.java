package br.edu.fatecpg.user.model;

public class PreferenciasUsuario {
    private String tema;
    private boolean notificacoes; 
    private int volume;           

    
    public PreferenciasUsuario() {
        this.tema = "Claro"; 
        this.notificacoes = true; 
        this.volume = 50; 
    }

    
    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public boolean isNotificacoes() {
        return notificacoes;
    }

    public void setNotificacoes(boolean notificacoes) {
        this.notificacoes = notificacoes;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    
    public String exibirPreferencias() {
        return "Tema: " + tema + "\n" +
               "Notificações: " + (notificacoes ? "Habilitadas" : "Desabilitadas") + "\n" +
               "Volume: " + volume;
    }
}
