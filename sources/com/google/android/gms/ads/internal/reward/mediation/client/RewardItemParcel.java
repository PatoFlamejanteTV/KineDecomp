package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public final class RewardItemParcel implements SafeParcelable {
    public static final zzc CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    public final int f650a;
    public final String b;
    public final int c;

    public RewardItemParcel(int i, String str, int i2) {
        this.f650a = i;
        this.b = str;
        this.c = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.a(this, parcel, i);
    }
}
