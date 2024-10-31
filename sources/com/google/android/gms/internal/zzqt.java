package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.SearchAuth;
import com.google.android.gms.search.SearchAuthApi;

/* loaded from: classes.dex */
public class zzqt implements SearchAuthApi {

    /* loaded from: classes.dex */
    static abstract class a extends zzqq.zza {
        public void zza(Status status, GoogleNowAuthState googleNowAuthState) {
            throw new UnsupportedOperationException();
        }

        public void zzbb(Status status) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes.dex */
    static class b extends zzlb.zza<Status, zzqs> {

        /* renamed from: a, reason: collision with root package name */
        private final GoogleApiClient f1822a;
        private final String b;
        private final boolean c;

        protected b(GoogleApiClient googleApiClient, String str) {
            super(SearchAuth.f2191a, googleApiClient);
            this.c = Log.isLoggable("SearchAuth", 3);
            this.f1822a = googleApiClient;
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Status zzb(Status status) {
            if (this.c) {
                Log.d("SearchAuth", "ClearTokenImpl received failure: " + status.b());
            }
            return status;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlb.zza
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void zza(zzqs zzqsVar) throws RemoteException {
            if (this.c) {
                Log.d("SearchAuth", "ClearTokenImpl started");
            }
            String packageName = this.f1822a.getContext().getPackageName();
            zzqsVar.zzpc().zzb(new iz(this), packageName, this.b);
        }
    }

    /* loaded from: classes.dex */
    static class c extends zzlb.zza<SearchAuthApi.GoogleNowAuthResult, zzqs> {

        /* renamed from: a, reason: collision with root package name */
        private final GoogleApiClient f1823a;
        private final String b;
        private final boolean c;

        protected c(GoogleApiClient googleApiClient, String str) {
            super(SearchAuth.f2191a, googleApiClient);
            this.c = Log.isLoggable("SearchAuth", 3);
            this.f1823a = googleApiClient;
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SearchAuthApi.GoogleNowAuthResult zzb(Status status) {
            if (this.c) {
                Log.d("SearchAuth", "GetGoogleNowAuthImpl received failure: " + status.b());
            }
            return new d(status, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlb.zza
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void zza(zzqs zzqsVar) throws RemoteException {
            if (this.c) {
                Log.d("SearchAuth", "GetGoogleNowAuthImpl started");
            }
            String packageName = this.f1823a.getContext().getPackageName();
            zzqsVar.zzpc().zza(new ja(this), packageName, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d implements SearchAuthApi.GoogleNowAuthResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f1824a;
        private final GoogleNowAuthState b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(Status status, GoogleNowAuthState googleNowAuthState) {
            this.f1824a = status;
            this.b = googleNowAuthState;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.f1824a;
        }
    }

    public PendingResult<Status> clearToken(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zza((GoogleApiClient) new b(googleApiClient, str));
    }

    public PendingResult<SearchAuthApi.GoogleNowAuthResult> getGoogleNowAuth(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zza((GoogleApiClient) new c(googleApiClient, str));
    }
}
