/**
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
@Table(name = "user")
public class User {

	// Identification User
	@SequenceGenerator(name = "seq", allocationSize = 1, sequenceName = "seq_user")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name = "id_user")
	@Id
	private Integer id;

	@Column(name = "nameLogin")
	private String nameLogin;

	@Column(name = "nameUser")
	private String nameUser;

	@Column(name = "description")
	private String description;

	@Column(name = "password")
	private String password;

	@Column(name = "passwordConfirm")
	private String passwordConfirm;

	/**
	 * Getters and Setters Methods
	 */

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nameLogin
	 */
	public String getNameLogin() {
		return nameLogin;
	}

	/**
	 * @param nameLogin
	 *            the nameLogin to set
	 */
	public void setNameLogin(String nameLogin) {
		this.nameLogin = nameLogin;
	}

	/**
	 * @return the nameUser
	 */
	public String getNameUser() {
		return nameUser;
	}

	/**
	 * @param nameUser
	 *            the nameUser to set
	 */
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the passwordConfirm
	 */
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	/**
	 * @param passwordConfirm
	 *            the passwordConfirm to set
	 */
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

}
