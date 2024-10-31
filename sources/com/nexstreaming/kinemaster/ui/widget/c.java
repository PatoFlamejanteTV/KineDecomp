package com.nexstreaming.kinemaster.ui.widget;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.Scroller;
import com.nexstreaming.app.general.util.v;

/* compiled from: WheelScroller.java */
/* loaded from: classes2.dex */
public class C {

    /* renamed from: a */
    private a f23720a;

    /* renamed from: b */
    private Context f23721b;

    /* renamed from: c */
    private com.nexstreaming.app.general.util.v f23722c;

    /* renamed from: d */
    private Scroller f23723d;

    /* renamed from: e */
    private int f23724e;

    /* renamed from: f */
    private float f23725f;

    /* renamed from: g */
    private boolean f23726g;

    /* renamed from: h */
    private v.d f23727h = new A(this);
    private final int i = 0;
    private final int j = 1;
    private Handler k = new B(this);

    /* compiled from: WheelScroller.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void a(int i);

        void b();

        void c();
    }

    public C(Context context, a aVar) {
        this.f23722c = new com.nexstreaming.app.general.util.v(context, this.f23727h);
        this.f23722c.a(false);
        this.f23723d = new Scroller(context);
        this.f23720a = aVar;
        this.f23721b = context;
    }

    private void c() {
        this.k.removeMessages(0);
        this.k.removeMessages(1);
    }

    public void d() {
        this.f23720a.a();
        a(1);
    }

    private void e() {
        if (this.f23726g) {
            return;
        }
        this.f23726g = true;
        this.f23720a.b();
    }

    public void a(int i, int i2) {
        this.f23723d.forceFinished(true);
        this.f23724e = 0;
        this.f23723d.startScroll(0, 0, 0, i, i2 != 0 ? i2 : 400);
        a(0);
        e();
    }

    public void b() {
        this.f23723d.forceFinished(true);
    }

    public boolean a(MotionEvent motionEvent) {
        int y;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f23725f = motionEvent.getY();
            this.f23723d.forceFinished(true);
            c();
        } else if (action == 2 && (y = (int) (motionEvent.getY() - this.f23725f)) != 0) {
            e();
            this.f23720a.a(y);
            this.f23725f = motionEvent.getY();
        }
        if (!this.f23722c.a(motionEvent) && motionEvent.getAction() == 1) {
            d();
        }
        return true;
    }

    public void a(int i) {
        c();
        this.k.sendEmptyMessage(i);
    }

    public void a() {
        if (this.f23726g) {
            this.f23720a.c();
            this.f23726g = false;
        }
    }
}
