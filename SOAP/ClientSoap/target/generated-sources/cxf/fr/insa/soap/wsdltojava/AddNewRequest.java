
package fr.insa.soap.wsdltojava;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour addNewRequest complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="addNewRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="requesterName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="requestDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addNewRequest", propOrder = {
    "requesterName",
    "requestDetails"
})
public class AddNewRequest {

    protected String requesterName;
    protected String requestDetails;

    /**
     * Obtient la valeur de la propriété requesterName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequesterName() {
        return requesterName;
    }

    /**
     * Définit la valeur de la propriété requesterName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequesterName(String value) {
        this.requesterName = value;
    }

    /**
     * Obtient la valeur de la propriété requestDetails.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestDetails() {
        return requestDetails;
    }

    /**
     * Définit la valeur de la propriété requestDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestDetails(String value) {
        this.requestDetails = value;
    }

}
