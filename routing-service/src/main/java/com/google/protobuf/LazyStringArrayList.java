package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public class LazyStringArrayList extends AbstractProtobufList implements LazyStringList, RandomAccess {
   private static final LazyStringArrayList EMPTY_LIST = new LazyStringArrayList();
   public static final LazyStringList EMPTY;
   private final List list;

   static LazyStringArrayList emptyList() {
      return EMPTY_LIST;
   }

   public LazyStringArrayList() {
      this(10);
   }

   public LazyStringArrayList(int var1) {
      this(new ArrayList(var1));
   }

   public LazyStringArrayList(LazyStringList var1) {
      this.list = new ArrayList(var1.size());
      this.addAll(var1);
   }

   public LazyStringArrayList(List var1) {
      this(new ArrayList(var1));
   }

   private LazyStringArrayList(ArrayList var1) {
      this.list = var1;
   }

   public LazyStringArrayList mutableCopyWithCapacity(int var1) {
      if (var1 < this.size()) {
         throw new IllegalArgumentException();
      } else {
         ArrayList var2 = new ArrayList(var1);
         var2.addAll(this.list);
         return new LazyStringArrayList(var2);
      }
   }

   public String get(int var1) {
      Object var2 = this.list.get(var1);
      if (var2 instanceof String) {
         return (String)var2;
      } else {
         String var4;
         if (var2 instanceof ByteString) {
            ByteString var5 = (ByteString)var2;
            var4 = var5.toStringUtf8();
            if (var5.isValidUtf8()) {
               this.list.set(var1, var4);
            }

            return var4;
         } else {
            byte[] var3 = (byte[])((byte[])var2);
            var4 = Internal.toStringUtf8(var3);
            if (Internal.isValidUtf8(var3)) {
               this.list.set(var1, var4);
            }

            return var4;
         }
      }
   }

   public int size() {
      return this.list.size();
   }

   public String set(int var1, String var2) {
      this.ensureIsMutable();
      Object var3 = this.list.set(var1, var2);
      return asString(var3);
   }

   public void add(int var1, String var2) {
      this.ensureIsMutable();
      this.list.add(var1, var2);
      ++this.modCount;
   }

   private void add(int var1, ByteString var2) {
      this.ensureIsMutable();
      this.list.add(var1, var2);
      ++this.modCount;
   }

   private void add(int var1, byte[] var2) {
      this.ensureIsMutable();
      this.list.add(var1, var2);
      ++this.modCount;
   }

   public boolean addAll(Collection var1) {
      return this.addAll(this.size(), var1);
   }

   public boolean addAll(int var1, Collection var2) {
      this.ensureIsMutable();
      Object var3 = var2 instanceof LazyStringList ? ((LazyStringList)var2).getUnderlyingElements() : var2;
      boolean var4 = this.list.addAll(var1, (Collection)var3);
      ++this.modCount;
      return var4;
   }

   public boolean addAllByteString(Collection var1) {
      this.ensureIsMutable();
      boolean var2 = this.list.addAll(var1);
      ++this.modCount;
      return var2;
   }

   public boolean addAllByteArray(Collection var1) {
      this.ensureIsMutable();
      boolean var2 = this.list.addAll(var1);
      ++this.modCount;
      return var2;
   }

   public String remove(int var1) {
      this.ensureIsMutable();
      Object var2 = this.list.remove(var1);
      ++this.modCount;
      return asString(var2);
   }

   public void clear() {
      this.ensureIsMutable();
      this.list.clear();
      ++this.modCount;
   }

   public void add(ByteString var1) {
      this.ensureIsMutable();
      this.list.add(var1);
      ++this.modCount;
   }

   public void add(byte[] var1) {
      this.ensureIsMutable();
      this.list.add(var1);
      ++this.modCount;
   }

   public Object getRaw(int var1) {
      return this.list.get(var1);
   }

   public ByteString getByteString(int var1) {
      Object var2 = this.list.get(var1);
      ByteString var3 = asByteString(var2);
      if (var3 != var2) {
         this.list.set(var1, var3);
      }

      return var3;
   }

   public byte[] getByteArray(int var1) {
      Object var2 = this.list.get(var1);
      byte[] var3 = asByteArray(var2);
      if (var3 != var2) {
         this.list.set(var1, var3);
      }

      return var3;
   }

   public void set(int var1, ByteString var2) {
      this.setAndReturn(var1, var2);
   }

   private Object setAndReturn(int var1, ByteString var2) {
      this.ensureIsMutable();
      return this.list.set(var1, var2);
   }

   public void set(int var1, byte[] var2) {
      this.setAndReturn(var1, var2);
   }

   private Object setAndReturn(int var1, byte[] var2) {
      this.ensureIsMutable();
      return this.list.set(var1, var2);
   }

   private static String asString(Object var0) {
      if (var0 instanceof String) {
         return (String)var0;
      } else {
         return var0 instanceof ByteString ? ((ByteString)var0).toStringUtf8() : Internal.toStringUtf8((byte[])((byte[])var0));
      }
   }

   private static ByteString asByteString(Object var0) {
      if (var0 instanceof ByteString) {
         return (ByteString)var0;
      } else {
         return var0 instanceof String ? ByteString.copyFromUtf8((String)var0) : ByteString.copyFrom((byte[])((byte[])var0));
      }
   }

   private static byte[] asByteArray(Object var0) {
      if (var0 instanceof byte[]) {
         return (byte[])((byte[])var0);
      } else {
         return var0 instanceof String ? Internal.toByteArray((String)var0) : ((ByteString)var0).toByteArray();
      }
   }

   public List getUnderlyingElements() {
      return Collections.unmodifiableList(this.list);
   }

   public void mergeFrom(LazyStringList var1) {
      this.ensureIsMutable();
      Iterator var2 = var1.getUnderlyingElements().iterator();

      while(var2.hasNext()) {
         Object var3 = var2.next();
         if (var3 instanceof byte[]) {
            byte[] var4 = (byte[])((byte[])var3);
            this.list.add(Arrays.copyOf(var4, var4.length));
         } else {
            this.list.add(var3);
         }
      }

   }

   public List asByteArrayList() {
      return new LazyStringArrayList.ByteArrayListView(this);
   }

   public List asByteStringList() {
      return new LazyStringArrayList.ByteStringListView(this);
   }

   public LazyStringList getUnmodifiableView() {
      return (LazyStringList)(this.isModifiable() ? new UnmodifiableLazyStringList(this) : this);
   }

   static {
      EMPTY_LIST.makeImmutable();
      EMPTY = EMPTY_LIST;
   }

   private static class ByteStringListView extends AbstractList implements RandomAccess {
      private final LazyStringArrayList list;

      ByteStringListView(LazyStringArrayList var1) {
         this.list = var1;
      }

      public ByteString get(int var1) {
         return this.list.getByteString(var1);
      }

      public int size() {
         return this.list.size();
      }

      public ByteString set(int var1, ByteString var2) {
         Object var3 = this.list.setAndReturn(var1, var2);
         ++this.modCount;
         return LazyStringArrayList.asByteString(var3);
      }

      public void add(int var1, ByteString var2) {
         this.list.add(var1, var2);
         ++this.modCount;
      }

      public ByteString remove(int var1) {
         String var2 = this.list.remove(var1);
         ++this.modCount;
         return LazyStringArrayList.asByteString(var2);
      }
   }

   private static class ByteArrayListView extends AbstractList implements RandomAccess {
      private final LazyStringArrayList list;

      ByteArrayListView(LazyStringArrayList var1) {
         this.list = var1;
      }

      public byte[] get(int var1) {
         return this.list.getByteArray(var1);
      }

      public int size() {
         return this.list.size();
      }

      public byte[] set(int var1, byte[] var2) {
         Object var3 = this.list.setAndReturn(var1, var2);
         ++this.modCount;
         return LazyStringArrayList.asByteArray(var3);
      }

      public void add(int var1, byte[] var2) {
         this.list.add(var1, var2);
         ++this.modCount;
      }

      public byte[] remove(int var1) {
         String var2 = this.list.remove(var1);
         ++this.modCount;
         return LazyStringArrayList.asByteArray(var2);
      }
   }
}
