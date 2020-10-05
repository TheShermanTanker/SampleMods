/*    */ package net.mcreator.dreamboss.procedures;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import java.util.Map;
/*    */ import net.mcreator.dreamboss.DreambossModElements;
/*    */ import net.mcreator.dreamboss.DreambossModElements.ModElement.Tag;
/*    */ import net.mcreator.dreamboss.DreambossModVariables;
/*    */ import net.minecraft.block.Blocks;
/*    */ import net.minecraft.entity.player.PlayerEntity;
/*    */ import net.minecraft.util.math.AxisAlignedBB;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.IWorld;
/*    */ 
/*    */ @Tag
/*    */ public class DreamEntityEntityFallsProcedure
/*    */   extends DreambossModElements.ModElement {
/*    */   public DreamEntityEntityFallsProcedure(DreambossModElements instance) {
/* 18 */     super(instance, 19);
/*    */   }
/*    */   
/*    */   public static void executeProcedure(Map<String, Object> dependencies) {
/* 22 */     if (dependencies.get("x") == null) {
/* 23 */       System.err.println("Failed to load dependency x for procedure DreamEntityEntityFalls!");
/*    */       return;
/*    */     } 
/* 26 */     if (dependencies.get("y") == null) {
/* 27 */       System.err.println("Failed to load dependency y for procedure DreamEntityEntityFalls!");
/*    */       return;
/*    */     } 
/* 30 */     if (dependencies.get("z") == null) {
/* 31 */       System.err.println("Failed to load dependency z for procedure DreamEntityEntityFalls!");
/*    */       return;
/*    */     } 
/* 34 */     if (dependencies.get("world") == null) {
/* 35 */       System.err.println("Failed to load dependency world for procedure DreamEntityEntityFalls!");
/*    */       return;
/*    */     } 
/* 38 */     double x = (dependencies.get("x") instanceof Integer) ? ((Integer)dependencies.get("x")).intValue() : ((Double)dependencies.get("x")).doubleValue();
/* 39 */     double y = (dependencies.get("y") instanceof Integer) ? ((Integer)dependencies.get("y")).intValue() : ((Double)dependencies.get("y")).doubleValue();
/* 40 */     double z = (dependencies.get("z") instanceof Integer) ? ((Integer)dependencies.get("z")).intValue() : ((Double)dependencies.get("z")).doubleValue();
/* 41 */     IWorld world = (IWorld)dependencies.get("world");
/* 42 */     (DreambossModVariables.WorldVariables.get(world)).timeSec = 0.0D;
/* 43 */     DreambossModVariables.WorldVariables.get(world).syncData(world);
/* 44 */     if (world.func_175647_a(PlayerEntity.class, new AxisAlignedBB(x - 7.0D, y - 7.0D, z - 7.0D, x + 7.0D, y + 7.0D, z + 7.0D), null)
/* 45 */       .stream()
/* 46 */       .sorted(Comparator.comparing(_entcnd -> Double.valueOf(_entcnd.func_70092_e(x, y, z)))).findFirst().orElse(null) == null)
/* 47 */       world.func_180501_a(new BlockPos((int)(x - 1.0D), (int)y, (int)z), Blocks.field_150355_j.func_176223_P(), 3); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\DreamMod.jar!\net\mcreator\dreamboss\procedures\DreamEntityEntityFallsProcedure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */