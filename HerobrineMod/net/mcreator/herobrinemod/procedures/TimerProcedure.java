/*    */ package net.mcreator.herobrinemod.procedures;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModElements;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModElements.ModElement.Tag;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModVariables;
/*    */ import net.minecraft.world.IWorld;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ import net.minecraftforge.event.TickEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ 
/*    */ @Tag
/*    */ public class TimerProcedure
/*    */   extends HerobrinemodModElements.ModElement
/*    */ {
/*    */   public TimerProcedure(HerobrinemodModElements instance) {
/* 19 */     super(instance, 4);
/* 20 */     MinecraftForge.EVENT_BUS.register(this);
/*    */   }
/*    */   
/*    */   public static void executeProcedure(Map<String, Object> dependencies) {
/* 24 */     if (dependencies.get("world") == null) {
/* 25 */       System.err.println("Failed to load dependency world for procedure Timer!");
/*    */       return;
/*    */     } 
/* 28 */     IWorld world = (IWorld)dependencies.get("world");
/* 29 */     (HerobrinemodModVariables.MapVariables.get(world)).timeSec += 0.05D;
/* 30 */     HerobrinemodModVariables.MapVariables.get(world).syncData(world);
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onWorldTick(TickEvent.WorldTickEvent event) {
/* 35 */     if (event.phase == TickEvent.Phase.END) {
/* 36 */       World world = event.world;
/* 37 */       Map<String, Object> dependencies = new HashMap<>();
/* 38 */       dependencies.put("world", world);
/* 39 */       dependencies.put("event", event);
/* 40 */       this; executeProcedure(dependencies);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\HerobrineMod.jar!\net\mcreator\herobrinemod\procedures\TimerProcedure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */