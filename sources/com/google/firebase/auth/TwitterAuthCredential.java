package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzdr;

/* loaded from: classes2.dex */
public class TwitterAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<TwitterAuthCredential> CREATOR = new zzy();

    /* renamed from: a */
    private String f16412a;

    /* renamed from: b */
    private String f16413b;

    @SafeParcelable.Constructor
    public TwitterAuthCredential(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2) {
        Preconditions.b(str);
        this.f16412a = str;
        Preconditions.b(str2);
        this.f16413b = str2;
    }

    public static zzdr a(TwitterAuthCredential twitterAuthCredential, String str) {
        Preconditions.a(twitterAuthCredential);
        return new zzdr(null, twitterAuthCredential.f16412a, twitterAuthCredential.getProvider(), null, twitterAuthCredential.f16413b, null, str, null);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "twitter.com";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f16412a, false);
        SafeParcelWriter.a(parcel, 2, this.f16413b, false);
        SafeParcelWriter.a(parcel, a2);
    }
}
