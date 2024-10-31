package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.EmailSignInConfig;
import com.google.android.gms.auth.api.signin.FacebookSignInConfig;
import com.google.android.gms.auth.api.signin.GoogleSignInConfig;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public final class SignInConfiguration implements SafeParcelable {

    /* renamed from: a, reason: collision with root package name */
    final int f808a;
    private final String c;
    private String d;
    private EmailSignInConfig e;
    private GoogleSignInConfig f;
    private FacebookSignInConfig g;
    private String h;
    private static int b = 31;
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new zzh();

    /* JADX INFO: Access modifiers changed from: package-private */
    public SignInConfiguration(int i, String str, String str2, EmailSignInConfig emailSignInConfig, GoogleSignInConfig googleSignInConfig, FacebookSignInConfig facebookSignInConfig, String str3) {
        this.f808a = i;
        this.c = zzx.a(str);
        this.d = str2;
        this.e = emailSignInConfig;
        this.f = googleSignInConfig;
        this.g = facebookSignInConfig;
        this.h = str3;
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public EmailSignInConfig c() {
        return this.e;
    }

    public GoogleSignInConfig d() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public FacebookSignInConfig e() {
        return this.g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:            if (android.text.TextUtils.isEmpty(r4.b()) != false) goto L11;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:            if (android.text.TextUtils.isEmpty(r4.f()) != false) goto L15;     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003e, code lost:            if (r4.c() == null) goto L19;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:            if (r4.e() == null) goto L23;     */
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
            com.google.android.gms.auth.api.signin.internal.SignInConfiguration r4 = (com.google.android.gms.auth.api.signin.internal.SignInConfiguration) r4     // Catch: java.lang.ClassCastException -> L97
            java.lang.String r1 = r3.c     // Catch: java.lang.ClassCastException -> L97
            java.lang.String r2 = r4.a()     // Catch: java.lang.ClassCastException -> L97
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L97
            if (r1 == 0) goto L3
            java.lang.String r1 = r3.d     // Catch: java.lang.ClassCastException -> L97
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L97
            if (r1 == 0) goto L56
            java.lang.String r1 = r4.b()     // Catch: java.lang.ClassCastException -> L97
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L97
            if (r1 == 0) goto L3
        L24:
            java.lang.String r1 = r3.h     // Catch: java.lang.ClassCastException -> L97
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L97
            if (r1 == 0) goto L63
            java.lang.String r1 = r4.f()     // Catch: java.lang.ClassCastException -> L97
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L97
            if (r1 == 0) goto L3
        L36:
            com.google.android.gms.auth.api.signin.EmailSignInConfig r1 = r3.e     // Catch: java.lang.ClassCastException -> L97
            if (r1 != 0) goto L70
            com.google.android.gms.auth.api.signin.EmailSignInConfig r1 = r4.c()     // Catch: java.lang.ClassCastException -> L97
            if (r1 != 0) goto L3
        L40:
            com.google.android.gms.auth.api.signin.FacebookSignInConfig r1 = r3.g     // Catch: java.lang.ClassCastException -> L97
            if (r1 != 0) goto L7d
            com.google.android.gms.auth.api.signin.FacebookSignInConfig r1 = r4.e()     // Catch: java.lang.ClassCastException -> L97
            if (r1 != 0) goto L3
        L4a:
            com.google.android.gms.auth.api.signin.GoogleSignInConfig r1 = r3.f     // Catch: java.lang.ClassCastException -> L97
            if (r1 != 0) goto L8a
            com.google.android.gms.auth.api.signin.GoogleSignInConfig r1 = r4.d()     // Catch: java.lang.ClassCastException -> L97
            if (r1 != 0) goto L3
        L54:
            r0 = 1
            goto L3
        L56:
            java.lang.String r1 = r3.d     // Catch: java.lang.ClassCastException -> L97
            java.lang.String r2 = r4.b()     // Catch: java.lang.ClassCastException -> L97
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L97
            if (r1 == 0) goto L3
            goto L24
        L63:
            java.lang.String r1 = r3.h     // Catch: java.lang.ClassCastException -> L97
            java.lang.String r2 = r4.f()     // Catch: java.lang.ClassCastException -> L97
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L97
            if (r1 == 0) goto L3
            goto L36
        L70:
            com.google.android.gms.auth.api.signin.EmailSignInConfig r1 = r3.e     // Catch: java.lang.ClassCastException -> L97
            com.google.android.gms.auth.api.signin.EmailSignInConfig r2 = r4.c()     // Catch: java.lang.ClassCastException -> L97
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L97
            if (r1 == 0) goto L3
            goto L40
        L7d:
            com.google.android.gms.auth.api.signin.FacebookSignInConfig r1 = r3.g     // Catch: java.lang.ClassCastException -> L97
            com.google.android.gms.auth.api.signin.FacebookSignInConfig r2 = r4.e()     // Catch: java.lang.ClassCastException -> L97
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L97
            if (r1 == 0) goto L3
            goto L4a
        L8a:
            com.google.android.gms.auth.api.signin.GoogleSignInConfig r1 = r3.f     // Catch: java.lang.ClassCastException -> L97
            com.google.android.gms.auth.api.signin.GoogleSignInConfig r2 = r4.d()     // Catch: java.lang.ClassCastException -> L97
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L97
            if (r1 == 0) goto L3
            goto L54
        L97:
            r1 = move-exception
            goto L3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.SignInConfiguration.equals(java.lang.Object):boolean");
    }

    public String f() {
        return this.h;
    }

    public int hashCode() {
        return new zzc().a(this.c).a(this.d).a(this.h).a(this.e).a(this.f).a(this.g).a();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.a(this, parcel, i);
    }
}
