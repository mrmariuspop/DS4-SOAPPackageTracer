
package org.assignment4clientswebservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getAllPackagesWSResult" type="{http://assignment4ClientsWebService.org/}ArrayOfTracePackage" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getAllPackagesWSResult"
})
@XmlRootElement(name = "getAllPackagesWSResponse")
public class GetAllPackagesWSResponse {

    protected ArrayOfTracePackage getAllPackagesWSResult;

    /**
     * Gets the value of the getAllPackagesWSResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTracePackage }
     *     
     */
    public ArrayOfTracePackage getGetAllPackagesWSResult() {
        return getAllPackagesWSResult;
    }

    /**
     * Sets the value of the getAllPackagesWSResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTracePackage }
     *     
     */
    public void setGetAllPackagesWSResult(ArrayOfTracePackage value) {
        this.getAllPackagesWSResult = value;
    }

}
