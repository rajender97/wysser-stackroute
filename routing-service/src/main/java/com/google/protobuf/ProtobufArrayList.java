package com.google.protobuf;

import java.util.Arrays;
import java.util.RandomAccess;

final class ProtobufArrayList extends AbstractProtobufList implements RandomAccess {
   private static final ProtobufArrayList EMPTY_LIST = new ProtobufArrayList(new Object[0], 0);
   private Object[] array;
   private int size;

   public static ProtobufArrayList emptyList() {
      return EMPTY_LIST;
   }

   ProtobufArrayList() {
      this((Object[])(new Object[10]), 0);
   }

   private ProtobufArrayList(Object[] var1, int var2) {
      this.array = var1;
      this.size = var2;
   }

   public ProtobufArrayList mutableCopyWithCapacity(int var1) {
      if (var1 < this.size) {
         throw new IllegalArgumentException();
      } else {
         Object[] var2 = Arrays.copyOf(this.array, var1);
         return new ProtobufArrayList(var2, this.size);
      }
   }

   public boolean add(Object var1) {
      this.ensureIsMutable();
      if (this.size == this.array.length) {
         int var2 = this.size * 3 / 2 + 1;
         Object[] var3 = Arrays.copyOf(this.array, var2);
         this.array = var3;
      }

      this.array[this.size++] = var1;
      ++this.modCount;
      return true;
   }

   public void add(int var1, Object var2) {
      this.ensureIsMutable();
      if (var1 >= 0 && var1 <= this.size) {
         if (this.size < this.array.length) {
            System.arraycopy(this.array, var1, this.array, var1 + 1, this.size - var1);
         } else {
            int var3 = this.size * 3 / 2 + 1;
            Object[] var4 = createArray(var3);
            System.arraycopy(this.array, 0, var4, 0, var1);
            System.arraycopy(this.array, var1, var4, var1 + 1, this.size - var1);
            this.array = var4;
         }

         this.array[var1] = var2;
         ++this.size;
         ++this.modCount;
      } else {
         throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(var1));
      }
   }

   public Object get(int var1) {
      this.ensureIndexInRange(var1);
      return this.array[var1];
   }

   public Object remove(int var1) {
      this.ensureIsMutable();
      this.ensureIndexInRange(var1);
      Object var2 = this.array[var1];
      if (var1 < this.size - 1) {
         System.arraycopy(this.array, var1 + 1, this.array, var1, this.size - var1 - 1);
      }

      --this.size;
      ++this.modCount;
      return var2;
   }

   public Object set(int var1, Object var2) {
      this.ensureIsMutable();
      this.ensureIndexInRange(var1);
      Object var3 = this.array[var1];
      this.array[var1] = var2;
      ++this.modCount;
      return var3;
   }

   public int size() {
      return this.size;
   }

   private static Object[] createArray(int var0) {
      return (Object[])(new Object[var0]);
   }

   private void ensureIndexInRange(int var1) {
      if (var1 < 0 || var1 >= this.size) {
         throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(var1));
      }
   }

   private String makeOutOfBoundsExceptionMessage(int var1) {
      return "Index:" + var1 + ", Size:" + this.size;
   }

   static {
      EMPTY_LIST.makeImmutable();
   }
}
