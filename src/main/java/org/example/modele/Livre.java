package org.example.modele;

import javax.persistence.*;


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

    public Livre(){
    }

    public Livre(String auteur, String titre) {
        this.auteur = auteur;
        this.titre = titre;
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

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", auteur='" + auteur + '\'' +
                ", titre='" + titre + '\'' +
                '}';
    }
}
