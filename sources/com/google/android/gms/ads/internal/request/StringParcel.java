package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class StringParcel implements SafeParcelable {
    public static final Parcelable.Creator<StringParcel> CREATOR = new zzn();

    /* renamed from: a, reason: collision with root package name */
    final int f625a;
    String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringParcel(int i, String str) {
        this.f625a = i;
        this.b = str;
    }

    public StringParcel(String str) {
        this.f625a = 1;
        this.b = str;
    }

    public String a() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzn.a(this, parcel, i);
    }
}
