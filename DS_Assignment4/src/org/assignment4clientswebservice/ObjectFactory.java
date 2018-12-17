
package org.assignment4clientswebservice;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.assignment4clientswebservice package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.assignment4clientswebservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllPackagesWS }
     * 
     */
    public GetAllPackagesWS createGetAllPackagesWS() {
        return new GetAllPackagesWS();
    }

    /**
     * Create an instance of {@link GetAllPackagesWSResponse }
     * 
     */
    public GetAllPackagesWSResponse createGetAllPackagesWSResponse() {
        return new GetAllPackagesWSResponse();
    }

    /**
     * Create an instance of {@link ArrayOfTracePackage }
     * 
     */
    public ArrayOfTracePackage createArrayOfTracePackage() {
        return new ArrayOfTracePackage();
    }

    /**
     * Create an instance of {@link LoginWS }
     * 
     */
    public LoginWS createLoginWS() {
        return new LoginWS();
    }

    /**
     * Create an instance of {@link RegisterWS }
     * 
     */
    public RegisterWS createRegisterWS() {
        return new RegisterWS();
    }

    /**
     * Create an instance of {@link SearchPackagesWSResponse }
     * 
     */
    public SearchPackagesWSResponse createSearchPackagesWSResponse() {
        return new SearchPackagesWSResponse();
    }

    /**
     * Create an instance of {@link SearchPackagesWS }
     * 
     */
    public SearchPackagesWS createSearchPackagesWS() {
        return new SearchPackagesWS();
    }

    /**
     * Create an instance of {@link CheckPackageStatusWSResponse }
     * 
     */
    public CheckPackageStatusWSResponse createCheckPackageStatusWSResponse() {
        return new CheckPackageStatusWSResponse();
    }

    /**
     * Create an instance of {@link LoginWSResponse }
     * 
     */
    public LoginWSResponse createLoginWSResponse() {
        return new LoginWSResponse();
    }

    /**
     * Create an instance of {@link CheckPackageStatusWS }
     * 
     */
    public CheckPackageStatusWS createCheckPackageStatusWS() {
        return new CheckPackageStatusWS();
    }

    /**
     * Create an instance of {@link RegisterWSResponse }
     * 
     */
    public RegisterWSResponse createRegisterWSResponse() {
        return new RegisterWSResponse();
    }

    /**
     * Create an instance of {@link TracePackage }
     * 
     */
    public TracePackage createTracePackage() {
        return new TracePackage();
    }

}
