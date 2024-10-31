package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzat;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.internal.zzse;

/* loaded from: classes2.dex */
public class DriveId implements SafeParcelable {
    public static final Parcelable.Creator<DriveId> CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    final int f1055a;
    final String b;
    final long c;
    final long d;
    final int e;
    private volatile String f;
    private volatile String g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DriveId(int i, String str, long j, long j2, int i2) {
        this.f = null;
        this.g = null;
        this.f1055a = i;
        this.b = str;
        zzx.b(!"".equals(str));
        zzx.b((str == null && j == -1) ? false : true);
        this.c = j;
        this.d = j2;
        this.e = i2;
    }

    public DriveId(String str, long j, long j2, int i) {
        this(1, str, j, j2, i);
    }

    public final String a() {
        if (this.f == null) {
            this.f = "DriveId:" + Base64.encodeToString(b(), 10);
        }
        return this.f;
    }

    final byte[] b() {
        zzat zzatVar = new zzat();
        zzatVar.f1136a = this.f1055a;
        zzatVar.b = this.b == null ? "" : this.b;
        zzatVar.c = this.c;
        zzatVar.d = this.d;
        zzatVar.e = this.e;
        return zzse.zzf(zzatVar);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DriveId)) {
            return false;
        }
        DriveId driveId = (DriveId) obj;
        if (driveId.d != this.d) {
            zzz.a("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
            return false;
        }
        if (driveId.c == -1 && this.c == -1) {
            return driveId.b.equals(this.b);
        }
        if (this.b == null || driveId.b == null) {
            return driveId.c == this.c;
        }
        if (driveId.c != this.c) {
            return false;
        }
        if (driveId.b.equals(this.b)) {
            return true;
        }
        zzz.a("DriveId", "Unexpected unequal resourceId for same DriveId object.");
        return false;
    }

    public int hashCode() {
        return this.c == -1 ? this.b.hashCode() : (String.valueOf(this.d) + String.valueOf(this.c)).hashCode();
    }

    public String toString() {
        return a();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.a(this, parcel, i);
    }
}
