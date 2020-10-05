/*    */ package net.mcreator.herobrinemod.procedures;
/*    */ 
/*    */ import java.util.Map;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModElements;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModElements.ModElement.Tag;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.particles.IParticleData;
/*    */ import net.minecraft.particles.ParticleTypes;
/*    */ import net.minecraft.world.IWorld;
/*    */ import net.minecraft.world.server.ServerWorld;
/*    */ 
/*    */ @Tag
/*    */ public class HerobrineAttackOnEntityTickUpdateProcedure extends HerobrinemodModElements.ModElement {
/*    */   public HerobrineAttackOnEntityTickUpdateProcedure(HerobrinemodModElements instance) {
/* 15 */     super(instance, 15);
/*    */   }
/*    */   
/*    */   public static void executeProcedure(Map<String, Object> dependencies) {
/* 19 */     if (dependencies.get("entity") == null) {
/* 20 */       System.err.println("Failed to load dependency entity for procedure HerobrineAttackOnEntityTickUpdate!");
/*    */       return;
/*    */     } 
/* 23 */     if (dependencies.get("x") == null) {
/* 24 */       System.err.println("Failed to load dependency x for procedure HerobrineAttackOnEntityTickUpdate!");
/*    */       return;
/*    */     } 
/* 27 */     if (dependencies.get("y") == null) {
/* 28 */       System.err.println("Failed to load dependency y for procedure HerobrineAttackOnEntityTickUpdate!");
/*    */       return;
/*    */     } 
/* 31 */     if (dependencies.get("z") == null) {
/* 32 */       System.err.println("Failed to load dependency z for procedure HerobrineAttackOnEntityTickUpdate!");
/*    */       return;
/*    */     } 
/* 35 */     if (dependencies.get("world") == null) {
/* 36 */       System.err.println("Failed to load dependency world for procedure HerobrineAttackOnEntityTickUpdate!");
/*    */       return;
/*    */     } 
/* 39 */     Entity entity = (Entity)dependencies.get("entity");
/* 40 */     double x = (dependencies.get("x") instanceof Integer) ? ((Integer)dependencies.get("x")).intValue() : ((Double)dependencies.get("x")).doubleValue();
/* 41 */     double y = (dependencies.get("y") instanceof Integer) ? ((Integer)dependencies.get("y")).intValue() : ((Double)dependencies.get("y")).doubleValue();
/* 42 */     double z = (dependencies.get("z") instanceof Integer) ? ((Integer)dependencies.get("z")).intValue() : ((Double)dependencies.get("z")).doubleValue();
/* 43 */     IWorld world = (IWorld)dependencies.get("world");
/* 44 */     if (world.func_201672_e().func_72935_r()) {
/* 45 */       if (!entity.field_70170_p.field_72995_K)
/* 46 */         entity.func_70106_y(); 
/* 47 */       if (world instanceof ServerWorld)
/* 48 */         ((ServerWorld)world).func_195598_a((IParticleData)ParticleTypes.field_197601_L, x, y, z, 20, 1.0D, 1.0D, 1.0D, 1.0D); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\HerobrineMod.jar!\net\mcreator\herobrinemod\procedures\HerobrineAttackOnEntityTickUpdateProcedure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */