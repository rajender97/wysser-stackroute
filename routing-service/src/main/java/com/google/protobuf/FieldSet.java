package com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class FieldSet {
   private static final int DEFAULT_FIELD_MAP_ARRAY_SIZE = 16;
   private final SmallSortedMap fields;
   private boolean isImmutable;
   private boolean hasLazyField;
   private static final FieldSet DEFAULT_INSTANCE = new FieldSet(true);

   private FieldSet() {
      this.fields = SmallSortedMap.newFieldMap(16);
   }

   private FieldSet(boolean var1) {
      this(SmallSortedMap.newFieldMap(0));
      this.makeImmutable();
   }

   private FieldSet(SmallSortedMap var1) {
      this.fields = var1;
      this.makeImmutable();
   }

   public static FieldSet newFieldSet() {
      return new FieldSet();
   }

   public static FieldSet emptySet() {
      return DEFAULT_INSTANCE;
   }

   public static FieldSet.Builder newBuilder() {
      return new FieldSet.Builder();
   }

   boolean isEmpty() {
      return this.fields.isEmpty();
   }

   public void makeImmutable() {
      if (!this.isImmutable) {
         this.fields.makeImmutable();
         this.isImmutable = true;
      }
   }

   public boolean isImmutable() {
      return this.isImmutable;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof FieldSet)) {
         return false;
      } else {
         FieldSet var2 = (FieldSet)var1;
         return this.fields.equals(var2.fields);
      }
   }

   public int hashCode() {
      return this.fields.hashCode();
   }

   public FieldSet clone() {
      FieldSet var1 = newFieldSet();

      Entry var3;
      for(int var2 = 0; var2 < this.fields.getNumArrayEntries(); ++var2) {
         var3 = this.fields.getArrayEntryAt(var2);
         var1.setField((FieldSet.FieldDescriptorLite)var3.getKey(), var3.getValue());
      }

      Iterator var4 = this.fields.getOverflowEntries().iterator();

      while(var4.hasNext()) {
         var3 = (Entry)var4.next();
         var1.setField((FieldSet.FieldDescriptorLite)var3.getKey(), var3.getValue());
      }

      var1.hasLazyField = this.hasLazyField;
      return var1;
   }

   public void clear() {
      this.fields.clear();
      this.hasLazyField = false;
   }

   public Map getAllFields() {
      if (this.hasLazyField) {
         SmallSortedMap var1 = cloneAllFieldsMap(this.fields, false);
         if (this.fields.isImmutable()) {
            var1.makeImmutable();
         }

         return var1;
      } else {
         return (Map)(this.fields.isImmutable() ? this.fields : Collections.unmodifiableMap(this.fields));
      }
   }

   private static SmallSortedMap cloneAllFieldsMap(SmallSortedMap var0, boolean var1) {
      SmallSortedMap var2 = SmallSortedMap.newFieldMap(16);

      for(int var3 = 0; var3 < var0.getNumArrayEntries(); ++var3) {
         cloneFieldEntry(var2, var0.getArrayEntryAt(var3), var1);
      }

      Iterator var5 = var0.getOverflowEntries().iterator();

      while(var5.hasNext()) {
         Entry var4 = (Entry)var5.next();
         cloneFieldEntry(var2, var4, var1);
      }

      return var2;
   }

   private static void cloneFieldEntry(Map var0, Entry var1, boolean var2) {
      FieldSet.FieldDescriptorLite var3 = (FieldSet.FieldDescriptorLite)var1.getKey();
      Object var4 = var1.getValue();
      if (var4 instanceof LazyField) {
         var0.put(var3, ((LazyField)var4).getValue());
      } else if (var2 && var4 instanceof List) {
         var0.put(var3, new ArrayList((List)var4));
      } else {
         var0.put(var3, var4);
      }

   }

   public Iterator iterator() {
      return (Iterator)(this.hasLazyField ? new LazyField.LazyIterator(this.fields.entrySet().iterator()) : this.fields.entrySet().iterator());
   }

   Iterator descendingIterator() {
      return (Iterator)(this.hasLazyField ? new LazyField.LazyIterator(this.fields.descendingEntrySet().iterator()) : this.fields.descendingEntrySet().iterator());
   }

   public boolean hasField(FieldSet.FieldDescriptorLite var1) {
      if (var1.isRepeated()) {
         throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
      } else {
         return this.fields.get(var1) != null;
      }
   }

   public Object getField(FieldSet.FieldDescriptorLite var1) {
      Object var2 = this.fields.get(var1);
      return var2 instanceof LazyField ? ((LazyField)var2).getValue() : var2;
   }

   public void setField(FieldSet.FieldDescriptorLite var1, Object var2) {
      if (var1.isRepeated()) {
         if (!(var2 instanceof List)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
         }

         ArrayList var3 = new ArrayList();
         var3.addAll((List)var2);
         Iterator var4 = var3.iterator();

         while(var4.hasNext()) {
            Object var5 = var4.next();
            this.verifyType(var1.getLiteType(), var5);
         }

         var2 = var3;
      } else {
         this.verifyType(var1.getLiteType(), var2);
      }

      if (var2 instanceof LazyField) {
         this.hasLazyField = true;
      }

      this.fields.put((Comparable)var1, var2);
   }

   public void clearField(FieldSet.FieldDescriptorLite var1) {
      this.fields.remove(var1);
      if (this.fields.isEmpty()) {
         this.hasLazyField = false;
      }

   }

   public int getRepeatedFieldCount(FieldSet.FieldDescriptorLite var1) {
      if (!var1.isRepeated()) {
         throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
      } else {
         Object var2 = this.getField(var1);
         return var2 == null ? 0 : ((List)var2).size();
      }
   }

   public Object getRepeatedField(FieldSet.FieldDescriptorLite var1, int var2) {
      if (!var1.isRepeated()) {
         throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
      } else {
         Object var3 = this.getField(var1);
         if (var3 == null) {
            throw new IndexOutOfBoundsException();
         } else {
            return ((List)var3).get(var2);
         }
      }
   }

   public void setRepeatedField(FieldSet.FieldDescriptorLite var1, int var2, Object var3) {
      if (!var1.isRepeated()) {
         throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
      } else {
         Object var4 = this.getField(var1);
         if (var4 == null) {
            throw new IndexOutOfBoundsException();
         } else {
            this.verifyType(var1.getLiteType(), var3);
            ((List)var4).set(var2, var3);
         }
      }
   }

   public void addRepeatedField(FieldSet.FieldDescriptorLite var1, Object var2) {
      if (!var1.isRepeated()) {
         throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
      } else {
         this.verifyType(var1.getLiteType(), var2);
         Object var3 = this.getField(var1);
         Object var4;
         if (var3 == null) {
            var4 = new ArrayList();
            this.fields.put((Comparable)var1, var4);
         } else {
            var4 = (List)var3;
         }

         ((List)var4).add(var2);
      }
   }

   private void verifyType(WireFormat.FieldType var1, Object var2) {
      if (!isValidType(var1, var2)) {
         throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
   }

   private static boolean isValidType(WireFormat.FieldType var0, Object var1) {
      Internal.checkNotNull(var1);
      switch(var0.getJavaType()) {
      case INT:
         return var1 instanceof Integer;
      case LONG:
         return var1 instanceof Long;
      case FLOAT:
         return var1 instanceof Float;
      case DOUBLE:
         return var1 instanceof Double;
      case BOOLEAN:
         return var1 instanceof Boolean;
      case STRING:
         return var1 instanceof String;
      case BYTE_STRING:
         return var1 instanceof ByteString || var1 instanceof byte[];
      case ENUM:
         return var1 instanceof Integer || var1 instanceof Internal.EnumLite;
      case MESSAGE:
         return var1 instanceof MessageLite || var1 instanceof LazyField;
      default:
         return false;
      }
   }

   public boolean isInitialized() {
      for(int var1 = 0; var1 < this.fields.getNumArrayEntries(); ++var1) {
         if (!isInitialized(this.fields.getArrayEntryAt(var1))) {
            return false;
         }
      }

      Iterator var3 = this.fields.getOverflowEntries().iterator();

      Entry var2;
      do {
         if (!var3.hasNext()) {
            return true;
         }

         var2 = (Entry)var3.next();
      } while(isInitialized(var2));

      return false;
   }

   private static boolean isInitialized(Entry var0) {
      FieldSet.FieldDescriptorLite var1 = (FieldSet.FieldDescriptorLite)var0.getKey();
      if (var1.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
         if (var1.isRepeated()) {
            Iterator var2 = ((List)var0.getValue()).iterator();

            while(var2.hasNext()) {
               MessageLite var3 = (MessageLite)var2.next();
               if (!var3.isInitialized()) {
                  return false;
               }
            }
         } else {
            Object var4 = var0.getValue();
            if (!(var4 instanceof MessageLite)) {
               if (var4 instanceof LazyField) {
                  return true;
               }

               throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }

            if (!((MessageLite)var4).isInitialized()) {
               return false;
            }
         }
      }

      return true;
   }

   static int getWireFormatForFieldType(WireFormat.FieldType var0, boolean var1) {
      return var1 ? 2 : var0.getWireType();
   }

   public void mergeFrom(FieldSet var1) {
      for(int var2 = 0; var2 < var1.fields.getNumArrayEntries(); ++var2) {
         this.mergeFromField(var1.fields.getArrayEntryAt(var2));
      }

      Iterator var4 = var1.fields.getOverflowEntries().iterator();

      while(var4.hasNext()) {
         Entry var3 = (Entry)var4.next();
         this.mergeFromField(var3);
      }

   }

   private static Object cloneIfMutable(Object var0) {
      if (var0 instanceof byte[]) {
         byte[] var1 = (byte[])((byte[])var0);
         byte[] var2 = new byte[var1.length];
         System.arraycopy(var1, 0, var2, 0, var1.length);
         return var2;
      } else {
         return var0;
      }
   }

   private void mergeFromField(Entry var1) {
      FieldSet.FieldDescriptorLite var2 = (FieldSet.FieldDescriptorLite)var1.getKey();
      Object var3 = var1.getValue();
      if (var3 instanceof LazyField) {
         var3 = ((LazyField)var3).getValue();
      }

      Object var4;
      if (var2.isRepeated()) {
         var4 = this.getField(var2);
         if (var4 == null) {
            var4 = new ArrayList();
         }

         Iterator var5 = ((List)var3).iterator();

         while(var5.hasNext()) {
            Object var6 = var5.next();
            ((List)var4).add(cloneIfMutable(var6));
         }

         this.fields.put((Comparable)var2, var4);
      } else if (var2.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
         var4 = this.getField(var2);
         if (var4 == null) {
            this.fields.put((Comparable)var2, cloneIfMutable(var3));
         } else {
            MessageLite var7 = var2.internalMergeFrom(((MessageLite)var4).toBuilder(), (MessageLite)var3).build();
            this.fields.put((Comparable)var2, var7);
         }
      } else {
         this.fields.put((Comparable)var2, cloneIfMutable(var3));
      }

   }

   public static Object readPrimitiveField(CodedInputStream var0, WireFormat.FieldType var1, boolean var2) throws IOException {
      return var2 ? WireFormat.readPrimitiveField(var0, var1, WireFormat.Utf8Validation.STRICT) : WireFormat.readPrimitiveField(var0, var1, WireFormat.Utf8Validation.LOOSE);
   }

   public void writeTo(CodedOutputStream var1) throws IOException {
      Entry var3;
      for(int var2 = 0; var2 < this.fields.getNumArrayEntries(); ++var2) {
         var3 = this.fields.getArrayEntryAt(var2);
         writeField((FieldSet.FieldDescriptorLite)var3.getKey(), var3.getValue(), var1);
      }

      Iterator var4 = this.fields.getOverflowEntries().iterator();

      while(var4.hasNext()) {
         var3 = (Entry)var4.next();
         writeField((FieldSet.FieldDescriptorLite)var3.getKey(), var3.getValue(), var1);
      }

   }

   public void writeMessageSetTo(CodedOutputStream var1) throws IOException {
      for(int var2 = 0; var2 < this.fields.getNumArrayEntries(); ++var2) {
         this.writeMessageSetTo(this.fields.getArrayEntryAt(var2), var1);
      }

      Iterator var4 = this.fields.getOverflowEntries().iterator();

      while(var4.hasNext()) {
         Entry var3 = (Entry)var4.next();
         this.writeMessageSetTo(var3, var1);
      }

   }

   private void writeMessageSetTo(Entry var1, CodedOutputStream var2) throws IOException {
      FieldSet.FieldDescriptorLite var3 = (FieldSet.FieldDescriptorLite)var1.getKey();
      if (var3.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !var3.isRepeated() && !var3.isPacked()) {
         Object var4 = var1.getValue();
         if (var4 instanceof LazyField) {
            var4 = ((LazyField)var4).getValue();
         }

         var2.writeMessageSetExtension(((FieldSet.FieldDescriptorLite)var1.getKey()).getNumber(), (MessageLite)var4);
      } else {
         writeField(var3, var1.getValue(), var2);
      }

   }

   static void writeElement(CodedOutputStream var0, WireFormat.FieldType var1, int var2, Object var3) throws IOException {
      if (var1 == WireFormat.FieldType.GROUP) {
         var0.writeGroup(var2, (MessageLite)var3);
      } else {
         var0.writeTag(var2, getWireFormatForFieldType(var1, false));
         writeElementNoTag(var0, var1, var3);
      }

   }

   static void writeElementNoTag(CodedOutputStream var0, WireFormat.FieldType var1, Object var2) throws IOException {
      switch(var1) {
      case DOUBLE:
         var0.writeDoubleNoTag((Double)var2);
         break;
      case FLOAT:
         var0.writeFloatNoTag((Float)var2);
         break;
      case INT64:
         var0.writeInt64NoTag((Long)var2);
         break;
      case UINT64:
         var0.writeUInt64NoTag((Long)var2);
         break;
      case INT32:
         var0.writeInt32NoTag((Integer)var2);
         break;
      case FIXED64:
         var0.writeFixed64NoTag((Long)var2);
         break;
      case FIXED32:
         var0.writeFixed32NoTag((Integer)var2);
         break;
      case BOOL:
         var0.writeBoolNoTag((Boolean)var2);
         break;
      case GROUP:
         var0.writeGroupNoTag((MessageLite)var2);
         break;
      case MESSAGE:
         var0.writeMessageNoTag((MessageLite)var2);
         break;
      case STRING:
         if (var2 instanceof ByteString) {
            var0.writeBytesNoTag((ByteString)var2);
         } else {
            var0.writeStringNoTag((String)var2);
         }
         break;
      case BYTES:
         if (var2 instanceof ByteString) {
            var0.writeBytesNoTag((ByteString)var2);
         } else {
            var0.writeByteArrayNoTag((byte[])((byte[])var2));
         }
         break;
      case UINT32:
         var0.writeUInt32NoTag((Integer)var2);
         break;
      case SFIXED32:
         var0.writeSFixed32NoTag((Integer)var2);
         break;
      case SFIXED64:
         var0.writeSFixed64NoTag((Long)var2);
         break;
      case SINT32:
         var0.writeSInt32NoTag((Integer)var2);
         break;
      case SINT64:
         var0.writeSInt64NoTag((Long)var2);
         break;
      case ENUM:
         if (var2 instanceof Internal.EnumLite) {
            var0.writeEnumNoTag(((Internal.EnumLite)var2).getNumber());
         } else {
            var0.writeEnumNoTag((Integer)var2);
         }
      }

   }

   public static void writeField(FieldSet.FieldDescriptorLite var0, Object var1, CodedOutputStream var2) throws IOException {
      WireFormat.FieldType var3 = var0.getLiteType();
      int var4 = var0.getNumber();
      if (var0.isRepeated()) {
         List var5 = (List)var1;
         if (var0.isPacked()) {
            var2.writeTag(var4, 2);
            int var6 = 0;

            Iterator var7;
            Object var8;
            for(var7 = var5.iterator(); var7.hasNext(); var6 += computeElementSizeNoTag(var3, var8)) {
               var8 = var7.next();
            }

            var2.writeRawVarint32(var6);
            var7 = var5.iterator();

            while(var7.hasNext()) {
               var8 = var7.next();
               writeElementNoTag(var2, var3, var8);
            }
         } else {
            Iterator var9 = var5.iterator();

            while(var9.hasNext()) {
               Object var10 = var9.next();
               writeElement(var2, var3, var4, var10);
            }
         }
      } else if (var1 instanceof LazyField) {
         writeElement(var2, var3, var4, ((LazyField)var1).getValue());
      } else {
         writeElement(var2, var3, var4, var1);
      }

   }

   public int getSerializedSize() {
      int var1 = 0;

      Entry var3;
      for(int var2 = 0; var2 < this.fields.getNumArrayEntries(); ++var2) {
         var3 = this.fields.getArrayEntryAt(var2);
         var1 += computeFieldSize((FieldSet.FieldDescriptorLite)var3.getKey(), var3.getValue());
      }

      for(Iterator var4 = this.fields.getOverflowEntries().iterator(); var4.hasNext(); var1 += computeFieldSize((FieldSet.FieldDescriptorLite)var3.getKey(), var3.getValue())) {
         var3 = (Entry)var4.next();
      }

      return var1;
   }

   public int getMessageSetSerializedSize() {
      int var1 = 0;

      for(int var2 = 0; var2 < this.fields.getNumArrayEntries(); ++var2) {
         var1 += this.getMessageSetSerializedSize(this.fields.getArrayEntryAt(var2));
      }

      Entry var3;
      for(Iterator var4 = this.fields.getOverflowEntries().iterator(); var4.hasNext(); var1 += this.getMessageSetSerializedSize(var3)) {
         var3 = (Entry)var4.next();
      }

      return var1;
   }

   private int getMessageSetSerializedSize(Entry var1) {
      FieldSet.FieldDescriptorLite var2 = (FieldSet.FieldDescriptorLite)var1.getKey();
      Object var3 = var1.getValue();
      if (var2.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !var2.isRepeated() && !var2.isPacked()) {
         return var3 instanceof LazyField ? CodedOutputStream.computeLazyFieldMessageSetExtensionSize(((FieldSet.FieldDescriptorLite)var1.getKey()).getNumber(), (LazyField)var3) : CodedOutputStream.computeMessageSetExtensionSize(((FieldSet.FieldDescriptorLite)var1.getKey()).getNumber(), (MessageLite)var3);
      } else {
         return computeFieldSize(var2, var3);
      }
   }

   static int computeElementSize(WireFormat.FieldType var0, int var1, Object var2) {
      int var3 = CodedOutputStream.computeTagSize(var1);
      if (var0 == WireFormat.FieldType.GROUP) {
         var3 *= 2;
      }

      return var3 + computeElementSizeNoTag(var0, var2);
   }

   static int computeElementSizeNoTag(WireFormat.FieldType var0, Object var1) {
      switch(var0) {
      case DOUBLE:
         return CodedOutputStream.computeDoubleSizeNoTag((Double)var1);
      case FLOAT:
         return CodedOutputStream.computeFloatSizeNoTag((Float)var1);
      case INT64:
         return CodedOutputStream.computeInt64SizeNoTag((Long)var1);
      case UINT64:
         return CodedOutputStream.computeUInt64SizeNoTag((Long)var1);
      case INT32:
         return CodedOutputStream.computeInt32SizeNoTag((Integer)var1);
      case FIXED64:
         return CodedOutputStream.computeFixed64SizeNoTag((Long)var1);
      case FIXED32:
         return CodedOutputStream.computeFixed32SizeNoTag((Integer)var1);
      case BOOL:
         return CodedOutputStream.computeBoolSizeNoTag((Boolean)var1);
      case GROUP:
         return CodedOutputStream.computeGroupSizeNoTag((MessageLite)var1);
      case MESSAGE:
         if (var1 instanceof LazyField) {
            return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField)var1);
         }

         return CodedOutputStream.computeMessageSizeNoTag((MessageLite)var1);
      case STRING:
         if (var1 instanceof ByteString) {
            return CodedOutputStream.computeBytesSizeNoTag((ByteString)var1);
         }

         return CodedOutputStream.computeStringSizeNoTag((String)var1);
      case BYTES:
         if (var1 instanceof ByteString) {
            return CodedOutputStream.computeBytesSizeNoTag((ByteString)var1);
         }

         return CodedOutputStream.computeByteArraySizeNoTag((byte[])((byte[])var1));
      case UINT32:
         return CodedOutputStream.computeUInt32SizeNoTag((Integer)var1);
      case SFIXED32:
         return CodedOutputStream.computeSFixed32SizeNoTag((Integer)var1);
      case SFIXED64:
         return CodedOutputStream.computeSFixed64SizeNoTag((Long)var1);
      case SINT32:
         return CodedOutputStream.computeSInt32SizeNoTag((Integer)var1);
      case SINT64:
         return CodedOutputStream.computeSInt64SizeNoTag((Long)var1);
      case ENUM:
         if (var1 instanceof Internal.EnumLite) {
            return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite)var1).getNumber());
         }

         return CodedOutputStream.computeEnumSizeNoTag((Integer)var1);
      default:
         throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
      }
   }

   public static int computeFieldSize(FieldSet.FieldDescriptorLite var0, Object var1) {
      WireFormat.FieldType var2 = var0.getLiteType();
      int var3 = var0.getNumber();
      if (!var0.isRepeated()) {
         return computeElementSize(var2, var3, var1);
      } else {
         int var4;
         Iterator var5;
         Object var6;
         if (var0.isPacked()) {
            var4 = 0;

            for(var5 = ((List)var1).iterator(); var5.hasNext(); var4 += computeElementSizeNoTag(var2, var6)) {
               var6 = var5.next();
            }

            return var4 + CodedOutputStream.computeTagSize(var3) + CodedOutputStream.computeRawVarint32Size(var4);
         } else {
            var4 = 0;

            for(var5 = ((List)var1).iterator(); var5.hasNext(); var4 += computeElementSize(var2, var3, var6)) {
               var6 = var5.next();
            }

            return var4;
         }
      }
   }

   // $FF: synthetic method
   FieldSet(SmallSortedMap var1, Object var2) {
      this(var1);
   }

   static final class Builder {
      private SmallSortedMap fields;
      private boolean hasLazyField;
      private boolean isMutable;
      private boolean hasNestedBuilders;

      private Builder() {
         this(SmallSortedMap.newFieldMap(16));
      }

      private Builder(SmallSortedMap var1) {
         this.fields = var1;
         this.isMutable = true;
      }

      public FieldSet build() {
         if (this.fields.isEmpty()) {
            return FieldSet.emptySet();
         } else {
            this.isMutable = false;
            SmallSortedMap var1 = this.fields;
            if (this.hasNestedBuilders) {
               var1 = FieldSet.cloneAllFieldsMap(this.fields, false);
               replaceBuilders(var1);
            }

            FieldSet var2 = new FieldSet(var1);
            var2.hasLazyField = this.hasLazyField;
            return var2;
         }
      }

      private static void replaceBuilders(SmallSortedMap var0) {
         for(int var1 = 0; var1 < var0.getNumArrayEntries(); ++var1) {
            replaceBuilders(var0.getArrayEntryAt(var1));
         }

         Iterator var3 = var0.getOverflowEntries().iterator();

         while(var3.hasNext()) {
            Entry var2 = (Entry)var3.next();
            replaceBuilders(var2);
         }

      }

      private static void replaceBuilders(Entry var0) {
         var0.setValue(replaceBuilders((FieldSet.FieldDescriptorLite)var0.getKey(), var0.getValue()));
      }

      private static Object replaceBuilders(FieldSet.FieldDescriptorLite var0, Object var1) {
         if (var1 == null) {
            return var1;
         } else if (var0.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            if (var0.isRepeated()) {
               if (!(var1 instanceof List)) {
                  throw new IllegalStateException("Repeated field should contains a List but actually contains type: " + var1.getClass());
               } else {
                  Object var2 = (List)var1;

                  for(int var3 = 0; var3 < ((List)var2).size(); ++var3) {
                     Object var4 = ((List)var2).get(var3);
                     Object var5 = replaceBuilder(var4);
                     if (var5 != var4) {
                        if (var2 == var1) {
                           var2 = new ArrayList((Collection)var2);
                        }

                        ((List)var2).set(var3, var5);
                     }
                  }

                  return var2;
               }
            } else {
               return replaceBuilder(var1);
            }
         } else {
            return var1;
         }
      }

      private static Object replaceBuilder(Object var0) {
         return var0 instanceof MessageLite.Builder ? ((MessageLite.Builder)var0).build() : var0;
      }

      public static FieldSet.Builder fromFieldSet(FieldSet var0) {
         FieldSet.Builder var1 = new FieldSet.Builder(FieldSet.cloneAllFieldsMap(var0.fields, true));
         var1.hasLazyField = var0.hasLazyField;
         return var1;
      }

      public Map getAllFields() {
         if (this.hasLazyField) {
            SmallSortedMap var1 = FieldSet.cloneAllFieldsMap(this.fields, false);
            if (this.fields.isImmutable()) {
               var1.makeImmutable();
            } else {
               replaceBuilders(var1);
            }

            return var1;
         } else {
            return (Map)(this.fields.isImmutable() ? this.fields : Collections.unmodifiableMap(this.fields));
         }
      }

      public boolean hasField(FieldSet.FieldDescriptorLite var1) {
         if (var1.isRepeated()) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
         } else {
            return this.fields.get(var1) != null;
         }
      }

      public Object getField(FieldSet.FieldDescriptorLite var1) {
         Object var2 = this.getFieldAllowBuilders(var1);
         return replaceBuilders(var1, var2);
      }

      Object getFieldAllowBuilders(FieldSet.FieldDescriptorLite var1) {
         Object var2 = this.fields.get(var1);
         return var2 instanceof LazyField ? ((LazyField)var2).getValue() : var2;
      }

      private void ensureIsMutable() {
         if (!this.isMutable) {
            this.fields = FieldSet.cloneAllFieldsMap(this.fields, true);
            this.isMutable = true;
         }

      }

      public void setField(FieldSet.FieldDescriptorLite var1, Object var2) {
         this.ensureIsMutable();
         if (var1.isRepeated()) {
            if (!(var2 instanceof List)) {
               throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }

            ArrayList var3 = new ArrayList();
            var3.addAll((List)var2);

            Object var5;
            for(Iterator var4 = var3.iterator(); var4.hasNext(); this.hasNestedBuilders = this.hasNestedBuilders || var5 instanceof MessageLite.Builder) {
               var5 = var4.next();
               verifyType(var1.getLiteType(), var5);
            }

            var2 = var3;
         } else {
            verifyType(var1.getLiteType(), var2);
         }

         if (var2 instanceof LazyField) {
            this.hasLazyField = true;
         }

         this.hasNestedBuilders = this.hasNestedBuilders || var2 instanceof MessageLite.Builder;
         this.fields.put((Comparable)var1, var2);
      }

      public void clearField(FieldSet.FieldDescriptorLite var1) {
         this.ensureIsMutable();
         this.fields.remove(var1);
         if (this.fields.isEmpty()) {
            this.hasLazyField = false;
         }

      }

      public int getRepeatedFieldCount(FieldSet.FieldDescriptorLite var1) {
         if (!var1.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
         } else {
            Object var2 = this.getField(var1);
            return var2 == null ? 0 : ((List)var2).size();
         }
      }

      public Object getRepeatedField(FieldSet.FieldDescriptorLite var1, int var2) {
         if (this.hasNestedBuilders) {
            this.ensureIsMutable();
         }

         Object var3 = this.getRepeatedFieldAllowBuilders(var1, var2);
         return replaceBuilder(var3);
      }

      Object getRepeatedFieldAllowBuilders(FieldSet.FieldDescriptorLite var1, int var2) {
         if (!var1.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
         } else {
            Object var3 = this.getFieldAllowBuilders(var1);
            if (var3 == null) {
               throw new IndexOutOfBoundsException();
            } else {
               return ((List)var3).get(var2);
            }
         }
      }

      public void setRepeatedField(FieldSet.FieldDescriptorLite var1, int var2, Object var3) {
         this.ensureIsMutable();
         if (!var1.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
         } else {
            this.hasNestedBuilders = this.hasNestedBuilders || var3 instanceof MessageLite.Builder;
            Object var4 = this.getField(var1);
            if (var4 == null) {
               throw new IndexOutOfBoundsException();
            } else {
               verifyType(var1.getLiteType(), var3);
               ((List)var4).set(var2, var3);
            }
         }
      }

      public void addRepeatedField(FieldSet.FieldDescriptorLite var1, Object var2) {
         this.ensureIsMutable();
         if (!var1.isRepeated()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
         } else {
            this.hasNestedBuilders = this.hasNestedBuilders || var2 instanceof MessageLite.Builder;
            verifyType(var1.getLiteType(), var2);
            Object var3 = this.getField(var1);
            Object var4;
            if (var3 == null) {
               var4 = new ArrayList();
               this.fields.put((Comparable)var1, var4);
            } else {
               var4 = (List)var3;
            }

            ((List)var4).add(var2);
         }
      }

      private static void verifyType(WireFormat.FieldType var0, Object var1) {
         if (!FieldSet.isValidType(var0, var1)) {
            if (var0.getJavaType() != WireFormat.JavaType.MESSAGE || !(var1 instanceof MessageLite.Builder)) {
               throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
         }
      }

      public boolean isInitialized() {
         for(int var1 = 0; var1 < this.fields.getNumArrayEntries(); ++var1) {
            if (!FieldSet.isInitialized(this.fields.getArrayEntryAt(var1))) {
               return false;
            }
         }

         Iterator var3 = this.fields.getOverflowEntries().iterator();

         Entry var2;
         do {
            if (!var3.hasNext()) {
               return true;
            }

            var2 = (Entry)var3.next();
         } while(FieldSet.isInitialized(var2));

         return false;
      }

      public void mergeFrom(FieldSet var1) {
         this.ensureIsMutable();

         for(int var2 = 0; var2 < var1.fields.getNumArrayEntries(); ++var2) {
            this.mergeFromField(var1.fields.getArrayEntryAt(var2));
         }

         Iterator var4 = var1.fields.getOverflowEntries().iterator();

         while(var4.hasNext()) {
            Entry var3 = (Entry)var4.next();
            this.mergeFromField(var3);
         }

      }

      private void mergeFromField(Entry var1) {
         FieldSet.FieldDescriptorLite var2 = (FieldSet.FieldDescriptorLite)var1.getKey();
         Object var3 = var1.getValue();
         if (var3 instanceof LazyField) {
            var3 = ((LazyField)var3).getValue();
         }

         Object var4;
         if (var2.isRepeated()) {
            var4 = this.getField(var2);
            if (var4 == null) {
               var4 = new ArrayList();
            }

            Iterator var5 = ((List)var3).iterator();

            while(var5.hasNext()) {
               Object var6 = var5.next();
               ((List)var4).add(FieldSet.cloneIfMutable(var6));
            }

            this.fields.put((Comparable)var2, var4);
         } else if (var2.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            var4 = this.getField(var2);
            if (var4 == null) {
               this.fields.put((Comparable)var2, FieldSet.cloneIfMutable(var3));
            } else if (var4 instanceof MessageLite.Builder) {
               var2.internalMergeFrom((MessageLite.Builder)var4, (MessageLite)var3);
            } else {
               MessageLite var7 = var2.internalMergeFrom(((MessageLite)var4).toBuilder(), (MessageLite)var3).build();
               this.fields.put((Comparable)var2, var7);
            }
         } else {
            this.fields.put((Comparable)var2, FieldSet.cloneIfMutable(var3));
         }

      }

      // $FF: synthetic method
      Builder(Object var1) {
         this();
      }
   }

   public interface FieldDescriptorLite extends Comparable {
      int getNumber();

      WireFormat.FieldType getLiteType();

      WireFormat.JavaType getLiteJavaType();

      boolean isRepeated();

      boolean isPacked();

      Internal.EnumLiteMap getEnumType();

      MessageLite.Builder internalMergeFrom(MessageLite.Builder var1, MessageLite var2);
   }
}
