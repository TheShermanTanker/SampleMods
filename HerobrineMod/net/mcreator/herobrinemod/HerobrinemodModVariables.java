/*     */ package net.mcreator.herobrinemod;
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
/*     */ public class HerobrinemodModVariables
/*     */ {
/*     */   public HerobrinemodModVariables(HerobrinemodModElements elements) {
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
/*  30 */         HerobrinemodMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity)event.getPlayer()), new WorldSavedDataSyncMessage(0, mapdata));
/*     */       }
/*  32 */       if (worlddata != null) {
/*  33 */         HerobrinemodMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity)event.getPlayer()), new WorldSavedDataSyncMessage(1, worlddata));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
/*  40 */     if (!(event.getPlayer()).field_70170_p.field_72995_K) {
/*  41 */       WorldSavedData worlddata = WorldVariables.get((IWorld)(event.getPlayer()).field_70170_p);
/*  42 */       if (worlddata != null)
/*  43 */         HerobrinemodMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity)event.getPlayer()), new WorldSavedDataSyncMessage(1, worlddata)); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class WorldVariables
/*     */     extends WorldSavedData {
/*     */     public WorldVariables() {
/*  50 */       super("herobrinemod_worldvars");
/*     */     }
/*     */     public static final String DATA_NAME = "herobrinemod_worldvars";
/*     */     public WorldVariables(String s) {
/*  54 */       super(s);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_76184_a(CompoundNBT nbt) {}
/*     */ 
/*     */     
/*     */     public CompoundNBT func_189551_b(CompoundNBT nbt) {
/*  63 */       return nbt;
/*     */     }
/*     */     
/*     */     public void syncData(IWorld world) {
/*  67 */       func_76185_a();
/*  68 */       if (!(world.func_201672_e()).field_72995_K)
/*  69 */         HerobrinemodMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with((world.func_201672_e()).field_73011_w::func_186058_p), new HerobrinemodModVariables.WorldSavedDataSyncMessage(1, this)); 
/*     */     }
/*     */     
/*  72 */     static WorldVariables clientSide = new WorldVariables();
/*     */     public static WorldVariables get(IWorld world) {
/*  74 */       if (world.func_201672_e() instanceof ServerWorld) {
/*  75 */         return (WorldVariables)((ServerWorld)world.func_201672_e()).func_217481_x().func_215752_a(WorldVariables::new, "herobrinemod_worldvars");
/*     */       }
/*  77 */       return clientSide;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class MapVariables
/*     */     extends WorldSavedData {
/*     */     public static final String DATA_NAME = "herobrinemod_mapvars";
/*  84 */     public double timeSec = 0.0D;
/*  85 */     public double timeSecNether = 0.0D;
/*     */     public MapVariables() {
/*  87 */       super("herobrinemod_mapvars");
/*     */     }
/*     */     
/*     */     public MapVariables(String s) {
/*  91 */       super(s);
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_76184_a(CompoundNBT nbt) {
/*  96 */       this.timeSec = nbt.func_74769_h("timeSec");
/*  97 */       this.timeSecNether = nbt.func_74769_h("timeSecNether");
/*     */     }
/*     */ 
/*     */     
/*     */     public CompoundNBT func_189551_b(CompoundNBT nbt) {
/* 102 */       nbt.func_74780_a("timeSec", this.timeSec);
/* 103 */       nbt.func_74780_a("timeSecNether", this.timeSecNether);
/* 104 */       return nbt;
/*     */     }
/*     */     
/*     */     public void syncData(IWorld world) {
/* 108 */       func_76185_a();
/* 109 */       if (!(world.func_201672_e()).field_72995_K)
/* 110 */         HerobrinemodMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new HerobrinemodModVariables.WorldSavedDataSyncMessage(0, this)); 
/*     */     }
/* 112 */     static MapVariables clientSide = new MapVariables();
/*     */     public static MapVariables get(IWorld world) {
/* 114 */       if (world.func_201672_e() instanceof ServerWorld) {
/* 115 */         return (MapVariables)world.func_201672_e().func_73046_m().func_71218_a(DimensionType.field_223227_a_).func_217481_x().func_215752_a(MapVariables::new, "herobrinemod_mapvars");
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
/* 127 */       this.data = (this.type == 0) ? new HerobrinemodModVariables.MapVariables() : new HerobrinemodModVariables.WorldVariables();
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
/*     */                 HerobrinemodModVariables.MapVariables.clientSide = (HerobrinemodModVariables.MapVariables)message.data;
/*     */               } else {
/*     */                 HerobrinemodModVariables.WorldVariables.clientSide = (HerobrinemodModVariables.WorldVariables)message.data;
/*     */               }  
/*     */           });
/* 151 */       context.setPacketHandled(true);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\HerobrineMod.jar!\net\mcreator\herobrinemod\HerobrinemodModVariables.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */