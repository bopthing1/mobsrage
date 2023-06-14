package com.bopthing1.mobsrage.event;

import com.bopthing1.mobsrage.MobsRage;
import com.bopthing1.mobsrage.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.core.pattern.RegexReplacement;

import java.util.Random;

public class ModEvents {
    public static int randomInt(int Min, int Max) {
        return (int) (Math.random()*(Max-Min))+Min;
    }

    @Mod.EventBusSubscriber(modid = MobsRage.MOD_ID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void onLivingHurt(LivingHurtEvent event) {
            if (event.getEntity() instanceof Mob) {
                Level level = event.getEntity().getLevel();
                Entity entity = event.getEntity();
                RegistryObject[] sounds = ModSounds.SOUNDS;

                RegistryObject<SoundEvent> sound = sounds[randomInt(0, sounds.length)];
                System.out.println(sound.get());

                level.playSound(entity, entity.blockPosition(), sound.get(), SoundSource.AMBIENT, 1f, 1f);
            }
        }
    }
}
