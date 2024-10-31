package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.Ea;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TrackSnapshot.java */
/* loaded from: classes2.dex */
public class Q implements z {

    /* renamed from: a, reason: collision with root package name */
    private final UniformTimelineLayoutManager f22621a;

    /* renamed from: b, reason: collision with root package name */
    private final UniformTimelineView f22622b;

    /* renamed from: c, reason: collision with root package name */
    private final T f22623c;

    /* renamed from: d, reason: collision with root package name */
    private final Ea f22624d;

    /* renamed from: e, reason: collision with root package name */
    private final float f22625e;

    /* renamed from: f, reason: collision with root package name */
    private final int f22626f;

    /* renamed from: g, reason: collision with root package name */
    private Bitmap f22627g;

    /* renamed from: h, reason: collision with root package name */
    private Bitmap f22628h;
    private final List<z> i = new ArrayList();
    private float j = 1.0f;
    private final Rect k = new Rect();
    private final Rect l = new Rect();
    private final RectF m = new RectF();

    public Q(UniformTimelineLayoutManager uniformTimelineLayoutManager, Ea ea) {
        this.f22621a = uniformTimelineLayoutManager;
        this.f22622b = uniformTimelineLayoutManager.i();
        this.f22623c = (T) this.f22622b.getAdapter();
        this.f22624d = ea;
        this.f22625e = this.f22622b.getResources().getDimensionPixelSize(R.dimen.timeline3_itemCornerRadius);
        this.f22626f = ea.e();
        b();
    }

