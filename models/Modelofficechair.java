// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelofficechair extends EntityModel<Entity> {
	private final ModelRenderer main;
	private final ModelRenderer bottompart;
	private final ModelRenderer axel1;
	private final ModelRenderer axel3;
	private final ModelRenderer axel4;
	private final ModelRenderer axel5;
	private final ModelRenderer axel2;
	private final ModelRenderer bone;
	private final ModelRenderer upperpart;

	public Modelofficechair() {
		textureWidth = 32;
		textureHeight = 32;

		main = new ModelRenderer(this);
		main.setRotationPoint(1.0F, 24.0F, 5.0F);

		bottompart = new ModelRenderer(this);
		bottompart.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(bottompart);
		bottompart.setTextureOffset(0, 0).addBox(2.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bottompart.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -11.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bottompart.setTextureOffset(0, 0).addBox(-6.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bottompart.setTextureOffset(0, 0).addBox(-8.0F, -2.0F, -6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bottompart.setTextureOffset(0, 0).addBox(4.0F, -2.0F, -6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		axel1 = new ModelRenderer(this);
		axel1.setRotationPoint(-1.0F, -2.0F, -2.0F);
		bottompart.addChild(axel1);
		setRotationAngle(axel1, 0.0F, -0.7854F, 0.0F);
		axel1.setTextureOffset(0, 25).addBox(-2.2929F, -1.0F, -0.7071F, 2.0F, 1.0F, 6.0F, 0.0F, false);

		axel3 = new ModelRenderer(this);
		axel3.setRotationPoint(2.0F, -2.0F, -16.0F);
		bottompart.addChild(axel3);
		axel3.setTextureOffset(0, 21).addBox(-4.0F, -1.0F, 6.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);

		axel4 = new ModelRenderer(this);
		axel4.setRotationPoint(1.0F, -2.0F, -12.0F);
		bottompart.addChild(axel4);
		axel4.setTextureOffset(0, 26).addBox(-8.0F, -1.0F, 6.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);

		axel5 = new ModelRenderer(this);
		axel5.setRotationPoint(7.0F, -2.0F, -12.0F);
		bottompart.addChild(axel5);
		axel5.setTextureOffset(0, 25).addBox(-8.0F, -1.0F, 6.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);

		axel2 = new ModelRenderer(this);
		axel2.setRotationPoint(0.0F, -2.0F, -4.0F);
		bottompart.addChild(axel2);
		setRotationAngle(axel2, 0.0F, 0.7854F, 0.0F);
		axel2.setTextureOffset(0, 25).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-1.0F, 0.0F, -5.0F);
		bottompart.addChild(bone);
		bone.setTextureOffset(0, 23).addBox(-1.0F, -9.0F, 0.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		upperpart = new ModelRenderer(this);
		upperpart.setRotationPoint(-1.0F, 0.0F, -5.0F);
		main.addChild(upperpart);
		upperpart.setTextureOffset(0, 0).addBox(-5.0F, -10.0F, -4.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
		upperpart.setTextureOffset(0, 0).addBox(4.0F, -13.0F, -4.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
		upperpart.setTextureOffset(0, 0).addBox(-5.0F, -13.0F, -4.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
		upperpart.setTextureOffset(10, 11).addBox(-5.0F, -18.0F, 5.0F, 10.0F, 8.0F, 1.0F, 0.0F, false);
		upperpart.setTextureOffset(0, 0).addBox(-4.0F, -19.0F, 5.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		upperpart.setTextureOffset(14, 27).addBox(4.0F, -12.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		upperpart.setTextureOffset(14, 27).addBox(-5.0F, -12.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
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