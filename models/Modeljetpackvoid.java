// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modeljetpackvoid extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer bone;
	private final ModelRenderer bone4;
	private final ModelRenderer bone3;
	private final ModelRenderer bone2;
	private final ModelRenderer arms;

	public Modeljetpackvoid() {
		textureWidth = 32;
		textureHeight = 32;

		body = new ModelRenderer(this);
		body.setRotationPoint(3.0F, 8.0F, 2.0F);
		body.setTextureOffset(0, 16).addBox(-10.0F, -9.0F, 0.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(8, 8).addBox(-6.0F, 2.0F, 3.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(0, 8).addBox(-2.0F, 2.0F, 3.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(14, 14).addBox(2.0F, -9.0F, 0.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(-6.0F, -6.0F, 0.0F, 6.0F, 6.0F, 2.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-6.0F, 6.0F, 0.0F);
		body.addChild(bone);
		setRotationAngle(bone, 0.7854F, 0.0F, 0.0F);
		bone.setTextureOffset(20, 8).addBox(-0.001F, -4.5858F, 4.2426F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(-3.0F, -10.0F, -4.0F);
		body.addChild(bone4);
		setRotationAngle(bone4, 0.0F, 0.0F, -0.7854F);
		bone4.setTextureOffset(16, 0).addBox(-6.0F, -4.0F, 4.001F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(4.0F, -3.0F, -4.0F);
		body.addChild(bone3);
		setRotationAngle(bone3, 0.0F, 0.0F, 0.7854F);
		bone3.setTextureOffset(8, 20).addBox(-6.0F, -4.0F, 4.001F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(-2.0F, 6.0F, 0.0F);
		body.addChild(bone2);
		setRotationAngle(bone2, 0.7854F, 0.0F, 0.0F);
		bone2.setTextureOffset(20, 20).addBox(-0.001F, -4.5858F, 4.2426F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		arms = new ModelRenderer(this);
		arms.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(arms);

	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}