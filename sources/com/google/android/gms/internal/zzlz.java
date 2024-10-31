package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb;

/* loaded from: classes.dex */
public final class zzlz implements zzly {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends zzlw {

        /* renamed from: a, reason: collision with root package name */
        private final zzlb.zzb<Status> f1767a;

        public a(zzlb.zzb<Status> zzbVar) {
            this.f1767a = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzlw, com.google.android.gms.internal.zzmc
        public void zzbN(int i) throws RemoteException {
            this.f1767a.zzp(new Status(i));
        }
    }

    @Override // com.google.android.gms.internal.zzly
    public PendingResult<Status> zzb(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new gg(this, googleApiClient));
    }
}
