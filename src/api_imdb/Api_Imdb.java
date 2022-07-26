package api_imdb;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import entities.JsonParser;
import entities.ClientHttp;
import entities.Conteudo;
import entities.ExtratorConteudoImdb;
import entities.ExtratorConteudoNasa;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;
import entities.GeradoraDeFigurinhas;
import java.io.InputStream;
import java.net.URL;

public class Api_Imdb {

    public static void main(String[] args) throws Exception {
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        ExtratorConteudoImdb extrator = new ExtratorConteudoImdb();

        var http = new ClientHttp();
        String json = http.buscaDados(url);

        // exibir e manipular os dados 
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            geradora.Cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }
}
