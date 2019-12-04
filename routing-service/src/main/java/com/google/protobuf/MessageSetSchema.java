package com.google.protobuf;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

final class MessageSetSchema implements Schema {
   private final MessageLite defaultInstance;
   private final UnknownFieldSchema unknownFieldSchema;
   private final boolean hasExtensions;
   private final ExtensionSchema extensionSchema;

   private MessageSetSchema(UnknownFieldSchema var1, ExtensionSchema var2, MessageLite var3) {
      this.unknownFieldSchema = var1;
      this.hasExtensions = var2.hasExtensions(var3);
      this.extensionSchema = var2;
      this.defaultInstance = var3;
   }

   static MessageSetSchema newSchema(UnknownFieldSchema var0, ExtensionSchema var1, MessageLite var2) {
      return new MessageSetSchema(var0, var1, var2);
   }

   public Object newInstance() {
      return this.defaultInstance.newBuilderForType().buildPartial();
   }

   public boolean equals(Object var1, Object var2) {
      Object var3 = this.unknownFieldSchema.getFromMessage(var1);
      Object var4 = this.unknownFieldSchema.getFromMessage(var2);
      if (!var3.equals(var4)) {
         return false;
      } else if (this.hasExtensions) {
         FieldSet var5 = this.extensionSchema.getExtensions(var1);
         FieldSet var6 = this.extensionSchema.getExtensions(var2);
         return var5.equals(var6);
      } else {
         return true;
      }
   }

   public int hashCode(Object var1) {
      int var2 = this.unknownFieldSchema.getFromMessage(var1).hashCode();
      if (this.hasExtensions) {
         FieldSet var3 = this.extensionSchema.getExtensions(var1);
         var2 = var2 * 53 + var3.hashCode();
      }

      return var2;
   }

