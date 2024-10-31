package com.nexstreaming.kinemaster.editorwrapper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.general.iab.PurchaseType;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.LayerExpression;
import com.nexstreaming.kinemaster.layer.BlendMode;
import com.nexstreaming.kinemaster.layer.SplitScreenType;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.ui.projectedit.C1916ib;
import com.nexstreaming.kinemaster.ui.projectedit.Vh;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2028i;
import com.nexstreaming.kinemaster.ui.widget.ClipThumbView;
import com.nexstreaming.kinemaster.ui.widget.KeyFrameDrawingView;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.ColorEffect;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class NexLayerItem extends NexSecondaryTimelineItem implements NexTimelineItem.o, NexTimelineItem.u, NexTimelineItem.a, NexTimelineItem.t, NexTimelineItem.s, NexTimelineItem.c {

    /* renamed from: f, reason: collision with root package name */
    private static Rect f20221f = new Rect();

    /* renamed from: g, reason: collision with root package name */
    private static b f20222g = new b();
    private int endTime;
    private int endTrim;
    private Object expressionState;

    /* renamed from: h, reason: collision with root package name */
    private transient Bitmap f20223h;
    private transient float j;
    private transient Rect k;
    private transient RectF l;
    private transient List<b> m;
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
    private RectF mCropBounds = null;
    private boolean mUseCropMask = false;
    private int mCropShapeId = 0;
    private float mCropMaskFeather = 0.0f;
    private transient boolean i = false;
    private int mNaturalOrientation = 0;
    private boolean useCustomMask = false;
    private AbstractRunnableC1763qa renderIn = new C1764ra(this);
    private AbstractRunnableC1763qa renderOut = new C1766sa(this);
    private AbstractRunnableC1763qa renderInPostCrop = new C1768ta(this);
    private AbstractRunnableC1763qa renderOutPostCrop = new C1770ua(this);
    private AbstractRunnableC1763qa renderOverall = new C1772va(this);
    private int layerInExpression = LayerExpression.None.getId();
    private int layerInExpressionDuration = 1000;
    private int layerOutExpression = LayerExpression.None.getId();
    private int layerOutExpressionDuration = 1000;
    private int layerOverallExpression = LayerExpression.None.getId();
    private float layerOverallExpressionSpeed = 1.0f;
    private BlendMode layerBlendMode = BlendMode.NONE;
    private boolean mIsVisibleLockIcon = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum DragType {
        START,
        END,
        FXSTART,
        FXEND
    }

    /* loaded from: classes.dex */
    public static class b implements Comparable<b> {

        /* renamed from: a, reason: collision with root package name */
        public float f20230a = 0.0f;

        /* renamed from: b, reason: collision with root package name */
        public float f20231b = 1.0f;

        /* renamed from: c, reason: collision with root package name */
        public float f20232c = EditorGlobal.n() / 2;

        /* renamed from: d, reason: collision with root package name */
        public float f20233d = EditorGlobal.m() / 2;

        /* renamed from: e, reason: collision with root package name */
        public float f20234e = 0.0f;

        /* renamed from: f, reason: collision with root package name */
        public float f20235f = 1.0f;

        /* renamed from: g, reason: collision with root package name */
        public float f20236g = 1.0f;

        /* renamed from: h, reason: collision with root package name */
        public float f20237h = 1.0f;

        public b() {
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            float f2 = this.f20230a;
            float f3 = bVar.f20230a;
            if (f2 < f3) {
                return -1;
            }
            return f2 > f3 ? 1 : 0;
        }

        public void b(b bVar) {
            this.f20230a = bVar.f20230a;
            this.f20231b = bVar.f20231b;
            this.f20232c = bVar.f20232c;
            this.f20233d = bVar.f20233d;
            this.f20234e = bVar.f20234e;
            this.f20235f = bVar.f20235f;
            this.f20236g = bVar.f20236g;
            this.f20237h = bVar.f20237h;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return obj == this;
            }
            b bVar = (b) obj;
            return bVar.f20231b == this.f20231b && bVar.f20232c == this.f20232c && bVar.f20233d == this.f20233d && bVar.f20234e == this.f20234e && bVar.f20230a == this.f20230a && bVar.f20235f == this.f20235f && bVar.f20236g == this.f20236g && bVar.f20237h == this.f20237h;
        }

        public int hashCode() {
            return ((((((((((((((0 + ((int) (this.f20232c * 1000.0f))) * 31) + ((int) (this.f20233d * 1000.0f))) * 31) + ((int) (this.f20231b * 10000.0f))) * 31) + ((int) (this.f20235f * 256.0f))) * 31) + ((int) (this.f20234e * 360.0f))) * 31) + ((int) (this.f20230a * 100000.0f))) * 31) + ((int) (this.f20236g * 100000.0f))) * 31) + ((int) (this.f20237h * 100000.0f));
        }

        public String toString() {
            return "[LayerKeyframe @" + this.f20230a + ":  " + this.f20232c + "," + this.f20233d + " scale=" + this.f20231b + " angle=" + this.f20234e + " alpha=" + this.f20235f + " scale x=" + this.f20236g + " scale y=" + this.f20237h + "]";
        }

        public KMProto.KMProject.KeyFrame a() {
            KMProto.KMProject.KeyFrame.Builder builder = new KMProto.KMProject.KeyFrame.Builder();
            builder.time = Float.valueOf(this.f20230a);
            builder.scale = Float.valueOf(this.f20231b);
            builder.x = Float.valueOf(this.f20232c);
            builder.y = Float.valueOf(this.f20233d);
            builder.angle = Float.valueOf(this.f20234e);
            builder.alpha = Float.valueOf(this.f20235f);
            builder.scalex = Float.valueOf(this.f20236g);
            builder.scaley = Float.valueOf(this.f20237h);
            return builder.build();
        }

        public b(b bVar) {
            b(bVar);
        }

        public static b a(KMProto.KMProject.KeyFrame keyFrame) {
            b bVar = new b();
            bVar.f20234e = keyFrame.angle.floatValue();
            bVar.f20230a = keyFrame.time.floatValue();
            bVar.f20231b = keyFrame.scale.floatValue();
            bVar.f20232c = keyFrame.x.floatValue();
            bVar.f20233d = keyFrame.y.floatValue();
            bVar.f20235f = keyFrame.alpha.floatValue();
            Float f2 = keyFrame.scalex;
            if (f2 == null) {
                f2 = keyFrame.scale;
            }
            bVar.f20236g = f2.floatValue();
            Float f3 = keyFrame.scaley;
            if (f3 == null) {
                f3 = keyFrame.scale;
            }
            bVar.f20237h = f3.floatValue();
            return bVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public float f20238a;

        /* renamed from: b, reason: collision with root package name */
        public float f20239b;

        /* renamed from: c, reason: collision with root package name */
        public float f20240c;

        public String toString() {
            return "[ScaleRange min=" + this.f20238a + " max=" + this.f20239b + " avg=" + this.f20240c + "]";
        }
    }

    private void a(LayerRenderer layerRenderer, boolean z) {
        float splitScreenSize;
        float f2;
        int splitScreenSize2;
        int i;
        layerRenderer.x();
        layerRenderer.c();
        layerRenderer.a(LayerRenderer.RenderTarget.Mask);
        int n = EditorGlobal.n();
        int m = EditorGlobal.m();
        int i2 = C1778ya.f20378a[getSplitScreenType().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    layerRenderer.c(-1, n - getSplitScreenSize(), 0.0f, n, m);
                    layerRenderer.d(true);
                    splitScreenSize = n - (getSplitScreenSize() / 2);
                    i = m / 2;
                } else if (i2 == 4) {
                    layerRenderer.c(-1, 0.0f, m - getSplitScreenSize(), n, m);
                    layerRenderer.d(true);
                    splitScreenSize = n / 2;
                    splitScreenSize2 = getSplitScreenSize() / 2;
                } else if (i2 == 5) {
                    layerRenderer.c(-1, 0.0f, 0.0f, n, m);
                    layerRenderer.d(true);
                    splitScreenSize = n / 2;
                    i = m / 2;
                } else {
                    throw new IllegalStateException();
                }
                f2 = i;
            } else {
                layerRenderer.c(-1, 0.0f, 0.0f, n, getSplitScreenSize());
                layerRenderer.d(true);
                splitScreenSize = n / 2;
                splitScreenSize2 = getSplitScreenSize() / 2;
            }
            f2 = splitScreenSize2;
        } else {
            layerRenderer.c(-1, 0.0f, 0.0f, getSplitScreenSize(), m);
            splitScreenSize = getSplitScreenSize() / 2;
            f2 = m / 2;
            layerRenderer.d(true);
        }
        layerRenderer.a(LayerRenderer.RenderTarget.Normal);
        getInterpolatedKeyframe(getScaledTime(layerRenderer.f()), f20222g, true);
        b bVar = f20222g;
        layerRenderer.b(bVar.f20232c, bVar.f20233d);
        if (this.k == null) {
            this.k = new Rect();
        }
        if (this.l == null) {
            this.l = new RectF();
        }
        RectF rectF = this.l;
        getBounds(this.k);
        rectF.set(this.k);
        if (z) {
            AbstractRunnableC1763qa abstractRunnableC1763qa = this.renderIn;
            int i3 = this.layerInExpression;
            b bVar2 = f20222g;
            abstractRunnableC1763qa.a(layerRenderer, i3, splitScreenSize - bVar2.f20232c, f2 - bVar2.f20233d, layerRenderer.f() - getAbsStartTime(), getDuration(), this.layerInExpressionDuration, d(), this.mNaturalOrientation);
        } else {
            layerRenderer.a(layerRenderer.d() * (getAlpha() / 255.0f));
            layerRenderer.a(f20222g.f20234e, 0.0f, 0.0f);
            float f3 = f20222g.f20231b;
            layerRenderer.b(f3, f3, 0.0f, 0.0f);
            layerRenderer.a(this.m_flipH ? -1.0f : 1.0f, this.m_flipV ? -1.0f : 1.0f);
            onRender(layerRenderer, f20222g, false);
        }
        layerRenderer.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF d() {
        if (this.k == null) {
            this.k = new Rect();
        }
        getExtendedBounds(this.k);
        RectF rectF = new RectF(this.k);
        float f2 = rectF.left;
        b bVar = f20222g;
        float f3 = bVar.f20236g;
        rectF.left = f2 * f3;
        float f4 = rectF.top;
        float f5 = bVar.f20237h;
        rectF.top = f4 * f5;
        rectF.right *= f3;
        rectF.bottom *= f5;
        return rectF;
    }

    private List<b> e() {
        if (isSplitScreenEnabled()) {
            if (this.m == null) {
                this.m = Collections.singletonList(getSplitScreenKeyframe());
            }
            return this.m;
        }
        a();
        return this.mKeyFrames;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void fromProtoBuf(KMProto.KMProject.LayerCommon layerCommon, NexLayerItem nexLayerItem) {
        Integer num = layerCommon.start_time;
        if (num != null) {
            nexLayerItem.startTime = num.intValue();
        }
        Integer num2 = layerCommon.end_time;
        if (num2 != null) {
            nexLayerItem.endTime = num2.intValue();
        }
        Integer num3 = layerCommon.start_trim;
        if (num3 != null) {
            nexLayerItem.startTrim = num3.intValue();
        }
        Integer num4 = layerCommon.end_trim;
        if (num4 != null) {
            nexLayerItem.endTrim = num4.intValue();
        }
        String str = layerCommon.layer_name;
        if (str != null) {
            nexLayerItem.mLayerName = str;
        }
        if (layerCommon.layer_expression != null) {
            Integer num5 = layerCommon.layer_expression_duration;
            int intValue = num5 != null ? num5.intValue() : 1000;
            LayerExpression fromId = LayerExpression.fromId(layerCommon.layer_expression.intValue());
            if (fromId.getType() == LayerExpression.Type.Legacy) {
                LayerExpression legacyInExpression = fromId.getLegacyInExpression();
                LayerExpression legacyOutExpression = fromId.getLegacyOutExpression();
                LayerExpression legacyOverallExpression = fromId.getLegacyOverallExpression();
                if (legacyInExpression != null) {
                    nexLayerItem.layerInExpression = legacyInExpression.getId();
                    nexLayerItem.layerInExpressionDuration = intValue;
                }
                if (legacyOutExpression != null) {
                    nexLayerItem.layerOutExpression = legacyOutExpression.getId();
                    nexLayerItem.layerOutExpressionDuration = intValue;
                }
                if (legacyOverallExpression != null) {
                    nexLayerItem.layerOverallExpression = legacyOverallExpression.getId();
                    nexLayerItem.layerOverallExpressionSpeed = 1.0f;
                }
            }
        }
        Integer num6 = layerCommon.layer_in_expression;
        if (num6 != null) {
            nexLayerItem.layerInExpression = num6.intValue();
        }
        Integer num7 = layerCommon.layer_in_expression_duration;
        if (num7 != null) {
            nexLayerItem.layerInExpressionDuration = num7.intValue();
        }
        Integer num8 = layerCommon.layer_out_expression;
        if (num8 != null) {
            nexLayerItem.layerOutExpression = num8.intValue();
        }
        Integer num9 = layerCommon.layer_out_expression_duration;
        if (num9 != null) {
            nexLayerItem.layerOutExpressionDuration = num9.intValue();
        }
        Integer num10 = layerCommon.layer_overall_expression;
        if (num10 != null) {
            nexLayerItem.layerOverallExpression = num10.intValue();
        }
        Float f2 = layerCommon.layer_overall_expression_speed;
        if (f2 != null) {
            nexLayerItem.layerOverallExpressionSpeed = f2.floatValue();
        }
        Float f3 = layerCommon.crop_mask_feather;
        if (f3 != null) {
            nexLayerItem.mCropMaskFeather = f3.floatValue();
        }
        Long l = layerCommon.z_order;
        if (l != null) {
            nexLayerItem.zOrder = l.longValue();
        }
        Boolean bool = layerCommon.pinned;
        if (bool != null) {
            nexLayerItem.pinned = bool.booleanValue();
        }
        Boolean bool2 = layerCommon.flip_h;
        if (bool2 != null) {
            nexLayerItem.m_flipH = bool2.booleanValue();
        }
        Boolean bool3 = layerCommon.flip_v;
        if (bool3 != null) {
            nexLayerItem.m_flipV = bool3.booleanValue();
        }
        Integer num11 = layerCommon.overall_alpha;
        if (num11 != null) {
            nexLayerItem.mAlpha = num11.intValue();
        } else {
            nexLayerItem.mAlpha = 255;
        }
        Float f4 = layerCommon.crop_bounds_left;
        if (f4 != null) {
            nexLayerItem.mCropBounds = new RectF(f4.floatValue(), layerCommon.crop_bounds_top.floatValue(), layerCommon.crop_bounds_right.floatValue(), layerCommon.crop_bounds_bottom.floatValue());
        } else {
            nexLayerItem.mCropBounds = null;
        }
        Boolean bool4 = layerCommon.use_crop_mask;
        if (bool4 != null) {
            nexLayerItem.mUseCropMask = bool4.booleanValue();
        }
        Integer num12 = layerCommon.crop_bounds_shape;
        if (num12 != null) {
            nexLayerItem.mCropShapeId = num12.intValue();
        }
        List<KMProto.KMProject.KeyFrame> list = layerCommon.keyframes;
        if (list != null && list.size() > 0) {
            nexLayerItem.mKeyFrames = new CopyOnWriteArrayList();
            Iterator<KMProto.KMProject.KeyFrame> it = layerCommon.keyframes.iterator();
            while (it.hasNext()) {
                nexLayerItem.addInOrder(nexLayerItem.mKeyFrames, b.a(it.next()));
            }
        }
        KMProto.KMProject.KeyFrame keyFrame = layerCommon.split_keyframe;
        if (keyFrame != null) {
            nexLayerItem.mSplitScreenKeyFrame = b.a(keyFrame);
        }
        Integer num13 = layerCommon.natural_orientation;
        if (num13 != null) {
            nexLayerItem.mNaturalOrientation = num13.intValue();
        }
        Integer num14 = layerCommon.split_size_bottom;
        nexLayerItem.m_splitSizeBottom = num14 == null ? 0 : num14.intValue();
        Integer num15 = layerCommon.split_size_top;
        nexLayerItem.m_splitSizeTop = num15 == null ? 0 : num15.intValue();
        Integer num16 = layerCommon.split_size_left;
        nexLayerItem.m_splitSizeLeft = num16 == null ? 0 : num16.intValue();
        Integer num17 = layerCommon.split_size_right;
        nexLayerItem.m_splitSizeRight = num17 == null ? 0 : num17.intValue();
        nexLayerItem.m_splitScreenType = SplitScreenType.fromProtoBuf(layerCommon.split_screen_type);
        Integer num18 = layerCommon.layermask_index;
        nexLayerItem.mLayerMaskIndex = num18 == null ? 0 : num18.intValue();
        Boolean bool5 = layerCommon.layermask_enabled;
        nexLayerItem.mLayerMaskEnabled = bool5 != null ? bool5.booleanValue() : false;
        Integer num19 = layerCommon.layermask_type;
        nexLayerItem.mLayerMaskMode = num19 == null ? LayerMaskMode.Contributes : LayerMaskMode.fromId(num19.intValue());
        nexLayerItem.layerBlendMode = getBlendModeFromProtoBuf(layerCommon.blend_mode);
    }

    static BlendMode getBlendModeFromProtoBuf(KMProto.KMProject.LayerBlendModeType layerBlendModeType) {
        if (layerBlendModeType == null) {
            return BlendMode.NONE;
        }
        for (BlendMode blendMode : BlendMode.values()) {
            if (blendMode.getBlendModeType() == layerBlendModeType) {
                return blendMode;
            }
        }
        return BlendMode.NONE;
    }

    public <T extends Comparable<T>> int addInOrder(List<T> list, T t) {
        int i;
        synchronized (this.mLock) {
            int binarySearch = Collections.binarySearch(list, t);
            i = binarySearch < 0 ? -(binarySearch + 1) : binarySearch + 1;
            list.add(i, t);
        }
        return i;
    }

    public b addKeyframe(float f2) {
        if (!isSplitScreenEnabled()) {
            a();
            b interpolatedKeyframe = getInterpolatedKeyframe(f2);
            addInOrder(this.mKeyFrames, interpolatedKeyframe);
            return interpolatedKeyframe;
        }
        throw new IllegalStateException();
    }

    public b addKeyframeWithoutCheck(b bVar) {
        addInOrder(this.mKeyFrames, bVar);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adjustForPivotChange(float f2, float f3) {
        a();
        for (b bVar : this.mKeyFrames) {
            bVar.f20232c += f2;
            bVar.f20233d += f3;
        }
        b splitScreenKeyframe = getSplitScreenKeyframe();
        splitScreenKeyframe.f20232c += f2;
        splitScreenKeyframe.f20233d += f3;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public NexTimelineItem.x beginTrim(NexTimelineItem.y yVar, int i) {
        int duration;
        if (i == 0) {
            return null;
        }
        if (i == 1) {
            duration = this.startTime;
        } else {
            duration = getDuration();
        }
        return new C1774wa(this, i, duration, Math.max(100, (int) (((int) TypedValue.applyDimension(1, 15.0f, yVar.getResources().getDisplayMetrics())) / yVar.a().f())), yVar);
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem, com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa
    public void bindView(View view, InterfaceC2028i interfaceC2028i) {
        super.bindView(view, interfaceC2028i);
        ImageView imageView = (ImageView) view.findViewById(R.id.clip_type_icon);
        TextView textView = (TextView) view.findViewById(R.id.clip_label);
        ClipThumbView clipThumbView = (ClipThumbView) view.findViewById(R.id.thumbnail_view);
        if (!checkResourceState(view.getContext())) {
            clipThumbView.a(false);
            imageView.setAlpha(0.5f);
            textView.setAlpha(0.5f);
        } else {
            clipThumbView.a(null, this);
        }
        int icon = getIcon();
        if (this.mIsVisibleLockIcon) {
            icon = R.drawable.timeline_item_lock_icon;
        }
        if (icon != 0) {
            imageView.setImageResource(icon);
        }
        String layerName = getLayerName();
        if (TextUtils.isEmpty(layerName)) {
            layerName = getLabelText(view.getContext());
        }
        textView.setText(layerName);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        boolean drawThumbnails = drawThumbnails(null, new Canvas(), new RectF(rect));
        if (this.pinned) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.pin_icon);
            imageView2.setVisibility(0);
            imageView2.setImageResource(drawThumbnails ? R.drawable.pin_light : R.drawable.pin_dark);
        } else {
            ((ImageView) view.findViewById(R.id.pin_icon)).setVisibility(8);
        }
        List<b> keyFrames = getKeyFrames();
        KeyFrameDrawingView keyFrameDrawingView = (KeyFrameDrawingView) view.findViewById(R.id.key_frame_drawing_view);
        if ((interfaceC2028i.a() && interfaceC2028i.b() == R.id.editmode_layer_anim) || (keyFrames != null && keyFrames.size() > 1 && interfaceC2028i.b() != R.id.editmode_volume_adjust)) {
            keyFrameDrawingView.a(getKeyFrames(), getDuration());
            keyFrameDrawingView.setVisibility(0);
        } else {
            keyFrameDrawingView.setVisibility(8);
        }
    }

    public void clearExpressionState() {
        this.expressionState = null;
    }

    protected boolean drawThumbnails(C1916ib c1916ib, Canvas canvas, RectF rectF) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void fitKeyframeToSplitscreenRect(com.nexstreaming.kinemaster.editorwrapper.NexLayerItem.b r12) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.editorwrapper.NexLayerItem.fitKeyframeToSplitscreenRect(com.nexstreaming.kinemaster.editorwrapper.NexLayerItem$b):void");
    }

    public RectF flipHorizontal(RectF rectF) {
        return new RectF(-rectF.right, rectF.bottom, -rectF.left, rectF.top);
    }

    public RectF flipVertical(RectF rectF) {
        return new RectF(rectF.right, -rectF.bottom, rectF.left, -rectF.top);
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

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.a
    public int getAlpha() {
        return this.mAlpha;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public NexPrimaryTimelineItem getAnchorItem() {
        return null;
    }

    protected abstract int getBGColor();

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.c
    public BlendMode getBlendMode() {
        return this.layerBlendMode;
    }

    public abstract void getBounds(Rect rect);

    public RectF getBoundsWithOrientation(RectF rectF, int i) {
        if (i != 90) {
            if (i == 180) {
                return new RectF(rectF.right, rectF.top, rectF.left, rectF.bottom);
            }
            if (i != 270) {
                return rectF;
            }
        }
        return new RectF(rectF.top, rectF.left, rectF.bottom, rectF.right);
    }

    public float getClipWidth() {
        return this.j;
    }

    public b getClosestKeyframe(float f2) {
        if (isSplitScreenEnabled()) {
            return getSplitScreenKeyframe();
        }
        a();
        float f3 = 0.0f;
        b bVar = null;
        for (b bVar2 : this.mKeyFrames) {
            float abs = Math.abs(bVar2.f20230a - f2);
            if (abs < f3 || bVar == null) {
                bVar = bVar2;
                f3 = abs;
            }
        }
        return bVar;
    }

    public boolean getCropBounds(RectF rectF) {
        RectF rectF2 = this.mCropBounds;
        if (rectF2 == null) {
            return false;
        }
        rectF.set(rectF2);
        return true;
    }

    public float getCropMaskFeather() {
        return this.mCropMaskFeather;
    }

    public int getCropShape() {
        return this.mCropShapeId;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getDuration() {
        return this.endTime - this.startTime;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getEndTime() {
        return this.endTime;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getEndTrim() {
        return this.endTrim;
    }

    public void getExtendedBounds(Rect rect) {
        getBounds(rect);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.s
    public boolean getFlipH() {
        return this.m_flipH;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.s
    public boolean getFlipV() {
        return this.m_flipV;
    }

    public abstract int getHeight();

    protected abstract int getIcon();

    public b getInterpolatedKeyframe(float f2) {
        b bVar = new b();
        getInterpolatedKeyframe(f2, bVar, true);
        return bVar;
    }

    public b getInterpolatedKeyframeIgnoreSplitScreen(float f2) {
        b bVar = new b();
        getInterpolatedKeyframe(f2, bVar, false);
        return bVar;
    }

    public List<b> getKeyFrames() {
        if (isSplitScreenEnabled()) {
            getSplitScreenKeyframe();
            return Collections.singletonList(this.mSplitScreenKeyFrame);
        }
        a();
        return Collections.unmodifiableList(this.mKeyFrames);
    }

    public List<b> getKeyFramesIgnoreSplitScreen() {
        a();
        return Collections.unmodifiableList(this.mKeyFrames);
    }

    protected String getLabelText(Context context) {
        return getDescriptiveTitle(context);
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
        builder.crop_mask_feather = Float.valueOf(this.mCropMaskFeather);
        builder.overall_alpha = Integer.valueOf(this.mAlpha);
        builder.split_size_bottom = Integer.valueOf(this.m_splitSizeBottom);
        builder.split_size_top = Integer.valueOf(this.m_splitSizeTop);
        builder.split_size_left = Integer.valueOf(this.m_splitSizeLeft);
        builder.split_size_right = Integer.valueOf(this.m_splitSizeRight);
        SplitScreenType splitScreenType = this.m_splitScreenType;
        builder.split_screen_type = splitScreenType == null ? KMProto.KMProject.SplitScreenType.OFF : splitScreenType.asProtoBuf();
        builder.layermask_enabled = Boolean.valueOf(this.mLayerMaskEnabled);
        builder.layermask_type = Integer.valueOf(this.mLayerMaskMode.getId());
        builder.layermask_index = Integer.valueOf(this.mLayerMaskIndex);
        builder.layer_name = this.mLayerName;
        RectF rectF = this.mCropBounds;
        if (rectF != null) {
            builder.crop_bounds_left = Float.valueOf(rectF.left);
            builder.crop_bounds_right = Float.valueOf(this.mCropBounds.right);
            builder.crop_bounds_top = Float.valueOf(this.mCropBounds.top);
            builder.crop_bounds_bottom = Float.valueOf(this.mCropBounds.bottom);
        } else {
            builder.crop_bounds_left = null;
            builder.crop_bounds_right = null;
            builder.crop_bounds_top = null;
            builder.crop_bounds_bottom = null;
        }
        boolean z = this.mUseCropMask;
        if (z) {
            builder.use_crop_mask = Boolean.valueOf(z);
        }
        int i = this.mCropShapeId;
        if (i != 0) {
            builder.crop_bounds_shape = Integer.valueOf(i);
        }
        builder.natural_orientation = Integer.valueOf(this.mNaturalOrientation);
        List<b> list = this.mKeyFrames;
        if (list != null) {
            builder.keyframes = new ArrayList(list.size());
            Iterator<b> it = this.mKeyFrames.iterator();
            while (it.hasNext()) {
                builder.keyframes.add(it.next().a());
            }
        }
        if (this.mSplitScreenKeyFrame != null) {
            builder.split_keyframe = getSplitScreenKeyframe().a();
        }
        builder.blend_mode = this.layerBlendMode.getBlendModeType();
        return builder.build();
    }

    public LayerExpression getLayerExpression(LayerExpression.Type type) {
        int i = C1778ya.f20379b[type.ordinal()];
        if (i == 1) {
            return LayerExpression.fromId(this.layerInExpression);
        }
        if (i == 2) {
            return LayerExpression.fromId(this.layerOutExpression);
        }
        if (i == 3) {
            return LayerExpression.fromId(this.layerOverallExpression);
        }
        throw new IllegalArgumentException();
    }

    public int getLayerExpressionDuration(LayerExpression.Type type) {
        int i = C1778ya.f20379b[type.ordinal()];
        if (i == 1) {
            return this.layerInExpressionDuration;
        }
        if (i == 2) {
            return this.layerOutExpressionDuration;
        }
        throw new IllegalArgumentException();
    }

    public float getLayerExpressionSpeed(LayerExpression.Type type) {
        if (C1778ya.f20379b[type.ordinal()] == 3) {
            return this.layerOverallExpressionSpeed;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.o
    public int getLayerMaskIndex() {
        return this.mLayerMaskIndex;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.o
    public LayerMaskMode getLayerMaskMode() {
        return this.mLayerMaskMode;
    }

    public String getLayerName() {
        return this.mLayerName;
    }

    public int getOrientation() {
        return this.mNaturalOrientation;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public boolean getPinned() {
        return this.pinned;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getRelativeEndTime() {
        return this.startTime;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getRelativeStartTime() {
        return this.endTime;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getRepresentedDuration() {
        return getDuration();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.s
    public int getRotation() {
        List<b> keyFrames = getKeyFrames();
        if (keyFrames == null || keyFrames.get(0) == null) {
            return 0;
        }
        return (int) keyFrames.get(0).f20234e;
    }

    public c getScaleRange() {
        c cVar = new c();
        getScaleRange(cVar);
        return cVar;
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
        float f2 = absStartTime;
        return (i - f2) / (absEndTime - f2);
    }

    public b getSplitScreenKeyframe() {
        if (this.mSplitScreenKeyFrame == null) {
            this.mSplitScreenKeyFrame = new b();
            b bVar = this.mSplitScreenKeyFrame;
            bVar.f20231b = 0.1f;
            bVar.f20236g = 0.1f;
            bVar.f20237h = 0.1f;
            int i = this.mNaturalOrientation;
            if (i != 90 && i != 270) {
                bVar.f20234e = i;
            } else {
                this.mSplitScreenKeyFrame.f20234e = 360 - this.mNaturalOrientation;
            }
            fitKeyframeToSplitscreenRect(this.mSplitScreenKeyFrame);
        }
        return this.mSplitScreenKeyFrame;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.t
    public int getSplitScreenSize() {
        if (supportsSplitScreen()) {
            int n = EditorGlobal.n();
            int m = EditorGlobal.m();
            int i = C1778ya.f20378a[getSplitScreenType().ordinal()];
            if (i == 1) {
                int i2 = this.m_splitSizeLeft;
                return i2 == 0 ? n / 2 : i2;
            }
            if (i == 2) {
                int i3 = this.m_splitSizeTop;
                return i3 == 0 ? m / 2 : i3;
            }
            if (i == 3) {
                int i4 = this.m_splitSizeRight;
                return i4 == 0 ? n / 2 : i4;
            }
            if (i != 4) {
                return 0;
            }
            int i5 = this.m_splitSizeBottom;
            return i5 == 0 ? m / 2 : i5;
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.t
    public SplitScreenType getSplitScreenType() {
        if (!supportsSplitScreen()) {
            return SplitScreenType.OFF;
        }
        SplitScreenType splitScreenType = this.m_splitScreenType;
        return splitScreenType == null ? SplitScreenType.OFF : splitScreenType;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getStartTime() {
        return this.startTime;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getStartTrim() {
        return this.startTrim;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa
    public int getTimelineViewLayoutResource() {
        return R.layout.timeline_item_secondary;
    }

    public abstract int getWidth();

    public long getZOrder() {
        return this.zOrder;
    }

    public float interpolate(float f2) {
        return f2;
    }

    public boolean isAvailableAsset(PurchaseType purchaseType, Context context) {
        return true;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.o
    public boolean isLayerMaskEnabled() {
        return this.mLayerMaskEnabled;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean isOptionApplied(int i) {
        switch (i) {
            case R.id.opt_alpha_adj /* 2131363085 */:
                return getAlpha() != 255;
            case R.id.opt_color_adj /* 2131363104 */:
                if (this instanceof NexTimelineItem.f) {
                    NexTimelineItem.f fVar = (NexTimelineItem.f) this;
                    return (fVar.getBrightness() == 0 && fVar.getContrast() == 0 && fVar.getSaturation() == 0) ? false : true;
                }
                break;
            case R.id.opt_color_filter /* 2131363106 */:
            case R.id.opt_color_tint /* 2131363107 */:
                if (this instanceof NexTimelineItem.h) {
                    ColorEffect colorEffect = ((NexTimelineItem.h) this).getColorEffect();
                    return (colorEffect == null || colorEffect.equals(ColorEffect.NONE)) ? false : true;
                }
                break;
            case R.id.opt_in_expression /* 2131363119 */:
                return getLayerExpression(LayerExpression.Type.In) != LayerExpression.None;
            case R.id.opt_information /* 2131363120 */:
                String str = this.mLayerName;
                return str != null && str.trim().length() > 0;
            case R.id.opt_layer_mask /* 2131363125 */:
                return isLayerMaskEnabled();
            case R.id.opt_out_expression /* 2131363132 */:
                return getLayerExpression(LayerExpression.Type.Out) != LayerExpression.None;
            case R.id.opt_overall_expression /* 2131363134 */:
                return getLayerExpression(LayerExpression.Type.Overall) != LayerExpression.None;
            case R.id.opt_splitscreen /* 2131363144 */:
                return isSplitScreenEnabled();
            case R.id.opt_volume /* 2131363166 */:
                if (this instanceof NexTimelineItem.e) {
                    NexTimelineItem.e eVar = (NexTimelineItem.e) this;
                    return eVar.getClipVolume() != 100 || eVar.getMuteAudio();
                }
                break;
            case R.id.opt_volume_env /* 2131363168 */:
                return isVolumeEnvelopeApplied();
        }
        return super.isOptionApplied(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isPivotMovable() {
        a();
        for (b bVar : this.mKeyFrames) {
            if (Math.abs(bVar.f20234e) > 1.0E-6d || Math.abs(bVar.f20231b - 1.0f) > 1.0E-6d) {
                return false;
            }
        }
        b splitScreenKeyframe = getSplitScreenKeyframe();
        return ((double) Math.abs(splitScreenKeyframe.f20234e)) <= 1.0E-6d && ((double) Math.abs(splitScreenKeyframe.f20231b - 1.0f)) <= 1.0E-6d;
    }

    public final boolean isPointInLayerAtTime(float f2, float f3, int i) {
        if (isSplitScreenEnabled()) {
            return isPointInSplitScreenLayer(f2, f3);
        }
        getInterpolatedKeyframe(getScaledTime(i), f20222g, true);
        b bVar = f20222g;
        Matrix matrix = new Matrix();
        matrix.postTranslate(-bVar.f20232c, -bVar.f20233d);
        float f4 = bVar.f20231b;
        matrix.postScale(1.0f / f4, 1.0f / f4);
        matrix.postRotate(-bVar.f20234e, 0.0f, 0.0f);
        float[] fArr = {f2, f3};
        matrix.mapPoints(fArr);
        return isTransformedPointInLayerAtTime(fArr[0], fArr[1], i);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isPointInSplitScreenLayer(float r7, float r8) {
        /*
            r6 = this;
            boolean r0 = r6.isSplitScreenEnabled()
            if (r0 == 0) goto L66
            int r0 = com.nextreaming.nexeditorui.EditorGlobal.n()
            int r1 = com.nextreaming.nexeditorui.EditorGlobal.m()
            int[] r2 = com.nexstreaming.kinemaster.editorwrapper.C1778ya.f20378a
            com.nexstreaming.kinemaster.layer.SplitScreenType r3 = r6.getSplitScreenType()
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 1
            r4 = 0
            if (r2 == r3) goto L4c
            r5 = 2
            if (r2 == r5) goto L46
            r5 = 3
            if (r2 == r5) goto L3b
            r5 = 4
            if (r2 == r5) goto L31
            r5 = 5
            if (r2 != r5) goto L2b
            goto L50
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>()
            throw r7
        L31:
            int r2 = r6.getSplitScreenSize()
            int r2 = r1 - r2
            float r2 = (float) r2
            float r0 = (float) r0
            float r1 = (float) r1
            goto L53
        L3b:
            int r2 = r6.getSplitScreenSize()
            int r2 = r0 - r2
            float r2 = (float) r2
            float r0 = (float) r0
            float r1 = (float) r1
            r4 = r2
            goto L52
        L46:
            float r0 = (float) r0
            int r1 = r6.getSplitScreenSize()
            goto L51
        L4c:
            int r0 = r6.getSplitScreenSize()
        L50:
            float r0 = (float) r0
        L51:
            float r1 = (float) r1
        L52:
            r2 = 0
        L53:
            int r4 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r4 < 0) goto L64
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 > 0) goto L64
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 < 0) goto L64
            int r7 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r7 > 0) goto L64
            goto L65
        L64:
            r3 = 0
        L65:
            return r3
        L66:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.editorwrapper.NexLayerItem.isPointInSplitScreenLayer(float, float):boolean");
    }

    public boolean isSplitScreenEnabled() {
        if (supportsSplitScreen()) {
            if ((this.m_splitScreenType != null) & (this.m_splitScreenType != SplitScreenType.OFF)) {
                return true;
            }
        }
        return false;
    }

    public abstract boolean isTransformedPointInLayerAtTime(float f2, float f3, int i);

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean isTrimmable() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean isVolumeEnvelopeApplied() {
        if (!(this instanceof Vh)) {
            return false;
        }
        Vh vh = (Vh) this;
        int volumeEnvelopeLength = vh.getVolumeEnvelopeLength();
        for (int i = 0; i < volumeEnvelopeLength; i++) {
            if (vh.getVolumeEnvelopeLevel(i) != 100) {
                return true;
            }
        }
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void moveClip(int i) {
        this.endTime = (this.endTime - this.startTime) + i;
        this.startTime = i;
    }

    public boolean needRendererReawakeOnEditResize() {
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean onCustomDrag(NexTimelineItem.i iVar, NexTimelineItem.w wVar, float f2, float f3, float f4) {
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onCustomDragDone(NexTimelineItem.i iVar, NexTimelineItem.w wVar) {
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onCustomDragDone_v3(NexTimelineItem.i iVar, NexTimelineItem.w wVar) {
        ViewGroup viewGroup;
        a aVar = (a) iVar;
        WindowManager windowManager = aVar.k;
        if (windowManager != null && (viewGroup = aVar.j) != null) {
            windowManager.removeView(viewGroup);
            aVar.j = null;
        }
        DragType dragType = aVar.f20224c;
        if (dragType == DragType.END) {
            wVar.a(getAbsEndTime() - 1, true);
        } else if (dragType == DragType.START) {
            wVar.a(getAbsStartTime(), true);
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean onCustomDrag_v3(NexTimelineItem.i iVar, NexTimelineItem.w wVar, float f2, float f3, float f4) {
        a aVar = (a) iVar;
        int i = C1778ya.f20380c[aVar.f20224c.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            int i2 = aVar.f20225d + ((int) ((f2 / f4) * 1000.0f));
            int endTime = getEndTime() - i2 < 100 ? getEndTime() - 100 : i2;
            if (endTime < 0) {
                endTime = 0;
            }
            trimClip(endTime, getEndTime());
            aVar.i.invalidate();
            wVar.a(true);
            return true;
        }
        int startTime = getStartTime();
        int i3 = ((int) ((f2 / f4) * 1000.0f)) + aVar.f20225d;
        if (i3 < 100) {
            i3 = 100;
        }
        if (i3 > wVar.getTimeline().getTotalTime()) {
            i3 = wVar.getTimeline().getTotalTime();
        }
        trimClip(startTime, i3 + startTime);
        aVar.i.invalidate();
        wVar.a(true);
        return true;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onCustomPostDrag(NexTimelineItem.i iVar, Rect rect) {
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onCustomPostDrag_v3(NexTimelineItem.i iVar, Rect rect) {
        a aVar = (a) iVar;
        if (aVar.k == null || aVar.j == null) {
            return;
        }
        if (aVar.f20224c == DragType.END) {
            aVar.l.x = rect.right - (aVar.f20228g / 2);
        } else {
            aVar.l.x = rect.left - (aVar.f20228g / 2);
        }
        aVar.k.updateViewLayout(aVar.j, aVar.l);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public NexTimelineItem.k onDown(Context context, NexTimelineItem.w wVar, RectF rectF, int i, int i2, boolean z, int i3) {
        if (i3 == R.id.editmode_trim && z) {
            return onDown_trim(context, wVar, rectF, i, i2, z, i3);
        }
        return null;
    }

    public NexTimelineItem.k onDown_trim(Context context, NexTimelineItem.w wVar, RectF rectF, int i, int i2, boolean z, int i3) {
        int absEndTime;
        C1764ra c1764ra = null;
        if (i3 != R.id.editmode_trim) {
            return null;
        }
        int secondaryItemCount = getTimeline().getSecondaryItemCount();
        int i4 = 0;
        for (int i5 = 0; i5 < secondaryItemCount; i5++) {
            NexSecondaryTimelineItem secondaryItem = getTimeline().getSecondaryItem(i5);
            if (secondaryItem instanceof NexLayerItem) {
                NexLayerItem nexLayerItem = (NexLayerItem) secondaryItem;
                if (nexLayerItem.getAbsStartTime() <= getAbsEndTime() && (absEndTime = nexLayerItem.getAbsEndTime()) > i4) {
                    i4 = absEndTime;
                }
            }
        }
        if (rectF.width() < rectF.height() * 4.0f) {
            if (i < rectF.left + (rectF.width() / 2.0f)) {
                a aVar = new a(c1764ra);
                aVar.f20224c = DragType.START;
                aVar.n = context;
                aVar.f20225d = this.startTime;
                aVar.f20226e = wVar.getTimeline().freeSpaceAtTime(getAbsStartTime() - 1, 3, 100, true);
                a(aVar, context, (int) rectF.left, (int) rectF.top);
                return aVar;
            }
            a aVar2 = new a(c1764ra);
            aVar2.f20224c = DragType.END;
            aVar2.n = context;
            aVar2.f20225d = getDuration();
            aVar2.f20226e = wVar.getTimeline().freeSpaceAtTime(getAbsEndTime() + 1, 3, 100, false);
            a(aVar2, context, (int) rectF.right, (int) rectF.top);
            return aVar2;
        }
        float f2 = i;
        if (f2 < rectF.left + (rectF.height() * 2.0f)) {
            a aVar3 = new a(c1764ra);
            aVar3.f20224c = DragType.START;
            aVar3.n = context;
            aVar3.f20225d = this.startTime;
            aVar3.f20226e = wVar.getTimeline().freeSpaceAtTime(getAbsStartTime() - 1, 3, 100, true);
            a(aVar3, context, (int) rectF.left, (int) rectF.top);
            return aVar3;
        }
        if (f2 <= rectF.right - (rectF.height() * 2.0f)) {
            return null;
        }
        a aVar4 = new a(c1764ra);
        aVar4.f20224c = DragType.END;
        aVar4.n = context;
        aVar4.f20225d = getDuration();
        aVar4.f20226e = wVar.getTimeline().freeSpaceAtTime(getAbsEndTime() + 1, 3, 100, false);
        a(aVar4, context, (int) rectF.right, (int) rectF.top);
        return aVar4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onDraw(C1916ib c1916ib) {
        TextPaint textPaint;
        List<com.nextreaming.nexeditorui.ob> list;
        int i;
        int i2;
        TextPaint textPaint2;
        float f2;
        RectF k = c1916ib.k();
        TextPaint j = c1916ib.j();
        Canvas a2 = c1916ib.a();
        RectF e2 = c1916ib.e();
        c1916ib.g();
        Drawable drawable = c1916ib.getResources().getDrawable(c1916ib.p() ? R.drawable.timeline_item_border_sel : R.drawable.timeline_item_border_nor);
        drawable.getPadding(f20221f);
        k.set(e2);
        float f3 = k.left;
        Rect rect = f20221f;
        k.left = f3 + rect.left;
        k.top += rect.top;
        k.right -= rect.right;
        k.bottom -= rect.bottom;
        this.j = e2.width();
        if (c1916ib.o()) {
            j.setStyle(Paint.Style.STROKE);
            j.setColor(-6710887);
            j.setStrokeWidth(1.0f);
            a2.drawRoundRect(k, 2.0f, 2.0f, j);
            return;
        }
        int color = c1916ib.getResources().getColor(getBGColor());
        j.setStyle(Paint.Style.FILL);
        j.setColor(color);
        if (this.j < drawable.getMinimumWidth()) {
            float i3 = c1916ib.i() * 2.0f;
            float i4 = c1916ib.i() * 1.0f;
            float f4 = k.top;
            Rect rect2 = f20221f;
            k.top = f4 + rect2.top;
            k.bottom -= rect2.bottom;
            k.left += rect2.left;
            k.right -= rect2.right;
            if (k.width() < i3) {
                k.left = k.centerX() - (i3 / 2.0f);
                k.right = k.left + i3;
            }
            a2.drawRoundRect(k, i4, i4, j);
            return;
        }
        a2.drawRect(k, j);
        boolean drawThumbnails = drawThumbnails(c1916ib, a2, k);
        k.set(e2);
        float f5 = k.left;
        Rect rect3 = f20221f;
        k.left = f5 + rect3.left;
        k.top += rect3.top;
        k.right -= rect3.right;
        k.bottom -= rect3.bottom;
        int icon = getIcon();
        if (this.mIsVisibleLockIcon) {
            icon = R.drawable.timeline_item_lock_icon;
        }
        if (icon != 0) {
            Drawable drawable2 = c1916ib.getResources().getDrawable(icon);
            int a3 = c1916ib.a(1.0f);
            float f6 = k.left;
            drawable2.setBounds(((int) f6) + a3 + 0, ((int) k.top) + a3, (int) (f6 + 0 + a3 + ((k.height() - (a3 * 2)) * (drawable2.getIntrinsicWidth() / drawable2.getIntrinsicHeight()))), ((int) k.bottom) - a3);
            drawable2.draw(a2);
        }
        String layerName = getLayerName();
        if (layerName == null || layerName.trim().length() < 1) {
            layerName = getLabelText(c1916ib);
        }
        if (layerName != null) {
            j.setColor(-1);
            j.setTextSize(c1916ib.getResources().getDimension(R.dimen.timeline_audioClipTextSize));
            Paint.FontMetrics fontMetrics = j.getFontMetrics();
            j.setAntiAlias(true);
            float height = e2.left + e2.height() + c1916ib.a(0.0f) + 0;
            String charSequence = TextUtils.ellipsize(layerName, j, (e2.right - height) - (e2.height() * (getPinned() ? 1.1f : 0.15f)), TextUtils.TruncateAt.MIDDLE).toString();
            if (drawThumbnails) {
                j.setShadowLayer(c1916ib.getResources().getDimension(R.dimen.timeline3_layertext_shadow), 0.0f, 0.0f, -2013265920);
            }
            a2.drawText(charSequence, height, e2.centerY() - (fontMetrics.ascent / 3.0f), j);
            if (drawThumbnails) {
                j.clearShadowLayer();
            }
        }
        drawPin(c1916ib, drawThumbnails ? R.drawable.pin_light : R.drawable.pin_dark);
        if (getOverLimit() || !checkResourceState(null)) {
            Drawable drawable3 = c1916ib.getResources().getDrawable(R.drawable.stripes_tile);
            int intrinsicWidth = drawable3.getIntrinsicWidth();
            int intrinsicHeight = drawable3.getIntrinsicHeight();
            int i5 = (int) e2.top;
            while (true) {
                float f7 = i5;
                float f8 = 1.0f;
                if (f7 >= e2.bottom + 1.0f) {
                    break;
                }
                int i6 = (int) e2.left;
                while (true) {
                    float f9 = i6;
                    if (f9 < e2.right + f8) {
                        int i7 = i6 + intrinsicWidth;
                        int i8 = i5 + intrinsicHeight;
                        TextPaint textPaint3 = j;
                        RectF rectF = k;
                        int i9 = i6;
                        float f10 = f7;
                        int i10 = i5;
                        Drawable drawable4 = drawable3;
                        if (!a2.quickReject(f9, f7, i7, i8, Canvas.EdgeType.AA)) {
                            drawable4.setBounds(i9, i10, i7, i8);
                            drawable4.setAlpha(100);
                            drawable4.draw(a2);
                        }
                        drawable3 = drawable4;
                        i5 = i10;
                        i6 = i7;
                        k = rectF;
                        j = textPaint3;
                        f7 = f10;
                        f8 = 1.0f;
                    }
                }
                i5 += intrinsicHeight;
            }
        }
        RectF rectF2 = k;
        TextPaint textPaint4 = j;
        drawLayerAnimation(c1916ib, getKeyFrames(), getDuration(), R.drawable.vol_env_keyframe_icon);
        drawable.setBounds((int) e2.left, (int) e2.top, (int) e2.right, (int) e2.bottom);
        drawable.draw(a2);
        if (c1916ib.d() == R.id.editmode_trim && c1916ib.p() && !c1916ib.o()) {
            a2.save();
            Drawable drawable5 = c1916ib.getResources().getDrawable(R.drawable.grip_yellow);
            int a4 = c1916ib.a(8.0f);
            float f11 = a4;
            a2.clipRect(e2.left - f11, e2.top, e2.right + f11, e2.bottom, Region.Op.REPLACE);
            drawable5.setBounds(((int) e2.left) - a4, (int) e2.top, ((int) e2.right) + a4, (int) e2.bottom);
            drawable5.draw(a2);
            a2.restore();
            return;
        }
        if (c1916ib.d() == R.id.editmode_volume_adjust && c1916ib.p() && !c1916ib.o() && (this instanceof Vh)) {
            Vh vh = (Vh) this;
            List<com.nextreaming.nexeditorui.ob> b2 = c1916ib.b();
            rectF2.set(e2);
            rectF2.inset(1.0f, 1.0f);
            int volumeEnvelopeLength = vh.getVolumeEnvelopeLength();
            int representedDuration = getRepresentedDuration();
            if (getTimeline().getTotalTime() < getAbsEndTime()) {
                representedDuration -= getAbsEndTime() - getTimeline().getTotalTime();
            }
            int i11 = representedDuration;
            new Path();
            Drawable drawable6 = c1916ib.getResources().getDrawable(R.drawable.vol_env_keyframe_icon);
            PointF[] pointFArr = new PointF[volumeEnvelopeLength];
            int intrinsicWidth2 = drawable6.getIntrinsicWidth() / 2;
            int intrinsicHeight2 = drawable6.getIntrinsicHeight() / 2;
            a2.clipRect(rectF2);
            textPaint4.reset();
            TextPaint textPaint5 = textPaint4;
            textPaint5.setAntiAlias(true);
            textPaint5.setStrokeWidth(5.0f);
            textPaint5.setStyle(Paint.Style.STROKE);
            textPaint5.setColor(-1);
            float f12 = 0.0f;
            float f13 = 0.0f;
            int i12 = 0;
            int i13 = 0;
            while (i12 < volumeEnvelopeLength) {
                if (i12 == 0) {
                    pointFArr[i13] = new PointF();
                    pointFArr[i13].x = (vh.getVolumeEnvelopeTimeAdj(i12) / getRepresentedDuration()) * rectF2.right;
                    pointFArr[i13].y = rectF2.bottom - ((vh.getVolumeEnvelopeLevel(i12) / 200.0f) * rectF2.bottom);
                    f2 = pointFArr[i13].x;
                    float f14 = pointFArr[i13].y;
                    i13++;
                    f13 = f14;
                    i2 = i12;
                    textPaint2 = textPaint5;
                    list = b2;
                    i = volumeEnvelopeLength;
                } else {
                    int volumeEnvelopeTimeAdj = vh.getVolumeEnvelopeTimeAdj(i12);
                    pointFArr[i13] = new PointF();
                    pointFArr[i13].x = (volumeEnvelopeTimeAdj / i11) * rectF2.right;
                    if (b2 != null) {
                        int i14 = 0;
                        while (true) {
                            if (i14 >= b2.size() - 1) {
                                textPaint = textPaint5;
                                list = b2;
                                i = volumeEnvelopeLength;
                                break;
                            }
                            com.nextreaming.nexeditorui.ob obVar = b2.get(i14);
                            int i15 = i14 + 1;
                            com.nextreaming.nexeditorui.ob obVar2 = b2.get(i15);
                            if (obVar.f24385a <= volumeEnvelopeTimeAdj) {
                                textPaint = textPaint5;
                                if (volumeEnvelopeTimeAdj < obVar2.f24385a) {
                                    list = b2;
                                    i = volumeEnvelopeLength;
                                    pointFArr[i13].x = obVar.f24386b + (((volumeEnvelopeTimeAdj - r0) * (obVar2.f24386b - r1)) / (r8 - r0));
                                    break;
                                }
                            } else {
                                textPaint = textPaint5;
                            }
                            i14 = i15;
                            b2 = b2;
                            volumeEnvelopeLength = volumeEnvelopeLength;
                            textPaint5 = textPaint;
                        }
                    } else {
                        textPaint = textPaint5;
                        list = b2;
                        i = volumeEnvelopeLength;
                    }
                    pointFArr[i13].y = rectF2.bottom - ((vh.getVolumeEnvelopeLevel(i12) / 200.0f) * rectF2.bottom);
                    i2 = i12;
                    textPaint2 = textPaint;
                    a2.drawLine(f12, f13, pointFArr[i13].x, pointFArr[i13].y, textPaint2);
                    f2 = pointFArr[i13].x;
                    float f15 = pointFArr[i13].y;
                    i13++;
                    f13 = f15;
                }
                f12 = f2;
                i12 = i2 + 1;
                textPaint5 = textPaint2;
                b2 = list;
                volumeEnvelopeLength = i;
            }
            for (int i16 = 0; i16 < pointFArr.length && pointFArr[i16] != null; i16++) {
                if (pointFArr[i16].x <= c1916ib.l() || !c1916ib.m()) {
                    drawable6.setBounds(((int) pointFArr[i16].x) - intrinsicWidth2, ((int) pointFArr[i16].y) - intrinsicHeight2, ((int) pointFArr[i16].x) + intrinsicWidth2, ((int) pointFArr[i16].y) + intrinsicHeight2);
                    drawable6.draw(a2);
                }
            }
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public NexTimelineItem.k onLongPress(Context context, NexTimelineItem.w wVar, RectF rectF, int i, int i2, boolean z, int i3) {
        return NexTimelineItem.k.f24133a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onRender(LayerRenderer layerRenderer, b bVar, boolean z);

    public abstract void onRenderAsleep(LayerRenderer layerRenderer);

    public abstract void onRenderAwake(LayerRenderer layerRenderer);

    public void onRenderPreAsleep(LayerRenderer layerRenderer) {
        this.f20223h = null;
    }

    public void onRenderPreAwake(LayerRenderer layerRenderer) {
        if (this.k == null) {
            this.k = new Rect();
        }
        if (this.l == null) {
            this.l = new RectF();
        }
        RectF rectF = this.l;
        getBounds(this.k);
        rectF.set(this.k);
        if (this.mUseCropMask) {
            this.f20223h = com.nexstreaming.kinemaster.layer.a.a(this.mCropShapeId, Math.max(this.k.width(), this.k.height()), this.mCropMaskFeather, layerRenderer.l());
        } else {
            RectF rectF2 = this.mCropBounds;
            if ((rectF2 == null || !rectF.contains(rectF2) || rectF.equals(this.mCropBounds)) ? false : true) {
                this.f20223h = com.nexstreaming.kinemaster.layer.a.a(com.nexstreaming.kinemaster.layer.a.b(), (int) Math.ceil(Math.max(this.k.width(), this.k.height())), 0.0f, layerRenderer.l());
            }
        }
        if (this.f20223h == null || this.mNaturalOrientation != 180) {
            return;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(-1.0f, 1.0f);
        Bitmap bitmap = this.f20223h;
        this.f20223h = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.f20223h.getHeight(), matrix, false);
    }

    public boolean onRenderRefresh(LayerRenderer layerRenderer) {
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean onShowItemMenu(Context context, int i, int i2, int i3, int i4, int i5, NexTimelineItem.p pVar) {
        return false;
    }

    public void removeAllKeyframe() {
        a();
        synchronized (this.mLock) {
            this.mKeyFrames.clear();
        }
    }

    public void removeKeyframe(b bVar) {
        if (!isSplitScreenEnabled()) {
            a();
            synchronized (this.mLock) {
                this.mKeyFrames.remove(bVar);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public void renderLayer(LayerRenderer layerRenderer, boolean z) {
        if (getSplitScreenType() != SplitScreenType.OFF) {
            a(layerRenderer, z);
            return;
        }
        getInterpolatedKeyframe(getScaledTime(layerRenderer.f()), f20222g, true);
        if (this.k == null) {
            this.k = new Rect();
        }
        if (this.l == null) {
            this.l = new RectF();
        }
        RectF rectF = this.l;
        getExtendedBounds(this.k);
        rectF.set(this.k);
        layerRenderer.x();
        b bVar = f20222g;
        layerRenderer.b(bVar.f20232c, bVar.f20233d);
        if (z) {
            layerRenderer.a(this.expressionState);
            this.renderIn.a(layerRenderer, this.layerInExpression, 0.0f, 0.0f, layerRenderer.f() - getAbsStartTime(), getDuration(), this.layerInExpressionDuration, d(), this.mNaturalOrientation);
            this.expressionState = layerRenderer.h();
            layerRenderer.a((Object) null);
        } else {
            layerRenderer.a(layerRenderer.d() * (getAlpha() / 255.0f));
            layerRenderer.x();
            layerRenderer.a(f20222g.f20234e + this.mNaturalOrientation, 0.0f, 0.0f);
            b bVar2 = f20222g;
            layerRenderer.b(bVar2.f20236g, bVar2.f20237h, 0.0f, 0.0f);
            layerRenderer.a(this.m_flipH ? -1.0f : 1.0f, this.m_flipV ? -1.0f : 1.0f);
            a(layerRenderer);
            boolean i = layerRenderer.i();
            layerRenderer.w();
            layerRenderer.d(i);
            layerRenderer.a(f20222g.f20234e, 0.0f, 0.0f);
            b bVar3 = f20222g;
            layerRenderer.b(bVar3.f20236g, bVar3.f20237h, 0.0f, 0.0f);
            layerRenderer.a(this.m_flipH ? -1.0f : 1.0f, this.m_flipV ? -1.0f : 1.0f);
            onRender(layerRenderer, f20222g, false);
        }
        layerRenderer.w();
    }

    public float reverseInterpolate(float f2) {
        return f2;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.a
    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setAnchorItem(NexPrimaryTimelineItem nexPrimaryTimelineItem) {
        throw new UnsupportedOperationException();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.c
    public void setBlendMode(BlendMode blendMode) {
        this.layerBlendMode = blendMode;
    }

    public void setCropBounds(RectF rectF) {
        if (rectF == null) {
            this.mCropBounds = null;
            return;
        }
        RectF rectF2 = this.mCropBounds;
        if (rectF2 == null) {
            this.mCropBounds = new RectF(rectF);
        } else {
            rectF2.set(rectF);
        }
    }

    public void setCropMaskFeather(float f2) {
        this.mCropMaskFeather = f2;
    }

    public void setCropShape(int i) {
        this.mCropShapeId = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void setDuration(int i) {
        throw new UnsupportedOperationException("setDuration not permitted on layer items");
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setEndTime(int i) {
        this.endTime = i;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setEndTrim(int i) {
        if (hasIntrinsicDuration()) {
            this.endTrim = i;
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.s
    public void setFlipH(boolean z) {
        if (this.m_flipH == z) {
            return;
        }
        this.m_flipH = z;
        b splitScreenKeyframe = getSplitScreenKeyframe();
        if (isSplitScreenEnabled()) {
            fitKeyframeToSplitscreenRect(splitScreenKeyframe);
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.s
    public void setFlipV(boolean z) {
        if (this.m_flipV == z) {
            return;
        }
        this.m_flipV = z;
        b splitScreenKeyframe = getSplitScreenKeyframe();
        if (isSplitScreenEnabled()) {
            fitKeyframeToSplitscreenRect(splitScreenKeyframe);
        }
    }

    public void setLayerExpression(LayerExpression.Type type, LayerExpression layerExpression) {
        int i = C1778ya.f20379b[type.ordinal()];
        if (i == 1) {
            this.layerInExpression = layerExpression.getId();
        } else if (i == 2) {
            this.layerOutExpression = layerExpression.getId();
        } else {
            if (i == 3) {
                this.layerOverallExpression = layerExpression.getId();
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public void setLayerExpressionDuration(LayerExpression.Type type, int i) {
        int i2 = C1778ya.f20379b[type.ordinal()];
        if (i2 == 1) {
            this.layerInExpressionDuration = i;
        } else {
            if (i2 == 2) {
                this.layerOutExpressionDuration = i;
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public void setLayerExpressionSpeed(LayerExpression.Type type, float f2) {
        if (C1778ya.f20379b[type.ordinal()] == 3) {
            this.layerOverallExpressionSpeed = f2;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.o
    public void setLayerMaskEnabled(boolean z) {
        this.mLayerMaskEnabled = z;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.o
    public void setLayerMaskIndex(int i) {
        this.mLayerMaskIndex = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.o
    public void setLayerMaskMode(LayerMaskMode layerMaskMode) {
        this.mLayerMaskMode = layerMaskMode;
    }

    public void setLayerName(String str) {
        this.mLayerName = str;
    }

    public void setOrientation(int i) {
        this.mNaturalOrientation = i;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setPinned(boolean z) {
        this.pinned = z;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setRelativeEndTime(int i) {
        this.endTime = i;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setRelativeStartTime(int i) {
        this.startTime = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.s
    public void setRotation(int i) {
        for (b bVar : getKeyFrames()) {
            bVar.f20234e += i;
            float f2 = bVar.f20234e;
            if (f2 >= 360.0f || f2 <= -360.0f) {
                bVar.f20234e %= 360.0f;
            }
            if (isSplitScreenEnabled()) {
                fitKeyframeToSplitscreenRect(bVar);
            }
        }
    }

    public void setSplitScreenSize(int i) {
        if (supportsSplitScreen()) {
            int i2 = C1778ya.f20378a[getSplitScreenType().ordinal()];
            if (i2 == 1) {
                this.m_splitSizeLeft = i;
                return;
            }
            if (i2 == 2) {
                this.m_splitSizeTop = i;
                return;
            } else if (i2 == 3) {
                this.m_splitSizeRight = i;
                return;
            } else {
                if (i2 != 4) {
                    return;
                }
                this.m_splitSizeBottom = i;
                return;
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.t
    public void setSplitScreenType(SplitScreenType splitScreenType) {
        if (!supportsSplitScreen()) {
            throw new UnsupportedOperationException();
        }
        if (splitScreenType == null) {
            splitScreenType = SplitScreenType.OFF;
        }
        this.m_splitScreenType = splitScreenType;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setStartTime(int i) {
        this.startTime = i;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setStartTrim(int i) {
        if (hasIntrinsicDuration()) {
            this.startTrim = i;
        }
    }

    public void setSuppressCropping(boolean z) {
        this.i = z;
    }

    public void setUseCropMask(boolean z) {
        this.mUseCropMask = z;
    }

    public void setUseCustomMask(boolean z) {
        this.useCustomMask = z;
    }

    public void setZOrder(long j) {
        this.zOrder = j;
    }

    public abstract boolean supportsSplitScreen();

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void trimClip(int i, int i2) {
        if (i2 - i >= 1) {
            if (hasIntrinsicDuration()) {
                int i3 = this.startTime - this.startTrim;
                int intinsicDuration = getIntinsicDuration() + i3;
                if (i < i3) {
                    i = i3;
                }
                if (i2 <= i) {
                    i2 = i + 1;
                }
                if (i2 > intinsicDuration) {
                    i2 = intinsicDuration;
                }
                if (i >= i2) {
                    i = i2 - 1;
                }
                this.startTime = i;
                this.endTime = i2;
                this.startTrim = i - i3;
                this.endTrim = intinsicDuration - i2;
                return;
            }
            this.startTime = i;
            this.endTime = i2;
            return;
        }
        throw new IllegalArgumentException("End time must be greater than start time");
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.u
    public void trimToLeft(int i) {
        trimClip(i, getEndTime());
        getTimeline().requestCalcTimes();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.u
    public void trimToRight(int i) {
        trimClip(getStartTime(), i);
        getTimeline().requestCalcTimes();
    }

    public void updateLockIconVisibility(PurchaseType purchaseType, Context context) {
        this.mIsVisibleLockIcon = !isAvailableAsset(purchaseType, context);
    }

    public boolean useCropMask() {
        return this.mUseCropMask;
    }

    public void getInterpolatedKeyframe(float f2, b bVar, boolean z) {
        if (z && isSplitScreenEnabled()) {
            bVar.b(getSplitScreenKeyframe());
            return;
        }
        float interpolate = interpolate(f2);
        a();
        Iterator<b> it = this.mKeyFrames.iterator();
        float f3 = 0.0f;
        b bVar2 = null;
        b bVar3 = null;
        float f4 = 0.0f;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            float f5 = next.f20230a;
            if (f5 <= interpolate) {
                if (f5 >= interpolate) {
                    bVar2 = next;
                    bVar3 = bVar2;
                    break;
                }
                float abs = Math.abs(interpolate - f5);
                if (abs < f4 || bVar3 == null) {
                    if (bVar2 != null) {
                        bVar3 = next;
                        break;
                    } else {
                        bVar3 = next;
                        f4 = abs;
                    }
                }
            } else {
                float abs2 = Math.abs(f5 - interpolate);
                if (abs2 < f3 || bVar2 == null) {
                    if (bVar3 != null) {
                        bVar2 = next;
                        break;
                    } else {
                        bVar2 = next;
                        f3 = abs2;
                    }
                }
            }
        }
        if (bVar3 == null) {
            bVar3 = bVar2;
        } else if (bVar2 == null) {
            bVar2 = bVar3;
        }
        if (bVar3 != null && bVar2 != null) {
            if (bVar2 != bVar3) {
                float f6 = bVar2.f20230a;
                float f7 = bVar3.f20230a;
                if (f6 != f7) {
                    float f8 = (interpolate - f7) / (f6 - f7);
                    float f9 = 1.0f - f8;
                    bVar.f20230a = interpolate;
                    bVar.f20235f = (bVar3.f20235f * f9) + (bVar2.f20235f * f8);
                    bVar.f20234e = a(bVar3.f20234e, bVar2.f20234e, f8);
                    bVar.f20231b = (bVar3.f20231b * f9) + (bVar2.f20231b * f8);
                    bVar.f20232c = (bVar3.f20232c * f9) + (bVar2.f20232c * f8);
                    bVar.f20233d = (bVar3.f20233d * f9) + (bVar2.f20233d * f8);
                    bVar.f20236g = (bVar3.f20236g * f9) + (bVar2.f20236g * f8);
                    bVar.f20237h = (bVar3.f20237h * f9) + (bVar2.f20237h * f8);
                    return;
                }
            }
            bVar.f20230a = interpolate;
            bVar.f20235f = bVar3.f20235f;
            bVar.f20234e = bVar3.f20234e;
            bVar.f20231b = bVar3.f20231b;
            bVar.f20232c = bVar3.f20232c;
            bVar.f20233d = bVar3.f20233d;
            bVar.f20236g = bVar3.f20236g;
            bVar.f20237h = bVar3.f20237h;
            return;
        }
        throw new IllegalStateException();
    }

    public void getScaleRange(c cVar) {
        a();
        double d2 = 0.0d;
        boolean z = true;
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        float f2 = Float.MIN_NORMAL;
        float f3 = Float.MAX_VALUE;
        for (b bVar : e()) {
            if (z) {
                z = false;
            } else {
                double d6 = bVar.f20230a;
                Double.isNaN(d6);
                double d7 = (d6 - d2) * 100.0d;
                double d8 = bVar.f20231b;
                Double.isNaN(d8);
                d3 += ((d8 + d4) / 2.0d) * d7;
                d5 += d7;
            }
            float f4 = bVar.f20231b;
            d4 = f4;
            double d9 = bVar.f20230a;
            f2 = Math.max(f2, f4);
            f3 = Math.min(f3, bVar.f20231b);
            d2 = d9;
        }
        if (d2 < 1.0d) {
            double d10 = (1.0d - d2) * 100.0d;
            d3 += d4 * d10;
            d5 += d10;
        }
        cVar.f20238a = f3;
        cVar.f20239b = f2;
        cVar.f20240c = (float) (d3 / d5);
    }

    public b addKeyframe(b bVar) {
        if (!isSplitScreenEnabled()) {
            a();
            addInOrder(this.mKeyFrames, bVar);
            return bVar;
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends NexTimelineItem.i {

        /* renamed from: c, reason: collision with root package name */
        DragType f20224c;

        /* renamed from: d, reason: collision with root package name */
        int f20225d;

        /* renamed from: e, reason: collision with root package name */
        int f20226e;

        /* renamed from: f, reason: collision with root package name */
        int f20227f;

        /* renamed from: g, reason: collision with root package name */
        int f20228g;

        /* renamed from: h, reason: collision with root package name */
        int f20229h;
        View i;
        ViewGroup j;
        WindowManager k;
        WindowManager.LayoutParams l;
        int m;
        Context n;

        private a() {
            this.f20224c = null;
            this.f20225d = 0;
            this.f20226e = 0;
            this.f20227f = 0;
            this.f20228g = 0;
            this.f20229h = 0;
            this.i = null;
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = 0;
        }

        /* synthetic */ a(C1764ra c1764ra) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LayerRenderer layerRenderer) {
        boolean z;
        boolean z2;
        if (!this.i && getSplitScreenType() == SplitScreenType.OFF) {
            if ((this instanceof TextLayer) && (LayerExpression.requiresMask(this.layerInExpression) || LayerExpression.requiresMask(this.layerOutExpression) || LayerExpression.requiresMask(this.layerOverallExpression))) {
                layerRenderer.a(-1);
                layerRenderer.d(true);
                return;
            }
            RectF rectF = this.l;
            getExtendedBounds(this.k);
            rectF.set(this.k);
            RectF rectF2 = new RectF();
            boolean cropBounds = getCropBounds(rectF2);
            boolean z3 = cropBounds && rectF.contains(rectF2) && !rectF.equals(rectF2);
            if (LayerExpression.requiresMask(this.layerInExpression) || LayerExpression.requiresMask(this.layerOutExpression) || LayerExpression.requiresMask(this.layerOverallExpression)) {
                z = cropBounds;
                z2 = true;
            } else {
                z = z3;
                z2 = false;
            }
            if (!z && !this.mUseCropMask && !z2) {
                layerRenderer.d(false);
                return;
            }
            float d2 = layerRenderer.d();
            layerRenderer.a(1.0f);
            layerRenderer.a(LayerRenderer.RenderTarget.Mask);
            layerRenderer.d(false);
            RectF boundsWithOrientation = getBoundsWithOrientation(rectF, this.mNaturalOrientation);
            layerRenderer.a(ViewCompat.MEASURED_STATE_MASK, boundsWithOrientation.left, boundsWithOrientation.top, boundsWithOrientation.right, boundsWithOrientation.bottom);
            if (z) {
                boundsWithOrientation = getBoundsWithOrientation(this.mCropBounds, this.mNaturalOrientation);
            }
            if (this.m_flipV) {
                boundsWithOrientation = flipVertical(boundsWithOrientation);
            }
            if (this.m_flipH) {
                boundsWithOrientation = flipHorizontal(boundsWithOrientation);
            }
            Bitmap bitmap = this.f20223h;
            if (bitmap != null) {
                layerRenderer.a(bitmap, boundsWithOrientation.left, boundsWithOrientation.top, boundsWithOrientation.right, boundsWithOrientation.bottom);
            } else {
                layerRenderer.c(-1, boundsWithOrientation.left, boundsWithOrientation.top, boundsWithOrientation.right, boundsWithOrientation.bottom);
            }
            layerRenderer.a(LayerRenderer.RenderTarget.Normal);
            layerRenderer.d(true);
            layerRenderer.a(d2);
        }
    }

    private float a(float f2, float f3, float f4) {
        if (Math.abs(f2 - f3) % 360.0f > 180.0f) {
            if (f3 > f2) {
                f2 += 360.0f;
            } else {
                f3 += 360.0f;
            }
        }
        return (f2 + ((f3 - f2) * f4)) % 360.0f;
    }

    private void a() {
        List<b> list = this.mKeyFrames;
        if (list == null || list.size() < 1) {
            this.mKeyFrames = new CopyOnWriteArrayList();
            addInOrder(this.mKeyFrames, new b());
        }
    }

    private void a(a aVar, Context context, int i, int i2) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        aVar.f20228g = (int) TypedValue.applyDimension(1, 100.0f, displayMetrics);
        aVar.f20229h = (int) TypedValue.applyDimension(1, 32.0f, displayMetrics);
        aVar.m = i - (aVar.f20228g / 2);
        aVar.k = (WindowManager) context.getSystemService("window");
        aVar.j = new FrameLayout(context);
        aVar.j.setBackgroundColor(0);
        aVar.i = new C1776xa(this, context, aVar);
        aVar.i.setLayoutParams(new FrameLayout.LayoutParams(aVar.f20228g, aVar.f20229h));
        aVar.j.addView(aVar.i);
        aVar.l = new WindowManager.LayoutParams();
        WindowManager.LayoutParams layoutParams = aVar.l;
        layoutParams.width = aVar.f20228g;
        int i3 = aVar.f20229h;
        layoutParams.height = i3;
        layoutParams.flags = 408;
        layoutParams.gravity = 51;
        layoutParams.x = aVar.m;
        layoutParams.y = (i2 - i3) + ((int) TypedValue.applyDimension(1, 2.0f, displayMetrics));
        WindowManager.LayoutParams layoutParams2 = aVar.l;
        layoutParams2.windowAnimations = 0;
        layoutParams2.format = -3;
        aVar.k.addView(aVar.j, layoutParams2);
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
}
