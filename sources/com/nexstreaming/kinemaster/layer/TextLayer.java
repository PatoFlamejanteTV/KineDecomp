package com.nexstreaming.kinemaster.layer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.v4.view.ViewCompat;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Log;
import com.google.protos.datapol.SemanticAnnotations;
import com.nexstreaming.app.general.nexasset.assetpackage.h;
import com.nexstreaming.app.general.nexasset.assetpackage.r;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.q;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.LayerExpression;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.project.ProjectDependency;
import com.nexstreaming.kinemaster.ui.projectedit.Bg;
import com.nexstreaming.kinemaster.ui.projectedit.C1939kh;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.text.Bidi;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes.dex */
public class TextLayer extends NexLayerItem {
    private TextPaint cachedTextPaint;
    private String fontId;
    private int[] gradientColors;
    private transient int n;
    private transient int o;
    private transient boolean p;
    private transient StaticLayout q;
    private transient NexLayerItem.c r;
    private transient float s;
    private transient boolean t;
    private transient Bitmap u;
    private String layerText = "";
    private float textSize = 50.0f;
    private int textColor = -1;
    private boolean enableBackground = false;
    private boolean extendBackground = false;
    private int backgroundColor = -2013265920;
    private boolean enableShadow = true;
    private int shadowColor = ViewCompat.MEASURED_STATE_MASK;
    private float shadowRadius = 5.0f;
    private float shadowDx = 3.0f;
    private float shadowDy = 3.0f;
    private boolean enableGlow = false;
    private int glowColor = -1426063446;
    private float glowRadius = 8.0f;
    private int glowType = 0;
    private boolean enableOutline = false;
    private int outlineColor = -3355444;
    private float outlineWidth = 1.0f;
    private boolean enableGradient = false;
    private Layout.Alignment textAlign = Layout.Alignment.ALIGN_CENTER;
    private int[] effect_id_ = {-1, -1};
    private int[] current_blend_mode_ = {0, 0};

