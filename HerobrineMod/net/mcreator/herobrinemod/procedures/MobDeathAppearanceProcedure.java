/*    */ package net.mcreator.herobrinemod.procedures;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModElements;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModElements.ModElement.Tag;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModVariables;
/*    */ import net.mcreator.herobrinemod.entity.HerobrineEntity;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.ILivingEntityData;
/*    */ import net.minecraft.entity.MobEntity;
/*    */ import net.minecraft.entity.SpawnReason;
/*    */ import net.minecraft.entity.player.PlayerEntity;
/*    */ import net.minecraft.nbt.CompoundNBT;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.SoundCategory;
/*    */ import net.minecraft.util.SoundEvent;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.IWorld;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ import net.minecraftforge.event.entity.living.LivingDeathEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.registries.ForgeRegistries;
/*    */ 
/*    */ @Tag
/*    */ public class MobDeathAppearanceProcedure
/*    */   extends HerobrinemodModElements.ModElement {
/*    */   public MobDeathAppearanceProcedure(HerobrinemodModElements instance) {
/* 32 */     super(instance, 9);
/* 33 */     MinecraftForge.EVENT_BUS.register(this);
/*    */   }
/*    */   
/*    */   public static void executeProcedure(Map<String, Object> dependencies) {
/* 37 */     if (dependencies.get("sourceentity") == null) {
/* 38 */       System.err.println("Failed to load dependency sourceentity for procedure MobDeathAppearance!");
/*    */       return;
/*    */     } 
/* 41 */     if (dependencies.get("x") == null) {
/* 42 */       System.err.println("Failed to load dependency x for procedure MobDeathAppearance!");
/*    */       return;
/*    */     } 
/* 45 */     if (dependencies.get("y") == null) {
/* 46 */       System.err.println("Failed to load dependency y for procedure MobDeathAppearance!");
/*    */       return;
/*    */     } 
/* 49 */     if (dependencies.get("z") == null) {
/* 50 */       System.err.println("Failed to load dependency z for procedure MobDeathAppearance!");
/*    */       return;
/*    */     } 
/* 53 */     if (dependencies.get("world") == null) {
/* 54 */       System.err.println("Failed to load dependency world for procedure MobDeathAppearance!");
/*    */       return;
/*    */     } 
/* 57 */     Entity sourceentity = (Entity)dependencies.get("sourceentity");
/* 58 */     double x = (dependencies.get("x") instanceof Integer) ? ((Integer)dependencies.get("x")).intValue() : ((Double)dependencies.get("x")).doubleValue();
/* 59 */     double y = (dependencies.get("y") instanceof Integer) ? ((Integer)dependencies.get("y")).intValue() : ((Double)dependencies.get("y")).doubleValue();
/* 60 */     double z = (dependencies.get("z") instanceof Integer) ? ((Integer)dependencies.get("z")).intValue() : ((Double)dependencies.get("z")).doubleValue();
/* 61 */     IWorld world = (IWorld)dependencies.get("world");
/* 62 */     if (Math.random() >= 0.92D) {
/* 63 */       if (world instanceof World && !(world.func_201672_e()).field_72995_K) {
/* 64 */         HerobrineEntity.CustomEntity customEntity = new HerobrineEntity.CustomEntity(HerobrineEntity.entity, world.func_201672_e());
/* 65 */         customEntity.func_70012_b(x, y, z, world.func_201674_k().nextFloat() * 360.0F, 0.0F);
/* 66 */         if (customEntity instanceof MobEntity) {
/* 67 */           ((MobEntity)customEntity).func_213386_a(world, world.func_175649_E(new BlockPos((Entity)customEntity)), SpawnReason.MOB_SUMMONED, (ILivingEntityData)null, (CompoundNBT)null);
/*    */         }
/* 69 */         world.func_217376_c((Entity)customEntity);
/*    */       } 
/* 71 */       world.func_184133_a((world.func_201672_e()).field_72995_K ? (PlayerEntity)(Minecraft.func_71410_x()).field_71439_g : (PlayerEntity)null, new BlockPos(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS
/* 72 */           .getValue(new ResourceLocation("herobrinemod:horror_sound1")), SoundCategory.NEUTRAL, 1.0F, 1.0F);
/*    */       
/* 74 */       sourceentity.func_70097_a(DamageSource.field_82727_n, 1.0F);
/* 75 */       (HerobrinemodModVariables.MapVariables.get(world)).timeSec = 0.0D;
/* 76 */       HerobrinemodModVariables.MapVariables.get(world).syncData(world);
/*    */     } 
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onEntityDeath(LivingDeathEvent event) {
/* 82 */     if (event != null && event.getEntity() != null) {
/* 83 */       Entity entity = event.getEntity();
/* 84 */       Entity sourceentity = event.getSource().func_76346_g();
/* 85 */       double i = entity.func_226277_ct_();
/* 86 */       double j = entity.func_226278_cu_();
/* 87 */       double k = entity.func_226281_cx_();
/* 88 */       World world = entity.field_70170_p;
/* 89 */       Map<String, Object> dependencies = new HashMap<>();
/* 90 */       dependencies.put("x", Double.valueOf(i));
/* 91 */       dependencies.put("y", Double.valueOf(j));
/* 92 */       dependencies.put("z", Double.valueOf(k));
/* 93 */       dependencies.put("world", world);
/* 94 */       dependencies.put("entity", entity);
/* 95 */       dependencies.put("sourceentity", sourceentity);
/* 96 */       dependencies.put("event", event);
/* 97 */       this; executeProcedure(dependencies);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\HerobrineMod.jar!\net\mcreator\herobrinemod\procedures\MobDeathAppearanceProcedure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */