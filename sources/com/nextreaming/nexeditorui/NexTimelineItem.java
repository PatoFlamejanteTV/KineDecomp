package com.nextreaming.nexeditorui;

import android.content.Context;
import android.content.ContextWrapper;
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
import android.view.View;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.FileType;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.editorwrapper.LayerMaskMode;
import com.nexstreaming.kinemaster.layer.BlendMode;
import com.nexstreaming.kinemaster.layer.SplitScreenType;
import com.nexstreaming.kinemaster.layer.handwriting.Stroke;
import com.nexstreaming.kinemaster.mediastore.MediaSupportType;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nexstreaming.kinemaster.project.ProjectDependency;
import com.nexstreaming.kinemaster.ui.projectedit.Bg;
import com.nexstreaming.kinemaster.ui.projectedit.C1916ib;
import com.nexstreaming.kinemaster.ui.projectedit.C1980pd;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2028i;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.UniformTimelineLayoutManager;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.UniformTimelineView;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.UUID;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: classes.dex */
public abstract class NexTimelineItem extends Observable implements Serializable, com.nexstreaming.kinemaster.editorwrapper.Fa, Fa.a, Fa.b {
    private static final long serialVersionUID = 9014758975387978513L;

    /* renamed from: a, reason: collision with root package name */
    private transient NexTimeline f24132a;
    private UUID m_uniqueId;

    /* loaded from: classes.dex */
    public interface a {
        int getAlpha();

        void setAlpha(int i);
    }

    /* loaded from: classes.dex */
    public interface b {
        String getEqualizer();

        String getVoiceChanger();

        void setEqualizer(String str);

        void setVoiceChanger(String str);
    }

    /* loaded from: classes.dex */
    public interface c {
        BlendMode getBlendMode();

        void setBlendMode(BlendMode blendMode);
    }

    /* loaded from: classes.dex */
    public interface d {
        float getChromaKeyBGClip();

        void getChromaKeyBlend(float[] fArr);

        int getChromaKeyColor();

        boolean getChromaKeyEnabled();

        float getChromaKeyFGClip();

        boolean getChromaKeyMaskEnabled();

        int[] getChromaKeyRecommendedColors();

        void setChromaKeyBGClip(float f2);

        void setChromaKeyBlend(float[] fArr);

        void setChromaKeyColor(int i);

        void setChromaKeyEnabled(boolean z);

        void setChromaKeyFGClip(float f2);

        void setChromaKeyMaskEnabled(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        int getAudioCompressor();

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
    public interface f {
        int getBrightness();

        int getContrast();

        int getSaturation();

        void setBrightness(int i);

        void setContrast(int i);

        void setSaturation(int i);
    }

    /* loaded from: classes.dex */
    public interface g {
        int getCombinedBrightness();

        int getCombinedContrast();

        int getCombinedSaturation();
    }

    /* loaded from: classes.dex */
    public interface h {
        ColorEffect getColorEffect();

        void setColorEffect(ColorEffect colorEffect);
    }

    /* loaded from: classes.dex */
    public static abstract class i extends k {
    }

    /* loaded from: classes.dex */
    public interface j {
        void addCMDrawingAction(com.nexstreaming.kinemaster.layer.handwriting.b bVar);

        void addCMEraseAll();

        void addCMStroke(Stroke stroke);

        List<com.nexstreaming.kinemaster.layer.handwriting.b> getCustomMaskDrawingActions();

        com.nexstreaming.kinemaster.layer.handwriting.b removeLastCMDrawingAction();
    }

    /* loaded from: classes.dex */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        public static final k f24133a = new k();

        /* renamed from: b, reason: collision with root package name */
        public static final k f24134b = new k();
    }

    /* loaded from: classes.dex */
    public interface l {
        int getEffectAssetIdx();

        String getEffectItemID();

        Map<String, String> getEffectOptions();

        void setEffectItem(com.nexstreaming.app.general.nexasset.assetpackage.r rVar);
    }

    /* loaded from: classes.dex */
    public interface m {
        float getStrengthValue();

        void setStrengthValue(float f2);
    }

    /* loaded from: classes.dex */
    public interface n {
        float getVariationhValue();

        void setVariationValue(float f2);
    }

    /* loaded from: classes.dex */
    public interface o {
        int getLayerMaskIndex();

        LayerMaskMode getLayerMaskMode();

        boolean isLayerMaskEnabled();

        void setLayerMaskEnabled(boolean z);

        void setLayerMaskIndex(int i);

        void setLayerMaskMode(LayerMaskMode layerMaskMode);
    }

    /* loaded from: classes.dex */
    public interface p {
    }

    /* loaded from: classes.dex */
    public interface q {
        int getMusicVolume();

        void setMusicVolume(int i);
    }

    /* loaded from: classes.dex */
    public interface r {
        void a(NexTimelineItem nexTimelineItem);

        void a(NexTimelineItem nexTimelineItem, NexTimelineItem nexTimelineItem2, NexTimelineItem nexTimelineItem3);
    }

    /* loaded from: classes.dex */
    public interface s {
        boolean getFlipH();

        boolean getFlipV();

        int getRotation();

