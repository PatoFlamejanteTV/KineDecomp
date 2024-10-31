package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzlb;
import java.util.List;

/* loaded from: classes.dex */
public class GetRecentContextCall {

    /* loaded from: classes.dex */
    public static class Request implements SafeParcelable {
        public static final zzf CREATOR = new zzf();

        /* renamed from: a, reason: collision with root package name */
        final int f760a;
        public final Account b;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        public final String f;

        /* loaded from: classes.dex */
        public static final class zza {

            /* renamed from: a, reason: collision with root package name */
            private Account f761a;
            private boolean b;
            private boolean c;
            private boolean d;
            private String e;

            public zza a(String str) {
                this.e = str;
                return this;
            }

            public zza a(boolean z) {
                this.c = z;
                return this;
            }

            public Request a() {
                return new Request(this.f761a, this.b, this.c, this.d, this.e);
            }
        }

        public Request() {
            this(null, false, false, false, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Request(int i, Account account, boolean z, boolean z2, boolean z3, String str) {
            this.f760a = i;
            this.b = account;
            this.c = z;
            this.d = z2;
            this.e = z3;
            this.f = str;
        }

        public Request(Account account, boolean z, boolean z2, boolean z3, String str) {
            this(1, account, z, z2, z3, str);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzf zzfVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzf zzfVar = CREATOR;
            zzf.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public static class Response implements Result, SafeParcelable {
        public static final zzg CREATOR = new zzg();

        /* renamed from: a, reason: collision with root package name */
        public Status f762a;
        public List<UsageInfo> b;
        public String[] c;
        final int d;

        public Response() {
            this.d = 1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Response(int i, Status status, List<UsageInfo> list, String[] strArr) {
            this.d = i;
            this.f762a = status;
            this.b = list;
            this.c = strArr;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzg zzgVar = CREATOR;
            return 0;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.f762a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzg zzgVar = CREATOR;
            zzg.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public static class zza extends zzlb.zza<Response, zzjs> {

        /* renamed from: a, reason: collision with root package name */
        private final Request f763a;

        public zza(Request request, GoogleApiClient googleApiClient) {
            super(com.google.android.gms.appdatasearch.zza.f769a, googleApiClient);
            this.f763a = request;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Response zzb(Status status) {
            Response response = new Response();
            response.f762a = status;
            return response;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlb.zza
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void zza(zzjs zzjsVar) throws RemoteException {
            zzjsVar.zzlw().zza(this.f763a, new a(this, this));
        }
    }
}
