package com.nexstreaming.kinemaster.layer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Log;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.l;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.LayerExpression;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.ui.projectedit.kp;
import com.nexstreaming.kinemaster.ui.projectedit.lo;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.text.Bidi;
import java.text.Normalizer;
import java.util.UUID;

/* loaded from: classes.dex */
public class TextLayer extends NexLayerItem {

    /* renamed from: a */
    private transient int f3474a;
    private transient int b;
    private transient boolean c;
    private TextPaint cachedTextPaint;
    private transient StaticLayout d;
    private transient NexLayerItem.c e;
    private transient float f;
    private String fontId;
    private transient Bitmap g;
    private int[] gradientColors;
    private String layerText = "";
    private float textSize = 50.0f;
    private int textColor = -1;
    private boolean enableBackground = false;
    private boolean extendBackground = false;
    private int backgroundColor = -2013265920;
    private boolean enableShadow = true;
    private int shadowColor = -16777216;
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

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAwake(LayerRenderer layerRenderer) {
        this.g = makeTextBitmap(this.g, 1.0f, 0.0f);
        this.f = 1.0f;
        layerRenderer.b(this.g);
    }

    public static TextLayer newInstance(String str, int i, int i2) {
        return newInstance(str, i, i2, 640, 360, 1.0f);
    }

    public static TextLayer newInstance(String str, int i, int i2, int i3, int i4, float f) {
        return newInstance(str, i, i2, i3, i4, f, 0.0f);
    }

