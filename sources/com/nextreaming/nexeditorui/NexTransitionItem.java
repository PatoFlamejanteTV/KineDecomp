package com.nextreaming.nexeditorui;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.EmbossMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.Log;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import com.nexstreaming.kinemaster.kmpackage.ThemeEffectType;
import com.nexstreaming.kinemaster.kmpackage.TransitionEffectAutoSelectContext;
import com.nexstreaming.kinemaster.project.ProjectDependency;
import com.nexstreaming.kinemaster.ui.projectedit.kp;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes.dex */
public class NexTransitionItem extends NexPrimaryTimelineItem implements NexTimelineItem.j {

    /* renamed from: a */
    private static final int[] f4495a = {R.attr.state_selected, R.attr.state_enabled};
    private static final int[] b = {R.attr.state_enabled};
    private static MaskFilter c = new EmbossMaskFilter(new float[]{3.0f, -3.0f, 5.0f}, 0.6f, 15.0f, 3.0f);
    private static final long serialVersionUID = 2;
    private ThemeEffectType m_autoThemeEffect;
    private HashMap<String, String> m_effectOptions;
    private String m_transitionEffectID;
    private String m_captureFilename = null;
    private int m_transitionDuration = 2000;
    private int m_transitionEngineDuration = 2000;
    private int m_transitionOverlapPercent = 100;
    private int m_transitionOffsetPercent = 100;
    private boolean m_disabled = false;
    private int m_durationLimit = Integer.MAX_VALUE;
    private boolean m_allowOverlap = false;

    public NexTransitionItem() {
        this.m_transitionEffectID = null;
        this.m_transitionEffectID = "none";
        updateOffsetOverlap();
    }

    NexTransitionItem(String str) {
        this.m_transitionEffectID = null;
        this.m_transitionEffectID = str;
        updateOffsetOverlap();
    }

    public int[] getTimeOptions() {
        return getTimeOptions(Integer.MAX_VALUE);
    }

