package com.google.android.gms.vision;

/* loaded from: classes.dex */
public abstract class Detector<T> {

    /* renamed from: a, reason: collision with root package name */
    private Object f2248a = new Object();
    private Processor<T> b;

    /* loaded from: classes.dex */
    public static class Detections<T> {
    }

    /* loaded from: classes.dex */
    public interface Processor<T> {
        void a();
    }

    public void a() {
        synchronized (this.f2248a) {
            if (this.b != null) {
                this.b.a();
                this.b = null;
            }
        }
    }
}
