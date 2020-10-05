/*     */ package net.mcreator.herobrinemod.procedures;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.mcreator.herobrinemod.HerobrinemodModElements;
/*     */ import net.mcreator.herobrinemod.HerobrinemodModElements.ModElement.Tag;
/*     */ import net.mcreator.herobrinemod.HerobrinemodModVariables;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.PlayerEntity;
/*     */ import net.minecraft.entity.player.ServerPlayerEntity;
/*     */ import net.minecraft.network.IPacket;
/*     */ import net.minecraft.network.play.server.SChangeGameStatePacket;
/*     */ import net.minecraft.network.play.server.SPlayEntityEffectPacket;
/*     */ import net.minecraft.network.play.server.SPlaySoundEventPacket;
/*     */ import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
/*     */ import net.minecraft.potion.EffectInstance;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.IWorld;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.dimension.DimensionType;
/*     */ import net.minecraft.world.server.ServerWorld;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.TickEvent;
/*     */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*     */ import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import net.minecraftforge.registries.IForgeRegistryEntry;
/*     */ 
/*     */ @Tag
/*     */ public class TimerNightmareProcedure extends HerobrinemodModElements.ModElement {
/*     */   public TimerNightmareProcedure(HerobrinemodModElements instance) {
/*  32 */     super(instance, 8);
/*  33 */     MinecraftForge.EVENT_BUS.register(this);
/*     */   }
/*     */   
/*     */   public static void executeProcedure(Map<String, Object> dependencies) {
/*  37 */     if (dependencies.get("entity") == null) {
/*  38 */       System.err.println("Failed to load dependency entity for procedure TimerNightmare!");
/*     */       return;
/*     */     } 
/*  41 */     if (dependencies.get("x") == null) {
/*  42 */       System.err.println("Failed to load dependency x for procedure TimerNightmare!");
/*     */       return;
/*     */     } 
/*  45 */     if (dependencies.get("y") == null) {
/*  46 */       System.err.println("Failed to load dependency y for procedure TimerNightmare!");
/*     */       return;
/*     */     } 
/*  49 */     if (dependencies.get("z") == null) {
/*  50 */       System.err.println("Failed to load dependency z for procedure TimerNightmare!");
/*     */       return;
/*     */     } 
/*  53 */     if (dependencies.get("world") == null) {
/*  54 */       System.err.println("Failed to load dependency world for procedure TimerNightmare!");
/*     */       return;
/*     */     } 
/*  57 */     Entity entity = (Entity)dependencies.get("entity");
/*  58 */     double x = (dependencies.get("x") instanceof Integer) ? ((Integer)dependencies.get("x")).intValue() : ((Double)dependencies.get("x")).doubleValue();
/*  59 */     double y = (dependencies.get("y") instanceof Integer) ? ((Integer)dependencies.get("y")).intValue() : ((Double)dependencies.get("y")).doubleValue();
/*  60 */     double z = (dependencies.get("z") instanceof Integer) ? ((Integer)dependencies.get("z")).intValue() : ((Double)dependencies.get("z")).doubleValue();
/*  61 */     IWorld world = (IWorld)dependencies.get("world");
/*     */     
/*  63 */     (HerobrinemodModVariables.MapVariables.get(world)).timeSecNether += 0.05D;
/*  64 */     HerobrinemodModVariables.MapVariables.get(world).syncData(world);
/*  65 */     if (ForgeRegistries.BIOMES.getKey((IForgeRegistryEntry)world.func_226691_t_(new BlockPos((int)x, (int)y, (int)z))).equals(new ResourceLocation("nether")) && 
/*  66 */       (HerobrinemodModVariables.MapVariables.get(world)).timeSecNether >= 2.0D && 
/*  67 */       (HerobrinemodModVariables.MapVariables.get(world)).timeSecNether < 3.0D) {
/*     */       
/*  69 */       Entity _ent = entity;
/*  70 */       if (!_ent.field_70170_p.field_72995_K && _ent instanceof ServerPlayerEntity) {
/*  71 */         DimensionType destinationType = DimensionType.field_223227_a_;
/*  72 */         ObfuscationReflectionHelper.setPrivateValue(ServerPlayerEntity.class, _ent, Boolean.valueOf(true), "field_184851_cj");
/*  73 */         ServerWorld nextWorld = _ent.func_184102_h().func_71218_a(destinationType);
/*  74 */         ((ServerPlayerEntity)_ent).field_71135_a.func_147359_a((IPacket)new SChangeGameStatePacket(4, 0.0F));
/*  75 */         ((ServerPlayerEntity)_ent).func_200619_a(nextWorld, nextWorld.func_175694_M().func_177958_n(), (nextWorld.func_175694_M().func_177956_o() + 1), nextWorld
/*  76 */             .func_175694_M().func_177952_p(), _ent.field_70177_z, _ent.field_70125_A);
/*  77 */         ((ServerPlayerEntity)_ent).field_71135_a.func_147359_a((IPacket)new SPlayerAbilitiesPacket(((ServerPlayerEntity)_ent).field_71075_bZ));
/*  78 */         for (EffectInstance effectinstance : ((ServerPlayerEntity)_ent).func_70651_bq()) {
/*  79 */           ((ServerPlayerEntity)_ent).field_71135_a.func_147359_a((IPacket)new SPlayEntityEffectPacket(_ent.func_145782_y(), effectinstance));
/*     */         }
/*  81 */         ((ServerPlayerEntity)_ent).field_71135_a.func_147359_a((IPacket)new SPlaySoundEventPacket(1032, BlockPos.field_177992_a, 0, false));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onPlayerTick(TickEvent.PlayerTickEvent event) {
/*  91 */     if (event.phase == TickEvent.Phase.END) {
/*  92 */       PlayerEntity playerEntity = event.player;
/*  93 */       World world = ((Entity)playerEntity).field_70170_p;
/*  94 */       double i = playerEntity.func_226277_ct_();
/*  95 */       double j = playerEntity.func_226278_cu_();
/*  96 */       double k = playerEntity.func_226281_cx_();
/*  97 */       Map<String, Object> dependencies = new HashMap<>();
/*  98 */       dependencies.put("x", Double.valueOf(i));
/*  99 */       dependencies.put("y", Double.valueOf(j));
/* 100 */       dependencies.put("z", Double.valueOf(k));
/* 101 */       dependencies.put("world", world);
/* 102 */       dependencies.put("entity", playerEntity);
/* 103 */       dependencies.put("event", event);
/* 104 */       this; executeProcedure(dependencies);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\HerobrineMod.jar!\net\mcreator\herobrinemod\procedures\TimerNightmareProcedure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */