package com.nexstreaming.kinemaster.layer;

import android.content.Context;
import android.graphics.Rect;
import android.opengl.GLES20;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.ui.projectedit.Aa;
import com.nexstreaming.kinemaster.ui.projectedit.Bg;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import java.util.UUID;

/* loaded from: classes.dex */
public class EffectLayer extends NexLayerItem implements NexTimelineItem.m, NexTimelineItem.n {
    private String effectId;
    private transient int n;
    private transient int o;
    private transient boolean p;
    private float effectStrength = 0.5f;
    private float effectVariation = 0.5f;
    private NexLayerItem.b scratchKF = new NexLayerItem.b();
    private LayerRenderer.g mEffectTexture = null;

    private void f() {
        if (this.p) {
            return;
        }
        this.n = 100;
        this.o = 100;
        this.p = true;
    }

    public static NexSecondaryTimelineItem fromProtoBuf(KMProto.KMProject.TimelineItem timelineItem) {
        EffectLayer effectLayer = new EffectLayer();
        effectLayer.setUniqueId(new UUID(timelineItem.unique_id_msb.longValue(), timelineItem.unique_id_lsb.longValue()));
        effectLayer.effectStrength = timelineItem.effect_layer.effect_strength.floatValue();
        effectLayer.effectVariation = timelineItem.effect_layer.effect_variation.floatValue();
        KMProto.KMProject.EffectLayer effectLayer2 = timelineItem.effect_layer;
        effectLayer.effectId = effectLayer2.effect_id;
        NexLayerItem.fromProtoBuf(effectLayer2.layer_common, effectLayer);
        Integer num = timelineItem.track_id;
        effectLayer.track_id = num != null ? num.intValue() : 0;
        return effectLayer;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public KMProto.KMProject.TimelineItem asProtoBuf() {
        KMProto.KMProject.EffectLayer.Builder builder = new KMProto.KMProject.EffectLayer.Builder();
        builder.effect_id = this.effectId;
        builder.effect_strength = Float.valueOf(this.effectStrength);
        builder.effect_variation = Float.valueOf(this.effectVariation);
        builder.layer_common = getLayerCommonProtoBuf();
        return new KMProto.KMProject.TimelineItem.Builder().clip_type(KMProto.KMProject.ClipType.LAYER_EFFECT).unique_id_lsb(Long.valueOf(getUniqueId().getLeastSignificantBits())).unique_id_msb(Long.valueOf(getUniqueId().getMostSignificantBits())).effect_layer(builder.build()).track_id(Integer.valueOf(this.track_id)).build();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getBGColor() {
        return R.color.layer_effect;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void getBounds(Rect rect) {
        rect.left = (-getWidth()) / 2;
        rect.right = rect.left + getWidth();
        rect.top = (-getHeight()) / 2;
        rect.bottom = rect.top + getHeight();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa.a
    public int getColorOption(int i) {
        return super.getColorOption(i);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveTitle(Context context) {
        return context.getResources().getString(R.string.layer_menu_effect);
    }

    public String getEffectId() {
        return this.effectId;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getHeight() {
        f();
        return this.o;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getIcon() {
        return R.drawable.opt_clip_effect;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getIntinsicDuration() {
        throw new UnsupportedOperationException();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected String getLabelText(Context context) {
        return context.getString(R.string.layer_menu_effect);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Class<? extends Bg> getOptionMenuClass() {
        return Aa.class;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.m
    public float getStrengthValue() {
        return this.effectStrength;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa.b
    public boolean getSwitchOption(int i) {
        return super.getSwitchOption(i);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.n
    public float getVariationhValue() {
        return this.effectVariation;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getWidth() {
        f();
        return this.n;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public boolean hasIntrinsicDuration() {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem, com.nextreaming.nexeditorui.NexTimelineItem
    public boolean isOptionApplied(int i) {
        if (i != R.id.opt_rotate) {
            return super.isOptionApplied(i);
        }
        return getRotation() != 0 || getFlipH() || getFlipV();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean isTransformedPointInLayerAtTime(float f2, float f3, int i) {
        int i2 = (-getWidth()) / 2;
        int width = getWidth() + i2;
        int i3 = (-getHeight()) / 2;
        return f2 >= ((float) i2) && f2 <= ((float) width) && f3 >= ((float) i3) && f3 <= ((float) (getHeight() + i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRender(LayerRenderer layerRenderer, NexLayerItem.b bVar, boolean z) {
        KineMasterApplication.f24056d.getApplicationContext();
        int i = this.n;
        float f2 = (-i) / 2;
        float f3 = f2 + i;
        int i2 = this.o;
        float f4 = (-i2) / 2;
        float f5 = f4 + i2;
        layerRenderer.n();
        layerRenderer.m();
        float f6 = bVar.f20231b;
        int i3 = this.n;
        int i4 = this.o;
        float f7 = bVar.f20232c;
        float f8 = bVar.f20233d;
        layerRenderer.x();
        GLES20.glEnable(2960);
        GLES20.glStencilFunc(519, 1, 255);
        GLES20.glStencilOp(7681, 7681, 7681);
        GLES20.glColorMask(false, false, false, false);
        GLES20.glStencilMask(255);
        GLES20.glClear(1024);
        layerRenderer.c(-1, f2, f4, f3, f5);
        GLES20.glColorMask(true, true, true, true);
        GLES20.glStencilFunc(514, 1, 255);
        GLES20.glStencilMask(0);
        this.mEffectTexture = layerRenderer.a(this.mEffectTexture, 0.0f, 0.0f, layerRenderer.n(), layerRenderer.m());
        layerRenderer.u();
        layerRenderer.d(this.mEffectTexture.c());
        layerRenderer.c(this.mEffectTexture.a());
        if (getEffectId().equals("Blur")) {
            layerRenderer.a(true);
            layerRenderer.g(false);
            layerRenderer.b(getStrengthValue());
        } else {
            layerRenderer.a(false);
        }
        if (getEffectId().equals("Mosaic")) {
            layerRenderer.e(true);
            layerRenderer.b(getStrengthValue());
        } else {
            layerRenderer.e(false);
        }
        layerRenderer.b(this.mEffectTexture.b(), 640.0f, 360.0f, 1280.0f, 720.0f);
        if (getEffectId().equals("Blur")) {
            layerRenderer.a(false);
            layerRenderer.g(true);
            this.mEffectTexture = layerRenderer.a(this.mEffectTexture, 0.0f, 0.0f, layerRenderer.n(), layerRenderer.m());
            layerRenderer.b(this.mEffectTexture.b(), 640.0f, 360.0f, 1280.0f, 720.0f);
        }
        GLES20.glDisable(2960);
        layerRenderer.w();
        layerRenderer.g(false);
        layerRenderer.a(false);
        layerRenderer.e(false);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAsleep(LayerRenderer layerRenderer) {
        releaseTexture();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAwake(LayerRenderer layerRenderer) {
        f();
    }

    public void releaseTexture() {
        this.mEffectTexture = null;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa.a
    public void setColorOption(int i, int i2) {
        super.setColorOption(i, i2);
        throw null;
    }

    public void setEffectId(String str) {
        this.effectId = str;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.m
    public void setStrengthValue(float f2) {
        this.effectStrength = f2;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Task setSwitchOption(int i, boolean z, Context context) {
        super.setSwitchOption(i, z, context);
        throw null;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.n
    public void setVariationValue(float f2) {
        this.effectVariation = f2;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean supportsSplitScreen() {
        return false;
    }
}
