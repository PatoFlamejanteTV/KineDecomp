package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.common.api.internal.d */
/* loaded from: classes.dex */
public final class C0800d {

    /* renamed from: a */
    private final zai<?> f10830a;

    /* renamed from: b */
    private final TaskCompletionSource<Boolean> f10831b = new TaskCompletionSource<>();

    public C0800d(zai<?> zaiVar) {
        this.f10830a = zaiVar;
    }

    public final TaskCompletionSource<Boolean> a() {
        return this.f10831b;
    }

    public final zai<?> b() {
        return this.f10830a;
    }
}
