package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.moments.Moment;

/* loaded from: classes.dex */
public final class zzqh implements Moments {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class a extends Plus.zza<Moments.LoadMomentsResult> {
        private a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(GoogleApiClient googleApiClient, ij ijVar) {
            this(googleApiClient);
        }

        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Moments.LoadMomentsResult zzb(Status status) {
            return new in(this, status);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class b extends Plus.zza<Status> {
        private b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(GoogleApiClient googleApiClient, ij ijVar) {
            this(googleApiClient);
        }

        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Status zzb(Status status) {
            return status;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class c extends Plus.zza<Status> {
        private c(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ c(GoogleApiClient googleApiClient, ij ijVar) {
            this(googleApiClient);
        }

        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Status zzb(Status status) {
            return status;
        }
    }

    public PendingResult<Moments.LoadMomentsResult> load(GoogleApiClient googleApiClient) {
        return googleApiClient.zza((GoogleApiClient) new ij(this, googleApiClient));
    }

    public PendingResult<Moments.LoadMomentsResult> load(GoogleApiClient googleApiClient, int i, String str, Uri uri, String str2, String str3) {
        return googleApiClient.zza((GoogleApiClient) new ik(this, googleApiClient, i, str, uri, str2, str3));
    }

    public PendingResult<Status> remove(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zzb(new im(this, googleApiClient, str));
    }

    public PendingResult<Status> write(GoogleApiClient googleApiClient, Moment moment) {
        return googleApiClient.zzb(new il(this, googleApiClient, moment));
    }
}
