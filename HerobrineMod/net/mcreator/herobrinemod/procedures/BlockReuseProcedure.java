/*     */ package net.mcreator.herobrinemod.procedures;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.mcreator.herobrinemod.HerobrinemodModElements;
/*     */ import net.mcreator.herobrinemod.HerobrinemodModElements.ModElement.Tag;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.PlayerEntity;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.Direction;
/*     */ import net.minecraft.util.Hand;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.BlockRayTraceResult;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import net.minecraft.world.IWorld;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.entity.player.PlayerInteractEvent;
/*     */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*     */ import net.minecraftforge.items.CapabilityItemHandler;
/*     */ import net.minecraftforge.items.IItemHandler;
/*     */ import net.minecraftforge.items.IItemHandlerModifiable;
/*     */ 
/*     */ @Tag
/*     */ public class BlockReuseProcedure
/*     */   extends HerobrinemodModElements.ModElement
/*     */ {
/*     */   public BlockReuseProcedure(HerobrinemodModElements instance) {
/*  32 */     super(instance, 14);
/*  33 */     MinecraftForge.EVENT_BUS.register(this);
/*     */   }
/*     */   
/*     */   public static void executeProcedure(Map<String, Object> dependencies) {
/*  37 */     if (dependencies.get("entity") == null) {
/*  38 */       System.err.println("Failed to load dependency entity for procedure BlockReuse!");
/*     */       return;
/*     */     } 
/*  41 */     if (dependencies.get("x") == null) {
/*  42 */       System.err.println("Failed to load dependency x for procedure BlockReuse!");
/*     */       return;
/*     */     } 
/*  45 */     if (dependencies.get("y") == null) {
/*  46 */       System.err.println("Failed to load dependency y for procedure BlockReuse!");
/*     */       return;
/*     */     } 
/*  49 */     if (dependencies.get("z") == null) {
/*  50 */       System.err.println("Failed to load dependency z for procedure BlockReuse!");
/*     */       return;
/*     */     } 
/*  53 */     if (dependencies.get("world") == null) {
/*  54 */       System.err.println("Failed to load dependency world for procedure BlockReuse!");
/*     */       return;
/*     */     } 
/*  57 */     Entity entity = (Entity)dependencies.get("entity");
/*  58 */     double x = (dependencies.get("x") instanceof Integer) ? ((Integer)dependencies.get("x")).intValue() : ((Double)dependencies.get("x")).doubleValue();
/*  59 */     double y = (dependencies.get("y") instanceof Integer) ? ((Integer)dependencies.get("y")).intValue() : ((Double)dependencies.get("y")).doubleValue();
/*  60 */     double z = (dependencies.get("z") instanceof Integer) ? ((Integer)dependencies.get("z")).intValue() : ((Double)dependencies.get("z")).doubleValue();
/*  61 */     IWorld world = (IWorld)dependencies.get("world");
/*  62 */     if (Math.random() > 0.6D) {
/*  63 */       if (Math.random() < 0.7D) {
/*     */         
/*  65 */         TileEntity _ent = world.func_175625_s(new BlockPos((int)x, (int)y, (int)z));
/*  66 */         if (_ent != null) {
/*  67 */           int _sltid = (int)Math.ceil(Math.random() * 26.0D);
/*  68 */           _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
/*     */                 
/*     */                 if (capability instanceof IItemHandlerModifiable) {
/*     */                   ((IItemHandlerModifiable)capability).setStackInSlot(_sltid, ItemStack.field_190927_a);
/*     */                 }
/*     */               });
/*     */         } 
/*     */       } 
/*  76 */     } else if (Math.random() > 0.7D) {
/*  77 */       if (Math.random() < 0.8D) {
/*     */         try {
/*  79 */           BlockState _bs = world.func_180495_p(new BlockPos((int)x, (int)y, (int)z));
/*  80 */           world.func_180501_a(new BlockPos((int)x, (int)y, (int)z), (BlockState)_bs
/*  81 */               .func_206870_a(_bs.func_177230_c().func_176194_O().func_185920_a("facing"), (Comparable)Direction.SOUTH), 3);
/*  82 */         } catch (Exception exception) {}
/*     */       }
/*  84 */       else if (Math.random() < 0.78D) {
/*     */         try {
/*  86 */           BlockState _bs = world.func_180495_p(new BlockPos((int)x, (int)y, (int)z));
/*  87 */           world.func_180501_a(new BlockPos((int)x, (int)y, (int)z), (BlockState)_bs
/*  88 */               .func_206870_a(_bs.func_177230_c().func_176194_O().func_185920_a("facing"), (Comparable)Direction.WEST), 3);
/*  89 */         } catch (Exception exception) {}
/*     */       }
/*  91 */       else if (Math.random() < 0.75D) {
/*     */         try {
/*  93 */           BlockState _bs = world.func_180495_p(new BlockPos((int)x, (int)y, (int)z));
/*  94 */           world.func_180501_a(new BlockPos((int)x, (int)y, (int)z), (BlockState)_bs
/*  95 */               .func_206870_a(_bs.func_177230_c().func_176194_O().func_185920_a("facing"), (Comparable)Direction.EAST), 3);
/*  96 */         } catch (Exception exception) {}
/*     */       }
/*  98 */       else if (Math.random() < 0.72D) {
/*     */         try {
/* 100 */           BlockState _bs = world.func_180495_p(new BlockPos((int)x, (int)y, (int)z));
/* 101 */           world.func_180501_a(new BlockPos((int)x, (int)y, (int)z), (BlockState)_bs
/* 102 */               .func_206870_a(_bs.func_177230_c().func_176194_O().func_185920_a("facing"), (Comparable)Direction.NORTH), 3);
/* 103 */         } catch (Exception exception) {}
/*     */       }
/*     */     
/* 106 */     } else if (Math.random() > 0.8D) {
/* 107 */       if (Math.random() < 0.9D && 
/* 108 */         entity instanceof PlayerEntity && world instanceof World) {
/* 109 */         BlockPos _bp = new BlockPos((int)x, (int)y, (int)z);
/* 110 */         world.func_180495_p(_bp).func_177230_c().func_225533_a_(world.func_180495_p(_bp), world.func_201672_e(), _bp, (PlayerEntity)entity, Hand.MAIN_HAND, 
/* 111 */             BlockRayTraceResult.func_216352_a(new Vec3d(_bp.func_177958_n(), _bp.func_177956_o(), _bp.func_177952_p()), Direction.UP, _bp));
/*     */       }
/*     */     
/* 114 */     } else if (Math.random() > 0.9D) {
/* 115 */       Block.func_220075_c(world.func_180495_p(new BlockPos((int)x, (int)y, (int)z)), world.func_201672_e(), new BlockPos((int)x, (int)y, (int)z));
/* 116 */       world.func_175655_b(new BlockPos((int)x, (int)y, (int)z), false);
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
/* 122 */     PlayerEntity entity = event.getPlayer();
/* 123 */     if (event.getHand() != entity.func_184600_cs())
/*     */       return; 
/* 125 */     int i = event.getPos().func_177958_n();
/* 126 */     int j = event.getPos().func_177956_o();
/* 127 */     int k = event.getPos().func_177952_p();
/* 128 */     World world = event.getWorld();
/* 129 */     Map<String, Object> dependencies = new HashMap<>();
/* 130 */     dependencies.put("x", Integer.valueOf(i));
/* 131 */     dependencies.put("y", Integer.valueOf(j));
/* 132 */     dependencies.put("z", Integer.valueOf(k));
/* 133 */     dependencies.put("world", world);
/* 134 */     dependencies.put("entity", entity);
/* 135 */     dependencies.put("event", event);
/* 136 */     this; executeProcedure(dependencies);
/*     */   }
/*     */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\HerobrineMod.jar!\net\mcreator\herobrinemod\procedures\BlockReuseProcedure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */