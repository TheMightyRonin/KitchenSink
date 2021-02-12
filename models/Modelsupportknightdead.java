// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelsupportknightdead extends EntityModel<Entity> {
	private final ModelRenderer main;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer arm1;
	private final ModelRenderer arm2;

	public Modelsupportknightdead() {
		textureWidth = 100;
		textureHeight = 100;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(1.0F, -3.0F, -3.0F);
		main.addChild(leg2);
		setRotationAngle(leg2, 1.5708F, 0.0F, 0.0F);
		leg2.setTextureOffset(16, 47).addBox(0.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		leg2.setTextureOffset(26, 0).addBox(1.0F, 6.0F, -3.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		leg2.setTextureOffset(38, 25).addBox(1.0F, 1.0F, -3.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(-1.0F, -3.0F, -3.0F);
		main.addChild(leg3);
		setRotationAngle(leg3, 1.5708F, 0.0F, 0.0F);
		leg3.setTextureOffset(32, 0).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		leg3.setTextureOffset(0, 0).addBox(-3.0F, 6.0F, -3.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		leg3.setTextureOffset(24, 20).addBox(-3.0F, 1.0F, -3.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 7.0F, -3.0F);
		main.addChild(body);
		setRotationAngle(body, -0.1309F, 0.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-5.0F, -26.0F, -3.0F, 10.0F, 14.0F, 6.0F, 0.0F, false);
		body.setTextureOffset(32, 47).addBox(-4.0F, -25.0F, -4.0F, 8.0F, 12.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(26, 30).addBox(-4.0F, -25.0F, 3.0F, 8.0F, 11.0F, 6.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 1.0F, -17.0F);
		main.addChild(head);
		setRotationAngle(head, -0.7418F, 0.0F, 0.0F);
		head.setTextureOffset(0, 20).addBox(-4.0F, -34.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(0, 52).addBox(4.0F, -33.0F, -3.0F, 1.0F, 6.0F, 6.0F, 0.0F, false);
		head.setTextureOffset(50, 50).addBox(-5.0F, -33.0F, -3.0F, 1.0F, 6.0F, 6.0F, 0.0F, false);
		head.setTextureOffset(48, 28).addBox(-3.0F, -33.0F, -5.0F, 6.0F, 6.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(48, 0).addBox(-1.0F, -35.0F, -3.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(24, 16).addBox(-1.0F, -36.0F, -2.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(36, 16).addBox(-1.0F, -34.0F, 4.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(16, 36).addBox(-1.0F, -35.0F, 5.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 20).addBox(-1.0F, -36.0F, 6.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(48, 0).addBox(-1.0F, -36.0F, 7.0F, 2.0F, 6.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(32, 25).addBox(-1.0F, -35.0F, 8.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);

		arm1 = new ModelRenderer(this);
		arm1.setRotationPoint(5.0F, -18.0F, 0.0F);
		main.addChild(arm1);
		setRotationAngle(arm1, 0.3054F, 0.0F, 0.0F);
		arm1.setTextureOffset(44, 12).addBox(0.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		arm1.setTextureOffset(40, 70).addBox(1.0F, 9.0F, -24.0F, 2.0F, 2.0F, 28.0F, 0.0F, false);
		arm1.setTextureOffset(0, 70).addBox(0.0F, 8.0F, -28.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		arm2 = new ModelRenderer(this);
		arm2.setRotationPoint(-5.0F, -25.0F, 0.0F);
		main.addChild(arm2);
		arm2.setTextureOffset(0, 36).addBox(-4.0F, 7.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
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