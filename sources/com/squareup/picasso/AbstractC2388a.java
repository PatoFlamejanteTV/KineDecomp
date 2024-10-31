package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Action.java */
/* renamed from: com.squareup.picasso.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2388a<T> {

    /* renamed from: a, reason: collision with root package name */
    final Picasso f25622a;

    /* renamed from: b, reason: collision with root package name */
    final C f25623b;

    /* renamed from: c, reason: collision with root package name */
    final WeakReference<T> f25624c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f25625d;

    /* renamed from: e, reason: collision with root package name */
    final int f25626e;

    /* renamed from: f, reason: collision with root package name */
    final int f25627f;

    /* renamed from: g, reason: collision with root package name */
    final int f25628g;

    /* renamed from: h, reason: collision with root package name */
    final Drawable f25629h;
    final String i;
    final Object j;
    boolean k;
    boolean l;

    /* compiled from: Action.java */
    /* renamed from: com.squareup.picasso.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C0131a<M> extends WeakReference<M> {

        /* renamed from: a, reason: collision with root package name */
        final AbstractC2388a f25630a;

        public C0131a(AbstractC2388a abstractC2388a, M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.f25630a = abstractC2388a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC2388a(Picasso picasso, T t, C c2, int i, int i2, int i3, Drawable drawable, String str, Object obj, boolean z) {
        this.f25622a = picasso;
        this.f25623b = c2;
        this.f25624c = t == null ? null : new C0131a(this, t, picasso.m);
        this.f25626e = i;
        this.f25627f = i2;
        this.f25625d = z;
        this.f25628g = i3;
        this.f25629h = drawable;
        this.i = str;
        this.j = obj == null ? this : obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.l = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Bitmap bitmap, Picasso.LoadedFrom loadedFrom);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f25626e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f25627f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Picasso f() {
        return this.f25622a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Picasso.Priority g() {
        return this.f25623b.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C h() {
        return this.f25623b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object i() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public T j() {
        WeakReference<T> weakReference = this.f25624c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.k;
    }
}
