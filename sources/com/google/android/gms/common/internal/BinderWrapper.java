package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;

@KeepForSdk
@KeepName
/* loaded from: classes.dex */
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new i();

    /* renamed from: a */
    private IBinder f11061a;

    public BinderWrapper() {
        this.f11061a = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f11061a);
    }

    private BinderWrapper(Parcel parcel) {
        this.f11061a = null;
        this.f11061a = parcel.readStrongBinder();
    }

    public /* synthetic */ BinderWrapper(Parcel parcel, i iVar) {
        this(parcel);
    }
}
