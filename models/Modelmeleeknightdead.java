// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelmeleeknightdead extends EntityModel<Entity> {
	private final ModelRenderer main;
	private final ModelRenderer body;
	private final ModelRenderer legr;
	private final ModelRenderer legl;
	private final ModelRenderer head;
	private final ModelRenderer tophorn;
	private final ModelRenderer tophorn2;
	private final ModelRenderer tophorn3;
	private final ModelRenderer arml;
	private final ModelRenderer arml2;
	private final ModelRenderer shield;

	public Modelmeleeknightdead() {
		textureWidth = 80;
		textureHeight = 80;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 35.0F, 0.0F);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -19.3125F, -0.5F);
		main.addChild(body);
		body.setTextureOffset(0, 43).addBox(-1.0F, 7.3125F, -1.5F, 2.0F, 1.0F, 3.0F, 0.0F, false);
		body.setTextureOffset(21, 0).addBox(-6.0F, -7.6875F, -2.5F, 12.0F, 11.0F, 6.0F, 0.0F, false);
		body.setTextureOffset(38, 17).addBox(-5.5F, 3.3125F, -2.0F, 11.0F, 4.0F, 5.0F, 0.0F, false);
		body.setTextureOffset(38, 26).addBox(-5.0F, -6.6875F, 3.5F, 10.0F, 9.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(12, 38).addBox(-4.0F, -5.6875F, 4.5F, 8.0F, 7.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(46, 38).addBox(-5.0F, -6.6875F, -3.5F, 10.0F, 6.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(51, 0).addBox(-4.0F, -5.6875F, -4.5F, 8.0F, 4.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(57, 12).addBox(-3.0F, -0.6875F, -3.5F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		legr = new ModelRenderer(this);
		legr.setRotationPoint(1.0F, -12.5F, 0.0F);
		main.addChild(legr);
		setRotationAngle(legr, -1.5708F, 0.0F, 0.0F);
		legr.setTextureOffset(56, 45).addBox(0.0F, 0.5F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		legr.setTextureOffset(38, 56).addBox(0.5F, 3.5F, -1.5F, 3.0F, 9.0F, 3.0F, 0.0F, false);

		legl = new ModelRenderer(this);
		legl.setRotationPoint(-1.0F, -12.5F, 0.0F);
		main.addChild(legl);
		setRotationAngle(legl, -1.5708F, 0.0F, 0.0F);
		legl.setTextureOffset(57, 5).addBox(-4.0F, 0.5F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		legl.setTextureOffset(50, 56).addBox(-3.5F, 3.5F, -1.5F, 3.0F, 9.0F, 3.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -26.8542F, -0.125F);
		main.addChild(head);
		setRotationAngle(head, 0.829F, 0.0F, 0.0F);
		head.setTextureOffset(22, 38).addBox(-4.0F, -8.1458F, -3.875F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(22, 54).addBox(-3.5F, -7.8958F, -4.875F, 7.0F, 7.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 68).addBox(-5.0F, -9.1458F, -2.875F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(65, 16).addBox(-1.0F, -9.1458F, 3.125F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(62, 32).addBox(-1.0F, -15.1458F, 3.125F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(62, 26).addBox(-6.0F, -13.1458F, -3.875F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(0, 37).addBox(-1.0F, -13.1458F, 4.125F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(62, 62).addBox(4.0F, -13.1458F, -3.875F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(32, 66).addBox(3.0F, -9.1458F, -2.875F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		tophorn = new ModelRenderer(this);
		tophorn.setRotationPoint(0.0F, -16.6458F, 2.625F);
		head.addChild(tophorn);
		setRotationAngle(tophorn, 1.0472F, 0.0F, 0.0F);
		tophorn.setTextureOffset(12, 7).addBox(-0.5F, -1.0F, -1.366F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		tophorn2 = new ModelRenderer(this);
		tophorn2.setRotationPoint(3.0F, -13.6458F, -1.375F);
		head.addChild(tophorn2);
		setRotationAngle(tophorn2, -1.0472F, -0.7854F, 0.0F);
		tophorn2.setTextureOffset(12, 2).addBox(-0.5F, -1.0F, -0.634F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		tophorn3 = new ModelRenderer(this);
		tophorn3.setRotationPoint(-4.0F, -13.6458F, -1.375F);
		head.addChild(tophorn3);
		setRotationAngle(tophorn3, -1.0472F, 0.7854F, 0.0F);
		tophorn3.setTextureOffset(12, 12).addBox(0.2071F, -1.6124F, -0.2804F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		arml = new ModelRenderer(this);
		arml.setRotationPoint(0.0F, -27.0F, 0.0F);
		main.addChild(arml);
		setRotationAngle(arml, 0.2618F, 0.0F, 0.0F);
		arml.setTextureOffset(19, 27).addBox(6.0F, -1.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		arml.setTextureOffset(0, 19).addBox(6.5F, 3.0F, -1.5F, 3.0F, 12.0F, 3.0F, 0.0F, false);
		arml.setTextureOffset(59, 52).addBox(7.0F, 12.9F, -3.0F, 2.0F, 2.0F, 5.0F, 0.0F, false);
		arml.setTextureOffset(0, 0).addBox(7.0F, 12.9F, -21.0F, 2.0F, 2.0F, 17.0F, 0.0F, false);
		arml.setTextureOffset(46, 46).addBox(7.5F, 12.9F, -29.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
		arml.setTextureOffset(19, 20).addBox(7.5F, 11.9F, -21.0F, 1.0F, 1.0F, 17.0F, 0.0F, false);
		arml.setTextureOffset(0, 19).addBox(7.5F, 14.9F, -21.0F, 1.0F, 1.0F, 17.0F, 0.0F, false);
		arml.setTextureOffset(52, 28).addBox(7.5F, 13.4F, -37.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		arml.setTextureOffset(22, 62).addBox(5.5F, 11.4F, -4.0F, 5.0F, 5.0F, 1.0F, 0.0F, false);

		arml2 = new ModelRenderer(this);
		arml2.setRotationPoint(0.0F, -24.0F, 0.0F);
		main.addChild(arml2);
		setRotationAngle(arml2, 0.0F, 0.0F, 0.3491F);
		arml2.setTextureOffset(19, 19).addBox(-10.0F, -1.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		arml2.setTextureOffset(0, 0).addBox(-9.5F, 3.0F, -1.5F, 3.0F, 12.0F, 3.0F, 0.0F, false);

		shield = new ModelRenderer(this);
		shield.setRotationPoint(1.0F, -27.0F, 0.0F);
		main.addChild(shield);
		setRotationAngle(shield, 0.0F, 0.0F, 0.3491F);
		shield.setTextureOffset(9, 0).addBox(-10.0F, 8.0F, 1.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		shield.setTextureOffset(0, 15).addBox(-10.0F, 8.0F, -2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		shield.setTextureOffset(0, 37).addBox(-10.5F, -2.0F, -4.5F, 1.0F, 21.0F, 10.0F, 0.0F, false);
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