        void setFlipH(boolean z);

        void setFlipV(boolean z);

        void setRotation(int i);
    }

    /* loaded from: classes.dex */
    public interface t {
        int getSplitScreenSize();

        SplitScreenType getSplitScreenType();

        void setSplitScreenType(SplitScreenType splitScreenType);
    }

    /* loaded from: classes.dex */
    public interface u {
        void trimToLeft(int i);

        void trimToRight(int i);
    }

    /* loaded from: classes.dex */
    public interface v {
    }

    /* loaded from: classes.dex */
    public interface w {
        int a(boolean z);

        void a(int i);

        void a(int i, boolean z);

        int getCurrentTime();

        NexTimeline getTimeline();
    }

    /* loaded from: classes.dex */
    public interface x<T> {
        String a();

        void a(int i);

        int b();

        void commit();

        T getItem();
    }

    /* loaded from: classes.dex */
    public static class y extends ContextWrapper {

        /* renamed from: a, reason: collision with root package name */
        private final UniformTimelineView f24135a;

        /* renamed from: b, reason: collision with root package name */
        private final UniformTimelineLayoutManager f24136b;

        public y(Context context, UniformTimelineView uniformTimelineView, UniformTimelineLayoutManager uniformTimelineLayoutManager) {
            super(context);
            this.f24135a = uniformTimelineView;
            this.f24136b = uniformTimelineLayoutManager;
        }

        public UniformTimelineLayoutManager a() {
            return this.f24136b;
        }
    }

    public void addDependencies(Collection<ProjectDependency> collection) {
    }

    public void applyFinalPath(MediaStoreItemId mediaStoreItemId, String str, NexVideoClipItem.CropMode cropMode, int i2) {
    }

    public abstract KMProto.KMProject.TimelineItem asProtoBuf();

    public x beginTrim(y yVar, int i2) {
        return null;
    }

    public void bindView(View view, InterfaceC2028i interfaceC2028i) {
    }

    public boolean checkResourceState(Context context) {
        return true;
    }

    public void clearDrawingCache() {
    }

    public void drawInCanvas(Context context, Canvas canvas, RectF rectF, RectF rectF2, Paint paint, boolean z, boolean z2, float f2, i iVar, boolean z3, float f3, int i2, int i3, List<ob> list, r rVar) {
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

    public abstract int getAbsEndTime();

    public abstract int getAbsStartTime();

    public int getAudioTrackUsage() {
        return 0;
    }

    public int getColorOption(int i2) {
        return 0;
    }

    public int getContentWeight() {
        return 0;
    }

    public String getDescriptiveSubtitle(Context context) {
        return null;
    }

    public String getDescriptiveTitle(Context context) {
        return null;
    }

    public Bitmap getDragBitmap(Context context, int i2, int i3, float f2) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF(0.0f, 0.0f, i2, i3);
        RectF rectF2 = new RectF();
        Paint paint = new Paint();
        drawInCanvas(context, canvas, rectF, rectF2, paint, false, false, f2, null, false, rectF.right, 0, 0, null, new Ra(this));
        Bitmap createBitmap2 = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap2);
        paint.reset();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setShadowLayer(3.0f, 0.0f, 0.0f, 2130706432);
        canvas2.drawBitmap(createBitmap, 0.0f, 0.0f, paint);
        return createBitmap2;
    }

