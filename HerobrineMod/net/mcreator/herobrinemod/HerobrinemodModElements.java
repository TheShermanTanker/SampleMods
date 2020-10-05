/*     */ package net.mcreator.herobrinemod;
/*     */ 
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.function.BiConsumer;
/*     */ import java.util.function.Function;
/*     */ import java.util.function.Supplier;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.entity.EntityType;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.world.biome.Biome;
/*     */ import net.minecraftforge.api.distmarker.Dist;
/*     */ import net.minecraftforge.api.distmarker.OnlyIn;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.RegistryEvent;
/*     */ import net.minecraftforge.fml.ModList;
/*     */ import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
/*     */ import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
/*     */ import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
/*     */ import net.minecraftforge.fml.network.NetworkEvent;
/*     */ import net.minecraftforge.forgespi.language.ModFileScanData;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HerobrinemodModElements
/*     */ {
/*  43 */   public final List<ModElement> elements = new ArrayList<>();
/*  44 */   public final List<Supplier<Block>> blocks = new ArrayList<>();
/*  45 */   public final List<Supplier<Item>> items = new ArrayList<>();
/*  46 */   public final List<Supplier<Biome>> biomes = new ArrayList<>();
/*  47 */   public final List<Supplier<EntityType<?>>> entities = new ArrayList<>();
/*  48 */   public final List<Supplier<Enchantment>> enchantments = new ArrayList<>();
/*  49 */   public static Map<ResourceLocation, SoundEvent> sounds = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int messageID;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerSounds(RegistryEvent.Register<SoundEvent> event) {
/*  78 */     for (Map.Entry<ResourceLocation, SoundEvent> sound : sounds.entrySet())
/*  79 */       event.getRegistry().register(((SoundEvent)sound.getValue()).setRegistryName(sound.getKey())); 
/*     */   }
/*  81 */   public HerobrinemodModElements() { this.messageID = 0; sounds.put(new ResourceLocation("herobrinemod", "horror_sound1"), new SoundEvent(new ResourceLocation("herobrinemod", "horror_sound1"))); sounds.put(new ResourceLocation("herobrinemod", "horror_sound2"), new SoundEvent(new ResourceLocation("herobrinemod", "horror_sound2"))); sounds.put(new ResourceLocation("herobrinemod", "horror_sound3"), new SoundEvent(new ResourceLocation("herobrinemod", "horror_sound3"))); sounds.put(new ResourceLocation("herobrinemod", "longbass"), new SoundEvent(new ResourceLocation("herobrinemod", "longbass"))); try { ModFileScanData modFileInfo = ModList.get().getModFileById("herobrinemod").getFile().getScanResult(); Set<ModFileScanData.AnnotationData> annotations = modFileInfo.getAnnotations(); for (ModFileScanData.AnnotationData annotationData : annotations) { if (annotationData.getAnnotationType().getClassName().equals(ModElement.Tag.class.getName())) { Class<?> clazz = Class.forName(annotationData.getClassType().getClassName()); if (clazz.getSuperclass() == ModElement.class)
/*     */             this.elements.add(clazz.getConstructor(new Class[] { getClass() }).newInstance(new Object[] { this }));  }  }  }
/*     */     catch (Exception e) { e.printStackTrace(); }
/*  84 */      Collections.sort(this.elements); this.elements.forEach(ModElement::initElements); MinecraftForge.EVENT_BUS.register(new HerobrinemodModVariables(this)); } public <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, PacketBuffer> encoder, Function<PacketBuffer, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) { HerobrinemodMod.PACKET_HANDLER.registerMessage(this.messageID, messageType, encoder, decoder, messageConsumer);
/*  85 */     this.messageID++; }
/*     */ 
/*     */   
/*     */   public List<ModElement> getElements() {
/*  89 */     return this.elements;
/*     */   }
/*     */   
/*     */   public List<Supplier<Block>> getBlocks() {
/*  93 */     return this.blocks;
/*     */   }
/*     */   
/*     */   public List<Supplier<Item>> getItems() {
/*  97 */     return this.items;
/*     */   }
/*     */   
/*     */   public List<Supplier<Biome>> getBiomes() {
/* 101 */     return this.biomes;
/*     */   }
/*     */   
/*     */   public List<Supplier<EntityType<?>>> getEntities() {
/* 105 */     return this.entities;
/*     */   }
/*     */   
/*     */   public List<Supplier<Enchantment>> getEnchantments() {
/* 109 */     return this.enchantments;
/*     */   }
/*     */   
/*     */   public static class ModElement
/*     */     implements Comparable<ModElement> {
/*     */     protected final HerobrinemodModElements elements;
/*     */     protected final int sortid;
/*     */     
/*     */     public ModElement(HerobrinemodModElements elements, int sortid) {
/* 118 */       this.elements = elements;
/* 119 */       this.sortid = sortid;
/*     */     }
/*     */ 
/*     */     
/*     */     public void initElements() {}
/*     */ 
/*     */     
/*     */     public void init(FMLCommonSetupEvent event) {}
/*     */ 
/*     */     
/*     */     public void serverLoad(FMLServerStartingEvent event) {}
/*     */ 
/*     */     
/*     */     @OnlyIn(Dist.CLIENT)
/*     */     public void clientLoad(FMLClientSetupEvent event) {}
/*     */ 
/*     */     
/*     */     public int compareTo(ModElement other) {
/* 137 */       return this.sortid - other.sortid;
/*     */     }
/*     */     
/*     */     @Retention(RetentionPolicy.RUNTIME)
/*     */     public static @interface Tag {}
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   public static @interface Tag {}
/*     */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\HerobrineMod.jar!\net\mcreator\herobrinemod\HerobrinemodModElements.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */