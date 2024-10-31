package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class LoyaltyPointsBalance implements SafeParcelable {
    public static final Parcelable.Creator<LoyaltyPointsBalance> CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    int f2319a;
    String b;
    double c;
    String d;
    long e;
    int f;
    private final int g;

    LoyaltyPointsBalance() {
        this.g = 1;
        this.f = -1;
        this.f2319a = -1;
        this.c = -1.0d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoyaltyPointsBalance(int i, int i2, String str, double d, String str2, long j, int i3) {
        this.g = i;
        this.f2319a = i2;
        this.b = str;
        this.c = d;
        this.d = str2;
        this.e = j;
        this.f = i3;
    }

    public int a() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.a(this, parcel, i);
    }
}
