/**
 * Portuguese:
 * Modelo -> É a camada que mantém o estado da aplicação, os dados que são transitados e apresentados para o usuário.
 * Representa os objetos de negócio e executa uma lógica de negócio ao receber os dados vindos da camada de visualização.
 * A camada de acesso a dados. Isso pode ser acesso direto aos dados, serviços web, etc
 * 
 * English: 
 * Model -> The data access layer. This can be direct data access, web services, etc
 * Client - Model - Access to Client data.
 * 
 */
package br.com.picuserp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Victor Sampaio
 *
 */
@Entity
@Table(name = "Client")
public class Client {

	// Identification client
	@SequenceGenerator(name = "seq", allocationSize = 1, sequenceName = "seq_client")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name = "id_client")
	@Id
	private Integer id;
	
	@Column(name = "socialName")
	private String socialName;
	
	@Column (name = "fantasyName")
	private String fantasyName;
	
	@Column (name = "branchActivity")
	private String branchActivity;
	
	// Localization Client
	@Column (name="phone")
	private String phone;
	
	@Column (name ="uf")
	private String uf;
	
	@Column (name = "city")
	private String city;
	
	@Column (name = "address")
	private String address;
	
	@Column (name = "addressNumber")
	private String addressNumber;
	
	// neighberhood -> bairro
	@Column (name = "neighberhood")
	private String neighberhood;
	
	@Column (name = "cepCod")
	private String cepCod;
	
	//Contact
	@Column (name = "contactName")
	private String contactName;
	
	@Column (name = "email")
	private String email;
	
	@Column (name = "phoneFax")
	private String phoneFax;
	//
	//
	/**
	 * Methods Gets and Sets 
	 **/

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the socialName
	 */
	public String getSocialName() {
		return socialName;
	}

	/**
	 * @param socialName the socialName to set
	 */
	public void setSocialName(String socialName) {
		this.socialName = socialName;
	}

	/**
	 * @return the fantasyName
	 */
	public String getFantasyName() {
		return fantasyName;
	}

	/**
	 * @param fantasyName the fantasyName to set
	 */
	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}

	/**
	 * @return the branchActivity
	 */
	public String getBranchActivity() {
		return branchActivity;
	}

	/**
	 * @param branchActivity the branchActivity to set
	 */
	public void setBranchActivity(String branchActivity) {
		this.branchActivity = branchActivity;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * @param uf the uf to set
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the addressNumber
	 */
	public String getAddressNumber() {
		return addressNumber;
	}

	/**
	 * @param addressNumber the addressNumber to set
	 */
	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	/**
	 * @return the neighberhood
	 */
	public String getNeighberhood() {
		return neighberhood;
	}

	/**
	 * @param neighberhood the neighberhood to set
	 */
	public void setNeighberhood(String neighberhood) {
		this.neighberhood = neighberhood;
	}

	/**
	 * @return the cepCod
	 */
	public String getCepCod() {
		return cepCod;
	}

	/**
	 * @param cepCod the cepCod to set
	 */
	public void setCepCod(String cepCod) {
		this.cepCod = cepCod;
	}

	/**
	 * @return the contactName
	 */
	public String getContactName() {
		return contactName;
	}

	/**
	 * @param contactName the contactName to set
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phoneFax
	 */
	public String getPhoneFax() {
		return phoneFax;
	}

	/**
	 * @param phoneFax the phoneFax to set
	 */
	public void setPhoneFax(String phoneFax) {
		this.phoneFax = phoneFax;
	}
	
	
	
	
	
}
