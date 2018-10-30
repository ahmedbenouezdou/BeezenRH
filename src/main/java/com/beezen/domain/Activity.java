package com.beezen.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "activity")
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private Date date;
    private Integer typeAction;
    @Column(columnDefinition="BOOLEAN DEFAULT false")
    private boolean isValid;

    
    @NotNull
    @ManyToOne(optional = false)
	@JoinColumn(name = "user_id")
    private Utilisateurs user;

    
    public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public Activity titre(String titre) {
        this.titre = titre;
        return this;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDate() {
        return date;
    }

    public Activity date(Date date) {
        this.date = date;
        return this;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTypeAction() {
        return typeAction;
    }

    public Activity typeAction(Integer typeAction) {
        this.typeAction = typeAction;
        return this;
    }

    public void setTypeAction(Integer typeAction) {
        this.typeAction = typeAction;
    }

    public Utilisateurs getUser() {
        return user;
    }

    public Activity user(Utilisateurs user) {
        this.user = user;
        return this;
    }

    public void setUser(Utilisateurs user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Activity activity = (Activity) o;
        if (activity.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), activity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }


	@Override
	public String toString() {
		return "Activity{" +
	            "id="  + id + ", titre=" + titre + ", date=" + date + ", typeAction=" + typeAction
				+ ", isValid=" + isValid + ", user=" + user + "}";
	}
}

