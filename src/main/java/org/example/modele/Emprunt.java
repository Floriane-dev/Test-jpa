package org.example.modele;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_DEBUT", nullable = false)
    private Date dateDeb;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_FIN", nullable = true)
    private Date dateFin;

    @Column(name ="DELAI", length =10, nullable = true)
    private int delaiMax;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT", nullable = false) //@JoinColumn : la colonne client pointe vers la classe emprunt
    private Client clientE; //un lien : clé etrangere vers l'entite client

    /**
     * par mappedBy="empruntLivres"
     * je r�cup�re automatiquement
     * les livres emprunt�s
     */
    @ManyToMany(mappedBy="empruntLivres")
    private Set<Livre> livresE;

    //constructeur par défaut
    public Emprunt() {
        livresE = new HashSet<Livre>();

    }

    //getter et setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Date getDateDeb() { return dateDeb; }
    public void setDateDeb(Date dateDeb) { this.dateDeb = dateDeb; }

    public Date getDateFin() { return dateFin; }
    public void setDateFin(Date dateFin) { this.dateFin = dateFin; }

    public int getDelaiMax() { return delaiMax; }
    public void setDelaiMax(int delaiMax) { this.delaiMax = delaiMax; }

    public Client getClientE() { return clientE; }
    public void setClientE(Client clientE) { this.clientE = clientE; }

    public Set<Livre> getLivresE() { return livresE; }

    public void setLivresE(Set<Livre> livresE) { this.livresE = livresE; }
}
