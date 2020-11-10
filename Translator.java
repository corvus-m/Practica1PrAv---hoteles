package triLazy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Translator {

    /*public static void main(String[] args) throws IOException {
        String text = "Hello world!";
        System.out.println("Translated text: " + translate("en", "es", text));
    }*/

    public static String translate(String langFrom, String langTo, String text) throws IOException {
        
        String urlStr = "https://script.google.com/macros/s/AKfycbwioWgJ8XQppNK88x6Htly6OJqih5_SSw2_BqFs-paVIxlpIXVB/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }   
    
}



