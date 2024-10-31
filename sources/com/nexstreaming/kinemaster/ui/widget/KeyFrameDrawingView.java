package com.nexstreaming.kinemaster.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.ui.projectedit.Vh;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.UniformTimelineView;
import java.util.List;

/* loaded from: classes2.dex */
public class KeyFrameDrawingView extends View {

    /* renamed from: a, reason: collision with root package name */
    private Context f23777a;

    /* renamed from: b, reason: collision with root package name */
    private Vh f23778b;

    /* renamed from: c, reason: collision with root package name */
    private int f23779c;

    /* renamed from: d, reason: collision with root package name */
    private int f23780d;

    /* renamed from: e, reason: collision with root package name */
    private int f23781e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f23782f;

    /* renamed from: g, reason: collision with root package name */
    private List<NexLayerItem.b> f23783g;

    /* renamed from: h, reason: collision with root package name */
    private DrawingMode f23784h;
    private a i;
    private View j;
    private UniformTimelineView k;
    private boolean l;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum DrawingMode {
        Envelope,
        LayerAnimation
    }

    /* loaded from: classes2.dex */
    class a implements UniformTimelineView.a {
        a() {
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.UniformTimelineView.a
        public void onDrawForeground(Canvas canvas) {
            if (KeyFrameDrawingView.this.getVisibility() != 0 || KeyFrameDrawingView.this.f23782f || KeyFrameDrawingView.this.f23784h != DrawingMode.Envelope || KeyFrameDrawingView.this.j == null || KeyFrameDrawingView.this.l) {
                return;
            }
            canvas.save();
            new Paint().setColor(Color.argb(128, 255, 0, 0));
            canvas.translate(KeyFrameDrawingView.this.j.getLeft(), KeyFrameDrawingView.this.getResources().getDimensionPixelSize(R.dimen.timeline3_timescale_height));
            KeyFrameDrawingView.this.j.draw(canvas);
            canvas.translate(-KeyFrameDrawingView.this.j.getLeft(), -KeyFrameDrawingView.this.getResources().getDimensionPixelSize(R.dimen.timeline3_timescale_height));
            Drawable drawable = KeyFrameDrawingView.this.getContext().getResources().getDrawable(R.drawable.timeline_item_border_sel);
            drawable.setBounds(KeyFrameDrawingView.this.j.getLeft(), KeyFrameDrawingView.this.j.getTop(), KeyFrameDrawingView.this.j.getRight(), KeyFrameDrawingView.this.j.getBottom());
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    public KeyFrameDrawingView(Context context) {
        super(context);
        this.i = new a();
        this.f23777a = context;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.nexstreaming.kinemaster.usage.analytics.b.a(KeyFrameDrawingView.class.getName());
        this.k = UniformTimelineView.g((View) getParent());
        UniformTimelineView uniformTimelineView = this.k;
        if (uniformTimelineView != null) {
            uniformTimelineView.a(this.i);
        }
        this.l = true;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        UniformTimelineView uniformTimelineView = this.k;
        if (uniformTimelineView != null) {
            uniformTimelineView.b(this.i);
        }
        this.k = null;
        this.l = false;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        List<NexLayerItem.b> list;
        int i;
        super.onDraw(canvas);
        Paint paint = new Paint();
        Rect rect = new Rect();
        getDrawingRect(rect);
        DrawingMode drawingMode = this.f23784h;
        if (drawingMode == DrawingMode.Envelope) {
            Vh vh = this.f23778b;
            if (vh == null) {
                return;
            }
            int volumeEnvelopeLength = vh.getVolumeEnvelopeLength();
            Drawable drawable = this.f23777a.getResources().getDrawable(R.drawable.vol_env_keyframe_icon);
            PointF[] pointFArr = new PointF[volumeEnvelopeLength];
            int intrinsicWidth = drawable.getIntrinsicWidth() / 2;
            int intrinsicHeight = drawable.getIntrinsicHeight() / 2;
            int i2 = 0;
            for (int i3 = 0; i3 < volumeEnvelopeLength; i3++) {
                if (i3 == 0) {
                    pointFArr[i2] = new PointF();
                    pointFArr[i2].x = (this.f23778b.getVolumeEnvelopeTimeForDrawing(i3) / this.f23779c) * rect.right;
                    pointFArr[i2].y = rect.bottom - ((this.f23778b.getVolumeEnvelopeLevel(i3) / 200.0f) * rect.bottom);
                } else {
                    pointFArr[i2] = new PointF();
                    pointFArr[i2].x = (this.f23778b.getVolumeEnvelopeTimeForDrawing(i3) / this.f23779c) * rect.right;
                    pointFArr[i2].y = rect.bottom - ((this.f23778b.getVolumeEnvelopeLevel(i3) / 200.0f) * rect.bottom);
                }
                i2++;
            }
            canvas.clipRect(rect);
            paint.reset();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(5.0f);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(-1);
            int i4 = 0;
            while (i4 < pointFArr.length - 1) {
                int i5 = i4 + 1;
                canvas.drawLine(pointFArr[i4].x, pointFArr[i4].y, pointFArr[i5].x, pointFArr[i5].y, paint);
                i4 = i5;
            }
            while (i < pointFArr.length && pointFArr[i] != null) {
                int volumeEnvelopeTimeAdj = this.f23778b.getVolumeEnvelopeTimeAdj(i);
                if (!this.f23782f) {
                    int i6 = this.f23780d;
                    int i7 = this.f23781e;
                    i = (i6 * 100) / i7 > volumeEnvelopeTimeAdj + ((i6 * 100) / i7) ? i + 1 : 0;
                }
                drawable.setBounds(((int) pointFArr[i].x) - intrinsicWidth, ((int) pointFArr[i].y) - intrinsicHeight, ((int) pointFArr[i].x) + intrinsicWidth, ((int) pointFArr[i].y) + intrinsicHeight);
                drawable.draw(canvas);
            }
            return;
        }
        if (drawingMode != DrawingMode.LayerAnimation || (list = this.f23783g) == null || list.size() < 1) {
            return;
        }
        Drawable drawable2 = this.f23777a.getResources().getDrawable(R.drawable.vol_env_keyframe_icon);
        int intrinsicWidth2 = drawable2.getIntrinsicWidth() / 2;
        int intrinsicHeight2 = drawable2.getIntrinsicHeight() / 2;
        for (int i8 = 0; i8 < this.f23783g.size(); i8++) {
            float width = rect.width() * this.f23783g.get(i8).f20230a;
            float centerY = rect.centerY();
            float f2 = intrinsicWidth2;
            float f3 = intrinsicHeight2;
            drawable2.setBounds((int) (width - f2), (int) (centerY - f3), (int) (width + f2), (int) (centerY + f3));
            drawable2.draw(canvas);
        }
    }

    public void a(Vh vh, int i, int i2, int i3, View view) {
        this.f23778b = vh;
        this.f23779c = i;
        this.f23780d = i2;
        this.f23781e = i3;
        this.f23784h = DrawingMode.Envelope;
        this.j = view;
        invalidate();
    }

    public KeyFrameDrawingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new a();
        this.f23777a = context;
    }

    public KeyFrameDrawingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = new a();
        this.f23777a = context;
    }

    public void a(Vh vh, int i, int i2, boolean z) {
        this.f23778b = vh;
        this.f23779c = i;
        this.f23780d = i2;
        this.f23782f = z;
        this.f23784h = DrawingMode.Envelope;
        invalidate();
    }

    public void a(List<NexLayerItem.b> list, int i) {
        this.f23783g = list;
        this.f23779c = i;
        this.f23784h = DrawingMode.LayerAnimation;
        invalidate();
    }
}
