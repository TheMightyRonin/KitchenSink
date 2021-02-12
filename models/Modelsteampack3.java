// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelsteampack3 extends EntityModel<Entity> {
	private final ModelRenderer Body;
	private final ModelRenderer arms;

	public Modelsteampack3() {
		textureWidth = 32;
		textureHeight = 32;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.setTextureOffset(16, 4).addBox(-1.0F, 3.0F, 2.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(0, 15).addBox(-4.5F, 0.0F, 2.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		Body.setTextureOffset(12, 0).addBox(1.5F, 0.0F, 2.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		Body.setTextureOffset(12, 12).addBox(-5.0F, 1.0F, 2.0F, 4.0F, 11.0F, 4.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(1.0F, 1.0F, 2.0F, 4.0F, 11.0F, 4.0F, 0.0F, false);

		arms = new ModelRenderer(this);
		arms.setRotationPoint(3.0F, 1.0F, 4.0F);
		Body.addChild(arms);

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}