package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new zzd();

    /* renamed from: a */
    private final boolean f10634a;

    /* renamed from: b */
    private final long f10635b;

    /* renamed from: c */
    private final long f10636c;

    @SafeParcelable.Constructor
    public zzc(@SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 2) long j2) {
        this.f10634a = z;
        this.f10635b = j;
        this.f10636c = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzc) {
            zzc zzcVar = (zzc) obj;
            if (this.f10634a == zzcVar.f10634a && this.f10635b == zzcVar.f10635b && this.f10636c == zzcVar.f10636c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.a(Boolean.valueOf(this.f10634a), Long.valueOf(this.f10635b), Long.valueOf(this.f10636c));
    }

    public final String toString() {
        return "CollectForDebugParcelable[skipPersistentStorage: " + this.f10634a + ",collectForDebugStartTimeMillis: " + this.f10635b + ",collectForDebugExpiryTimeMillis: " + this.f10636c + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f10634a);
        SafeParcelWriter.a(parcel, 2, this.f10636c);
        SafeParcelWriter.a(parcel, 3, this.f10635b);
        SafeParcelWriter.a(parcel, a2);
    }
}
