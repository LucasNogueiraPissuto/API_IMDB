/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author lucas
 */
public class Conteudo {
    private final String titulo;
    private final String urlImagem;

    public Conteudo(String titulo, String urlImagem) {
        this.titulo = titulo;
        this.urlImagem = urlImagem;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public String getUrlImagem() {
        return urlImagem;
    }   
    
}
