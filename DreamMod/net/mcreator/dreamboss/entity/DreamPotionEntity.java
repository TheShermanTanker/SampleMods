/*     */ package net.mcreator.dreamboss.entity;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.mcreator.dreamboss.DreambossModElements;
/*     */ import net.mcreator.dreamboss.DreambossModElements.ModElement.Tag;
/*     */ import net.mcreator.dreamboss.procedures.DreamPotionEntityIsHurtProcedure;
/*     */ import net.mcreator.dreamboss.procedures.DreamPotionOnEntityTickUpdateProcedure;
/*     */ import net.mcreator.dreamboss.procedures.DreamPotionOnInitialEntitySpawnProcedure;
/*     */ import net.minecraft.client.renderer.entity.BipedRenderer;
/*     */ import net.minecraft.client.renderer.entity.EntityRenderer;
/*     */ import net.minecraft.client.renderer.entity.EntityRendererManager;
/*     */ import net.minecraft.client.renderer.entity.IEntityRenderer;
/*     */ import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
/*     */ import net.minecraft.client.renderer.entity.layers.LayerRenderer;
/*     */ import net.minecraft.client.renderer.entity.model.BipedModel;
/*     */ import net.minecraft.entity.CreatureAttribute;
/*     */ import net.minecraft.entity.CreatureEntity;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityType;
/*     */ import net.minecraft.entity.ILivingEntityData;
/*     */ import net.minecraft.entity.MobEntity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.SpawnReason;
/*     */ import net.minecraft.entity.ai.goal.AvoidEntityGoal;
/*     */ import net.minecraft.entity.ai.goal.Goal;
/*     */ import net.minecraft.entity.ai.goal.LookRandomlyGoal;
/*     */ import net.minecraft.entity.monster.MonsterEntity;
/*     */ import net.minecraft.entity.player.ServerPlayerEntity;
/*     */ import net.minecraft.inventory.EquipmentSlotType;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.Items;
/*     */ import net.minecraft.nbt.CompoundNBT;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.IItemProvider;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.util.text.ITextComponent;
/*     */ import net.minecraft.util.text.StringTextComponent;
/*     */ import net.minecraft.world.BossInfo;
/*     */ import net.minecraft.world.DifficultyInstance;
/*     */ import net.minecraft.world.IWorld;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.server.ServerBossInfo;
/*     */ import net.minecraftforge.api.distmarker.Dist;
/*     */ import net.minecraftforge.api.distmarker.OnlyIn;
/*     */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*     */ import net.minecraftforge.fml.client.registry.RenderingRegistry;
/*     */ import net.minecraftforge.fml.network.FMLPlayMessages;
/*     */ import net.minecraftforge.fml.network.NetworkHooks;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ 
/*     */ @Tag
/*     */ public class DreamPotionEntity extends DreambossModElements.ModElement {
/*  54 */   public static EntityType entity = null;
/*     */   public DreamPotionEntity(DreambossModElements instance) {
/*  56 */     super(instance, 6);
/*  57 */     FMLJavaModLoadingContext.get().getModEventBus().register(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initElements() {
/*  64 */     entity = (EntityType)EntityType.Builder.func_220322_a(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).func_220320_c().func_220321_a(0.6F, 1.8F).func_206830_a("dream_potion").setRegistryName("dream_potion");
/*  65 */     this.elements.entities.add(() -> entity);
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   @OnlyIn(Dist.CLIENT)
/*     */   public void registerModels(ModelRegistryEvent event) {
/*  71 */     RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
/*     */           BipedRenderer customRender = new BipedRenderer(renderManager, new BipedModel(0.0F), 0.5F)
/*     */             {
/*     */               public ResourceLocation func_110775_a(Entity entity) {
/*  75 */                 return new ResourceLocation("dreamboss:textures/dream1.png");
/*     */               }
/*     */             };
/*     */           customRender.func_177094_a((LayerRenderer)new BipedArmorLayer((IEntityRenderer)customRender, new BipedModel(0.5F), new BipedModel(1.0F)));
/*     */           return (EntityRenderer)customRender;
/*     */         });
/*     */   }
/*     */   public static class CustomEntity extends MonsterEntity {
/*     */     private final ServerBossInfo bossInfo;
/*  84 */     public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) { this(DreamPotionEntity.entity, world); }
/*     */     public IPacket<?> func_213297_N() { return NetworkHooks.getEntitySpawningPacket((Entity)this); }
/*     */     protected void func_184651_r() { super.func_184651_r(); this.field_70714_bg.func_75776_a(1, (Goal)new AvoidEntityGoal((CreatureEntity)this, PlayerEntity.class, 6.0F, 1.0D, 1.2D)); this.field_70714_bg.func_75776_a(2, (Goal)new AvoidEntityGoal((CreatureEntity)this, ServerPlayerEntity.class, 6.0F, 1.0D, 1.2D)); this.field_70714_bg.func_75776_a(3, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 0.8D));
/*     */       this.field_70714_bg.func_75776_a(4, (Goal)new LookRandomlyGoal((MobEntity)this)); }
/*  88 */     public CreatureAttribute func_70668_bt() { return CreatureAttribute.field_223222_a_; } public CustomEntity(EntityType<CustomEntity> type, World world) { super(type, world);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 211 */       this.bossInfo = new ServerBossInfo(func_145748_c_(), BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS); this.field_70728_aV = 10; func_94061_f(false); func_200203_b((ITextComponent)new StringTextComponent("Dream")); func_174805_g(true); func_110163_bv(); func_184201_a(EquipmentSlotType.MAINHAND, new ItemStack((IItemProvider)Items.field_185155_bH, 1)); func_184201_a(EquipmentSlotType.OFFHAND, new ItemStack((IItemProvider)Items.field_185159_cQ, 1)); }
/*     */     public boolean func_213397_c(double distanceToClosestPlayer) { return false; }
/*     */     protected void func_213333_a(DamageSource source, int looting, boolean recentlyHitIn) { super.func_213333_a(source, looting, recentlyHitIn); func_199701_a_(new ItemStack((IItemProvider)Items.field_151166_bC, 1)); }
/* 214 */     public SoundEvent func_184601_bQ(DamageSource ds) { return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt")); } public void func_184178_b(ServerPlayerEntity player) { super.func_184178_b(player);
/* 215 */       this.bossInfo.func_186760_a(player); } public SoundEvent func_184615_bR() { return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death")); }
/*     */     public boolean func_70097_a(DamageSource source, float amount) { double x = func_226277_ct_(); double y = func_226278_cu_(); double z = func_226281_cx_(); CustomEntity customEntity = this; Entity sourceentity = source.func_76346_g(); Map<String, Object> $_dependencies = new HashMap<>(); $_dependencies.put("entity", customEntity); $_dependencies.put("x", Double.valueOf(x)); $_dependencies.put("y", Double.valueOf(y)); $_dependencies.put("z", Double.valueOf(z)); $_dependencies.put("world", this.field_70170_p); DreamPotionEntityIsHurtProcedure.executeProcedure($_dependencies); if (source == DamageSource.field_76379_h)
/*     */         return false;  return super.func_70097_a(source, amount); }
/*     */     public ILivingEntityData func_213386_a(IWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata, CompoundNBT tag) { ILivingEntityData retval = super.func_213386_a(world, difficulty, reason, livingdata, tag); double x = func_226277_ct_(); double y = func_226278_cu_(); double z = func_226281_cx_(); CustomEntity customEntity = this; Map<String, Object> $_dependencies = new HashMap<>(); $_dependencies.put("entity", customEntity); $_dependencies.put("world", world); DreamPotionOnInitialEntitySpawnProcedure.executeProcedure($_dependencies);
/*     */       return retval; }
/* 220 */     public void func_184203_c(ServerPlayerEntity player) { super.func_184203_c(player);
/* 221 */       this.bossInfo.func_186761_b(player); } public void func_70030_z() { super.func_70030_z(); double x = func_226277_ct_(); double y = func_226278_cu_(); double z = func_226281_cx_(); CustomEntity customEntity = this; Map<String, Object> $_dependencies = new HashMap<>(); $_dependencies.put("entity", customEntity); $_dependencies.put("x", Double.valueOf(x)); $_dependencies.put("y", Double.valueOf(y)); $_dependencies.put("z", Double.valueOf(z)); $_dependencies.put("world", this.field_70170_p); DreamPotionOnEntityTickUpdateProcedure.executeProcedure($_dependencies); }
/*     */     protected void func_110147_ax() { super.func_110147_ax(); if (func_110148_a(SharedMonsterAttributes.field_111263_d) != null) func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.3D);  if (func_110148_a(SharedMonsterAttributes.field_111267_a) != null) func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(300.0D);  if (func_110148_a(SharedMonsterAttributes.field_188791_g) != null)
/*     */         func_110148_a(SharedMonsterAttributes.field_188791_g).func_111128_a(0.0D);  if (func_110148_a(SharedMonsterAttributes.field_111264_e) == null)
/*     */         func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);  func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(3.0D); }
/*     */     public boolean func_184222_aU() { return false; }
/* 226 */     public void func_70619_bc() { super.func_70619_bc();
/* 227 */       this.bossInfo.func_186735_a(func_110143_aJ() / func_110138_aP()); }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\DreamMod.jar!\net\mcreator\dreamboss\entity\DreamPotionEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */