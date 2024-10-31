package com.xiaomi.gamecenter.sdk;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes3.dex */
public class b implements IServiceCallback {

    /* renamed from: a */
    private IBinder f26585a;

    public b(IBinder iBinder) {
        this.f26585a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f26585a;
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
            this.f26585a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
