package com.beezen.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
//import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "utilisateurs")
public class Utilisateurs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique=true)
	private String username;
	@Column(unique=true)
	private String email;
	private String password;
	private String numtel;
	private Integer codereset;
	private Date datereset;
	private String company;
	private String lastName;
	private String firstName;
	private String about;
	private String post;
	private String icon;
	private String facebookLink;
	private String likendinLink;
	private String googleplusLink;
	
	public String getFacebookLink() {
		return facebookLink;
	}

	public void setFacebookLink(String facebookLink) {
		this.facebookLink = facebookLink;
	}

	public String getLikendinLink() {
		return likendinLink;
	}

	public void setLikendinLink(String likendinLink) {
		this.likendinLink = likendinLink;
	}

	public String getGoogleplusLink() {
		return googleplusLink;
	}

	public void setGoogleplusLink(String googleplusLink) {
		this.googleplusLink = googleplusLink;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "utilisateurs_roles", joinColumns = @JoinColumn(name = "utilisateurid"), inverseJoinColumns = @JoinColumn(name = "roleid"))
	private List<Roles> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCodereset() {
		return codereset;
	}

	public void setCodereset(Integer codereset) {
		this.codereset = codereset;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getCodeReset() {
		return codereset;
	}

	public void setReset(Integer codereset) {
		this.codereset = codereset;
	}

	public Date getDatereset() {
		return datereset;
	}

	public void setDatereset(Date datereset) {
		this.datereset = datereset;
	}

	public String getNumtel() {
		return numtel;
	}

	public void setNumtel(String numtel) {
		this.numtel = numtel;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
