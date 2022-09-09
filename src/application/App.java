package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        String path = "C:\\Users\\karli\\OneDrive\\Área de Trabalho\\Cursos\\Java\\Projetos\\exercicioMap\\in.txt";

        Map<String, Integer> ballotBox = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                
                String candidate = fields[0];
                int votes = Integer.parseInt(fields[1]);

                if (ballotBox.containsKey(candidate)) {
                    votes += ballotBox.get(candidate);
                }

                ballotBox.put(candidate, votes);

                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String key : ballotBox.keySet()) {
            System.out.println(key + ": " + ballotBox.get(key));
        }
    }
}
