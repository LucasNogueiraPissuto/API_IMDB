package api_imdb;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    
    
    public void Cria() throws IOException{
        BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme.jpg"));
        
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);
        
        ImageIO.write(novaImagem, "png", new File("saida/filme"));
        
        novaImagem.getGraphics();
    }
    
    public static void main(String[] args) throws IOException{
        var geradora = new GeradoraDeFigurinhas();
        geradora.Cria();
    }
}
