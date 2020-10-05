/*    */ package net.mcreator.herobrinemod.procedures;
/*    */ 
/*    */ import java.util.Map;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModElements;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModElements.ModElement.Tag;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModVariables;
/*    */ import net.minecraft.world.IWorld;
/*    */ 
/*    */ @Tag
/*    */ public class HerobrineSleepOnInitialEntitySpawnProcedure
/*    */   extends HerobrinemodModElements.ModElement {
/*    */   public HerobrineSleepOnInitialEntitySpawnProcedure(HerobrinemodModElements instance) {
/* 13 */     super(instance, 5);
/*    */   }
/*    */   
/*    */   public static void executeProcedure(Map<String, Object> dependencies) {
/* 17 */     if (dependencies.get("world") == null) {
/* 18 */       System.err.println("Failed to load dependency world for procedure HerobrineSleepOnInitialEntitySpawn!");
/*    */       return;
/*    */     } 
/* 21 */     IWorld world = (IWorld)dependencies.get("world");
/* 22 */     (HerobrinemodModVariables.MapVariables.get(world)).timeSec = 0.0D;
/* 23 */     HerobrinemodModVariables.MapVariables.get(world).syncData(world);
/*    */   }
/*    */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\HerobrineMod.jar!\net\mcreator\herobrinemod\procedures\HerobrineSleepOnInitialEntitySpawnProcedure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */