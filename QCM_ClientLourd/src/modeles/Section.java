/***********************************************************************
 * 
 * Module:  Section.java
 * Author:  fcourtet
 * Purpose: Defines the Class Section
 ***********************************************************************/
package modeles;

import java.util.*;

/** Description d'une section contenu dans UN test. */
public class Section {
   private Integer numero;
   private Integer numeroOrdre;
   private String nom;
   private Integer nbQuestion;
   
   public java.util.Collection<Question> LesQuestions;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Question> getLesQuestions() {
      if (LesQuestions == null)
         LesQuestions = new java.util.ArrayList<Question>();
      return LesQuestions;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorLesQuestions() {
      if (LesQuestions == null)
         LesQuestions = new java.util.ArrayList<Question>();
      return LesQuestions.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newLesQuestions */
   public void setLesQuestions(java.util.Collection<Question> newLesQuestions) {
      removeAllLesQuestions();
      for (java.util.Iterator iter = newLesQuestions.iterator(); iter.hasNext();)
         addLesQuestions((Question)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newQuestion */
   public void addLesQuestions(Question newQuestion) {
      if (newQuestion == null)
         return;
      if (this.LesQuestions == null)
         this.LesQuestions = new java.util.ArrayList<Question>();
      if (!this.LesQuestions.contains(newQuestion))
         this.LesQuestions.add(newQuestion);
   }
   
   /** @pdGenerated default remove
     * @param oldQuestion */
   public void removeLesQuestions(Question oldQuestion) {
      if (oldQuestion == null)
         return;
      if (this.LesQuestions != null)
         if (this.LesQuestions.contains(oldQuestion))
            this.LesQuestions.remove(oldQuestion);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllLesQuestions() {
      if (LesQuestions != null)
         LesQuestions.clear();
   }

}