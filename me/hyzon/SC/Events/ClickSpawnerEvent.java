/*    */ package me.hyzon.SC.Events;
/*    */ 
/*    */ import me.hyzon.SC.Main;
/*    */ import me.hyzon.SC.Open;
/*    */ import org.bukkit.Chunk;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ 
/*    */ public class ClickSpawnerEvent
/*    */   implements Listener
/*    */ {
/* 18 */   Main x = (Main)Main.getPlugin(Main.class);
/*    */   
/*    */   @EventHandler
/*    */   public void ClickSpawner(PlayerInteractEvent e) {
/* 22 */     Player p = e.getPlayer();
/* 23 */     Action a = e.getAction();
/* 24 */     Block b = e.getClickedBlock();
/* 25 */     if (a == Action.RIGHT_CLICK_BLOCK && 
/* 26 */       p.isSneaking()) {
/* 27 */       if (e.getItem() == null)
/*    */         return; 
/* 29 */       Material i = e.getItem().getType();
/* 30 */       if (b.getType() == Material.MOB_SPAWNER && i == Material.STICK) {
/* 31 */         Location m = b.getLocation();
/* 32 */         (new Open()).menu(m.getWorld(), m, p);
/* 33 */         Chunk c = m.getWorld().getChunkAt(b);
/* 34 */         int cX = c.getX() << 4;
/* 35 */         int cZ = c.getZ() << 4;
/* 36 */         String cgi = String.valueOf(String.valueOf(cX)) + "-" + String.valueOf(cZ);
/* 37 */         this.x.pcgi.put(p.getName(), cgi);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\hongb\Downloads\SpawnerChunks.jar!\me\hyzon\SC\Events\ClickSpawnerEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */