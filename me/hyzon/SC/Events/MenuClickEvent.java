/*    */ package me.hyzon.SC.Events;
/*    */ 
/*    */ import me.hyzon.SC.Main;
/*    */ import me.hyzon.SC.Tasks;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.inventory.InventoryClickEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class MenuClickEvent
/*    */   implements Listener {
/* 15 */   Main x = (Main)Main.getPlugin(Main.class);
/*    */   
/*    */   @EventHandler
/*    */   public void Click(InventoryClickEvent e) {
/* 19 */     if (e.getWhoClicked() instanceof Player && 
/* 20 */       e.getInventory().getName().equals(this.x.in)) {
/* 21 */       Player p = (Player)e.getWhoClicked();
/* 22 */       ItemStack is = e.getCurrentItem();
/* 23 */       if (is == null || !is.hasItemMeta() || is.getType() == Material.AIR) {
/* 24 */         e.setCancelled(true);
/*    */         return;
/*    */       } 
/* 27 */       e.setCancelled(true);
/*    */       
/* 29 */       String gn = is.getItemMeta().getDisplayName();
/* 30 */       if (gn.equals("§6Add §a1 §6to this chunk.")) {
/* 31 */         double balance = this.x.eco.getBalance((OfflinePlayer)p);
/* 32 */         double price = this.x.getConfig().getDouble("Price-For-Each-Upgrade");
/* 33 */         if (balance > price - 0.01D) {
/* 34 */           if (this.x.pcgi.containsKey(p.getName())) {
/* 35 */             String cgi = (String)this.x.pcgi.get(p.getName());
/* 36 */             int max = this.x.getConfig().getInt("Added-Max-Amount");
/* 37 */             int ee = (new Tasks()).getChunkE(cgi);
/* 38 */             if (ee > max - 1) {
/* 39 */               p.closeInventory();
/*    */             } else {
/* 41 */               this.x.eco.withdrawPlayer((OfflinePlayer)p, this.x.cost);
/* 42 */               p.sendMessage(String.valueOf(this.x.prefix) + "§a1 " + this.x.clr + "has been added to this chunk!");
/* 43 */               (new Tasks()).setChunkE(cgi, (new Tasks()).getChunkE(cgi) + 1);
/*    */             } 
/*    */           } else {
/* 46 */             p.sendMessage(String.valueOf(this.x.prefix) + "Error occurred! Please retry!");
/*    */           } 
/*    */         } else {
/* 49 */           p.sendMessage(String.valueOf(this.x.prefix) + "You do not have enough money!");
/*    */         } 
/* 51 */         p.closeInventory();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\hongb\Downloads\SpawnerChunks.jar!\me\hyzon\SC\Events\MenuClickEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */