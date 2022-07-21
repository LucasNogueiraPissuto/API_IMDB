package api_imdb;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import entities.JsonParser;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Api_Imdb {

    public static void main(String[] args) throws IOException, InterruptedException {
        ArrayList<String> movieNames = new ArrayList<>();
        String personalVote;
        Scanner sc = new Scanner(System.in);

        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = (HttpRequest) HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        JsonParser parser = new JsonParser();
        Map<String, String> moviesWithPersonalVote = new HashMap<String, String>();
        List<Map<String, String>> moviesList = parser.parse(body);

        System.out.println("Qual filme gostaria de dar sua nota pessoal?");
        String movieName = sc.nextLine();

        for (Map<String, String> filme : moviesList) {
            filme.put("personalVote", "None");
        }

        for (Map<String, String> filme : moviesList) {
            if (filme.get("title").equals(movieName)) {
                System.out.println("Qual sua nota para o filme " + filme.get("title") + " ?");
                personalVote = sc.nextLine();
                filme.put("personalVote", personalVote);
                System.out.println("Nota " + personalVote + " atribuida com sucesso!");
                System.out.println("---");
                System.out.println("Filmes com suas notas pessoais e notas do publico:");
                System.out.println("---");
                for (Map<String, String> filme1 : moviesList){
                    System.out.println(" ");
                    System.out.println("Titulo: " + filme1.get("title"));
                    System.out.println("Nota pessoal: " +filme1.get("personalVote"));
                    System.out.println("Nota do IMBD: " +filme1.get("imDbRating"));
                }
                break;
            } else {
                System.out.println("Filme não encontrado");
                break;
            }
            
        }

        sc.close();
    }

}
