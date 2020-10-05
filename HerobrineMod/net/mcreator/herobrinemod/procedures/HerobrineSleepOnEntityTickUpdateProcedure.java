/*    */ package net.mcreator.herobrinemod.procedures;
/*    */ 
/*    */ import java.util.Map;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModElements;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModElements.ModElement.Tag;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModVariables;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.world.IWorld;
/*    */ 
/*    */ @Tag
/*    */ public class HerobrineSleepOnEntityTickUpdateProcedure
/*    */   extends HerobrinemodModElements.ModElement {
/*    */   public HerobrineSleepOnEntityTickUpdateProcedure(HerobrinemodModElements instance) {
/* 14 */     super(instance, 6);
/*    */   }
/*    */   
/*    */   public static void executeProcedure(Map<String, Object> dependencies) {
/* 18 */     if (dependencies.get("entity") == null) {
/* 19 */       System.err.println("Failed to load dependency entity for procedure HerobrineSleepOnEntityTickUpdate!");
/*    */       return;
/*    */     } 
/* 22 */     if (dependencies.get("world") == null) {
/* 23 */       System.err.println("Failed to load dependency world for procedure HerobrineSleepOnEntityTickUpdate!");
/*    */       return;
/*    */     } 
/* 26 */     Entity entity = (Entity)dependencies.get("entity");
/* 27 */     IWorld world = (IWorld)dependencies.get("world");
/* 28 */     if ((HerobrinemodModVariables.MapVariables.get(world)).timeSec >= 0.5D && 
/* 29 */       !entity.field_70170_p.field_72995_K)
/* 30 */       entity.func_70106_y(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\HerobrineMod.jar!\net\mcreator\herobrinemod\procedures\HerobrineSleepOnEntityTickUpdateProcedure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */