package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzdr;

/* loaded from: classes2.dex */
public class GithubAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<GithubAuthCredential> CREATOR = new zzt();

    /* renamed from: a */
    private String f16400a;

    @SafeParcelable.Constructor
    public GithubAuthCredential(@SafeParcelable.Param(id = 1) String str) {
        Preconditions.b(str);
        this.f16400a = str;
    }

    public static zzdr a(GithubAuthCredential githubAuthCredential, String str) {
        Preconditions.a(githubAuthCredential);
        return new zzdr(null, githubAuthCredential.f16400a, githubAuthCredential.getProvider(), null, null, null, str, null);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "github.com";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f16400a, false);
        SafeParcelWriter.a(parcel, a2);
    }
}
