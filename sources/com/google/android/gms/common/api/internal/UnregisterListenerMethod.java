package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class UnregisterListenerMethod<A extends Api.AnyClient, L> {

    /* renamed from: a */
    private final ListenerHolder.ListenerKey<L> f10813a;

    @KeepForSdk
    public ListenerHolder.ListenerKey<L> a() {
        return this.f10813a;
    }

    @KeepForSdk
    public abstract void a(A a2, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException;
}
