/*    */ package me.hyzon.SC;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ 
/*    */ 
/*    */ public class Tasks
/*    */ {
/* 10 */   File FL = new File("plugins/SpawnerChunks/Data.yml");
/* 11 */   YamlConfiguration YC = YamlConfiguration.loadConfiguration(this.FL);
/*    */   
/*    */   public int getChunkC(String cgi) {
/* 14 */     return this.YC.getInt("Chunks." + cgi + ".c");
/*    */   }
/*    */   
/*    */   public int getChunkE(String cgi) {
/* 18 */     return this.YC.getInt("Chunks." + cgi + ".e");
/*    */   }
/*    */   
/*    */   public void setChunkE(String cgi, int set) {
/* 22 */     this.YC.set("Chunks." + cgi + ".e", Integer.valueOf(set));
/* 23 */     save();
/*    */   }
/*    */   
/*    */   public void setChunkC(String cgi, int set) {
/* 27 */     this.YC.set("Chunks." + cgi + ".c", Integer.valueOf(set));
/* 28 */     save();
/*    */   }
/*    */   
/*    */   public void setcgi(String cgi, String set) {
/* 32 */     this.YC.set("Chunks." + cgi, set);
/* 33 */     save();
/*    */   }
/*    */   
/*    */   public boolean cgiCheck(String cgi) {
/* 37 */     if (this.YC.getString("Chunks." + cgi) == null) {
/* 38 */       return true;
/*    */     }
/* 40 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void save() {
/*    */     try {
/* 46 */       this.YC.save(this.FL);
/* 47 */     } catch (IOException e) {
/* 48 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\hongb\Downloads\SpawnerChunks.jar!\me\hyzon\SC\Tasks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */