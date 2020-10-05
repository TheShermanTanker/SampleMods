/*     */ package net.mcreator.herobrinemod.entity;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.mcreator.herobrinemod.HerobrinemodModElements;
/*     */ import net.mcreator.herobrinemod.HerobrinemodModElements.ModElement.Tag;
/*     */ import net.mcreator.herobrinemod.procedures.HerobrineSleepOnInitialEntitySpawnProcedure;
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
/*     */ import net.minecraft.entity.EntityClassification;
/*     */ import net.minecraft.entity.EntityType;
/*     */ import net.minecraft.entity.ILivingEntityData;
/*     */ import net.minecraft.entity.MobEntity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.SpawnReason;
/*     */ import net.minecraft.entity.ai.goal.Goal;
/*     */ import net.minecraft.entity.ai.goal.HurtByTargetGoal;
/*     */ import net.minecraft.entity.ai.goal.LookRandomlyGoal;
/*     */ import net.minecraft.entity.ai.goal.MeleeAttackGoal;
/*     */ import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
/*     */ import net.minecraft.entity.ai.goal.RandomWalkingGoal;
/*     */ import net.minecraft.entity.monster.MonsterEntity;
/*     */ import net.minecraft.entity.player.PlayerEntity;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.SpawnEggItem;
/*     */ import net.minecraft.nbt.CompoundNBT;
/*     */ import net.minecraft.network.IPacket;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.world.DifficultyInstance;
/*     */ import net.minecraft.world.IWorld;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.api.distmarker.Dist;
/*     */ import net.minecraftforge.api.distmarker.OnlyIn;
/*     */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*     */ import net.minecraftforge.fml.client.registry.RenderingRegistry;
/*     */ import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
/*     */ import net.minecraftforge.fml.network.FMLPlayMessages;
/*     */ import net.minecraftforge.fml.network.NetworkHooks;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ 
/*     */ @Tag
/*     */ public class HerobrineEntity extends HerobrinemodModElements.ModElement {
/*  52 */   public static EntityType entity = null;
/*     */   public HerobrineEntity(HerobrinemodModElements instance) {
/*  54 */     super(instance, 2);
/*  55 */     FMLJavaModLoadingContext.get().getModEventBus().register(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initElements() {
/*  62 */     entity = (EntityType)EntityType.Builder.func_220322_a(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).func_220320_c().func_220321_a(0.6F, 1.8F).func_206830_a("herobrinesleep").setRegistryName("herobrinesleep");
/*  63 */     this.elements.entities.add(() -> entity);
/*  64 */     this.elements.items.add(() -> (Item)(new SpawnEggItem(entity, -1, -1, (new Item.Properties()).func_200916_a(null))).setRegistryName("herobrinesleep"));
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   @OnlyIn(Dist.CLIENT)
/*     */   public void registerModels(ModelRegistryEvent event) {
/*  70 */     RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
/*     */           BipedRenderer customRender = new BipedRenderer(renderManager, new BipedModel(0.0F), 0.5F)
/*     */             {
/*     */               public ResourceLocation func_110775_a(Entity entity) {
/*  74 */                 return new ResourceLocation("herobrinemod:textures/herobrine.png");
/*     */               }
/*     */             };
/*     */           customRender.func_177094_a((LayerRenderer)new BipedArmorLayer((IEntityRenderer)customRender, new BipedModel(0.5F), new BipedModel(1.0F)));
/*     */           return (EntityRenderer)customRender;
/*     */         });
/*     */   }
/*     */   
/*     */   public static class CustomEntity extends MonsterEntity { public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
/*  83 */       this(HerobrineEntity.entity, world);
/*     */     }
/*     */     
/*     */     public CustomEntity(EntityType<CustomEntity> type, World world) {
/*  87 */       super(type, world);
/*  88 */       this.field_70728_aV = 0;
/*  89 */       func_94061_f(false);
/*     */     }
/*     */ 
/*     */     
/*     */     public IPacket<?> func_213297_N() {
/*  94 */       return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_184651_r() {
/*  99 */       super.func_184651_r();
/* 100 */       this.field_70714_bg.func_75776_a(1, (Goal)new MeleeAttackGoal((CreatureEntity)this, 1.2D, false));
/* 101 */       this.field_70715_bh.func_75776_a(2, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
/* 102 */       this.field_70714_bg.func_75776_a(3, (Goal)new RandomWalkingGoal((CreatureEntity)this, 0.8D));
/* 103 */       this.field_70714_bg.func_75776_a(4, (Goal)new LookRandomlyGoal((MobEntity)this));
/* 104 */       this.field_70715_bh.func_75776_a(5, (Goal)new NearestAttackableTargetGoal((MobEntity)this, PlayerEntity.class, false, false));
/*     */     }
/*     */ 
/*     */     
/*     */     public CreatureAttribute func_70668_bt() {
/* 109 */       return CreatureAttribute.field_223222_a_;
/*     */     }
/*     */     
/*     */     protected void func_213333_a(DamageSource source, int looting, boolean recentlyHitIn) {
/* 113 */       super.func_213333_a(source, looting, recentlyHitIn);
/*     */     }
/*     */ 
/*     */     
/*     */     public SoundEvent func_184601_bQ(DamageSource ds) {
/* 118 */       return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
/*     */     }
/*     */ 
/*     */     
/*     */     public SoundEvent func_184615_bR() {
/* 123 */       return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean func_70097_a(DamageSource source, float amount) {
/* 128 */       if (source.func_76364_f() instanceof net.minecraft.entity.projectile.ArrowEntity)
/* 129 */         return false; 
/* 130 */       if (source.func_76364_f() instanceof PlayerEntity)
/* 131 */         return false; 
/* 132 */       if (source.func_76364_f() instanceof net.minecraft.entity.projectile.PotionEntity)
/* 133 */         return false; 
/* 134 */       if (source == DamageSource.field_76379_h)
/* 135 */         return false; 
/* 136 */       if (source == DamageSource.field_76367_g)
/* 137 */         return false; 
/* 138 */       if (source == DamageSource.field_76369_e)
/* 139 */         return false; 
/* 140 */       if (source == DamageSource.field_180137_b)
/* 141 */         return false; 
/* 142 */       return super.func_70097_a(source, amount);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public ILivingEntityData func_213386_a(IWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata, CompoundNBT tag) {
/* 148 */       ILivingEntityData retval = super.func_213386_a(world, difficulty, reason, livingdata, tag);
/* 149 */       double x = func_226277_ct_();
/* 150 */       double y = func_226278_cu_();
/* 151 */       double z = func_226281_cx_();
/* 152 */       CustomEntity customEntity = this;
/*     */       
/* 154 */       Map<String, Object> $_dependencies = new HashMap<>();
/* 155 */       $_dependencies.put("world", world);
/* 156 */       HerobrineSleepOnInitialEntitySpawnProcedure.executeProcedure($_dependencies);
/*     */       
/* 158 */       return retval;
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_70030_z() {
/* 163 */       super.func_70030_z();
/* 164 */       double x = func_226277_ct_();
/* 165 */       double y = func_226278_cu_();
/* 166 */       double z = func_226281_cx_();
/* 167 */       CustomEntity customEntity = this;
/*     */       
/* 169 */       Map<String, Object> $_dependencies = new HashMap<>();
/* 170 */       $_dependencies.put("entity", customEntity);
/* 171 */       $_dependencies.put("world", this.field_70170_p);
/* 172 */       HerobrineSleepOnEntityTickUpdateProcedure.executeProcedure($_dependencies);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void func_110147_ax() {
/* 178 */       super.func_110147_ax();
/* 179 */       if (func_110148_a(SharedMonsterAttributes.field_111263_d) != null)
/* 180 */         func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.3D); 
/* 181 */       if (func_110148_a(SharedMonsterAttributes.field_111267_a) != null)
/* 182 */         func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0D); 
/* 183 */       if (func_110148_a(SharedMonsterAttributes.field_188791_g) != null)
/* 184 */         func_110148_a(SharedMonsterAttributes.field_188791_g).func_111128_a(0.0D); 
/* 185 */       if (func_110148_a(SharedMonsterAttributes.field_111264_e) == null)
/* 186 */         func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e); 
/* 187 */       func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(3.0D);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\HerobrineMod.jar!\net\mcreator\herobrinemod\entity\HerobrineEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */