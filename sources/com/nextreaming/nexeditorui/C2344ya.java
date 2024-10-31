package com.nextreaming.nexeditorui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.SectionIndexer;

/* compiled from: NexIndexScroller.java */
/* renamed from: com.nextreaming.nexeditorui.ya */
/* loaded from: classes.dex */
public class C2344ya {

    /* renamed from: a */
    private float f24409a;

    /* renamed from: b */
    private float f24410b;

    /* renamed from: c */
    private float f24411c;

    /* renamed from: d */
    private float f24412d;

    /* renamed from: e */
    private float f24413e;

    /* renamed from: f */
    private float f24414f;

    /* renamed from: h */
    private int f24416h;
    private int i;
    private ListView l;
    private RectF o;
    private int p;
    private int q;

    /* renamed from: g */
    private int f24415g = 0;
    private int j = -1;
    private boolean k = false;
    private SectionIndexer m = null;
    private String[] n = null;
    private Handler r = new HandlerC2342xa(this);

    public C2344ya(Context context, NexIndexableListView nexIndexableListView, int i, int i2) {
        this.l = null;
        this.f24412d = context.getResources().getDisplayMetrics().density;
        this.f24413e = context.getResources().getDisplayMetrics().scaledDensity;
        this.l = nexIndexableListView;
        a(this.l.getAdapter());
        this.p = i;
        this.q = i2;
        float f2 = this.f24412d;
        this.f24409a = 20.0f * f2;
        this.f24410b = 10.0f * f2;
        this.f24411c = f2 * 5.0f;
    }

    public void b() {
        int i = this.f24415g;
        if (i == 0) {
            a(1);
        } else if (i == 3) {
            a(3);
        }
    }

    public void a(Canvas canvas) {
        if (this.f24415g == 0 || this.n == null) {
            return;
        }
        Paint paint = new Paint();
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setAlpha((int) (this.f24414f * 64.0f));
        paint.setAntiAlias(true);
        canvas.drawRect(this.o, paint);
        String[] strArr = this.n;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int i = this.j;
        float f2 = 0.0f;
        if (i >= 0 && i < strArr.length) {
            Paint paint2 = new Paint();
            paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
            paint2.setAlpha(96);
            paint2.setAntiAlias(true);
            paint2.setShadowLayer(3.0f, 0.0f, 0.0f, Color.argb(64, 0, 0, 0));
            Paint paint3 = new Paint();
            paint3.setColor(-1);
            paint3.setAntiAlias(true);
            paint3.setTextSize(this.f24413e * 50.0f);
            float measureText = paint3.measureText(this.n[this.j]);
            float descent = ((this.f24411c * 2.0f) + paint3.descent()) - paint3.ascent();
            int i2 = this.f24416h;
            int i3 = this.i;
            RectF rectF = new RectF((i2 - descent) / 2.0f, (i3 - descent) / 2.0f, ((i2 - descent) / 2.0f) + descent, ((i3 - descent) / 2.0f) + descent);
            float f3 = this.f24412d;
            canvas.drawRoundRect(rectF, f3 * 5.0f, f3 * 5.0f, paint2);
            canvas.drawText(this.n[this.j], (rectF.left + ((rectF.width() - measureText) / 2.0f)) - 1.0f, ((rectF.top + this.f24411c) - paint3.ascent()) + 1.0f, paint3);
        }
        Paint paint4 = new Paint();
        paint4.setColor(-1);
        paint4.setAlpha((int) (this.f24414f * 255.0f));
        paint4.setAntiAlias(true);
        paint4.setTextSize(this.f24413e * 12.0f);
        float height = (this.o.height() - (this.f24410b * 2.0f)) / this.n.length;
        float descent2 = (height - (paint4.descent() - paint4.ascent())) / 2.0f;
        for (int i4 = 0; i4 < this.n.length; i4++) {
            float width = (this.o.width() - paint4.measureText(this.n[i4])) / 2.0f;
            float ascent = (((this.o.top + this.f24410b) + (i4 * height)) + descent2) - paint4.ascent();
            if (ascent - f2 >= this.f24413e * 12.0f) {
                canvas.drawText(this.n[i4], this.o.left + width, ascent, paint4);
                f2 = ascent;
            }
        }
    }

    public boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && this.k) {
                    if (a(motionEvent.getX(), motionEvent.getY())) {
                        this.j = a(motionEvent.getY());
                        this.l.setSelection(this.m.getPositionForSection(this.j));
                    }
                    return true;
                }
            } else {
                if (this.k) {
                    this.k = false;
                    this.j = -1;
                }
                if (this.f24415g == 2) {
                    a(3);
                }
            }
        } else if (this.m != null && this.f24415g != 0 && a(motionEvent.getX(), motionEvent.getY())) {
            a(2);
            this.k = true;
            this.j = a(motionEvent.getY());
            this.l.setSelection(this.m.getPositionForSection(this.j));
            return true;
        }
        return false;
    }

    public void a(int i, int i2, int i3, int i4) {
        this.f24416h = i;
        this.i = i2;
        float f2 = i;
        this.o = new RectF((f2 - this.f24410b) - this.f24409a, this.p, f2, i2 - this.q);
    }

    public void a() {
        if (this.f24415g == 2) {
            a(3);
        }
    }

    public void a(Adapter adapter) {
        if (adapter instanceof SectionIndexer) {
            this.m = (SectionIndexer) adapter;
            this.n = (String[]) this.m.getSections();
        }
    }

    public void a(int i) {
        if (i < 0 || i > 3) {
            return;
        }
        this.f24415g = i;
        int i2 = this.f24415g;
        if (i2 == 0) {
            this.r.removeMessages(0);
            return;
        }
        if (i2 == 1) {
            this.f24414f = 0.0f;
            a(0L);
        } else {
            if (i2 != 2) {
                return;
            }
            this.r.removeMessages(0);
        }
    }

    private boolean a(float f2, float f3) {
        RectF rectF = this.o;
        if (f2 >= rectF.left) {
            float f4 = rectF.top;
            if (f3 >= f4 && f3 <= f4 + rectF.height()) {
                return true;
            }
        }
        return false;
    }

    private int a(float f2) {
        String[] strArr = this.n;
        if (strArr == null || strArr.length == 0) {
            return 0;
        }
        RectF rectF = this.o;
        float f3 = rectF.top;
        if (f2 < this.f24410b + f3) {
            return 0;
        }
        float height = f3 + rectF.height();
        float f4 = this.f24410b;
        if (f2 >= height - f4) {
            return this.n.length - 1;
        }
        RectF rectF2 = this.o;
        return (int) (((f2 - rectF2.top) - f4) / ((rectF2.height() - (this.f24410b * 2.0f)) / this.n.length));
    }

    public void a(long j) {
        this.r.removeMessages(0);
        this.r.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + j);
    }
}
