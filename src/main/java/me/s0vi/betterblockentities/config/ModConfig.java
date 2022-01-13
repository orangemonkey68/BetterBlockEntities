package me.s0vi.betterblockentities.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

@Config(name = "betterblockentities")
public class ModConfig implements ConfigData {

    @ConfigEntry.Gui.CollapsibleObject
    ToggledListSection fallingBlocks = new ToggledListSection();

    public ToggledListSection getFallingBlocks() {
        return fallingBlocks;
    }

    public static class ToggledListSection {
        boolean enabled = true;
        boolean whitelist = true;
        List<String> blockIds = new ArrayList<>();

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public boolean isWhitelist() {
            return whitelist;
        }

        public void setWhitelist(boolean whitelist) {
            this.whitelist = whitelist;
        }

        public List<Identifier> getBlocks() {
            return blocks;
        }

        public void setBlocks(List<Identifier> blocks) {
            this.blocks = blocks;
        }
    }
}