   public void mergeFrom(Object var1, Object var2) {
      SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, var1, var2);
      if (this.hasExtensions) {
         SchemaUtil.mergeExtensions(this.extensionSchema, var1, var2);
      }

   }

   public void writeTo(Object var1, Writer var2) throws IOException {
      FieldSet var3 = this.extensionSchema.getExtensions(var1);
      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         Entry var5 = (Entry)var4.next();
         FieldSet.FieldDescriptorLite var6 = (FieldSet.FieldDescriptorLite)var5.getKey();
         if (var6.getLiteJavaType() != WireFormat.JavaType.MESSAGE || var6.isRepeated() || var6.isPacked()) {
            throw new IllegalStateException("Found invalid MessageSet item.");
         }

         if (var5 instanceof LazyField.LazyEntry) {
            var2.writeMessageSetItem(var6.getNumber(), ((LazyField.LazyEntry)var5).getField().toByteString());
         } else {
            var2.writeMessageSetItem(var6.getNumber(), var5.getValue());
         }
      }

      this.writeUnknownFieldsHelper(this.unknownFieldSchema, var1, var2);
   }

   private void writeUnknownFieldsHelper(UnknownFieldSchema var1, Object var2, Writer var3) throws IOException {
      var1.writeAsMessageSetTo(var1.getFromMessage(var2), var3);
   }

   public void mergeFrom(Object var1, byte[] var2, int var3, int var4, ArrayDecoders.Registers var5) throws IOException {
      UnknownFieldSetLite var6 = ((GeneratedMessageLite)var1).unknownFields;
      if (var6 == UnknownFieldSetLite.getDefaultInstance()) {
         var6 = UnknownFieldSetLite.newInstance();
         ((GeneratedMessageLite)var1).unknownFields = var6;
      }

      FieldSet var7 = ((GeneratedMessageLite.ExtendableMessage)var1).ensureExtensionsAreMutable();
      GeneratedMessageLite.GeneratedExtension var8 = null;

      while(true) {
         while(var3 < var4) {
            var3 = ArrayDecoders.decodeVarint32(var2, var3, var5);
            int var9 = var5.int1;
            if (var9 != WireFormat.MESSAGE_SET_ITEM_TAG) {
               if (WireFormat.getTagWireType(var9) == 2) {
                  var8 = (GeneratedMessageLite.GeneratedExtension)this.extensionSchema.findExtensionByNumber(var5.extensionRegistry, this.defaultInstance, WireFormat.getTagFieldNumber(var9));
                  if (var8 != null) {
                     var3 = ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(var8.getMessageDefaultInstance().getClass()), var2, var3, var4, var5);
                     var7.setField(var8.descriptor, var5.object1);
                  } else {
                     var3 = ArrayDecoders.decodeUnknownField(var9, var2, var3, var4, var6, var5);
                  }
               } else {
                  var3 = ArrayDecoders.skipField(var9, var2, var3, var4, var5);
               }
            } else {
               int var10 = 0;
               ByteString var11 = null;

               while(var3 < var4) {
                  var3 = ArrayDecoders.decodeVarint32(var2, var3, var5);
                  int var12 = var5.int1;
                  int var13 = WireFormat.getTagFieldNumber(var12);
                  int var14 = WireFormat.getTagWireType(var12);
                  switch(var13) {
                  case 2:
                     if (var14 == 0) {
                        var3 = ArrayDecoders.decodeVarint32(var2, var3, var5);
                        var10 = var5.int1;
                        var8 = (GeneratedMessageLite.GeneratedExtension)this.extensionSchema.findExtensionByNumber(var5.extensionRegistry, this.defaultInstance, var10);
                        continue;
                     }
                     break;
                  case 3:
                     if (var8 != null) {
                        var3 = ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(var8.getMessageDefaultInstance().getClass()), var2, var3, var4, var5);
                        var7.setField(var8.descriptor, var5.object1);
                        continue;
                     }

                     if (var14 == 2) {
                        var3 = ArrayDecoders.decodeBytes(var2, var3, var5);
                        var11 = (ByteString)var5.object1;
                        continue;
                     }
                  }

                  if (var12 == WireFormat.MESSAGE_SET_ITEM_END_TAG) {
                     break;
                  }

                  var3 = ArrayDecoders.skipField(var12, var2, var3, var4, var5);
               }

               if (var11 != null) {
                  var6.storeField(WireFormat.makeTag(var10, 2), var11);
               }
            }
         }

         if (var3 != var4) {
            throw InvalidProtocolBufferException.parseFailure();
         }

         return;
      }
   }

   public void mergeFrom(Object var1, Reader var2, ExtensionRegistryLite var3) throws IOException {
      this.mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, var1, var2, var3);
   }

   private void mergeFromHelper(UnknownFieldSchema var1, ExtensionSchema var2, Object var3, Reader var4, ExtensionRegistryLite var5) throws IOException {
      Object var6 = var1.getBuilderFromMessage(var3);
      FieldSet var7 = var2.getMutableExtensions(var3);

      while(true) {
         try {
            int var8 = var4.getFieldNumber();
            if (var8 == Integer.MAX_VALUE) {
               return;
            }

            if (this.parseMessageSetItemOrUnknownField(var4, var5, var2, var7, var1, var6)) {
               continue;
            }
         } finally {
            var1.setBuilderToMessage(var3, var6);
         }

         return;
      }
   }

   public void makeImmutable(Object var1) {
      this.unknownFieldSchema.makeImmutable(var1);
      this.extensionSchema.makeImmutable(var1);
   }

   private boolean parseMessageSetItemOrUnknownField(Reader var1, ExtensionRegistryLite var2, ExtensionSchema var3, FieldSet var4, UnknownFieldSchema var5, Object var6) throws IOException {
      int var7 = var1.getTag();
      if (var7 != WireFormat.MESSAGE_SET_ITEM_TAG) {
         if (WireFormat.getTagWireType(var7) == 2) {
            Object var13 = var3.findExtensionByNumber(var2, this.defaultInstance, WireFormat.getTagFieldNumber(var7));
            if (var13 != null) {
               var3.parseLengthPrefixedMessageSetItem(var1, var13, var2, var4);
               return true;
            } else {
               return var5.mergeOneFieldFrom(var6, var1);
            }
         } else {
            return var1.skipField();
         }
      } else {
         int var8 = 0;
         ByteString var9 = null;
         Object var10 = null;

         while(true) {
            int var11 = var1.getFieldNumber();
            if (var11 == Integer.MAX_VALUE) {
               break;
            }

            int var12 = var1.getTag();
            if (var12 == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
               var8 = var1.readUInt32();
               var10 = var3.findExtensionByNumber(var2, this.defaultInstance, var8);
            } else if (var12 == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
               if (var10 != null) {
                  var3.parseLengthPrefixedMessageSetItem(var1, var10, var2, var4);
               } else {
                  var9 = var1.readBytes();
               }
            } else if (!var1.skipField()) {
               break;
            }
         }

         if (var1.getTag() != WireFormat.MESSAGE_SET_ITEM_END_TAG) {
            throw InvalidProtocolBufferException.invalidEndTag();
         } else {
            if (var9 != null) {
               if (var10 != null) {
                  var3.parseMessageSetItem(var9, var10, var2, var4);
               } else {
                  var5.addLengthDelimited(var6, var8, var9);
               }
            }

            return true;
         }
      }
   }

   public final boolean isInitialized(Object var1) {
      FieldSet var2 = this.extensionSchema.getExtensions(var1);
      return var2.isInitialized();
   }

   public int getSerializedSize(Object var1) {
      byte var2 = 0;
      int var3 = var2 + this.getUnknownFieldsSerializedSize(this.unknownFieldSchema, var1);
      if (this.hasExtensions) {
         var3 += this.extensionSchema.getExtensions(var1).getMessageSetSerializedSize();
      }

      return var3;
   }

   private int getUnknownFieldsSerializedSize(UnknownFieldSchema var1, Object var2) {
      Object var3 = var1.getFromMessage(var2);
      return var1.getSerializedSizeAsMessageSet(var3);
   }
}
