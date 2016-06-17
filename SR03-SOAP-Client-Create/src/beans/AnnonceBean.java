/**
 * AnnonceBean.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package beans;

public class AnnonceBean  implements java.io.Serializable {
    private beans.AdresseBean adresse;

    private java.lang.String annonceur;

    private java.lang.String details;

    private int id;

    private java.lang.String nom;

    private java.lang.String tel;

    public AnnonceBean() {
    }

    public AnnonceBean(
           beans.AdresseBean adresse,
           java.lang.String annonceur,
           java.lang.String details,
           int id,
           java.lang.String nom,
           java.lang.String tel) {
           this.adresse = adresse;
           this.annonceur = annonceur;
           this.details = details;
           this.id = id;
           this.nom = nom;
           this.tel = tel;
    }


    /**
     * Gets the adresse value for this AnnonceBean.
     * 
     * @return adresse
     */
    public beans.AdresseBean getAdresse() {
        return adresse;
    }


    /**
     * Sets the adresse value for this AnnonceBean.
     * 
     * @param adresse
     */
    public void setAdresse(beans.AdresseBean adresse) {
        this.adresse = adresse;
    }


    /**
     * Gets the annonceur value for this AnnonceBean.
     * 
     * @return annonceur
     */
    public java.lang.String getAnnonceur() {
        return annonceur;
    }


    /**
     * Sets the annonceur value for this AnnonceBean.
     * 
     * @param annonceur
     */
    public void setAnnonceur(java.lang.String annonceur) {
        this.annonceur = annonceur;
    }


    /**
     * Gets the details value for this AnnonceBean.
     * 
     * @return details
     */
    public java.lang.String getDetails() {
        return details;
    }


    /**
     * Sets the details value for this AnnonceBean.
     * 
     * @param details
     */
    public void setDetails(java.lang.String details) {
        this.details = details;
    }


    /**
     * Gets the id value for this AnnonceBean.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this AnnonceBean.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the nom value for this AnnonceBean.
     * 
     * @return nom
     */
    public java.lang.String getNom() {
        return nom;
    }


    /**
     * Sets the nom value for this AnnonceBean.
     * 
     * @param nom
     */
    public void setNom(java.lang.String nom) {
        this.nom = nom;
    }


    /**
     * Gets the tel value for this AnnonceBean.
     * 
     * @return tel
     */
    public java.lang.String getTel() {
        return tel;
    }


    /**
     * Sets the tel value for this AnnonceBean.
     * 
     * @param tel
     */
    public void setTel(java.lang.String tel) {
        this.tel = tel;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AnnonceBean)) return false;
        AnnonceBean other = (AnnonceBean) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.adresse==null && other.getAdresse()==null) || 
             (this.adresse!=null &&
              this.adresse.equals(other.getAdresse()))) &&
            ((this.annonceur==null && other.getAnnonceur()==null) || 
             (this.annonceur!=null &&
              this.annonceur.equals(other.getAnnonceur()))) &&
            ((this.details==null && other.getDetails()==null) || 
             (this.details!=null &&
              this.details.equals(other.getDetails()))) &&
            this.id == other.getId() &&
            ((this.nom==null && other.getNom()==null) || 
             (this.nom!=null &&
              this.nom.equals(other.getNom()))) &&
            ((this.tel==null && other.getTel()==null) || 
             (this.tel!=null &&
              this.tel.equals(other.getTel())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAdresse() != null) {
            _hashCode += getAdresse().hashCode();
        }
        if (getAnnonceur() != null) {
            _hashCode += getAnnonceur().hashCode();
        }
        if (getDetails() != null) {
            _hashCode += getDetails().hashCode();
        }
        _hashCode += getId();
        if (getNom() != null) {
            _hashCode += getNom().hashCode();
        }
        if (getTel() != null) {
            _hashCode += getTel().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AnnonceBean.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://beans", "AnnonceBean"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adresse");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans", "adresse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://beans", "AdresseBean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annonceur");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans", "annonceur"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("details");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans", "details"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nom");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans", "nom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans", "tel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
