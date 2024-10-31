package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public abstract class WriteAwareParcelable implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    private volatile transient boolean f1066a = false;

    protected abstract void a(Parcel parcel, int i);

    public final boolean a_() {
        return this.f1066a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzx.a(!a_());
        this.f1066a = true;
        a(parcel, i);
    }
}