    public Bitmap getDragBitmap_v3(Context context, int i2, int i3, int i4) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        float f2 = i3;
        RectF rectF = new RectF(0.0f, 0.0f, i4, f2);
        RectF rectF2 = new RectF();
        TextPaint textPaint = new TextPaint();
        r qa = new Qa(this);
        C1916ib c1916ib = new C1916ib(context);
        c1916ib.a(canvas, rectF, rectF2, textPaint, false, false, (i) null, false, rectF.right, 0, 0, (List<ob>) null, qa, this, true);
        onDraw(c1916ib);
        textPaint.reset();
        textPaint.setAntiAlias(true);
        float dimension = context.getResources().getDimension(R.dimen.timeline3_itemCornerRadius);
        float dimension2 = context.getResources().getDimension(R.dimen.timeline3_itemBorderInset);
        textPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Path path = new Path();
        float f3 = i2;
        path.addRect(0.0f, 0.0f, f3, f2, Path.Direction.CW);
        path.addRoundRect(new RectF(dimension2, dimension2, f3 - dimension2, f2 - dimension2), dimension, dimension, Path.Direction.CW);
        path.setFillType(Path.FillType.EVEN_ODD);
        canvas.drawPath(path, textPaint);
        if (i4 > i2) {
            textPaint.reset();
            textPaint.setAntiAlias(true);
            textPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            textPaint.setShader(new LinearGradient(f3, 0.0f, (i2 * 3) / 4, 0.0f, 0, -1, Shader.TileMode.CLAMP));
            canvas.drawRect(0.0f, 0.0f, f3, f2, textPaint);
        }
        return createBitmap;
    }

    public abstract int getDuration();

    public FileType.FileCategory getFileCategory() {
        return null;
    }

    public MediaStoreItemId getMediaMSID() {
        return null;
    }

    public MediaSupportType getMediaSupportType() {
        return MediaSupportType.Supported;
    }

    public Class<? extends Bg> getOptionMenuClass() {
        return C1980pd.class;
    }

    public int[] getOptionMenuItems() {
        return new int[0];
    }

    public abstract int getRepresentedDuration();

    public int getRepresentedDurationWithoutOverlap() {
        return getRepresentedDuration();
    }

    public boolean getSwitchOption(int i2) {
        return false;
    }

    public final NexTimeline getTimeline() {
        return this.f24132a;
    }

    public int getTimelineViewLayoutResource() {
        return R.layout.timeline_item_generic;
    }

    public int getUIEndTime() {
        return getAbsEndTime();
    }

    public int getUIStartTime() {
        return getAbsStartTime();
    }

    public final UUID getUniqueId() {
        if (this.m_uniqueId == null) {
            setUniqueId(UUID.randomUUID());
        }
        return this.m_uniqueId;
    }

    public int getVideoCodecExportMemoryUsage() {
        return 0;
    }

    public int getVideoCodecLegacyMemoryUsage() {
        return 0;
    }

    public int getVideoTrackUsage() {
        return 0;
    }

    public boolean hasDependencyFromAsset(String str) {
        return false;
    }

    public boolean isClipReady() {
        return true;
    }

    public boolean isDraggable() {
        return false;
    }

    public boolean isOptionApplied(int i2) {
        return false;
    }

    public boolean isReadyToPlay() {
        return true;
    }

    public boolean isTrimmable() {
        return false;
    }

    public abstract boolean onCustomDrag(i iVar, w wVar, float f2, float f3, float f4);

    public abstract void onCustomDragDone(i iVar, w wVar);

    public void onCustomDragDone_v3(i iVar, w wVar) {
        onCustomDragDone(iVar, wVar);
    }

    public boolean onCustomDrag_v3(i iVar, w wVar, float f2, float f3, float f4) {
        return onCustomDrag(iVar, wVar, f2, f3, f4);
    }

    public abstract void onCustomPostDrag(i iVar, Rect rect);

    public void onCustomPostDrag_v3(i iVar, Rect rect) {
        onCustomPostDrag(iVar, rect);
    }

    public abstract k onDown(Context context, w wVar, RectF rectF, int i2, int i3, boolean z, int i4);

    public void onDraw(C1916ib c1916ib) {
        drawInCanvas(c1916ib, c1916ib.a(), c1916ib.e(), c1916ib.k(), c1916ib.j(), c1916ib.p(), c1916ib.o(), c1916ib.i(), c1916ib.c(), c1916ib.m(), c1916ib.l(), c1916ib.d(), c1916ib.f(), c1916ib.b(), c1916ib.h());
    }

    public abstract k onLongPress(Context context, w wVar, RectF rectF, int i2, int i3, boolean z, int i4);

    public abstract boolean onShowItemMenu(Context context, int i2, int i3, int i4, int i5, int i6, p pVar);

    public void onTimelineLoaded() {
    }

    public void postNotification() {
        setChanged();
        notifyObservers();
    }

    public void removeRequiredOverlaysFromDeleteSet(Set<String> set) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void requestTimelineCalcTimes() {
        NexTimeline nexTimeline = this.f24132a;
        if (nexTimeline != null) {
            nexTimeline.requestCalcTimes();
        }
    }

    public void setColorOption(int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    public abstract void setDuration(int i2);

    public Task setSwitchOption(int i2, boolean z, Context context) {
        throw new UnsupportedOperationException();
    }

    public final void setUniqueId(UUID uuid) {
        this.m_uniqueId = uuid;
    }

    public void trimBorderForDragShadow(C1916ib c1916ib, int i2, int i3, int i4, int i5) {
        if (c1916ib.n()) {
            TextPaint j2 = c1916ib.j();
            Canvas a2 = c1916ib.a();
            RectF e2 = c1916ib.e();
            int a3 = c1916ib.a(2.0f);
            int a4 = c1916ib.a(2.0f);
            j2.reset();
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            a2.saveLayer(e2, paint, 31);
            float f2 = a4;
            a2.drawRoundRect(new RectF(i2 + a3, i3 + a3, i4 - a3, i5 - a3), f2, f2, j2);
            a2.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void wasAddedToTimeline(NexTimeline nexTimeline) {
        NexTimeline nexTimeline2 = this.f24132a;
        if (nexTimeline2 == nexTimeline) {
            return;
        }
        if (nexTimeline2 == null) {
            this.f24132a = nexTimeline;
            return;
        }
        throw new IllegalStateException("Cannot link to multiple timelines");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void wasRemovedFromTimeline(NexTimeline nexTimeline) {
        NexTimeline nexTimeline2 = this.f24132a;
        if (nexTimeline2 == nexTimeline) {
            this.f24132a = null;
        } else if (nexTimeline2 != null) {
            throw new IllegalStateException("Attempt to add item to a timeline it doesn't belong to");
        }
    }

    public void writeFCXML(XmlSerializer xmlSerializer) {
    }

    public void writeKMXML(XmlSerializer xmlSerializer) {
    }
}
