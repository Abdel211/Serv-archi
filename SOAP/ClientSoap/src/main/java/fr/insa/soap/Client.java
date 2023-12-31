package fr.insa.soap;

import fr.insa.soap.wsdltojava.AddRequest;
import fr.insa.soap.wsdltojava.AddRequestService;

import java.net.URL;

public class Client {

    public static void main(String[] args) {
        try {
            // URL du WSDL du service web
            URL url = new URL("http://localhost:8090/AddRequest?wsdl");

            // Cr�ez une instance du service web en utilisant l'URL du WSDL
            AddRequestService service = new AddRequestService(url);

            
            AddRequest port = service.getAddRequestPort();

           
            String requesterName = "Abdel Amine";
            String requestDetails = "Details of the request";

            String response = port.addNewRequest(requesterName, requestDetails);

            
            System.out.println("Response from server: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
