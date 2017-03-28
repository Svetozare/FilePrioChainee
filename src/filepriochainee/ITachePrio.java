/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filepriochainee;

/**
 *
 * @author Milev
 */
public interface ITachePrio {
   /**
    * Permet d'obtenir la priorite de cet objet.
    * @return la priorite de cet objet.
    */
   int getPriorite();
   
   /**
    * Permet de modifier la priorite de cet objet par la valeur passee 
    * en parametre.
    * @param priorite la nouvelle priorite de cet objet.
    */
   void setPriorite(int priorite);
}
