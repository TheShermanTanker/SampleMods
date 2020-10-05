/*    */ package net.mcreator.herobrinemod.procedures;
/*    */ 
/*    */ import java.util.Map;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModElements;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModElements.ModElement.Tag;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.text.ITextComponent;
/*    */ import net.minecraft.util.text.StringTextComponent;
/*    */ import net.minecraftforge.fml.server.ServerLifecycleHooks;
/*    */ 
/*    */ @Tag
/*    */ public class TempleOnStructureInstanceGeneratedProcedure
/*    */   extends HerobrinemodModElements.ModElement {
/*    */   public TempleOnStructureInstanceGeneratedProcedure(HerobrinemodModElements instance) {
/* 15 */     super(instance, 13);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void executeProcedure(Map<String, Object> dependencies) {
/* 20 */     MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
/* 21 */     if (mcserv != null)
/* 22 */       mcserv.func_184103_al().func_148539_a((ITextComponent)new StringTextComponent("He's watching")); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\HerobrineMod.jar!\net\mcreator\herobrinemod\procedures\TempleOnStructureInstanceGeneratedProcedure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */