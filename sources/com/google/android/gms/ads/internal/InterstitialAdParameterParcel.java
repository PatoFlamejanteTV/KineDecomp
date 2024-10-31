package com.google.android.gms.ads.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public final class InterstitialAdParameterParcel implements SafeParcelable {
    public static final zzl CREATOR = new zzl();

    /* renamed from: a, reason: collision with root package name */
    public final int f529a;
    public final boolean b;
    public final boolean c;
    public final String d;
    public final boolean e;
    public final float f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InterstitialAdParameterParcel(int i, boolean z, boolean z2, String str, boolean z3, float f) {
        this.f529a = i;
        this.b = z;
        this.c = z2;
        this.d = str;
        this.e = z3;
        this.f = f;
    }

    public InterstitialAdParameterParcel(boolean z, boolean z2, String str, boolean z3, float f) {
        this(2, z, z2, str, z3, f);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzl.a(this, parcel, i);
    }
}
