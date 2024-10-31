package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class Feature implements SafeParcelable {
    public static final zze CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    final int f759a;
    public final int b;
    final Bundle c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Feature(int i, int i2, Bundle bundle) {
        this.f759a = i;
        this.b = i2;
        this.c = bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zze zzeVar = CREATOR;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze zzeVar = CREATOR;
        zze.a(this, parcel, i);
    }
}
