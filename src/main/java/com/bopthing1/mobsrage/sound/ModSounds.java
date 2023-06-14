package com.bopthing1.mobsrage.sound;

import com.bopthing1.mobsrage.MobsRage;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.core.pattern.RegexReplacement;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MobsRage.MOD_ID);

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = new ResourceLocation(MobsRage.MOD_ID,  name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static final RegistryObject<SoundEvent> RAGE1 = registerSoundEvent("rage1");
    public static final RegistryObject<SoundEvent> RAGE2 = registerSoundEvent("rage2");

    public static RegistryObject[] SOUNDS = {RAGE1, RAGE2};
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
