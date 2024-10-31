package com.google.android.gms.ads.internal.reward.client;

import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public final class RewardedVideoAdRequestParcel implements SafeParcelable {
    public static final zzh CREATOR = new zzh();

    /* renamed from: a, reason: collision with root package name */
    public final int f643a;
    public final AdRequestParcel b;
    public final String c;

    public RewardedVideoAdRequestParcel(int i, AdRequestParcel adRequestParcel, String str) {
        this.f643a = i;
        this.b = adRequestParcel;
        this.c = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.a(this, parcel, i);
    }
}
