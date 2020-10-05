/*    */ package net.mcreator.dreamboss.procedures;
/*    */ 
/*    */ import java.util.Map;
/*    */ import net.mcreator.dreamboss.DreambossModElements;
/*    */ import net.mcreator.dreamboss.DreambossModElements.ModElement.Tag;
/*    */ import net.mcreator.dreamboss.DreambossModVariables;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.LivingEntity;
/*    */ import net.minecraft.world.IWorld;
/*    */ 
/*    */ @Tag
/*    */ public class DreamBowOnInitialEntitySpawnProcedure
/*    */   extends DreambossModElements.ModElement {
/*    */   public DreamBowOnInitialEntitySpawnProcedure(DreambossModElements instance) {
/* 15 */     super(instance, 11);
/*    */   }
/*    */   
/*    */   public static void executeProcedure(Map<String, Object> dependencies) {
/* 19 */     if (dependencies.get("entity") == null) {
/* 20 */       System.err.println("Failed to load dependency entity for procedure DreamBowOnInitialEntitySpawn!");
/*    */       return;
/*    */     } 
/* 23 */     if (dependencies.get("world") == null) {
/* 24 */       System.err.println("Failed to load dependency world for procedure DreamBowOnInitialEntitySpawn!");
/*    */       return;
/*    */     } 
/* 27 */     Entity entity = (Entity)dependencies.get("entity");
/* 28 */     IWorld world = (IWorld)dependencies.get("world");
/* 29 */     if (entity instanceof LivingEntity)
/* 30 */       ((LivingEntity)entity).func_70606_j((float)(DreambossModVariables.WorldVariables.get(world)).DreamHealth); 
/* 31 */     (DreambossModVariables.WorldVariables.get(world)).timeSec = 0.0D;
/* 32 */     DreambossModVariables.WorldVariables.get(world).syncData(world);
/*    */   }
/*    */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\DreamMod.jar!\net\mcreator\dreamboss\procedures\DreamBowOnInitialEntitySpawnProcedure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */