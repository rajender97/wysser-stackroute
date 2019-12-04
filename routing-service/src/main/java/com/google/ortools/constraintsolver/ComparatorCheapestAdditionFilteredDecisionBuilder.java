package com.google.ortools.constraintsolver;

public class ComparatorCheapestAdditionFilteredDecisionBuilder extends CheapestAdditionFilteredDecisionBuilder {
   private transient long swigCPtr;

   protected ComparatorCheapestAdditionFilteredDecisionBuilder(long var1, boolean var3) {
      super(mainJNI.ComparatorCheapestAdditionFilteredDecisionBuilder_SWIGUpcast(var1), var3);
      this.swigCPtr = var1;
   }

   protected static long getCPtr(ComparatorCheapestAdditionFilteredDecisionBuilder var0) {
      return var0 == null ? 0L : var0.swigCPtr;
   }

   protected void finalize() {
      this.delete();
   }

   public synchronized void delete() {
      if (this.swigCPtr != 0L) {
         if (this.swigCMemOwn) {
            this.swigCMemOwn = false;
            mainJNI.delete_ComparatorCheapestAdditionFilteredDecisionBuilder(this.swigCPtr);
         }

         this.swigCPtr = 0L;
      }

      super.delete();
   }

   public String toString() {
      return mainJNI.ComparatorCheapestAdditionFilteredDecisionBuilder_toString(this.swigCPtr, this);
   }
}
