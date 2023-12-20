package fr.insa.mas.Help.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requests")
public class RequestController {

    private List<Request> requests = new ArrayList<>(); //  liste de demandes

    @PostMapping("/add")
    public String addNewRequest(
            @RequestParam("requesterName") String requesterName,
            @RequestParam("requestDetails") String requestDetails
    ) {
        Request newRequest = new Request(requesterName, requestDetails);
        requests.add(newRequest);

        return "Demande de " + requesterName + " ajoutée avec succès.";
    }

    @GetMapping("/all")
    public List<Request> getAllRequests() {
        // Retourne toutes les demandes présentes dans la liste
        return requests;
    }

    @PostMapping("/accept/{index}")
    public String acceptRequest(@PathVariable int index) {
        if (index >= 0 && index < requests.size()) {
            Request request = requests.get(index);
            request.setAccepted(true);
            return "La demande à l'index " + index + " a été acceptée.";
        } else {
            return "Index de demande invalide.";
        }
    }

    @PostMapping("/reject/{index}")
    public String rejectRequest(@PathVariable int index) {
        if (index >= 0 && index < requests.size()) {
            requests.remove(index);
            return "La demande à l'index " + index + " a été rejetée.";
        } else {
            return "Index de demande invalide.";
        }
    }

    @PostMapping("/status/{index}")
    public String changeRequestStatus(@PathVariable int index, @RequestParam("status") String status) {
        if (index >= 0 && index < requests.size()) {
            Request request = requests.get(index);
            request.setStatus(status);
            return "Le statut de la demande à l'index " + index + " a été mis à jour.";
        } else {
            return "Index de demande invalide.";
        }
    }

    
}

