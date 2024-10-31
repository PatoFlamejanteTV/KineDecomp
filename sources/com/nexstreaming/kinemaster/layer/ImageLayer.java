package com.nexstreaming.kinemaster.layer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.ui.projectedit.ay;
import com.nexstreaming.kinemaster.ui.projectedit.bo;
import com.nexstreaming.kinemaster.ui.projectedit.kp;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.ColorEffect;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import com.nextreaming.nexvideoeditor.NexImageLoader;
import java.io.File;
import java.util.UUID;

/* loaded from: classes.dex */
public class ImageLayer extends MediaLayer implements NexTimelineItem.e, NexTimelineItem.f, NexTimelineItem.g {

    /* renamed from: a */
    private transient int f3472a;
    private transient int b;
    private transient boolean c;
    private transient Bitmap d;
    private transient Bitmap e;
    private String filePath;
    private int m_Brightness;
    private int m_Contrast;
    private int m_Saturation;
    private ColorEffect m_colorEffect;
    private boolean m_lut;
    private boolean m_mask;
    private boolean m_needsRedraw;

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAwake(LayerRenderer layerRenderer) {
        a();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null) {
            layerRenderer.b(imageBitmap);
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAsleep(LayerRenderer layerRenderer) {
        this.d = null;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRender(LayerRenderer layerRenderer, NexLayerItem.b bVar) {
        Bitmap imageBitmap;
        if (this.d != null && (imageBitmap = getImageBitmap()) != null) {
            layerRenderer.l();
            if (this.m_lut) {
                layerRenderer.b(imageBitmap, 0.0f, 0.0f);
            } else if (this.m_mask) {
                layerRenderer.a(com.nexstreaming.app.general.c.a.a(getCombinedBrightness() / 255.0f, getCombinedContrast() / 255.0f, getCombinedSaturation() / 255.0f, this.m_colorEffect != null ? this.m_colorEffect.getTintColor() : 0));
                layerRenderer.a(LayerRenderer.RenderTarget.Mask);
                layerRenderer.a(imageBitmap, 0.0f, 0.0f);
                layerRenderer.a(LayerRenderer.RenderTarget.Normal);
                layerRenderer.a(true);
            } else {
                if (this.m_colorEffect != null) {
                    layerRenderer.a(this.m_colorEffect.getLut());
                }
                layerRenderer.a(com.nexstreaming.app.general.c.a.a(getCombinedBrightness() / 255.0f, getCombinedContrast() / 255.0f, getCombinedSaturation() / 255.0f, this.m_colorEffect != null ? this.m_colorEffect.getTintColor() : 0));
                layerRenderer.a(imageBitmap, 0.0f, 0.0f);
            }
            layerRenderer.a((Bitmap) null);
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
    public void getBounds(Rect rect) {
        rect.left = (-getWidth()) / 2;
        rect.right = rect.left + getWidth();
        rect.top = (-getHeight()) / 2;
        rect.bottom = rect.top + getHeight();
    }

    public Bitmap getThumbnailBitmap() {
        Bitmap a2;
        if (this.e == null && this.filePath != null) {
            if (this.filePath.startsWith("@solid:") && this.filePath.endsWith(".jpg")) {
                int parseLong = (int) Long.parseLong(this.filePath.substring(7, 15), 16);
                a2 = Bitmap.createBitmap(320, 180, Bitmap.Config.ARGB_8888);
                new Canvas(a2).drawColor(parseLong);
            } else {
                a2 = NexImageLoader.loadBitmap(this.filePath, 320, 180).a();
            }
            this.e = a2;
        }
        return this.e;
    }

    public Bitmap getImageBitmap() {
        Bitmap a2;
        if (this.d == null && this.filePath != null) {
            if (this.filePath.startsWith("@solid:") && this.filePath.endsWith(".jpg")) {
                int parseLong = (int) Long.parseLong(this.filePath.substring(7, 15), 16);
                a2 = Bitmap.createBitmap(320, 180, Bitmap.Config.ARGB_8888);
                new Canvas(a2).drawColor(parseLong);
            } else {
                a2 = NexImageLoader.loadBitmap(this.filePath, 1920, 1080).a();
            }
            this.d = a2;
        }
        return this.d;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected String getLabelText(Context context) {
        return (this.filePath.startsWith("@solid:") && this.filePath.endsWith(".jpg")) ? context.getResources().getString(R.string.solid_color_clip) : new File(this.filePath).getName();
    }

    private void a() {
        if (!this.c) {
            Bitmap imageBitmap = getImageBitmap();
            if (imageBitmap != null) {
                this.f3472a = imageBitmap.getWidth();
                this.b = imageBitmap.getHeight();
            }
            this.c = true;
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveTitle(Context context) {
        return this.filePath == null ? "" : new File(this.filePath).getName();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveSubtitle(Context context) {
        return this.f3472a + "×" + this.b;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getBGColor() {
        return R.color.layer_text;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getIcon() {
        return R.drawable.layericon_image;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected boolean drawThumbnails(ay ayVar, Canvas canvas, RectF rectF) {
        Bitmap thumbnailBitmap = getThumbnailBitmap();
        if (thumbnailBitmap == null) {
            return false;
        }
        int width = thumbnailBitmap.getWidth();
        int height = thumbnailBitmap.getHeight();
        float height2 = rectF.height();
        rectF.top -= height2 / 2.0f;
        rectF.bottom = (height2 / 2.0f) + rectF.bottom;
        int max = (int) Math.max(1.0f, ((width * rectF.height()) / height) + 0.5f);
        int i = (int) (rectF.right + max + 1.0f);
        canvas.save();
        canvas.clipRect(rectF);
        for (int i2 = (int) rectF.left; i2 < i; i2 += max) {
            rectF.left = i2;
            rectF.right = i2 + max;
            canvas.drawBitmap(thumbnailBitmap, (Rect) null, rectF, (Paint) null);
        }
        canvas.restore();
        return true;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getWidth() {
        a();
        return this.f3472a;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getHeight() {
        a();
        return this.b;
    }

    public void setMediaPath(String str, Context context) {
        this.filePath = str;
        this.d = null;
        this.e = null;
        this.c = false;
        this.m_needsRedraw = true;
        this.m_lut = false;
        this.m_mask = false;
        a();
    }

    public boolean needsRedrawBitmap() {
        return this.m_needsRedraw;
    }

    public void setNeedsRedraw(boolean z) {
        this.m_needsRedraw = z;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public KMProto.KMProject.TimelineItem asProtoBuf() {
        KMProto.KMProject.ImageLayer.Builder builder = new KMProto.KMProject.ImageLayer.Builder();
        builder.brightness = Integer.valueOf(this.m_Brightness);
        builder.contrast = Integer.valueOf(this.m_Contrast);
        builder.saturation = Integer.valueOf(this.m_Saturation);
        builder.color_effect = this.m_colorEffect == null ? null : this.m_colorEffect.asProtoBuf();
        builder.image_path = this.filePath;
        builder.layer_common = getLayerCommonProtoBuf();
        return new KMProto.KMProject.TimelineItem.Builder().clip_type(KMProto.KMProject.ClipType.LAYER_IMAGE).unique_id_lsb(Long.valueOf(getUniqueId().getLeastSignificantBits())).unique_id_msb(Long.valueOf(getUniqueId().getMostSignificantBits())).image_layer(builder.build()).build();
    }

    public static NexSecondaryTimelineItem fromProtoBuf(KMProto.KMProject.TimelineItem timelineItem) {
        ImageLayer imageLayer = new ImageLayer();
        imageLayer.setUniqueId(new UUID(timelineItem.unique_id_msb.longValue(), timelineItem.unique_id_lsb.longValue()));
        imageLayer.m_Brightness = timelineItem.image_layer.brightness.intValue();
        imageLayer.m_Contrast = timelineItem.image_layer.contrast.intValue();
        imageLayer.m_Saturation = timelineItem.image_layer.saturation.intValue();
        imageLayer.m_colorEffect = ColorEffect.fromProtoBuf(timelineItem.image_layer.color_effect);
        imageLayer.filePath = timelineItem.image_layer.image_path;
        imageLayer.setMediaPath(timelineItem.image_layer.image_path, null);
        fromProtoBuf(timelineItem.image_layer.layer_common, imageLayer);
        return imageLayer;
    }

    public boolean isSolid() {
        return this.filePath != null && this.filePath.startsWith("@solid:") && this.filePath.endsWith(".jpg");
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public boolean hasIntrinsicDuration() {
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getIntinsicDuration() {
        throw new UnsupportedOperationException();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Class<? extends kp> getOptionMenuClass() {
        return bo.class;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public void setBrightness(int i) {
        this.m_Brightness = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public void setContrast(int i) {
        this.m_Contrast = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public void setSaturation(int i) {
        this.m_Saturation = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public int getBrightness() {
        return this.m_Brightness;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public int getContrast() {
        return this.m_Contrast;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public int getSaturation() {
        return this.m_Saturation;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.f
    public int getCombinedBrightness() {
        return this.m_colorEffect == null ? this.m_Brightness : this.m_Brightness + ((int) (255.0f * this.m_colorEffect.getBrightness()));
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.f
    public int getCombinedContrast() {
        return this.m_colorEffect == null ? this.m_Contrast : this.m_Contrast + ((int) (255.0f * this.m_colorEffect.getContrast()));
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.f
    public int getCombinedSaturation() {
        return this.m_colorEffect == null ? this.m_Saturation : this.m_Saturation + ((int) (255.0f * this.m_colorEffect.getSaturation()));
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.g
    public void setColorEffect(ColorEffect colorEffect) {
        this.m_colorEffect = colorEffect;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.g
    public ColorEffect getColorEffect() {
        return this.m_colorEffect;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean checkResourceState(Context context) {
        return (this.filePath.startsWith("@solid:") && this.filePath.endsWith(".jpg")) || new File(this.filePath).exists();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean supportsSplitScreen() {
        return true;
    }

    @Override // com.nexstreaming.kinemaster.layer.MediaLayer
    public String getMediaPath() {
        return this.filePath;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void setColorOption(int i, int i2) {
        if (i == R.id.opt_color) {
            a(i2);
        } else {
            super.setColorOption(i, i2);
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getColorOption(int i) {
        return i == R.id.opt_color ? getSolidColor() : super.getColorOption(i);
    }

    private void a(int i) {
        if (isSolid()) {
            this.filePath = String.format("@solid:%08X.jpg", Integer.valueOf(i));
            this.e = null;
        }
    }

    public int getSolidColor() {
        if (!isSolid()) {
            return 0;
        }
        return (int) Long.parseLong(this.filePath.substring(7, 15), 16);
    }
}
