package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.zzb;

/* loaded from: classes.dex */
public class AmsEntityUpdateParcelable implements SafeParcelable, zzb {
    public static final Parcelable.Creator<AmsEntityUpdateParcelable> CREATOR = new zzf();

    /* renamed from: a, reason: collision with root package name */
    final int f2332a;
    private byte b;
    private final byte c;
    private final String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AmsEntityUpdateParcelable(int i, byte b, byte b2, String str) {
        this.b = b;
        this.f2332a = i;
        this.c = b2;
        this.d = str;
    }

    public byte a() {
        return this.b;
    }

    public byte b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AmsEntityUpdateParcelable amsEntityUpdateParcelable = (AmsEntityUpdateParcelable) obj;
        return this.b == amsEntityUpdateParcelable.b && this.f2332a == amsEntityUpdateParcelable.f2332a && this.c == amsEntityUpdateParcelable.c && this.d.equals(amsEntityUpdateParcelable.d);
    }

    public int hashCode() {
        return (((((this.f2332a * 31) + this.b) * 31) + this.c) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "AmsEntityUpdateParcelable{mVersionCode=" + this.f2332a + ", mEntityId=" + ((int) this.b) + ", mAttributeId=" + ((int) this.c) + ", mValue='" + this.d + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.a(this, parcel, i);
    }
}
