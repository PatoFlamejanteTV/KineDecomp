package com.mixpanel.android.viewcrawler;

import android.os.Looper;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: UIThreadSet.java */
/* loaded from: classes.dex */
class i<T> {

    /* renamed from: a, reason: collision with root package name */
    private Set<T> f3094a = new HashSet();

    public void b(T t) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new RuntimeException("Can't add an activity when not on the UI thread");
        }
        this.f3094a.add(t);
    }

    public void a(T t) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new RuntimeException("Can't remove an activity when not on the UI thread");
        }
        this.f3094a.remove(t);
    }

    public Set<T> a() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new RuntimeException("Can't remove an activity when not on the UI thread");
        }
        return Collections.unmodifiableSet(this.f3094a);
    }

    public boolean b() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new RuntimeException("Can't check isEmpty() when not on the UI thread");
        }
        return this.f3094a.isEmpty();
    }
}
