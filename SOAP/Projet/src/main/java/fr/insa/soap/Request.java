package fr.insa.soap;

public class Request {
    private String requesterName;
    private String requestDetails;
    
    public Request(String requesterName, String requestDetails) {
        this.requesterName = requesterName;
        this.requestDetails = requestDetails;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public String getRequestDetails() {
        return requestDetails;
    }

    public void setRequestDetails(String requestDetails) {
        this.requestDetails = requestDetails;
    }
}
