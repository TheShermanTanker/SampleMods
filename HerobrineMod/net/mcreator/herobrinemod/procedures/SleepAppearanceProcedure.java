/*    */ package net.mcreator.herobrinemod.procedures;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModElements;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModElements.ModElement.Tag;
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
/*    */ import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.registries.ForgeRegistries;
/*    */ 
/*    */ @Tag
/*    */ public class SleepAppearanceProcedure
/*    */   extends HerobrinemodModElements.ModElement {
/*    */   public SleepAppearanceProcedure(HerobrinemodModElements instance) {
/* 31 */     super(instance, 3);
/* 32 */     MinecraftForge.EVENT_BUS.register(this);
/*    */   }
/*    */   
/*    */   public static void executeProcedure(Map<String, Object> dependencies) {
/* 36 */     if (dependencies.get("entity") == null) {
/* 37 */       System.err.println("Failed to load dependency entity for procedure SleepAppearance!");
/*    */       return;
/*    */     } 
/* 40 */     if (dependencies.get("x") == null) {
/* 41 */       System.err.println("Failed to load dependency x for procedure SleepAppearance!");
/*    */       return;
/*    */     } 
/* 44 */     if (dependencies.get("y") == null) {
/* 45 */       System.err.println("Failed to load dependency y for procedure SleepAppearance!");
/*    */       return;
/*    */     } 
/* 48 */     if (dependencies.get("z") == null) {
/* 49 */       System.err.println("Failed to load dependency z for procedure SleepAppearance!");
/*    */       return;
/*    */     } 
/* 52 */     if (dependencies.get("world") == null) {
/* 53 */       System.err.println("Failed to load dependency world for procedure SleepAppearance!");
/*    */       return;
/*    */     } 
/* 56 */     Entity entity = (Entity)dependencies.get("entity");
/* 57 */     double x = (dependencies.get("x") instanceof Integer) ? ((Integer)dependencies.get("x")).intValue() : ((Double)dependencies.get("x")).doubleValue();
/* 58 */     double y = (dependencies.get("y") instanceof Integer) ? ((Integer)dependencies.get("y")).intValue() : ((Double)dependencies.get("y")).doubleValue();
/* 59 */     double z = (dependencies.get("z") instanceof Integer) ? ((Integer)dependencies.get("z")).intValue() : ((Double)dependencies.get("z")).doubleValue();
/* 60 */     IWorld world = (IWorld)dependencies.get("world");
/* 61 */     if (Math.random() >= 0.9D) {
/* 62 */       if (world instanceof World && !(world.func_201672_e()).field_72995_K) {
/* 63 */         HerobrineEntity.CustomEntity customEntity = new HerobrineEntity.CustomEntity(HerobrineEntity.entity, world.func_201672_e());
/* 64 */         customEntity.func_70012_b(x, y, z - 1.0D, world.func_201674_k().nextFloat() * 360.0F, 0.0F);
/* 65 */         if (customEntity instanceof MobEntity) {
/* 66 */           ((MobEntity)customEntity).func_213386_a(world, world.func_175649_E(new BlockPos((Entity)customEntity)), SpawnReason.MOB_SUMMONED, (ILivingEntityData)null, (CompoundNBT)null);
/*    */         }
/* 68 */         world.func_217376_c((Entity)customEntity);
/*    */       } 
/* 70 */       world.func_184133_a((world.func_201672_e()).field_72995_K ? (PlayerEntity)(Minecraft.func_71410_x()).field_71439_g : (PlayerEntity)null, new BlockPos(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS
/* 71 */           .getValue(new ResourceLocation("herobrinemod:horror_sound2")), SoundCategory.NEUTRAL, 1.0F, 1.0F);
/*    */       
/* 73 */       entity.func_70097_a(DamageSource.field_82727_n, 1.0F);
/*    */     } 
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onPlayerInBed(PlayerSleepInBedEvent event) {
/* 79 */     PlayerEntity entity = event.getPlayer();
/* 80 */     int i = event.getPos().func_177958_n();
/* 81 */     int j = event.getPos().func_177956_o();
/* 82 */     int k = event.getPos().func_177952_p();
/* 83 */     World world = entity.field_70170_p;
/* 84 */     Map<String, Object> dependencies = new HashMap<>();
/* 85 */     dependencies.put("x", Integer.valueOf(i));
/* 86 */     dependencies.put("y", Integer.valueOf(j));
/* 87 */     dependencies.put("z", Integer.valueOf(k));
/* 88 */     dependencies.put("world", world);
/* 89 */     dependencies.put("entity", entity);
/* 90 */     dependencies.put("event", event);
/* 91 */     this; executeProcedure(dependencies);
/*    */   }
/*    */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\HerobrineMod.jar!\net\mcreator\herobrinemod\procedures\SleepAppearanceProcedure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */