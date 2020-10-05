/*    */ package net.mcreator.herobrinemod.procedures;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModElements;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModElements.ModElement.Tag;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.PlayerEntity;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.text.ITextComponent;
/*    */ import net.minecraft.util.text.StringTextComponent;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ import net.minecraftforge.event.entity.player.PlayerEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.server.ServerLifecycleHooks;
/*    */ 
/*    */ @Tag
/*    */ public class SpawnMessageProcedure extends HerobrinemodModElements.ModElement {
/*    */   public SpawnMessageProcedure(HerobrinemodModElements instance) {
/* 20 */     super(instance, 11);
/* 21 */     MinecraftForge.EVENT_BUS.register(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void executeProcedure(Map<String, Object> dependencies) {
/* 26 */     MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
/* 27 */     if (mcserv != null) {
/* 28 */       mcserv.func_184103_al().func_148539_a((ITextComponent)new StringTextComponent("Player has joined the world"));
/*    */     }
/*    */     
/* 31 */     mcserv = ServerLifecycleHooks.getCurrentServer();
/* 32 */     if (mcserv != null) {
/* 33 */       mcserv.func_184103_al().func_148539_a((ITextComponent)new StringTextComponent("Herobrine has joined the world"));
/*    */     }
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
/* 39 */     PlayerEntity playerEntity = event.getPlayer();
/* 40 */     Map<String, Object> dependencies = new HashMap<>();
/* 41 */     dependencies.put("x", Double.valueOf(playerEntity.func_226277_ct_()));
/* 42 */     dependencies.put("y", Double.valueOf(playerEntity.func_226278_cu_()));
/* 43 */     dependencies.put("z", Double.valueOf(playerEntity.func_226281_cx_()));
/* 44 */     dependencies.put("world", ((Entity)playerEntity).field_70170_p);
/* 45 */     dependencies.put("entity", playerEntity);
/* 46 */     dependencies.put("event", event);
/* 47 */     this; executeProcedure(dependencies);
/*    */   }
/*    */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\HerobrineMod.jar!\net\mcreator\herobrinemod\procedures\SpawnMessageProcedure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */