package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.util.PlatformVersion;

/* loaded from: classes.dex */
public abstract class zab {

    /* renamed from: a, reason: collision with root package name */
    private final int f10888a;

    public zab(int i) {
        this.f10888a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status b(RemoteException remoteException) {
        StringBuilder sb = new StringBuilder();
        if (PlatformVersion.b() && (remoteException instanceof TransactionTooLargeException)) {
            sb.append("TransactionTooLargeException: ");
        }
        sb.append(remoteException.getLocalizedMessage());
        return new Status(8, sb.toString());
    }

    public abstract void a(Status status);

    public abstract void a(GoogleApiManager.zaa<?> zaaVar) throws DeadObjectException;

    public abstract void a(zaab zaabVar, boolean z);

    public abstract void a(RuntimeException runtimeException);
}
