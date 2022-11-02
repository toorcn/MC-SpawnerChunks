/*    */ package me.hyzon.SC;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class MFile
/*    */ {
/*  8 */   Main c = (Main)Main.getPlugin(Main.class);
/*    */   
/* 10 */   File DF = this.c.DIR;
/* 11 */   File LN = this.c.F;
/*    */   
/*    */   public void Create() {
/* 14 */     if (!this.DF.exists()) {
/*    */       try {
/* 16 */         this.DF.mkdir();
/* 17 */         this.DF.createNewFile();
/* 18 */       } catch (IOException e) {
/* 19 */         e.printStackTrace();
/*    */       } 
/*    */     }
/* 22 */     if (this.DF.exists() && 
/* 23 */       !this.LN.exists())
/*    */       try {
/* 25 */         this.LN.createNewFile();
/* 26 */       } catch (IOException e) {
/* 27 */         e.printStackTrace();
/*    */       }  
/*    */   }
/*    */ }


/* Location:              C:\Users\hongb\Downloads\SpawnerChunks.jar!\me\hyzon\SC\MFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */