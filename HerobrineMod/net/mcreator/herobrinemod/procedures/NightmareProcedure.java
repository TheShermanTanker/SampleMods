/*    */ package net.mcreator.herobrinemod.procedures;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModElements;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModElements.ModElement.Tag;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModVariables;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.LivingEntity;
/*    */ import net.minecraft.entity.player.ServerPlayerEntity;
/*    */ import net.minecraft.network.IPacket;
/*    */ import net.minecraft.network.play.server.SChangeGameStatePacket;
/*    */ import net.minecraft.network.play.server.SPlayEntityEffectPacket;
/*    */ import net.minecraft.network.play.server.SPlaySoundEventPacket;
/*    */ import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
/*    */ import net.minecraft.potion.EffectInstance;
/*    */ import net.minecraft.potion.Effects;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.IWorld;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.dimension.DimensionType;
/*    */ import net.minecraft.world.server.ServerWorld;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
/*    */ 
/*    */ @Tag
/*    */ public class NightmareProcedure
/*    */   extends HerobrinemodModElements.ModElement {
/*    */   public NightmareProcedure(HerobrinemodModElements instance) {
/* 32 */     super(instance, 7);
/* 33 */     MinecraftForge.EVENT_BUS.register(this);
/*    */   }
/*    */   
/*    */   public static void executeProcedure(Map<String, Object> dependencies) {
/* 37 */     if (dependencies.get("entity") == null) {
/* 38 */       System.err.println("Failed to load dependency entity for procedure Nightmare!");
/*    */       return;
/*    */     } 
/* 41 */     if (dependencies.get("world") == null) {
/* 42 */       System.err.println("Failed to load dependency world for procedure Nightmare!");
/*    */       return;
/*    */     } 
/* 45 */     Entity entity = (Entity)dependencies.get("entity");
/* 46 */     IWorld world = (IWorld)dependencies.get("world");
/* 47 */     if (Math.random() > 0.9D) {
/* 48 */       if (entity instanceof LivingEntity)
/* 49 */         ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_76426_n, 40, 1)); 
/* 50 */       if (entity instanceof LivingEntity) {
/* 51 */         ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_204839_B, 40, 1));
/*    */       }
/* 53 */       Entity _ent = entity;
/* 54 */       if (!_ent.field_70170_p.field_72995_K && _ent instanceof ServerPlayerEntity) {
/* 55 */         DimensionType destinationType = DimensionType.field_223228_b_;
/* 56 */         ObfuscationReflectionHelper.setPrivateValue(ServerPlayerEntity.class, _ent, Boolean.valueOf(true), "field_184851_cj");
/* 57 */         ServerWorld nextWorld = _ent.func_184102_h().func_71218_a(destinationType);
/* 58 */         ((ServerPlayerEntity)_ent).field_71135_a.func_147359_a((IPacket)new SChangeGameStatePacket(4, 0.0F));
/* 59 */         ((ServerPlayerEntity)_ent).func_200619_a(nextWorld, nextWorld.func_175694_M().func_177958_n(), (nextWorld.func_175694_M().func_177956_o() + 1), nextWorld
/* 60 */             .func_175694_M().func_177952_p(), _ent.field_70177_z, _ent.field_70125_A);
/* 61 */         ((ServerPlayerEntity)_ent).field_71135_a.func_147359_a((IPacket)new SPlayerAbilitiesPacket(((ServerPlayerEntity)_ent).field_71075_bZ));
/* 62 */         for (EffectInstance effectinstance : ((ServerPlayerEntity)_ent).func_70651_bq()) {
/* 63 */           ((ServerPlayerEntity)_ent).field_71135_a.func_147359_a((IPacket)new SPlayEntityEffectPacket(_ent.func_145782_y(), effectinstance));
/*    */         }
/* 65 */         ((ServerPlayerEntity)_ent).field_71135_a.func_147359_a((IPacket)new SPlaySoundEventPacket(1032, BlockPos.field_177992_a, 0, false));
/*    */       } 
/*    */       
/* 68 */       (HerobrinemodModVariables.MapVariables.get(world)).timeSecNether = 0.0D;
/* 69 */       HerobrinemodModVariables.MapVariables.get(world).syncData(world);
/*    */     } 
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onEntityEndSleep(PlayerWakeUpEvent event) {
/* 75 */     Entity entity = event.getEntity();
/* 76 */     World world = entity.field_70170_p;
/* 77 */     double i = entity.func_226277_ct_();
/* 78 */     double j = entity.func_226278_cu_();
/* 79 */     double k = entity.func_226281_cx_();
/* 80 */     Map<String, Object> dependencies = new HashMap<>();
/* 81 */     dependencies.put("x", Double.valueOf(i));
/* 82 */     dependencies.put("y", Double.valueOf(j));
/* 83 */     dependencies.put("z", Double.valueOf(k));
/* 84 */     dependencies.put("world", world);
/* 85 */     dependencies.put("entity", entity);
/* 86 */     dependencies.put("event", event);
/* 87 */     this; executeProcedure(dependencies);
/*    */   }
/*    */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\HerobrineMod.jar!\net\mcreator\herobrinemod\procedures\NightmareProcedure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */