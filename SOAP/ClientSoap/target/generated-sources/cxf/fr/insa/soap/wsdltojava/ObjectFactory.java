
package fr.insa.soap.wsdltojava;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.insa.soap.wsdltojava package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddNewRequest_QNAME = new QName("http://soap.insa.fr/", "addNewRequest");
    private final static QName _AddNewRequestResponse_QNAME = new QName("http://soap.insa.fr/", "addNewRequestResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.insa.soap.wsdltojava
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddNewRequest }
     * 
     */
    public AddNewRequest createAddNewRequest() {
        return new AddNewRequest();
    }

    /**
     * Create an instance of {@link AddNewRequestResponse }
     * 
     */
    public AddNewRequestResponse createAddNewRequestResponse() {
        return new AddNewRequestResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNewRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddNewRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.insa.fr/", name = "addNewRequest")
    public JAXBElement<AddNewRequest> createAddNewRequest(AddNewRequest value) {
        return new JAXBElement<AddNewRequest>(_AddNewRequest_QNAME, AddNewRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNewRequestResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddNewRequestResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.insa.fr/", name = "addNewRequestResponse")
    public JAXBElement<AddNewRequestResponse> createAddNewRequestResponse(AddNewRequestResponse value) {
        return new JAXBElement<AddNewRequestResponse>(_AddNewRequestResponse_QNAME, AddNewRequestResponse.class, null, value);
    }

}
