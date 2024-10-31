package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final class zag<ResultT> extends zac {

    /* renamed from: b, reason: collision with root package name */
    private final TaskApiCall<Api.AnyClient, ResultT> f10931b;

    /* renamed from: c, reason: collision with root package name */
    private final TaskCompletionSource<ResultT> f10932c;

    /* renamed from: d, reason: collision with root package name */
    private final StatusExceptionMapper f10933d;

    public zag(int i, TaskApiCall<Api.AnyClient, ResultT> taskApiCall, TaskCompletionSource<ResultT> taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        super(i);
        this.f10932c = taskCompletionSource;
        this.f10931b = taskApiCall;
        this.f10933d = statusExceptionMapper;
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void a(GoogleApiManager.zaa<?> zaaVar) throws DeadObjectException {
        Status b2;
        try {
            this.f10931b.a(zaaVar.f(), this.f10932c);
        } catch (DeadObjectException e2) {
            throw e2;
        } catch (RemoteException e3) {
            b2 = zab.b(e3);
            a(b2);
        } catch (RuntimeException e4) {
            a(e4);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final Feature[] b(GoogleApiManager.zaa<?> zaaVar) {
        return this.f10931b.c();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean c(GoogleApiManager.zaa<?> zaaVar) {
        return this.f10931b.b();
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void a(Status status) {
        this.f10932c.b(this.f10933d.a(status));
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void a(RuntimeException runtimeException) {
        this.f10932c.b(runtimeException);
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void a(zaab zaabVar, boolean z) {
        zaabVar.a(this.f10932c, z);
    }
}
