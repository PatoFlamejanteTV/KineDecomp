package com.nexstreaming.kinemaster.layer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorMatrix;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import com.google.protos.datapol.SemanticAnnotations;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.ui.projectedit.Bg;
import com.nexstreaming.kinemaster.ui.projectedit.Xg;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes.dex */
public class StickerLayer extends NexLayerItem {
    private transient int n;
    private transient int o;
    private transient boolean p;
    private transient c.d.b.h.a q;
    private transient ColorMatrix r;
    private transient NexLayerItem.c u;
    private transient float v;
    private boolean colorizeEnabled = false;
    private int colorizeColor = -8947849;
    private int stickerId = 0;
    private transient ArrayList<c.d.b.h.a> s = new ArrayList<>();
    private transient SparseArray<Bitmap> t = new SparseArray<>();
    private int[] effect_id_ = {-1, -1};
    private int[] current_blend_mode_ = {0, 0};

    private void f() {
        if (this.p) {
            return;
        }
        c.d.b.h.a sticker = getSticker();
        this.n = sticker.c();
        this.o = sticker.b();
        this.p = true;
    }

    public static NexSecondaryTimelineItem fromProtoBuf(KMProto.KMProject.TimelineItem timelineItem) {
        StickerLayer stickerLayer = new StickerLayer();
        stickerLayer.setUniqueId(new UUID(timelineItem.unique_id_msb.longValue(), timelineItem.unique_id_lsb.longValue()));
        stickerLayer.colorizeColor = timelineItem.sticker_layer.colorize_color.intValue();
        stickerLayer.stickerId = timelineItem.sticker_layer.sticker_id.intValue();
        stickerLayer.colorizeEnabled = timelineItem.sticker_layer.colorize_enabled.booleanValue();
        NexLayerItem.fromProtoBuf(timelineItem.sticker_layer.layer_common, stickerLayer);
        Integer num = timelineItem.track_id;
        stickerLayer.track_id = num != null ? num.intValue() : 0;
        return stickerLayer;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public KMProto.KMProject.TimelineItem asProtoBuf() {
        KMProto.KMProject.StickerLayer.Builder builder = new KMProto.KMProject.StickerLayer.Builder();
        builder.colorize_color = Integer.valueOf(this.colorizeColor);
        builder.colorize_enabled = Boolean.valueOf(this.colorizeEnabled);
        builder.sticker_id = Integer.valueOf(this.stickerId);
        builder.layer_common = getLayerCommonProtoBuf();
        return new KMProto.KMProject.TimelineItem.Builder().clip_type(KMProto.KMProject.ClipType.LAYER_STICKER).unique_id_lsb(Long.valueOf(getUniqueId().getLeastSignificantBits())).unique_id_msb(Long.valueOf(getUniqueId().getMostSignificantBits())).sticker_layer(builder.build()).track_id(Integer.valueOf(this.track_id)).build();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getBGColor() {
        return R.color.layer_sticker;
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
        if (i == R.id.opt_colorize_color) {
            return getColorizeColor();
        }
        return super.getColorOption(i);
    }

    public int getColorizeColor() {
        return this.colorizeColor;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveTitle(Context context) {
        context.getResources().getString(R.string.layer_menu_overlay);
        return context.getResources().getString(R.string.layer_menu_sticker);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getHeight() {
        f();
        return this.o;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getIcon() {
        return R.drawable.layericon_sticker;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getIntinsicDuration() {
        throw new UnsupportedOperationException();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected String getLabelText(Context context) {
        context.getResources().getString(R.string.layer_menu_overlay);
        return context.getString(R.string.layer_menu_sticker);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Class<? extends Bg> getOptionMenuClass() {
        return Xg.class;
    }

    public c.d.b.h.a getSticker() {
        if (this.q == null) {
            this.q = c.d.b.h.a.a(this.stickerId);
        }
        return this.q;
    }

    public Bitmap getStickerBitmap(int i) {
        if (this.q.i()) {
            if (this.u == null) {
                this.u = new NexLayerItem.c();
            }
            getScaleRange(this.u);
            float max = SemanticAnnotations.SemanticType.ST_THIRD_PARTY_DATA_VALUE / Math.max(this.n, this.o);
            NexLayerItem.c cVar = this.u;
            float min = Math.min(Math.min(cVar.f20240c * 2.0f, cVar.f20239b), max);
            if (this.v == 0.0f || Math.abs(r1 - min) > 1.0E-5d) {
                this.v = min;
                this.t.clear();
            }
        }
        Bitmap bitmap = this.t.get(i);
        if (bitmap != null) {
            return bitmap;
        }
        Bitmap a2 = this.q.a(KineMasterApplication.f24056d.getApplicationContext(), this.v);
        this.t.put(i, a2);
        return a2;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa.b
    public boolean getSwitchOption(int i) {
        if (i == R.id.opt_colorize_color) {
            return isColorizeEnabled();
        }
        return super.getSwitchOption(i);
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

    public boolean isColorizeEnabled() {
        return this.colorizeEnabled;
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
        int i;
        NexEditor i2;
        c.d.b.h.a sticker = getSticker();
        if (sticker == null) {
            return;
        }
        Context applicationContext = KineMasterApplication.f24056d.getApplicationContext();
        if (sticker.h()) {
            int f2 = layerRenderer.f() - getAbsStartTime();
            int c2 = sticker.c(applicationContext);
            int i3 = f2 % c2;
            sticker.a(applicationContext, i3);
            i = sticker.g();
            Log.d("StickerLayer", "Sticker id=" + sticker.e() + " elapsed=" + f2 + " duration=" + c2 + " cycle=" + i3 + " time=" + i);
        } else {
            i = 0;
        }
        Bitmap stickerBitmap = getStickerBitmap(i);
        layerRenderer.x();
        if (isColorizeEnabled()) {
            if (this.r == null) {
                this.r = c.d.a.a.e.a.a(0.0f, 0.0f, -1.0f, this.colorizeColor);
            }
            layerRenderer.a(this.r);
        }
        int ordinal = getBlendMode().ordinal();
        if (ordinal > 0) {
            if (this.current_blend_mode_[layerRenderer.l().id] != ordinal) {
                if (this.effect_id_[layerRenderer.l().id] >= 0) {
                    EditorGlobal.i().d(this.effect_id_[layerRenderer.l().id], layerRenderer.l().id);
                }
                this.effect_id_[layerRenderer.l().id] = -1;
                this.current_blend_mode_[layerRenderer.l().id] = 0;
            }
            if (this.effect_id_[layerRenderer.l().id] < 0 && (i2 = EditorGlobal.i()) != null) {
                this.effect_id_[layerRenderer.l().id] = i2.a(String.format(Locale.US, "com.nexstreaming.editor.blend_%02d", Integer.valueOf(ordinal)), layerRenderer.l().id);
                this.current_blend_mode_[layerRenderer.l().id] = ordinal;
            }
        }
        if (this.effect_id_[layerRenderer.l().id] >= 0 && ordinal > 0) {
            layerRenderer.a(this.effect_id_[layerRenderer.l().id], stickerBitmap, "", layerRenderer.f(), 0, 1000, 0.0f, 0.0f, layerRenderer.d(), layerRenderer.i());
        } else {
            layerRenderer.a(stickerBitmap, (-r2) / 2.0f, (-r4) / 2.0f, this.n / 2.0f, this.o / 2.0f);
        }
        layerRenderer.w();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAsleep(LayerRenderer layerRenderer) {
        this.t.clear();
        c.d.b.h.a sticker = getSticker();
        if (sticker != null) {
            sticker.a();
        }
        NexEditor i = EditorGlobal.i();
        if (i == null || this.effect_id_[layerRenderer.l().id] < 0) {
            return;
        }
        i.d(this.effect_id_[layerRenderer.l().id], layerRenderer.l().id);
        this.effect_id_[layerRenderer.l().id] = -1;
        this.current_blend_mode_[layerRenderer.l().id] = 0;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAwake(LayerRenderer layerRenderer) {
        f();
        getStickerBitmap(0);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa.a
    public void setColorOption(int i, int i2) {
        if (i == R.id.opt_colorize_color) {
            setColorizeColor(i2);
        } else {
            super.setColorOption(i, i2);
            throw null;
        }
    }

    public void setColorizeColor(int i) {
        this.colorizeColor = i;
        this.r = null;
    }

    public void setColorizeEnabled(boolean z) {
        this.colorizeEnabled = z;
    }

    public void setSticker(c.d.b.h.a aVar) {
        if (aVar == null) {
            this.q = null;
            this.stickerId = 0;
            this.n = 0;
            this.o = 0;
            this.p = true;
        } else if (aVar.e() != this.stickerId) {
            this.q = aVar;
            this.stickerId = aVar.e();
            this.p = false;
            f();
        }
        this.t.clear();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Task setSwitchOption(int i, boolean z, Context context) {
        if (i == R.id.opt_colorize_color) {
            setColorizeEnabled(z);
            return null;
        }
        super.setSwitchOption(i, z, context);
        throw null;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean supportsSplitScreen() {
        return false;
    }

    public c.d.b.h.a getSticker(int i) {
        return this.s.get(i);
    }
}
