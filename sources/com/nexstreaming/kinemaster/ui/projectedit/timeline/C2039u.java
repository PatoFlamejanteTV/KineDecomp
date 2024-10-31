package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.content.res.Resources;
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
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.I;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.UniformTimelineView;
import com.nexstreaming.kinemaster.ui.widget.ClipThumbView;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import java.util.Locale;

/* compiled from: SecondaryItemDragDecoration.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.timeline.u, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2039u extends I implements UniformTimelineView.a {
    private final float A;
    private final int B;
    private final int C;
    private final float D;
    private final int E;
    private final int F;
    private final int G;
    private final float H;
    private Paint I;
    private Paint J;
    private Rect K;
    private RectF L;
    protected z M;
    private final int z;

    public C2039u(UniformTimelineView uniformTimelineView, Fa fa, MotionEvent motionEvent) {
        super(uniformTimelineView, fa, motionEvent);
        Resources j = j();
        this.z = j.getDimensionPixelSize(R.dimen.timeline3_dragItemMaxWidth);
        this.A = j.getDimensionPixelSize(R.dimen.timeline3_itemCornerRadius);
        this.B = j.getDimensionPixelSize(R.dimen.timeline_drag_selection_stroke_width);
        this.C = j.getDimensionPixelSize(R.dimen.timeline_drag_track_height_offset);
        this.D = TypedValue.applyDimension(1, 1.0f, j.getDisplayMetrics());
        this.H = j.getDimensionPixelSize(R.dimen.timeline3_ctsTextSize);
        this.F = j.getDimensionPixelSize(R.dimen.timeline3_ctsBoxWidth);
        this.G = j.getDimensionPixelSize(R.dimen.timeline3_ctsBoxHeight);
        this.E = j.getDimensionPixelSize(R.dimen.timeline_guide_start_offset);
        this.M = b(fa);
        this.v = m().getTrackIdByItem(fa);
    }

    private Paint J() {
        if (this.J == null) {
            this.J = new Paint(1);
            this.J.setColor(-1);
            this.J.setStrokeWidth(this.D);
            this.J.setTextAlign(Paint.Align.CENTER);
            this.J.setTextSize(this.H);
        }
        return this.J;
    }

    private boolean K() {
        int trackIndexById;
        if (m().getTrackCount() <= 1 && m().getSecondaryItemCount() <= 1) {
            return false;
        }
        int trackIdByItem = m().getTrackIdByItem(t());
        return (m().getSecondaryItemCount(trackIdByItem) <= 1 && trackIdByItem == this.v && ((trackIndexById = m().getTrackIndexById(trackIdByItem)) == 0 || trackIndexById == m().getTrackCount() - 1)) ? false : true;
    }

    private static ClipThumbView a(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                return a((ViewGroup) childAt);
            }
            if (childAt instanceof ClipThumbView) {
                return (ClipThumbView) childAt;
            }
        }
        return null;
    }

    private z b(Fa fa) {
        int a2;
        View a3;
        Canvas canvas;
        int i;
        if (!(fa instanceof NexSecondaryTimelineItem) || (a2 = h().a(fa)) == -1 || (a3 = h().a(a2)) == null) {
            return null;
        }
        int width = this.p.getBounds().width();
        int min = Math.min(width, i());
        int height = a3.getHeight();
        float f2 = min;
        float f3 = height;
        RectF rectF = new RectF(0.0f, 0.0f, f2, f3);
        Bitmap createBitmap = Bitmap.createBitmap(min, height, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        int save = canvas2.save();
        canvas2.clipRect(rectF);
        ClipThumbView a4 = a((ViewGroup) a3);
        if (a4 != null) {
            int startTime = a4.getStartTime();
            a4.setStartTime((int) (((int) Math.max((this.p.b() + a3.getLeft()) - (i() / 2), 0.0f)) * h().f()));
            a3.draw(canvas2);
            a4.setStartTime(startTime);
        } else {
            a3.draw(canvas2);
        }
        Path path = new Path();
        path.addRect(rectF, Path.Direction.CW);
        float f4 = this.A;
        path.addRoundRect(rectF, f4, f4, Path.Direction.CW);
        path.setFillType(Path.FillType.EVEN_ODD);
        Paint paint = new Paint(1);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas2.drawPath(path, paint);
        if (width > i()) {
            if (this.p.b() > i() / 2) {
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                float f5 = min - ((min * 3) / 4);
                paint.setShader(new LinearGradient(0.0f, 0.0f, f5, 0.0f, 0, -1, Shader.TileMode.CLAMP));
                canvas2.drawRect(0.0f, 0.0f, f5, f3, paint);
            }
            if (width - this.p.b() > i() / 2) {
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                float f6 = (min * 3) / 4;
                canvas = canvas2;
                paint.setShader(new LinearGradient(f2, 0.0f, f6, 0.0f, 0, -1, Shader.TileMode.CLAMP));
                canvas.drawRect(f6, 0.0f, f2, f3, paint);
                i = save;
                canvas.restoreToCount(i);
                return new C2027h(createBitmap);
            }
        }
        canvas = canvas2;
        i = save;
        canvas.restoreToCount(i);
        return new C2027h(createBitmap);
    }

    private void c(boolean z) {
        n().setTimelineGuideVisibility(!z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    public void D() {
        super.D();
        h().a(new C2038t(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    public void G() {
        super.G();
        int c2 = h().c(Math.min(this.o.centerX(), o()) + ((int) h().t), this.o.centerY() + ((int) h().u));
        if (c2 != -1) {
            this.v = c2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    public void H() {
        int i;
        int i2;
        int requiredSubTrackCount;
        super.H();
        float f2 = -h().t;
        float totalTime = (m().getTotalTime() * h().f()) - h().t;
        float g2 = (-h().u) + h().g();
        float f3 = (h().w - h().u) + h().E;
        if (K()) {
            g2 -= (h().F + h().G) / 2;
            i = h().F / 2;
            i2 = h().G;
            requiredSubTrackCount = m().getRequiredSubTrackCount();
        } else {
            i = h().F;
            i2 = h().G;
            requiredSubTrackCount = m().getRequiredSubTrackCount();
        }
        float f4 = f3 - (i - (i2 * requiredSubTrackCount));
        float f5 = this.q;
        if (f5 < f2) {
            this.q = f2;
        } else if (f5 > totalTime) {
            this.q = totalTime;
        }
        float f6 = this.r;
        if (f6 < g2) {
            this.r = g2;
        } else if (f6 > f4) {
            this.r = f4;
        }
    }

    protected final Paint I() {
        return b(true);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.UniformTimelineView.a
    public void onDrawForeground(Canvas canvas) {
        a(canvas, true);
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        z zVar;
        if (this.m && (zVar = this.M) != null && zVar.isValid()) {
            a(canvas, false);
            canvas.save();
            canvas.clipRect(0, h().E + h().U, canvas.getWidth(), canvas.getHeight());
            int width = this.M.getWidth();
            int height = this.M.getHeight();
            if (s().isRunning()) {
                double radians = Math.toRadians(180.0d);
                double b2 = s().b();
                Double.isNaN(b2);
                float sin = (float) Math.sin(radians * b2);
                canvas.scale((((this.z * 0.2f) / width) * sin) + 1.0f, (((h().F * 0.2f) / height) * sin) + 1.0f, this.q + (width / 2), this.r + (height / 2));
            } else {
                canvas.scale(1.0f, 1.0f);
            }
            this.M.a(canvas, this.q, this.r);
            canvas.restore();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    protected int u() {
        if (this.v == -1) {
            return 0;
        }
        int trackIdByItem = m().getTrackIdByItem(t());
        int secondaryItemCount = m().getSecondaryItemCount(trackIdByItem);
        if (secondaryItemCount == 1 && this.v == trackIdByItem) {
            return 4;
        }
        Rect c2 = h().c(this.v);
        if (c2 == null) {
            return 0;
        }
        int trackIndexById = m().getTrackIndexById(trackIdByItem);
        int trackIndexById2 = m().getTrackIndexById(this.v);
        if (this.o.centerY() > c2.top - (h().G / 2) && this.o.centerY() < c2.top + this.C) {
            return (secondaryItemCount == 1 && trackIndexById2 == trackIndexById + 1) ? 4 : 5;
        }
        if (this.o.centerY() >= c2.bottom + (h().G / 2) || this.o.centerY() <= c2.bottom - this.C) {
            return 4;
        }
        return (secondaryItemCount == 1 && trackIndexById2 == trackIndexById - 1) ? 4 : 6;
    }

    private String c(int i) {
        int frameFromTime = m().getFrameFromTime(i);
        int frameRate = m().getFrameRate();
        int i2 = frameRate * 60;
        int i3 = i2 * 60;
        return String.format(Locale.ENGLISH, "%02d:%02d:%02d:%02d", Integer.valueOf(frameFromTime / i3), Integer.valueOf((frameFromTime % i3) / i2), Integer.valueOf((frameFromTime % i2) / frameRate), Integer.valueOf(frameFromTime % frameRate));
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I
    protected void a(I.a aVar) {
        aVar.a(new BounceInterpolator());
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.graphics.Canvas r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.timeline.C2039u.a(android.graphics.Canvas, boolean):void");
    }

    private void c(Canvas canvas, Rect rect) {
        RectF rectF = new RectF(rect);
        float f2 = this.A;
        canvas.drawRoundRect(rectF, f2, f2, I());
    }

    protected void a(Canvas canvas) {
        Paint J = J();
        int i = this.o.left;
        canvas.drawLine(i, this.E, i, n().getHeight(), J());
        String c2 = c((int) ((this.w.d() + h().t) / k()));
        if (this.K == null) {
            this.K = new Rect();
        }
        J.getTextBounds(c2, 0, c2.length(), this.K);
        int width = this.K.width();
        int i2 = this.F;
        if (width < i2) {
            Rect rect = this.K;
            rect.right = rect.left + i2;
        }
        Rect rect2 = this.K;
        rect2.top += this.E * 2;
        rect2.bottom = rect2.top + this.G;
        rect2.offsetTo(this.o.left - (rect2.width() / 2), 0);
        float height = this.K.height() / 2;
        if (this.L == null) {
            this.L = new RectF();
        }
        RectF rectF = this.L;
        Rect rect3 = this.K;
        rectF.set(rect3.left + 1, rect3.top + 1, rect3.right - 1, rect3.bottom - 1);
        canvas.drawRoundRect(this.L, height, height, J);
        J.setColor(ViewCompat.MEASURED_STATE_MASK);
        J.setStyle(Paint.Style.STROKE);
        canvas.drawRoundRect(this.L, height, height, J);
        J.setStyle(Paint.Style.FILL);
        Rect rect4 = this.K;
        float width2 = rect4.left + (rect4.width() / 2);
        Rect rect5 = this.K;
        canvas.drawText(c2, width2, ((rect5.top + (rect5.height() / 2)) + (this.H / 2.0f)) - this.E, J);
        J.setColor(-1);
    }

    protected final Paint b(boolean z) {
        if (this.I == null) {
            this.I = new Paint(1);
            this.I.setColor(-1);
            this.I.setStrokeWidth(this.B);
        }
        this.I.setStyle(z ? Paint.Style.STROKE : Paint.Style.FILL);
        return this.I;
    }

    private void b(Canvas canvas, Rect rect) {
        float f2 = rect.left;
        int i = rect.bottom;
        canvas.drawLine(f2, i, rect.right, i, I());
        canvas.drawCircle(rect.left, rect.bottom, this.A, b(false));
    }

    private void a(Canvas canvas, Rect rect) {
        float f2 = rect.left;
        int i = rect.top;
        canvas.drawLine(f2, i, rect.right, i, I());
        canvas.drawCircle(rect.left, rect.top, this.A, b(false));
    }
}
