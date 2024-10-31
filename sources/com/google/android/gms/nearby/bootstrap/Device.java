package com.google.android.gms.nearby.bootstrap;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public class Device implements SafeParcelable {
    public static final Parcelable.Creator<Device> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    final int f2083a;
    private final String b;
    private final String c;
    private final String d;
    private final byte e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Device(int i, String str, String str2, String str3, byte b) {
        this.f2083a = i;
        this.b = zzx.a(str);
        this.c = (String) zzx.a(str2);
        this.d = (String) zzx.a(str3);
        zzx.b(b <= 4, "Unknown device type");
        this.e = b;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public byte d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.b + ": " + this.c + "[" + ((int) this.e) + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
