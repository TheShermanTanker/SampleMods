/*    */ package net.mcreator.dreamboss.procedures;
/*    */ 
/*    */ import java.util.Map;
/*    */ import net.mcreator.dreamboss.DreambossModElements;
/*    */ import net.mcreator.dreamboss.DreambossModElements.ModElement.Tag;
/*    */ import net.mcreator.dreamboss.DreambossModVariables;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityType;
/*    */ import net.minecraft.entity.ILivingEntityData;
/*    */ import net.minecraft.entity.LivingEntity;
/*    */ import net.minecraft.entity.MobEntity;
/*    */ import net.minecraft.entity.SpawnReason;
/*    */ import net.minecraft.entity.projectile.PotionEntity;
/*    */ import net.minecraft.nbt.CompoundNBT;
/*    */ import net.minecraft.potion.EffectInstance;
/*    */ import net.minecraft.potion.Effects;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.IWorld;
/*    */ 
/*    */ @Tag
/*    */ public class DreamPotionOnEntityTickUpdateProcedure
/*    */   extends DreambossModElements.ModElement
/*    */ {
/*    */   public DreamPotionOnEntityTickUpdateProcedure(DreambossModElements instance) {
/* 25 */     super(instance, 10);
/*    */   }
/*    */   
/*    */   public static void executeProcedure(Map<String, Object> dependencies) {
/* 29 */     if (dependencies.get("entity") == null) {
/* 30 */       System.err.println("Failed to load dependency entity for procedure DreamPotionOnEntityTickUpdate!");
/*    */       return;
/*    */     } 
/* 33 */     if (dependencies.get("x") == null) {
/* 34 */       System.err.println("Failed to load dependency x for procedure DreamPotionOnEntityTickUpdate!");
/*    */       return;
/*    */     } 
/* 37 */     if (dependencies.get("y") == null) {
/* 38 */       System.err.println("Failed to load dependency y for procedure DreamPotionOnEntityTickUpdate!");
/*    */       return;
/*    */     } 
/* 41 */     if (dependencies.get("z") == null) {
/* 42 */       System.err.println("Failed to load dependency z for procedure DreamPotionOnEntityTickUpdate!");
/*    */       return;
/*    */     } 
/* 45 */     if (dependencies.get("world") == null) {
/* 46 */       System.err.println("Failed to load dependency world for procedure DreamPotionOnEntityTickUpdate!");
/*    */       return;
/*    */     } 
/* 49 */     Entity entity = (Entity)dependencies.get("entity");
/* 50 */     double x = (dependencies.get("x") instanceof Integer) ? ((Integer)dependencies.get("x")).intValue() : ((Double)dependencies.get("x")).doubleValue();
/* 51 */     double y = (dependencies.get("y") instanceof Integer) ? ((Integer)dependencies.get("y")).intValue() : ((Double)dependencies.get("y")).doubleValue();
/* 52 */     double z = (dependencies.get("z") instanceof Integer) ? ((Integer)dependencies.get("z")).intValue() : ((Double)dependencies.get("z")).doubleValue();
/* 53 */     IWorld world = (IWorld)dependencies.get("world");
/* 54 */     if ((DreambossModVariables.WorldVariables.get(world)).timeSec > 1.0D && 
/* 55 */       (DreambossModVariables.WorldVariables.get(world)).timeSec < 1.05D) {
/* 56 */       if (world instanceof net.minecraft.world.World && !(world.func_201672_e()).field_72995_K) {
/* 57 */         PotionEntity potionEntity = new PotionEntity(EntityType.field_200754_at, world.func_201672_e());
/* 58 */         potionEntity.func_70012_b(x, y, z, 0.0F, 0.0F);
/* 59 */         potionEntity.func_213293_j(0.0D, 0.01D, 0.0D);
/* 60 */         if (potionEntity instanceof MobEntity) {
/* 61 */           ((MobEntity)potionEntity).func_213386_a(world, world.func_175649_E(new BlockPos((Entity)potionEntity)), SpawnReason.MOB_SUMMONED, (ILivingEntityData)null, (CompoundNBT)null);
/*    */         }
/* 63 */         world.func_217376_c((Entity)potionEntity);
/*    */       } 
/* 65 */       if (entity instanceof LivingEntity)
/* 66 */         ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_76428_l, 60, 5)); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\DreamMod.jar!\net\mcreator\dreamboss\procedures\DreamPotionOnEntityTickUpdateProcedure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */