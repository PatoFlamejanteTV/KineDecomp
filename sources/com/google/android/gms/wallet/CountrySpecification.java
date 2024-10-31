package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
/* loaded from: classes.dex */
public class CountrySpecification implements SafeParcelable {
    public static final Parcelable.Creator<CountrySpecification> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    String f2279a;
    private final int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CountrySpecification(int i, String str) {
        this.b = i;
        this.f2279a = str;
    }

    public int a() {
        return this.b;
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
