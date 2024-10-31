package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final class zah extends O<Boolean> {

    /* renamed from: c, reason: collision with root package name */
    private final ListenerHolder.ListenerKey<?> f10934c;

    public zah(ListenerHolder.ListenerKey<?> listenerKey, TaskCompletionSource<Boolean> taskCompletionSource) {
        super(4, taskCompletionSource);
        this.f10934c = listenerKey;
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
        zabw zabwVar = zaaVar.i().get(this.f10934c);
        if (zabwVar == null) {
            return null;
        }
        return zabwVar.f10905a.c();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean c(GoogleApiManager.zaa<?> zaaVar) {
        zabw zabwVar = zaaVar.i().get(this.f10934c);
        return zabwVar != null && zabwVar.f10905a.d();
    }

    @Override // com.google.android.gms.common.api.internal.O
    public final void d(GoogleApiManager.zaa<?> zaaVar) throws RemoteException {
        zabw remove = zaaVar.i().remove(this.f10934c);
        if (remove != null) {
            remove.f10906b.a(zaaVar.f(), this.f10785b);
            remove.f10905a.a();
        } else {
            this.f10785b.b((TaskCompletionSource<T>) false);
        }
    }

    @Override // com.google.android.gms.common.api.internal.O, com.google.android.gms.common.api.internal.zab
    public final /* bridge */ /* synthetic */ void a(Status status) {
        super.a(status);
    }
}
