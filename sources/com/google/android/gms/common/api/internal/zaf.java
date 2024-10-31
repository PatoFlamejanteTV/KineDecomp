package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final class zaf extends O<Void> {

    /* renamed from: c, reason: collision with root package name */
    private final RegisterListenerMethod<Api.AnyClient, ?> f10929c;

    /* renamed from: d, reason: collision with root package name */
    private final UnregisterListenerMethod<Api.AnyClient, ?> f10930d;

    public zaf(zabw zabwVar, TaskCompletionSource<Void> taskCompletionSource) {
        super(3, taskCompletionSource);
        this.f10929c = zabwVar.f10905a;
        this.f10930d = zabwVar.f10906b;
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final /* bridge */ /* synthetic */ void a(zaab zaabVar, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.O, com.google.android.gms.common.api.internal.zab
    public final /* bridge */ /* synthetic */ void a(RuntimeException runtimeException) {
        super.a(runtimeException);
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final Feature[] b(GoogleApiManager.zaa<?> zaaVar) {
        return this.f10929c.c();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean c(GoogleApiManager.zaa<?> zaaVar) {
        return this.f10929c.d();
    }

    @Override // com.google.android.gms.common.api.internal.O
    public final void d(GoogleApiManager.zaa<?> zaaVar) throws RemoteException {
        this.f10929c.a(zaaVar.f(), this.f10785b);
        if (this.f10929c.b() != null) {
            zaaVar.i().put(this.f10929c.b(), new zabw(this.f10929c, this.f10930d));
        }
    }

    @Override // com.google.android.gms.common.api.internal.O, com.google.android.gms.common.api.internal.zab
    public final /* bridge */ /* synthetic */ void a(Status status) {
        super.a(status);
    }
}
