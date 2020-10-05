/*    */ package net.mcreator.dreamboss.procedures;
/*    */ 
/*    */ import java.util.Map;
/*    */ import net.mcreator.dreamboss.DreambossModElements;
/*    */ import net.mcreator.dreamboss.DreambossModElements.ModElement.Tag;
/*    */ import net.mcreator.dreamboss.DreambossModVariables;
/*    */ import net.mcreator.dreamboss.entity.DreamBowEntity;
/*    */ import net.mcreator.dreamboss.entity.DreamEntityEntity;
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
/*    */ public class DreamPotionEntityIsHurtProcedure
/*    */   extends DreambossModElements.ModElement
/*    */ {
/*    */   public DreamPotionEntityIsHurtProcedure(DreambossModElements instance) {
/* 23 */     super(instance, 16);
/*    */   }
/*    */   
/*    */   public static void executeProcedure(Map<String, Object> dependencies) {
/* 27 */     if (dependencies.get("entity") == null) {
/* 28 */       System.err.println("Failed to load dependency entity for procedure DreamPotionEntityIsHurt!");
/*    */       return;
/*    */     } 
/* 31 */     if (dependencies.get("x") == null) {
/* 32 */       System.err.println("Failed to load dependency x for procedure DreamPotionEntityIsHurt!");
/*    */       return;
/*    */     } 
/* 35 */     if (dependencies.get("y") == null) {
/* 36 */       System.err.println("Failed to load dependency y for procedure DreamPotionEntityIsHurt!");
/*    */       return;
/*    */     } 
/* 39 */     if (dependencies.get("z") == null) {
/* 40 */       System.err.println("Failed to load dependency z for procedure DreamPotionEntityIsHurt!");
/*    */       return;
/*    */     } 
/* 43 */     if (dependencies.get("world") == null) {
/* 44 */       System.err.println("Failed to load dependency world for procedure DreamPotionEntityIsHurt!");
/*    */       return;
/*    */     } 
/* 47 */     Entity entity = (Entity)dependencies.get("entity");
/* 48 */     double x = (dependencies.get("x") instanceof Integer) ? ((Integer)dependencies.get("x")).intValue() : ((Double)dependencies.get("x")).doubleValue();
/* 49 */     double y = (dependencies.get("y") instanceof Integer) ? ((Integer)dependencies.get("y")).intValue() : ((Double)dependencies.get("y")).doubleValue();
/* 50 */     double z = (dependencies.get("z") instanceof Integer) ? ((Integer)dependencies.get("z")).intValue() : ((Double)dependencies.get("z")).doubleValue();
/* 51 */     IWorld world = (IWorld)dependencies.get("world");
/* 52 */     if ((DreambossModVariables.WorldVariables.get(world)).timeSec > 5.0D) {
/*    */       
/* 54 */       (DreambossModVariables.WorldVariables.get(world)).DreamHealth = ((entity instanceof LivingEntity) ? ((LivingEntity)entity).func_110143_aJ() : -1.0F);
/* 55 */       DreambossModVariables.WorldVariables.get(world).syncData(world);
/* 56 */       if (!entity.field_70170_p.field_72995_K)
/* 57 */         entity.func_70106_y(); 
/* 58 */       if (Math.random() > 0.35D) {
/* 59 */         if (world instanceof net.minecraft.world.World && !(world.func_201672_e()).field_72995_K) {
/* 60 */           DreamEntityEntity.CustomEntity customEntity = new DreamEntityEntity.CustomEntity(DreamEntityEntity.entity, world.func_201672_e());
/* 61 */           customEntity.func_70012_b(x, y, z, world.func_201674_k().nextFloat() * 360.0F, 0.0F);
/* 62 */           if (customEntity instanceof MobEntity) {
/* 63 */             ((MobEntity)customEntity).func_213386_a(world, world.func_175649_E(new BlockPos((Entity)customEntity)), SpawnReason.MOB_SUMMONED, (ILivingEntityData)null, (CompoundNBT)null);
/*    */           }
/* 65 */           world.func_217376_c((Entity)customEntity);
/*    */         }
/*    */       
/* 68 */       } else if (world instanceof net.minecraft.world.World && !(world.func_201672_e()).field_72995_K) {
/* 69 */         DreamBowEntity.CustomEntity customEntity = new DreamBowEntity.CustomEntity(DreamBowEntity.entity, world.func_201672_e());
/* 70 */         customEntity.func_70012_b(x, y, z, world.func_201674_k().nextFloat() * 360.0F, 0.0F);
/* 71 */         if (customEntity instanceof MobEntity) {
/* 72 */           ((MobEntity)customEntity).func_213386_a(world, world.func_175649_E(new BlockPos((Entity)customEntity)), SpawnReason.MOB_SUMMONED, (ILivingEntityData)null, (CompoundNBT)null);
/*    */         }
/* 74 */         world.func_217376_c((Entity)customEntity);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\DreamMod.jar!\net\mcreator\dreamboss\procedures\DreamPotionEntityIsHurtProcedure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */