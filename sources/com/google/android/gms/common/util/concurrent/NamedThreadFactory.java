package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@KeepForSdk
/* loaded from: classes.dex */
public class NamedThreadFactory implements ThreadFactory {

    /* renamed from: a */
    private final String f11292a;

    /* renamed from: b */
    private final int f11293b;

    /* renamed from: c */
    private final ThreadFactory f11294c;

    @KeepForSdk
    public NamedThreadFactory(String str) {
        this(str, 0);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f11294c.newThread(new a(runnable, 0));
        newThread.setName(this.f11292a);
        return newThread;
    }

    private NamedThreadFactory(String str, int i) {
        this.f11294c = Executors.defaultThreadFactory();
        Preconditions.a(str, (Object) "Name must not be null");
        this.f11292a = str;
        this.f11293b = 0;
    }
}
