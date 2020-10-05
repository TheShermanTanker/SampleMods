/*    */ package net.mcreator.dreamboss.procedures;
/*    */ 
/*    */ import java.util.Comparator;
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
/*    */ import net.minecraft.entity.player.PlayerEntity;
/*    */ import net.minecraft.nbt.CompoundNBT;
/*    */ import net.minecraft.util.Hand;
/*    */ import net.minecraft.util.math.AxisAlignedBB;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.IWorld;
/*    */ 
/*    */ @Tag
/*    */ public class DreamEntityIsHurtProcedure
/*    */   extends DreambossModElements.ModElement
/*    */ {
/*    */   public DreamEntityIsHurtProcedure(DreambossModElements instance) {
/* 26 */     super(instance, 3);
/*    */   }
/*    */   
/*    */   public static void executeProcedure(Map<String, Object> dependencies) {
/* 30 */     if (dependencies.get("entity") == null) {
/* 31 */       System.err.println("Failed to load dependency entity for procedure DreamEntityIsHurt!");
/*    */       return;
/*    */     } 
/* 34 */     if (dependencies.get("sourceentity") == null) {
/* 35 */       System.err.println("Failed to load dependency sourceentity for procedure DreamEntityIsHurt!");
/*    */       return;
/*    */     } 
/* 38 */     if (dependencies.get("x") == null) {
/* 39 */       System.err.println("Failed to load dependency x for procedure DreamEntityIsHurt!");
/*    */       return;
/*    */     } 
/* 42 */     if (dependencies.get("y") == null) {
/* 43 */       System.err.println("Failed to load dependency y for procedure DreamEntityIsHurt!");
/*    */       return;
/*    */     } 
/* 46 */     if (dependencies.get("z") == null) {
/* 47 */       System.err.println("Failed to load dependency z for procedure DreamEntityIsHurt!");
/*    */       return;
/*    */     } 
/* 50 */     if (dependencies.get("world") == null) {
/* 51 */       System.err.println("Failed to load dependency world for procedure DreamEntityIsHurt!");
/*    */       return;
/*    */     } 
/* 54 */     Entity entity = (Entity)dependencies.get("entity");
/* 55 */     Entity sourceentity = (Entity)dependencies.get("sourceentity");
/* 56 */     double x = (dependencies.get("x") instanceof Integer) ? ((Integer)dependencies.get("x")).intValue() : ((Double)dependencies.get("x")).doubleValue();
/* 57 */     double y = (dependencies.get("y") instanceof Integer) ? ((Integer)dependencies.get("y")).intValue() : ((Double)dependencies.get("y")).doubleValue();
/* 58 */     double z = (dependencies.get("z") instanceof Integer) ? ((Integer)dependencies.get("z")).intValue() : ((Double)dependencies.get("z")).doubleValue();
/* 59 */     IWorld world = (IWorld)dependencies.get("world");
/* 60 */     if (entity instanceof LivingEntity) {
/* 61 */       ((LivingEntity)entity).func_226292_a_(Hand.MAIN_HAND, true);
/*    */     }
/* 63 */     if (((entity instanceof LivingEntity) ? ((LivingEntity)entity).func_110143_aJ() : -1.0F) < 150.0F && (
/* 64 */       (entity instanceof LivingEntity) ? ((LivingEntity)entity).func_110143_aJ() : -1.0F) > 130.0F) {
/*    */       
/* 66 */       (DreambossModVariables.WorldVariables.get(world)).DreamHealth = ((entity instanceof LivingEntity) ? ((LivingEntity)entity).func_110143_aJ() : -1.0F);
/* 67 */       DreambossModVariables.WorldVariables.get(world).syncData(world);
/* 68 */       if (!entity.field_70170_p.field_72995_K)
/* 69 */         entity.func_70106_y(); 
/* 70 */       if (world instanceof net.minecraft.world.World && !(world.func_201672_e()).field_72995_K) {
/* 71 */         DreamPotionEntity.CustomEntity customEntity = new DreamPotionEntity.CustomEntity(DreamPotionEntity.entity, world.func_201672_e());
/* 72 */         customEntity.func_70012_b(x, y, z, world.func_201674_k().nextFloat() * 360.0F, 0.0F);
/* 73 */         if (customEntity instanceof MobEntity) {
/* 74 */           ((MobEntity)customEntity).func_213386_a(world, world.func_175649_E(new BlockPos((Entity)customEntity)), SpawnReason.MOB_SUMMONED, (ILivingEntityData)null, (CompoundNBT)null);
/*    */         }
/* 76 */         world.func_217376_c((Entity)customEntity);
/*    */       } 
/*    */     } 
/*    */     
/* 80 */     if (world
/* 81 */       .func_175647_a(PlayerEntity.class, new AxisAlignedBB(x - 2.0D, y - 2.0D, z - 2.0D, x + 2.0D, y + 2.0D, z + 2.0D), null)
/* 82 */       .stream().sorted(Comparator.comparing(_entcnd -> Double.valueOf(_entcnd.func_70092_e(x, y, z)))).findFirst().orElse(null) != null && 
/* 83 */       Math.random() > 0.9D) {
/* 84 */       (DreambossModVariables.WorldVariables.get(world)).timeSec = 0.0D;
/* 85 */       DreambossModVariables.WorldVariables.get(world).syncData(world);
/* 86 */       sourceentity.func_70015_d(10);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\DreamMod.jar!\net\mcreator\dreamboss\procedures\DreamEntityIsHurtProcedure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */