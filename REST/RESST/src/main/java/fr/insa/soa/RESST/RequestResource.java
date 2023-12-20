package fr.insa.soa.RESST;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("requests")
public class RequestResource {

    private static List<Request> requests = new ArrayList<>();
    private static List<Volontaire> volontaires = new ArrayList<>(); // Liste des volontaires

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String addNewRequest(
            @FormParam("requesterName") String requesterName,
            @FormParam("requestDetails") String requestDetails
    ) {
        // Créer une nouvelle demande
        Request newRequest = new Request(requesterName, requestDetails);

        // Ajouter la demande à la liste statique
        requests.add(newRequest);

        // Retourner un message de confirmation
        return "Demande de " + requesterName + " ajoutée avec succès.";
    }

    @POST
    @Path("accept/{index}")
    public String acceptRequest(@PathParam("index") int index) {
        if (index >= 0 && index < requests.size()) {
            Request request = requests.get(index);
            request.setAccepted(true);
            return "La demande à l'index " + index + " a été acceptée.";
        } else {
            return "Index de demande invalide.";
        }
    }

    @POST
    @Path("volontaires")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String addVolontaire(
            @FormParam("nom") String nom,
            @FormParam("prenom") String prenom,
            @FormParam("aAntecedentsJudiciaires") boolean aAntecedentsJudiciaires,
            @FormParam("age") int age
    ) {
        // Créer un nouveau volontaire
        Volontaire nouveauVolontaire = new Volontaire(nom, prenom, aAntecedentsJudiciaires, age);

        

        // Logique pour accepter ou refuser le volontaire en fonction de certains critères
        if (aAntecedentsJudiciaires || age < 18) {
            return "Le volontaire n'est pas accepté pour raisons de conformités";
        }
        else {
        	// Ajouter le volontaire à la liste des volontaires
            volontaires.add(nouveauVolontaire);
        }
        // Retourner un message de confirmation si le volontaire est accepté
        return "Le volontaire a été accepté.";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllRequests() {
        StringBuilder response = new StringBuilder();
        response.append("Liste des demandes d'aide :").append(System.lineSeparator());
        for (Request request : requests) {
            response.append(request).append(System.lineSeparator());
        }
        response.append(System.lineSeparator());
        response.append("Liste des volontaires :").append(System.lineSeparator());
        for (Volontaire volontaire : volontaires) {
            response.append(volontaire).append(System.lineSeparator());
        }
        return response.toString();
    }
}
