package metier.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "CAMIONS")
public class Camion implements Serializable{
	@Id
	@Column (name="ID_CAMION")
	@GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long idCamion;
	@Column (name="NOM_CAMION")
    private String nomCamion;
    private double prix;
public Camion() {
super();
}
public Camion(String nomCamion, double prix) {
super();
this.nomCamion = nomCamion;
this.prix = prix;
}
public Long getIdCamion() {
return idCamion;
}
public void setIdCamion(Long idCamion) {
this.idCamion = idCamion;
}
public String getNomCamion() {
return nomCamion;
}
public void setNomCamion(String nomCamion) {
this.nomCamion = nomCamion;
}
public double getPrix() {
return prix;
}
public void setPrix(double prix) {
this.prix = prix;
}
}
