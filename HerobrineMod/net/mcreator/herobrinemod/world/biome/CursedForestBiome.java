/*     */ package net.mcreator.herobrinemod.world.biome;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import net.mcreator.herobrinemod.HerobrinemodModElements;
/*     */ import net.mcreator.herobrinemod.HerobrinemodModElements.ModElement.Tag;
/*     */ import net.mcreator.herobrinemod.entity.HerobrineEntity;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockState;
/*     */ import net.minecraft.block.Blocks;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.EntityClassification;
/*     */ import net.minecraft.entity.EntityType;
/*     */ import net.minecraft.tags.BlockTags;
/*     */ import net.minecraft.util.Direction;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.MutableBoundingBox;
/*     */ import net.minecraft.world.IBlockReader;
/*     */ import net.minecraft.world.IWorld;
/*     */ import net.minecraft.world.IWorldWriter;
/*     */ import net.minecraft.world.biome.Biome;
/*     */ import net.minecraft.world.biome.DefaultBiomeFeatures;
/*     */ import net.minecraft.world.gen.GenerationStage;
/*     */ import net.minecraft.world.gen.IWorldGenerationReader;
/*     */ import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
/*     */ import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
/*     */ import net.minecraft.world.gen.feature.AbstractTreeFeature;
/*     */ import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
/*     */ import net.minecraft.world.gen.feature.Feature;
/*     */ import net.minecraft.world.gen.feature.IFeatureConfig;
/*     */ import net.minecraft.world.gen.feature.SphereReplaceConfig;
/*     */ import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
/*     */ import net.minecraft.world.gen.placement.ChanceConfig;
/*     */ import net.minecraft.world.gen.placement.FrequencyConfig;
/*     */ import net.minecraft.world.gen.placement.IPlacementConfig;
/*     */ import net.minecraft.world.gen.placement.Placement;
/*     */ import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
/*     */ import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
/*     */ import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
/*     */ import net.minecraftforge.api.distmarker.Dist;
/*     */ import net.minecraftforge.api.distmarker.OnlyIn;
/*     */ import net.minecraftforge.common.BiomeManager;
/*     */ import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
/*     */ import net.minecraftforge.registries.ObjectHolder;
/*     */ 
/*     */ @Tag
/*     */ public class CursedForestBiome extends HerobrinemodModElements.ModElement {
/*     */   @ObjectHolder("herobrinemod:cursed_forest")
/*  49 */   public static final CustomBiome biome = null;
/*     */   public CursedForestBiome(HerobrinemodModElements instance) {
/*  51 */     super(instance, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void initElements() {
/*  56 */     this.elements.biomes.add(() -> new CustomBiome());
/*     */   }
/*     */ 
/*     */   
/*     */   public void init(FMLCommonSetupEvent event) {
/*  61 */     BiomeManager.addSpawnBiome(biome);
/*  62 */     BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 10));
/*     */   }
/*     */   
/*     */   static class CustomBiome extends Biome { public CustomBiome() {
/*  66 */       super((new Biome.Builder()).func_205417_d(0.0F).func_205421_a(0.1F).func_205420_b(0.3F).func_205414_c(0.5F).func_205415_a(Biome.RainType.NONE)
/*  67 */           .func_205419_a(Biome.Category.FOREST).func_205412_a(4159204).func_205413_b(329011)
/*  68 */           .func_222351_a(SurfaceBuilder.field_215396_G, (ISurfaceBuilderConfig)new SurfaceBuilderConfig(Blocks.field_196658_i.func_176223_P(), Blocks.field_150346_d
/*  69 */               .func_176223_P(), Blocks.field_150346_d.func_176223_P())));
/*  70 */       setRegistryName("cursed_forest");
/*  71 */       DefaultBiomeFeatures.func_222300_a(this);
/*  72 */       DefaultBiomeFeatures.func_222295_c(this);
/*  73 */       DefaultBiomeFeatures.func_222335_f(this);
/*  74 */       DefaultBiomeFeatures.func_222288_h(this);
/*  75 */       func_203611_a(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_227247_y_.func_225566_b_((IFeatureConfig)DefaultBiomeFeatures.field_226831_z_)
/*  76 */           .func_227228_a_(Placement.field_215017_c.func_227446_a_((IPlacementConfig)new FrequencyConfig(4))));
/*  77 */       func_203611_a(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_227248_z_.func_225566_b_((IFeatureConfig)DefaultBiomeFeatures.field_226826_u_)
/*  78 */           .func_227228_a_(Placement.field_215018_d.func_227446_a_((IPlacementConfig)new FrequencyConfig(4))));
/*  79 */       func_203611_a(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_227248_z_
/*  80 */           .func_225566_b_((IFeatureConfig)DefaultBiomeFeatures.field_226722_J_)
/*  81 */           .func_227228_a_(Placement.field_215024_j.func_227446_a_((IPlacementConfig)new ChanceConfig(3))));
/*  82 */       func_203611_a(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_227248_z_.func_225566_b_((IFeatureConfig)DefaultBiomeFeatures.field_226721_I_)
/*  83 */           .func_227228_a_(Placement.field_215024_j.func_227446_a_((IPlacementConfig)new ChanceConfig(3))));
/*  84 */       func_203611_a(GenerationStage.Decoration.VEGETAL_DECORATION, (new CursedForestBiome.CustomTreeFeature())
/*     */           
/*  86 */           .func_225566_b_((IFeatureConfig)(new BaseTreeFeatureConfig.Builder((BlockStateProvider)new SimpleBlockStateProvider(Blocks.field_196619_M.func_176223_P()), (BlockStateProvider)new SimpleBlockStateProvider(Blocks.field_150350_a
/*  87 */                 .func_176223_P()))).func_225569_d_(4)
/*  88 */             .setSapling((IPlantable)Blocks.field_196678_w).func_225568_b_())
/*  89 */           .func_227228_a_(Placement.field_215027_m.func_227446_a_((IPlacementConfig)new AtSurfaceWithExtraConfig(3, 0.1F, 1))));
/*  90 */       func_203611_a(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.field_202285_ae
/*     */           
/*  92 */           .func_225566_b_((IFeatureConfig)new SphereReplaceConfig(Blocks.field_150351_n.func_176223_P(), 6, 2, 
/*  93 */               Lists.newArrayList((Object[])new BlockState[] { Blocks.field_196658_i.func_176223_P(), Blocks.field_150346_d.func_176223_P()
/*  94 */                 }))).func_227228_a_(Placement.field_215016_b.func_227446_a_((IPlacementConfig)new FrequencyConfig(1))));
/*  95 */       func_201866_a(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.field_200791_e, 20, 4, 4));
/*  96 */       func_201866_a(EntityClassification.MONSTER, new Biome.SpawnListEntry(HerobrineEntity.entity, 1, 1, 1));
/*     */     }
/*     */ 
/*     */     
/*     */     @OnlyIn(Dist.CLIENT)
/*     */     public int func_225529_c_() {
/* 102 */       return -6710887;
/*     */     } }
/*     */ 
/*     */   
/*     */   static class CustomTreeFeature extends AbstractTreeFeature<BaseTreeFeatureConfig> {
/*     */     CustomTreeFeature() {
/* 108 */       super(BaseTreeFeatureConfig::func_227376_b_);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean func_225557_a_(IWorldGenerationReader worldgen, Random rand, BlockPos position, Set<BlockPos> changedBlocks, Set<BlockPos> changedBlocks2, MutableBoundingBox bbox, BaseTreeFeatureConfig conf) {
/* 114 */       if (!(worldgen instanceof IWorld))
/* 115 */         return false; 
/* 116 */       IWorld world = (IWorld)worldgen;
/* 117 */       int height = rand.nextInt(5) + 4;
/* 118 */       boolean spawnTree = true;
/* 119 */       if (position.func_177956_o() >= 1 && position.func_177956_o() + height + 1 <= world.func_217301_I()) {
/* 120 */         for (int j = position.func_177956_o(); j <= position.func_177956_o() + 1 + height; j++) {
/* 121 */           int k = 1;
/* 122 */           if (j == position.func_177956_o())
/* 123 */             k = 0; 
/* 124 */           if (j >= position.func_177956_o() + height - 1)
/* 125 */             k = 2; 
/* 126 */           for (int px = position.func_177958_n() - k; px <= position.func_177958_n() + k && spawnTree; px++) {
/* 127 */             for (int pz = position.func_177952_p() - k; pz <= position.func_177952_p() + k && spawnTree; pz++) {
/* 128 */               if (j >= 0 && j < world.func_217301_I()) {
/* 129 */                 if (!isReplaceable(world, new BlockPos(px, j, pz))) {
/* 130 */                   spawnTree = false;
/*     */                 }
/*     */               } else {
/* 133 */                 spawnTree = false;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/* 138 */         if (!spawnTree) {
/* 139 */           return false;
/*     */         }
/* 141 */         Block ground = world.func_180495_p(position.func_177982_a(0, -1, 0)).func_177230_c();
/* 142 */         Block ground2 = world.func_180495_p(position.func_177982_a(0, -2, 0)).func_177230_c();
/* 143 */         if ((ground != Blocks.field_196658_i.func_176223_P().func_177230_c() && ground != Blocks.field_150346_d.func_176223_P().func_177230_c()) || (ground2 != Blocks.field_196658_i
/* 144 */           .func_176223_P().func_177230_c() && ground2 != Blocks.field_150346_d.func_176223_P().func_177230_c()))
/* 145 */           return false; 
/* 146 */         BlockState state = world.func_180495_p(position.func_177977_b());
/* 147 */         if (position.func_177956_o() < world.func_217301_I() - height - 1) {
/* 148 */           setTreeBlockState(changedBlocks, (IWorldWriter)world, position.func_177977_b(), Blocks.field_150346_d.func_176223_P(), bbox); int genh;
/* 149 */           for (genh = position.func_177956_o() - 3 + height; genh <= position.func_177956_o() + height; genh++) {
/* 150 */             int i4 = genh - position.func_177956_o() + height;
/* 151 */             int j1 = (int)(1.0D - i4 * 0.5D);
/* 152 */             for (int k1 = position.func_177958_n() - j1; k1 <= position.func_177958_n() + j1; k1++) {
/* 153 */               for (int i2 = position.func_177952_p() - j1; i2 <= position.func_177952_p() + j1; i2++) {
/* 154 */                 int j2 = i2 - position.func_177952_p();
/* 155 */                 if (Math.abs(position.func_177958_n()) != j1 || Math.abs(j2) != j1 || (rand.nextInt(2) != 0 && i4 != 0)) {
/* 156 */                   BlockPos blockpos = new BlockPos(k1, genh, i2);
/* 157 */                   state = world.func_180495_p(blockpos);
/* 158 */                   if (state.func_177230_c().isAir(state, (IBlockReader)world, blockpos) || state.func_185904_a().func_76230_c() || state
/* 159 */                     .func_203425_a(BlockTags.field_206952_E) || state.func_177230_c() == Blocks.field_150350_a.func_176223_P().func_177230_c() || state
/* 160 */                     .func_177230_c() == Blocks.field_150350_a.func_176223_P().func_177230_c()) {
/* 161 */                     setTreeBlockState(changedBlocks, (IWorldWriter)world, blockpos, Blocks.field_150350_a.func_176223_P(), bbox);
/*     */                   }
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/* 167 */           for (genh = 0; genh < height; genh++) {
/* 168 */             BlockPos genhPos = position.func_177981_b(genh);
/* 169 */             state = world.func_180495_p(genhPos);
/* 170 */             setTreeBlockState(changedBlocks, (IWorldWriter)world, genhPos, Blocks.field_196619_M.func_176223_P(), bbox);
/* 171 */             if (state.func_177230_c().isAir(state, (IBlockReader)world, genhPos) || state.func_185904_a().func_76230_c() || state.func_203425_a(BlockTags.field_206952_E) || state
/* 172 */               .func_177230_c() == Blocks.field_150350_a.func_176223_P().func_177230_c() || state
/* 173 */               .func_177230_c() == Blocks.field_150350_a.func_176223_P().func_177230_c());
/*     */           } 
/*     */           
/* 176 */           if (rand.nextInt(4) == 0 && height > 5) {
/* 177 */             for (int hlevel = 0; hlevel < 2; hlevel++) {
/* 178 */               for (Direction Direction : Direction.Plane.HORIZONTAL) {
/* 179 */                 if (rand.nextInt(4 - hlevel) == 0) {
/* 180 */                   Direction dir = Direction.func_176734_d();
/* 181 */                   setTreeBlockState(changedBlocks, (IWorldWriter)world, position.func_177982_a(dir.func_82601_c(), height - 5 + hlevel, dir.func_82599_e()), Blocks.field_150350_a
/* 182 */                       .func_176223_P(), bbox);
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           }
/* 187 */           return true;
/*     */         } 
/* 189 */         return false;
/*     */       } 
/*     */ 
/*     */       
/* 193 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     private void addVines(IWorld world, BlockPos pos, Set<BlockPos> changedBlocks, MutableBoundingBox bbox) {
/* 198 */       setTreeBlockState(changedBlocks, (IWorldWriter)world, pos, Blocks.field_150350_a.func_176223_P(), bbox);
/* 199 */       int i = 5;
/* 200 */       for (BlockPos blockpos = pos.func_177977_b(); world.func_175623_d(blockpos) && i > 0; i--) {
/* 201 */         setTreeBlockState(changedBlocks, (IWorldWriter)world, blockpos, Blocks.field_150350_a.func_176223_P(), bbox);
/* 202 */         blockpos = blockpos.func_177977_b();
/*     */       } 
/*     */     }
/*     */     
/*     */     private boolean canGrowInto(Block blockType) {
/* 207 */       return (blockType.func_176223_P().func_185904_a() == Material.field_151579_a || blockType == Blocks.field_196619_M.func_176223_P().func_177230_c() || blockType == Blocks.field_150350_a
/* 208 */         .func_176223_P().func_177230_c() || blockType == Blocks.field_196658_i.func_176223_P().func_177230_c() || blockType == Blocks.field_150346_d
/* 209 */         .func_176223_P().func_177230_c());
/*     */     }
/*     */     
/*     */     private boolean isReplaceable(IWorld world, BlockPos pos) {
/* 213 */       BlockState state = world.func_180495_p(pos);
/* 214 */       return (state.func_177230_c().isAir(state, (IBlockReader)world, pos) || canGrowInto(state.func_177230_c()) || !state.func_185904_a().func_76230_c());
/*     */     }
/*     */     
/*     */     private void setTreeBlockState(Set<BlockPos> changedBlocks, IWorldWriter world, BlockPos pos, BlockState state, MutableBoundingBox mbb) {
/* 218 */       func_227217_a_(world, pos, state, mbb);
/* 219 */       changedBlocks.add(pos.func_185334_h());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\HerobrineMod.jar!\net\mcreator\herobrinemod\world\biome\CursedForestBiome.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */