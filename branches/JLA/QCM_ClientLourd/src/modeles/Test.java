package modeles;
/***********************************************************************

 * Module:  Test.java
 * Author:  fcourtet
 * Purpose: Defines the Class Test
 ***********************************************************************/

import java.util.*;

/** Description d'un test qu'il est possible de planifier pour les candidats. */
public class Test {
   private Integer numero;
   private String nom;
   private Short duree;
   private Number seuilReussite;
   
   public java.util.Collection<Section> LesSections;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Section> getLesSections() {
      if (LesSections == null)
         LesSections = new java.util.ArrayList<Section>();
      return LesSections;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorLesSections() {
      if (LesSections == null)
         LesSections = new java.util.ArrayList<Section>();
      return LesSections.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newLesSections */
   public void setLesSections(java.util.Collection<Section> newLesSections) {
      removeAllLesSections();
      for (java.util.Iterator iter = newLesSections.iterator(); iter.hasNext();)
         addLesSections((Section)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSection */
   public void addLesSections(Section newSection) {
      if (newSection == null)
         return;
      if (this.LesSections == null)
         this.LesSections = new java.util.ArrayList<Section>();
      if (!this.LesSections.contains(newSection))
         this.LesSections.add(newSection);
   }
   
   /** @pdGenerated default remove
     * @param oldSection */
   public void removeLesSections(Section oldSection) {
      if (oldSection == null)
         return;
      if (this.LesSections != null)
         if (this.LesSections.contains(oldSection))
            this.LesSections.remove(oldSection);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllLesSections() {
      if (LesSections != null)
         LesSections.clear();
   }

}