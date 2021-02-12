// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelvoidspawn extends EntityModel<Entity> {
	private final ModelRenderer main;

	public Modelvoidspawn() {
		textureWidth = 128;
		textureHeight = 128;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);
		main.setTextureOffset(36, 18).addBox(-5.0F, -1.0F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
		main.setTextureOffset(0, 34).addBox(-6.0F, -2.0F, -6.0F, 12.0F, 1.0F, 12.0F, 0.0F, false);
		main.setTextureOffset(0, 0).addBox(-7.0F, -6.0F, -7.0F, 14.0F, 4.0F, 14.0F, 0.0F, false);
		main.setTextureOffset(0, 18).addBox(-6.0F, -10.0F, -6.0F, 12.0F, 4.0F, 12.0F, 0.0F, false);
		main.setTextureOffset(38, 38).addBox(-5.0F, -14.0F, -5.0F, 10.0F, 4.0F, 10.0F, 0.0F, false);
		main.setTextureOffset(40, 29).addBox(-4.0F, -15.0F, -4.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
		main.setTextureOffset(0, 18).addBox(2.0F, -1.0F, 5.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		main.setTextureOffset(0, 8).addBox(-3.0F, -1.0F, 5.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		main.setTextureOffset(0, 12).addBox(4.0F, -1.0F, 6.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		main.setTextureOffset(5, 0).addBox(-4.0F, -1.0F, 6.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		main.setTextureOffset(5, 5).addBox(-8.0F, -1.0F, 9.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		main.setTextureOffset(0, 10).addBox(5.0F, -1.0F, -4.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		main.setTextureOffset(0, 4).addBox(7.0F, -1.0F, 7.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		main.setTextureOffset(6, 2).addBox(-5.0F, -1.0F, 7.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		main.setTextureOffset(7, 7).addBox(-8.0F, -1.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		main.setTextureOffset(0, 0).addBox(8.0F, -1.0F, -7.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		main.render(matrixStack, buffer, packedLight, packedOverlay);
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