    public int[] getTimeOptions(int i) {
        ArrayList arrayList = new ArrayList(9);
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = ((i2 * 29900) / 9) + 100;
            int i4 = i3 - (i3 % 2000);
            if (i4 < 100) {
                i4 = 100;
            }
            if (i4 > 30000) {
                i4 = 30000;
            }
            if (i4 <= i) {
                arrayList.add(Integer.valueOf(i4));
            }
        }
        return com.nexstreaming.app.general.util.l.a(arrayList);
    }

    public int getMaximumDuration() {
        int i;
        int i2 = 0;
        updateDurationLimit();
        int i3 = 0;
        while (true) {
            i = i2;
            if (i3 >= 9) {
                break;
            }
            int i4 = ((i3 * 29900) / 9) + 100;
            i2 = i4 - (i4 % 2000);
            if (i2 < 100) {
                i2 = 100;
            }
            if (i2 > 30000) {
                i2 = 30000;
            }
            if (i2 > getDurationLimit()) {
                break;
            }
            if (i2 > getDurationLimit()) {
                i2 = i;
            }
            i3++;
        }
        return i;
    }

    public void updateDurationLimit() {
        int i;
        NexTimeline timeline = getTimeline();
        if (timeline != null) {
            int indexOfPrimaryItem = timeline.getIndexOfPrimaryItem(this);
            if (indexOfPrimaryItem >= 1 && indexOfPrimaryItem < timeline.getPrimaryItemCount() - 1) {
                NexPrimaryTimelineItem primaryItem = timeline.getPrimaryItem(indexOfPrimaryItem - 1);
                NexPrimaryTimelineItem primaryItem2 = timeline.getPrimaryItem(indexOfPrimaryItem + 1);
                if (primaryItem != null && (primaryItem instanceof NexVideoClipItem) && primaryItem2 != null && (primaryItem2 instanceof NexVideoClipItem)) {
                    NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) primaryItem;
                    NexVideoClipItem nexVideoClipItem2 = (NexVideoClipItem) primaryItem2;
                    int duration = (((((nexVideoClipItem.getDuration() - nexVideoClipItem.getTrimTimeStart()) - nexVideoClipItem.getTrimTimeEnd()) * 100) / nexVideoClipItem.getPlaybackSpeed()) - nexVideoClipItem.getStartOverlap()) - 750;
                    int duration2 = (((((nexVideoClipItem2.getDuration() - nexVideoClipItem2.getTrimTimeStart()) - nexVideoClipItem2.getTrimTimeEnd()) * 100) / nexVideoClipItem2.getPlaybackSpeed()) - nexVideoClipItem2.getEndOverlap()) - 750;
                    int i2 = 30000 > duration ? duration : 30000;
                    if (i2 <= duration2) {
                        duration2 = i2;
                    }
                    i = duration2 + (((100 - this.m_transitionOverlapPercent) * duration2) / 100);
                    if (((!nexVideoClipItem.isImage() && nexVideoClipItem.getHeight() >= 1000) || (!nexVideoClipItem2.isImage() && nexVideoClipItem2.getHeight() >= 1000)) && i > NexEditorDeviceProfile.getDeviceProfile().getFullHDMaxTransitionTime()) {
                        i = NexEditorDeviceProfile.getDeviceProfile().getFullHDMaxTransitionTime();
                    }
                    this.m_allowOverlap = nexVideoClipItem.isImage() || nexVideoClipItem2.isImage() || NexEditorDeviceProfile.getDeviceProfile().allowOverlappingVideo();
                    if (!this.m_allowOverlap && this.m_transitionOverlapPercent > 0) {
                        i = 0;
                    }
                    this.m_durationLimit = i;
                    if (this.m_transitionOverlapPercent <= 0) {
                    }
                }
            }
            i = 30000;
            this.m_durationLimit = i;
            if (this.m_transitionOverlapPercent <= 0) {
            }
        }
    }

    public int getDurationLimit() {
        updateDurationLimit();
        return this.m_durationLimit;
    }

    public void checkForChangedOverlap() {
        EffectLibrary q = EditorGlobal.a().q();
        if (q == null) {
            Log.d("NexTransitionItem", "checkForChangedOverlap failed : null effect library");
            return;
        }
        com.nexstreaming.kinemaster.kmpackage.at b2 = q.b(this.m_transitionEffectID);
        if (b2 == null) {
            Log.d("NexTransitionItem", "checkForChangedOverlap failed : null transition");
        } else {
            if (b2.p() != this.m_transitionOverlapPercent) {
            }
        }
    }

    public void updateOffsetOverlap() {
        if (this.m_transitionEffectID != null) {
            EffectLibrary q = EditorGlobal.a().q();
            com.nexstreaming.kinemaster.kmpackage.at b2 = q.b(this.m_transitionEffectID);
            if (b2 == null) {
                b2 = q.b("none");
            }
            if (b2 == null) {
                this.m_transitionOffsetPercent = 0;
                this.m_transitionOverlapPercent = 0;
                return;
            } else {
                this.m_transitionOffsetPercent = b2.o();
                this.m_transitionOverlapPercent = b2.p();
                return;
            }
        }
        this.m_transitionOffsetPercent = 0;
        this.m_transitionOverlapPercent = 0;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public NexTransitionItem getTransition() {
        return this;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public int getPixelWidth(float f, float f2) {
        int representedDuration = (int) ((getRepresentedDuration() * f) / 1000.0f);
        int max = (int) ((Math.max(getRepresentedDuration(), 750) * f) / 1000.0f);
        if (representedDuration >= 35.0f * f2) {
            return representedDuration;
        }
        if (Math.max(representedDuration, max) >= 15.0f * f2) {
            return (int) (35.0f * f2);
        }
        return Math.max((int) ((35.0f * f2) - (((15.0f * f2) - representedDuration) * 2.0f)), (int) (1.0f * f2));
    }

    public boolean isSet() {
        return (this.m_transitionEffectID == null || this.m_transitionEffectID.equals("none") || this.m_disabled) ? false : true;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getRepresentedDuration() {
        if (isSet()) {
            return getDuration();
        }
        return 0;
    }

    public NexVideoClipItem getLeftClip() {
        int indexOfPrimaryItem;
        NexTimeline timeline = getTimeline();
        if (timeline != null && (indexOfPrimaryItem = timeline.getIndexOfPrimaryItem(this)) >= 0) {
            return (NexVideoClipItem) timeline.getPrimaryItem(indexOfPrimaryItem - 1);
        }
        return null;
    }

    public NexVideoClipItem getRightClip() {
        int indexOfPrimaryItem;
        NexTimeline timeline = getTimeline();
        if (timeline != null && (indexOfPrimaryItem = timeline.getIndexOfPrimaryItem(this)) >= 0) {
            return (NexVideoClipItem) timeline.getPrimaryItem(indexOfPrimaryItem + 1);
        }
        return null;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onDraw(com.nexstreaming.kinemaster.ui.projectedit.ay ayVar) {
        Drawable drawable;
        boolean z;
        Drawable bitmapDrawable;
        Bitmap smallThumbnailForTime;
        int width;
        Bitmap smallThumbnailForTime2;
        int width2;
        boolean f = ayVar.f();
        RectF d = ayVar.d();
        TextPaint e = ayVar.e();
        Canvas b2 = ayVar.b();
        RectF c2 = ayVar.c();
        float j = ayVar.j();
        e.setAntiAlias(true);
        if (EditorGlobal.a() == null) {
            drawable = ayVar.getResources().getDrawable(com.nexstreaming.app.kinemasterfree.R.drawable.n3_transition_none);
            z = false;
        } else if (isSet()) {
            com.nexstreaming.kinemaster.kmpackage.at b3 = EditorGlobal.a().q().b(this.m_transitionEffectID);
            if (getTransitionEffectAutoType() == ThemeEffectType.TRANSITION) {
                bitmapDrawable = ayVar.getResources().getDrawable(com.nexstreaming.app.kinemasterfree.R.drawable.n3_transition_none);
            } else {
                Bitmap c3 = b3 != null ? b3.c(ayVar) : null;
                if (c3 == null) {
                    bitmapDrawable = ayVar.getResources().getDrawable(com.nexstreaming.app.kinemasterfree.R.drawable.n3_transition_none);
                } else {
                    bitmapDrawable = new BitmapDrawable(ayVar.getResources(), c3);
                }
            }
            z = true;
            drawable = bitmapDrawable;
        } else {
            drawable = ayVar.getResources().getDrawable(com.nexstreaming.app.kinemasterfree.R.drawable.n3_transition_none);
            z = false;
        }
        Drawable drawable2 = ayVar.getResources().getDrawable(f ? com.nexstreaming.app.kinemasterfree.R.drawable.n3_transbtn_sel : com.nexstreaming.app.kinemasterfree.R.drawable.n3_transbtn_nor);
        float min = Math.min(ayVar.getResources().getDimension(com.nexstreaming.app.kinemasterfree.R.dimen.timeline_transition_icon_large_size), (c2.height() * 3.0f) / 4.0f);
        float min2 = Math.min(ayVar.getResources().getDimension(com.nexstreaming.app.kinemasterfree.R.dimen.timeline_transition_icon_small_size), (4.0f * min) / 5.0f);
        float f2 = min / 2.0f;
        d.top = c2.centerY() - f2;
        d.bottom = c2.centerY() + f2;
        d.left = c2.centerX() - f2;
        d.right = f2 + c2.centerX();
        d.intersect(c2);
        if (d.width() < d.height()) {
            float centerY = d.centerY();
            float width3 = d.width();
            d.top = centerY - (width3 / 2.0f);
            d.bottom = centerY + (width3 / 2.0f);
        }
        int i = (int) ((d.left - c2.left) / j);
        if (i > 10) {
            NexVideoClipItem leftClip = getLeftClip();
            NexVideoClipItem rightClip = getRightClip();
            int absStartTime = getAbsStartTime();
            int absEndTime = getAbsEndTime() - absStartTime;
            float f3 = 2.0f * j;
            e.setStyle(Paint.Style.FILL);
            Path path = new Path();
            float width4 = c2.width();
            if (leftClip != null) {
                if (leftClip.isPreset()) {
                    e.setColor(leftClip.getSolidColor());
                    e.setAlpha(Math.min(i - 10, 24));
                    path.rewind();
                    path.moveTo(c2.left + f3, c2.bottom - f3);
                    path.lineTo(c2.left + f3, c2.top);
                    path.lineTo(d.left, d.top + f3);
                    path.lineTo(d.left, d.bottom - f3);
                    path.close();
                    path.setFillType(Path.FillType.EVEN_ODD);
                    b2.drawPath(path, e);
                } else if (b2.isHardwareAccelerated()) {
                    e.setColor(872415231);
                    e.setAlpha(Math.min(i - 10, 24));
                    path.rewind();
                    path.moveTo(c2.left + f3, c2.bottom - f3);
                    path.lineTo(c2.left + f3, c2.top);
                    path.lineTo(d.left, d.top + f3);
                    path.lineTo(d.left, d.bottom - f3);
                    path.close();
                    path.setFillType(Path.FillType.EVEN_ODD);
                    b2.drawPath(path, e);
                } else {
                    b2.saveLayerAlpha(c2, Math.min((i - 10) * 3, 128), 31);
                    float f4 = c2.left;
                    float centerY2 = c2.centerY();
                    float height = c2.height();
                    float height2 = d.height();
                    while (true) {
                        float f5 = f4;
                        if (f5 >= d.left || (smallThumbnailForTime2 = leftClip.getSmallThumbnailForTime((int) (absStartTime + (((f5 - c2.left) * absEndTime) / width4)), c2.height(), j, ayVar, ayVar.a())) == null || (width2 = (smallThumbnailForTime2.getWidth() * 3) / 4) < 1) {
                            break;
                        }
                        int i2 = ((int) ((((f5 - c2.left) * (height2 - height)) / width4) + height)) / 2;
                        int i3 = ((int) (((((f5 - c2.left) + width2) * (height2 - height)) / width4) + height)) / 2;
                        e.setFilterBitmap(true);
                        e.setColor(-1);
                        b2.drawBitmapMesh(smallThumbnailForTime2, 1, 1, new float[]{f5, centerY2 - i2, width2 + f5, centerY2 - i3, f5, i2 + centerY2, width2 + f5, i3 + centerY2}, 0, null, 0, e);
                        f4 = width2 + f5;
                    }
                    path.rewind();
                    path.moveTo(c2.left + f3, c2.bottom - f3);
                    path.lineTo(c2.left + f3, c2.top);
                    path.lineTo(d.left, d.top + f3);
                    path.lineTo(d.left, d.bottom - f3);
                    path.close();
                    path.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                    e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                    e.setColor(0);
                    b2.drawPath(path, e);
                    e.setXfermode(null);
                    b2.restore();
                }
            } else {
                e.setColor(859190086);
                e.setAlpha(Math.min(i - 10, 24));
                path.rewind();
                path.moveTo(c2.left + f3, c2.bottom - f3);
                path.lineTo(c2.left + f3, c2.top);
                path.lineTo(d.left, d.top + f3);
                path.lineTo(d.left, d.bottom - f3);
                path.close();
                path.setFillType(Path.FillType.EVEN_ODD);
                b2.drawPath(path, e);
            }
            if (rightClip != null) {
                if (rightClip.isPreset()) {
                    e.setColor(rightClip.getSolidColor());
                    e.setAlpha(Math.min(i - 10, 24));
                    path.rewind();
                    path.moveTo(c2.right - (2.0f * f3), c2.top);
                    path.lineTo(c2.right - (2.0f * f3), c2.bottom - f3);
                    path.lineTo(d.right, d.bottom - f3);
                    path.lineTo(d.right, d.top + f3);
                    path.setFillType(Path.FillType.EVEN_ODD);
                    path.close();
                    b2.drawPath(path, e);
                } else if (b2.isHardwareAccelerated()) {
                    e.setColor(859190086);
                    e.setAlpha(Math.min(i - 10, 24));
                    path.rewind();
                    path.moveTo(c2.right - (2.0f * f3), c2.top);
                    path.lineTo(c2.right - (2.0f * f3), c2.bottom - f3);
                    path.lineTo(d.right, d.bottom - f3);
                    path.lineTo(d.right, d.top + f3);
                    path.setFillType(Path.FillType.EVEN_ODD);
                    path.close();
                    b2.drawPath(path, e);
                } else {
                    b2.saveLayerAlpha(c2, Math.min((i - 10) * 3, 128), 31);
                    float f6 = c2.right;
                    float centerY3 = c2.centerY();
                    float height3 = c2.height();
                    float height4 = d.height();
                    while (true) {
                        float f7 = f6;
                        if (f7 <= d.right || (smallThumbnailForTime = rightClip.getSmallThumbnailForTime((int) (absStartTime + (((f7 - c2.right) * absEndTime) / width4)), c2.height(), j, ayVar, ayVar.a())) == null || (width = (smallThumbnailForTime.getWidth() * 3) / 4) < 1) {
                            break;
                        }
                        int i4 = ((int) ((((c2.right - (f7 - width)) * (height4 - height3)) / width4) + height3)) / 2;
                        int i5 = ((int) ((((c2.right - f7) * (height4 - height3)) / width4) + height3)) / 2;
                        e.setFilterBitmap(true);
                        e.setColor(-1);
                        b2.drawBitmapMesh(smallThumbnailForTime, 1, 1, new float[]{f7 - width, centerY3 - i4, f7, centerY3 - i5, f7 - width, i4 + centerY3, f7, i5 + centerY3}, 0, null, 0, e);
                        f6 = f7 - width;
                    }
                    path.rewind();
                    path.moveTo(c2.right - (2.0f * f3), c2.top);
                    path.lineTo(c2.right - (2.0f * f3), c2.bottom - f3);
                    path.lineTo(d.right, d.bottom - f3);
                    path.lineTo(d.right, d.top + f3);
                    path.close();
                    path.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                    e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                    e.setColor(0);
                    b2.drawPath(path, e);
                    e.setXfermode(null);
                    b2.restore();
                }
            } else {
                e.setColor(-1);
                e.setAlpha(Math.min(i - 10, 24));
                path.rewind();
                path.moveTo(c2.right - (2.0f * f3), c2.top);
                path.lineTo(c2.right - (2.0f * f3), c2.bottom - f3);
                path.lineTo(d.right, d.bottom - f3);
                path.lineTo(d.right, d.top + f3);
                path.setFillType(Path.FillType.EVEN_ODD);
                path.close();
                b2.drawPath(path, e);
            }
        }
        Rect rect = new Rect();
        drawable2.setAlpha(255);
        drawable.setAlpha(255);
        float width5 = d.width();
        if (width5 >= min2) {
            if (width5 < min) {
                int i6 = (int) (((width5 - min2) / (min - min2)) * 255.0f);
                drawable2.setAlpha(i6);
                drawable.setAlpha(i6);
            }
            drawable2.setBounds((int) d.left, (int) d.top, (int) d.right, (int) d.bottom);
            drawable2.draw(b2);
            drawable2.getPadding(rect);
            d.left += rect.left;
            d.top += rect.top;
            d.right -= rect.right;
            d.bottom -= rect.bottom;
            Bitmap bitmap = null;
            if (z && (drawable instanceof BitmapDrawable)) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
            }
            if (bitmap != null && !z) {
                e.reset();
                e.setFilterBitmap(true);
                e.setAntiAlias(true);
                b2.saveLayerAlpha(d, 255, 31);
                e.setColorFilter(new PorterDuffColorFilter(-3192246, PorterDuff.Mode.SRC_IN));
                b2.drawBitmap(bitmap, (Rect) null, d, e);
                d.offset(1.0f * j, 1.0f * j);
                e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
                e.setMaskFilter(new BlurMaskFilter(3.0f, BlurMaskFilter.Blur.NORMAL));
                e.setColorFilter(new PorterDuffColorFilter(-42149, PorterDuff.Mode.SRC_IN));
                b2.drawBitmap(bitmap, (Rect) null, d, e);
                b2.restore();
                return;
            }
            if (drawable != null) {
                drawable.setBounds((int) d.left, (int) d.top, (int) d.right, (int) d.bottom);
                drawable.draw(b2);
            }
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void drawInCanvas(Context context, Canvas canvas, RectF rectF, RectF rectF2, Paint paint, boolean z, boolean z2, float f, NexTimelineItem.h hVar, boolean z3, float f2, int i, int i2, List<ef> list, NexTimelineItem.p pVar) {
        throw new IllegalStateException();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getDuration() {
        if (isSet()) {
            return this.m_transitionDuration;
        }
        return 0;
    }

    public int getEngineDuration() {
        if (isSet()) {
            return this.m_transitionEngineDuration;
        }
        return 0;
    }

    public int getTransitionOverlapPercent() {
        return this.m_transitionOverlapPercent;
    }

    public int getTransitionOffsetPercent() {
        return this.m_transitionOffsetPercent;
    }

    public int getTransitionOverlap() {
        if (isSet()) {
            return (this.m_transitionDuration * this.m_transitionOverlapPercent) / 100;
        }
        return 0;
    }

    public int getTransitionOffset() {
        if (isSet()) {
            return (this.m_transitionDuration * this.m_transitionOffsetPercent) / 100;
        }
        return 0;
    }

    public boolean ensureTransitionFits() {
        int i = this.m_transitionEngineDuration;
        int i2 = this.m_transitionDuration;
        if (!isSet()) {
            this.m_disabled = true;
        }
        updateDurationLimit();
        if (this.m_transitionDuration < 100) {
            this.m_transitionDuration = 100;
        }
        if (this.m_transitionDuration > 30000) {
            this.m_transitionDuration = 30000;
        }
        if (this.m_transitionDuration > this.m_durationLimit) {
            this.m_transitionDuration = this.m_durationLimit;
        }
        if (this.m_transitionDuration < 100) {
            this.m_disabled = true;
        }
        if (!isSet()) {
            this.m_transitionEngineDuration = 0;
        } else {
            this.m_transitionEngineDuration = this.m_transitionDuration;
        }
        return (i == this.m_transitionEngineDuration && i2 == this.m_transitionDuration) ? false : true;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void setDuration(int i) {
        this.m_transitionDuration = i;
        ensureTransitionFits();
    }

    public String getTransitionEffectID() {
        return this.m_transitionEffectID;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem, com.nextreaming.nexeditorui.NexTimelineItem.j
    public String getEffectID() {
        return this.m_transitionEffectID;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.j
    public int getEffectDuration() {
        return getDuration();
    }

    public ThemeEffectType getTransitionEffectAutoType() {
        return this.m_autoThemeEffect;
    }

    @Deprecated
    public void setTransitionEffectAutoType(Theme theme, ThemeEffectType themeEffectType) {
        throw new IllegalStateException();
    }

    public void setTransitionEffectID(String str) {
        if (this.m_autoThemeEffect != null) {
            throw new IllegalStateException();
        }
        if (this.m_transitionEffectID == null || !this.m_transitionEffectID.equals(str)) {
            this.m_transitionEffectID = str;
            this.m_disabled = false;
            ensureTransitionFits();
            updateOffsetOverlap();
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public NexTimelineItem.i onLongPress(Context context, NexTimelineItem.t tVar, RectF rectF, int i, int i2, boolean z, int i3) {
        return null;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public NexTimelineItem.i onDown(Context context, NexTimelineItem.t tVar, RectF rectF, int i, int i2, boolean z, int i3) {
        return null;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean onShowItemMenu(Context context, int i, int i2, int i3, int i4, int i5, NexTimelineItem.n nVar) {
        return false;
    }

    public void clearTransitionEffect() {
        this.m_transitionEffectID = "none";
        ensureTransitionFits();
    }

    @Deprecated
    public void setEnabled(boolean z) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public boolean getEnabled() {
        return !isSet();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void removeRequiredOverlaysFromDeleteSet(Set<String> set) {
        if (this.m_captureFilename != null) {
            set.remove(this.m_captureFilename);
        }
        if (this.m_effectOptions != null && !this.m_effectOptions.isEmpty()) {
            for (Map.Entry<String, String> entry : this.m_effectOptions.entrySet()) {
                if (entry.getKey().startsWith("overlay:")) {
                    String value = entry.getValue();
                    int lastIndexOf = value.lastIndexOf(32);
                    if (lastIndexOf >= 0) {
                        value = value.substring(lastIndexOf + 1);
                    }
                    set.remove(value);
                }
            }
        }
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public String getCaptureFilename() {
        return this.m_captureFilename;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public void setCaptureFilename(String str) {
        this.m_captureFilename = str;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public void onDuplicated(int i) {
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onThemeChanged(Theme theme, EffectLibrary effectLibrary) {
        if ("themeEffect".equals(this.m_transitionEffectID)) {
            this.m_transitionEffectID = null;
            this.m_autoThemeEffect = ThemeEffectType.TRANSITION;
        } else if (this.m_transitionEffectID != null && !this.m_transitionEffectID.contains(".") && !this.m_transitionEffectID.equals("none")) {
            String[][] strArr = {new String[]{"none", "none"}, new String[]{"flip", "com.nexstreaming.kinemaster.builtin.transition.flip"}, new String[]{"checker", "com.nexstreaming.kinemaster.builtin.transition.checker"}, new String[]{"Crossfade", "com.nexstreaming.kinemaster.builtin.transition.crossfade"}, new String[]{"fadecolor", "com.nexstreaming.kinemaster.builtin.transition.fadethroughcolor"}, new String[]{"fadewhite", "com.nexstreaming.kinemaster.builtin.transition.fadethroughwhite"}, new String[]{"PIP", "com.nexstreaming.kinemaster.builtin.transition.pip.corners"}, new String[]{"PIP2", "com.nexstreaming.kinemaster.builtin.transition.pip.inset"}, new String[]{"PIP3", "com.nexstreaming.kinemaster.builtin.transition.pip.splitscn"}, new String[]{"PIP4", "com.nexstreaming.kinemaster.builtin.transition.pip.tiles"}, new String[]{"PIP5", "com.nexstreaming.kinemaster.builtin.transition.pip.colortiles"}, new String[]{"Slide Left", "com.nexstreaming.kinemaster.builtin.transition.slideleft"}, new String[]{"Slide Right", "com.nexstreaming.kinemaster.builtin.transition.slideright"}, new String[]{"strips", "com.nexstreaming.kinemaster.builtin.transition.strips"}, new String[]{"zoominout", "com.nexstreaming.kinemaster.builtin.transition.zoominout"}, new String[]{"zoomout", "com.nexstreaming.kinemaster.builtin.transition.zoomout"}, new String[]{"zoomflip", "com.nexstreaming.kinemaster.builtin.transition.zoomflip"}};
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String[] strArr2 = strArr[i];
                if (!strArr2[0].equals(this.m_transitionEffectID)) {
                    i++;
                } else {
                    this.m_transitionEffectID = strArr2[1];
                    break;
                }
            }
        }
        a(theme);
        ensureTransitionFits();
        updateOffsetOverlap();
        super.onThemeChanged(theme, effectLibrary);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public KMProto.KMProject.TimelineItem asProtoBuf() {
        KMProto.KMProject.Transition.Builder builder = new KMProto.KMProject.Transition.Builder();
        builder.captureFilename = this.m_captureFilename;
        builder.transition_effect_id = this.m_transitionEffectID;
        if (this.m_autoThemeEffect != null) {
            builder.auto_theme_effect = this.m_autoThemeEffect.asProtoBuf();
        }
        return new KMProto.KMProject.TimelineItem.Builder().clip_type(KMProto.KMProject.ClipType.TRANSITION).unique_id_lsb(Long.valueOf(getUniqueId().getLeastSignificantBits())).unique_id_msb(Long.valueOf(getUniqueId().getMostSignificantBits())).transition(builder.transition_duration(Integer.valueOf(this.m_transitionDuration)).transition_engine_duration(Integer.valueOf(this.m_transitionEngineDuration)).transition_offset_percent(Integer.valueOf(this.m_transitionOffsetPercent)).transition_overlap_percent(Integer.valueOf(this.m_transitionOverlapPercent)).disabled(Boolean.valueOf(this.m_disabled)).minimum_duration(100).maximum_duration(30000).effect_options(com.nexstreaming.kinemaster.c.a.a(this.m_effectOptions)).duration_limit(Integer.valueOf(this.m_durationLimit)).allow_overlap(Boolean.valueOf(this.m_allowOverlap)).build()).build();
    }

    public static NexTransitionItem fromProtoBuf(KMProto.KMProject.TimelineItem timelineItem) {
        NexTransitionItem nexTransitionItem = new NexTransitionItem();
        nexTransitionItem.setUniqueId(new UUID(timelineItem.unique_id_msb.longValue(), timelineItem.unique_id_lsb.longValue()));
        KMProto.KMProject.Transition transition = timelineItem.transition;
        nexTransitionItem.m_captureFilename = transition.captureFilename;
        nexTransitionItem.m_transitionEffectID = transition.transition_effect_id;
        nexTransitionItem.m_autoThemeEffect = ThemeEffectType.fromProtoBuf(transition.auto_theme_effect);
        nexTransitionItem.m_transitionDuration = transition.transition_duration.intValue();
        nexTransitionItem.m_transitionEngineDuration = transition.transition_engine_duration.intValue();
        nexTransitionItem.m_transitionOffsetPercent = transition.transition_offset_percent.intValue();
        nexTransitionItem.m_transitionOverlapPercent = transition.transition_overlap_percent.intValue();
        nexTransitionItem.m_disabled = transition.disabled.booleanValue();
        nexTransitionItem.m_effectOptions = com.nexstreaming.kinemaster.c.a.a(transition.effect_options);
        nexTransitionItem.m_durationLimit = transition.duration_limit.intValue();
        nexTransitionItem.m_allowOverlap = transition.allow_overlap.booleanValue();
        return nexTransitionItem;
    }

    public String effectIdByContextForTheme(Theme theme) {
        return effectIdByContextForTheme(theme, null);
    }

    public String effectIdByContextForTheme(Theme theme, ThemeEffectType themeEffectType) {
        NexVideoClipItem leftClip = getLeftClip();
        NexVideoClipItem rightClip = getRightClip();
        TransitionEffectAutoSelectContext transitionEffectAutoSelectContext = new TransitionEffectAutoSelectContext();
        transitionEffectAutoSelectContext.effectDuration = getDuration() / 1000.0d;
        transitionEffectAutoSelectContext.endTime = getAbsEndTime() / 1000.0d;
        transitionEffectAutoSelectContext.index = getTimeline().getIndexOfPrimaryItem(this) / 2;
        transitionEffectAutoSelectContext.leftClipDuration = leftClip.getDuration() / 1000.0d;
        transitionEffectAutoSelectContext.leftClipHasText = leftClip.hasText();
        transitionEffectAutoSelectContext.leftClipIndex = transitionEffectAutoSelectContext.index;
        if (leftClip.isImage()) {
            transitionEffectAutoSelectContext.getClass();
            transitionEffectAutoSelectContext.leftClipType = 2;
        } else if (leftClip.isPreset()) {
            transitionEffectAutoSelectContext.getClass();
            transitionEffectAutoSelectContext.leftClipType = 3;
        } else {
            transitionEffectAutoSelectContext.getClass();
            transitionEffectAutoSelectContext.leftClipType = 1;
        }
        transitionEffectAutoSelectContext.numberOfClips = (getTimeline().getPrimaryItemCount() + 1) / 2;
        transitionEffectAutoSelectContext.lastClip = transitionEffectAutoSelectContext.numberOfClips;
        transitionEffectAutoSelectContext.projectDuration = getTimeline().getTotalTime();
        transitionEffectAutoSelectContext.rightClipDuration = rightClip.getDuration() / 1000.0d;
        transitionEffectAutoSelectContext.rightClipHasText = rightClip.hasText();
        transitionEffectAutoSelectContext.rightClipIndex = transitionEffectAutoSelectContext.index;
        if (rightClip.isImage()) {
            transitionEffectAutoSelectContext.getClass();
            transitionEffectAutoSelectContext.rightClipType = 2;
        } else if (rightClip.isPreset()) {
            transitionEffectAutoSelectContext.getClass();
            transitionEffectAutoSelectContext.rightClipType = 3;
        } else {
            transitionEffectAutoSelectContext.getClass();
            transitionEffectAutoSelectContext.rightClipType = 1;
        }
        transitionEffectAutoSelectContext.startTime = getAbsStartTime() / 1000.0d;
        transitionEffectAutoSelectContext.versionCode = getTimeline().getAppVersionCode();
        NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
        transitionEffectAutoSelectContext.multisample = deviceProfile.getGLMultisample();
        transitionEffectAutoSelectContext.depthBits = deviceProfile.getGLDepthBufferBits();
        String a2 = theme.a(transitionEffectAutoSelectContext);
        if (a2 == null) {
            return theme.a(themeEffectType);
        }
        return a2;
    }

    private void a(Theme theme) {
        if (getTimeline() != null && this.m_autoThemeEffect != null) {
            this.m_transitionEffectID = effectIdByContextForTheme(theme, this.m_autoThemeEffect);
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onTimelineLoaded(EffectLibrary effectLibrary, int i) {
        super.onTimelineLoaded(effectLibrary, i);
        if (i == 3 && this.m_autoThemeEffect != null) {
            NexTimeline timeline = getTimeline();
            if (timeline != null) {
                Theme e = effectLibrary.e(timeline.getThemeId());
                if (e != null) {
                    this.m_transitionEffectID = effectIdByContextForTheme(e, this.m_autoThemeEffect);
                } else {
                    this.m_transitionEffectID = "none";
                }
            } else {
                this.m_transitionEffectID = "none";
            }
            this.m_autoThemeEffect = null;
        }
    }

    public boolean getAllowOverlap() {
        return this.m_allowOverlap;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem, com.nextreaming.nexeditorui.NexTimelineItem.j
    public Map<String, String> getEffectOptions() {
        if (this.m_effectOptions == null) {
            this.m_effectOptions = new HashMap<>();
        }
        return this.m_effectOptions;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean onCustomDrag(NexTimelineItem.h hVar, NexTimelineItem.t tVar, float f, float f2, float f3) {
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onCustomDragDone(NexTimelineItem.h hVar, NexTimelineItem.t tVar) {
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public int getEndOverlap() {
        return 0;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public int getStartOverlap() {
        return 0;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onCustomPostDrag(NexTimelineItem.h hVar, Rect rect) {
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public ResultTask<Bitmap> getThumbnail(Context context) {
        return null;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public ResultTask<Bitmap> getEndThumbnail(int i) {
        return null;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public ResultTask<Bitmap> getStartThumbnail(int i) {
        return null;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.j
    public void setEffect(com.nexstreaming.kinemaster.kmpackage.b bVar) {
        setTransitionEffectID(bVar == null ? "none" : bVar.a());
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Class<? extends kp> getOptionMenuClass() {
        return com.nexstreaming.kinemaster.ui.b.o.class;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void addDependencies(Set<ProjectDependency> set) {
        if (this.m_transitionEffectID != null && this.m_transitionEffectID.length() > 0 && !this.m_transitionEffectID.equals("none")) {
            set.add(ProjectDependency.b(this.m_transitionEffectID));
        }
    }
}
