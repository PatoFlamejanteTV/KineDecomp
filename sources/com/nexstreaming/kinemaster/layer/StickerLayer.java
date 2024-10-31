package com.nexstreaming.kinemaster.layer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorMatrix;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.ui.projectedit.kp;
import com.nexstreaming.kinemaster.ui.projectedit.kx;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import java.util.ArrayList;
import java.util.UUID;

/* loaded from: classes.dex */
public class StickerLayer extends NexLayerItem {

    /* renamed from: a */
    private transient int f3473a;
    private transient int b;
    private transient boolean c;
    private transient com.nexstreaming.kinemaster.e.a d;
    private transient ColorMatrix e;
    private transient NexLayerItem.c h;
    private transient float i;
    private boolean colorizeEnabled = false;
    private int colorizeColor = -8947849;
    private int stickerId = 0;
    private transient ArrayList<com.nexstreaming.kinemaster.e.a> f = new ArrayList<>();
    private transient SparseArray<Bitmap> g = new SparseArray<>();

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAwake(LayerRenderer layerRenderer) {
        a();
        getStickerBitmap(0);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAsleep(LayerRenderer layerRenderer) {
        this.g.clear();
        com.nexstreaming.kinemaster.e.a sticker = getSticker();
        if (sticker != null) {
            sticker.i();
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRender(LayerRenderer layerRenderer, NexLayerItem.b bVar) {
        com.nexstreaming.kinemaster.e.a sticker = getSticker();
        if (sticker != null) {
            Context applicationContext = KineMasterApplication.a().getApplicationContext();
            int i = 0;
            if (sticker.c()) {
                int j = layerRenderer.j() - getAbsStartTime();
                int a2 = sticker.a(applicationContext);
                int i2 = j % a2;
                sticker.a(applicationContext, i2);
                i = sticker.d();
                Log.d("StickerLayer", "Sticker id=" + sticker.a() + " elapsed=" + j + " duration=" + a2 + " cycle=" + i2 + " time=" + i);
            }
            Bitmap stickerBitmap = getStickerBitmap(i);
            layerRenderer.l();
            if (isColorizeEnabled()) {
                if (this.e == null) {
                    this.e = com.nexstreaming.app.general.c.a.a(0.0f, 0.0f, -1.0f, this.colorizeColor);
                }
                layerRenderer.a(this.e);
            }
            layerRenderer.a(stickerBitmap, (-this.f3473a) / 2.0f, (-this.b) / 2.0f, this.f3473a / 2.0f, this.b / 2.0f);
            layerRenderer.m();
        }
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
        return context.getString(R.string.layer_menu_sticker);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveTitle(Context context) {
        return context.getResources().getString(R.string.layer_menu_sticker);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getBGColor() {
        return R.color.layer_sticker;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getIcon() {
        return R.drawable.layericon_sticker;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Class<? extends kp> getOptionMenuClass() {
        return kx.class;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean getSwitchOption(int i) {
        return i == R.id.opt_colorize_color ? isColorizeEnabled() : super.getSwitchOption(i);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Task setSwitchOption(int i, boolean z, Context context) {
        if (i == R.id.opt_colorize_color) {
            setColorizeEnabled(z);
            return null;
        }
        super.setSwitchOption(i, z, context);
        return null;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getColorOption(int i) {
        return i == R.id.opt_colorize_color ? getColorizeColor() : super.getColorOption(i);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void setColorOption(int i, int i2) {
        if (i == R.id.opt_colorize_color) {
            setColorizeColor(i2);
        } else {
            super.setColorOption(i, i2);
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getWidth() {
        a();
        return this.f3473a;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getHeight() {
        a();
        return this.b;
    }

    public com.nexstreaming.kinemaster.e.a getSticker() {
        if (this.d == null) {
            this.d = com.nexstreaming.kinemaster.e.a.a(this.stickerId);
        }
        return this.d;
    }

    public com.nexstreaming.kinemaster.e.a getSticker(int i) {
        return this.f.get(i);
    }

    public int getColorizeColor() {
        return this.colorizeColor;
    }

    public void setColorizeColor(int i) {
        this.colorizeColor = i;
        this.e = null;
    }

    public boolean isColorizeEnabled() {
        return this.colorizeEnabled;
    }

    public void setColorizeEnabled(boolean z) {
        this.colorizeEnabled = z;
    }

    public void setSticker(com.nexstreaming.kinemaster.e.a aVar) {
        if (aVar == null) {
            this.d = null;
            this.stickerId = 0;
            this.f3473a = 0;
            this.b = 0;
            this.c = true;
        } else if (aVar.a() != this.stickerId) {
            this.d = aVar;
            this.stickerId = aVar.a();
            this.c = false;
            a();
        }
        this.g.clear();
    }

    private void a() {
        if (!this.c) {
            com.nexstreaming.kinemaster.e.a sticker = getSticker();
            this.f3473a = sticker.e();
            this.b = sticker.f();
            this.c = true;
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public KMProto.KMProject.TimelineItem asProtoBuf() {
        KMProto.KMProject.StickerLayer.Builder builder = new KMProto.KMProject.StickerLayer.Builder();
        builder.colorize_color = Integer.valueOf(this.colorizeColor);
        builder.colorize_enabled = Boolean.valueOf(this.colorizeEnabled);
        builder.sticker_id = Integer.valueOf(this.stickerId);
        builder.layer_common = getLayerCommonProtoBuf();
        return new KMProto.KMProject.TimelineItem.Builder().clip_type(KMProto.KMProject.ClipType.LAYER_STICKER).unique_id_lsb(Long.valueOf(getUniqueId().getLeastSignificantBits())).unique_id_msb(Long.valueOf(getUniqueId().getMostSignificantBits())).sticker_layer(builder.build()).build();
    }

    public static NexSecondaryTimelineItem fromProtoBuf(KMProto.KMProject.TimelineItem timelineItem) {
        StickerLayer stickerLayer = new StickerLayer();
        stickerLayer.setUniqueId(new UUID(timelineItem.unique_id_msb.longValue(), timelineItem.unique_id_lsb.longValue()));
        stickerLayer.colorizeColor = timelineItem.sticker_layer.colorize_color.intValue();
        stickerLayer.stickerId = timelineItem.sticker_layer.sticker_id.intValue();
        stickerLayer.colorizeEnabled = timelineItem.sticker_layer.colorize_enabled.booleanValue();
        fromProtoBuf(timelineItem.sticker_layer.layer_common, stickerLayer);
        return stickerLayer;
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

    public Bitmap getStickerBitmap(int i) {
        if (this.d.h()) {
            if (this.h == null) {
                this.h = new NexLayerItem.c();
            }
            getScaleRange(this.h);
            float min = Math.min(Math.min(this.h.c * 2.0f, this.h.b), 2000 / Math.max(this.f3473a, this.b));
            if (this.i == 0.0f || Math.abs(this.i - min) > 1.0E-5d) {
                this.i = min;
                this.g.clear();
            }
        }
        Bitmap bitmap = this.g.get(i);
        if (bitmap == null) {
            Bitmap a2 = this.d.a(KineMasterApplication.a().getApplicationContext(), this.i);
            this.g.put(i, a2);
            return a2;
        }
        return bitmap;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean supportsSplitScreen() {
        return false;
    }
}
