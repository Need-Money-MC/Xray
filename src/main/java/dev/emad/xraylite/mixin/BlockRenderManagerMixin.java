package dev.emad.xraylite.mixin;

import dev.emad.xraylite.XrayLiteClient;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockRenderManager.class)
public abstract class BlockRenderManagerMixin {
    @Inject(
            method = "renderBlock(Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/BlockRenderView;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;ZLnet/minecraft/util/math/random/Random;)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void xraylite$hideNonOres(
            BlockState state, BlockPos pos, BlockRenderView world,
            MatrixStack matrices, VertexConsumer vertexConsumer,
            boolean cull, Random random, CallbackInfo ci
    ) {
        if (XrayLiteClient.enabled && !XrayLiteClient.isOre(state)) {
            ci.cancel();
        }
    }

    @ModifyVariable(
            method = "renderBlock(Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/BlockRenderView;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;ZLnet/minecraft/util/math/random/Random;)V",
            at = @At("HEAD"),
            argsOnly = true,
            ordinal = 0
    )
    private boolean xraylite$disableFaceCulling(boolean cull) {
        return XrayLiteClient.enabled ? false : cull;
    }
}
