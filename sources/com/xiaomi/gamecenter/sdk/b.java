package com.xiaomi.gamecenter.sdk;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements IServiceCallback {

    /* renamed from: a, reason: collision with root package name */
    private IBinder f4888a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(IBinder iBinder) {
        this.f4888a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f4888a;
    }

    @Override // com.xiaomi.gamecenter.sdk.IServiceCallback
    public void startActivity(String str, String str2, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IServiceCallback");
            obtain.writeString(str);
            obtain.writeString(str2);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4888a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