    private synchronized void f() {
        if (!this.p || this.q == null) {
            TextPaint g2 = g();
            String text = getText();
            int min = (int) Math.min(EditorGlobal.n(), StaticLayout.getDesiredWidth(text, g2) + 1.0f);
            Bidi bidi = new Bidi(text, -2);
            if (!this.textAlign.equals(Layout.Alignment.ALIGN_CENTER) && !bidi.baseIsLeftToRight()) {
                if (!bidi.baseIsLeftToRight() && this.textAlign.equals(Layout.Alignment.ALIGN_NORMAL)) {
                    this.q = new StaticLayout(text, 0, this.layerText.length(), g2, min, Layout.Alignment.ALIGN_OPPOSITE, 1.0f, 0.0f, true);
                } else if (!bidi.baseIsLeftToRight() && this.textAlign.equals(Layout.Alignment.ALIGN_OPPOSITE)) {
                    this.q = new StaticLayout(text, 0, this.layerText.length(), g2, min, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
                }
                int h2 = h() * 2;
                this.n = Math.max(1, this.q.getWidth()) + h2;
                this.o = Math.max(1, this.q.getHeight()) + h2;
                Log.d("TextLayer", String.format("Text Layer calcDimensions : %s (%d %d)", text, Integer.valueOf(this.n), Integer.valueOf(this.o)));
                this.p = true;
            }
            this.q = new StaticLayout(text, 0, this.layerText.length(), g2, min, this.textAlign, 1.0f, 0.0f, true);
            int h22 = h() * 2;
            this.n = Math.max(1, this.q.getWidth()) + h22;
            this.o = Math.max(1, this.q.getHeight()) + h22;
            Log.d("TextLayer", String.format("Text Layer calcDimensions : %s (%d %d)", text, Integer.valueOf(this.n), Integer.valueOf(this.o)));
            this.p = true;
        }
    }

    public static NexSecondaryTimelineItem fromProtoBuf(KMProto.KMProject.TimelineItem timelineItem) {
        TextLayer textLayer = new TextLayer();
        textLayer.setUniqueId(new UUID(timelineItem.unique_id_msb.longValue(), timelineItem.unique_id_lsb.longValue()));
        textLayer.enableGlow = timelineItem.text_layer.enable_glow.booleanValue();
        KMProto.KMProject.TextLayer textLayer2 = timelineItem.text_layer;
        textLayer.layerText = textLayer2.layer_text;
        textLayer.textSize = textLayer2.text_size.floatValue();
        KMProto.KMProject.TextLayer textLayer3 = timelineItem.text_layer;
        textLayer.fontId = textLayer3.font_id;
        textLayer.textColor = textLayer3.text_color.intValue();
        textLayer.enableShadow = timelineItem.text_layer.enable_shadow.booleanValue();
        textLayer.shadowColor = timelineItem.text_layer.shadow_color.intValue();
        textLayer.shadowRadius = timelineItem.text_layer.shadow_radius.floatValue();
        Boolean bool = timelineItem.text_layer.enable_background;
        textLayer.enableBackground = bool == null ? false : bool.booleanValue();
        Integer num = timelineItem.text_layer.background_color;
        textLayer.backgroundColor = num == null ? -2013265920 : num.intValue();
        Boolean bool2 = timelineItem.text_layer.extend_background;
        textLayer.extendBackground = bool2 == null ? false : bool2.booleanValue();
        textLayer.shadowDx = timelineItem.text_layer.shadow_dx.floatValue();
        textLayer.shadowDy = timelineItem.text_layer.shadow_dy.floatValue();
        textLayer.enableGlow = timelineItem.text_layer.enable_glow.booleanValue();
        textLayer.glowColor = timelineItem.text_layer.glow_color.intValue();
        textLayer.glowRadius = timelineItem.text_layer.glow_radius.floatValue();
        textLayer.glowType = timelineItem.text_layer.glow_type.intValue();
        textLayer.enableOutline = timelineItem.text_layer.enable_outline.booleanValue();
        textLayer.outlineColor = timelineItem.text_layer.outline_color.intValue();
        textLayer.outlineWidth = timelineItem.text_layer.outline_width.floatValue();
        textLayer.enableGradient = timelineItem.text_layer.enable_gradient.booleanValue();
        List<Integer> list = timelineItem.text_layer.gradient_colors;
        textLayer.gradientColors = list == null ? null : q.a(list);
        Integer num2 = timelineItem.text_layer.text_align;
        if (num2 != null && num2.intValue() != 0) {
            if (timelineItem.text_layer.text_align.intValue() == 1) {
                textLayer.textAlign = Layout.Alignment.ALIGN_NORMAL;
            } else if (timelineItem.text_layer.text_align.intValue() == 2) {
                textLayer.textAlign = Layout.Alignment.ALIGN_OPPOSITE;
            }
        } else {
            textLayer.textAlign = Layout.Alignment.ALIGN_CENTER;
        }
        NexLayerItem.fromProtoBuf(timelineItem.text_layer.layer_common, textLayer);
        Integer num3 = timelineItem.track_id;
        textLayer.track_id = num3 != null ? num3.intValue() : 0;
        return textLayer;
    }

    private TextPaint g() {
        TextPaint textPaint = this.cachedTextPaint;
        if (textPaint == null) {
            this.cachedTextPaint = new TextPaint();
        } else {
            textPaint.reset();
            this.cachedTextPaint.setTypeface(null);
        }
        TextPaint textPaint2 = this.cachedTextPaint;
        textPaint2.setTextSize(this.textSize);
        textPaint2.setAntiAlias(true);
        textPaint2.setColor(-1);
        textPaint2.setStrokeWidth(this.outlineWidth);
        textPaint2.setStyle(Paint.Style.FILL_AND_STROKE);
        Typeface a2 = com.nexstreaming.kinemaster.fonts.d.b().a(this.fontId);
        if (a2 != null) {
            textPaint2.setTypeface(a2);
        }
        return textPaint2;
    }

    private int h() {
        return (int) Math.ceil(Math.max(this.outlineWidth, Math.max(this.glowRadius, this.shadowRadius + Math.max(Math.abs(this.shadowDx), Math.abs(this.shadowDy)))));
    }

    public static TextLayer newInstance(String str, int i, int i2) {
        return newInstance(str, i, i2, EditorGlobal.n() / 2, EditorGlobal.m() / 2, 1.0f);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void addDependencies(Collection<ProjectDependency> collection) {
        String str = this.fontId;
        if (str == null || str.length() <= 0 || this.fontId.equals(NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE)) {
            return;
        }
        collection.add(ProjectDependency.c(this.fontId));
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public KMProto.KMProject.TimelineItem asProtoBuf() {
        KMProto.KMProject.TextLayer.Builder builder = new KMProto.KMProject.TextLayer.Builder();
        builder.enable_glow = Boolean.valueOf(this.enableGlow);
        builder.layer_text = this.layerText;
        builder.text_size = Float.valueOf(this.textSize);
        builder.font_id = this.fontId;
        builder.text_color = Integer.valueOf(this.textColor);
        builder.enable_shadow = Boolean.valueOf(this.enableShadow);
        builder.shadow_color = Integer.valueOf(this.shadowColor);
        builder.shadow_radius = Float.valueOf(this.shadowRadius);
        builder.enable_background = Boolean.valueOf(this.enableBackground);
        builder.extend_background = Boolean.valueOf(this.extendBackground);
        builder.background_color = Integer.valueOf(this.backgroundColor);
        builder.shadow_dx = Float.valueOf(this.shadowDx);
        builder.shadow_dy = Float.valueOf(this.shadowDy);
        builder.enable_glow = Boolean.valueOf(this.enableGlow);
        builder.glow_color = Integer.valueOf(this.glowColor);
        builder.glow_radius = Float.valueOf(this.glowRadius);
        builder.glow_type = Integer.valueOf(this.glowType);
        builder.enable_outline = Boolean.valueOf(this.enableOutline);
        builder.outline_color = Integer.valueOf(this.outlineColor);
        builder.outline_width = Float.valueOf(this.outlineWidth);
        builder.enable_gradient = Boolean.valueOf(this.enableGradient);
        int[] iArr = this.gradientColors;
        builder.gradient_colors = iArr == null ? null : q.a(iArr);
        Layout.Alignment alignment = this.textAlign;
        if (alignment == Layout.Alignment.ALIGN_CENTER) {
            builder.text_align = 0;
        } else if (alignment == Layout.Alignment.ALIGN_NORMAL) {
            builder.text_align = 1;
        } else if (alignment == Layout.Alignment.ALIGN_OPPOSITE) {
            builder.text_align = 2;
        }
        builder.layer_common = getLayerCommonProtoBuf();
        return new KMProto.KMProject.TimelineItem.Builder().clip_type(KMProto.KMProject.ClipType.LAYER_TEXT).unique_id_lsb(Long.valueOf(getUniqueId().getLeastSignificantBits())).unique_id_msb(Long.valueOf(getUniqueId().getMostSignificantBits())).text_layer(builder.build()).track_id(Integer.valueOf(this.track_id)).build();
    }

    public boolean checkMatchingTexBitmapSize(int i, int i2, int i3, int i4) {
        if (this.r == null) {
            this.r = new NexLayerItem.c();
        }
        getScaleRange(this.r);
        float max = SemanticAnnotations.SemanticType.ST_THIRD_PARTY_DATA_VALUE / Math.max(i, i2);
        NexLayerItem.c cVar = this.r;
        float min = Math.min(Math.min(cVar.f20240c * 2.0f, cVar.f20239b), max);
        int i5 = (int) (i * min);
        int i6 = (int) (i2 * min);
        return i5 > 0 && i6 > 0 && i3 == i5 && i4 == i6;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getBGColor() {
        return R.color.layer_text;
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void getBounds(Rect rect) {
        rect.left = (-getWidth()) / 2;
        rect.right = rect.left + getWidth();
        rect.top = (-getHeight()) / 2;
        rect.bottom = rect.top + getHeight();
        RectF rectF = new RectF(rect);
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.postScale(getFlipH() ? -1.0f : 1.0f, getFlipV() ? -1.0f : 1.0f);
        matrix.mapRect(rectF);
        rect.left = (int) rectF.left;
        rect.top = (int) rectF.top;
        rect.right = (int) rectF.right;
        rect.bottom = (int) rectF.bottom;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa.a
    public int getColorOption(int i) {
        if (i == R.id.opt_text_color) {
            return getTextColor();
        }
        if (i == R.id.opt_shadow) {
            return getShadowColor();
        }
        if (i == R.id.opt_glow) {
            return getGlowColor();
        }
        if (i == R.id.opt_outline) {
            return getOutlineColor();
        }
        if (i == R.id.opt_background_color) {
            return getBackgroundColor();
        }
        return super.getColorOption(i);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean getCropBounds(RectF rectF) {
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveTitle(Context context) {
        return context.getResources().getString(R.string.layer_menu_text);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void getExtendedBounds(Rect rect) {
        super.getExtendedBounds(rect);
        if (this.extendBackground && this.enableBackground) {
            rect.left = -EditorGlobal.n();
            rect.right = EditorGlobal.n();
        }
    }

    public String getFontAssetId() {
        String str = this.fontId;
        if (str == null || !str.contains("/")) {
            return null;
        }
        return str.substring(0, str.indexOf(47));
    }

    public String getFontId() {
        String str = this.fontId;
        if (str == null || !str.contains("/")) {
            return str;
        }
        return str.split("/")[r0.length - 1];
    }

    public int getGlowColor() {
        return this.glowColor;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getHeight() {
        f();
        return this.o;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getIcon() {
        return R.drawable.layericon_text;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getIntinsicDuration() {
        throw new UnsupportedOperationException();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected String getLabelText(Context context) {
        return getText();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Class<? extends Bg> getOptionMenuClass() {
        return C1939kh.class;
    }

    public int getOutlineColor() {
        return this.outlineColor;
    }

    public int getShadowColor() {
        return this.shadowColor;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa.b
    public boolean getSwitchOption(int i) {
        if (i == R.id.opt_shadow) {
            return isEnableShadow();
        }
        if (i == R.id.opt_glow) {
            return isEnableGlow();
        }
        if (i == R.id.opt_outline) {
            return isEnableOutline();
        }
        if (i == R.id.opt_background_color) {
            return isEnableBackground();
        }
        if (i == R.id.opt_background_extend) {
            return isExtendBackground();
        }
        return super.getSwitchOption(i);
    }

    public String getText() {
        String str = this.layerText;
        return str == null ? "" : str;
    }

    public Layout.Alignment getTextAlign() {
        return this.textAlign;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public float getTextSize() {
        return this.textSize;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem, com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa
    public int getTimelineViewLayoutResource() {
        return R.layout.timeline_item_secondary_textlayer;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getTrackAffinity() {
        return R.drawable.track_header_text_icon;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int[] getTrackOptionItems() {
        return new int[]{R.id.opt_alpha_adj, R.id.opt_track_text_style};
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getWidth() {
        f();
        return this.n;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean hasDependencyFromAsset(String str) {
        String fontAssetId = getFontAssetId();
        return fontAssetId != null && fontAssetId.equals(str);
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public boolean hasIntrinsicDuration() {
        return false;
    }

    public boolean isEnableBackground() {
        return this.enableBackground;
    }

    public boolean isEnableGlow() {
        return this.enableGlow;
    }

    public boolean isEnableOutline() {
        return this.enableOutline;
    }

    public boolean isEnableShadow() {
        return this.enableShadow;
    }

    public boolean isExtendBackground() {
        return this.extendBackground;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem, com.nextreaming.nexeditorui.NexTimelineItem
    public boolean isOptionApplied(int i) {
        switch (i) {
            case R.id.opt_blending /* 2131363096 */:
                return getBlendMode() != BlendMode.NONE;
            case R.id.opt_rotate /* 2131363137 */:
                return getRotation() != 0 || getFlipH() || getFlipV();
            case R.id.opt_text_color /* 2131363156 */:
                int i2 = this.textColor;
                return (i2 == -1 || i2 == -1) ? false : true;
            case R.id.opt_text_font /* 2131363157 */:
                return this.fontId != null;
            default:
                return super.isOptionApplied(i);
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean isTransformedPointInLayerAtTime(float f2, float f3, int i) {
        int i2 = (-getWidth()) / 2;
        int width = getWidth() + i2;
        int i3 = (-getHeight()) / 2;
        return f2 >= ((float) i2) && f2 <= ((float) width) && f3 >= ((float) i3) && f3 <= ((float) (getHeight() + i3));
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x016a A[Catch: all -> 0x01c3, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0010, B:7:0x0017, B:13:0x0070, B:15:0x0076, B:17:0x007c, B:19:0x0088, B:25:0x0090, B:26:0x009a, B:28:0x00ea, B:31:0x00f1, B:33:0x00f7, B:35:0x0101, B:36:0x0150, B:38:0x016a, B:40:0x018c, B:41:0x019f, B:43:0x01aa, B:47:0x0117, B:49:0x011d, B:51:0x0127, B:54:0x0139, B:55:0x0094), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x018c A[Catch: all -> 0x01c3, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0010, B:7:0x0017, B:13:0x0070, B:15:0x0076, B:17:0x007c, B:19:0x0088, B:25:0x0090, B:26:0x009a, B:28:0x00ea, B:31:0x00f1, B:33:0x00f7, B:35:0x0101, B:36:0x0150, B:38:0x016a, B:40:0x018c, B:41:0x019f, B:43:0x01aa, B:47:0x0117, B:49:0x011d, B:51:0x0127, B:54:0x0139, B:55:0x0094), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01aa A[Catch: all -> 0x01c3, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0010, B:7:0x0017, B:13:0x0070, B:15:0x0076, B:17:0x007c, B:19:0x0088, B:25:0x0090, B:26:0x009a, B:28:0x00ea, B:31:0x00f1, B:33:0x00f7, B:35:0x0101, B:36:0x0150, B:38:0x016a, B:40:0x018c, B:41:0x019f, B:43:0x01aa, B:47:0x0117, B:49:0x011d, B:51:0x0127, B:54:0x0139, B:55:0x0094), top: B:3:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized android.graphics.Bitmap makeTextBitmap(android.graphics.Bitmap r22, float r23, float r24) {
        /*
            Method dump skipped, instructions count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.layer.TextLayer.makeTextBitmap(android.graphics.Bitmap, float, float):android.graphics.Bitmap");
    }

    public void notifyStyleChanged() {
        this.t = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRender(LayerRenderer layerRenderer, NexLayerItem.b bVar, boolean z) {
        int i;
        NexEditor i2;
        LayerExpression layerExpression = getLayerExpression(LayerExpression.Type.In);
        getLayerExpression(LayerExpression.Type.Out);
        int layerExpressionDuration = layerExpression == LayerExpression.LetterByLetter ? getLayerExpressionDuration(LayerExpression.Type.In) : 0;
        int absStartTime = getAbsStartTime();
        int absEndTime = getAbsEndTime() - absStartTime;
        int i3 = layerExpressionDuration + 0;
        if (i3 > absEndTime) {
            int i4 = ((i3 - absEndTime) + 1) / 2;
            layerExpressionDuration -= i4;
            i = 0 - i4;
        } else {
            i = 0;
        }
        int f2 = layerRenderer.f() - absStartTime;
        float f3 = 1.0f;
        if (f2 >= layerExpressionDuration || layerExpressionDuration <= 0) {
            if (f2 > absEndTime - i && i > 0) {
                f3 = 1.0f - ((f2 - r4) / i);
            }
        } else {
            f3 = f2 / layerExpressionDuration;
        }
        if (f3 != this.s || this.t) {
            this.u = makeTextBitmap(this.u, f3, this.s);
            this.s = f3;
            this.t = false;
        }
        layerRenderer.x();
        int i5 = this.n;
        float f4 = (-i5) / 2;
        float f5 = i5 + f4;
        int i6 = this.o;
        float f6 = (-i6) / 2;
        float f7 = i6 + f6;
        if (isEnableBackground()) {
            if (isExtendBackground()) {
                layerRenderer.c(getBackgroundColor(), f4 - 10000.0f, f6, f5 + 10000.0f, f7);
            } else {
                layerRenderer.c(getBackgroundColor(), f4, f6, f5, f7);
            }
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
            layerRenderer.a(this.effect_id_[layerRenderer.l().id], this.u, "", layerRenderer.f(), 0, 1000, f4, f6, f5, f7, layerRenderer.d(), layerRenderer.i());
        } else {
            layerRenderer.a(this.u, f4, f6, f5, f7);
        }
        layerRenderer.w();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAsleep(LayerRenderer layerRenderer) {
        this.u = null;
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
        this.u = makeTextBitmap(this.u, 1.0f, 0.0f);
        this.s = 1.0f;
        layerRenderer.a(this.u);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa.a
    public void setColorOption(int i, int i2) {
        if (i == R.id.opt_text_color) {
            this.textColor = i2;
            return;
        }
        if (i == R.id.opt_shadow) {
            this.shadowColor = i2;
            return;
        }
        if (i == R.id.opt_outline) {
            this.outlineColor = i2;
            return;
        }
        if (i == R.id.opt_glow) {
            this.glowColor = i2;
        } else if (i == R.id.opt_background_color) {
            this.backgroundColor = i2;
        } else {
            super.setColorOption(i, i2);
            throw null;
        }
    }

    public void setFontId(String str) {
        r a2 = h.e().a(str);
        if (a2 == null) {
            this.fontId = str;
        } else {
            int assetIdx = a2.getAssetPackage() != null ? a2.getAssetPackage().getAssetIdx() : 0;
            this.fontId = assetIdx + "/" + a2.getId();
        }
        this.p = false;
        f();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Task setSwitchOption(int i, boolean z, Context context) {
        if (i == R.id.opt_shadow) {
            this.enableShadow = z;
        } else if (i == R.id.opt_glow) {
            this.enableGlow = z;
        } else if (i == R.id.opt_outline) {
            this.enableOutline = z;
        } else if (i == R.id.opt_background_color) {
            this.enableBackground = z;
        } else if (i == R.id.opt_background_extend) {
            this.extendBackground = z;
        } else {
            super.setSwitchOption(i, z, context);
            throw null;
        }
        return null;
    }

    public void setText(String str) {
        this.layerText = str;
        this.p = false;
    }

    public synchronized void setTextAlign(Layout.Alignment alignment) {
        this.textAlign = alignment;
        this.q = null;
        this.p = true;
        f();
    }

    public void setTextSize(float f2) {
        this.textSize = f2;
        this.p = false;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean supportsSplitScreen() {
        return false;
    }

    public void updateRenderBitmap(Bitmap bitmap) {
        this.u = bitmap;
    }

    public static TextLayer newInstance(String str, int i, int i2, int i3, int i4, float f2) {
        return newInstance(str, i, i2, i3, i4, f2, 0.0f);
    }

    public static TextLayer newInstance(String str, int i, int i2, int i3, int i4, float f2, float f3) {
        if (i2 < 33) {
            i2 = 33;
        }
        TextLayer textLayer = new TextLayer();
        textLayer.setStartTime(i);
        textLayer.setEndTime(i + i2);
        textLayer.setTextSize(50.0f);
        NexLayerItem.b closestKeyframe = textLayer.getClosestKeyframe(0.0f);
        closestKeyframe.f20232c = i3;
        closestKeyframe.f20233d = i4;
        closestKeyframe.f20231b = f2;
        closestKeyframe.f20234e = f3;
        textLayer.setText(str);
        return textLayer;
    }
}
