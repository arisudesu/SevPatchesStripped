package tv.darkosto.sevpatches.core;

import net.minecraft.launchwrapper.IClassTransformer;
import tv.darkosto.sevpatches.core.patches.PatchJaffFishAreFish;
import tv.darkosto.sevpatches.core.patches.PatchJaffFishLiveInWater;
import tv.darkosto.sevpatches.core.patches.PatchJaffSpawnRemover;

public class SevPatchesTransformer implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        switch (transformedName) {
            case "com.tmtravlr.jaff.JAFFMod":
                return new PatchJaffFishLiveInWater(basicClass).apply();
            case "com.tmtravlr.jaff.JAFFEventHandler":
                return new PatchJaffSpawnRemover(basicClass).apply();
            case "com.tmtravlr.jaff.entities.EntityFish":
                return new PatchJaffFishAreFish(basicClass).apply();
            default:
                return basicClass;
        }
    }
}
