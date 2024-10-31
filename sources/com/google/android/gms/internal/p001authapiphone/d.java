package com.google.android.gms.internal.p001authapiphone;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class d extends TaskApiCall<zzi, Void> {

    /* renamed from: c, reason: collision with root package name */
    private TaskCompletionSource<Void> f12745c;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(b bVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public /* synthetic */ void a(zzi zziVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        this.f12745c = taskCompletionSource;
        a((zze) zziVar.getService());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Status status) {
        TaskUtil.a(status, this.f12745c);
    }

    protected abstract void a(zze zzeVar) throws RemoteException;
}
