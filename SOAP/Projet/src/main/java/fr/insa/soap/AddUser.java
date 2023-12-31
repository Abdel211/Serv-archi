package fr.insa.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public class AddUser {

    private List<User> usersRequestingHelp;

    public AddUser() {
    	usersRequestingHelp = new ArrayList<User>();

    }

    @WebMethod
    public String addUserRequestHelp(
        @WebParam(name = "username") String username,
        @WebParam(name = "email") String email,
        @WebParam(name = "requestDetails") String requestDetails
    ) {
        // Cr�er un nouvel utilisateur demandant de l'aide
        User newUser = new User(username, email, requestDetails);

        // Ajouter l'utilisateur � la liste
        usersRequestingHelp.add(newUser);

        // Retourner un message de confirmation
        return "Utilisateur " + username + " ajout� avec succ�s pour demander de l'aide.";
    }

    // Classe interne User pour repr�senter les utilisateurs
    private class User {
        private String username;
        private String email;
        private String requestDetails;

        public User(String username, String email, String requestDetails) {
            this.username = username;
            this.email = email;
            this.requestDetails = requestDetails;
        }

       
    }
}
