/*    */ package me.hyzon.SC;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Chunk;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ public class Open
/*    */ {
/* 17 */   Main x = (Main)Main.getPlugin(Main.class);
/* 18 */   Tasks task = new Tasks();
/*    */   
/*    */   public void menu(World w, Location l, final Player p) {
/* 21 */     Chunk c = w.getChunkAt(l);
/* 22 */     String cgi = String.valueOf(String.valueOf(c.getX() << 4)) + "-" + String.valueOf(c.getZ() << 4);
/*    */     
/* 24 */     final Inventory i = Bukkit.getServer().createInventory(null, 9, this.x.in);
/*    */     
/* 26 */     ItemStack T = new ItemStack(Material.PAPER);
/* 27 */     ItemMeta TM = T.getItemMeta();
/* 28 */     int am = this.x.getConfig().getInt("Default-Amount") + this.task.getChunkE(cgi);
/* 29 */     TM.setDisplayName("§6(§a" + (new Tasks()).getChunkC(cgi) + "§6/" + am + ")");
/* 30 */     T.setItemMeta(TM);
/*    */     
/* 32 */     ItemStack E = new ItemStack(Material.PAPER);
/* 33 */     ItemMeta EM = E.getItemMeta();
/* 34 */     int mx = this.x.getConfig().getInt("Default-Amount") + this.task.getChunkE(cgi);
/* 35 */     int left = this.x.getConfig().getInt("Added-Max-Amount") + this.x.getConfig().getInt("Default-Amount") - mx;
/* 36 */     if (this.x.ecof) {
/* 37 */       EM.setDisplayName("§a" + left + " §6left to buy.");
/*    */     }
/* 39 */     if (!this.x.ecof) {
/* 40 */       EM.setDisplayName("§cFeature disabled.");
/* 41 */       EM.setLore(Arrays.asList(new String[] { "§8---------------", "§7Feature disabled due", "§7to no Vault dependency found!", "§8---------------" }));
/*    */     } 
/* 43 */     E.setItemMeta(EM);
/*    */     
/* 45 */     ItemStack A = new ItemStack(Material.MOB_SPAWNER);
/* 46 */     ItemMeta AM = A.getItemMeta();
/* 47 */     int max = this.x.getConfig().getInt("Added-Max-Amount");
/* 48 */     int e = this.task.getChunkE(cgi);
/* 49 */     if (e > max - 1) {
/* 50 */       AM.setDisplayName("§cLimit has been reached.");
/*    */     } else {
/* 52 */       AM.setDisplayName("§6Add §a1 §6to this chunk.");
/*    */     } 
/* 54 */     if (!this.x.ecof) {
/* 55 */       AM.setDisplayName("§cFeature disabled.");
/* 56 */       AM.setLore(Arrays.asList(new String[] { "§8---------------", "§7Feature disabled due", "§7to no Vault dependency found!", "§8---------------" }));
/*    */     } 
/* 58 */     if (this.x.ecof) {
/* 59 */       AM.setLore(Arrays.asList(new String[] { "§8---------------", "§7Cost: §b$" + this.x.cost, "§8---------------" }));
/*    */     }
/* 61 */     A.setItemMeta(AM);
/*    */     
/* 63 */     i.setItem(2, T);
/* 64 */     i.setItem(4, A);
/* 65 */     i.setItem(6, E);
/*    */     
/* 67 */     p.sendMessage(String.valueOf(this.x.prefix) + "Opening the menu!");
/* 68 */     Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.x, new Runnable() {
/*    */           public void run() {
/* 70 */             p.openInventory(i);
/*    */           }
/* 72 */         },  5L);
/*    */   }
/*    */ }


/* Location:              C:\Users\hongb\Downloads\SpawnerChunks.jar!\me\hyzon\SC\Open.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */