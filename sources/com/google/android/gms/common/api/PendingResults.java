package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
/* loaded from: classes.dex */
public final class PendingResults {

    /* loaded from: classes.dex */
    private static final class a<R extends Result> extends BasePendingResult<R> {
        private final R q;

        public a(GoogleApiClient googleApiClient, R r) {
            super(googleApiClient);
            this.q = r;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public final R a(Status status) {
            return this.q;
        }
    }

    @KeepForSdk
    private PendingResults() {
    }

    @KeepForSdk
    public static PendingResult<Status> a(Status status, GoogleApiClient googleApiClient) {
        Preconditions.a(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(googleApiClient);
        statusPendingResult.a((StatusPendingResult) status);
        return statusPendingResult;
    }

    @KeepForSdk
    public static <R extends Result> PendingResult<R> a(R r, GoogleApiClient googleApiClient) {
        Preconditions.a(r, "Result must not be null");
        Preconditions.a(!r.getStatus().Q(), "Status code must not be SUCCESS");
        a aVar = new a(googleApiClient, r);
        aVar.a((a) r);
        return aVar;
    }
}
