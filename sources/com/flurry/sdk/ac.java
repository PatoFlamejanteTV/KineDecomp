package com.flurry.sdk;

import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
class ac {

    /* renamed from: a, reason: collision with root package name */
    private Timer f449a;
    private a b;
    private b c;

    /* loaded from: classes.dex */
    public interface b {
        void m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends TimerTask {
        private b b;

        a(b bVar) {
            this.b = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            ac.this.a();
            if (this.b != null) {
                this.b.m();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(b bVar) {
        this.c = bVar;
    }

    public synchronized void a(long j) {
        if (b()) {
            a();
        }
        this.f449a = new Timer("FlurrySessionTimer");
        this.b = new a(this.c);
        this.f449a.schedule(this.b, j);
    }

    public synchronized void a() {
        if (this.f449a != null) {
            this.f449a.cancel();
            this.f449a = null;
        }
        this.b = null;
    }

    public boolean b() {
        return this.f449a != null;
    }
}
