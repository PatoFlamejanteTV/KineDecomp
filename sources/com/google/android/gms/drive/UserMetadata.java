package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class UserMetadata implements SafeParcelable {
    public static final Parcelable.Creator<UserMetadata> CREATOR = new zzk();

    /* renamed from: a, reason: collision with root package name */
    final int f1065a;
    final String b;
    final String c;
    final String d;
    final boolean e;
    final String f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UserMetadata(int i, String str, String str2, String str3, boolean z, String str4) {
        this.f1065a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = z;
        this.f = str4;
    }

    public UserMetadata(String str, String str2, String str3, boolean z, String str4) {
        this(1, str, str2, str3, z, str4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("Permission ID: '%s', Display Name: '%s', Picture URL: '%s', Authenticated User: %b, Email: '%s'", this.b, this.c, this.d, Boolean.valueOf(this.e), this.f);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.a(this, parcel, i);
    }
}
