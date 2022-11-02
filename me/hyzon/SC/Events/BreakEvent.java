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
/*    */ import org.bukkit.event.block.BlockBreakEvent;
/*    */ 
/*    */ public class BreakEvent
/*    */   implements Listener
/*    */ {
/* 17 */   Main x = (Main)Main.getPlugin(Main.class);
/*    */   
/*    */   @EventHandler
/*    */   public void Break(BlockBreakEvent e) {
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
/* 43 */       int max = this.x.getConfig().getInt("Default-Amount") + (new Tasks()).getChunkE(cgi);
/* 44 */       if (this.x.getConfig().getBoolean("Msg")) {
/* 45 */         p.sendMessage(String.valueOf(this.x.prefix) + "(§6" + (count - 1) + this.x.clr + "/" + max + ")");
/*    */       }
/* 47 */       if ((new Tasks()).getChunkC(cgi) != count - 1) {
/* 48 */         (new Tasks()).setChunkC(cgi, count - 1);
/*    */       }
/* 50 */       if (this.x.getConfig().getBoolean("Auto-SetBack")) {
/* 51 */         int Max = this.x.getConfig().getInt("Added-Max-Amount") + this.x.getConfig().getInt("Default-Amount");
/* 52 */         int cc = (new Tasks()).getChunkC(cgi);
/* 53 */         if (cc > Max - 1) {
/* 54 */           (new Tasks()).setChunkC(cgi, this.x.getConfig().getInt("Added-Max-Amount"));
/*    */         }
/*    */       } 
/* 57 */       if ((new Tasks()).getChunkE(cgi) == 0 && (new Tasks()).getChunkC(cgi) == 0)
/* 58 */         (new Tasks()).setcgi(cgi, null); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\hongb\Downloads\SpawnerChunks.jar!\me\hyzon\SC\Events\BreakEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */