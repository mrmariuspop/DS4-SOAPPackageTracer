
package org.assignment4clientswebservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ClientsWebServiceSoap", targetNamespace = "http://assignment4ClientsWebService.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ClientsWebServiceSoap {


    /**
     * 
     * @param password
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://assignment4ClientsWebService.org/loginWS")
    @WebResult(name = "loginWSResult", targetNamespace = "http://assignment4ClientsWebService.org/")
    @RequestWrapper(localName = "loginWS", targetNamespace = "http://assignment4ClientsWebService.org/", className = "org.assignment4clientswebservice.LoginWS")
    @ResponseWrapper(localName = "loginWSResponse", targetNamespace = "http://assignment4ClientsWebService.org/", className = "org.assignment4clientswebservice.LoginWSResponse")
    public String loginWS(
        @WebParam(name = "Username", targetNamespace = "http://assignment4ClientsWebService.org/")
        String username,
        @WebParam(name = "Password", targetNamespace = "http://assignment4ClientsWebService.org/")
        String password);

    /**
     * 
     * @param password
     * @param username
     */
    @WebMethod(action = "http://assignment4ClientsWebService.org/registerWS")
    @RequestWrapper(localName = "registerWS", targetNamespace = "http://assignment4ClientsWebService.org/", className = "org.assignment4clientswebservice.RegisterWS")
    @ResponseWrapper(localName = "registerWSResponse", targetNamespace = "http://assignment4ClientsWebService.org/", className = "org.assignment4clientswebservice.RegisterWSResponse")
    public void registerWS(
        @WebParam(name = "Username", targetNamespace = "http://assignment4ClientsWebService.org/")
        String username,
        @WebParam(name = "Password", targetNamespace = "http://assignment4ClientsWebService.org/")
        String password);

    /**
     * 
     * @param username
     * @return
     *     returns org.assignment4clientswebservice.ArrayOfTracePackage
     */
    @WebMethod(action = "http://assignment4ClientsWebService.org/getAllPackagesWS")
    @WebResult(name = "getAllPackagesWSResult", targetNamespace = "http://assignment4ClientsWebService.org/")
    @RequestWrapper(localName = "getAllPackagesWS", targetNamespace = "http://assignment4ClientsWebService.org/", className = "org.assignment4clientswebservice.GetAllPackagesWS")
    @ResponseWrapper(localName = "getAllPackagesWSResponse", targetNamespace = "http://assignment4ClientsWebService.org/", className = "org.assignment4clientswebservice.GetAllPackagesWSResponse")
    public ArrayOfTracePackage getAllPackagesWS(
        @WebParam(name = "Username", targetNamespace = "http://assignment4ClientsWebService.org/")
        String username);

    /**
     * 
     * @param packagename
     * @return
     *     returns org.assignment4clientswebservice.ArrayOfTracePackage
     */
    @WebMethod(action = "http://assignment4ClientsWebService.org/searchPackagesWS")
    @WebResult(name = "searchPackagesWSResult", targetNamespace = "http://assignment4ClientsWebService.org/")
    @RequestWrapper(localName = "searchPackagesWS", targetNamespace = "http://assignment4ClientsWebService.org/", className = "org.assignment4clientswebservice.SearchPackagesWS")
    @ResponseWrapper(localName = "searchPackagesWSResponse", targetNamespace = "http://assignment4ClientsWebService.org/", className = "org.assignment4clientswebservice.SearchPackagesWSResponse")
    public ArrayOfTracePackage searchPackagesWS(
        @WebParam(name = "Packagename", targetNamespace = "http://assignment4ClientsWebService.org/")
        String packagename);

    /**
     * 
     * @param packagename
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://assignment4ClientsWebService.org/checkPackageStatusWS")
    @WebResult(name = "checkPackageStatusWSResult", targetNamespace = "http://assignment4ClientsWebService.org/")
    @RequestWrapper(localName = "checkPackageStatusWS", targetNamespace = "http://assignment4ClientsWebService.org/", className = "org.assignment4clientswebservice.CheckPackageStatusWS")
    @ResponseWrapper(localName = "checkPackageStatusWSResponse", targetNamespace = "http://assignment4ClientsWebService.org/", className = "org.assignment4clientswebservice.CheckPackageStatusWSResponse")
    public String checkPackageStatusWS(
        @WebParam(name = "Packagename", targetNamespace = "http://assignment4ClientsWebService.org/")
        String packagename);

}
