package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class O<T> extends zac {

    /* renamed from: b, reason: collision with root package name */
    protected final TaskCompletionSource<T> f10785b;

    public O(int i, TaskCompletionSource<T> taskCompletionSource) {
        super(i);
        this.f10785b = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public void a(Status status) {
        this.f10785b.b(new ApiException(status));
    }

    protected abstract void d(GoogleApiManager.zaa<?> zaaVar) throws RemoteException;

    @Override // com.google.android.gms.common.api.internal.zab
    public void a(RuntimeException runtimeException) {
        this.f10785b.b(runtimeException);
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void a(GoogleApiManager.zaa<?> zaaVar) throws DeadObjectException {
        Status b2;
        Status b3;
        try {
            d(zaaVar);
        } catch (DeadObjectException e2) {
            b3 = zab.b(e2);
            a(b3);
            throw e2;
        } catch (RemoteException e3) {
            b2 = zab.b(e3);
            a(b2);
        } catch (RuntimeException e4) {
            a(e4);
        }
    }
}
