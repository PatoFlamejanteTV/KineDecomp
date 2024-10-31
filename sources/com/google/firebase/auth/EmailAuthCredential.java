package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.logging.Logger;

/* loaded from: classes2.dex */
public class EmailAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<EmailAuthCredential> CREATOR = new zzf();

    /* renamed from: a */
    private static final Logger f16381a = new Logger("EmailAuthCredential", new String[0]);

    /* renamed from: b */
    private String f16382b;

    /* renamed from: c */
    private String f16383c;

    /* renamed from: d */
    private final String f16384d;

    /* renamed from: e */
    private String f16385e;

    /* renamed from: f */
    private boolean f16386f;

    @SafeParcelable.Constructor
    public EmailAuthCredential(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3, @SafeParcelable.Param(id = 4) String str4, @SafeParcelable.Param(id = 5) boolean z) {
        Preconditions.b(str);
        this.f16382b = str;
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
        }
        this.f16383c = str2;
        this.f16384d = str3;
        this.f16385e = str4;
        this.f16386f = z;
    }

    public final String O() {
        return this.f16384d;
    }

    public final boolean P() {
        return !TextUtils.isEmpty(this.f16384d);
    }

    public final EmailAuthCredential a(FirebaseUser firebaseUser) {
        this.f16385e = firebaseUser.Y();
        this.f16386f = true;
        return this;
    }

    public final String getEmail() {
        return this.f16382b;
    }

    public final String getPassword() {
        return this.f16383c;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return AuthUI.EMAIL_PROVIDER;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f16382b, false);
        SafeParcelWriter.a(parcel, 2, this.f16383c, false);
        SafeParcelWriter.a(parcel, 3, this.f16384d, false);
        SafeParcelWriter.a(parcel, 4, this.f16385e, false);
        SafeParcelWriter.a(parcel, 5, this.f16386f);
        SafeParcelWriter.a(parcel, a2);
    }

    public String a() {
        return !TextUtils.isEmpty(this.f16383c) ? AuthUI.EMAIL_PROVIDER : "emailLink";
    }
}
