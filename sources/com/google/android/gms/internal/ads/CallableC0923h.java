package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class CallableC0923h implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f12187a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallableC0923h(Context context) {
        this.f12187a = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Void call() throws Exception {
        zzwu.zzpz().initialize(this.f12187a);
        return null;
    }
}
