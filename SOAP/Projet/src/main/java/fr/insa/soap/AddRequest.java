package fr.insa.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public class AddRequest {

    private List<Request> requests;

    public AddRequest() {
        requests = new ArrayList<Request>(); // Modifier cette ligne
    }

    @WebMethod
    public String addNewRequest(
        @WebParam(name = "requesterName") String requesterName,
        @WebParam(name = "requestDetails") String requestDetails
    ) {
        // Créer une nouvelle demande
        Request newRequest = new Request(requesterName, requestDetails);

        // Ajouter la demande à la liste
        requests.add(newRequest);

        // Retourner un message de confirmation
        return "Demande de " + requesterName + " ajoutée avec succès.";
    }
}

