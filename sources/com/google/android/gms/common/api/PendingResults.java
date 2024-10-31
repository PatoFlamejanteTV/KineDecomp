package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlc;
import com.google.android.gms.internal.zzlo;

/* loaded from: classes.dex */
public final class PendingResults {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a<R extends Result> extends zzlc<R> {

        /* renamed from: a */
        private final R f977a;

        public a(GoogleApiClient googleApiClient, R r) {
            super(googleApiClient);
            this.f977a = r;
        }

        @Override // com.google.android.gms.internal.zzlc
        public R zzb(Status status) {
            return this.f977a;
        }
    }

    private PendingResults() {
    }

    public static <R extends Result> PendingResult<R> a(R r, GoogleApiClient googleApiClient) {
        zzx.a(r, "Result must not be null");
        zzx.b(!r.getStatus().d(), "Status code must not be SUCCESS");
        a aVar = new a(googleApiClient, r);
        aVar.zzb((a) r);
        return aVar;
    }

    public static PendingResult<Status> a(Status status, GoogleApiClient googleApiClient) {
        zzx.a(status, "Result must not be null");
        zzlo zzloVar = new zzlo(googleApiClient);
        zzloVar.zzb((zzlo) status);
        return zzloVar;
    }
}
