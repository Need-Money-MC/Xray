package dev.emad.xraylite;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public final class XrayLiteClient implements ClientModInitializer {
    public static boolean enabled = false;
    private static KeyBinding toggleKey;

    @Override
    public void onInitializeClient() {
        toggleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.xraylite.toggle",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_X,
                "category.xraylite"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (toggleKey.wasPressed()) {
                enabled = !enabled;

                if (client.worldRenderer != null) {
                    client.worldRenderer.reload();
                }

                if (client.player != null) {
                    client.player.sendMessage(
                            Text.literal("X-Ray ")
                                    .formatted(Formatting.GOLD)
                                    .append(Text.literal(enabled ? "ON" : "OFF")
                                            .formatted(enabled ? Formatting.GREEN : Formatting.RED)),
                            true
                    );
                }
            }
        });
    }

    public static boolean isOre(net.minecraft.block.BlockState state) {
        var block = state.getBlock();
        return block == net.minecraft.block.Blocks.COAL_ORE
                || block == net.minecraft.block.Blocks.DEEPSLATE_COAL_ORE
                || block == net.minecraft.block.Blocks.IRON_ORE
                || block == net.minecraft.block.Blocks.DEEPSLATE_IRON_ORE
                || block == net.minecraft.block.Blocks.COPPER_ORE
                || block == net.minecraft.block.Blocks.DEEPSLATE_COPPER_ORE
                || block == net.minecraft.block.Blocks.GOLD_ORE
                || block == net.minecraft.block.Blocks.DEEPSLATE_GOLD_ORE
                || block == net.minecraft.block.Blocks.REDSTONE_ORE
                || block == net.minecraft.block.Blocks.DEEPSLATE_REDSTONE_ORE
                || block == net.minecraft.block.Blocks.EMERALD_ORE
                || block == net.minecraft.block.Blocks.DEEPSLATE_EMERALD_ORE
                || block == net.minecraft.block.Blocks.LAPIS_ORE
                || block == net.minecraft.block.Blocks.DEEPSLATE_LAPIS_ORE
                || block == net.minecraft.block.Blocks.DIAMOND_ORE
                || block == net.minecraft.block.Blocks.DEEPSLATE_DIAMOND_ORE
                || block == net.minecraft.block.Blocks.NETHER_GOLD_ORE
                || block == net.minecraft.block.Blocks.NETHER_QUARTZ_ORE
                || block == net.minecraft.block.Blocks.ANCIENT_DEBRIS;
    }
}
