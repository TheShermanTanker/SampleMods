/*    */ package net.mcreator.dreamboss.procedures;
/*    */ 
/*    */ import java.util.Map;
/*    */ import net.mcreator.dreamboss.DreambossModElements;
/*    */ import net.mcreator.dreamboss.DreambossModElements.ModElement.Tag;
/*    */ import net.mcreator.dreamboss.DreambossModVariables;
/*    */ import net.mcreator.dreamboss.entity.DreamPotionEntity;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.ILivingEntityData;
/*    */ import net.minecraft.entity.LivingEntity;
/*    */ import net.minecraft.entity.MobEntity;
/*    */ import net.minecraft.entity.SpawnReason;
/*    */ import net.minecraft.nbt.CompoundNBT;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.IWorld;
/*    */ 
/*    */ @Tag
/*    */ public class DreamBowEntityIsHurtProcedure
/*    */   extends DreambossModElements.ModElement
/*    */ {
/*    */   public DreamBowEntityIsHurtProcedure(DreambossModElements instance) {
/* 22 */     super(instance, 18);
/*    */   }
/*    */   
/*    */   public static void executeProcedure(Map<String, Object> dependencies) {
/* 26 */     if (dependencies.get("entity") == null) {
/* 27 */       System.err.println("Failed to load dependency entity for procedure DreamBowEntityIsHurt!");
/*    */       return;
/*    */     } 
/* 30 */     if (dependencies.get("x") == null) {
/* 31 */       System.err.println("Failed to load dependency x for procedure DreamBowEntityIsHurt!");
/*    */       return;
/*    */     } 
/* 34 */     if (dependencies.get("y") == null) {
/* 35 */       System.err.println("Failed to load dependency y for procedure DreamBowEntityIsHurt!");
/*    */       return;
/*    */     } 
/* 38 */     if (dependencies.get("z") == null) {
/* 39 */       System.err.println("Failed to load dependency z for procedure DreamBowEntityIsHurt!");
/*    */       return;
/*    */     } 
/* 42 */     if (dependencies.get("world") == null) {
/* 43 */       System.err.println("Failed to load dependency world for procedure DreamBowEntityIsHurt!");
/*    */       return;
/*    */     } 
/* 46 */     Entity entity = (Entity)dependencies.get("entity");
/* 47 */     double x = (dependencies.get("x") instanceof Integer) ? ((Integer)dependencies.get("x")).intValue() : ((Double)dependencies.get("x")).doubleValue();
/* 48 */     double y = (dependencies.get("y") instanceof Integer) ? ((Integer)dependencies.get("y")).intValue() : ((Double)dependencies.get("y")).doubleValue();
/* 49 */     double z = (dependencies.get("z") instanceof Integer) ? ((Integer)dependencies.get("z")).intValue() : ((Double)dependencies.get("z")).doubleValue();
/* 50 */     IWorld world = (IWorld)dependencies.get("world");
/* 51 */     if (((entity instanceof LivingEntity) ? ((LivingEntity)entity).func_110143_aJ() : -1.0F) < 70.0F) {
/*    */       
/* 53 */       (DreambossModVariables.WorldVariables.get(world)).DreamHealth = ((entity instanceof LivingEntity) ? ((LivingEntity)entity).func_110143_aJ() : -1.0F);
/* 54 */       DreambossModVariables.WorldVariables.get(world).syncData(world);
/* 55 */       if (!entity.field_70170_p.field_72995_K)
/* 56 */         entity.func_70106_y(); 
/* 57 */       if (world instanceof net.minecraft.world.World && !(world.func_201672_e()).field_72995_K) {
/* 58 */         DreamPotionEntity.CustomEntity customEntity = new DreamPotionEntity.CustomEntity(DreamPotionEntity.entity, world.func_201672_e());
/* 59 */         customEntity.func_70012_b(x, y, z, world.func_201674_k().nextFloat() * 360.0F, 0.0F);
/* 60 */         if (customEntity instanceof MobEntity) {
/* 61 */           ((MobEntity)customEntity).func_213386_a(world, world.func_175649_E(new BlockPos((Entity)customEntity)), SpawnReason.MOB_SUMMONED, (ILivingEntityData)null, (CompoundNBT)null);
/*    */         }
/* 63 */         world.func_217376_c((Entity)customEntity);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\DreamMod.jar!\net\mcreator\dreamboss\procedures\DreamBowEntityIsHurtProcedure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */