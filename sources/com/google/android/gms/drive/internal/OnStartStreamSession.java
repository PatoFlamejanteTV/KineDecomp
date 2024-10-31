package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class OnStartStreamSession implements SafeParcelable {
    public static final Parcelable.Creator<OnStartStreamSession> CREATOR = new zzbi();

    /* renamed from: a, reason: collision with root package name */
    final int f1112a;
    final ParcelFileDescriptor b;
    final IBinder c;
    final String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnStartStreamSession(int i, ParcelFileDescriptor parcelFileDescriptor, IBinder iBinder, String str) {
        this.f1112a = i;
        this.b = parcelFileDescriptor;
        this.c = iBinder;
        this.d = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbi.a(this, parcel, i | 1);
    }
}
