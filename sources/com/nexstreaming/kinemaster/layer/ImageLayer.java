package com.nexstreaming.kinemaster.layer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.nexstreaming.app.general.util.FileType;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.handwriting.Stroke;
import com.nexstreaming.kinemaster.mediastore.provider.s;
import com.nexstreaming.kinemaster.ui.projectedit.Bg;
import com.nexstreaming.kinemaster.ui.projectedit.C1916ib;
import com.nexstreaming.kinemaster.ui.projectedit.Mb;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2028i;
import com.nexstreaming.kinemaster.ui.widget.ClipThumbView;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.ColorEffect;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.nextreaming.nexvideoeditor.NexImageLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes.dex */
public class ImageLayer extends MediaLayer implements NexTimelineItem.f, NexTimelineItem.h, NexTimelineItem.g, NexTimelineItem.j {
    private String filePath;
    private int m_Brightness;
    private int m_Contrast;
    private int m_Saturation;
    private ColorEffect m_colorEffect;
    private boolean m_lut;
    private boolean m_mask;
    private boolean m_needsRedraw;
    private transient int n;
    private transient int o;
    private transient boolean p;
    private transient Bitmap q;
    private transient Bitmap r;
    private List<com.nexstreaming.kinemaster.layer.handwriting.b> customMaskDrawingActionList = new ArrayList();
    private int[] effect_id_ = {-1, -1};
    private int[] current_blend_mode_ = {0, 0};

