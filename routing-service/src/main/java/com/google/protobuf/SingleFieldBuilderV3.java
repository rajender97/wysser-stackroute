package com.google.protobuf;

public class SingleFieldBuilderV3 implements AbstractMessage.BuilderParent {
   private AbstractMessage.BuilderParent parent;
   private AbstractMessage.Builder builder;
   private AbstractMessage message;
   private boolean isClean;

   public SingleFieldBuilderV3(AbstractMessage var1, AbstractMessage.BuilderParent var2, boolean var3) {
      this.message = (AbstractMessage)Internal.checkNotNull(var1);
      this.parent = var2;
      this.isClean = var3;
   }

   public void dispose() {
      this.parent = null;
   }

   public AbstractMessage getMessage() {
      if (this.message == null) {
         this.message = (AbstractMessage)this.builder.buildPartial();
      }

      return this.message;
   }

   public AbstractMessage build() {
      this.isClean = true;
      return this.getMessage();
   }

   public AbstractMessage.Builder getBuilder() {
      if (this.builder == null) {
         this.builder = (AbstractMessage.Builder)this.message.newBuilderForType(this);
         this.builder.mergeFrom((Message)this.message);
         this.builder.markClean();
      }

      return this.builder;
   }

   public MessageOrBuilder getMessageOrBuilder() {
      return (MessageOrBuilder)(this.builder != null ? this.builder : this.message);
   }

   public SingleFieldBuilderV3 setMessage(AbstractMessage var1) {
      this.message = (AbstractMessage)Internal.checkNotNull(var1);
      if (this.builder != null) {
         this.builder.dispose();
         this.builder = null;
      }

      this.onChanged();
      return this;
   }

   public SingleFieldBuilderV3 mergeFrom(AbstractMessage var1) {
      if (this.builder == null && this.message == this.message.getDefaultInstanceForType()) {
         this.message = var1;
      } else {
         this.getBuilder().mergeFrom((Message)var1);
      }

      this.onChanged();
      return this;
   }

   public SingleFieldBuilderV3 clear() {
      this.message = (AbstractMessage)((AbstractMessage)(this.message != null ? this.message.getDefaultInstanceForType() : this.builder.getDefaultInstanceForType()));
      if (this.builder != null) {
         this.builder.dispose();
         this.builder = null;
      }

      this.onChanged();
      return this;
   }

   private void onChanged() {
      if (this.builder != null) {
         this.message = null;
      }

      if (this.isClean && this.parent != null) {
         this.parent.markDirty();
         this.isClean = false;
      }

   }

   public void markDirty() {
      this.onChanged();
   }
}
