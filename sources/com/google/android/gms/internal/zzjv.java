package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.appinvite.AppInvite;
import com.google.android.gms.appinvite.AppInviteApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb;

/* loaded from: classes.dex */
public class zzjv implements AppInviteApi {

    /* loaded from: classes.dex */
    static abstract class a<R extends Result> extends zzlb.zza<R, zzjw> {
        public a(GoogleApiClient googleApiClient) {
            super(AppInvite.f776a, googleApiClient);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class b extends a<Status> {
        private final String b;

        public b(GoogleApiClient googleApiClient, String str) {
            super(googleApiClient);
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Status zzb(Status status) {
            return status;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlb.zza
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void zza(zzjw zzjwVar) throws RemoteException {
            zzjwVar.zzb(new es(this), this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class c extends a<Status> {
        private final String b;

        public c(GoogleApiClient googleApiClient, String str) {
            super(googleApiClient);
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Status zzb(Status status) {
            return status;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlb.zza
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void zza(zzjw zzjwVar) throws RemoteException {
            zzjwVar.zza(new et(this), this.b);
        }
    }

    public PendingResult<Status> convertInvitation(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zza((GoogleApiClient) new c(googleApiClient, str));
    }

    public PendingResult<Status> updateInvitationOnInstall(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zza((GoogleApiClient) new b(googleApiClient, str));
    }
}
