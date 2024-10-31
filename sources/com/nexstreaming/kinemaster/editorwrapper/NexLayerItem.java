package com.nexstreaming.kinemaster.editorwrapper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.LayerExpression;
import com.nexstreaming.kinemaster.layer.SplitScreenType;
import com.nexstreaming.kinemaster.ui.projectedit.nb;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.ColorEffect;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.ef;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class NexLayerItem extends NexSecondaryTimelineItem implements NexTimelineItem.a, NexTimelineItem.m, NexTimelineItem.q, NexTimelineItem.r, NexTimelineItem.s {
    private static Rect e = new Rect();
    private static b f = new b();

    /* renamed from: a, reason: collision with root package name */
    private transient float f3296a;
    private transient Rect b;
    private transient RectF c;
    private transient List<b> d;
    private int endTime;
    private int endTrim;
    private Object expressionState;
    private List<b> mKeyFrames;
    private String mLayerName;
    private b mSplitScreenKeyFrame;
    private boolean m_flipH;
    private boolean m_flipV;
    private SplitScreenType m_splitScreenType;
    private int m_splitSizeBottom;
    private int m_splitSizeLeft;
    private int m_splitSizeRight;
    private int m_splitSizeTop;
    private boolean pinned;
    private int startTime;
    private int startTrim;
    private long zOrder;
    private int mAlpha = 255;
    private boolean mLayerMaskEnabled = false;
    private LayerMaskMode mLayerMaskMode = LayerMaskMode.Contributes;
    private int mLayerMaskIndex = 0;
    private Object mLock = new Object();
    private am renderIn = new an(this);
    private am renderOut = new ao(this);
    private am renderOverall = new ap(this);
    private int layerInExpression = LayerExpression.None.getId();
    private int layerInExpressionDuration = LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
    private int layerOutExpression = LayerExpression.None.getId();
    private int layerOutExpressionDuration = LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
    private int layerOverallExpression = LayerExpression.None.getId();
    private float layerOverallExpressionSpeed = 1.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum DragType {
        START,
        END,
        FXSTART,
        FXEND
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public float f3300a;
        public float b;
        public float c;
    }

    protected abstract int getBGColor();

    public abstract void getBounds(Rect rect);

    public abstract int getHeight();

    protected abstract int getIcon();

    public abstract int getWidth();

    public abstract boolean isTransformedPointInLayerAtTime(float f2, float f3, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onRender(LayerRenderer layerRenderer, b bVar);

    public abstract void onRenderAsleep(LayerRenderer layerRenderer);

    public abstract void onRenderAwake(LayerRenderer layerRenderer);

    public abstract boolean supportsSplitScreen();

    public <T extends Comparable<T>> int addInOrder(List<T> list, T t) {
        int i;
        synchronized (this.mLock) {
            int binarySearch = Collections.binarySearch(list, t);
            if (binarySearch < 0) {
                i = -(binarySearch + 1);
            } else {
                i = binarySearch + 1;
            }
            list.add(i, t);
        }
        return i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.m
    public void setLayerMaskEnabled(boolean z) {
        this.mLayerMaskEnabled = z;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.m
    public boolean isLayerMaskEnabled() {
        return this.mLayerMaskEnabled;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.m
    public int getLayerMaskIndex() {
        return this.mLayerMaskIndex;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.m
    public void setLayerMaskIndex(int i) {
        this.mLayerMaskIndex = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.m
    public LayerMaskMode getLayerMaskMode() {
        return this.mLayerMaskMode;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.m
    public void setLayerMaskMode(LayerMaskMode layerMaskMode) {
        this.mLayerMaskMode = layerMaskMode;
    }

    public String getLayerName() {
        return this.mLayerName;
    }

    public void setLayerName(String str) {
        this.mLayerName = str;
    }

    public void clearExpressionState() {
        this.expressionState = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float a() {
        if (this.b == null) {
            this.b = new Rect();
        }
        if (this.c == null) {
            this.c = new RectF();
        }
        RectF rectF = this.c;
        getBounds(this.b);
        rectF.set(this.b);
        return (rectF.right - rectF.left) * f.b;
    }

    private void a(LayerRenderer layerRenderer, boolean z) {
        float f2;
        float f3;
        layerRenderer.l();
        layerRenderer.k();
        layerRenderer.a(LayerRenderer.RenderTarget.Mask);
        switch (getSplitScreenType()) {
            case LEFT:
                layerRenderer.b(-1, 0.0f, 0.0f, getSplitScreenSize(), 720.0f);
                float splitScreenSize = getSplitScreenSize() / 2;
                layerRenderer.a(true);
                f2 = 360.0f;
                f3 = splitScreenSize;
                break;
            case TOP:
                layerRenderer.b(-1, 0.0f, 0.0f, 1280.0f, getSplitScreenSize());
                layerRenderer.a(true);
                f2 = getSplitScreenSize() / 2;
                f3 = 640.0f;
                break;
            case RIGHT:
                layerRenderer.b(-1, 1280 - getSplitScreenSize(), 0.0f, 1280.0f, 720.0f);
                layerRenderer.a(true);
                f2 = 360.0f;
                f3 = 1280 - (getSplitScreenSize() / 2);
                break;
            case BOTTOM:
                layerRenderer.b(-1, 0.0f, 720 - getSplitScreenSize(), 1280.0f, 720.0f);
                layerRenderer.a(true);
                f2 = getSplitScreenSize() / 2;
                f3 = 640.0f;
                break;
            case FULL:
                layerRenderer.a(false);
                f2 = 360.0f;
                f3 = 640.0f;
                break;
            default:
                throw new IllegalStateException();
        }
        layerRenderer.a(LayerRenderer.RenderTarget.Normal);
        getInterpolatedKeyframe(getScaledTime(layerRenderer.j()), f);
        layerRenderer.a(f.c, f.d);
        if (this.b == null) {
            this.b = new Rect();
        }
        if (this.c == null) {
            this.c = new RectF();
        }
        RectF rectF = this.c;
        getBounds(this.b);
        rectF.set(this.b);
        float f4 = (rectF.right - rectF.left) * f.b;
        float f5 = (rectF.bottom - rectF.top) * f.b;
        if (z) {
            this.renderIn.a(layerRenderer, this.layerInExpression, f3 - f.c, f2 - f.d, layerRenderer.j() - getAbsStartTime(), getDuration(), this.layerInExpressionDuration, f4, f5);
        } else {
            layerRenderer.d(layerRenderer.r() * (getAlpha() / 255.0f));
            layerRenderer.b(f.e, 0.0f, 0.0f);
            layerRenderer.a(f.b, f.b, 0.0f, 0.0f);
            layerRenderer.b(this.m_flipH ? -1.0f : 1.0f, this.m_flipV ? -1.0f : 1.0f);
            onRender(layerRenderer, f);
        }
        layerRenderer.m();
    }

    public void renderLayer(LayerRenderer layerRenderer, boolean z) {
        if ((this instanceof NexTimelineItem.r) && getSplitScreenType() != SplitScreenType.OFF) {
            a(layerRenderer, z);
            return;
        }
        getInterpolatedKeyframe(getScaledTime(layerRenderer.j()), f);
        if (this.b == null) {
            this.b = new Rect();
        }
        if (this.c == null) {
            this.c = new RectF();
        }
        RectF rectF = this.c;
        getBounds(this.b);
        rectF.set(this.b);
        float f2 = (rectF.right - rectF.left) * f.b;
        float f3 = (rectF.bottom - rectF.top) * f.b;
        layerRenderer.l();
        layerRenderer.a(f.c, f.d);
        if (z) {
            layerRenderer.a(this.expressionState);
            this.renderIn.a(layerRenderer, this.layerInExpression, 0.0f, 0.0f, layerRenderer.j() - getAbsStartTime(), getDuration(), this.layerInExpressionDuration, f2, f3);
            this.expressionState = layerRenderer.g();
            layerRenderer.a((Object) null);
        } else {
            layerRenderer.d(layerRenderer.r() * (getAlpha() / 255.0f));
            layerRenderer.b(f.e, 0.0f, 0.0f);
            layerRenderer.a(f.b, f.b, 0.0f, 0.0f);
            layerRenderer.b(this.m_flipH ? -1.0f : 1.0f, this.m_flipV ? -1.0f : 1.0f);
            onRender(layerRenderer, f);
        }
        layerRenderer.m();
    }

    /* loaded from: classes.dex */
    public static class b implements Comparable<b> {

        /* renamed from: a, reason: collision with root package name */
        public float f3299a = 0.0f;
        public float b = 1.0f;
        public float c = 640.0f;
        public float d = 360.0f;
        public float e = 0.0f;
        public float f = 1.0f;

        public void a(b bVar) {
            this.f3299a = bVar.f3299a;
            this.b = bVar.b;
            this.c = bVar.c;
            this.d = bVar.d;
            this.e = bVar.e;
            this.f = bVar.f;
        }

        @Override // java.lang.Comparable
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            if (this.f3299a < bVar.f3299a) {
                return -1;
            }
            if (this.f3299a > bVar.f3299a) {
                return 1;
            }
            return 0;
        }

        public String toString() {
            return "[LayerKeyframe @" + this.f3299a + ":  " + this.c + "," + this.d + " scale=" + this.b + " angle=" + this.e + " alpha=" + this.f + "]";
        }

        public KMProto.KMProject.KeyFrame a() {
            KMProto.KMProject.KeyFrame.Builder builder = new KMProto.KMProject.KeyFrame.Builder();
            builder.time = Float.valueOf(this.f3299a);
            builder.scale = Float.valueOf(this.b);
            builder.x = Float.valueOf(this.c);
            builder.y = Float.valueOf(this.d);
            builder.angle = Float.valueOf(this.e);
            builder.alpha = Float.valueOf(this.f);
            return builder.build();
        }

        public static b a(KMProto.KMProject.KeyFrame keyFrame) {
            b bVar = new b();
            bVar.e = keyFrame.angle.floatValue();
            bVar.f3299a = keyFrame.time.floatValue();
            bVar.b = keyFrame.scale.floatValue();
            bVar.c = keyFrame.x.floatValue();
            bVar.d = keyFrame.y.floatValue();
            bVar.f = keyFrame.alpha.floatValue();
            return bVar;
        }
    }

    public float interpolate(float f2) {
        return f2;
    }

    public float reverseInterpolate(float f2) {
        return f2;
    }

    public float getScaledTime(int i) {
        int absStartTime = getAbsStartTime();
        int absEndTime = getAbsEndTime();
        if (i < absStartTime) {
            return 0.0f;
        }
        if (i > absEndTime) {
            return 1.0f;
        }
        return (i - absStartTime) / (absEndTime - absStartTime);
    }

    public b getInterpolatedKeyframe(float f2) {
        b bVar = new b();
        getInterpolatedKeyframe(f2, bVar);
        return bVar;
    }

    public void getInterpolatedKeyframe(float f2, b bVar) {
        b bVar2;
        b bVar3;
        float f3;
        float f4;
        b bVar4;
        b bVar5 = null;
        float f5 = 0.0f;
        if (isSplitScreenEnabled()) {
            bVar.a(getSplitScreenKeyframe());
            return;
        }
        float interpolate = interpolate(f2);
        b();
        Iterator<b> it = this.mKeyFrames.iterator();
        b bVar6 = null;
        float f6 = 0.0f;
        while (true) {
            if (!it.hasNext()) {
                bVar2 = bVar5;
                bVar3 = bVar6;
                break;
            }
            bVar2 = it.next();
            if (bVar2.f3299a <= interpolate) {
                if (bVar2.f3299a >= interpolate) {
                    bVar3 = bVar2;
                    break;
                }
                float abs = Math.abs(interpolate - bVar2.f3299a);
                if (abs < f6 || bVar6 == null) {
                    if (bVar5 != null) {
                        b bVar7 = bVar5;
                        bVar3 = bVar2;
                        bVar2 = bVar7;
                        break;
                    }
                    f3 = f5;
                    f4 = abs;
                    b bVar8 = bVar5;
                    bVar4 = bVar2;
                    bVar2 = bVar8;
                    f6 = f4;
                    f5 = f3;
                    bVar6 = bVar4;
                    bVar5 = bVar2;
                }
                bVar2 = bVar5;
                bVar4 = bVar6;
                f3 = f5;
                f4 = f6;
                f6 = f4;
                f5 = f3;
                bVar6 = bVar4;
                bVar5 = bVar2;
            } else {
                float abs2 = Math.abs(bVar2.f3299a - interpolate);
                if (abs2 < f5 || bVar5 == null) {
                    if (bVar6 != null) {
                        bVar3 = bVar6;
                        break;
                    }
                    bVar4 = bVar6;
                    f4 = f6;
                    f3 = abs2;
                    f6 = f4;
                    f5 = f3;
                    bVar6 = bVar4;
                    bVar5 = bVar2;
                }
                bVar2 = bVar5;
                bVar4 = bVar6;
                f3 = f5;
                f4 = f6;
                f6 = f4;
                f5 = f3;
                bVar6 = bVar4;
                bVar5 = bVar2;
            }
        }
        if (bVar3 == null) {
            bVar3 = bVar2;
        } else if (bVar2 == null) {
            bVar2 = bVar3;
        }
        if (bVar3 == null || bVar2 == null) {
            throw new IllegalStateException();
        }
        if (bVar2 == bVar3 || bVar2.f3299a == bVar3.f3299a) {
            bVar.f3299a = interpolate;
            bVar.f = bVar3.f;
            bVar.e = bVar3.e;
            bVar.b = bVar3.b;
            bVar.c = bVar3.c;
            bVar.d = bVar3.d;
            return;
        }
        float f7 = (interpolate - bVar3.f3299a) / (bVar2.f3299a - bVar3.f3299a);
        float f8 = 1.0f - f7;
        bVar.f3299a = interpolate;
        bVar.f = (bVar3.f * f8) + (bVar2.f * f7);
        bVar.e = (bVar3.e * f8) + (bVar2.e * f7);
        bVar.b = (bVar3.b * f8) + (bVar2.b * f7);
        bVar.c = (bVar3.c * f8) + (bVar2.c * f7);
        bVar.d = (bVar2.d * f7) + (bVar3.d * f8);
    }

    private void b() {
        if (this.mKeyFrames == null || this.mKeyFrames.size() < 1) {
            this.mKeyFrames = new CopyOnWriteArrayList();
            addInOrder(this.mKeyFrames, new b());
        }
    }

    public b getSplitScreenKeyframe() {
        if (this.mSplitScreenKeyFrame == null) {
            this.mSplitScreenKeyFrame = new b();
            this.mSplitScreenKeyFrame.b = 0.1f;
            fitKeyframeToSplitscreenRect(this.mSplitScreenKeyFrame);
        }
        return this.mSplitScreenKeyFrame;
    }

    public List<b> getKeyFrames() {
        if (isSplitScreenEnabled()) {
            return Collections.singletonList(this.mSplitScreenKeyFrame);
        }
        b();
        return Collections.unmodifiableList(this.mKeyFrames);
    }

    private List<b> c() {
        if (isSplitScreenEnabled()) {
            return Collections.singletonList(this.mSplitScreenKeyFrame);
        }
        b();
        return Collections.unmodifiableList(this.mKeyFrames);
    }

    public c getScaleRange() {
        c cVar = new c();
        getScaleRange(cVar);
        return cVar;
    }

    private List<b> d() {
        if (isSplitScreenEnabled()) {
            if (this.d == null) {
                this.d = Collections.singletonList(getSplitScreenKeyframe());
            }
            return this.d;
        }
        b();
        return this.mKeyFrames;
    }

    public void getScaleRange(c cVar) {
        b();
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        float f2 = Float.MIN_NORMAL;
        float f3 = Float.MAX_VALUE;
        boolean z = true;
        for (b bVar : d()) {
            if (z) {
                z = false;
            } else {
                double d5 = (bVar.f3299a - d2) * 100.0d;
                d3 += ((d + bVar.b) / 2.0d) * d5;
                d4 += d5;
            }
            d = bVar.b;
            d2 = bVar.f3299a;
            f2 = Math.max(f2, bVar.b);
            f3 = Math.min(f3, bVar.b);
        }
        if (d2 < 1.0d) {
            double d6 = (1.0d - d2) * 100.0d;
            d3 += d * d6;
            d4 += d6;
        }
        cVar.f3300a = f3;
        cVar.b = f2;
        cVar.c = (float) (d3 / d4);
    }

    public b getClosestKeyframe(float f2) {
        float f3;
        if (isSplitScreenEnabled()) {
            return getSplitScreenKeyframe();
        }
        b();
        float f4 = 0.0f;
        b bVar = null;
        for (b bVar2 : this.mKeyFrames) {
            float abs = Math.abs(bVar2.f3299a - f2);
            if (abs < f4 || bVar == null) {
                f3 = abs;
            } else {
                bVar2 = bVar;
                f3 = f4;
            }
            f4 = f3;
            bVar = bVar2;
        }
        return bVar;
    }

    public b addKeyframe(float f2) {
        if (isSplitScreenEnabled()) {
            throw new IllegalStateException();
        }
        b();
        b interpolatedKeyframe = getInterpolatedKeyframe(f2);
        addInOrder(this.mKeyFrames, interpolatedKeyframe);
        return interpolatedKeyframe;
    }

    public b addKeyframe(b bVar) {
        if (isSplitScreenEnabled()) {
            throw new IllegalStateException();
        }
        b();
        addInOrder(this.mKeyFrames, bVar);
        return bVar;
    }

    public void removeKeyframe(b bVar) {
        if (isSplitScreenEnabled()) {
            throw new IllegalStateException();
        }
        b();
        synchronized (this.mLock) {
            this.mKeyFrames.remove(bVar);
        }
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setRelativeStartTime(int i) {
        this.startTime = i;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setRelativeEndTime(int i) {
        this.endTime = i;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getRelativeEndTime() {
        return this.startTime;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getRelativeStartTime() {
        return this.endTime;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setAnchorItem(NexPrimaryTimelineItem nexPrimaryTimelineItem) {
        throw new UnsupportedOperationException();
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public NexPrimaryTimelineItem getAnchorItem() {
        return null;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setPinned(boolean z) {
        this.pinned = z;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public boolean getPinned() {
        return this.pinned;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getDuration() {
        return this.endTime - this.startTime;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void setDuration(int i) {
        throw new UnsupportedOperationException("setDuration not permitted on layer items");
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getRepresentedDuration() {
        return getDuration();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean onCustomDrag(NexTimelineItem.h hVar, NexTimelineItem.t tVar, float f2, float f3, float f4) {
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onCustomPostDrag(NexTimelineItem.h hVar, Rect rect) {
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onCustomDragDone(NexTimelineItem.h hVar, NexTimelineItem.t tVar) {
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public NexTimelineItem.i onLongPress(Context context, NexTimelineItem.t tVar, RectF rectF, int i, int i2, boolean z, int i3) {
        return NexTimelineItem.i.n;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public NexTimelineItem.i onDown(Context context, NexTimelineItem.t tVar, RectF rectF, int i, int i2, boolean z, int i3) {
        if (i3 == R.id.editmode_trim && z) {
            return onDown_trim(context, tVar, rectF, i, i2, z, i3);
        }
        return null;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean onShowItemMenu(Context context, int i, int i2, int i3, int i4, int i5, NexTimelineItem.n nVar) {
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getAbsEndTime() {
        if (this.pinned) {
            return this.endTime;
        }
        NexPrimaryTimelineItem anchorItem = getAnchorItem();
        if (anchorItem == null) {
            return this.endTime;
        }
        return anchorItem.getAbsStartTime() + this.endTime;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getAbsStartTime() {
        if (this.pinned) {
            return this.startTime;
        }
        NexPrimaryTimelineItem anchorItem = getAnchorItem();
        if (anchorItem == null) {
            return this.startTime;
        }
        return anchorItem.getAbsStartTime() + this.startTime;
    }

    protected String getLabelText(Context context) {
        return getDescriptiveTitle(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onDraw(com.nexstreaming.kinemaster.ui.projectedit.ay ayVar) {
        float f2;
        float f3;
        RectF d = ayVar.d();
        TextPaint e2 = ayVar.e();
        Canvas b2 = ayVar.b();
        RectF c2 = ayVar.c();
        Drawable drawable = ayVar.getResources().getDrawable(ayVar.f() ? R.drawable.timeline_item_border_sel : R.drawable.timeline_item_border_nor);
        drawable.getPadding(e);
        d.set(c2);
        d.left += e.left;
        d.top += e.top;
        d.right -= e.right;
        d.bottom -= e.bottom;
        this.f3296a = c2.width();
        if (ayVar.g()) {
            e2.setStyle(Paint.Style.STROKE);
            e2.setColor(-6710887);
            e2.setStrokeWidth(1.0f);
            b2.drawRoundRect(d, 2.0f, 2.0f, e2);
            return;
        }
        int color = ayVar.getResources().getColor(getBGColor());
        e2.setStyle(Paint.Style.FILL);
        e2.setColor(color);
        if (this.f3296a < drawable.getMinimumWidth()) {
            float j = ayVar.j() * 2.0f;
            float j2 = ayVar.j() * 1.0f;
            d.top += e.top;
            d.bottom -= e.bottom;
            d.left += e.left;
            d.right -= e.right;
            if (d.width() < j) {
                d.left = d.centerX() - (j / 2.0f);
                d.right = j + d.left;
            }
            b2.drawRoundRect(d, j2, j2, e2);
            return;
        }
        b2.drawRect(d, e2);
        boolean drawThumbnails = drawThumbnails(ayVar, b2, d);
        d.set(c2);
        d.left += e.left;
        d.top += e.top;
        d.right -= e.right;
        d.bottom -= e.bottom;
        int icon = getIcon();
        if (icon != 0) {
            Drawable drawable2 = ayVar.getResources().getDrawable(icon);
            int a2 = ayVar.a(1.0f);
            drawable2.setBounds(((int) d.left) + a2 + 0, ((int) d.top) + a2, (int) (((drawable2.getIntrinsicWidth() / drawable2.getIntrinsicHeight()) * (d.height() - (a2 * 2))) + d.left + 0 + a2), ((int) d.bottom) - a2);
            drawable2.draw(b2);
        }
        String layerName = getLayerName();
        String labelText = (layerName == null || layerName.trim().length() < 1) ? getLabelText(ayVar) : layerName;
        if (labelText != null) {
            e2.setColor(-1);
            e2.setTextSize(ayVar.getResources().getDimension(R.dimen.timeline_audioClipTextSize));
            Paint.FontMetrics fontMetrics = e2.getFontMetrics();
            e2.setAntiAlias(true);
            float height = 0 + c2.left + c2.height() + ayVar.a(0.0f);
            String charSequence = TextUtils.ellipsize(labelText, e2, (c2.right - height) - ((getPinned() ? 1.1f : 0.15f) * c2.height()), TextUtils.TruncateAt.MIDDLE).toString();
            if (drawThumbnails) {
                e2.setShadowLayer(ayVar.getResources().getDimension(R.dimen.timeline3_layertext_shadow), 0.0f, 0.0f, -2013265920);
            }
            b2.drawText(charSequence, height, c2.centerY() - (fontMetrics.ascent / 3.0f), e2);
            if (drawThumbnails) {
                e2.clearShadowLayer();
            }
        }
        drawPin(ayVar, drawThumbnails ? R.drawable.pin_light : R.drawable.pin_dark);
        if (getOverLimit()) {
            Drawable drawable3 = ayVar.getResources().getDrawable(R.drawable.stripes_tile);
            int intrinsicWidth = drawable3.getIntrinsicWidth();
            int intrinsicHeight = drawable3.getIntrinsicHeight();
            int i = (int) c2.top;
            while (true) {
                int i2 = i;
                if (i2 >= c2.bottom + 1.0f) {
                    break;
                }
                int i3 = (int) c2.left;
                while (true) {
                    int i4 = i3;
                    if (i4 < c2.right + 1.0f) {
                        int i5 = i4 + intrinsicWidth;
                        int i6 = i2 + intrinsicHeight;
                        if (!b2.quickReject(i4, i2, i5, i6, Canvas.EdgeType.AA)) {
                            drawable3.setBounds(i4, i2, i5, i6);
                            drawable3.setAlpha(100);
                            drawable3.draw(b2);
                        }
                        i3 = i4 + intrinsicWidth;
                    }
                }
                i = i2 + intrinsicHeight;
            }
        }
        drawLayerAnimation(ayVar, getKeyFrames(), getDuration(), R.drawable.vol_env_keyframe_icon);
        drawable.setBounds((int) c2.left, (int) c2.top, (int) c2.right, (int) c2.bottom);
        drawable.draw(b2);
        if (ayVar.l() == R.id.editmode_trim && ayVar.f() && !ayVar.g()) {
            b2.save();
            Drawable drawable4 = ayVar.getResources().getDrawable(R.drawable.grip_yellow);
            int a3 = ayVar.a(8.0f);
            b2.clipRect(c2.left - a3, c2.top, c2.right + a3, c2.bottom, Region.Op.REPLACE);
            drawable4.setBounds(((int) c2.left) - a3, (int) c2.top, ((int) c2.right) + a3, (int) c2.bottom);
            drawable4.draw(b2);
            b2.restore();
            return;
        }
        if (ayVar.l() == R.id.editmode_volume_adjust && ayVar.f() && !ayVar.g() && (this instanceof nb)) {
            nb nbVar = (nb) this;
            List<ef> o = ayVar.o();
            d.set(c2);
            d.inset(1.0f, 1.0f);
            int volumeEnvelopeLength = nbVar.getVolumeEnvelopeLength();
            int representedDuration = getRepresentedDuration();
            int absEndTime = getTimeline().getTotalTime() < getAbsEndTime() ? representedDuration - (getAbsEndTime() - getTimeline().getTotalTime()) : representedDuration;
            new Path();
            Drawable drawable5 = ayVar.getResources().getDrawable(R.drawable.vol_env_keyframe_icon);
            PointF[] pointFArr = new PointF[volumeEnvelopeLength];
            int intrinsicWidth2 = drawable5.getIntrinsicWidth() / 2;
            int intrinsicHeight2 = drawable5.getIntrinsicHeight() / 2;
            float f4 = 0.0f;
            b2.clipRect(d);
            e2.reset();
            e2.setAntiAlias(true);
            e2.setStrokeWidth(5.0f);
            e2.setStyle(Paint.Style.STROKE);
            e2.setColor(-1);
            int i7 = 0;
            int i8 = 0;
            float f5 = 0.0f;
            while (i7 < volumeEnvelopeLength) {
                if (i7 == 0) {
                    pointFArr[i8] = new PointF();
                    pointFArr[i8].x = (nbVar.getVolumeEnvelopeTimeAdj(i7) / getRepresentedDuration()) * d.right;
                    pointFArr[i8].y = d.bottom - ((nbVar.getVolumeEnvelopeLevel(i7) / 200.0f) * d.bottom);
                    f2 = pointFArr[i8].x;
                    f3 = pointFArr[i8].y;
                } else {
                    int volumeEnvelopeTimeAdj = nbVar.getVolumeEnvelopeTimeAdj(i7);
                    pointFArr[i8] = new PointF();
                    pointFArr[i8].x = (volumeEnvelopeTimeAdj / absEndTime) * d.right;
                    if (o != null) {
                        int i9 = 0;
                        while (true) {
                            int i10 = i9;
                            if (i10 >= o.size() - 1) {
                                break;
                            }
                            ef efVar = o.get(i10);
                            ef efVar2 = o.get(i10 + 1);
                            if (efVar.f4622a > volumeEnvelopeTimeAdj || volumeEnvelopeTimeAdj >= efVar2.f4622a) {
                                i9 = i10 + 1;
                            } else {
                                pointFArr[i8].x = (((volumeEnvelopeTimeAdj - efVar.f4622a) * (efVar2.b - efVar.b)) / (efVar2.f4622a - efVar.f4622a)) + efVar.b;
                                break;
                            }
                        }
                    }
                    pointFArr[i8].y = d.bottom - ((nbVar.getVolumeEnvelopeLevel(i7) / 200.0f) * d.bottom);
                    b2.drawLine(f5, f4, pointFArr[i8].x, pointFArr[i8].y, e2);
                    f2 = pointFArr[i8].x;
                    f3 = pointFArr[i8].y;
                }
                i7++;
                i8++;
                float f6 = f2;
                f4 = f3;
                f5 = f6;
            }
            for (int i11 = 0; i11 < pointFArr.length && pointFArr[i11] != null; i11++) {
                if (pointFArr[i11].x <= ayVar.n() || !ayVar.h()) {
                    drawable5.setBounds(((int) pointFArr[i11].x) - intrinsicWidth2, ((int) pointFArr[i11].y) - intrinsicHeight2, ((int) pointFArr[i11].x) + intrinsicWidth2, ((int) pointFArr[i11].y) + intrinsicHeight2);
                    drawable5.draw(b2);
                }
            }
        }
    }

    protected boolean drawThumbnails(com.nexstreaming.kinemaster.ui.projectedit.ay ayVar, Canvas canvas, RectF rectF) {
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setStartTime(int i) {
        this.startTime = i;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setEndTime(int i) {
        this.endTime = i;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getStartTime() {
        return this.startTime;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getEndTime() {
        return this.endTime;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setStartTrim(int i) {
        if (hasIntrinsicDuration()) {
            this.startTrim = i;
        }
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setEndTrim(int i) {
        if (hasIntrinsicDuration()) {
            this.endTrim = i;
        }
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getStartTrim() {
        return this.startTrim;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getEndTrim() {
        return this.endTrim;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void moveClip(int i) {
        this.endTime = (this.endTime - this.startTime) + i;
        this.startTime = i;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void trimClip(int i, int i2) {
        if (i2 - i < 1) {
            throw new IllegalArgumentException("End time must be greater than start time");
        }
        if (hasIntrinsicDuration()) {
            int i3 = this.startTime - this.startTrim;
            int intinsicDuration = i3 + getIntinsicDuration();
            int i4 = i < i3 ? i3 : i;
            int i5 = i2 <= i4 ? i4 + 1 : i2;
            if (i5 > intinsicDuration) {
                i5 = intinsicDuration;
            }
            if (i4 >= i5) {
                i4 = i5 - 1;
            }
            this.startTime = i4;
            this.endTime = i5;
            this.startTrim = i4 - i3;
            this.endTrim = intinsicDuration - i5;
            return;
        }
        this.startTime = i;
        this.endTime = i2;
    }

    public LayerExpression getLayerExpression(LayerExpression.Type type) {
        switch (type) {
            case In:
                return LayerExpression.fromId(this.layerInExpression);
            case Out:
                return LayerExpression.fromId(this.layerOutExpression);
            case Overall:
                return LayerExpression.fromId(this.layerOverallExpression);
            default:
                throw new IllegalArgumentException();
        }
    }

    public int getLayerExpressionDuration(LayerExpression.Type type) {
        switch (type) {
            case In:
                return this.layerInExpressionDuration;
            case Out:
                return this.layerOutExpressionDuration;
            default:
                throw new IllegalArgumentException();
        }
    }

    public void setLayerExpressionDuration(LayerExpression.Type type, int i) {
        switch (type) {
            case In:
                this.layerInExpressionDuration = i;
                return;
            case Out:
                this.layerOutExpressionDuration = i;
                return;
            default:
                throw new IllegalArgumentException();
        }
    }

    public void setLayerExpressionSpeed(LayerExpression.Type type, float f2) {
        switch (type) {
            case Overall:
                this.layerOverallExpressionSpeed = f2;
                return;
            default:
                throw new IllegalArgumentException();
        }
    }

    public float getLayerExpressionSpeed(LayerExpression.Type type) {
        switch (type) {
            case Overall:
                return this.layerOverallExpressionSpeed;
            default:
                throw new IllegalArgumentException();
        }
    }

    public void setLayerExpression(LayerExpression.Type type, LayerExpression layerExpression) {
        switch (type) {
            case In:
                this.layerInExpression = layerExpression.getId();
                return;
            case Out:
                this.layerOutExpression = layerExpression.getId();
                return;
            case Overall:
                this.layerOverallExpression = layerExpression.getId();
                return;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean isPointInSplitScreenLayer(float f2, float f3) {
        float f4;
        float f5 = 1280.0f;
        float f6 = 720.0f;
        float f7 = 0.0f;
        if (!isSplitScreenEnabled()) {
            throw new IllegalStateException();
        }
        switch (getSplitScreenType()) {
            case LEFT:
                f5 = getSplitScreenSize();
                f4 = 0.0f;
                break;
            case TOP:
                f6 = getSplitScreenSize();
                f4 = 0.0f;
                break;
            case RIGHT:
                f7 = 1280 - getSplitScreenSize();
                f4 = 0.0f;
                break;
            case BOTTOM:
                f4 = 720 - getSplitScreenSize();
                break;
            case FULL:
                f4 = 0.0f;
                break;
            default:
                throw new IllegalStateException();
        }
        return f2 >= f7 && f2 <= f5 && f3 >= f4 && f3 <= f6;
    }

    public final boolean isPointInLayerAtTime(float f2, float f3, int i) {
        if (isSplitScreenEnabled()) {
            return isPointInSplitScreenLayer(f2, f3);
        }
        getInterpolatedKeyframe(getScaledTime(i), f);
        b bVar = f;
        Matrix matrix = new Matrix();
        matrix.postTranslate(-bVar.c, -bVar.d);
        matrix.postScale(1.0f / bVar.b, 1.0f / bVar.b);
        matrix.postRotate(-bVar.e, 0.0f, 0.0f);
        float[] fArr = {f2, f3};
        matrix.mapPoints(fArr);
        return isTransformedPointInLayerAtTime(fArr[0], fArr[1], i);
    }

    public long getZOrder() {
        return this.zOrder;
    }

    public void setZOrder(long j) {
        this.zOrder = j;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.s
    public void trimToLeft(int i) {
        trimClip(i, getEndTime());
        getTimeline().requestCalcTimes();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.s
    public void trimToRight(int i) {
        trimClip(getStartTime(), i);
        getTimeline().requestCalcTimes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends NexTimelineItem.h {

        /* renamed from: a, reason: collision with root package name */
        DragType f3298a;
        int b;
        int c;
        int d;
        int e;
        int f;
        View g;
        ViewGroup h;
        WindowManager i;
        WindowManager.LayoutParams j;
        int k;
        Context l;

        private a() {
            this.f3298a = null;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = 0;
        }

        /* synthetic */ a(an anVar) {
            this();
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean onCustomDrag_v3(NexTimelineItem.h hVar, NexTimelineItem.t tVar, float f2, float f3, float f4) {
        a aVar = (a) hVar;
        int max = Math.max(33, (int) (((aVar.l.getResources().getDisplayMetrics().density * 15.0f) / f4) * 1000.0f));
        switch (aVar.f3298a) {
            case END:
                int startTime = getStartTime();
                int i = aVar.b + ((int) ((f2 / f4) * 1000.0f));
                if (i >= max) {
                    max = i;
                }
                if (max > tVar.getTimeline().getTotalTime()) {
                    max = tVar.getTimeline().getTotalTime();
                }
                trimClip(startTime, max + startTime);
                aVar.g.invalidate();
                tVar.a(true);
                return true;
            case START:
                int i2 = aVar.b + ((int) ((f2 / f4) * 1000.0f));
                int endTime = getEndTime() - i2 < max ? getEndTime() - max : i2;
                if (endTime < 0) {
                    endTime = 0;
                }
                trimClip(endTime, getEndTime());
                aVar.g.invalidate();
                tVar.a(true);
                return true;
            default:
                return false;
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onCustomDragDone_v3(NexTimelineItem.h hVar, NexTimelineItem.t tVar) {
        a aVar = (a) hVar;
        if (aVar.i != null && aVar.h != null) {
            aVar.i.removeView(aVar.h);
            aVar.h = null;
        }
        if (aVar.f3298a == DragType.END) {
            tVar.a(getAbsEndTime() - 1, true);
        } else if (aVar.f3298a == DragType.START) {
            tVar.a(getAbsStartTime(), true);
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onCustomPostDrag_v3(NexTimelineItem.h hVar, Rect rect) {
        a aVar = (a) hVar;
        if (aVar.i != null && aVar.h != null) {
            if (aVar.f3298a == DragType.END) {
                aVar.j.x = rect.right - (aVar.e / 2);
            } else {
                aVar.j.x = rect.left - (aVar.e / 2);
            }
            aVar.i.updateViewLayout(aVar.h, aVar.j);
        }
    }

    public NexTimelineItem.i onDown_trim(Context context, NexTimelineItem.t tVar, RectF rectF, int i, int i2, boolean z, int i3) {
        int i4;
        if (i3 != R.id.editmode_trim) {
            return null;
        }
        int secondaryItemCount = getTimeline().getSecondaryItemCount();
        int i5 = 0;
        int i6 = 0;
        while (i6 < secondaryItemCount) {
            NexSecondaryTimelineItem secondaryItem = getTimeline().getSecondaryItem(i6);
            if (secondaryItem instanceof NexLayerItem) {
                NexLayerItem nexLayerItem = (NexLayerItem) secondaryItem;
                if (nexLayerItem.getAbsStartTime() > getAbsEndTime()) {
                    i4 = i5;
                } else {
                    i4 = nexLayerItem.getAbsEndTime();
                    if (i4 > i5) {
                    }
                }
                i6++;
                i5 = i4;
            }
            i4 = i5;
            i6++;
            i5 = i4;
        }
        if (rectF.width() < rectF.height() * 4.0f) {
            if (i < rectF.left + (rectF.width() / 2.0f)) {
                a aVar = new a(null);
                aVar.f3298a = DragType.START;
                aVar.l = context;
                aVar.b = this.startTime;
                aVar.c = tVar.getTimeline().freeSpaceAtTime(getAbsStartTime() - 1, 3, 100, true);
                a(aVar, context, (int) rectF.left, (int) rectF.top);
                return aVar;
            }
            a aVar2 = new a(null);
            aVar2.f3298a = DragType.END;
            aVar2.l = context;
            aVar2.b = getDuration();
            aVar2.c = tVar.getTimeline().freeSpaceAtTime(getAbsEndTime() + 1, 3, 100, false);
            a(aVar2, context, (int) rectF.right, (int) rectF.top);
            return aVar2;
        }
        if (i < rectF.left + (rectF.height() * 2.0f)) {
            a aVar3 = new a(null);
            aVar3.f3298a = DragType.START;
            aVar3.l = context;
            aVar3.b = this.startTime;
            aVar3.c = tVar.getTimeline().freeSpaceAtTime(getAbsStartTime() - 1, 3, 100, true);
            a(aVar3, context, (int) rectF.left, (int) rectF.top);
            return aVar3;
        }
        if (i > rectF.right - (rectF.height() * 2.0f)) {
            a aVar4 = new a(null);
            aVar4.f3298a = DragType.END;
            aVar4.l = context;
            aVar4.b = getDuration();
            aVar4.c = tVar.getTimeline().freeSpaceAtTime(getAbsEndTime() + 1, 3, 100, false);
            a(aVar4, context, (int) rectF.right, (int) rectF.top);
            return aVar4;
        }
        return null;
    }

    private void a(a aVar, Context context, int i, int i2) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        aVar.e = (int) TypedValue.applyDimension(1, 100.0f, displayMetrics);
        aVar.f = (int) TypedValue.applyDimension(1, 32.0f, displayMetrics);
        aVar.k = i - (aVar.e / 2);
        aVar.i = (WindowManager) context.getSystemService("window");
        aVar.h = new FrameLayout(context);
        aVar.h.setBackgroundColor(0);
        aVar.g = new aq(this, context, aVar);
        aVar.g.setLayoutParams(new FrameLayout.LayoutParams(aVar.e, aVar.f));
        aVar.h.addView(aVar.g);
        aVar.j = new WindowManager.LayoutParams();
        aVar.j.width = aVar.e;
        aVar.j.height = aVar.f;
        aVar.j.flags = 408;
        aVar.j.gravity = 51;
        aVar.j.x = aVar.k;
        aVar.j.y = ((int) TypedValue.applyDimension(1, 2.0f, displayMetrics)) + (i2 - aVar.f);
        aVar.j.windowAnimations = 0;
        aVar.j.format = -3;
        aVar.i.addView(aVar.h, aVar.j);
    }

    public float getClipWidth() {
        return this.f3296a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public KMProto.KMProject.LayerCommon getLayerCommonProtoBuf() {
        KMProto.KMProject.LayerCommon.Builder builder = new KMProto.KMProject.LayerCommon.Builder();
        builder.end_time = Integer.valueOf(this.endTime);
        builder.start_time = Integer.valueOf(this.startTime);
        builder.start_trim = Integer.valueOf(this.startTrim);
        builder.end_trim = Integer.valueOf(this.endTrim);
        builder.layer_expression = null;
        builder.layer_expression_duration = null;
        builder.layer_in_expression = Integer.valueOf(this.layerInExpression);
        builder.layer_in_expression_duration = Integer.valueOf(this.layerInExpressionDuration);
        builder.layer_out_expression = Integer.valueOf(this.layerOutExpression);
        builder.layer_out_expression_duration = Integer.valueOf(this.layerOutExpressionDuration);
        builder.layer_overall_expression = Integer.valueOf(this.layerOverallExpression);
        builder.layer_overall_expression_speed = Float.valueOf(this.layerOverallExpressionSpeed);
        builder.z_order = Long.valueOf(this.zOrder);
        builder.pinned = Boolean.valueOf(this.pinned);
        builder.flip_h = Boolean.valueOf(this.m_flipH);
        builder.flip_v = Boolean.valueOf(this.m_flipV);
        builder.overall_alpha = Integer.valueOf(this.mAlpha);
        builder.split_size_bottom = Integer.valueOf(this.m_splitSizeBottom);
        builder.split_size_top = Integer.valueOf(this.m_splitSizeTop);
        builder.split_size_left = Integer.valueOf(this.m_splitSizeLeft);
        builder.split_size_right = Integer.valueOf(this.m_splitSizeRight);
        builder.split_screen_type = this.m_splitScreenType == null ? KMProto.KMProject.SplitScreenType.OFF : this.m_splitScreenType.asProtoBuf();
        builder.layermask_enabled = Boolean.valueOf(this.mLayerMaskEnabled);
        builder.layermask_type = Integer.valueOf(this.mLayerMaskMode.getId());
        builder.layermask_index = Integer.valueOf(this.mLayerMaskIndex);
        builder.layer_name = this.mLayerName;
        if (this.mKeyFrames != null) {
            builder.keyframes = new ArrayList(this.mKeyFrames.size());
            Iterator<b> it = this.mKeyFrames.iterator();
            while (it.hasNext()) {
                builder.keyframes.add(it.next().a());
            }
        }
        if (this.mSplitScreenKeyFrame != null) {
            builder.split_keyframe = getSplitScreenKeyframe().a();
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void fromProtoBuf(KMProto.KMProject.LayerCommon layerCommon, NexLayerItem nexLayerItem) {
        if (layerCommon.start_time != null) {
            nexLayerItem.startTime = layerCommon.start_time.intValue();
        }
        if (layerCommon.end_time != null) {
            nexLayerItem.endTime = layerCommon.end_time.intValue();
        }
        if (layerCommon.start_trim != null) {
            nexLayerItem.startTrim = layerCommon.start_trim.intValue();
        }
        if (layerCommon.end_trim != null) {
            nexLayerItem.endTrim = layerCommon.end_trim.intValue();
        }
        if (layerCommon.layer_name != null) {
            nexLayerItem.mLayerName = layerCommon.layer_name;
        }
        if (layerCommon.layer_expression != null) {
            int i = LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
            if (layerCommon.layer_expression_duration != null) {
                i = layerCommon.layer_expression_duration.intValue();
            }
            LayerExpression fromId = LayerExpression.fromId(layerCommon.layer_expression.intValue());
            if (fromId.getType() == LayerExpression.Type.Legacy) {
                LayerExpression legacyInExpression = fromId.getLegacyInExpression();
                LayerExpression legacyOutExpression = fromId.getLegacyOutExpression();
                LayerExpression legacyOverallExpression = fromId.getLegacyOverallExpression();
                if (legacyInExpression != null) {
                    nexLayerItem.layerInExpression = legacyInExpression.getId();
                    nexLayerItem.layerInExpressionDuration = i;
                }
                if (legacyOutExpression != null) {
                    nexLayerItem.layerOutExpression = legacyOutExpression.getId();
                    nexLayerItem.layerOutExpressionDuration = i;
                }
                if (legacyOverallExpression != null) {
                    nexLayerItem.layerOverallExpression = legacyOverallExpression.getId();
                    nexLayerItem.layerOverallExpressionSpeed = 1.0f;
                }
            }
        }
        if (layerCommon.layer_in_expression != null) {
            nexLayerItem.layerInExpression = layerCommon.layer_in_expression.intValue();
        }
        if (layerCommon.layer_in_expression_duration != null) {
            nexLayerItem.layerInExpressionDuration = layerCommon.layer_in_expression_duration.intValue();
        }
        if (layerCommon.layer_out_expression != null) {
            nexLayerItem.layerOutExpression = layerCommon.layer_out_expression.intValue();
        }
        if (layerCommon.layer_out_expression_duration != null) {
            nexLayerItem.layerOutExpressionDuration = layerCommon.layer_out_expression_duration.intValue();
        }
        if (layerCommon.layer_overall_expression != null) {
            nexLayerItem.layerOverallExpression = layerCommon.layer_overall_expression.intValue();
        }
        if (layerCommon.layer_overall_expression_speed != null) {
            nexLayerItem.layerOverallExpressionSpeed = layerCommon.layer_overall_expression_speed.floatValue();
        }
        if (layerCommon.z_order != null) {
            nexLayerItem.zOrder = layerCommon.z_order.longValue();
        }
        if (layerCommon.pinned != null) {
            nexLayerItem.pinned = layerCommon.pinned.booleanValue();
        }
        if (layerCommon.flip_h != null) {
            nexLayerItem.m_flipH = layerCommon.flip_h.booleanValue();
        }
        if (layerCommon.flip_v != null) {
            nexLayerItem.m_flipV = layerCommon.flip_v.booleanValue();
        }
        if (layerCommon.overall_alpha != null) {
            nexLayerItem.mAlpha = layerCommon.overall_alpha.intValue();
        } else {
            nexLayerItem.mAlpha = 255;
        }
        if (layerCommon.keyframes != null && layerCommon.keyframes.size() > 0) {
            nexLayerItem.mKeyFrames = new CopyOnWriteArrayList();
            Iterator<KMProto.KMProject.KeyFrame> it = layerCommon.keyframes.iterator();
            while (it.hasNext()) {
                nexLayerItem.addInOrder(nexLayerItem.mKeyFrames, b.a(it.next()));
            }
        }
        if (layerCommon.split_keyframe != null) {
            nexLayerItem.mSplitScreenKeyFrame = b.a(layerCommon.split_keyframe);
        }
        nexLayerItem.m_splitSizeBottom = layerCommon.split_size_bottom == null ? 0 : layerCommon.split_size_bottom.intValue();
        nexLayerItem.m_splitSizeTop = layerCommon.split_size_top == null ? 0 : layerCommon.split_size_top.intValue();
        nexLayerItem.m_splitSizeLeft = layerCommon.split_size_left == null ? 0 : layerCommon.split_size_left.intValue();
        nexLayerItem.m_splitSizeRight = layerCommon.split_size_right == null ? 0 : layerCommon.split_size_right.intValue();
        nexLayerItem.m_splitScreenType = SplitScreenType.fromProtoBuf(layerCommon.split_screen_type);
        nexLayerItem.mLayerMaskIndex = layerCommon.layermask_index == null ? 0 : layerCommon.layermask_index.intValue();
        nexLayerItem.mLayerMaskEnabled = layerCommon.layermask_enabled != null ? layerCommon.layermask_enabled.booleanValue() : false;
        nexLayerItem.mLayerMaskMode = layerCommon.layermask_type == null ? LayerMaskMode.Contributes : LayerMaskMode.fromId(layerCommon.layermask_type.intValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isPivotMovable() {
        b();
        for (b bVar : this.mKeyFrames) {
            if (Math.abs(bVar.e) > 1.0E-6d || Math.abs(bVar.b - 1.0f) > 1.0E-6d) {
                return false;
            }
        }
        b splitScreenKeyframe = getSplitScreenKeyframe();
        return ((double) Math.abs(splitScreenKeyframe.e)) <= 1.0E-6d && ((double) Math.abs(splitScreenKeyframe.b - 1.0f)) <= 1.0E-6d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adjustForPivotChange(float f2, float f3) {
        b();
        for (b bVar : this.mKeyFrames) {
            bVar.c += f2;
            bVar.d += f3;
        }
        b splitScreenKeyframe = getSplitScreenKeyframe();
        splitScreenKeyframe.c += f2;
        splitScreenKeyframe.d += f3;
    }

    public boolean isSplitScreenEnabled() {
        if (supportsSplitScreen()) {
            if ((this.m_splitScreenType != null) & (this.m_splitScreenType != SplitScreenType.OFF)) {
                return true;
            }
        }
        return false;
    }

    public void fitKeyframeToSplitscreenRect(b bVar) {
        float f2;
        float f3;
        float f4 = 1280.0f;
        float f5 = 720.0f;
        if (isSplitScreenEnabled()) {
            switch (getSplitScreenType()) {
                case LEFT:
                    f4 = getSplitScreenSize();
                    f2 = 0.0f;
                    f3 = 0.0f;
                    break;
                case TOP:
                    f5 = getSplitScreenSize();
                    f2 = 0.0f;
                    f3 = 0.0f;
                    break;
                case RIGHT:
                    f3 = 1280 - getSplitScreenSize();
                    f2 = 0.0f;
                    break;
                case BOTTOM:
                    f2 = 720 - getSplitScreenSize();
                    f3 = 0.0f;
                    break;
                case FULL:
                    f2 = 0.0f;
                    f3 = 0.0f;
                    break;
                default:
                    return;
            }
            if (this.b == null) {
                this.b = new Rect();
            }
            if (this.c == null) {
                this.c = new RectF();
            }
            RectF rectF = this.c;
            float f6 = f5 - f2;
            float f7 = f4 - f3;
            getBounds(this.b);
            rectF.set(this.b);
            rectF.left *= bVar.b;
            rectF.top *= bVar.b;
            rectF.right *= bVar.b;
            rectF.bottom *= bVar.b;
            a(rectF, (int) bVar.e);
            rectF.offset(bVar.c, bVar.d);
            float width = f7 - rectF.width();
            float height = f6 - rectF.height();
            if (width > 0.0f && width > height) {
                bVar.b *= f7 / rectF.width();
            } else if (height > 0.0f) {
                bVar.b *= f6 / rectF.height();
            }
            rectF.set(this.b);
            rectF.left *= bVar.b;
            rectF.top *= bVar.b;
            rectF.right *= bVar.b;
            rectF.bottom *= bVar.b;
            a(rectF, (int) bVar.e);
            rectF.offset(bVar.c, bVar.d);
            if (rectF.right < f4) {
                bVar.c = (f4 - rectF.right) + bVar.c;
            } else if (rectF.left > f3) {
                bVar.c += f3 - rectF.left;
            }
            if (rectF.bottom < f5) {
                bVar.d = (f5 - rectF.bottom) + bVar.d;
            } else if (rectF.top > f2) {
                bVar.d += f2 - rectF.top;
            }
        }
    }

    private void a(RectF rectF, int i) {
        if (i == 90 || i == -270) {
            float f2 = rectF.top;
            float f3 = rectF.bottom;
            float f4 = rectF.left;
            rectF.top = -rectF.right;
            rectF.right = f3;
            rectF.bottom = -f4;
            rectF.left = f2;
            return;
        }
        if (i == 270 || i == -90) {
            float f5 = rectF.top;
            float f6 = rectF.bottom;
            float f7 = rectF.left;
            float f8 = rectF.right;
            rectF.top = f7;
            rectF.left = -f6;
            rectF.bottom = f8;
            rectF.right = -f5;
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.r
    public SplitScreenType getSplitScreenType() {
        if (supportsSplitScreen()) {
            return this.m_splitScreenType == null ? SplitScreenType.OFF : this.m_splitScreenType;
        }
        return SplitScreenType.OFF;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.r
    public void setSplitScreenType(SplitScreenType splitScreenType) {
        if (!supportsSplitScreen()) {
            throw new UnsupportedOperationException();
        }
        if (splitScreenType == null) {
            splitScreenType = SplitScreenType.OFF;
        }
        this.m_splitScreenType = splitScreenType;
    }

    public int getSplitScreenSize() {
        if (!supportsSplitScreen()) {
            throw new UnsupportedOperationException();
        }
        switch (getSplitScreenType()) {
            case LEFT:
                if (this.m_splitSizeLeft == 0) {
                    return 640;
                }
                return this.m_splitSizeLeft;
            case TOP:
                if (this.m_splitSizeTop != 0) {
                    return this.m_splitSizeTop;
                }
                return 360;
            case RIGHT:
                return this.m_splitSizeRight != 0 ? this.m_splitSizeRight : 640;
            case BOTTOM:
                if (this.m_splitSizeBottom != 0) {
                    return this.m_splitSizeBottom;
                }
                return 360;
            default:
                return 0;
        }
    }

    public void setSplitScreenSize(int i) {
        if (!supportsSplitScreen()) {
            throw new UnsupportedOperationException();
        }
        switch (getSplitScreenType()) {
            case LEFT:
                this.m_splitSizeLeft = i;
                return;
            case TOP:
                this.m_splitSizeTop = i;
                return;
            case RIGHT:
                this.m_splitSizeRight = i;
                return;
            case BOTTOM:
                this.m_splitSizeBottom = i;
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0002. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean isOptionApplied(int i) {
        switch (i) {
            case R.id.opt_color_adj /* 2131820646 */:
                if (this instanceof NexTimelineItem.e) {
                    NexTimelineItem.e eVar = (NexTimelineItem.e) this;
                    return (eVar.getBrightness() == 0 && eVar.getContrast() == 0 && eVar.getSaturation() == 0) ? false : true;
                }
                return super.isOptionApplied(i);
            case R.id.opt_color_tint /* 2131820648 */:
                if (this instanceof NexTimelineItem.g) {
                    ColorEffect colorEffect = ((NexTimelineItem.g) this).getColorEffect();
                    return (colorEffect == null || colorEffect.equals(ColorEffect.NONE)) ? false : true;
                }
                return super.isOptionApplied(i);
            case R.id.opt_in_expression /* 2131820657 */:
                return getLayerExpression(LayerExpression.Type.In) != LayerExpression.None;
            case R.id.opt_layer_mask /* 2131820658 */:
                return isLayerMaskEnabled();
            case R.id.opt_layer_name /* 2131820659 */:
                return this.mLayerName != null && this.mLayerName.trim().length() > 0;
            case R.id.opt_out_expression /* 2131820663 */:
                return getLayerExpression(LayerExpression.Type.Out) != LayerExpression.None;
            case R.id.opt_overall_expression /* 2131820665 */:
                return getLayerExpression(LayerExpression.Type.Overall) != LayerExpression.None;
            case R.id.opt_splitscreen /* 2131820673 */:
                return isSplitScreenEnabled();
            case R.id.opt_volume /* 2131820691 */:
                if (this instanceof NexTimelineItem.d) {
                    return ((NexTimelineItem.d) this).getClipVolume() != 100 || ((NexTimelineItem.d) this).getMuteAudio();
                }
                return super.isOptionApplied(i);
            case R.id.opt_volume_env /* 2131820693 */:
                return isVolumeEnvelopeApplied();
            default:
                return super.isOptionApplied(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean isVolumeEnvelopeApplied() {
        if (!(this instanceof nb)) {
            return false;
        }
        nb nbVar = (nb) this;
        int volumeEnvelopeLength = nbVar.getVolumeEnvelopeLength();
        for (int i = 0; i < volumeEnvelopeLength; i++) {
            if (nbVar.getVolumeEnvelopeLevel(i) != 100) {
                return true;
            }
        }
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.q
    public void setFlipH(boolean z) {
        if (this.m_flipV != z) {
            this.m_flipV = z;
            for (b bVar : c()) {
                bVar.e = 180.0f - bVar.e;
            }
            b splitScreenKeyframe = getSplitScreenKeyframe();
            splitScreenKeyframe.e = 180.0f - splitScreenKeyframe.e;
            if (isSplitScreenEnabled()) {
                fitKeyframeToSplitscreenRect(splitScreenKeyframe);
            }
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.q
    public void setFlipV(boolean z) {
        if (this.m_flipH != z) {
            this.m_flipH = z;
            for (b bVar : c()) {
                bVar.e = 180.0f - bVar.e;
            }
            b splitScreenKeyframe = getSplitScreenKeyframe();
            splitScreenKeyframe.e = 180.0f - splitScreenKeyframe.e;
            if (isSplitScreenEnabled()) {
                fitKeyframeToSplitscreenRect(splitScreenKeyframe);
            }
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.q
    public void setRotation(int i) {
        for (b bVar : getKeyFrames()) {
            bVar.e += i;
            if (bVar.e >= 360.0f || bVar.e <= -360.0f) {
                bVar.e %= 360.0f;
            }
            if (isSplitScreenEnabled()) {
                fitKeyframeToSplitscreenRect(bVar);
            }
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.q
    public boolean getFlipH() {
        return this.m_flipV;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.q
    public boolean getFlipV() {
        return this.m_flipH;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.q
    public int getRotation() {
        List<b> keyFrames = getKeyFrames();
        if (keyFrames == null || keyFrames.get(0) == null) {
            return 0;
        }
        return (int) keyFrames.get(0).e;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.a
    public int getAlpha() {
        return this.mAlpha;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.a
    public void setAlpha(int i) {
        this.mAlpha = i;
    }
}
