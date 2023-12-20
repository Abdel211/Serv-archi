package fr.insa.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.List;

@WebService
public class Twofonctions {

    private List<String> users;
    private List<String> requests;

    public Twofonctions() {
        //users = new ArrayList<>();
        //requests = new ArrayList<>();
    }

    @WebMethod
    public String addUser(@WebParam(name = "username") String username) {
        users.add(username);
        return "Utilisateur ajouté : " + username;
    }

    @WebMethod
    public String addRequest(@WebParam(name = "requestDetails") String requestDetails) {
        requests.add(requestDetails);
        return "Demande ajoutée : " + requestDetails;
    }

    public static void main(String[] args) {
        String url = "http://localhost:8089/UserService";
        Twofonctions userService = new Twofonctions();
        Endpoint.publish(url, userService);
        System.out.println("Service web UserService démarré avec succès : " + url);
    }
}
