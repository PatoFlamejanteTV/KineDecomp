package io.fabric.sdk.android.services.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdvertisingInfoServiceStrategy.java */
/* loaded from: classes3.dex */
public class g implements h {

    /* renamed from: a, reason: collision with root package name */
    private final Context f26892a;

    /* compiled from: AdvertisingInfoServiceStrategy.java */
    /* loaded from: classes3.dex */
    private static final class a implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        private boolean f26893a;

        /* renamed from: b, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f26894b;

        private a() {
            this.f26893a = false;
            this.f26894b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() {
            if (this.f26893a) {
                io.fabric.sdk.android.f.f().e("Fabric", "getBinder already called");
            }
            this.f26893a = true;
            try {
                return this.f26894b.poll(200L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                return null;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f26894b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.f26894b.clear();
        }
    }

    /* compiled from: AdvertisingInfoServiceStrategy.java */
    /* loaded from: classes3.dex */
    private static final class b implements IInterface {

        /* renamed from: a, reason: collision with root package name */
        private final IBinder f26895a;

        public b(IBinder iBinder) {
            this.f26895a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f26895a;
        }

        public String getId() throws RemoteException {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.f26895a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readString();
                } catch (Exception unused) {
                    io.fabric.sdk.android.f.f().d("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
                    obtain2.recycle();
                    obtain.recycle();
                    str = null;
                }
                return str;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean v() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            boolean z = false;
            try {
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain.writeInt(1);
                    this.f26895a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                } catch (Exception unused) {
                    io.fabric.sdk.android.f.f().d("Fabric", "Could not get parcel from Google Play Service to capture Advertising limitAdTracking");
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public g(Context context) {
        this.f26892a = context.getApplicationContext();
    }

    @Override // io.fabric.sdk.android.services.common.h
    public io.fabric.sdk.android.services.common.b a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            io.fabric.sdk.android.f.f().d("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        try {
            this.f26892a.getPackageManager().getPackageInfo("com.android.vending", 0);
            a aVar = new a();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (this.f26892a.bindService(intent, aVar, 1)) {
                    try {
                        try {
                            b bVar = new b(aVar.a());
                            return new io.fabric.sdk.android.services.common.b(bVar.getId(), bVar.v());
                        } finally {
                            this.f26892a.unbindService(aVar);
                        }
                    } catch (Exception e2) {
                        io.fabric.sdk.android.f.f().b("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", e2);
                        this.f26892a.unbindService(aVar);
                    }
                } else {
                    io.fabric.sdk.android.f.f().d("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
                }
            } catch (Throwable th) {
                io.fabric.sdk.android.f.f().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", th);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            io.fabric.sdk.android.f.f().d("Fabric", "Unable to find Google Play Services package name");
            return null;
        } catch (Exception e3) {
            io.fabric.sdk.android.f.f().a("Fabric", "Unable to determine if Google Play Services is available", e3);
            return null;
        }
    }
}
