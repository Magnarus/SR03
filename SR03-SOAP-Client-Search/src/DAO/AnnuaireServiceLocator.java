/**
 * AnnuaireServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DAO;

public class AnnuaireServiceLocator extends org.apache.axis.client.Service implements DAO.AnnuaireService {

    public AnnuaireServiceLocator() {
    }


    public AnnuaireServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AnnuaireServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Annuaire
    private java.lang.String Annuaire_address = "http://localhost:8080/SR03-SOAP/services/Annuaire";

    public java.lang.String getAnnuaireAddress() {
        return Annuaire_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AnnuaireWSDDServiceName = "Annuaire";

    public java.lang.String getAnnuaireWSDDServiceName() {
        return AnnuaireWSDDServiceName;
    }

    public void setAnnuaireWSDDServiceName(java.lang.String name) {
        AnnuaireWSDDServiceName = name;
    }

    public DAO.Annuaire getAnnuaire() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Annuaire_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAnnuaire(endpoint);
    }

    public DAO.Annuaire getAnnuaire(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            DAO.AnnuaireSoapBindingStub _stub = new DAO.AnnuaireSoapBindingStub(portAddress, this);
            _stub.setPortName(getAnnuaireWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAnnuaireEndpointAddress(java.lang.String address) {
        Annuaire_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (DAO.Annuaire.class.isAssignableFrom(serviceEndpointInterface)) {
                DAO.AnnuaireSoapBindingStub _stub = new DAO.AnnuaireSoapBindingStub(new java.net.URL(Annuaire_address), this);
                _stub.setPortName(getAnnuaireWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Annuaire".equals(inputPortName)) {
            return getAnnuaire();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://DAO", "AnnuaireService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://DAO", "Annuaire"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Annuaire".equals(portName)) {
            setAnnuaireEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
