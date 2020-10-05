/*     */ package net.mcreator.dreamboss;
/*     */ 
/*     */ import java.util.function.Function;
/*     */ import java.util.function.Supplier;
/*     */ import net.minecraft.entity.player.ServerPlayerEntity;
/*     */ import net.minecraft.nbt.CompoundNBT;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.world.IWorld;
/*     */ import net.minecraft.world.dimension.DimensionType;
/*     */ import net.minecraft.world.server.ServerWorld;
/*     */ import net.minecraft.world.storage.WorldSavedData;
/*     */ import net.minecraftforge.event.entity.player.PlayerEvent;
/*     */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*     */ import net.minecraftforge.fml.network.NetworkEvent;
/*     */ import net.minecraftforge.fml.network.PacketDistributor;
/*     */ 
/*     */ public class DreambossModVariables
/*     */ {
/*     */   public DreambossModVariables(DreambossModElements elements) {
/*  20 */     elements.addNetworkMessage(WorldSavedDataSyncMessage.class, WorldSavedDataSyncMessage::buffer, WorldSavedDataSyncMessage::new, WorldSavedDataSyncMessage::handler);
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
/*  26 */     if (!(event.getPlayer()).field_70170_p.field_72995_K) {
/*  27 */       WorldSavedData mapdata = MapVariables.get((IWorld)(event.getPlayer()).field_70170_p);
/*  28 */       WorldSavedData worlddata = WorldVariables.get((IWorld)(event.getPlayer()).field_70170_p);
/*  29 */       if (mapdata != null) {
/*  30 */         DreambossMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity)event.getPlayer()), new WorldSavedDataSyncMessage(0, mapdata));
/*     */       }
/*  32 */       if (worlddata != null) {
/*  33 */         DreambossMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity)event.getPlayer()), new WorldSavedDataSyncMessage(1, worlddata));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
/*  40 */     if (!(event.getPlayer()).field_70170_p.field_72995_K) {
/*  41 */       WorldSavedData worlddata = WorldVariables.get((IWorld)(event.getPlayer()).field_70170_p);
/*  42 */       if (worlddata != null)
/*  43 */         DreambossMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity)event.getPlayer()), new WorldSavedDataSyncMessage(1, worlddata)); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class WorldVariables extends WorldSavedData {
/*     */     public static final String DATA_NAME = "dreamboss_worldvars";
/*  49 */     public double timeSec = 0.0D;
/*  50 */     public double DreamHealth = 0.0D;
/*     */     public WorldVariables() {
/*  52 */       super("dreamboss_worldvars");
/*     */     }
/*     */     
/*     */     public WorldVariables(String s) {
/*  56 */       super(s);
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_76184_a(CompoundNBT nbt) {
/*  61 */       this.timeSec = nbt.func_74769_h("timeSec");
/*  62 */       this.DreamHealth = nbt.func_74769_h("DreamHealth");
/*     */     }
/*     */ 
/*     */     
/*     */     public CompoundNBT func_189551_b(CompoundNBT nbt) {
/*  67 */       nbt.func_74780_a("timeSec", this.timeSec);
/*  68 */       nbt.func_74780_a("DreamHealth", this.DreamHealth);
/*  69 */       return nbt;
/*     */     }
/*     */     
/*     */     public void syncData(IWorld world) {
/*  73 */       func_76185_a();
/*  74 */       if (!(world.func_201672_e()).field_72995_K)
/*  75 */         DreambossMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with((world.func_201672_e()).field_73011_w::func_186058_p), new DreambossModVariables.WorldSavedDataSyncMessage(1, this)); 
/*     */     }
/*     */     
/*  78 */     static WorldVariables clientSide = new WorldVariables();
/*     */     public static WorldVariables get(IWorld world) {
/*  80 */       if (world.func_201672_e() instanceof ServerWorld) {
/*  81 */         return (WorldVariables)((ServerWorld)world.func_201672_e()).func_217481_x().func_215752_a(WorldVariables::new, "dreamboss_worldvars");
/*     */       }
/*  83 */       return clientSide;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class MapVariables extends WorldSavedData {
/*     */     public static final String DATA_NAME = "dreamboss_mapvars";
/*     */     
/*     */     public MapVariables() {
/*  91 */       super("dreamboss_mapvars");
/*     */     }
/*     */     
/*     */     public MapVariables(String s) {
/*  95 */       super(s);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_76184_a(CompoundNBT nbt) {}
/*     */ 
/*     */     
/*     */     public CompoundNBT func_189551_b(CompoundNBT nbt) {
/* 104 */       return nbt;
/*     */     }
/*     */     
/*     */     public void syncData(IWorld world) {
/* 108 */       func_76185_a();
/* 109 */       if (!(world.func_201672_e()).field_72995_K)
/* 110 */         DreambossMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new DreambossModVariables.WorldSavedDataSyncMessage(0, this)); 
/*     */     }
/* 112 */     static MapVariables clientSide = new MapVariables();
/*     */     public static MapVariables get(IWorld world) {
/* 114 */       if (world.func_201672_e() instanceof ServerWorld) {
/* 115 */         return (MapVariables)world.func_201672_e().func_73046_m().func_71218_a(DimensionType.field_223227_a_).func_217481_x().func_215752_a(MapVariables::new, "dreamboss_mapvars");
/*     */       }
/* 117 */       return clientSide;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class WorldSavedDataSyncMessage {
/*     */     public int type;
/*     */     public WorldSavedData data;
/*     */     
/*     */     public WorldSavedDataSyncMessage(PacketBuffer buffer) {
/* 126 */       this.type = buffer.readInt();
/* 127 */       this.data = (this.type == 0) ? new DreambossModVariables.MapVariables() : new DreambossModVariables.WorldVariables();
/* 128 */       this.data.func_76184_a(buffer.func_150793_b());
/*     */     }
/*     */     
/*     */     public WorldSavedDataSyncMessage(int type, WorldSavedData data) {
/* 132 */       this.type = type;
/* 133 */       this.data = data;
/*     */     }
/*     */     
/*     */     public static void buffer(WorldSavedDataSyncMessage message, PacketBuffer buffer) {
/* 137 */       buffer.writeInt(message.type);
/* 138 */       buffer.func_150786_a(message.data.func_189551_b(new CompoundNBT()));
/*     */     }
/*     */     
/*     */     public static void handler(WorldSavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
/* 142 */       NetworkEvent.Context context = contextSupplier.get();
/* 143 */       context.enqueueWork(() -> {
/*     */             if (!context.getDirection().getReceptionSide().isServer())
/*     */               if (message.type == 0) {
/*     */                 DreambossModVariables.MapVariables.clientSide = (DreambossModVariables.MapVariables)message.data;
/*     */               } else {
/*     */                 DreambossModVariables.WorldVariables.clientSide = (DreambossModVariables.WorldVariables)message.data;
/*     */               }  
/*     */           });
/* 151 */       context.setPacketHandled(true);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\DreamMod.jar!\net\mcreator\dreamboss\DreambossModVariables.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */