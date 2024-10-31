package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzas;
import com.google.android.gms.internal.zzse;

/* loaded from: classes2.dex */
public class ChangeSequenceNumber implements SafeParcelable {
    public static final Parcelable.Creator<ChangeSequenceNumber> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    final int f1049a;
    final long b;
    final long c;
    final long d;
    private volatile String e = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChangeSequenceNumber(int i, long j, long j2, long j3) {
        zzx.b(j != -1);
        zzx.b(j2 != -1);
        zzx.b(j3 != -1);
        this.f1049a = i;
        this.b = j;
        this.c = j2;
        this.d = j3;
    }

    public final String a() {
        if (this.e == null) {
            this.e = "ChangeSequenceNumber:" + Base64.encodeToString(b(), 10);
        }
        return this.e;
    }

    final byte[] b() {
        zzas zzasVar = new zzas();
        zzasVar.f1135a = this.f1049a;
        zzasVar.b = this.b;
        zzasVar.c = this.c;
        zzasVar.d = this.d;
        return zzse.zzf(zzasVar);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ChangeSequenceNumber)) {
            return false;
        }
        ChangeSequenceNumber changeSequenceNumber = (ChangeSequenceNumber) obj;
        return changeSequenceNumber.c == this.c && changeSequenceNumber.d == this.d && changeSequenceNumber.b == this.b;
    }

    public int hashCode() {
        return (String.valueOf(this.b) + String.valueOf(this.c) + String.valueOf(this.d)).hashCode();
    }

    public String toString() {
        return a();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