    private void b() {
        int a2;
        float f2;
        int a3 = this.f22621a.a((Fa) this.f22624d);
        if (a3 == -1 || (a2 = this.f22621a.a(M.a(this.f22624d))) == -1) {
            return;
        }
        View a4 = this.f22621a.a(a3);
        View a5 = this.f22621a.a(a2);
        if (a5 == null || a4 == null) {
            return;
        }
        a4.getHitRect(this.k);
        this.l.set(0, 0, this.k.width(), this.k.height());
        this.f22627g = a(a5, this.k);
        this.f22628h = a(a4, this.k);
        float f3 = this.f22621a.f();
        UniformTimelineLayoutManager uniformTimelineLayoutManager = this.f22621a;
        float f4 = uniformTimelineLayoutManager.t;
        int i = uniformTimelineLayoutManager.F;
        int i2 = uniformTimelineLayoutManager.G;
        float f5 = f4 / f3;
        float width = ((uniformTimelineLayoutManager.getWidth() + f4) - 1.0f) / f3;
        for (NexSecondaryTimelineItem nexSecondaryTimelineItem : this.f22622b.getTimeline().getSecondaryItems()) {
            if (nexSecondaryTimelineItem.getTrackId() == this.f22624d.c() && nexSecondaryTimelineItem.getDuration() > 0) {
                int absStartTime = nexSecondaryTimelineItem.getAbsStartTime();
                if (nexSecondaryTimelineItem.getAbsEndTime() >= f5) {
                    if (absStartTime <= width) {
                        int floor = ((int) Math.floor((r12 * f3) - f4)) + 1;
                        int subTrackMapping = (nexSecondaryTimelineItem.getSubTrackMapping() * (i + i2)) + (i2 / 2);
                        int a6 = this.f22621a.a((Fa) nexSecondaryTimelineItem);
                        View a7 = this.f22621a.a(a6);
                        if (a7 == null) {
                            f2 = width;
                            X createViewHolder = this.f22623c.createViewHolder(this.f22622b, nexSecondaryTimelineItem.getTimelineViewLayoutResource());
                            this.f22623c.bindViewHolder(createViewHolder, a6);
                            a7 = createViewHolder.itemView;
                            a7.layout(0, 0, (((int) (((r11 - absStartTime) * f3) + 0.5f)) + floor) - floor, (subTrackMapping + i) - subTrackMapping);
                        } else {
                            f2 = width;
                        }
                        this.i.add(new C2027h(a(a7, this.k, this.f22625e), floor, subTrackMapping, nexSecondaryTimelineItem.getSubTrackMapping()));
                        width = f2;
                    }
                }
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.z
    public int a() {
        return 0;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.z
    public void a(int i) {
        int height = this.l.height() - i;
        if (height != 0) {
            this.l.inset(0, height / 2);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.z
    public int getHeight() {
        return this.k.height();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.z
    public int getIndex() {
        return 0;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.z
    public int getWidth() {
        return this.k.width();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.z
    public boolean isValid() {
        Bitmap bitmap;
        Bitmap bitmap2 = this.f22627g;
        return (bitmap2 == null || bitmap2.isRecycled() || (bitmap = this.f22628h) == null || bitmap.isRecycled()) ? false : true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.z
    public void a(float f2) {
        this.j = f2;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.z
    public void a(Canvas canvas, float f2, float f3) {
        int i;
        if (!isValid()) {
            return;
        }
        this.l.right = this.f22628h.getWidth();
        RectF rectF = this.m;
        Rect rect = this.l;
        rectF.set(0.0f, rect.top + f3, rect.width(), this.l.bottom + f3);
        canvas.drawBitmap(this.f22628h, this.l, this.m, (Paint) null);
        int size = this.i.size();
        int i2 = this.f22626f;
        int i3 = i2 / 2;
        int i4 = 0;
        int i5 = i2 > 1 ? (this.f22621a.F / 2) / (i2 - 1) : 0;
        int i6 = 0;
        while (true) {
            int i7 = this.f22626f;
            if (i6 < i7) {
                int i8 = (int) ((i6 / 2.0f) + 0.5f);
                if (i6 % 2 != 0) {
                    i8 = i7 - i8;
                }
                int i9 = 0;
                while (i9 < size) {
                    z zVar = this.i.get(i9);
                    if (zVar.getIndex() == i8) {
                        if (this.l.top + (this.f22621a.G / 2) > zVar.a()) {
                            i = (this.l.top + (this.f22621a.G / 2)) - zVar.a();
                            if (this.f22626f > 2 && i8 < i3) {
                                i += i8 * i5;
                            }
                        } else if (this.l.bottom - (this.f22621a.G / 2) < zVar.a() + zVar.getHeight()) {
                            i = ((this.l.bottom - (this.f22621a.G / 2)) - zVar.getHeight()) - zVar.a();
                            if (this.f22626f > 2 && i8 >= i3) {
                                i -= Math.max((i3 - Math.abs(i3 - i8)) - (1 - (size % 2)), i4) * i5;
                            }
                        } else {
                            i = 0;
                        }
                        if (size > 1) {
                            float f4 = this.j;
                            zVar.a(Math.min(f4 + ((f4 / i3) * (i3 - Math.abs(i3 - i8))), 1.0f));
                        }
                        zVar.a(canvas, f2, f3 + i);
                    }
                    i9++;
                    i4 = 0;
                }
                i6++;
                i4 = 0;
            } else {
                this.l.right = this.f22627g.getWidth();
                this.m.right = this.f22627g.getWidth();
                canvas.drawBitmap(this.f22627g, this.l, this.m, (Paint) null);
                return;
            }
        }
    }

    public static Bitmap a(View view, Rect rect) {
        return a(view, rect, 0.0f);
    }

    public static Bitmap a(View view, Rect rect, float f2) {
        Rect rect2 = new Rect();
        view.getHitRect(rect2);
        int min = Math.min(rect2.width(), rect.width() - rect2.left);
        int height = rect2.height();
        Bitmap createBitmap = Bitmap.createBitmap(min, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.clipRect(0, 0, min, height);
        view.draw(canvas);
        if (f2 > 0.0f) {
            RectF rectF = new RectF(0.0f, 0.0f, rect2.width(), rect2.height());
            Path path = new Path();
            path.addRect(rectF, Path.Direction.CW);
            path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
            path.setFillType(Path.FillType.EVEN_ODD);
            Paint paint = new Paint(1);
            paint.setFilterBitmap(true);
            paint.setDither(true);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            canvas.drawPath(path, paint);
        }
        return createBitmap;
    }
}
