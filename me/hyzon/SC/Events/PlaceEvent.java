/*    */ package me.hyzon.SC.Events;
/*    */ 
/*    */ import me.hyzon.SC.Main;
/*    */ import me.hyzon.SC.Tasks;
/*    */ import org.bukkit.Chunk;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.BlockPlaceEvent;
/*    */ 
/*    */ public class PlaceEvent
/*    */   implements Listener
/*    */ {
/* 17 */   Main x = (Main)Main.getPlugin(Main.class);
/*    */   
/*    */   @EventHandler
/*    */   public void Place(BlockPlaceEvent e) {
/* 21 */     Player p = e.getPlayer();
/* 22 */     Block b = e.getBlock();
/* 23 */     World w = b.getWorld();
/* 24 */     Chunk c = w.getChunkAt(b);
/* 25 */     int cX = c.getX() << 4;
/* 26 */     int cZ = c.getZ() << 4;
/* 27 */     String cgi = String.valueOf(String.valueOf(cX)) + "-" + String.valueOf(cZ);
/* 28 */     if (b.getType() == Material.MOB_SPAWNER) {
/* 29 */       int count = 0;
/* 30 */       for (int xs = cX; xs < 16 + cX; xs++) {
/* 31 */         for (int zs = cZ; zs < 16 + cZ; zs++) {
/* 32 */           for (int ys = 0; ys < 256; ys++) {
/* 33 */             if (w.getBlockAt(xs, ys, zs).getType() == Material.MOB_SPAWNER) {
/* 34 */               if ((new Tasks()).cgiCheck(cgi)) {
/* 35 */                 (new Tasks()).setChunkE(cgi, 0);
/* 36 */                 (new Tasks()).setChunkC(cgi, 0);
/*    */               } 
/* 38 */               count++;
/*    */             } 
/*    */           } 
/*    */         } 
/*    */       } 
/* 43 */       if (this.x.getConfig().getBoolean("Auto-SetBack")) {
/* 44 */         int Max = this.x.getConfig().getInt("Added-Max-Amount") + this.x.getConfig().getInt("Default-Amount");
/* 45 */         int cc = (new Tasks()).getChunkC(cgi);
/* 46 */         if (cc > Max - 1) {
/* 47 */           (new Tasks()).setChunkE(cgi, this.x.getConfig().getInt("Added-Max-Amount"));
/*    */         }
/*    */       } 
/* 50 */       int max = this.x.getConfig().getInt("Default-Amount") + (new Tasks()).getChunkE(cgi);
/* 51 */       if (count > max) {
/* 52 */         e.setCancelled(true);
/* 53 */         p.sendMessage(String.valueOf(this.x.prefix) + "You have reached the maximum amount of spawners in this chunk!");
/* 54 */         if ((new Tasks()).getChunkC(cgi) != count) {
/* 55 */           (new Tasks()).setChunkC(cgi, max);
/*    */         }
/*    */       } else {
/* 58 */         if (this.x.getConfig().getBoolean("Msg")) {
/* 59 */           p.sendMessage(String.valueOf(this.x.prefix) + "(§6" + count + this.x.clr + "/" + max + ")");
/*    */         }
/* 61 */         if ((new Tasks()).getChunkC(cgi) != count)
/* 62 */           (new Tasks()).setChunkC(cgi, count); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\hongb\Downloads\SpawnerChunks.jar!\me\hyzon\SC\Events\PlaceEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */