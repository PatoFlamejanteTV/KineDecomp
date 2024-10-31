package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class LoyaltyPoints implements SafeParcelable {
    public static final Parcelable.Creator<LoyaltyPoints> CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    String f2318a;
    LoyaltyPointsBalance b;
    String c;
    TimeInterval d;
    private final int e;

    LoyaltyPoints() {
        this.e = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoyaltyPoints(int i, String str, LoyaltyPointsBalance loyaltyPointsBalance, String str2, TimeInterval timeInterval) {
        this.e = i;
        this.f2318a = str;
        this.b = loyaltyPointsBalance;
        this.c = str2;
        this.d = timeInterval;
    }

    public int a() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.a(this, parcel, i);
    }
}
