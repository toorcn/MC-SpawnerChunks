/*    */ package me.hyzon.SC;
/*    */ 
/*    */ import net.milkbowl.vault.economy.Economy;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.plugin.RegisteredServiceProvider;
/*    */ 
/*    */ 
/*    */ public class EcoSetup
/*    */ {
/* 10 */   Main x = (Main)Main.getPlugin(Main.class);
/*    */   
/*    */   public boolean se() {
/* 13 */     if (Bukkit.getServer().getPluginManager().getPlugin("Vault") == null) {
/* 14 */       return false;
/*    */     }
/* 16 */     RegisteredServiceProvider<Economy> rsp = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
/* 17 */     if (rsp == null) {
/* 18 */       return false;
/*    */     }
/* 20 */     this.x.eco = (Economy)rsp.getProvider();
/* 21 */     return (this.x.eco != null);
/*    */   }
/*    */   
/*    */   public void setup() {
/* 25 */     if (!se()) {
/* 26 */       this.x.log.severe(String.format("[%s] - Add Spawner Feature disabled due to no Vault dependency found!", new Object[] { this.x.getDescription().getName() }));
/* 27 */       this.x.ecof = false;
/*    */     } 
/* 29 */     if (se())
/* 30 */       this.x.ecof = true; 
/*    */   }
/*    */ }


/* Location:              C:\Users\hongb\Downloads\SpawnerChunks.jar!\me\hyzon\SC\EcoSetup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */