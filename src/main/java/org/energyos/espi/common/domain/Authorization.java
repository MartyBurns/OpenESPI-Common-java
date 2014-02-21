/*
 * Copyright 2013 EnergyOS.org
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.08.27 at 01:43:57 PM EDT 
//


package org.energyos.espi.common.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.energyos.espi.common.models.atom.adapters.AuthorizationAdapter;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;


/**
 * [extension] Represents a permission granted by an owner for access to a resource.
 * 
 * Atom Links:
 * self link to this resource
 * rel corresponding ApplicationInformation (if this is the client access containing token instance)
 * rel corresponding to the authorized resource (if this is the access_token containing instance for a customer resource)
 * 
 * Note: for privacy there is no identifier of the RetailCustomer in this structure but an implementation will have consider how to maintain a correspendance between a RetailCustomer and his authorization.
 * 
 * <p>Java class for Authorization complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Authorization">
 *   &lt;complexContent>
 *     &lt;extension base="{http://naesb.org/espi}IdentifiedObject">
 *       &lt;sequence>
 *         &lt;element name="authorizedPeriod" type="{http://naesb.org/espi}DateTimeInterval" minOccurs="0"/>
 *         &lt;element name="publishedPeriod" type="{http://naesb.org/espi}DateTimeInterval" minOccurs="0"/>
 *         &lt;element name="referenceID" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="access_token" type="{http://naesb.org/espi}String512" minOccurs="0"/>
 *         &lt;element name="status" type="{http://naesb.org/espi}AuthorizationStatus" minOccurs="0"/>
 *         &lt;element name="expires_in" type="{http://naesb.org/espi}TimeType" minOccurs="0"/>
 *         &lt;element name="grant_type" type="{http://naesb.org/espi}GrantType" minOccurs="0"/>
 *         &lt;element name="refresh_token" type="{http://naesb.org/espi}String512" minOccurs="0"/>
 *         &lt;element name="scope" type="{http://naesb.org/espi}String256" minOccurs="0"/>
 *         &lt;element name="state" type="{http://naesb.org/espi}String256" minOccurs="0"/>
 *         &lt;element name="response_type" type="{http://naesb.org/espi}ResponseType" minOccurs="0"/>
 *         &lt;element name="token_type" type="{http://naesb.org/espi}TokenType" minOccurs="0"/>
 *         &lt;element name="code" type="{http://naesb.org/espi}String512" minOccurs="0"/>
 *         &lt;element name="error" type="{http://naesb.org/espi}OAuthError" minOccurs="0"/>
 *         &lt;element name="error_description" type="{http://naesb.org/espi}String256" minOccurs="0"/>
 *         &lt;element name="error_uri" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="resourceURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="authorizationURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Authorization", propOrder = {
	    "authorizedPeriod",
	    "publishedPeriod",
	    "retailCustomer",
	    "accessToken",
	    "status",
	    "expiresIn",
	    "grantType",
	    "refreshToken",
	    "scope",
	    "state",
	    "responseType",
	    "tokenType",
	    "code",
	    "error",
	    "errorDescription",
	    "errorUri",
	    "resourceURI",
	    "authorizationURI",
	    "subscriptionURI",
	    "thirdParty"
	})@Entity
@Table(name = "authorizations")
@XmlJavaTypeAdapter(AuthorizationAdapter.class)
@NamedQueries(value = {
        @NamedQuery(name = Authorization.QUERY_FIND_ALL_IDS,
                query = "SELECT authorization.id FROM Authorization authorization"),		
        @NamedQuery(name = Authorization.QUERY_FIND_BY_ID, 
        		query = "SELECT authorization FROM Authorization authorization WHERE authorization.id = :id"),
        @NamedQuery(name = Authorization.QUERY_FIND_BY_RETAIL_CUSTOMER_ID,
                query = "SELECT authorization FROM Authorization authorization WHERE authorization.retailCustomer.id = :retailCustomerId AND authorization.resourceURI IS NOT NULL"),
        @NamedQuery(name = Authorization.QUERY_FIND_BY_SCOPE,
        		query = "SELECT authorization FROM Authorization authorization WHERE authorization.scope = :scope AND authorization.retailCustomer.id = :retailCustomerId"),
        @NamedQuery(name = Authorization.QUERY_FIND_BY_STATE,
		    	query = "SELECT authorization FROM Authorization authorization WHERE authorization.state = :state"),
		@NamedQuery(name = Authorization.QUERY_FIND_BY_UUID, 
        		query = "SELECT authorization FROM Authorization authorization WHERE authorization.uuid = :uuid"),
        @NamedQuery(name = Authorization.QUERY_FIND_BY_RESOURCE_URI, 
                query = "SELECT authorization FROM Authorization authorization WHERE authorization.resourceURI = :uri")
})
public class Authorization
        extends IdentifiedObject {

    public static final String QUERY_FIND_ALL_IDS = "Authorization.findAllIds";
    public static final String QUERY_FIND_BY_ID = "Authorization.findById";
    public static final String QUERY_FIND_BY_RETAIL_CUSTOMER_ID = "Authorization.findAllByRetailCustomerId";    
	public static final String QUERY_FIND_BY_SCOPE = "Authorization.findByScope";
    public static final String QUERY_FIND_BY_STATE = "Authorization.findByState";	
	public final static String QUERY_FIND_BY_UUID = "Authorization.findByUUID";
	public static final String QUERY_FIND_BY_RESOURCE_URI = "Authorization.findByResourceUri";

    @Embedded
    @AttributeOverrides({
    	@AttributeOverride(name="start", column=@Column(name="ap_start")),
    	@AttributeOverride(name="duration", column=@Column(name="ap_duration"))
    })
    protected DateTimeInterval authorizedPeriod;

    @Embedded 
    @AttributeOverrides({
    	@AttributeOverride(name="start", column=@Column(name="pp_start")),
    	@AttributeOverride(name="duration", column=@Column(name="pp_duration"))
    })
	protected DateTimeInterval publishedPeriod;
    
    @Column(name = "access_token")
    protected String accessToken;
    
    @Column(name = "authorization_uri")
    @XmlSchemaType(name = "anyURI")
    
    protected String authorizationURI;
    @XmlSchemaType(name = "anyURI")
    
    protected String resourceURI;
    
    @Column(name = "status")
    protected String status;
    
    @Column(name = "third_party")
    protected String thirdParty;
    
    @ManyToOne @JoinColumn(name = "retail_customer_id")
    @XmlElement(name = "referenceID")
    protected RetailCustomer retailCustomer;

    @XmlElement(name = "expires_in")
    protected Long expiresIn;
    
    @XmlElement(name = "grant_type")
    protected GrantType grantType;
    
    @XmlElement(name = "refresh_token")
    protected String refreshToken;
    
    @Column(name = "scope")
    private String scope;
    
    @Column(name = "state")
    private String state;
    
    @XmlElement(name = "response_type")
    protected ResponseType responseType;
    
    @XmlElement(name = "token_type")
    protected TokenType tokenType;
    
    protected String code;
    
    @XmlElement(name = "error")
    protected OAuthError error;
    
    @XmlElement(name = "error_description")
    protected String errorDescription;
    
    @XmlElement(name = "error_uri")
    @XmlSchemaType(name = "anyURI")
    protected String errorUri;
    
    @ManyToOne @JoinColumn(name = "application_information_id")
    @XmlTransient
    private ApplicationInformation applicationInformation;
    
    private String subscriptionURI;    

    /**
     * Gets the value of the authorizedPeriod property.
     *
     * @return
     *     possible object is
     *     {@link DateTimeInterval }
     *
     */
    public DateTimeInterval getAuthorizedPeriod() {
        return authorizedPeriod;
    }

    /**
     * Sets the value of the authorizedPeriod property.
     *
     * @param value
     *     allowed object is
     *     {@link DateTimeInterval }
     *
     */
    public void setAuthorizedPeriod(DateTimeInterval value) {
        this.authorizedPeriod = value;
    }

    /**
     * Gets the value of the publishedPeriod property.
     *
     * @return
     *     possible object is
     *     {@link DateTimeInterval }
     *
     */
    public DateTimeInterval getPublishedPeriod() {
        return publishedPeriod;
    }

    /**
     * Sets the value of the publishedPeriod property.
     *
     * @param value
     *     allowed object is
     *     {@link DateTimeInterval }
     *
     */
    public void setPublishedPeriod(DateTimeInterval value) {
        this.publishedPeriod = value;
    }

    /**
     * Gets the value of the accessToken property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Sets the value of the accessToken property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAccessToken(String value) {
        this.accessToken = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the expiresIn property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getExpiresIn() {
        return expiresIn;
    }

    /**
     * Sets the value of the expiresIn property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setExpiresIn(Long value) {
        this.expiresIn = value;
    }

    /**
     * Gets the value of the grantType property.
     *
     * @return
     *     possible object is
     *     {@link GrantType }
     *
     */
    public GrantType getGrantType() {
        return grantType;
    }

    /**
     * Sets the value of the grantType property.
     *
     * @param value
     *     allowed object is
     *     {@link GrantType }
     *
     */
    public void setGrantType(GrantType value) {
        this.grantType = value;
    }

    /**
     * Sets the value of the grantType property.
     *
     * @param value
     *     allowed object is
     *     {@link GrantType }
     *
     */
    public void setGrantType(String value) {
        this.grantType = GrantType.fromValue(value);
    }
    
    /**
     * Gets the value of the resource property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getResourceURI() {
        return resourceURI;
    }

    /**
     * Sets the value of the resource property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setResourceURI(String value) {
        this.resourceURI = value;
    }

    /**
     * Gets the value of the refreshToken property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * Sets the value of the refreshToken property.
     *
     * @param oAuth2RefreshToken
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRefreshToken(String value) {
    	if(value != null) {
    		this.refreshToken = value;
    	}
    }

    /**
     * Gets the value of the scope property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getScope() {
        return scope;
    }

    /**
     * Sets the value of the scope property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setScope(String value) {
        this.scope = value;
    }

    /**
     * Gets the value of the state property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the responseType property.
     *
     * @return
     *     possible object is
     *     {@link ResponseType }
     *
     */
    public ResponseType getResponseType() {
        return responseType;
    }

    /**
     * Sets the value of the responseType property.
     *
     * @param value
     *     allowed object is
     *     {@link ResponseType }
     *
     */
    public void setResponseType(ResponseType value) {
        this.responseType = value;
    }

    /**
     * Sets the value of the responseType property.
     *
     * @param value
     *     allowed object is
     *     {@link ResponseType }
     *
     */
    public void setResponseType(String value) {
        this.responseType = ResponseType.fromValue(value);
    }    
    
    /**
     * Gets the value of the tokenType property.
     *
     * @return
     *     possible object is
     *     {@link TokenType }
     *
     */
    public TokenType getTokenType() {
        return tokenType;
    }

    /**
     * Sets the value of the tokenType property.
     *
     * @param value
     *     allowed object is
     *     {@link TokenType }
     *
     */
    public void setTokenType(TokenType value) {
        this.tokenType = value;
    }

    /**
     * Sets the value of the tokenType property.
     *
     * @param value
     *     allowed object is
     *     {@link TokenType }
     *
     */
    public void setTokenType(String value) {
        this.tokenType = TokenType.fromValue(value);
    }

    /**
     * Gets the value of the code property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the error property.
     *
     * @return
     *     possible object is
     *     {@link OAuthError }
     *
     */
    public OAuthError getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     *
     * @param value
     *     allowed object is
     *     {@link OAuthError }
     *
     */
    public void setError(OAuthError value) {
        this.error = value;
    }


    /**
     * Sets the value of the error property.
     *
     * @param value
     *     allowed object is
     *     {@link OAuthError }
     *
     */
    public void setError(String value) {
        this.error = OAuthError.fromValue(value);
    }    
    
    /**
     * Gets the value of the errorDescription property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getErrorDescription() {
        return errorDescription;
    }

    /**
     * Sets the value of the errorDescription property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setErrorDescription(String value) {
        this.errorDescription = value;
    }

    /**
     * Gets the value of the errorUri property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getErrorUri() {
        return errorUri;
    }

    /**
     * Sets the value of the errorUri property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setErrorUri(String value) {
        this.errorUri = value;
    }  
    
    public String getAuthorizationURI() {
        return authorizationURI;
    }

    public void setAuthorizationURI(String authorizationServerURI) {
        this.authorizationURI = authorizationServerURI;
    }
    
    public String getThirdParty() {
        return thirdParty;
    }

    public void setThirdParty(String thirdParty) {
        this.thirdParty = thirdParty;
    }

    public RetailCustomer getRetailCustomer() {
        return retailCustomer;
    }

    public void setRetailCustomer(RetailCustomer retailCustomer) {
        this.retailCustomer = retailCustomer;
    }

    public ApplicationInformation getApplicationInformation() {
        return applicationInformation;
    }

    public void setApplicationInformation(ApplicationInformation applicationInformation) {
        this.applicationInformation = applicationInformation;
    }

    public void setSubscriptionURI(String subscriptionURI) {
        this.subscriptionURI = subscriptionURI;
    }

    public String getSubscriptionURI() {
        return subscriptionURI;
    }

    public String getSubscriptionId() {
        String[] pieces = subscriptionURI.split("/");
        return pieces[pieces.length-1];
    }
    
    public void merge(IdentifiedObject resource) {
    	super.merge(resource);
  	  this.accessToken = ((Authorization)resource).getAccessToken();
  	  this.applicationInformation = ((Authorization)resource).getApplicationInformation();
  	  this.authorizationURI = ((Authorization)resource).authorizationURI;
  	  this.authorizedPeriod = ((Authorization)resource).getAuthorizedPeriod();
  	  this.code = ((Authorization)resource).getCode();
  	  this.description = ((Authorization)resource).getDescription();
  	  this.error = ((Authorization)resource).getError();
  	  this.errorDescription = ((Authorization)resource).getErrorDescription();
  	  this.errorUri = ((Authorization)resource).getErrorUri();
  	  this.expiresIn = ((Authorization)resource).getExpiresIn();
  	  this.grantType = ((Authorization)resource).getGrantType();
  	  this.href = ((Authorization)resource).getHref();
  	  this.publishedPeriod = ((Authorization)resource).getPublishedPeriod();
  	  this.refreshToken = ((Authorization)resource).getRefreshToken();
  	  this.replyTo = ((Authorization)resource).getReplyTo();
  	  this.resourceURI = ((Authorization)resource).getResourceURI();
  	  this.responseRequired = ((Authorization)resource).getResponseRequired();
  	  this.retailCustomer = ((Authorization)resource).getRetailCustomer();
  	  this.scope = ((Authorization)resource).getScope();
  	  this.signatureRequired = ((Authorization)resource).signatureRequired;
  	  this.state = ((Authorization)resource).getState();
  	  this.status = ((Authorization)resource).getStatus();
  	  this.subscribable = ((Authorization)resource).subscribable;
  	  this.subscriptionURI = ((Authorization)resource).getSubscriptionURI();
  	  this.thirdParty = ((Authorization)resource).getThirdParty();
  	  this.tokenType = ((Authorization)resource).getTokenType();
    }
}
