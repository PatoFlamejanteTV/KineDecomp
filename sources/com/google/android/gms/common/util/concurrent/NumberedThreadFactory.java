package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@KeepForSdk
/* loaded from: classes.dex */
public class NumberedThreadFactory implements ThreadFactory {

    /* renamed from: a */
    private final String f11295a;

    /* renamed from: b */
    private final int f11296b;

    /* renamed from: c */
    private final AtomicInteger f11297c;

    /* renamed from: d */
    private final ThreadFactory f11298d;

    @KeepForSdk
    public NumberedThreadFactory(String str) {
        this(str, 0);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f11298d.newThread(new a(runnable, 0));
        String str = this.f11295a;
        int andIncrement = this.f11297c.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(str);
        sb.append("[");
        sb.append(andIncrement);
        sb.append("]");
        newThread.setName(sb.toString());
        return newThread;
    }

    private NumberedThreadFactory(String str, int i) {
        this.f11297c = new AtomicInteger();
        this.f11298d = Executors.defaultThreadFactory();
        Preconditions.a(str, (Object) "Name must not be null");
        this.f11295a = str;
        this.f11296b = 0;
    }
}
