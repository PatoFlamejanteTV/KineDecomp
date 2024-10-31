package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.AttestationData;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.SafetyNetApi;
import java.util.List;

/* loaded from: classes.dex */
public class zzqn implements SafetyNetApi {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements SafetyNetApi.AttestationResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f1818a;
        private final AttestationData b;

        public a(Status status, AttestationData attestationData) {
            this.f1818a = status;
            this.b = attestationData;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.f1818a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class b extends iu<SafetyNetApi.AttestationResult> {
        protected zzql c;

        public b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.c = new ix(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SafetyNetApi.AttestationResult zzb(Status status) {
            return new a(status, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class c extends iu<SafetyNetApi.SafeBrowsingResult> {
        protected zzql d;

        public c(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.d = new iy(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SafetyNetApi.SafeBrowsingResult zzb(Status status) {
            return new d(status, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d implements SafetyNetApi.SafeBrowsingResult {

        /* renamed from: a, reason: collision with root package name */
        private Status f1819a;
        private final SafeBrowsingData b;
        private String c;

        public d(Status status, SafeBrowsingData safeBrowsingData) {
            this.f1819a = status;
            this.b = safeBrowsingData;
            this.c = null;
            if (this.b != null) {
                this.c = this.b.a();
            } else if (this.f1819a.d()) {
                this.f1819a = new Status(8);
            }
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.f1819a;
        }
    }

    public PendingResult<SafetyNetApi.AttestationResult> attest(GoogleApiClient googleApiClient, byte[] bArr) {
        return googleApiClient.zza((GoogleApiClient) new iv(this, googleApiClient, bArr));
    }

    public PendingResult<SafetyNetApi.SafeBrowsingResult> lookupUri(GoogleApiClient googleApiClient, List<Integer> list, String str) {
        if (list == null) {
            throw new IllegalArgumentException("Null threatTypes in lookupUri");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Null or empty uri in lookupUri");
        }
        return googleApiClient.zza((GoogleApiClient) new iw(this, googleApiClient, list, str));
    }
}
