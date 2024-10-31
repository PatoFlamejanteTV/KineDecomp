package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private IBinder f994a;

    public BinderWrapper() {
        this.f994a = null;
    }

    public BinderWrapper(IBinder iBinder) {
        this.f994a = null;
        this.f994a = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        this.f994a = null;
        this.f994a = parcel.readStrongBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ BinderWrapper(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f994a);
    }
}