    public static TextLayer newInstance(String str, int i, int i2, int i3, int i4, float f, float f2) {
        if (i2 < 33) {
            i2 = 33;
        }
        TextLayer textLayer = new TextLayer();
        textLayer.setStartTime(i);
        textLayer.setEndTime(i + i2);
        textLayer.setTextSize(50.0f);
        NexLayerItem.b closestKeyframe = textLayer.getClosestKeyframe(0.0f);
        closestKeyframe.c = i3;
        closestKeyframe.d = i4;
        closestKeyframe.b = f;
        closestKeyframe.e = f2;
        textLayer.setText(str);
        return textLayer;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAsleep(LayerRenderer layerRenderer) {
        this.g = null;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRender(LayerRenderer layerRenderer, NexLayerItem.b bVar) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        int i = 0;
        LayerExpression layerExpression = getLayerExpression(LayerExpression.Type.In);
        getLayerExpression(LayerExpression.Type.Out);
        int layerExpressionDuration = layerExpression == LayerExpression.LetterByLetter ? getLayerExpressionDuration(LayerExpression.Type.In) : 0;
        int absStartTime = getAbsStartTime();
        int absEndTime = getAbsEndTime() - absStartTime;
        if (layerExpressionDuration + 0 > absEndTime) {
            int i2 = (layerExpressionDuration + 0) - absEndTime;
            layerExpressionDuration -= (i2 + 1) / 2;
            i = 0 - ((i2 + 1) / 2);
        }
        int j = layerRenderer.j() - absStartTime;
        if (j < layerExpressionDuration && layerExpressionDuration > 0) {
            f = j / layerExpressionDuration;
        } else {
            f = (j <= absEndTime - i || i <= 0) ? 1.0f : 1.0f - ((j - (absEndTime - i)) / i);
        }
        if (f != this.f) {
            this.g = makeTextBitmap(this.g, f, this.f);
            this.f = f;
        }
        layerRenderer.l();
        if (this.textAlign == Layout.Alignment.ALIGN_OPPOSITE) {
            float f6 = -this.f3474a;
            f2 = (-this.b) / 2;
            f3 = f2 + this.b;
            f4 = this.f3474a + f6;
            f5 = f6;
        } else if (this.textAlign == Layout.Alignment.ALIGN_NORMAL) {
            f2 = (-this.b) / 2;
            f3 = f2 + this.b;
            f4 = this.f3474a + 0.0f;
            f5 = 0.0f;
        } else {
            float f7 = (-this.f3474a) / 2;
            f2 = (-this.b) / 2;
            f3 = f2 + this.b;
            f4 = this.f3474a + f7;
            f5 = f7;
        }
        if (isEnableBackground()) {
            if (isExtendBackground()) {
                layerRenderer.b(getBackgroundColor(), f5 - 10000.0f, f2, f4 + 10000.0f, f3);
            } else {
                layerRenderer.b(getBackgroundColor(), f5, f2, f4, f3);
            }
        }
        layerRenderer.a(this.g, f5, f2, f4, f3);
        layerRenderer.m();
    }

    public boolean checkMatchingTexBitmapSize(int i, int i2, int i3, int i4) {
        if (this.e == null) {
            this.e = new NexLayerItem.c();
        }
        getScaleRange(this.e);
        float min = Math.min(Math.min(this.e.c * 2.0f, this.e.b), 2000 / Math.max(i, i2));
        int i5 = (int) (i * min);
        int i6 = (int) (min * i2);
        return i5 > 0 && i6 > 0 && i3 == i5 && i4 == i6;
    }

    public synchronized Bitmap makeTextBitmap(Bitmap bitmap, float f, float f2) {
        StaticLayout staticLayout;
        c();
        int b = b();
        if (this.e == null) {
            this.e = new NexLayerItem.c();
        }
        getScaleRange(this.e);
        float min = Math.min(Math.min(this.e.c * 2.0f, this.e.b), 2000 / Math.max(this.f3474a, this.b));
        int i = (int) (this.f3474a * min);
        int i2 = (int) (this.b * min);
        String normalize = Normalizer.normalize(getText(), Normalizer.Form.NFD);
        int length = (int) (((normalize.length() * f) + 0.5f) * 1000.0f);
        int length2 = (int) (((normalize.length() * f2) + 0.5f) * 1000.0f);
        int i3 = length / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
        int i4 = length2 / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
        int i5 = length - (i3 * LicenseErrCode.LICENSE_STATUS_NOT_LICENSED);
        int i6 = length2 - (i4 * LicenseErrCode.LICENSE_STATUS_NOT_LICENSED);
        if (i <= 0 || i2 <= 0) {
            bitmap = null;
        } else {
            if (bitmap != null && bitmap.getWidth() == i && bitmap.getHeight() == i2 && bitmap.getConfig().equals(Bitmap.Config.ARGB_8888)) {
                if (i3 != i4) {
                    bitmap.eraseColor(0);
                }
            } else {
                bitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(bitmap);
            canvas.scale(min, min);
            canvas.translate(b, b);
            TextPaint paint = this.d.getPaint();
            TextPaint a2 = a();
            int min2 = (int) Math.min(1280.0f, StaticLayout.getDesiredWidth(getText(), a2) + 1.0f);
            Bidi bidi = new Bidi(normalize, -2);
            String normalize2 = Normalizer.normalize(new SpannableStringBuilder().append((CharSequence) normalize, 0, i3), Normalizer.Form.NFC);
            if (this.textAlign.equals(Layout.Alignment.ALIGN_CENTER) || bidi.baseIsLeftToRight()) {
                staticLayout = new StaticLayout(normalize2, 0, normalize2.length(), a2, min2, this.textAlign, 1.0f, 0.0f, true);
            } else if (!bidi.baseIsLeftToRight() && this.textAlign.equals(Layout.Alignment.ALIGN_NORMAL)) {
                staticLayout = new StaticLayout(normalize2, 0, normalize2.length(), a2, min2, Layout.Alignment.ALIGN_OPPOSITE, 1.0f, 0.0f, true);
            } else if (!bidi.baseIsLeftToRight() && this.textAlign.equals(Layout.Alignment.ALIGN_OPPOSITE)) {
                staticLayout = new StaticLayout(normalize2, 0, normalize2.length(), a2, min2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            } else {
                bitmap = null;
            }
            paint.setTextAlign(Paint.Align.LEFT);
            paint.setStyle(Paint.Style.FILL);
            if (this.enableShadow) {
                paint.setMaskFilter(new BlurMaskFilter(this.shadowRadius / min, BlurMaskFilter.Blur.NORMAL));
                paint.setColor(this.shadowColor);
                canvas.save();
                canvas.translate(this.shadowDx, this.shadowDy);
                staticLayout.draw(canvas);
                canvas.restore();
            }
            if (this.enableGlow) {
                paint.setMaskFilter(new BlurMaskFilter(this.glowRadius / min, BlurMaskFilter.Blur.OUTER));
                paint.setColor(this.glowColor);
                staticLayout.draw(canvas);
            }
            paint.setMaskFilter(null);
            paint.setColor(this.textColor);
            staticLayout.draw(canvas);
            if (this.enableOutline) {
                staticLayout.getPaint().setStyle(Paint.Style.STROKE);
                paint.setColor(this.outlineColor);
                paint.setStrokeWidth(this.outlineWidth / min);
                staticLayout.draw(canvas);
            }
        }
        return bitmap;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean isTransformedPointInLayerAtTime(float f, float f2, int i) {
        int i2 = (-getWidth()) / 2;
        int width = getWidth() + i2;
        int i3 = (-getHeight()) / 2;
        return f >= ((float) i2) && f <= ((float) width) && f2 >= ((float) i3) && f2 <= ((float) (getHeight() + i3));
    }

    public void updateRenderBitmap(Bitmap bitmap) {
        this.g = bitmap;
    }

    public String getText() {
        return this.layerText == null ? "" : this.layerText;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected String getLabelText(Context context) {
        return getText();
    }

    public void setText(String str) {
        this.layerText = str;
        this.c = false;
    }

    public void setTextSize(float f) {
        this.textSize = f;
        this.c = false;
    }

    public float getTextSize() {
        return this.textSize;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.text.TextPaint a() {
        /*
            r7 = this;
            android.text.TextPaint r0 = r7.cachedTextPaint
            if (r0 != 0) goto L4d
            android.text.TextPaint r0 = new android.text.TextPaint
            r0.<init>()
            r7.cachedTextPaint = r0
        Lb:
            android.text.TextPaint r2 = r7.cachedTextPaint
            float r0 = r7.textSize
            r2.setTextSize(r0)
            r0 = 1
            r2.setAntiAlias(r0)
            r0 = -1
            r2.setColor(r0)
            float r0 = r7.outlineWidth
            r2.setStrokeWidth(r0)
            android.graphics.Paint$Style r0 = android.graphics.Paint.Style.FILL_AND_STROKE
            r2.setStyle(r0)
            r1 = 0
            java.lang.String r0 = r7.fontId
            if (r0 == 0) goto L70
            com.nextreaming.nexeditorui.KineMasterApplication r0 = com.nextreaming.nexeditorui.KineMasterApplication.a()
            com.nexstreaming.kinemaster.kmpackage.EffectLibrary r0 = r0.e()
            if (r0 == 0) goto L70
            java.lang.String r3 = r7.fontId
            com.nexstreaming.kinemaster.kmpackage.Font r3 = r0.f(r3)
            if (r3 == 0) goto L70
            com.nextreaming.nexeditorui.KineMasterApplication r0 = com.nextreaming.nexeditorui.KineMasterApplication.a()     // Catch: com.nexstreaming.kinemaster.kmpackage.Font.TypefaceLoadException -> L53
            android.content.Context r0 = r0.getApplicationContext()     // Catch: com.nexstreaming.kinemaster.kmpackage.Font.TypefaceLoadException -> L53
            android.graphics.Typeface r0 = r3.b(r0)     // Catch: com.nexstreaming.kinemaster.kmpackage.Font.TypefaceLoadException -> L53
        L47:
            if (r0 == 0) goto L4c
            r2.setTypeface(r0)
        L4c:
            return r2
        L4d:
            android.text.TextPaint r0 = r7.cachedTextPaint
            r0.reset()
            goto Lb
        L53:
            r0 = move-exception
            java.lang.String r4 = "TextLayer"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to get typeface for : "
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r3 = r3.m()
            java.lang.StringBuilder r3 = r5.append(r3)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r4, r3, r0)
        L70:
            r0 = r1
            goto L47
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.layer.TextLayer.a():android.text.TextPaint");
    }

    private int b() {
        return (int) Math.ceil(Math.max(this.outlineWidth, Math.max(this.glowRadius, this.shadowRadius + Math.max(Math.abs(this.shadowDx), Math.abs(this.shadowDy)))));
    }

    private synchronized void c() {
        if (!this.c || this.d == null) {
            TextPaint a2 = a();
            String text = getText();
            int min = (int) Math.min(1280.0f, StaticLayout.getDesiredWidth(text, a2) + 1.0f);
            Bidi bidi = new Bidi(text, -2);
            if (this.textAlign.equals(Layout.Alignment.ALIGN_CENTER) || bidi.baseIsLeftToRight()) {
                this.d = new StaticLayout(text, 0, this.layerText.length(), a2, min, this.textAlign, 1.0f, 0.0f, true);
            } else if (!bidi.baseIsLeftToRight() && this.textAlign.equals(Layout.Alignment.ALIGN_NORMAL)) {
                this.d = new StaticLayout(text, 0, this.layerText.length(), a2, min, Layout.Alignment.ALIGN_OPPOSITE, 1.0f, 0.0f, true);
            } else if (!bidi.baseIsLeftToRight() && this.textAlign.equals(Layout.Alignment.ALIGN_OPPOSITE)) {
                this.d = new StaticLayout(text, 0, this.layerText.length(), a2, min, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            int b = b();
            this.f3474a = Math.max(1, this.d.getWidth()) + (b * 2);
            this.b = (b * 2) + Math.max(1, this.d.getHeight());
            this.c = true;
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveTitle(Context context) {
        return context.getResources().getString(R.string.layer_menu_text);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getBGColor() {
        return R.color.layer_text;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getIcon() {
        return R.drawable.layericon_text;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getWidth() {
        c();
        return this.f3474a;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getHeight() {
        c();
        return this.b;
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
        builder.gradient_colors = this.gradientColors == null ? null : l.a(this.gradientColors);
        if (this.textAlign == Layout.Alignment.ALIGN_CENTER) {
            builder.text_align = 0;
        } else if (this.textAlign == Layout.Alignment.ALIGN_NORMAL) {
            builder.text_align = 1;
        } else if (this.textAlign == Layout.Alignment.ALIGN_OPPOSITE) {
            builder.text_align = 2;
        }
        builder.layer_common = getLayerCommonProtoBuf();
        return new KMProto.KMProject.TimelineItem.Builder().clip_type(KMProto.KMProject.ClipType.LAYER_TEXT).unique_id_lsb(Long.valueOf(getUniqueId().getLeastSignificantBits())).unique_id_msb(Long.valueOf(getUniqueId().getMostSignificantBits())).text_layer(builder.build()).build();
    }

    public static NexSecondaryTimelineItem fromProtoBuf(KMProto.KMProject.TimelineItem timelineItem) {
        TextLayer textLayer = new TextLayer();
        textLayer.setUniqueId(new UUID(timelineItem.unique_id_msb.longValue(), timelineItem.unique_id_lsb.longValue()));
        textLayer.enableGlow = timelineItem.text_layer.enable_glow.booleanValue();
        textLayer.layerText = timelineItem.text_layer.layer_text;
        textLayer.textSize = timelineItem.text_layer.text_size.floatValue();
        textLayer.fontId = timelineItem.text_layer.font_id;
        textLayer.textColor = timelineItem.text_layer.text_color.intValue();
        textLayer.enableShadow = timelineItem.text_layer.enable_shadow.booleanValue();
        textLayer.shadowColor = timelineItem.text_layer.shadow_color.intValue();
        textLayer.shadowRadius = timelineItem.text_layer.shadow_radius.floatValue();
        textLayer.enableBackground = timelineItem.text_layer.enable_background == null ? false : timelineItem.text_layer.enable_background.booleanValue();
        textLayer.backgroundColor = timelineItem.text_layer.background_color == null ? -2013265920 : timelineItem.text_layer.background_color.intValue();
        textLayer.extendBackground = timelineItem.text_layer.extend_background != null ? timelineItem.text_layer.extend_background.booleanValue() : false;
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
        textLayer.gradientColors = timelineItem.text_layer.gradient_colors == null ? null : l.a(timelineItem.text_layer.gradient_colors);
        if (timelineItem.text_layer.text_align == null || timelineItem.text_layer.text_align.intValue() == 0) {
            textLayer.textAlign = Layout.Alignment.ALIGN_CENTER;
        } else if (timelineItem.text_layer.text_align.intValue() == 1) {
            textLayer.textAlign = Layout.Alignment.ALIGN_NORMAL;
        } else if (timelineItem.text_layer.text_align.intValue() == 2) {
            textLayer.textAlign = Layout.Alignment.ALIGN_OPPOSITE;
        }
        fromProtoBuf(timelineItem.text_layer.layer_common, textLayer);
        return textLayer;
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
        return lo.class;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public int getGlowColor() {
        return this.glowColor;
    }

    public int getOutlineColor() {
        return this.outlineColor;
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public int getShadowColor() {
        return this.shadowColor;
    }

    public synchronized void setTextAlign(Layout.Alignment alignment) {
        this.textAlign = alignment;
        this.d = null;
        this.c = true;
        c();
    }

    public Layout.Alignment getTextAlign() {
        return this.textAlign;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
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

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
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
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
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

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Task setSwitchOption(int i, boolean z, Context context) {
        if (i == R.id.opt_shadow) {
            this.enableShadow = z;
            return null;
        }
        if (i == R.id.opt_glow) {
            this.enableGlow = z;
            return null;
        }
        if (i == R.id.opt_outline) {
            this.enableOutline = z;
            return null;
        }
        if (i == R.id.opt_background_color) {
            this.enableBackground = z;
            return null;
        }
        if (i == R.id.opt_background_extend) {
            this.extendBackground = z;
            return null;
        }
        super.setSwitchOption(i, z, context);
        return null;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void getBounds(Rect rect) {
        if ((!getFlipV() && this.textAlign == Layout.Alignment.ALIGN_OPPOSITE) || (getFlipV() && this.textAlign == Layout.Alignment.ALIGN_NORMAL)) {
            rect.left = -getWidth();
            rect.right = rect.left + getWidth();
            rect.top = (-getHeight()) / 2;
            rect.bottom = rect.top + getHeight();
            return;
        }
        if ((!getFlipV() && this.textAlign == Layout.Alignment.ALIGN_NORMAL) || (getFlipV() && this.textAlign == Layout.Alignment.ALIGN_OPPOSITE)) {
            rect.left = 0;
            rect.right = rect.left + getWidth();
            rect.top = (-getHeight()) / 2;
            rect.bottom = rect.top + getHeight();
            return;
        }
        rect.left = (-getWidth()) / 2;
        rect.right = rect.left + getWidth();
        rect.top = (-getHeight()) / 2;
        rect.bottom = rect.top + getHeight();
    }

    public boolean isEnableShadow() {
        return this.enableShadow;
    }

    public boolean isEnableBackground() {
        return this.enableBackground;
    }

    public boolean isExtendBackground() {
        return this.extendBackground;
    }

    public boolean isEnableGlow() {
        return this.enableGlow;
    }

    public boolean isEnableOutline() {
        return this.enableOutline;
    }

    public void setFontId(String str) {
        Log.d("TextLayer", "TESTTEST :: setFontId :: " + str);
        this.fontId = str;
        this.c = false;
        c();
    }

    public String getFontId() {
        return this.fontId;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean supportsSplitScreen() {
        return false;
    }
}
