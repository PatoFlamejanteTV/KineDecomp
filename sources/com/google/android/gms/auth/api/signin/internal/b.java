package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
final class b extends zzc {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ a f10601a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f10601a = aVar;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzc, com.google.android.gms.auth.api.signin.internal.zzs
    public final void c(Status status) throws RemoteException {
        this.f10601a.a((a) status);
    }
}
