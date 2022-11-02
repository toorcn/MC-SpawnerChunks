/*    */ package me.hyzon.SC;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.util.HashMap;
/*    */ import java.util.logging.Logger;
/*    */ import me.hyzon.SC.Events.BreakEvent;
/*    */ import me.hyzon.SC.Events.ClickSpawnerEvent;
/*    */ import me.hyzon.SC.Events.MenuClickEvent;
/*    */ import me.hyzon.SC.Events.PlaceEvent;
/*    */ import net.milkbowl.vault.economy.Economy;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ 
/*    */ public class Main
/*    */   extends JavaPlugin
/*    */   implements Listener
/*    */ {
/* 20 */   public File DIR = new File("plugins/SpawnerChunks");
/* 21 */   public File F = new File("plugins/SpawnerChunks/Data.yml");
/* 22 */   public String prefix = "§aSpawner§6Chunks §8- §7";
/* 23 */   public String clr = "§7";
/* 24 */   public double version = 1.0D;
/* 25 */   public String in = "§aSpawner§6Chunks §6v§c" + this.version;
/* 26 */   public HashMap<String, String> pcgi = new HashMap<>();
/* 27 */   public double cost = getConfig().getDouble("Price-For-Each-Upgrade");
/*    */   
/*    */   public boolean ecof;
/* 30 */   public final Logger log = Logger.getLogger("Minecraft");
/* 31 */   public Economy eco = null;
/*    */   
/*    */   public void onEnable() {
/* 34 */     getConfig().options().copyDefaults(true);
/* 35 */     saveConfig();
/* 36 */     (new MFile()).Create();
/* 37 */     getServer().getPluginManager().registerEvents((Listener)new MenuClickEvent(), (Plugin)this);
/* 38 */     getServer().getPluginManager().registerEvents((Listener)new PlaceEvent(), (Plugin)this);
/* 39 */     getServer().getPluginManager().registerEvents((Listener)new BreakEvent(), (Plugin)this);
/* 40 */     getServer().getPluginManager().registerEvents((Listener)new ClickSpawnerEvent(), (Plugin)this);
/* 41 */     (new EcoSetup()).setup();
/*    */   }
/*    */ }


/* Location:              C:\Users\hongb\Downloads\SpawnerChunks.jar!\me\hyzon\SC\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */