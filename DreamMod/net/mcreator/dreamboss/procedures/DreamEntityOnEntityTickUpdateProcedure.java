/*    */ package net.mcreator.dreamboss.procedures;
/*    */ 
/*    */ import java.util.Map;
/*    */ import net.mcreator.dreamboss.DreambossModElements;
/*    */ import net.mcreator.dreamboss.DreambossModElements.ModElement.Tag;
/*    */ import net.mcreator.dreamboss.DreambossModVariables;
/*    */ import net.minecraft.block.Blocks;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.IWorld;
/*    */ 
/*    */ @Tag
/*    */ public class DreamEntityOnEntityTickUpdateProcedure
/*    */   extends DreambossModElements.ModElement {
/*    */   public DreamEntityOnEntityTickUpdateProcedure(DreambossModElements instance) {
/* 15 */     super(instance, 20);
/*    */   }
/*    */   
/*    */   public static void executeProcedure(Map<String, Object> dependencies) {
/* 19 */     if (dependencies.get("x") == null) {
/* 20 */       System.err.println("Failed to load dependency x for procedure DreamEntityOnEntityTickUpdate!");
/*    */       return;
/*    */     } 
/* 23 */     if (dependencies.get("y") == null) {
/* 24 */       System.err.println("Failed to load dependency y for procedure DreamEntityOnEntityTickUpdate!");
/*    */       return;
/*    */     } 
/* 27 */     if (dependencies.get("z") == null) {
/* 28 */       System.err.println("Failed to load dependency z for procedure DreamEntityOnEntityTickUpdate!");
/*    */       return;
/*    */     } 
/* 31 */     if (dependencies.get("world") == null) {
/* 32 */       System.err.println("Failed to load dependency world for procedure DreamEntityOnEntityTickUpdate!");
/*    */       return;
/*    */     } 
/* 35 */     double x = (dependencies.get("x") instanceof Integer) ? ((Integer)dependencies.get("x")).intValue() : ((Double)dependencies.get("x")).doubleValue();
/* 36 */     double y = (dependencies.get("y") instanceof Integer) ? ((Integer)dependencies.get("y")).intValue() : ((Double)dependencies.get("y")).doubleValue();
/* 37 */     double z = (dependencies.get("z") instanceof Integer) ? ((Integer)dependencies.get("z")).intValue() : ((Double)dependencies.get("z")).doubleValue();
/* 38 */     IWorld world = (IWorld)dependencies.get("world");
/* 39 */     if ((DreambossModVariables.WorldVariables.get(world)).timeSec > 0.4D && 
/* 40 */       (DreambossModVariables.WorldVariables.get(world)).timeSec < 0.45D)
/* 41 */       world.func_180501_a(new BlockPos((int)(x - 1.0D), (int)y, (int)z), Blocks.field_150350_a.func_176223_P(), 3); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\DreamMod.jar!\net\mcreator\dreamboss\procedures\DreamEntityOnEntityTickUpdateProcedure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */