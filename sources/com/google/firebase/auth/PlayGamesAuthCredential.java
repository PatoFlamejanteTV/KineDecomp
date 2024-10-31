package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzdr;

/* loaded from: classes2.dex */
public class PlayGamesAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<PlayGamesAuthCredential> CREATOR = new zzx();

    /* renamed from: a */
    private final String f16411a;

    @SafeParcelable.Constructor
    public PlayGamesAuthCredential(@SafeParcelable.Param(id = 1) String str) {
        Preconditions.b(str);
        this.f16411a = str;
    }

    public static zzdr a(PlayGamesAuthCredential playGamesAuthCredential, String str) {
        Preconditions.a(playGamesAuthCredential);
        return new zzdr(null, null, playGamesAuthCredential.getProvider(), null, null, playGamesAuthCredential.f16411a, str, null);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "playgames.google.com";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f16411a, false);
        SafeParcelWriter.a(parcel, a2);
    }
}
