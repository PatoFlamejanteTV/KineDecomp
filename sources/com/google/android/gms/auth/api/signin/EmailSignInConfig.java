package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Patterns;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public class EmailSignInConfig implements SafeParcelable {
    public static final Parcelable.Creator<EmailSignInConfig> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    final int f803a;
    private final Uri b;
    private String c;
    private Uri d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmailSignInConfig(int i, Uri uri, String str, Uri uri2) {
        zzx.a(uri, "Server widget url cannot be null in order to use email/password sign in.");
        zzx.a(uri.toString(), (Object) "Server widget url cannot be null in order to use email/password sign in.");
        zzx.b(Patterns.WEB_URL.matcher(uri.toString()).matches(), "Invalid server widget url");
        this.f803a = i;
        this.b = uri;
        this.c = str;
        this.d = uri2;
    }

    public Uri a() {
        return this.b;
    }

    public Uri b() {
        return this.d;
    }

    public String c() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001a, code lost:            if (r4.b() == null) goto L11;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
        L3:
            return r0
        L4:
            com.google.android.gms.auth.api.signin.EmailSignInConfig r4 = (com.google.android.gms.auth.api.signin.EmailSignInConfig) r4     // Catch: java.lang.ClassCastException -> L4a
            android.net.Uri r1 = r3.b     // Catch: java.lang.ClassCastException -> L4a
            android.net.Uri r2 = r4.a()     // Catch: java.lang.ClassCastException -> L4a
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L4a
            if (r1 == 0) goto L3
            android.net.Uri r1 = r3.d     // Catch: java.lang.ClassCastException -> L4a
            if (r1 != 0) goto L30
            android.net.Uri r1 = r4.b()     // Catch: java.lang.ClassCastException -> L4a
            if (r1 != 0) goto L3
        L1c:
            java.lang.String r1 = r3.c     // Catch: java.lang.ClassCastException -> L4a
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L4a
            if (r1 == 0) goto L3d
            java.lang.String r1 = r4.c()     // Catch: java.lang.ClassCastException -> L4a
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L4a
            if (r1 == 0) goto L3
        L2e:
            r0 = 1
            goto L3
        L30:
            android.net.Uri r1 = r3.d     // Catch: java.lang.ClassCastException -> L4a
            android.net.Uri r2 = r4.b()     // Catch: java.lang.ClassCastException -> L4a
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L4a
            if (r1 == 0) goto L3
            goto L1c
        L3d:
            java.lang.String r1 = r3.c     // Catch: java.lang.ClassCastException -> L4a
            java.lang.String r2 = r4.c()     // Catch: java.lang.ClassCastException -> L4a
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L4a
            if (r1 == 0) goto L3
            goto L2e
        L4a:
            r1 = move-exception
            goto L3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.EmailSignInConfig.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return new com.google.android.gms.auth.api.signin.internal.zzc().a(this.b).a(this.d).a(this.c).a();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
