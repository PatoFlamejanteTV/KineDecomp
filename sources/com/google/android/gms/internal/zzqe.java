package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus;

/* loaded from: classes.dex */
public final class zzqe implements Account {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class a extends Plus.zza<Status> {
        private a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(GoogleApiClient googleApiClient, ii iiVar) {
            this(googleApiClient);
        }

        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Status zzb(Status status) {
            return status;
        }
    }

    public void clearDefaultAccount(GoogleApiClient googleApiClient) {
        com.google.android.gms.plus.internal.zze a2 = Plus.a(googleApiClient, false);
        if (a2 != null) {
            a2.c();
        }
    }

    public String getAccountName(GoogleApiClient googleApiClient) {
        return Plus.a(googleApiClient, true).a();
    }

    public PendingResult<Status> revokeAccessAndDisconnect(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new ii(this, googleApiClient));
    }
}
