package net.tape.LightsOut.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.AbstractBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Slice;

import java.util.function.ToIntFunction;

@Mixin(Blocks.class)
public class RedstoneTorchMixin {
	@ModifyArg(method = "<clinit>",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/block/AbstractBlock$Settings;luminance(Ljava/util/function/ToIntFunction;)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0),
			slice = @Slice(
					from = @At(value = "CONSTANT", args = "stringValue=redstone_torch")
			)
	)

	private static ToIntFunction<BlockState> foo(ToIntFunction<BlockState> x) {
		return (state) -> 0;
	}
}
