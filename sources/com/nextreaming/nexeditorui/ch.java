package com.nextreaming.nexeditorui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.SectionIndexer;

/* compiled from: NexIndexScroller.java */
/* loaded from: classes.dex */
public class ch {

    /* renamed from: a, reason: collision with root package name */
    private float f4571a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private int h;
    private int i;
    private ListView l;
    private RectF o;
    private int p;
    private int q;
    private int g = 0;
    private int j = -1;
    private boolean k = false;
    private SectionIndexer m = null;
    private String[] n = null;
    private Handler r = new ci(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ float a(ch chVar, double d) {
        float f = (float) (chVar.f + d);
        chVar.f = f;
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ float b(ch chVar, double d) {
        float f = (float) (chVar.f - d);
        chVar.f = f;
        return f;
    }

    public ch(Context context, NexIndexableListView nexIndexableListView, int i, int i2) {
        this.l = null;
        this.d = context.getResources().getDisplayMetrics().density;
        this.e = context.getResources().getDisplayMetrics().scaledDensity;
        this.l = nexIndexableListView;
        a(this.l.getAdapter());
        this.p = i;
        this.q = i2;
        this.f4571a = 20.0f * this.d;
        this.b = 10.0f * this.d;
        this.c = 5.0f * this.d;
    }

    public void a(Canvas canvas) {
        float f = 0.0f;
        if (this.g != 0 && this.n != null) {
            Paint paint = new Paint();
            paint.setColor(-16777216);
            paint.setAlpha((int) (64.0f * this.f));
            paint.setAntiAlias(true);
            canvas.drawRect(this.o, paint);
            if (this.n != null && this.n.length > 0) {
                if (this.j >= 0 && this.j < this.n.length) {
                    Paint paint2 = new Paint();
                    paint2.setColor(-16777216);
                    paint2.setAlpha(96);
                    paint2.setAntiAlias(true);
                    paint2.setShadowLayer(3.0f, 0.0f, 0.0f, Color.argb(64, 0, 0, 0));
                    Paint paint3 = new Paint();
                    paint3.setColor(-1);
                    paint3.setAntiAlias(true);
                    paint3.setTextSize(50.0f * this.e);
                    float measureText = paint3.measureText(this.n[this.j]);
                    float descent = ((this.c * 2.0f) + paint3.descent()) - paint3.ascent();
                    RectF rectF = new RectF((this.h - descent) / 2.0f, (this.i - descent) / 2.0f, ((this.h - descent) / 2.0f) + descent, descent + ((this.i - descent) / 2.0f));
                    canvas.drawRoundRect(rectF, 5.0f * this.d, 5.0f * this.d, paint2);
                    canvas.drawText(this.n[this.j], (((rectF.width() - measureText) / 2.0f) + rectF.left) - 1.0f, ((rectF.top + this.c) - paint3.ascent()) + 1.0f, paint3);
                }
                Paint paint4 = new Paint();
                paint4.setColor(-1);
                paint4.setAlpha((int) (255.0f * this.f));
                paint4.setAntiAlias(true);
                paint4.setTextSize(12.0f * this.e);
                float height = (this.o.height() - (this.b * 2.0f)) / this.n.length;
                float descent2 = (height - (paint4.descent() - paint4.ascent())) / 2.0f;
                for (int i = 0; i < this.n.length; i++) {
                    float width = (this.o.width() - paint4.measureText(this.n[i])) / 2.0f;
                    float ascent = (((this.o.top + this.b) + (i * height)) + descent2) - paint4.ascent();
                    if (ascent - f >= 12.0f * this.e) {
                        canvas.drawText(this.n[i], width + this.o.left, ascent, paint4);
                        f = ascent;
                    }
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
    public boolean a(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.m != null && this.g != 0 && a(motionEvent.getX(), motionEvent.getY())) {
                    a(2);
                    this.k = true;
                    this.j = a(motionEvent.getY());
                    this.l.setSelection(this.m.getPositionForSection(this.j));
                    return true;
                }
                return false;
            case 1:
                if (this.k) {
                    this.k = false;
                    this.j = -1;
                }
                if (this.g == 2) {
                    a(3);
                }
                return false;
            case 2:
                if (this.k) {
                    if (!a(motionEvent.getX(), motionEvent.getY())) {
                        return true;
                    }
                    this.j = a(motionEvent.getY());
                    this.l.setSelection(this.m.getPositionForSection(this.j));
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        this.h = i;
        this.i = i2;
        this.o = new RectF((i - this.b) - this.f4571a, this.p, i, i2 - this.q);
    }

    public void a() {
        if (this.g == 0) {
            a(1);
        } else if (this.g == 3) {
            a(3);
        }
    }

    public void b() {
        if (this.g == 2) {
            a(3);
        }
    }

    public void a(Adapter adapter) {
        if (adapter instanceof SectionIndexer) {
            this.m = (SectionIndexer) adapter;
            this.n = (String[]) this.m.getSections();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (i >= 0 && i <= 3) {
            this.g = i;
            switch (this.g) {
                case 0:
                    this.r.removeMessages(0);
                    return;
                case 1:
                    this.f = 0.0f;
                    a(0L);
                    return;
                case 2:
                    this.r.removeMessages(0);
                    return;
                default:
                    return;
            }
        }
    }

    private boolean a(float f, float f2) {
        return f >= this.o.left && f2 >= this.o.top && f2 <= this.o.top + this.o.height();
    }

    private int a(float f) {
        if (this.n == null || this.n.length == 0 || f < this.o.top + this.b) {
            return 0;
        }
        if (f >= (this.o.top + this.o.height()) - this.b) {
            return this.n.length - 1;
        }
        return (int) (((f - this.o.top) - this.b) / ((this.o.height() - (2.0f * this.b)) / this.n.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        this.r.removeMessages(0);
        this.r.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + j);
    }
}
