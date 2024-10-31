package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzdr;

/* loaded from: classes2.dex */
public class FacebookAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<FacebookAuthCredential> CREATOR = new zzg();

    /* renamed from: a */
    private final String f16387a;

    @SafeParcelable.Constructor
    public FacebookAuthCredential(@SafeParcelable.Param(id = 1) String str) {
        Preconditions.b(str);
        this.f16387a = str;
    }

    public static zzdr a(FacebookAuthCredential facebookAuthCredential, String str) {
        Preconditions.a(facebookAuthCredential);
        return new zzdr(null, facebookAuthCredential.f16387a, facebookAuthCredential.getProvider(), null, null, null, str, null);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "facebook.com";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f16387a, false);
        SafeParcelWriter.a(parcel, a2);
    }
}
