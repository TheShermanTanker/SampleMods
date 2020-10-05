/*     */ package net.mcreator.herobrinemod.world.structure;
/*     */ import com.mojang.datafixers.Dynamic;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.function.Function;
/*     */ import net.mcreator.herobrinemod.HerobrinemodModElements;
/*     */ import net.mcreator.herobrinemod.HerobrinemodModElements.ModElement.Tag;
/*     */ import net.mcreator.herobrinemod.procedures.TempleOnStructureInstanceGeneratedProcedure;
/*     */ import net.minecraft.util.Mirror;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.Rotation;
/*     */ import net.minecraft.util.concurrent.ThreadTaskExecutor;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.ChunkPos;
/*     */ import net.minecraft.world.IWorld;
/*     */ import net.minecraft.world.biome.Biome;
/*     */ import net.minecraft.world.dimension.DimensionType;
/*     */ import net.minecraft.world.gen.ChunkGenerator;
/*     */ import net.minecraft.world.gen.GenerationStage;
/*     */ import net.minecraft.world.gen.Heightmap;
/*     */ import net.minecraft.world.gen.feature.Feature;
/*     */ import net.minecraft.world.gen.feature.IFeatureConfig;
/*     */ import net.minecraft.world.gen.feature.NoFeatureConfig;
/*     */ import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
/*     */ import net.minecraft.world.gen.feature.template.PlacementSettings;
/*     */ import net.minecraft.world.gen.feature.template.StructureProcessor;
/*     */ import net.minecraft.world.gen.feature.template.Template;
/*     */ import net.minecraft.world.gen.placement.IPlacementConfig;
/*     */ import net.minecraft.world.gen.placement.Placement;
/*     */ import net.minecraft.world.server.ServerWorld;
/*     */ import net.minecraftforge.fml.LogicalSide;
/*     */ import net.minecraftforge.fml.LogicalSidedProvider;
/*     */ import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import net.minecraftforge.registries.IForgeRegistryEntry;
/*     */ 
/*     */ @Tag
/*     */ public class TempleStructure extends HerobrinemodModElements.ModElement {
/*     */   public TempleStructure(HerobrinemodModElements instance) {
/*  41 */     super(instance, 13);
/*     */   }
/*     */ 
/*     */   
/*     */   public void init(FMLCommonSetupEvent event) {
/*  46 */     Feature<NoFeatureConfig> feature = new Feature<NoFeatureConfig>(NoFeatureConfig::func_214639_a)
/*     */       {
/*     */         public boolean place(IWorld world, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
/*  49 */           int ci = (pos.func_177958_n() >> 4) * 16;
/*  50 */           int ck = (pos.func_177952_p() >> 4) * 16;
/*  51 */           DimensionType dimensionType = world.func_201675_m().func_186058_p();
/*  52 */           boolean dimensionCriteria = false;
/*  53 */           if (dimensionType == DimensionType.field_223227_a_)
/*  54 */             dimensionCriteria = true; 
/*  55 */           if (!dimensionCriteria)
/*  56 */             return false; 
/*  57 */           if (random.nextInt(1000000) + 1 <= 1000) {
/*  58 */             int count = random.nextInt(1) + 1;
/*  59 */             for (int a = 0; a < count; a++) {
/*  60 */               int i = ci + random.nextInt(16);
/*  61 */               int k = ck + random.nextInt(16);
/*  62 */               int j = world.func_201676_a(Heightmap.Type.OCEAN_FLOOR_WG, i, k);
/*  63 */               j--;
/*  64 */               Rotation rotation = Rotation.values()[random.nextInt(3)];
/*  65 */               Mirror mirror = Mirror.values()[random.nextInt(2)];
/*  66 */               BlockPos spawnTo = new BlockPos(i, j + 0, k);
/*  67 */               int x = spawnTo.func_177958_n();
/*  68 */               int y = spawnTo.func_177956_o();
/*  69 */               int z = spawnTo.func_177952_p();
/*     */               
/*  71 */               Template template = ((ServerWorld)world.func_201672_e()).func_217485_w().func_186340_h().func_200220_a(new ResourceLocation("herobrinemod", "herobrine_temple"));
/*  72 */               if (template == null)
/*  73 */                 return false; 
/*  74 */               template.func_186260_a(world, spawnTo, (new PlacementSettings())
/*  75 */                   .func_186220_a(rotation).func_189950_a(random).func_186214_a(mirror)
/*  76 */                   .func_215222_a((StructureProcessor)BlockIgnoreStructureProcessor.field_215206_c).func_186218_a((ChunkPos)null)
/*  77 */                   .func_186222_a(false));
/*  78 */               ThreadTaskExecutor<?> executor = (ThreadTaskExecutor)LogicalSidedProvider.WORKQUEUE.get(LogicalSide.SERVER);
/*  79 */               if (!executor.func_213162_bc()) {
/*  80 */                 executor.func_213165_a(() -> {
/*     */                       Map<String, Object> $_dependencies = new HashMap<>();
/*     */ 
/*     */ 
/*     */                       
/*     */                       TempleOnStructureInstanceGeneratedProcedure.executeProcedure($_dependencies);
/*     */                     });
/*     */               } else {
/*  88 */                 Map<String, Object> $_dependencies = new HashMap<>();
/*  89 */                 TempleOnStructureInstanceGeneratedProcedure.executeProcedure($_dependencies);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/*  94 */           return true;
/*     */         }
/*     */       };
/*  97 */     for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
/*  98 */       boolean biomeCriteria = false;
/*  99 */       if (ForgeRegistries.BIOMES.getKey((IForgeRegistryEntry)biome).equals(new ResourceLocation("herobrinemod:cursed_forest")))
/* 100 */         biomeCriteria = true; 
/* 101 */       if (!biomeCriteria)
/*     */         continue; 
/* 103 */       biome.func_203611_a(GenerationStage.Decoration.SURFACE_STRUCTURES, feature.func_225566_b_((IFeatureConfig)IFeatureConfig.field_202429_e)
/* 104 */           .func_227228_a_(Placement.field_215022_h.func_227446_a_((IPlacementConfig)IPlacementConfig.field_202468_e)));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\HerobrineMod.jar!\net\mcreator\herobrinemod\world\structure\TempleStructure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */