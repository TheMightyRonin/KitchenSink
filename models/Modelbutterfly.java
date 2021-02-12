// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelbutterfly extends EntityModel<Entity> {
	private final ModelRenderer main;
	private final ModelRenderer wing1;
	private final ModelRenderer wing2;
	private final ModelRenderer body;

	public Modelbutterfly() {
		textureWidth = 32;
		textureHeight = 32;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);

		wing1 = new ModelRenderer(this);
		wing1.setRotationPoint(0.75F, -1.0F, 0.0F);
		main.addChild(wing1);
		wing1.setTextureOffset(2, 21).addBox(0.25F, -0.5F, -5.0F, 5.0F, 1.0F, 10.0F, 0.0F, true);
		wing1.setTextureOffset(8, 13).addBox(5.25F, -0.5F, -4.0F, 4.0F, 1.0F, 8.0F, 0.0F, true);

		wing2 = new ModelRenderer(this);
		wing2.setRotationPoint(-1.0F, -1.0F, 0.0F);
		main.addChild(wing2);
		wing2.setTextureOffset(2, 21).addBox(-5.0F, -0.5F, -5.0F, 5.0F, 1.0F, 10.0F, 0.0F, false);
		wing2.setTextureOffset(8, 13).addBox(-9.0F, -0.5F, -4.0F, 4.0F, 1.0F, 8.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(body);
		body.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -6.0F, 2.0F, 2.0F, 12.0F, 0.0F, false);
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
		this.wing1.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.wing2.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}