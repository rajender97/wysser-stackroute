package com.google.protobuf;

import java.lang.reflect.Field;

final class FieldInfo implements Comparable {
   private final Field field;
   private final FieldType type;
   private final Class messageClass;
   private final int fieldNumber;
   private final Field presenceField;
   private final int presenceMask;
   private final boolean required;
   private final boolean enforceUtf8;
   private final OneofInfo oneof;
   private final Field cachedSizeField;
   private final Class oneofStoredType;
   private final Object mapDefaultEntry;
   private final Internal.EnumVerifier enumVerifier;

   public static FieldInfo forField(Field var0, int var1, FieldType var2, boolean var3) {
      checkFieldNumber(var1);
      Internal.checkNotNull(var0, "field");
      Internal.checkNotNull(var2, "fieldType");
      if (var2 != FieldType.MESSAGE_LIST && var2 != FieldType.GROUP_LIST) {
         return new FieldInfo(var0, var1, var2, (Class)null, (Field)null, 0, false, var3, (OneofInfo)null, (Class)null, (Object)null, (Internal.EnumVerifier)null, (Field)null);
      } else {
         throw new IllegalStateException("Shouldn't be called for repeated message fields.");
      }
   }

   public static FieldInfo forPackedField(Field var0, int var1, FieldType var2, Field var3) {
      checkFieldNumber(var1);
      Internal.checkNotNull(var0, "field");
      Internal.checkNotNull(var2, "fieldType");
      if (var2 != FieldType.MESSAGE_LIST && var2 != FieldType.GROUP_LIST) {
         return new FieldInfo(var0, var1, var2, (Class)null, (Field)null, 0, false, false, (OneofInfo)null, (Class)null, (Object)null, (Internal.EnumVerifier)null, var3);
      } else {
         throw new IllegalStateException("Shouldn't be called for repeated message fields.");
      }
   }

   public static FieldInfo forRepeatedMessageField(Field var0, int var1, FieldType var2, Class var3) {
      checkFieldNumber(var1);
      Internal.checkNotNull(var0, "field");
      Internal.checkNotNull(var2, "fieldType");
      Internal.checkNotNull(var3, "messageClass");
      return new FieldInfo(var0, var1, var2, var3, (Field)null, 0, false, false, (OneofInfo)null, (Class)null, (Object)null, (Internal.EnumVerifier)null, (Field)null);
   }

   public static FieldInfo forFieldWithEnumVerifier(Field var0, int var1, FieldType var2, Internal.EnumVerifier var3) {
      checkFieldNumber(var1);
      Internal.checkNotNull(var0, "field");
      return new FieldInfo(var0, var1, var2, (Class)null, (Field)null, 0, false, false, (OneofInfo)null, (Class)null, (Object)null, var3, (Field)null);
   }

   public static FieldInfo forPackedFieldWithEnumVerifier(Field var0, int var1, FieldType var2, Internal.EnumVerifier var3, Field var4) {
      checkFieldNumber(var1);
      Internal.checkNotNull(var0, "field");
      return new FieldInfo(var0, var1, var2, (Class)null, (Field)null, 0, false, false, (OneofInfo)null, (Class)null, (Object)null, var3, var4);
   }

   public static FieldInfo forProto2OptionalField(Field var0, int var1, FieldType var2, Field var3, int var4, boolean var5, Internal.EnumVerifier var6) {
      checkFieldNumber(var1);
      Internal.checkNotNull(var0, "field");
      Internal.checkNotNull(var2, "fieldType");
      Internal.checkNotNull(var3, "presenceField");
      if (var3 != null && !isExactlyOneBitSet(var4)) {
         throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + var4);
      } else {
         return new FieldInfo(var0, var1, var2, (Class)null, var3, var4, false, var5, (OneofInfo)null, (Class)null, (Object)null, var6, (Field)null);
      }
   }

   public static FieldInfo forOneofMemberField(int var0, FieldType var1, OneofInfo var2, Class var3, boolean var4, Internal.EnumVerifier var5) {
      checkFieldNumber(var0);
      Internal.checkNotNull(var1, "fieldType");
      Internal.checkNotNull(var2, "oneof");
      Internal.checkNotNull(var3, "oneofStoredType");
      if (!var1.isScalar()) {
         throw new IllegalArgumentException("Oneof is only supported for scalar fields. Field " + var0 + " is of type " + var1);
      } else {
         return new FieldInfo((Field)null, var0, var1, (Class)null, (Field)null, 0, false, var4, var2, var3, (Object)null, var5, (Field)null);
      }
   }

   private static void checkFieldNumber(int var0) {
      if (var0 <= 0) {
         throw new IllegalArgumentException("fieldNumber must be positive: " + var0);
      }
   }

   public static FieldInfo forProto2RequiredField(Field var0, int var1, FieldType var2, Field var3, int var4, boolean var5, Internal.EnumVerifier var6) {
      checkFieldNumber(var1);
      Internal.checkNotNull(var0, "field");
      Internal.checkNotNull(var2, "fieldType");
      Internal.checkNotNull(var3, "presenceField");
      if (var3 != null && !isExactlyOneBitSet(var4)) {
         throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + var4);
      } else {
         return new FieldInfo(var0, var1, var2, (Class)null, var3, var4, true, var5, (OneofInfo)null, (Class)null, (Object)null, var6, (Field)null);
      }
   }

   public static FieldInfo forMapField(Field var0, int var1, Object var2, Internal.EnumVerifier var3) {
      Internal.checkNotNull(var2, "mapDefaultEntry");
      checkFieldNumber(var1);
      Internal.checkNotNull(var0, "field");
      return new FieldInfo(var0, var1, FieldType.MAP, (Class)null, (Field)null, 0, false, true, (OneofInfo)null, (Class)null, var2, var3, (Field)null);
   }

   private FieldInfo(Field var1, int var2, FieldType var3, Class var4, Field var5, int var6, boolean var7, boolean var8, OneofInfo var9, Class var10, Object var11, Internal.EnumVerifier var12, Field var13) {
      this.field = var1;
      this.type = var3;
      this.messageClass = var4;
      this.fieldNumber = var2;
      this.presenceField = var5;
      this.presenceMask = var6;
      this.required = var7;
      this.enforceUtf8 = var8;
      this.oneof = var9;
      this.oneofStoredType = var10;
      this.mapDefaultEntry = var11;
      this.enumVerifier = var12;
      this.cachedSizeField = var13;
   }

   public int getFieldNumber() {
      return this.fieldNumber;
   }

   public Field getField() {
      return this.field;
   }

   public FieldType getType() {
      return this.type;
   }

   public OneofInfo getOneof() {
      return this.oneof;
   }

   public Class getOneofStoredType() {
      return this.oneofStoredType;
   }

   public Internal.EnumVerifier getEnumVerifier() {
      return this.enumVerifier;
   }

   public int compareTo(FieldInfo var1) {
      return this.fieldNumber - var1.fieldNumber;
   }

   public Class getListElementType() {
      return this.messageClass;
   }

   public Field getPresenceField() {
      return this.presenceField;
   }

   public Object getMapDefaultEntry() {
      return this.mapDefaultEntry;
   }

   public int getPresenceMask() {
      return this.presenceMask;
   }

   public boolean isRequired() {
      return this.required;
   }

   public boolean isEnforceUtf8() {
      return this.enforceUtf8;
   }

   public Field getCachedSizeField() {
      return this.cachedSizeField;
   }

   public Class getMessageFieldClass() {
      switch(this.type) {
      case MESSAGE:
      case GROUP:
         return this.field != null ? this.field.getType() : this.oneofStoredType;
      case MESSAGE_LIST:
      case GROUP_LIST:
         return this.messageClass;
      default:
         return null;
      }
   }

   public static FieldInfo.Builder newBuilder() {
      return new FieldInfo.Builder();
   }

   private static boolean isExactlyOneBitSet(int var0) {
      return var0 != 0 && (var0 & var0 - 1) == 0;
   }

   @Override
   public int compareTo(Object o) {
      return 0;
   }

   public static final class Builder {
      private Field field;
      private FieldType type;
      private int fieldNumber;
      private Field presenceField;
      private int presenceMask;
      private boolean required;
      private boolean enforceUtf8;
      private OneofInfo oneof;
      private Class oneofStoredType;
      private Object mapDefaultEntry;
      private Internal.EnumVerifier enumVerifier;
      private Field cachedSizeField;

      private Builder() {
      }

      public FieldInfo.Builder withField(Field var1) {
         if (this.oneof != null) {
            throw new IllegalStateException("Cannot set field when building a oneof.");
         } else {
            this.field = var1;
            return this;
         }
      }

      public FieldInfo.Builder withType(FieldType var1) {
         this.type = var1;
         return this;
      }

      public FieldInfo.Builder withFieldNumber(int var1) {
         this.fieldNumber = var1;
         return this;
      }

      public FieldInfo.Builder withPresence(Field var1, int var2) {
         this.presenceField = (Field)Internal.checkNotNull(var1, "presenceField");
         this.presenceMask = var2;
         return this;
      }

      public FieldInfo.Builder withOneof(OneofInfo var1, Class var2) {
         if (this.field == null && this.presenceField == null) {
            this.oneof = var1;
            this.oneofStoredType = var2;
            return this;
         } else {
            throw new IllegalStateException("Cannot set oneof when field or presenceField have been provided");
         }
      }

      public FieldInfo.Builder withRequired(boolean var1) {
         this.required = var1;
         return this;
      }

      public FieldInfo.Builder withMapDefaultEntry(Object var1) {
         this.mapDefaultEntry = var1;
         return this;
      }

      public FieldInfo.Builder withEnforceUtf8(boolean var1) {
         this.enforceUtf8 = var1;
         return this;
      }

      public FieldInfo.Builder withEnumVerifier(Internal.EnumVerifier var1) {
         this.enumVerifier = var1;
         return this;
      }

      public FieldInfo.Builder withCachedSizeField(Field var1) {
         this.cachedSizeField = var1;
         return this;
      }

      public FieldInfo build() {
         if (this.oneof != null) {
            return FieldInfo.forOneofMemberField(this.fieldNumber, this.type, this.oneof, this.oneofStoredType, this.enforceUtf8, this.enumVerifier);
         } else if (this.mapDefaultEntry != null) {
            return FieldInfo.forMapField(this.field, this.fieldNumber, this.mapDefaultEntry, this.enumVerifier);
         } else if (this.presenceField != null) {
            return this.required ? FieldInfo.forProto2RequiredField(this.field, this.fieldNumber, this.type, this.presenceField, this.presenceMask, this.enforceUtf8, this.enumVerifier) : FieldInfo.forProto2OptionalField(this.field, this.fieldNumber, this.type, this.presenceField, this.presenceMask, this.enforceUtf8, this.enumVerifier);
         } else if (this.enumVerifier != null) {
            return this.cachedSizeField == null ? FieldInfo.forFieldWithEnumVerifier(this.field, this.fieldNumber, this.type, this.enumVerifier) : FieldInfo.forPackedFieldWithEnumVerifier(this.field, this.fieldNumber, this.type, this.enumVerifier, this.cachedSizeField);
         } else {
            return this.cachedSizeField == null ? FieldInfo.forField(this.field, this.fieldNumber, this.type, this.enforceUtf8) : FieldInfo.forPackedField(this.field, this.fieldNumber, this.type, this.cachedSizeField);
         }
      }

      // $FF: synthetic method
      Builder(Object var1) {
         this();
      }
   }
}
