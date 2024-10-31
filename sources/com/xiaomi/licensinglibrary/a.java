package com.xiaomi.licensinglibrary;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements ILicenseService {

    /* renamed from: a, reason: collision with root package name */
    private IBinder f4916a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(IBinder iBinder) {
        this.f4916a = iBinder;
    }

    @Override // com.xiaomi.licensinglibrary.ILicenseService
    public Bundle a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.licensinglibrary.ILicenseService");
            this.f4916a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.licensinglibrary.ILicenseService
    public Bundle a(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.licensinglibrary.ILicenseService");
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4916a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.licensinglibrary.ILicenseService
    public void a(String str, String str2, String str3, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.licensinglibrary.ILicenseService");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            obtain.writeInt(i);
            this.f4916a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f4916a;
    }

    @Override // com.xiaomi.licensinglibrary.ILicenseService
    public Bundle b(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.licensinglibrary.ILicenseService");
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4916a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