    private void f() {
        if (this.p) {
            return;
        }
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null) {
            this.n = imageBitmap.getWidth();
            this.o = imageBitmap.getHeight();
        }
        this.p = true;
    }

    public static NexSecondaryTimelineItem fromProtoBuf(KMProto.KMProject.TimelineItem timelineItem) {
        ImageLayer imageLayer = new ImageLayer();
        imageLayer.setUniqueId(new UUID(timelineItem.unique_id_msb.longValue(), timelineItem.unique_id_lsb.longValue()));
        imageLayer.m_Brightness = timelineItem.image_layer.brightness.intValue();
        imageLayer.m_Contrast = timelineItem.image_layer.contrast.intValue();
        imageLayer.m_Saturation = timelineItem.image_layer.saturation.intValue();
        imageLayer.m_colorEffect = ColorEffect.fromProtoBuf(timelineItem.image_layer.color_effect);
        String str = timelineItem.image_layer.image_path;
        imageLayer.filePath = str;
        imageLayer.setMediaPath(str, null);
        NexLayerItem.fromProtoBuf(timelineItem.image_layer.layer_common, imageLayer);
        Integer num = timelineItem.track_id;
        imageLayer.track_id = num != null ? num.intValue() : 0;
        return imageLayer;
    }

    public static ImageLayer fromVideoClipItem(NexVideoClipItem nexVideoClipItem) {
        ImageLayer imageLayer = new ImageLayer();
        imageLayer.m_Brightness = nexVideoClipItem.getBrightness();
        imageLayer.m_Contrast = nexVideoClipItem.getContrast();
        imageLayer.m_Saturation = nexVideoClipItem.getSaturation();
        imageLayer.m_colorEffect = nexVideoClipItem.getColorEffect();
        imageLayer.filePath = nexVideoClipItem.getMediaPath();
        imageLayer.setMediaPath(nexVideoClipItem.getMediaPath(), null);
        if (nexVideoClipItem.getRotation() != 90 && nexVideoClipItem.getRotation() != 270) {
            imageLayer.setFlipH(nexVideoClipItem.getFlipH());
            imageLayer.setFlipV(nexVideoClipItem.getFlipV());
        } else {
            imageLayer.setFlipH(nexVideoClipItem.getFlipV());
            imageLayer.setFlipV(nexVideoClipItem.getFlipH());
        }
        imageLayer.setSplitScreenType(c.d.b.l.a.f3846a.a());
        if (imageLayer.getSplitScreenType() != SplitScreenType.OFF) {
            imageLayer.fitKeyframeToSplitscreenRect(imageLayer.getSplitScreenKeyframe());
        }
        return imageLayer;
    }

    private void setSolidColor(int i) {
        if (isSolid()) {
            this.filePath = String.format("@solid:%08X.jpg", Integer.valueOf(i));
            this.r = null;
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.j
    public void addCMDrawingAction(com.nexstreaming.kinemaster.layer.handwriting.b bVar) {
        setUseCustomMask(true);
        this.customMaskDrawingActionList.add(bVar);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.j
    public void addCMEraseAll() {
        if (!this.customMaskDrawingActionList.isEmpty()) {
            if (this.customMaskDrawingActionList.get(r0.size() - 1) instanceof com.nexstreaming.kinemaster.layer.handwriting.c) {
                return;
            }
        }
        this.customMaskDrawingActionList.add(new com.nexstreaming.kinemaster.layer.handwriting.c());
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.j
    public void addCMStroke(Stroke stroke) {
        setUseCustomMask(true);
        this.customMaskDrawingActionList.add(new Stroke(stroke));
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public KMProto.KMProject.TimelineItem asProtoBuf() {
        KMProto.KMProject.ImageLayer.Builder builder = new KMProto.KMProject.ImageLayer.Builder();
        builder.brightness = Integer.valueOf(this.m_Brightness);
        builder.contrast = Integer.valueOf(this.m_Contrast);
        builder.saturation = Integer.valueOf(this.m_Saturation);
        ColorEffect colorEffect = this.m_colorEffect;
        builder.color_effect = colorEffect == null ? null : colorEffect.asProtoBuf();
        builder.image_path = this.filePath;
        builder.layer_common = getLayerCommonProtoBuf();
        return new KMProto.KMProject.TimelineItem.Builder().clip_type(KMProto.KMProject.ClipType.LAYER_IMAGE).unique_id_lsb(Long.valueOf(getUniqueId().getLeastSignificantBits())).unique_id_msb(Long.valueOf(getUniqueId().getMostSignificantBits())).image_layer(builder.build()).track_id(Integer.valueOf(this.track_id)).build();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem, com.nextreaming.nexeditorui.NexSecondaryTimelineItem, com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa
    public void bindView(View view, InterfaceC2028i interfaceC2028i) {
        super.bindView(view, interfaceC2028i);
        ClipThumbView clipThumbView = (ClipThumbView) view.findViewById(R.id.thumbnail_view);
        if (getRotation() <= 0) {
            Math.abs(getRotation());
        }
        if (!checkResourceState(view.getContext())) {
            clipThumbView.a(false);
            return;
        }
        if (clipThumbView.a() && this.filePath.equals(clipThumbView.getPath())) {
            clipThumbView.a(this);
            return;
        }
        clipThumbView.a(getSolidColor(), this.filePath, this);
        interfaceC2028i.d().a("small:" + this.filePath, clipThumbView, (Bitmap) null);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean checkResourceState(Context context) {
        return (this.filePath.startsWith("@solid:") && this.filePath.endsWith(".jpg")) || new File(this.filePath).exists();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void copyOptions(NexTimelineItem nexTimelineItem) {
        if (nexTimelineItem instanceof NexTimelineItem.f) {
            NexTimelineItem.f fVar = (NexTimelineItem.f) nexTimelineItem;
            this.m_Brightness = fVar.getBrightness();
            this.m_Contrast = fVar.getContrast();
            this.m_Saturation = fVar.getSaturation();
        }
        if (nexTimelineItem instanceof NexTimelineItem.h) {
            this.m_colorEffect = ((NexTimelineItem.h) nexTimelineItem).getColorEffect();
        }
        if (nexTimelineItem instanceof NexTimelineItem.t) {
            setSplitScreenType(((NexTimelineItem.t) nexTimelineItem).getSplitScreenType());
        }
        if (nexTimelineItem instanceof NexTimelineItem.o) {
            NexTimelineItem.o oVar = (NexTimelineItem.o) nexTimelineItem;
            setLayerMaskEnabled(oVar.isLayerMaskEnabled());
            setLayerMaskIndex(oVar.getLayerMaskIndex());
            setLayerMaskMode(oVar.getLayerMaskMode());
        }
        if (nexTimelineItem instanceof NexTimelineItem.s) {
            NexTimelineItem.s sVar = (NexTimelineItem.s) nexTimelineItem;
            setFlipV(sVar.getFlipV());
            setFlipH(sVar.getFlipH());
            setRotation(sVar.getRotation());
        }
        if (nexTimelineItem instanceof NexLayerItem) {
            NexLayerItem nexLayerItem = (NexLayerItem) nexTimelineItem;
            float duration = getDuration();
            int width = getWidth();
            float duration2 = nexLayerItem.getDuration();
            int width2 = nexLayerItem.getWidth();
            removeAllKeyframe();
            for (NexLayerItem.b bVar : nexLayerItem.getKeyFrames()) {
                float f2 = bVar.f20230a * duration2;
                if (f2 > duration) {
                    NexLayerItem.b interpolatedKeyframe = nexLayerItem.getInterpolatedKeyframe(duration / duration2);
                    NexLayerItem.b bVar2 = new NexLayerItem.b();
                    bVar2.f20230a = 1.0f;
                    bVar2.f20232c = interpolatedKeyframe.f20232c;
                    bVar2.f20233d = interpolatedKeyframe.f20233d;
                    bVar2.f20234e = interpolatedKeyframe.f20234e;
                    bVar2.f20231b = (width2 * interpolatedKeyframe.f20231b) / width;
                    float f3 = bVar2.f20231b;
                    bVar2.f20237h = f3;
                    bVar2.f20236g = f3;
                    addKeyframeWithoutCheck(bVar2);
                    return;
                }
                NexLayerItem.b bVar3 = new NexLayerItem.b();
                bVar3.f20230a = f2 / duration;
                bVar3.f20232c = bVar.f20232c;
                bVar3.f20233d = bVar.f20233d;
                bVar3.f20234e = bVar.f20234e;
                bVar3.f20231b = (width2 * bVar.f20231b) / width;
                float f4 = bVar3.f20231b;
                bVar3.f20237h = f4;
                bVar3.f20236g = f4;
                addKeyframeWithoutCheck(bVar3);
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected boolean drawThumbnails(C1916ib c1916ib, Canvas canvas, RectF rectF) {
        Bitmap thumbnailBitmap = getThumbnailBitmap();
        if (thumbnailBitmap == null) {
            return false;
        }
        int width = thumbnailBitmap.getWidth();
        int height = thumbnailBitmap.getHeight();
        float height2 = rectF.height() / 2.0f;
        rectF.top -= height2;
        rectF.bottom += height2;
        int max = (int) Math.max(1.0f, ((width * rectF.height()) / height) + 0.5f);
        int i = (int) rectF.left;
        int i2 = (int) (rectF.right + max + 1.0f);
        canvas.save();
        canvas.clipRect(rectF);
        while (i < i2) {
            rectF.left = i;
            i += max;
            rectF.right = i;
            canvas.drawBitmap(thumbnailBitmap, (Rect) null, rectF, (Paint) null);
        }
        canvas.restore();
        return true;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getBGColor() {
        return R.color.layer_text;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void getBounds(Rect rect) {
        rect.left = (-getWidth()) / 2;
        rect.right = rect.left + getWidth();
        rect.top = (-getHeight()) / 2;
        rect.bottom = rect.top + getHeight();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.f
    public int getBrightness() {
        return this.m_Brightness;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.h
    public ColorEffect getColorEffect() {
        return this.m_colorEffect;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa.a
    public int getColorOption(int i) {
        if (i == R.id.opt_color) {
            return getSolidColor();
        }
        return super.getColorOption(i);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.g
    public int getCombinedBrightness() {
        ColorEffect colorEffect = this.m_colorEffect;
        if (colorEffect == null) {
            return this.m_Brightness;
        }
        return this.m_Brightness + ((int) (colorEffect.getBrightness() * 255.0f));
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.g
    public int getCombinedContrast() {
        ColorEffect colorEffect = this.m_colorEffect;
        if (colorEffect == null) {
            return this.m_Contrast;
        }
        return this.m_Contrast + ((int) (colorEffect.getContrast() * 255.0f));
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.g
    public int getCombinedSaturation() {
        ColorEffect colorEffect = this.m_colorEffect;
        if (colorEffect == null) {
            return this.m_Saturation;
        }
        return this.m_Saturation + ((int) (colorEffect.getSaturation() * 255.0f));
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.f
    public int getContrast() {
        return this.m_Contrast;
    }

    public Bitmap getCustomMaskBitmap() {
        getBounds(new Rect());
        Bitmap createBitmap = Bitmap.createBitmap(1280, 720, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.save();
        NexLayerItem.b closestKeyframe = getClosestKeyframe(0.0f);
        canvas.scale(1280.0f / r0.width(), 720.0f / r0.height(), closestKeyframe.f20232c, closestKeyframe.f20233d);
        canvas.translate(0.0f, 0.0f);
        canvas.translate(closestKeyframe.f20232c - 640.0f, closestKeyframe.f20233d - 360.0f);
        Iterator<com.nexstreaming.kinemaster.layer.handwriting.b> it = getCustomMaskDrawingActions().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().b()) {
                i++;
            }
        }
        for (com.nexstreaming.kinemaster.layer.handwriting.b bVar : getCustomMaskDrawingActions()) {
            if (bVar.b()) {
                i--;
            }
            if (i < 1) {
                bVar.a(canvas);
            }
        }
        return createBitmap;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.j
    public List<com.nexstreaming.kinemaster.layer.handwriting.b> getCustomMaskDrawingActions() {
        return this.customMaskDrawingActionList;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveSubtitle(Context context) {
        if (isSolid()) {
            int solidColor = getSolidColor();
            return context.getResources().getString(R.string.solid_clip_rgb, Integer.valueOf(Color.red(solidColor)), Integer.valueOf(Color.green(solidColor)), Integer.valueOf(Color.blue(solidColor)));
        }
        return this.n + "×" + this.o;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveTitle(Context context) {
        String str = this.filePath;
        if (str == null) {
            return "";
        }
        if (str.startsWith("@solid:") && this.filePath.endsWith(".jpg")) {
            return context.getResources().getString(R.string.solid_color_clip);
        }
        if (s.a(context, this.filePath) != null) {
            return context.getResources().getString(R.string.mediabrowser_backgrounds);
        }
        return new File(this.filePath).getName();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public FileType.FileCategory getFileCategory() {
        return FileType.FileCategory.Image;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getHeight() {
        f();
        return this.o;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getIcon() {
        return R.drawable.layericon_image;
    }

    public Bitmap getImageBitmap() {
        String str;
        Bitmap a2;
        if (!checkResourceState(null)) {
            this.q = null;
            return null;
        }
        if (this.q == null && (str = this.filePath) != null) {
            if (str.startsWith("@solid:") && this.filePath.endsWith(".jpg")) {
                int parseLong = (int) Long.parseLong(this.filePath.substring(7, 15), 16);
                float l = EditorGlobal.l();
                int i = ModuleDescriptor.MODULE_VERSION;
                int i2 = 180;
                if (l == 1.7777778f) {
                    i = 180;
                    i2 = ModuleDescriptor.MODULE_VERSION;
                } else if (EditorGlobal.l() != 0.5625f) {
                    i = 180;
                }
                a2 = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
                new Canvas(a2).drawColor(parseLong);
            } else {
                a2 = NexImageLoader.loadBitmap(this.filePath, 1920, 1080).a();
            }
            this.q = a2;
        }
        return this.q;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getIntinsicDuration() {
        throw new UnsupportedOperationException();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected String getLabelText(Context context) {
        String str = this.filePath;
        if (str == null) {
            return "";
        }
        if (str.startsWith("@solid:") && this.filePath.endsWith(".jpg")) {
            return context.getResources().getString(R.string.solid_color_clip);
        }
        if (s.a(context, this.filePath) != null) {
            return context.getResources().getString(R.string.mediabrowser_backgrounds);
        }
        return new File(this.filePath).getName();
    }

    @Override // com.nexstreaming.kinemaster.layer.MediaLayer
    public String getMediaPath() {
        return this.filePath;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Class<? extends Bg> getOptionMenuClass() {
        return Mb.class;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.f
    public int getSaturation() {
        return this.m_Saturation;
    }

    public int getSolidColor() {
        if (isSolid()) {
            return (int) Long.parseLong(this.filePath.substring(7, 15), 16);
        }
        return 0;
    }

    public Bitmap getThumbnailBitmap() {
        String str;
        Bitmap a2;
        if (!checkResourceState(null)) {
            this.r = null;
            return null;
        }
        if (this.r == null && (str = this.filePath) != null) {
            if (str.startsWith("@solid:") && this.filePath.endsWith(".jpg")) {
                int parseLong = (int) Long.parseLong(this.filePath.substring(7, 15), 16);
                a2 = Bitmap.createBitmap(ModuleDescriptor.MODULE_VERSION, 180, Bitmap.Config.ARGB_8888);
                new Canvas(a2).drawColor(parseLong);
            } else {
                a2 = NexImageLoader.loadBitmap(this.filePath, ModuleDescriptor.MODULE_VERSION, 180).a();
            }
            this.r = a2;
        }
        return this.r;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem, com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa
    public int getTimelineViewLayoutResource() {
        return R.layout.timeline_item_secondary_imagelayer;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getTrackAffinity() {
        return isSolid() ? R.drawable.track_header_bg_icon : R.drawable.track_header_image_icon;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int[] getTrackOptionItems() {
        return new int[]{R.id.opt_alpha_adj};
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
        if (i == R.id.opt_blending) {
            return getBlendMode() != BlendMode.NONE;
        }
        if (i != R.id.opt_rotate) {
            return super.isOptionApplied(i);
        }
        return getRotation() != 0 || getFlipH() || getFlipV();
    }

    public boolean isSolid() {
        String str = this.filePath;
        return str != null && str.startsWith("@solid:") && this.filePath.endsWith(".jpg");
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean isTransformedPointInLayerAtTime(float f2, float f3, int i) {
        int i2 = (-getWidth()) / 2;
        int width = getWidth() + i2;
        int i3 = (-getHeight()) / 2;
        return f2 >= ((float) i2) && f2 <= ((float) width) && f3 >= ((float) i3) && f3 <= ((float) (getHeight() + i3));
    }

    public boolean needsRedrawBitmap() {
        return this.m_needsRedraw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRender(LayerRenderer layerRenderer, NexLayerItem.b bVar, boolean z) {
        Bitmap imageBitmap;
        NexEditor i;
        if (this.q == null || (imageBitmap = getImageBitmap()) == null) {
            return;
        }
        layerRenderer.x();
        if (this.m_lut) {
            layerRenderer.b(imageBitmap, 0.0f, 0.0f);
        } else {
            if (this.m_mask) {
                float combinedBrightness = getCombinedBrightness() / 255.0f;
                float combinedContrast = getCombinedContrast() / 255.0f;
                float combinedSaturation = getCombinedSaturation() / 255.0f;
                ColorEffect colorEffect = this.m_colorEffect;
                layerRenderer.a(c.d.a.a.e.a.a(combinedBrightness, combinedContrast, combinedSaturation, colorEffect != null ? colorEffect.getTintColor() : 0));
                layerRenderer.a(LayerRenderer.RenderTarget.Mask);
                layerRenderer.a(imageBitmap, 0.0f, 0.0f);
                layerRenderer.a(LayerRenderer.RenderTarget.Normal);
                layerRenderer.d(true);
            } else {
                ColorEffect colorEffect2 = this.m_colorEffect;
                if (colorEffect2 != null) {
                    layerRenderer.c(colorEffect2.getLut());
                }
                float combinedBrightness2 = getCombinedBrightness() / 255.0f;
                float combinedContrast2 = getCombinedContrast() / 255.0f;
                float combinedSaturation2 = getCombinedSaturation() / 255.0f;
                ColorEffect colorEffect3 = this.m_colorEffect;
                layerRenderer.a(c.d.a.a.e.a.a(combinedBrightness2, combinedContrast2, combinedSaturation2, colorEffect3 != null ? colorEffect3.getTintColor() : 0));
                int ordinal = getBlendMode().ordinal();
                if (ordinal > 0) {
                    if (this.current_blend_mode_[layerRenderer.l().id] != ordinal) {
                        if (this.effect_id_[layerRenderer.l().id] >= 0) {
                            EditorGlobal.i().d(this.effect_id_[layerRenderer.l().id], layerRenderer.l().id);
                        }
                        this.effect_id_[layerRenderer.l().id] = -1;
                        this.current_blend_mode_[layerRenderer.l().id] = 0;
                    }
                    if (this.effect_id_[layerRenderer.l().id] < 0 && (i = EditorGlobal.i()) != null) {
                        this.effect_id_[layerRenderer.l().id] = i.a(String.format(Locale.US, "com.nexstreaming.editor.blend_%02d", Integer.valueOf(ordinal)), layerRenderer.l().id);
                        this.current_blend_mode_[layerRenderer.l().id] = ordinal;
                    }
                }
                if (this.effect_id_[layerRenderer.l().id] >= 0 && ordinal > 0) {
                    layerRenderer.a(this.effect_id_[layerRenderer.l().id], imageBitmap, "", layerRenderer.f(), 0, 1000, 0.0f, 0.0f, layerRenderer.d(), layerRenderer.i());
                } else {
                    layerRenderer.a(imageBitmap, 0.0f, 0.0f);
                }
            }
        }
        layerRenderer.c((Bitmap) null);
        layerRenderer.w();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAsleep(LayerRenderer layerRenderer) {
        this.q = null;
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
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null) {
            layerRenderer.a(imageBitmap);
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.j
    public com.nexstreaming.kinemaster.layer.handwriting.b removeLastCMDrawingAction() {
        if (this.customMaskDrawingActionList.size() <= 0) {
            return null;
        }
        return this.customMaskDrawingActionList.remove(r0.size() - 1);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.f
    public void setBrightness(int i) {
        this.m_Brightness = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.h
    public void setColorEffect(ColorEffect colorEffect) {
        this.m_colorEffect = colorEffect;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa.a
    public void setColorOption(int i, int i2) {
        if (i == R.id.opt_color) {
            setSolidColor(i2);
        } else {
            super.setColorOption(i, i2);
            throw null;
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.f
    public void setContrast(int i) {
        this.m_Contrast = i;
    }

    public void setMediaPath(String str, Context context) {
        this.filePath = str;
        this.q = null;
        this.r = null;
        this.p = false;
        this.m_needsRedraw = true;
        this.m_lut = false;
        this.m_mask = false;
        f();
    }

    public void setNeedsRedraw(boolean z) {
        this.m_needsRedraw = z;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.f
    public void setSaturation(int i) {
        this.m_Saturation = i;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean supportsSplitScreen() {
        return true;
    }

    @Override // com.nexstreaming.kinemaster.layer.MediaLayer
    public void setMediaPath(String str) {
        this.filePath = str;
    }
}
