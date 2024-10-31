package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb;

/* loaded from: classes2.dex */
public class zzbt extends zzd {

    /* renamed from: a, reason: collision with root package name */
    private final zzlb.zzb<Status> f1138a;

    @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
    public void a() throws RemoteException {
        this.f1138a.zzp(Status.f979a);
    }

    @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
    public void a(Status status) throws RemoteException {
        this.f1138a.zzp(status);
    }
}
