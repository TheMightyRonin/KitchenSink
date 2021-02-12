// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelvoidroach extends EntityModel<Entity> {
	private final ModelRenderer bone2;
	private final ModelRenderer body;
	private final ModelRenderer body2;
	private final ModelRenderer body3;
	private final ModelRenderer body4;
	private final ModelRenderer body5;
	private final ModelRenderer body6;
	private final ModelRenderer bone;

	public Modelvoidroach() {
		textureWidth = 32;
		textureHeight = 32;

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 24.0F, 0.0F);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone2.addChild(body);
		body.setTextureOffset(11, 7).addBox(-2.0F, -1.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		body2 = new ModelRenderer(this);
		body2.setRotationPoint(-1.5F, -1.0F, 0.5F);
		bone2.addChild(body2);
		body2.setTextureOffset(0, 9).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		body3 = new ModelRenderer(this);
		body3.setRotationPoint(-1.0F, -1.0F, -1.5F);
		bone2.addChild(body3);
		body3.setTextureOffset(0, 7).addBox(-1.0F, 0.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		body4 = new ModelRenderer(this);
		body4.setRotationPoint(1.0F, -1.0F, -2.5F);
		bone2.addChild(body4);
		body4.setTextureOffset(0, 4).addBox(0.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		body5 = new ModelRenderer(this);
		body5.setRotationPoint(1.0F, -1.0F, 0.5F);
		bone2.addChild(body5);
		body5.setTextureOffset(0, 2).addBox(0.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		body6 = new ModelRenderer(this);
		body6.setRotationPoint(1.0F, -1.0F, 2.5F);
		bone2.addChild(body6);
		body6.setTextureOffset(0, 0).addBox(0.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone2.addChild(bone);
		bone.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 1.0F, 6.0F, 0.0F, false);
		bone.setTextureOffset(0, 7).addBox(-1.5F, -3.0F, -2.5F, 3.0F, 1.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone2.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.body2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.body3.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.body4.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.body5.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.body.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.body6.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}