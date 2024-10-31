package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class GoogleNowAuthState implements SafeParcelable {
    public static final Parcelable.Creator<GoogleNowAuthState> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    final int f2190a;
    String b;
    String c;
    long d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleNowAuthState(int i, String str, String str2, long j) {
        this.f2190a = i;
        this.b = str;
        this.c = str2;
        this.d = j;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public long c() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "mAuthCode = " + this.b + "\nmAccessToken = " + this.c + "\nmNextAllowedTimeMillis = " + this.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
