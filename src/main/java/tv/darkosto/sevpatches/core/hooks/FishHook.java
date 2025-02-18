package tv.darkosto.sevpatches.core.hooks;

import com.tmtravlr.jaff.ConfigOptions;
import com.tmtravlr.jaff.entities.EntityFishClownfish;
import com.tmtravlr.jaff.entities.EntityFishCod;
import com.tmtravlr.jaff.entities.EntityFishPufferfish;
import com.tmtravlr.jaff.entities.EntityFishSalmon;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import tv.darkosto.sevpatches.core.SevPatchesLoadingPlugin;

import java.util.HashSet;
import java.util.Set;

public class FishHook {
    public static void registerPlacement() {
        SevPatchesLoadingPlugin.LOGGER.info("JAFFA Phase 1");
        EntitySpawnPlacementRegistry.setPlacementType(EntityFishCod.class, EntityLiving.SpawnPlacementType.IN_WATER);
        EntitySpawnPlacementRegistry.setPlacementType(EntityFishClownfish.class, EntityLiving.SpawnPlacementType.IN_WATER);
        EntitySpawnPlacementRegistry.setPlacementType(EntityFishPufferfish.class, EntityLiving.SpawnPlacementType.IN_WATER);
        EntitySpawnPlacementRegistry.setPlacementType(EntityFishSalmon.class, EntityLiving.SpawnPlacementType.IN_WATER);
    }

    public static void registerSpawns() {
        SevPatchesLoadingPlugin.LOGGER.info("JAFFA Phase 2");

        Set<Biome> waterBiomes = new HashSet<>();
        waterBiomes.addAll(BiomeDictionary.getBiomes(BiomeDictionary.Type.RIVER));
        waterBiomes.addAll(BiomeDictionary.getBiomes(BiomeDictionary.Type.SWAMP));
        waterBiomes.addAll(BiomeDictionary.getBiomes(BiomeDictionary.Type.OCEAN));

        Set<Biome> landWaterBiomes = new HashSet<>();
        landWaterBiomes.addAll(BiomeDictionary.getBiomes(BiomeDictionary.Type.RIVER));
        landWaterBiomes.addAll(BiomeDictionary.getBiomes(BiomeDictionary.Type.SWAMP));

        if (ConfigOptions.enableCod) {
            EntityRegistry.addSpawn(EntityFishCod.class, 40, 4, 4, EnumCreatureType.WATER_CREATURE, waterBiomes.toArray(new Biome[0]));
        }
        if (ConfigOptions.enableClownfish) {
            EntityRegistry.addSpawn(EntityFishClownfish.class, 12, 4, 4, EnumCreatureType.WATER_CREATURE, BiomeDictionary.getBiomes(BiomeDictionary.Type.OCEAN).toArray(new Biome[0]));
        }
        if (ConfigOptions.enablePufferfish) {
            EntityRegistry.addSpawn(EntityFishPufferfish.class, 8, 1, 1, EnumCreatureType.WATER_CREATURE, BiomeDictionary.getBiomes(BiomeDictionary.Type.OCEAN).toArray(new Biome[0]));
        }
        if (ConfigOptions.enableSalmon) {
            EntityRegistry.addSpawn(EntityFishSalmon.class, 4, 4, 4, EnumCreatureType.WATER_CREATURE, BiomeDictionary.getBiomes(BiomeDictionary.Type.OCEAN).toArray(new Biome[0]));
            EntityRegistry.addSpawn(EntityFishSalmon.class, 40, 4, 4, EnumCreatureType.WATER_CREATURE, landWaterBiomes.toArray(new Biome[0]));
        }
    }
}
