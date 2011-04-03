/***********************************************************************
 * 
 * Module:  Examen.java
 * Author:  fcourtet
 * Purpose: Defines the Class Examen
 ***********************************************************************/

package modeles;

import java.util.*;

/** Description d'un examen. */
public class Examen {
   private Integer numero;
   private Date dateDebut;
   private Date dateFin;
   
   public Collection<SessionCandidat> LesSessionsCandidats;
   public DestinataireReponse LeDestinataireReponses;
   public Test LeTest;
   
   
   /** @pdGenerated default getter */
   public Collection<SessionCandidat> getLesSessionsCandidats() {
      if (LesSessionsCandidats == null)
         LesSessionsCandidats = new java.util.ArrayList<SessionCandidat>();
      return LesSessionsCandidats;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorLesSessionsCandidats() {
      if (LesSessionsCandidats == null)
         LesSessionsCandidats = new java.util.ArrayList<SessionCandidat>();
      return LesSessionsCandidats.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newLesSessionsCandidats */
   public void setLesSessionsCandidats(java.util.Collection<SessionCandidat> newLesSessionsCandidats) {
      removeAllLesSessionsCandidats();
      for (Iterator iter = newLesSessionsCandidats.iterator(); iter.hasNext();)
         addLesSessionsCandidats((SessionCandidat)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSessionCandidat */
   public void addLesSessionsCandidats(SessionCandidat newSessionCandidat) {
      if (newSessionCandidat == null)
         return;
      if (this.LesSessionsCandidats == null)
         this.LesSessionsCandidats = new java.util.ArrayList<SessionCandidat>();
      if (!this.LesSessionsCandidats.contains(newSessionCandidat))
         this.LesSessionsCandidats.add(newSessionCandidat);
   }
   
   /** @pdGenerated default remove
     * @param oldSessionCandidat */
   public void removeLesSessionsCandidats(SessionCandidat oldSessionCandidat) {
      if (oldSessionCandidat == null)
         return;
      if (this.LesSessionsCandidats != null)
         if (this.LesSessionsCandidats.contains(oldSessionCandidat))
            this.LesSessionsCandidats.remove(oldSessionCandidat);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllLesSessionsCandidats() {
      if (LesSessionsCandidats != null)
         LesSessionsCandidats.clear();
   }

}