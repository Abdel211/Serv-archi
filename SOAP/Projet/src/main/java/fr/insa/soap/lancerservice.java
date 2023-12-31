package fr.insa.soap;
import javax.xml.ws.Endpoint;

public class lancerservice {
    public static void main(String[] args) {
        lancerservice app = new lancerservice();
        app.demarrerService();
    }

    public void demarrerService() {
        // D�finir l'URL de votre service web AddUser
        String addUserURL = "http://localhost:8089/AddUser";

        // Cr�er une instance du service web AddUser
        AddUser addUserService = new AddUser();

        // Publier le service web AddUser � l'URL sp�cifi�e
        Endpoint.publish(addUserURL, addUserService);

        // Afficher un message indiquant que le service AddUser a �t� d�marr� avec succ�s
        System.out.println("Service web AddUser d�marr� avec succ�s : " + addUserURL);

        // D�finir l'URL de votre service web AddRequest
        String addRequestURL = "http://localhost:8090/AddRequest";

        // Cr�er une instance du service web AddRequest
        AddRequest addRequestService = new AddRequest();

        // Publier le service web AddRequest � l'URL sp�cifi�e
        Endpoint.publish(addRequestURL, addRequestService);

        System.out.println("Service web AddRequest d�marr� avec succ�s : " + addRequestURL);
    }
}


