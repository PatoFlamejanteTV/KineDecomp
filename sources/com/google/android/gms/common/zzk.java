package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new zzl();

    /* renamed from: a */
    private final String f11310a;

    /* renamed from: b */
    @Nullable
    private final c f11311b;

    /* renamed from: c */
    private final boolean f11312c;

    /* renamed from: d */
    private final boolean f11313d;

    @SafeParcelable.Constructor
    public zzk(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) @Nullable IBinder iBinder, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) boolean z2) {
        this.f11310a = str;
        this.f11311b = a(iBinder);
        this.f11312c = z;
        this.f11313d = z2;
    }

    @Nullable
    private static c a(@Nullable IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            IObjectWrapper u = zzj.a(iBinder).u();
            byte[] bArr = u == null ? null : (byte[]) ObjectWrapper.a(u);
            if (bArr != null) {
                return new d(bArr);
            }
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
            return null;
        } catch (RemoteException e2) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e2);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        IBinder asBinder;
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f11310a, false);
        c cVar = this.f11311b;
        if (cVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            asBinder = null;
        } else {
            asBinder = cVar.asBinder();
        }
        SafeParcelWriter.a(parcel, 2, asBinder, false);
        SafeParcelWriter.a(parcel, 3, this.f11312c);
        SafeParcelWriter.a(parcel, 4, this.f11313d);
        SafeParcelWriter.a(parcel, a2);
    }

    public zzk(String str, @Nullable c cVar, boolean z, boolean z2) {
        this.f11310a = str;
        this.f11311b = cVar;
        this.f11312c = z;
        this.f11313d = z2;
    }
}
