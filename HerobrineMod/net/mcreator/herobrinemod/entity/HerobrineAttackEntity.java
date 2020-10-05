/*     */ package net.mcreator.herobrinemod.entity;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.mcreator.herobrinemod.HerobrinemodModElements;
/*     */ import net.mcreator.herobrinemod.HerobrinemodModElements.ModElement.Tag;
/*     */ import net.mcreator.herobrinemod.procedures.HerobrineAttackOnEntityTickUpdateProcedure;
/*     */ import net.mcreator.herobrinemod.procedures.HerobrineAttackPlayerCollidesWithThisEntityProcedure;
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
/*     */ import net.minecraft.entity.EntitySpawnPlacementRegistry;
/*     */ import net.minecraft.entity.EntityType;
/*     */ import net.minecraft.entity.MobEntity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.goal.Goal;
/*     */ import net.minecraft.entity.ai.goal.HurtByTargetGoal;
/*     */ import net.minecraft.entity.ai.goal.LookRandomlyGoal;
/*     */ import net.minecraft.entity.ai.goal.MeleeAttackGoal;
/*     */ import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
/*     */ import net.minecraft.entity.ai.goal.RandomWalkingGoal;
/*     */ import net.minecraft.entity.monster.MonsterEntity;
/*     */ import net.minecraft.entity.player.PlayerEntity;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemGroup;
/*     */ import net.minecraft.item.SpawnEggItem;
/*     */ import net.minecraft.network.IPacket;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.Biome;
/*     */ import net.minecraft.world.gen.Heightmap;
/*     */ import net.minecraftforge.api.distmarker.Dist;
/*     */ import net.minecraftforge.api.distmarker.OnlyIn;
/*     */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*     */ import net.minecraftforge.fml.client.registry.RenderingRegistry;
/*     */ import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
/*     */ import net.minecraftforge.fml.network.FMLPlayMessages;
/*     */ import net.minecraftforge.fml.network.NetworkHooks;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ 
/*     */ @Tag
/*     */ public class HerobrineAttackEntity extends HerobrinemodModElements.ModElement {
/*  52 */   public static EntityType entity = null;
/*     */   public HerobrineAttackEntity(HerobrinemodModElements instance) {
/*  54 */     super(instance, 10);
/*  55 */     FMLJavaModLoadingContext.get().getModEventBus().register(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initElements() {
/*  62 */     entity = (EntityType)EntityType.Builder.func_220322_a(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).func_220320_c().func_220321_a(0.6F, 1.8F).func_206830_a("herobrine_attack").setRegistryName("herobrine_attack");
/*  63 */     this.elements.entities.add(() -> entity);
/*  64 */     this.elements.items.add(() -> (Item)(new SpawnEggItem(entity, -65485, -13421773, (new Item.Properties()).func_200916_a(ItemGroup.field_78026_f))).setRegistryName("herobrine_attack"));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(FMLCommonSetupEvent event) {
/*  70 */     for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
/*  71 */       biome.func_76747_a(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 18, 1, 1));
/*     */     }
/*  73 */     EntitySpawnPlacementRegistry.func_209343_a(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::func_223324_d);
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   @OnlyIn(Dist.CLIENT)
/*     */   public void registerModels(ModelRegistryEvent event) {
/*  80 */     RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
/*     */           BipedRenderer customRender = new BipedRenderer(renderManager, new BipedModel(0.0F), 0.5F)
/*     */             {
/*     */               public ResourceLocation func_110775_a(Entity entity) {
/*  84 */                 return new ResourceLocation("herobrinemod:textures/herobrine.png");
/*     */               }
/*     */             };
/*     */           customRender.func_177094_a((LayerRenderer)new BipedArmorLayer((IEntityRenderer)customRender, new BipedModel(0.5F), new BipedModel(1.0F)));
/*     */           return (EntityRenderer)customRender;
/*     */         });
/*     */   }
/*     */   
/*     */   public static class CustomEntity extends MonsterEntity { public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
/*  93 */       this(HerobrineAttackEntity.entity, world);
/*     */     }
/*     */     
/*     */     public CustomEntity(EntityType<CustomEntity> type, World world) {
/*  97 */       super(type, world);
/*  98 */       this.field_70728_aV = 0;
/*  99 */       func_94061_f(false);
/*     */     }
/*     */ 
/*     */     
/*     */     public IPacket<?> func_213297_N() {
/* 104 */       return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_184651_r() {
/* 109 */       super.func_184651_r();
/* 110 */       this.field_70714_bg.func_75776_a(1, (Goal)new MeleeAttackGoal((CreatureEntity)this, 2.0D, false));
/* 111 */       this.field_70715_bh.func_75776_a(2, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
/* 112 */       this.field_70714_bg.func_75776_a(3, (Goal)new RandomWalkingGoal((CreatureEntity)this, 0.8D));
/* 113 */       this.field_70714_bg.func_75776_a(4, (Goal)new LookRandomlyGoal((MobEntity)this));
/* 114 */       this.field_70715_bh.func_75776_a(5, (Goal)new NearestAttackableTargetGoal((MobEntity)this, PlayerEntity.class, false, false));
/*     */     }
/*     */ 
/*     */     
/*     */     public CreatureAttribute func_70668_bt() {
/* 119 */       return CreatureAttribute.field_223222_a_;
/*     */     }
/*     */     
/*     */     protected void func_213333_a(DamageSource source, int looting, boolean recentlyHitIn) {
/* 123 */       super.func_213333_a(source, looting, recentlyHitIn);
/*     */     }
/*     */ 
/*     */     
/*     */     public SoundEvent func_184639_G() {
/* 128 */       return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("herobrinemod:longbass"));
/*     */     }
/*     */ 
/*     */     
/*     */     public SoundEvent func_184601_bQ(DamageSource ds) {
/* 133 */       return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
/*     */     }
/*     */ 
/*     */     
/*     */     public SoundEvent func_184615_bR() {
/* 138 */       return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean func_70097_a(DamageSource source, float amount) {
/* 143 */       double x = func_226277_ct_();
/* 144 */       double y = func_226278_cu_();
/* 145 */       double z = func_226281_cx_();
/* 146 */       CustomEntity customEntity = this;
/* 147 */       Entity sourceentity = source.func_76346_g();
/*     */       
/* 149 */       Map<String, Object> $_dependencies = new HashMap<>();
/* 150 */       $_dependencies.put("entity", customEntity);
/* 151 */       $_dependencies.put("sourceentity", sourceentity);
/* 152 */       $_dependencies.put("x", Double.valueOf(x));
/* 153 */       $_dependencies.put("y", Double.valueOf(y));
/* 154 */       $_dependencies.put("z", Double.valueOf(z));
/* 155 */       $_dependencies.put("world", this.field_70170_p);
/* 156 */       HerobrineAttackPlayerCollidesWithThisEntityProcedure.executeProcedure($_dependencies);
/*     */       
/* 158 */       if (source.func_76364_f() instanceof net.minecraft.entity.projectile.ArrowEntity)
/* 159 */         return false; 
/* 160 */       if (source.func_76364_f() instanceof PlayerEntity)
/* 161 */         return false; 
/* 162 */       if (source.func_76364_f() instanceof net.minecraft.entity.projectile.PotionEntity)
/* 163 */         return false; 
/* 164 */       if (source == DamageSource.field_76379_h)
/* 165 */         return false; 
/* 166 */       if (source == DamageSource.field_76367_g)
/* 167 */         return false; 
/* 168 */       if (source == DamageSource.field_76369_e)
/* 169 */         return false; 
/* 170 */       if (source == DamageSource.field_180137_b)
/* 171 */         return false; 
/* 172 */       return super.func_70097_a(source, amount);
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_70030_z() {
/* 177 */       super.func_70030_z();
/* 178 */       double x = func_226277_ct_();
/* 179 */       double y = func_226278_cu_();
/* 180 */       double z = func_226281_cx_();
/* 181 */       CustomEntity customEntity = this;
/*     */       
/* 183 */       Map<String, Object> $_dependencies = new HashMap<>();
/* 184 */       $_dependencies.put("entity", customEntity);
/* 185 */       $_dependencies.put("x", Double.valueOf(x));
/* 186 */       $_dependencies.put("y", Double.valueOf(y));
/* 187 */       $_dependencies.put("z", Double.valueOf(z));
/* 188 */       $_dependencies.put("world", this.field_70170_p);
/* 189 */       HerobrineAttackOnEntityTickUpdateProcedure.executeProcedure($_dependencies);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_70100_b_(PlayerEntity sourceentity) {
/* 195 */       super.func_70100_b_(sourceentity);
/* 196 */       CustomEntity customEntity = this;
/* 197 */       double x = func_226277_ct_();
/* 198 */       double y = func_226278_cu_();
/* 199 */       double z = func_226281_cx_();
/*     */       
/* 201 */       Map<String, Object> $_dependencies = new HashMap<>();
/* 202 */       $_dependencies.put("entity", customEntity);
/* 203 */       $_dependencies.put("sourceentity", sourceentity);
/* 204 */       $_dependencies.put("x", Double.valueOf(x));
/* 205 */       $_dependencies.put("y", Double.valueOf(y));
/* 206 */       $_dependencies.put("z", Double.valueOf(z));
/* 207 */       $_dependencies.put("world", this.field_70170_p);
/* 208 */       HerobrineAttackPlayerCollidesWithThisEntityProcedure.executeProcedure($_dependencies);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void func_110147_ax() {
/* 214 */       super.func_110147_ax();
/* 215 */       if (func_110148_a(SharedMonsterAttributes.field_111263_d) != null)
/* 216 */         func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.3D); 
/* 217 */       if (func_110148_a(SharedMonsterAttributes.field_111267_a) != null)
/* 218 */         func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0D); 
/* 219 */       if (func_110148_a(SharedMonsterAttributes.field_188791_g) != null)
/* 220 */         func_110148_a(SharedMonsterAttributes.field_188791_g).func_111128_a(0.0D); 
/* 221 */       if (func_110148_a(SharedMonsterAttributes.field_111264_e) == null)
/* 222 */         func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e); 
/* 223 */       func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(3.0D);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\HerobrineMod.jar!\net\mcreator\herobrinemod\entity\HerobrineAttackEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */