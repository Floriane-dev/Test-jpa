package org.example.modele;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "LIVRE")
public class Livre {
    /**
     * @Id : KP
     * @GeneratedValue(strategy=GenerationType.IDENTITY) ) AUTOINCREMENTAL
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "AUTEUR", length = 50, nullable = false)
    private String auteur;

    @Column(name = "TITRE", length = 255, nullable = false)
    private String titre;

    /**
     * REGLE DE TABLE DE JONCTION N,N
     * 1 Livre -> n Emprunt(s)
     * 1 Emprunt ->  n Livre(s)
     */
    @ManyToMany
    @JoinTable(name="COMPO",
            joinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID"),
            inverseJoinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID")
    )
    private Set<Emprunt> empruntLivres;

    public Livre(){
    }

    public Livre(String auteur, String titre) {
        this.auteur = auteur;
        this.titre = titre;
        empruntLivres = new HashSet<Emprunt>();
    }

    //getter et setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Set<Emprunt> getEmpruntLivres() { return empruntLivres; }

    public void setEmpruntLivres(Set<Emprunt> empruntLivres) {
        this.empruntLivres = empruntLivres;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", auteur='" + auteur + '\'' +
                ", titre='" + titre + '\'' +
                '}';
    }
}
