package com.squareup.picasso;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* compiled from: Stats.java */
/* loaded from: classes3.dex */
public class H {

    /* renamed from: a */
    final HandlerThread f25578a = new HandlerThread("Picasso-Stats", 10);

    /* renamed from: b */
    final InterfaceC2398k f25579b;

    /* renamed from: c */
    final Handler f25580c;

    /* renamed from: d */
    long f25581d;

    /* renamed from: e */
    long f25582e;

    /* renamed from: f */
    long f25583f;

    /* renamed from: g */
    long f25584g;

    /* renamed from: h */
    long f25585h;
    long i;
    long j;
    long k;
    int l;
    int m;
    int n;

    /* compiled from: Stats.java */
    /* loaded from: classes3.dex */
    public static class a extends Handler {

        /* renamed from: a */
        private final H f25586a;

        public a(Looper looper, H h2) {
            super(looper);
            this.f25586a = h2;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                this.f25586a.d();
                return;
            }
            if (i == 1) {
                this.f25586a.e();
                return;
            }
            if (i == 2) {
                this.f25586a.b(message.arg1);
                return;
            }
            if (i == 3) {
                this.f25586a.c(message.arg1);
            } else if (i != 4) {
                Picasso.f25603a.post(new G(this, message));
            } else {
                this.f25586a.a((Long) message.obj);
            }
        }
    }

    public H(InterfaceC2398k interfaceC2398k) {
        this.f25579b = interfaceC2398k;
        this.f25578a.start();
        N.a(this.f25578a.getLooper());
        this.f25580c = new a(this.f25578a.getLooper(), this);
    }

    public void a(Bitmap bitmap) {
        a(bitmap, 2);
    }

    public void b(Bitmap bitmap) {
        a(bitmap, 3);
    }

    public void c() {
        this.f25580c.sendEmptyMessage(1);
    }

    void d() {
        this.f25581d++;
    }

    void e() {
        this.f25582e++;
    }

    public void a(long j) {
        Handler handler = this.f25580c;
        handler.sendMessage(handler.obtainMessage(4, Long.valueOf(j)));
    }

    public void b() {
        this.f25580c.sendEmptyMessage(0);
    }

    void c(long j) {
        this.n++;
        this.f25585h += j;
        this.k = a(this.m, this.f25585h);
    }

    void a(Long l) {
        this.l++;
        this.f25583f += l.longValue();
        this.i = a(this.l, this.f25583f);
    }

    void b(long j) {
        this.m++;
        this.f25584g += j;
        this.j = a(this.m, this.f25584g);
    }

    public I a() {
        return new I(this.f25579b.a(), this.f25579b.size(), this.f25581d, this.f25582e, this.f25583f, this.f25584g, this.f25585h, this.i, this.j, this.k, this.l, this.m, this.n, System.currentTimeMillis());
    }

    private void a(Bitmap bitmap, int i) {
        int a2 = N.a(bitmap);
        Handler handler = this.f25580c;
        handler.sendMessage(handler.obtainMessage(i, a2, 0));
    }

    private static long a(int i, long j) {
        return j / i;
    }
}
