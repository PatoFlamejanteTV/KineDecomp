package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzdr;

/* loaded from: classes2.dex */
public class GoogleAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<GoogleAuthCredential> CREATOR = new zzu();

    /* renamed from: a */
    private final String f16401a;

    /* renamed from: b */
    private final String f16402b;

    @SafeParcelable.Constructor
    public GoogleAuthCredential(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2) {
        if (str == null && str2 == null) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        e(str, "idToken");
        this.f16401a = str;
        e(str2, "accessToken");
        this.f16402b = str2;
    }

    public static zzdr a(GoogleAuthCredential googleAuthCredential, String str) {
        Preconditions.a(googleAuthCredential);
        return new zzdr(googleAuthCredential.f16401a, googleAuthCredential.f16402b, googleAuthCredential.getProvider(), null, null, null, str, null);
    }

    private static String e(String str, String str2) {
        if (str == null || !TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(str2).concat(" must not be empty"));
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "google.com";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f16401a, false);
        SafeParcelWriter.a(parcel, 2, this.f16402b, false);
        SafeParcelWriter.a(parcel, a2);
    }
}
