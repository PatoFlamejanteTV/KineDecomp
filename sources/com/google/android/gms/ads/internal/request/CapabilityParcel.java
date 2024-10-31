package com.google.android.gms.ads.internal.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class CapabilityParcel implements SafeParcelable {
    public static final Parcelable.Creator<CapabilityParcel> CREATOR = new zzi();

    /* renamed from: a, reason: collision with root package name */
    public final int f623a;
    public final boolean b;
    public final boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CapabilityParcel(int i, boolean z, boolean z2) {
        this.f623a = i;
        this.b = z;
        this.c = z2;
    }

    public CapabilityParcel(boolean z, boolean z2) {
        this(1, z, z2);
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("iap_supported", this.b);
        bundle.putBoolean("default_iap_supported", this.c);
        return bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.a(this, parcel, i);
    }
}
