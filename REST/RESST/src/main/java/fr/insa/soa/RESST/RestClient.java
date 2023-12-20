package fr.insa.soa.RESST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class RestClient {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Demande à l'utilisateur de saisir les détails de la demande
            System.out.print("Nom du demandeur d'aide : ");
            String requesterName = scanner.nextLine();

            System.out.print("Détails de la demande : ");
            String requestDetails = scanner.nextLine();

            // Création d'une nouvelle demande
            createNewRequest(requesterName, requestDetails);

            // Demande à l'utilisateur de saisir les détails du volontaire
            System.out.println("\nDétails du volontaire :");
            System.out.print("Nom : ");
            String nom = scanner.nextLine();

            System.out.print("Prénom : ");
            String prenom = scanner.nextLine();

            System.out.print("A-t-il des antécédents judiciaires ? (true/false) : ");
            boolean aAntecedentsJudiciaires = Boolean.parseBoolean(scanner.nextLine());

            System.out.print("Âge : ");
            int age = Integer.parseInt(scanner.nextLine());

            // Création d'un nouveau volontaire
            createNewVolontaire(nom, prenom, aAntecedentsJudiciaires, age);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createNewRequest(String requesterName, String requestDetails) throws IOException {
        try {
            // URL du service REST pour créer une demande
            URL url = new URL("http://localhost:8080/RESST/webapi/requests/add");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Paramètres de la requête POST
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);

            // Données de la requête
            String data = "requesterName=" + requesterName + "&requestDetails=" + requestDetails;

            // Envoi des données
            try (OutputStream outputStream = connection.getOutputStream()) {
                outputStream.write(data.getBytes());
            }

            // Lecture de la réponse
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();
                System.out.println("Réponse du service pour la demande : " + response.toString());

                // Décision d'accepter ou rejeter la demande
                System.out.print("Voulez-vous accepter cette demande ? (Oui/Non) : ");
                Scanner decisionScanner = new Scanner(System.in);
                String decision = decisionScanner.nextLine();

                if (decision.equalsIgnoreCase("Oui")) {
                    acceptRequest(0); // Indice de la demande à accepter
                } else {
                    System.out.println("La demande a été rejetée.");
                }
            } else {
                System.out.println("Erreur : " + responseCode);
            }

            // Fermeture de la connexion
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void acceptRequest(int index) {
        try {
            // URL pour accepter une demande spécifique
            URL url = new URL("http://localhost:8080/RESST/webapi/requests/accept/" + index);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();
                System.out.println("Réponse du service pour l'acceptation : " + response.toString());
            } else {
                System.out.println("Erreur lors de l'acceptation : " + responseCode);
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createNewVolontaire(String nom, String prenom, boolean aAntecedentsJudiciaires, int age) {
        try {
            // URL du service REST pour ajouter un volontaire
            URL url = new URL("http://localhost:8080/RESST/webapi/requests/volontaires");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Paramètres de la requête POST
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);

            // Données de la requête
            String data = "nom=" + nom + "&prenom=" + prenom + "&aAntecedentsJudiciaires=" + aAntecedentsJudiciaires + "&age=" + age;

            // Envoi des données
            try (OutputStream outputStream = connection.getOutputStream()) {
                outputStream.write(data.getBytes());
            }

            // Lecture de la réponse
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();
                System.out.println("Réponse du service pour l'ajout de volontaire : " + response.toString());
            } else {
                System.out.println("Erreur lors de l'ajout de volontaire : " + responseCode);
            }

            // Fermeture de la connexion
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
