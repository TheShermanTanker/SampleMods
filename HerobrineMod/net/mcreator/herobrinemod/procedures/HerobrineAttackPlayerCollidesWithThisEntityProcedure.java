/*    */ package net.mcreator.herobrinemod.procedures;
/*    */ 
/*    */ import java.util.Map;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModElements;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModElements.ModElement.Tag;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.LivingEntity;
/*    */ import net.minecraft.entity.player.PlayerEntity;
/*    */ import net.minecraft.potion.EffectInstance;
/*    */ import net.minecraft.potion.Effects;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.SoundCategory;
/*    */ import net.minecraft.util.SoundEvent;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.IWorld;
/*    */ import net.minecraftforge.registries.ForgeRegistries;
/*    */ 
/*    */ @Tag
/*    */ public class HerobrineAttackPlayerCollidesWithThisEntityProcedure
/*    */   extends HerobrinemodModElements.ModElement {
/*    */   public HerobrineAttackPlayerCollidesWithThisEntityProcedure(HerobrinemodModElements instance) {
/* 23 */     super(instance, 10);
/*    */   }
/*    */   
/*    */   public static void executeProcedure(Map<String, Object> dependencies) {
/* 27 */     if (dependencies.get("entity") == null) {
/* 28 */       System.err.println("Failed to load dependency entity for procedure HerobrineAttackPlayerCollidesWithThisEntity!");
/*    */       return;
/*    */     } 
/* 31 */     if (dependencies.get("sourceentity") == null) {
/* 32 */       System.err.println("Failed to load dependency sourceentity for procedure HerobrineAttackPlayerCollidesWithThisEntity!");
/*    */       return;
/*    */     } 
/* 35 */     if (dependencies.get("x") == null) {
/* 36 */       System.err.println("Failed to load dependency x for procedure HerobrineAttackPlayerCollidesWithThisEntity!");
/*    */       return;
/*    */     } 
/* 39 */     if (dependencies.get("y") == null) {
/* 40 */       System.err.println("Failed to load dependency y for procedure HerobrineAttackPlayerCollidesWithThisEntity!");
/*    */       return;
/*    */     } 
/* 43 */     if (dependencies.get("z") == null) {
/* 44 */       System.err.println("Failed to load dependency z for procedure HerobrineAttackPlayerCollidesWithThisEntity!");
/*    */       return;
/*    */     } 
/* 47 */     if (dependencies.get("world") == null) {
/* 48 */       System.err.println("Failed to load dependency world for procedure HerobrineAttackPlayerCollidesWithThisEntity!");
/*    */       return;
/*    */     } 
/* 51 */     Entity entity = (Entity)dependencies.get("entity");
/* 52 */     Entity sourceentity = (Entity)dependencies.get("sourceentity");
/* 53 */     double x = (dependencies.get("x") instanceof Integer) ? ((Integer)dependencies.get("x")).intValue() : ((Double)dependencies.get("x")).doubleValue();
/* 54 */     double y = (dependencies.get("y") instanceof Integer) ? ((Integer)dependencies.get("y")).intValue() : ((Double)dependencies.get("y")).doubleValue();
/* 55 */     double z = (dependencies.get("z") instanceof Integer) ? ((Integer)dependencies.get("z")).intValue() : ((Double)dependencies.get("z")).doubleValue();
/* 56 */     IWorld world = (IWorld)dependencies.get("world");
/* 57 */     if (sourceentity instanceof LivingEntity)
/* 58 */       ((LivingEntity)sourceentity).func_195064_c(new EffectInstance(Effects.field_76440_q, 120, 3)); 
/* 59 */     if (!entity.field_70170_p.field_72995_K)
/* 60 */       entity.func_70106_y(); 
/* 61 */     world.func_184133_a((world.func_201672_e()).field_72995_K ? (PlayerEntity)(Minecraft.func_71410_x()).field_71439_g : (PlayerEntity)null, new BlockPos(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS
/* 62 */         .getValue(new ResourceLocation("herobrinemod:horror_sound3")), SoundCategory.NEUTRAL, 1.0F, 1.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\HerobrineMod.jar!\net\mcreator\herobrinemod\procedures\HerobrineAttackPlayerCollidesWithThisEntityProcedure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */