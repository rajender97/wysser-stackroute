package com.google.protobuf;

public enum JavaType {
   VOID(Void.class, Void.class, (Object)null),
   INT(Integer.TYPE, Integer.class, 0),
   LONG(Long.TYPE, Long.class, 0L),
   FLOAT(Float.TYPE, Float.class, 0.0F),
   DOUBLE(Double.TYPE, Double.class, 0.0D),
   BOOLEAN(Boolean.TYPE, Boolean.class, false),
   STRING(String.class, String.class, ""),
   BYTE_STRING(ByteString.class, ByteString.class, ByteString.EMPTY),
   ENUM(Integer.TYPE, Integer.class, (Object)null),
   MESSAGE(Object.class, Object.class, (Object)null);

   private final Class type;
   private final Class boxedType;
   private final Object defaultDefault;

   private JavaType(Class var3, Class var4, Object var5) {
      this.type = var3;
      this.boxedType = var4;
      this.defaultDefault = var5;
   }

   public Object getDefaultDefault() {
      return this.defaultDefault;
   }

   public Class getType() {
      return this.type;
   }

   public Class getBoxedType() {
      return this.boxedType;
   }

   public boolean isValidType(Class var1) {
      return this.type.isAssignableFrom(var1);
   }
}
