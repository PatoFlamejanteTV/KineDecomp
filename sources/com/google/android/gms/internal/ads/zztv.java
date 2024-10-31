package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.InputStream;

@zzark
/* loaded from: classes2.dex */
public final class zztv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zztv> CREATOR = new zztw();
    private ParcelFileDescriptor zzbzu;

    public zztv() {
        this(null);
    }

    private final synchronized ParcelFileDescriptor zzog() {
        return this.zzbzu;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, (Parcelable) zzog(), i, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public final synchronized boolean zzoe() {
        return this.zzbzu != null;
    }

    public final synchronized InputStream zzof() {
        if (this.zzbzu == null) {
            return null;
        }
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(this.zzbzu);
        this.zzbzu = null;
        return autoCloseInputStream;
    }

    @SafeParcelable.Constructor
    public zztv(@SafeParcelable.Param(id = 2) ParcelFileDescriptor parcelFileDescriptor) {
        this.zzbzu = parcelFileDescriptor;
    }
}
