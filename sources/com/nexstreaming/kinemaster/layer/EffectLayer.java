package com.nexstreaming.kinemaster.layer;

import android.content.Context;
import android.graphics.Rect;
import android.opengl.GLES20;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.ui.projectedit.kp;
import com.nexstreaming.kinemaster.ui.projectedit.r;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import java.util.UUID;

/* loaded from: classes.dex */
public class EffectLayer extends NexLayerItem implements NexTimelineItem.k, NexTimelineItem.l {

    /* renamed from: a */
    private transient int f3470a;
    private transient int b;
    private transient boolean c;
    private String effectId;
    private float effectStrength = 0.5f;
    private float effectVariation = 0.5f;
    private NexLayerItem.b scratchKF = new NexLayerItem.b();
    private LayerRenderer.g mEffectTexture = null;

    public void releaseTexture() {
        this.mEffectTexture = null;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAwake(LayerRenderer layerRenderer) {
        a();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAsleep(LayerRenderer layerRenderer) {
        releaseTexture();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRender(LayerRenderer layerRenderer, NexLayerItem.b bVar) {
        KineMasterApplication.a().getApplicationContext();
        float f = (-this.f3470a) / 2;
        float f2 = (-this.b) / 2;
        float c = layerRenderer.c() / 1280.0f;
        float f3 = layerRenderer.f() / 720.0f;
        float f4 = bVar.b * this.f3470a * c;
        float f5 = bVar.b * this.b * f3;
        float f6 = (c * bVar.c) - (f4 * 0.5f);
        float f7 = ((720.0f - bVar.d) * f3) - (0.5f * f5);
        layerRenderer.l();
        GLES20.glEnable(2960);
        GLES20.glStencilFunc(519, 1, 255);
        GLES20.glStencilOp(7681, 7681, 7681);
        GLES20.glColorMask(false, false, false, false);
        GLES20.glStencilMask(255);
        GLES20.glClear(1024);
        layerRenderer.b(-1, f, f2, f + this.f3470a, f2 + this.b);
        GLES20.glColorMask(true, true, true, true);
        GLES20.glStencilFunc(514, 1, 255);
        GLES20.glStencilMask(0);
        this.mEffectTexture = layerRenderer.a(this.mEffectTexture, 0.0f, 0.0f, layerRenderer.c(), layerRenderer.f());
        layerRenderer.t();
        layerRenderer.a(this.mEffectTexture.b());
        layerRenderer.b(this.mEffectTexture.c());
        if (getEffectId().equals("Blur")) {
            layerRenderer.d(true);
            layerRenderer.e(false);
            layerRenderer.c(getStrengthValue());
        } else {
            layerRenderer.d(false);
        }
        if (getEffectId().equals("Mosaic")) {
            layerRenderer.f(true);
            layerRenderer.c(getStrengthValue());
        } else {
            layerRenderer.f(false);
        }
        layerRenderer.a(this.mEffectTexture.a(), 640.0f, 360.0f, 1280.0f, 720.0f);
        if (getEffectId().equals("Blur")) {
            layerRenderer.d(false);
            layerRenderer.e(true);
            this.mEffectTexture = layerRenderer.a(this.mEffectTexture, 0.0f, 0.0f, layerRenderer.c(), layerRenderer.f());
            layerRenderer.a(this.mEffectTexture.a(), 640.0f, 360.0f, 1280.0f, 720.0f);
        }
        GLES20.glDisable(2960);
        layerRenderer.m();
        layerRenderer.e(false);
        layerRenderer.d(false);
        layerRenderer.f(false);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean isTransformedPointInLayerAtTime(float f, float f2, int i) {
        int i2 = (-getWidth()) / 2;
        int width = getWidth() + i2;
        int i3 = (-getHeight()) / 2;
        return f >= ((float) i2) && f <= ((float) width) && f2 >= ((float) i3) && f2 <= ((float) (getHeight() + i3));
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected String getLabelText(Context context) {
        return context.getString(R.string.layer_menu_effect);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveTitle(Context context) {
        return context.getResources().getString(R.string.layer_menu_effect);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getBGColor() {
        return R.color.layer_effect;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getIcon() {
        return R.drawable.opt_clip_effect;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Class<? extends kp> getOptionMenuClass() {
        return r.class;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean getSwitchOption(int i) {
        return super.getSwitchOption(i);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Task setSwitchOption(int i, boolean z, Context context) {
        super.setSwitchOption(i, z, context);
        return null;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getColorOption(int i) {
        return super.getColorOption(i);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void setColorOption(int i, int i2) {
        super.setColorOption(i, i2);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getWidth() {
        a();
        return this.f3470a;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getHeight() {
        a();
        return this.b;
    }

    public String getEffectId() {
        return this.effectId;
    }

    public void setEffectId(String str) {
        this.effectId = str;
    }

    private void a() {
        if (!this.c) {
            this.f3470a = 100;
            this.b = 100;
            this.c = true;
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public KMProto.KMProject.TimelineItem asProtoBuf() {
        KMProto.KMProject.EffectLayer.Builder builder = new KMProto.KMProject.EffectLayer.Builder();
        builder.effect_id = this.effectId;
        builder.effect_strength = Float.valueOf(this.effectStrength);
        builder.effect_variation = Float.valueOf(this.effectVariation);
        builder.layer_common = getLayerCommonProtoBuf();
        return new KMProto.KMProject.TimelineItem.Builder().clip_type(KMProto.KMProject.ClipType.LAYER_EFFECT).unique_id_lsb(Long.valueOf(getUniqueId().getLeastSignificantBits())).unique_id_msb(Long.valueOf(getUniqueId().getMostSignificantBits())).effect_layer(builder.build()).build();
    }

    public static NexSecondaryTimelineItem fromProtoBuf(KMProto.KMProject.TimelineItem timelineItem) {
        EffectLayer effectLayer = new EffectLayer();
        effectLayer.setUniqueId(new UUID(timelineItem.unique_id_msb.longValue(), timelineItem.unique_id_lsb.longValue()));
        effectLayer.effectStrength = timelineItem.effect_layer.effect_strength.floatValue();
        effectLayer.effectVariation = timelineItem.effect_layer.effect_variation.floatValue();
        effectLayer.effectId = timelineItem.effect_layer.effect_id;
        fromProtoBuf(timelineItem.effect_layer.layer_common, effectLayer);
        return effectLayer;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public boolean hasIntrinsicDuration() {
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getIntinsicDuration() {
        throw new UnsupportedOperationException();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void getBounds(Rect rect) {
        rect.left = (-getWidth()) / 2;
        rect.right = rect.left + getWidth();
        rect.top = (-getHeight()) / 2;
        rect.bottom = rect.top + getHeight();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean supportsSplitScreen() {
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.k
    public void setStrengthValue(float f) {
        this.effectStrength = f;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.k
    public float getStrengthValue() {
        return this.effectStrength;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.l
    public void setVariationValue(float f) {
        this.effectVariation = f;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.l
    public float getVariationhValue() {
        return this.effectVariation;
    }
}
