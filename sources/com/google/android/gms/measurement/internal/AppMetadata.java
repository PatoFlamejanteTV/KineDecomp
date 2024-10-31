package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public class AppMetadata implements SafeParcelable {
    public static final zzb CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    public final int f2018a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final long f;
    public final long g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppMetadata(int i, String str, String str2, String str3, String str4, long j, long j2) {
        this.f2018a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = j;
        this.g = j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppMetadata(String str, String str2, String str3, String str4, long j, long j2) {
        zzx.a(str);
        this.f2018a = 1;
        this.b = str;
        this.c = TextUtils.isEmpty(str2) ? null : str2;
        this.d = str3;
        this.e = str4;
        this.f = j;
        this.g = j2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
