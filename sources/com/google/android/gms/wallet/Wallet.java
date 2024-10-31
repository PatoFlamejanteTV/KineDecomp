package com.google.android.gms.wallet;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import com.google.android.gms.internal.zzrq;
import com.google.android.gms.internal.zzrr;

/* loaded from: classes.dex */
public final class Wallet {
    private static final Api.zzc<zzro> e = new Api.zzc<>();
    private static final Api.zza<zzro, WalletOptions> f = new a();

    /* renamed from: a, reason: collision with root package name */
    public static final Api<WalletOptions> f2294a = new Api<>("Wallet.API", f, e);
    public static final Payments b = new zzrn();
    public static final com.google.android.gms.wallet.wobs.zzj c = new zzrr();
    public static final com.google.android.gms.wallet.firstparty.zza d = new zzrq();

    /* loaded from: classes.dex */
    public static final class WalletOptions implements Api.ApiOptions.HasOptions {

        /* renamed from: a, reason: collision with root package name */
        public final int f2295a;
        public final int b;

        /* loaded from: classes.dex */
        public static final class Builder {

            /* renamed from: a, reason: collision with root package name */
            private int f2296a = 3;
            private int b = 0;
        }

        private WalletOptions() {
            this(new Builder());
        }

        private WalletOptions(Builder builder) {
            this.f2295a = builder.f2296a;
            this.b = builder.b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ WalletOptions(a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class zza<R extends Result> extends zzlb.zza<R, zzro> {
        public zza(GoogleApiClient googleApiClient) {
            super(Wallet.e, googleApiClient);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class zzb extends zza<Status> {
        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Status zzb(Status status) {
            return status;
        }
    }

    private Wallet() {
    }
}
