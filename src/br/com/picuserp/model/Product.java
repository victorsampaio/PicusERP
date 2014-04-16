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
@Table(name ="product")
public class Product {
	
	// Identification product
	@SequenceGenerator(name = "seq", allocationSize = 1, sequenceName = "seq_product")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name = "id_product")
	@Id
	private Integer id;

	// Id, name,description - barCod
	// manufactorer - 
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "description")
	private String description;
	
	@Column (name = "barCod")
	private int barCod;
	
	@Column (name= "manufacturer")
	private String manufacturer;
	
	
}
