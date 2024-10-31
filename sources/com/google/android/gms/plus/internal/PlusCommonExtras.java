package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public class PlusCommonExtras implements SafeParcelable {
    public static final zzf CREATOR = new zzf();

    /* renamed from: a, reason: collision with root package name */
    private final int f2160a;
    private String b;
    private String c;

    public PlusCommonExtras() {
        this.f2160a = 1;
        this.b = "";
        this.c = "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlusCommonExtras(int i, String str, String str2) {
        this.f2160a = i;
        this.b = str;
        this.c = str2;
    }

    public int a() {
        return this.f2160a;
    }

    public void a(Bundle bundle) {
        bundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", com.google.android.gms.common.internal.safeparcel.zzc.a(this));
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusCommonExtras)) {
            return false;
        }
        PlusCommonExtras plusCommonExtras = (PlusCommonExtras) obj;
        return this.f2160a == plusCommonExtras.f2160a && zzw.a(this.b, plusCommonExtras.b) && zzw.a(this.c, plusCommonExtras.c);
    }

    public int hashCode() {
        return zzw.a(Integer.valueOf(this.f2160a), this.b, this.c);
    }

    public String toString() {
        return zzw.a(this).a("versionCode", Integer.valueOf(this.f2160a)).a("Gpsrc", this.b).a("ClientCallingPackage", this.c).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.a(this, parcel, i);
    }
}
