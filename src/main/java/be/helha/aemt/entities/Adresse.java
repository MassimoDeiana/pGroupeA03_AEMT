package be.helha.aemt.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresse implements Serializable
{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String rue,numero,ville;
    private int codePostal;
    
    public Adresse() {
        
    }
    
    public Adresse(String rue, String numero, String ville, int codePostal){
        this.rue=rue;
        this.numero=numero;
        this.ville=ville;
        this.codePostal=codePostal;
    }

    public Integer getId() {
        return id;
    }

    public String getRue() {
        return rue;
    }

    public String getNumero() {
        return numero;
    }

    public String getVille() {
        return ville;
    }

    public int getCp() {
        return codePostal;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setCp(int codePostal) {
        this.codePostal = codePostal;
    }

    @Override
    public String toString() {
        return  id + " adresse : " + rue + " : " + numero + " : " + ville + " : " + codePostal ;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Adresse other = (Adresse) obj;
        return codePostal == other.codePostal && Objects.equals(numero, other.numero) && Objects.equals(rue, other.rue)
                && Objects.equals(ville, other.ville);
    }
    
}