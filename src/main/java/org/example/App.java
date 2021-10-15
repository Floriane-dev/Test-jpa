package org.example;

import org.example.modele.Livre;

import javax.persistence.*;
import java.sql.SQLOutput;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
     public static void main( String[] args ) {

        System.out.println("Hello World!");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
        EntityManager em = entityManagerFactory.createEntityManager();
        //Trouvé un livre dans la biblio a partir de l'id

        Livre l1 = em.find(Livre.class, 4);
         //empêcher un message d'erreur si la liste est trop courte par ex.
        if (l1 != null) {
            System.out.println("Le titre du livre est : " + l1.getTitre() + " et l'auteur est : "+ l1.getAuteur());
        } else {
            System.out.println("Livre non trouvé");
        }

        //Création d'un nouveau livre (id est auto-incremente)
        Livre l2 = new Livre("A1","T1");

         /**
          * ouverture d'une transaction pour la MAJ de BDD
          */
         em.getTransaction().begin();

         /**J'ajoute le nouveau livre dans la BD :
         // em.persist(l2);

         // Je modifie le titre du livre l2 :
           l2 = em.find(Livre.class,9);
           l2.setTitre("Je suis le nouv titre de l2");
           em.merge(l2);  //UPDATE pour la modif du titre

         //Je supprime l2 :
           em.remove(l2);

          */
          //Requête pour extraire un livre en fonction de son titre :
         TypedQuery<Livre> requeteTitre = em.createQuery("select i from Livre i where i.titre='Je suis le nouv titre de l2'", Livre.class);
         Livre sortie = requeteTitre.getSingleResult();
         System.out.println("Le livre dont le titre est 'Du plaisir dans la cuisine' a pour id "+ sortie.getId());

         //Requête pour extraire  livre à partir du nom de l'auteur :
         TypedQuery<Livre> requeteAuteur = em.createQuery("Select i from Livre i where i.auteur = 'Gaston Pouet'", Livre.class);
         Livre sortieBis = requeteAuteur.getSingleResult();
         System.out.println("L'identifiant du livre de Gaston Pouet est " + sortieBis.getId());

         //Je liste tous les elements de la BD :
         TypedQuery<Livre> requeteTous = em.createQuery("Select i from Livre i", Livre.class);
         List<Livre> tous = null;
         tous = requeteTous.getResultList();
         for(Livre tt : tous) {
             System.out.println("Auteur : " + tt.getAuteur() + " Titre : " + tt.getTitre());

         }
          /**
          * Valide la Transaction et la ferme la transaction
          */
         em.getTransaction().commit();
         em.close();

    }

}
