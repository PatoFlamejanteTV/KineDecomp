package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public class AccountChangeEvent implements SafeParcelable {
    public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    final int f777a;
    final long b;
    final String c;
    final int d;
    final int e;
    final String f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccountChangeEvent(int i, long j, String str, int i2, int i3, String str2) {
        this.f777a = i;
        this.b = j;
        this.c = (String) zzx.a(str);
        this.d = i2;
        this.e = i3;
        this.f = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        return this.f777a == accountChangeEvent.f777a && this.b == accountChangeEvent.b && zzw.a(this.c, accountChangeEvent.c) && this.d == accountChangeEvent.d && this.e == accountChangeEvent.e && zzw.a(this.f, accountChangeEvent.f);
    }

    public int hashCode() {
        return zzw.a(Integer.valueOf(this.f777a), Long.valueOf(this.b), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e), this.f);
    }

    public String toString() {
        String str = "UNKNOWN";
        switch (this.d) {
            case 1:
                str = "ADDED";
                break;
            case 2:
                str = "REMOVED";
                break;
            case 3:
                str = "RENAMED_FROM";
                break;
            case 4:
                str = "RENAMED_TO";
                break;
        }
        return "AccountChangeEvent {accountName = " + this.c + ", changeType = " + str + ", changeData = " + this.f + ", eventIndex = " + this.e + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
