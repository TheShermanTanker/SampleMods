/*    */ package net.mcreator.herobrinemod.world.structure;
/*    */ 
/*    */ import com.mojang.datafixers.Dynamic;
/*    */ import java.util.Random;
/*    */ import java.util.function.Function;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModElements;
/*    */ import net.mcreator.herobrinemod.HerobrinemodModElements.ModElement.Tag;
/*    */ import net.minecraft.util.Mirror;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.Rotation;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.util.math.ChunkPos;
/*    */ import net.minecraft.world.IWorld;
/*    */ import net.minecraft.world.biome.Biome;
/*    */ import net.minecraft.world.dimension.DimensionType;
/*    */ import net.minecraft.world.gen.ChunkGenerator;
/*    */ import net.minecraft.world.gen.GenerationStage;
/*    */ import net.minecraft.world.gen.Heightmap;
/*    */ import net.minecraft.world.gen.feature.Feature;
/*    */ import net.minecraft.world.gen.feature.IFeatureConfig;
/*    */ import net.minecraft.world.gen.feature.NoFeatureConfig;
/*    */ import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
/*    */ import net.minecraft.world.gen.feature.template.PlacementSettings;
/*    */ import net.minecraft.world.gen.feature.template.StructureProcessor;
/*    */ import net.minecraft.world.gen.feature.template.Template;
/*    */ import net.minecraft.world.gen.placement.IPlacementConfig;
/*    */ import net.minecraft.world.gen.placement.Placement;
/*    */ import net.minecraft.world.server.ServerWorld;
/*    */ import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
/*    */ import net.minecraftforge.registries.ForgeRegistries;
/*    */ 
/*    */ @Tag
/*    */ public class PyramidStructure extends HerobrinemodModElements.ModElement {
/*    */   public PyramidStructure(HerobrinemodModElements instance) {
/* 35 */     super(instance, 12);
/*    */   }
/*    */ 
/*    */   
/*    */   public void init(FMLCommonSetupEvent event) {
/* 40 */     Feature<NoFeatureConfig> feature = new Feature<NoFeatureConfig>(NoFeatureConfig::func_214639_a)
/*    */       {
/*    */         public boolean place(IWorld world, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
/* 43 */           int ci = (pos.func_177958_n() >> 4) * 16;
/* 44 */           int ck = (pos.func_177952_p() >> 4) * 16;
/* 45 */           DimensionType dimensionType = world.func_201675_m().func_186058_p();
/* 46 */           boolean dimensionCriteria = false;
/* 47 */           if (dimensionType == DimensionType.field_223227_a_)
/* 48 */             dimensionCriteria = true; 
/* 49 */           if (!dimensionCriteria)
/* 50 */             return false; 
/* 51 */           if (random.nextInt(1000000) + 1 <= 3000) {
/* 52 */             int count = random.nextInt(1) + 1;
/* 53 */             for (int a = 0; a < count; a++) {
/* 54 */               int i = ci + random.nextInt(16);
/* 55 */               int k = ck + random.nextInt(16);
/* 56 */               int j = world.func_201676_a(Heightmap.Type.WORLD_SURFACE_WG, i, k);
/* 57 */               j--;
/* 58 */               Rotation rotation = Rotation.values()[random.nextInt(3)];
/* 59 */               Mirror mirror = Mirror.values()[random.nextInt(2)];
/* 60 */               BlockPos spawnTo = new BlockPos(i, j + 1, k);
/* 61 */               int x = spawnTo.func_177958_n();
/* 62 */               int y = spawnTo.func_177956_o();
/* 63 */               int z = spawnTo.func_177952_p();
/*    */               
/* 65 */               Template template = ((ServerWorld)world.func_201672_e()).func_217485_w().func_186340_h().func_200220_a(new ResourceLocation("herobrinemod", "herobrine_pyramid"));
/* 66 */               if (template == null)
/* 67 */                 return false; 
/* 68 */               template.func_186260_a(world, spawnTo, (new PlacementSettings())
/* 69 */                   .func_186220_a(rotation).func_189950_a(random).func_186214_a(mirror)
/* 70 */                   .func_215222_a((StructureProcessor)BlockIgnoreStructureProcessor.field_215204_a).func_186218_a((ChunkPos)null)
/* 71 */                   .func_186222_a(false));
/*    */             } 
/*    */           } 
/* 74 */           return true;
/*    */         }
/*    */       };
/* 77 */     for (Biome biome : ForgeRegistries.BIOMES.getValues())
/* 78 */       biome.func_203611_a(GenerationStage.Decoration.SURFACE_STRUCTURES, feature.func_225566_b_((IFeatureConfig)IFeatureConfig.field_202429_e)
/* 79 */           .func_227228_a_(Placement.field_215022_h.func_227446_a_((IPlacementConfig)IPlacementConfig.field_202468_e))); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Josep\Downloads\Decompile Minecraft\HerobrineMod.jar!\net\mcreator\herobrinemod\world\structure\PyramidStructure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */