package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzlm;

/* loaded from: classes.dex */
final class b<T> extends s<Status> {

    /* renamed from: a, reason: collision with root package name */
    private T f2367a;
    private zzlm<T> b;
    private a<T> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a<T> {
        void a(zzbo zzboVar, zzlb.zzb<Status> zzbVar, T t, zzlm<T> zzlmVar) throws RemoteException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Status zzb(Status status) {
        this.f2367a = null;
        this.b = null;
        return status;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(zzbo zzboVar) throws RemoteException {
        this.c.a(zzboVar, this, this.f2367a, this.b);
        this.f2367a = null;
        this.b = null;
    }
}
