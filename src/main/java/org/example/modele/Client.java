package org.example.modele;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;

    @Column(name = "NOM", length = 50, nullable = false)
    private String name;

    @Column(name = "PRENOM", length = 50, nullable = false)
    private String prenom;

    @OneToMany(mappedBy = "clientE")
    private Set<Emprunt> emprunts;


    //Constructeur par défaut obligatoire
    public Client(){
        super();

        /* rajout l'instanciation de l'emprunt pour éviter les collections null et des incohérences
        quand le client n'a rien emprunter
        */
        emprunts = new HashSet<Emprunt>();

    }
    public Client(int idClient, String name, String prenom){
     this.idClient = idClient;
     this.name = name;
     this.prenom = prenom;
    }
    //Getter et setter
    public int getIdClient(){ return idClient; }
    public void setIdClient (int idClient){ this.idClient = idClient; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public Set<Emprunt> getEmprunts() { return emprunts; }
    public void setEmprunts(Set<Emprunt> emprunts) { this.emprunts = emprunts; }


}
