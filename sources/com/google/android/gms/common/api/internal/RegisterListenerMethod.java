package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class RegisterListenerMethod<A extends Api.AnyClient, L> {

    /* renamed from: a */
    private final ListenerHolder<L> f10791a;

    /* renamed from: b */
    private final Feature[] f10792b;

    /* renamed from: c */
    private final boolean f10793c;

    @KeepForSdk
    public void a() {
        this.f10791a.a();
    }

    @KeepForSdk
    public abstract void a(A a2, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException;

    @KeepForSdk
    public ListenerHolder.ListenerKey<L> b() {
        return this.f10791a.b();
    }

    @KeepForSdk
    public Feature[] c() {
        return this.f10792b;
    }

    public final boolean d() {
        return this.f10793c;
    }
}
