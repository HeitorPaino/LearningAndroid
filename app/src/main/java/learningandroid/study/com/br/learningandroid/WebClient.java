package learningandroid.study.com.br.learningandroid;

import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by heitorpaino on 2/28/18.
 */

public class WebClient {
    public String post(String json){
        try {
            URL url = new URL("https://www.caelum.com.br/mobile");
            HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
            connection.setRequestProperty("Content-Type", "application-json");
            connection.setRequestProperty("Accept", "application-json");
            connection.setDoOutput(true);

            PrintStream output = new PrintStream(connection.getOutputStream());
            output.println(json);

            connection.connect();

            Scanner scanner = new Scanner(connection.getInputStream());

            String resposta = scanner.next();

            return resposta;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
