/*    */ package net.mcreator.dreamboss.procedures;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import net.mcreator.dreamboss.DreambossModElements;
/*    */ import net.mcreator.dreamboss.DreambossModElements.ModElement.Tag;
/*    */ import net.mcreator.dreamboss.DreambossModVariables;
/*    */ import net.minecraft.block.Blocks;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.PlayerEntity;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.IWorld;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ import net.minecraftforge.event.TickEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ 
/*    */ @Tag
/*    */ public class RemoveLavaProcedure
/*    */   extends DreambossModElements.ModElement {
/*    */   public RemoveLavaProcedure(DreambossModElements instance) {
/* 22 */     super(instance, 22);
/* 23 */     MinecraftForge.EVENT_BUS.register(this);
/*    */   }
/*    */   
/*    */   public static void executeProcedure(Map<String, Object> dependencies) {
/* 27 */     if (dependencies.get("x") == null) {
/* 28 */       System.err.println("Failed to load dependency x for procedure RemoveLava!");
/*    */       return;
/*    */     } 
/* 31 */     if (dependencies.get("y") == null) {
/* 32 */       System.err.println("Failed to load dependency y for procedure RemoveLava!");
/*    */       return;
/*    */     } 
/* 35 */     if (dependencies.get("z") == null) {
/* 36 */       System.err.println("Failed to load dependency z for procedure RemoveLava!");
/*    */       return;
/*    */     } 
/* 39 */     if (dependencies.get("world") == null) {
/* 40 */       System.err.println("Failed to load dependency world for procedure RemoveLava!");
/*    */       return;
/*    */     } 
/* 43 */     double x = (dependencies.get("x") instanceof Integer) ? ((Integer)dependencies.get("x")).intValue() : ((Double)dependencies.get("x")).doubleValue();
/* 44 */     double y = (dependencies.get("y") instanceof Integer) ? ((Integer)dependencies.get("y")).intValue() : ((Double)dependencies.get("y")).doubleValue();
/* 45 */     double z = (dependencies.get("z") instanceof Integer) ? ((Integer)dependencies.get("z")).intValue() : ((Double)dependencies.get("z")).doubleValue();
/* 46 */     IWorld world = (IWorld)dependencies.get("world");
/* 47 */     if ((DreambossModVariables.WorldVariables.get(world)).timeSec > 0.4D && 
/* 48 */       (DreambossModVariables.WorldVariables.get(world)).timeSec < 0.45D) {
/* 49 */       world.func_180501_a(new BlockPos((int)(x - 1.0D), (int)y, (int)z), Blocks.field_150350_a.func_176223_P(), 3);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onPlayerTick(TickEvent.PlayerTickEvent event) {
/* 56 */     if (event.phase == TickEvent.Phase.END) {
/* 57 */       PlayerEntity playerEntity = event.player;
/* 58 */       World world = ((Entity)playerEntity).field_70170_p;
/* 59 */       double i = playerEntity.func_226277_ct_();
/* 60 */       double j = playerEntity.func_226278_cu_();
/* 61 */       double k = playerEntity.func_226281_cx_();
/* 62 */       Map<String, Object> dependencies = new HashMap<>();
/* 63 */       dependencies.put("x", Double.valueOf(i));
/* 64 */       dependencies.put("y", Double.valueOf(j));
/* 65 */       dependencies.put("z", Double.valueOf(k));
/* 66 */       dependencies.put("world", world);
/* 67 */       dependencies.put("entity", playerEntity);
/* 68 */       dependencies.put("event", event);
/* 69 */       this; executeProcedure(dependencies);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\DreamMod.jar!\net\mcreator\dreamboss\procedures\RemoveLavaProcedure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */