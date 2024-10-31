package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb;

/* loaded from: classes.dex */
abstract class gh<R extends Result> extends zzlb.zza<R, zzmb> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class a extends gh<Status> {
        public a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Status zzb(Status status) {
            return status;
        }
    }

    public gh(GoogleApiClient googleApiClient) {
        super(zzlx.zzRk, googleApiClient);
    }
}
