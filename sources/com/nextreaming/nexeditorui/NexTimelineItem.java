package com.nextreaming.nexeditorui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextPaint;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.LayerMaskMode;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import com.nexstreaming.kinemaster.layer.SplitScreenType;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.project.ProjectDependency;
import com.nexstreaming.kinemaster.ui.projectedit.es;
import com.nexstreaming.kinemaster.ui.projectedit.kp;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class NexTimelineItem implements Serializable {
    private static final long serialVersionUID = 9014758975387978513L;

    /* renamed from: a, reason: collision with root package name */
    private transient NexTimeline f4494a;
    private UUID m_uniqueId;

    /* loaded from: classes.dex */
    public interface a {
        int getAlpha();

        void setAlpha(int i);
    }

    /* loaded from: classes.dex */
    public interface b {
        int getAudioEffect();

        void setAudioEffect(int i);
    }

    /* loaded from: classes.dex */
    public interface c {
        float getChromaKeyBGClip();

        void getChromaKeyBlend(float[] fArr);

        int getChromaKeyColor();

        boolean getChromaKeyEnabled();

        float getChromaKeyFGClip();

        boolean getChromaKeyMaskEnabled();

        int[] getChromaKeyRecommendedColors();

        void setChromaKeyBGClip(float f);

        void setChromaKeyBlend(float[] fArr);

        void setChromaKeyColor(int i);

        void setChromaKeyEnabled(boolean z);

        void setChromaKeyFGClip(float f);

        void setChromaKeyMaskEnabled(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        int getAudioLeftVolume();

        int getAudioPitch();

        int getAudioRightVolume();

        int getClipVolume();

        boolean getMuteAudio();

        boolean isCheckedAudioCompressor();

        void setAudioCompressor(boolean z);

        void setAudioLeftVolume(int i);

        void setAudioPitch(int i);

        void setAudioRightVolume(int i);

        void setClipVolume(int i);

        void setMuteAudio(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        int getBrightness();

        int getContrast();

        int getSaturation();

        void setBrightness(int i);

        void setContrast(int i);

        void setSaturation(int i);
    }

    /* loaded from: classes.dex */
    public interface f {
        int getCombinedBrightness();

        int getCombinedContrast();

        int getCombinedSaturation();
    }

    /* loaded from: classes.dex */
    public interface g {
        ColorEffect getColorEffect();

        void setColorEffect(ColorEffect colorEffect);
    }

    /* loaded from: classes.dex */
    public static abstract class h extends i {
    }

    /* loaded from: classes.dex */
    public static class i {
        public static final i n = new i();
        public static final i o = new i();
    }

    /* loaded from: classes.dex */
    public interface j {
        int getEffectDuration();

        String getEffectID();

        Map<String, String> getEffectOptions();

        void setEffect(com.nexstreaming.kinemaster.kmpackage.b bVar);
    }

    /* loaded from: classes.dex */
    public interface k {
        float getStrengthValue();

        void setStrengthValue(float f);
    }

    /* loaded from: classes.dex */
    public interface l {
        float getVariationhValue();

        void setVariationValue(float f);
    }

    /* loaded from: classes.dex */
    public interface m {
        int getLayerMaskIndex();

        LayerMaskMode getLayerMaskMode();

        boolean isLayerMaskEnabled();

        void setLayerMaskEnabled(boolean z);

        void setLayerMaskIndex(int i);

        void setLayerMaskMode(LayerMaskMode layerMaskMode);
    }

    /* loaded from: classes.dex */
    public interface n {
    }

    /* loaded from: classes.dex */
    public interface o {
        int getMusicVolume();

        void setMusicVolume(int i);
    }

    /* loaded from: classes.dex */
    public interface p {
        void a(NexTimelineItem nexTimelineItem);

        void a(NexTimelineItem nexTimelineItem, NexTimelineItem nexTimelineItem2, NexTimelineItem nexTimelineItem3);
    }

    /* loaded from: classes.dex */
    public interface q {
        boolean getFlipH();

        boolean getFlipV();

        int getRotation();

        void setFlipH(boolean z);

        void setFlipV(boolean z);

        void setRotation(int i);
    }

    /* loaded from: classes.dex */
    public interface r {
        SplitScreenType getSplitScreenType();

        void setSplitScreenType(SplitScreenType splitScreenType);
    }

    /* loaded from: classes.dex */
    public interface s {
        void trimToLeft(int i);

        void trimToRight(int i);
    }

    /* loaded from: classes.dex */
    public interface t {
        int a(boolean z);

        void a(int i, boolean z);

        void c(int i);

        int getCurrentTime();

        NexTimeline getTimeline();
    }

    public abstract KMProto.KMProject.TimelineItem asProtoBuf();

    public abstract int getAbsEndTime();

    public abstract int getAbsStartTime();

    public abstract int getDuration();

    public abstract int getRepresentedDuration();

    public abstract boolean onCustomDrag(h hVar, t tVar, float f2, float f3, float f4);

    public abstract void onCustomDragDone(h hVar, t tVar);

    public abstract void onCustomPostDrag(h hVar, Rect rect);

    public abstract i onDown(Context context, t tVar, RectF rectF, int i2, int i3, boolean z, int i4);

    public abstract i onLongPress(Context context, t tVar, RectF rectF, int i2, int i3, boolean z, int i4);

    public abstract boolean onShowItemMenu(Context context, int i2, int i3, int i4, int i5, int i6, n nVar);

    public abstract void setDuration(int i2);

    public void applyFinalPath(MSID msid, String str, NexVideoClipItem.CropMode cropMode, int i2) {
    }

    public boolean isOptionApplied(int i2) {
        return false;
    }

    public boolean isClipReady() {
        return true;
    }

    public void addDependencies(Set<ProjectDependency> set) {
    }

    public int getColorOption(int i2) {
        return 0;
    }

    public void setColorOption(int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    public boolean getSwitchOption(int i2) {
        return false;
    }

    public Task setSwitchOption(int i2, boolean z, Context context) {
        throw new UnsupportedOperationException();
    }

    public final UUID getUniqueId() {
        if (this.m_uniqueId == null) {
            setUniqueId(UUID.randomUUID());
        }
        return this.m_uniqueId;
    }

    public final void setUniqueId(UUID uuid) {
        this.m_uniqueId = uuid;
    }

    public void removeRequiredOverlaysFromDeleteSet(Set<String> set) {
    }

    public int getRepresentedDurationWithoutOverlap() {
        return getRepresentedDuration();
    }

    public boolean onCustomDrag_v3(h hVar, t tVar, float f2, float f3, float f4) {
        return onCustomDrag(hVar, tVar, f2, f3, f4);
    }

    public void onCustomPostDrag_v3(h hVar, Rect rect) {
        onCustomPostDrag(hVar, rect);
    }

    public void onCustomDragDone_v3(h hVar, t tVar) {
        onCustomDragDone(hVar, tVar);
    }

    public boolean isReadyToPlay() {
        return true;
    }

    public boolean checkResourceState(Context context) {
        return true;
    }

    public MediaStoreItem.MediaSupportType getMediaSupportType() {
        return MediaStoreItem.MediaSupportType.Supported;
    }

    public int[] getOptionMenuItems() {
        return new int[0];
    }

    public void onDraw(com.nexstreaming.kinemaster.ui.projectedit.ay ayVar) {
        drawInCanvas(ayVar, ayVar.b(), ayVar.c(), ayVar.d(), ayVar.e(), ayVar.f(), ayVar.g(), ayVar.j(), ayVar.k(), ayVar.h(), ayVar.n(), ayVar.l(), ayVar.m(), ayVar.o(), ayVar.a());
    }

    public void drawInCanvas(Context context, Canvas canvas, RectF rectF, RectF rectF2, Paint paint, boolean z, boolean z2, float f2, h hVar, boolean z3, float f3, int i2, int i3, List<ef> list, p pVar) {
        rectF2.set(rectF);
        rectF2.inset(1.0f, 1.0f);
        if (z) {
            paint.setColor(-3364216);
        } else {
            paint.setColor(-8947849);
        }
        if (!z2) {
            paint.setStyle(Paint.Style.FILL);
            canvas.drawRoundRect(rectF2, 2.0f, 2.0f, paint);
        }
        paint.setStyle(Paint.Style.STROKE);
        if (z) {
            paint.setColor(-52);
        } else {
            paint.setColor(-6710887);
        }
        if (!z2) {
            paint.setStrokeWidth(2.0f);
        }
        canvas.drawRoundRect(rectF2, 2.0f, 2.0f, paint);
    }

    public Bitmap getDragBitmap_v3(Context context, int i2, int i3, int i4) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF(0.0f, 0.0f, i4, i3);
        RectF rectF2 = new RectF();
        TextPaint textPaint = new TextPaint();
        p czVar = new cz(this);
        com.nexstreaming.kinemaster.ui.projectedit.ay ayVar = new com.nexstreaming.kinemaster.ui.projectedit.ay(context);
        ayVar.a(canvas, rectF, rectF2, textPaint, false, false, null, false, rectF.right, 0, 0, null, czVar, this, true);
        onDraw(ayVar);
        textPaint.reset();
        textPaint.setAntiAlias(true);
        float dimension = context.getResources().getDimension(R.dimen.timeline3_itemCornerRadius);
        float dimension2 = context.getResources().getDimension(R.dimen.timeline3_itemBorderInset);
        textPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Path path = new Path();
        path.addRect(0.0f, 0.0f, i2, i3, Path.Direction.CW);
        path.addRoundRect(new RectF(dimension2, dimension2, i2 - dimension2, i3 - dimension2), dimension, dimension, Path.Direction.CW);
        path.setFillType(Path.FillType.EVEN_ODD);
        canvas.drawPath(path, textPaint);
        if (i4 > i2) {
            textPaint.reset();
            textPaint.setAntiAlias(true);
            textPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            textPaint.setShader(new LinearGradient(i2, 0.0f, (i2 * 3) / 4, 0.0f, 0, -1, Shader.TileMode.CLAMP));
            canvas.drawRect(0.0f, 0.0f, i2, i3, textPaint);
        }
        return createBitmap;
    }

    public Bitmap getDragBitmap(Context context, int i2, int i3, float f2) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF(0.0f, 0.0f, i2, i3);
        RectF rectF2 = new RectF();
        Paint paint = new Paint();
        drawInCanvas(context, canvas, rectF, rectF2, paint, false, false, f2, null, false, rectF.right, 0, 0, null, new da(this));
        Bitmap createBitmap2 = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap2);
        paint.reset();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setShadowLayer(3.0f, 0.0f, 0.0f, 2130706432);
        canvas2.drawBitmap(createBitmap, 0.0f, 0.0f, paint);
        return createBitmap2;
    }

    public void trimBorderForDragShadow(com.nexstreaming.kinemaster.ui.projectedit.ay ayVar, int i2, int i3, int i4, int i5) {
        if (ayVar.i()) {
            TextPaint e2 = ayVar.e();
            Canvas b2 = ayVar.b();
            RectF c2 = ayVar.c();
            int a2 = ayVar.a(2.0f);
            int a3 = ayVar.a(2.0f);
            e2.reset();
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            b2.saveLayer(c2, paint, 31);
            b2.drawRoundRect(new RectF(i2 + a2, i3 + a2, i4 - a2, i5 - a2), a3, a3, e2);
            b2.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void wasRemovedFromTimeline(NexTimeline nexTimeline) {
        if (this.f4494a == nexTimeline) {
            this.f4494a = null;
        } else if (this.f4494a != null) {
            throw new IllegalStateException("Attempt to add item to a timeline it doesn't belong to");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void wasAddedToTimeline(NexTimeline nexTimeline) {
        if (this.f4494a != nexTimeline) {
            if (this.f4494a != null) {
                throw new IllegalStateException("Cannot link to multiple timelines");
            }
            this.f4494a = nexTimeline;
        }
    }

    public final NexTimeline getTimeline() {
        if (this.f4494a == null) {
        }
        return this.f4494a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void requestTimelineCalcTimes() {
        if (this.f4494a != null) {
            this.f4494a.requestCalcTimes();
        }
    }

    public Class<? extends kp> getOptionMenuClass() {
        return es.class;
    }

    public void onThemeChanged(Theme theme, EffectLibrary effectLibrary) {
    }

    public void onTimelineLoaded(EffectLibrary effectLibrary, int i2) {
    }

    public MSID getMediaMSID() {
        return null;
    }

    public void clearDrawingCache() {
    }

    public String getDescriptiveTitle(Context context) {
        return null;
    }

    public String getDescriptiveSubtitle(Context context) {
        return null;
    }

    public int getAudioTrackUsage() {
        return 0;
    }

    public int getVideoTrackUsage() {
        return 0;
    }

    public int getVideoCodecMemoryUsage() {
        return 0;
    }
}
