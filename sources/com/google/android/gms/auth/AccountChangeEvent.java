package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class AccountChangeEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zza();

    /* renamed from: a */
    private final int f10389a;

    /* renamed from: b */
    private final long f10390b;

    /* renamed from: c */
    private final String f10391c;

    /* renamed from: d */
    private final int f10392d;

    /* renamed from: e */
    private final int f10393e;

    /* renamed from: f */
    private final String f10394f;

    @SafeParcelable.Constructor
    public AccountChangeEvent(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) long j, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) int i3, @SafeParcelable.Param(id = 6) String str2) {
        this.f10389a = i;
        this.f10390b = j;
        Preconditions.a(str);
        this.f10391c = str;
        this.f10392d = i2;
        this.f10393e = i3;
        this.f10394f = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AccountChangeEvent) {
            AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
            if (this.f10389a == accountChangeEvent.f10389a && this.f10390b == accountChangeEvent.f10390b && Objects.a(this.f10391c, accountChangeEvent.f10391c) && this.f10392d == accountChangeEvent.f10392d && this.f10393e == accountChangeEvent.f10393e && Objects.a(this.f10394f, accountChangeEvent.f10394f)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.a(Integer.valueOf(this.f10389a), Long.valueOf(this.f10390b), this.f10391c, Integer.valueOf(this.f10392d), Integer.valueOf(this.f10393e), this.f10394f);
    }

    public String toString() {
        int i = this.f10392d;
        String str = i != 1 ? i != 2 ? i != 3 ? i != 4 ? "UNKNOWN" : "RENAMED_TO" : "RENAMED_FROM" : "REMOVED" : "ADDED";
        String str2 = this.f10391c;
        String str3 = this.f10394f;
        int i2 = this.f10393e;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 91 + str.length() + String.valueOf(str3).length());
        sb.append("AccountChangeEvent {accountName = ");
        sb.append(str2);
        sb.append(", changeType = ");
        sb.append(str);
        sb.append(", changeData = ");
        sb.append(str3);
        sb.append(", eventIndex = ");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f10389a);
        SafeParcelWriter.a(parcel, 2, this.f10390b);
        SafeParcelWriter.a(parcel, 3, this.f10391c, false);
        SafeParcelWriter.a(parcel, 4, this.f10392d);
        SafeParcelWriter.a(parcel, 5, this.f10393e);
        SafeParcelWriter.a(parcel, 6, this.f10394f, false);
        SafeParcelWriter.a(parcel, a2);
    }
}
