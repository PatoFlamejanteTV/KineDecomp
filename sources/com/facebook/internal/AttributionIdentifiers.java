package com.facebook.internal;

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
import com.facebook.FacebookException;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class AttributionIdentifiers {
    private static final String ANDROID_ID_COLUMN_NAME = "androidid";
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER = "com.facebook.katana.provider.AttributionIdProvider";
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI = "com.facebook.wakizashi.provider.AttributionIdProvider";
    private static final int CONNECTION_RESULT_SUCCESS = 0;
    private static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 3600000;
    private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
    private static final String TAG = AttributionIdentifiers.class.getCanonicalName();
    private static AttributionIdentifiers recentlyFetchedIdentifiers;
    private String androidAdvertiserId;
    private String androidInstallerPackage;
    private String attributionId;
    private long fetchTime;
    private boolean limitTracking;

    private static AttributionIdentifiers getAndroidId(Context context) {
        AttributionIdentifiers androidIdViaReflection = getAndroidIdViaReflection(context);
        if (androidIdViaReflection == null) {
            AttributionIdentifiers androidIdViaService = getAndroidIdViaService(context);
            if (androidIdViaService == null) {
                return new AttributionIdentifiers();
            }
            return androidIdViaService;
        }
        return androidIdViaReflection;
    }

    private static AttributionIdentifiers getAndroidIdViaReflection(Context context) {
        Object invokeMethodQuietly;
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new FacebookException("getAndroidId cannot be called on the main thread.");
            }
            Method methodQuietly = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{Context.class});
            if (methodQuietly == null) {
                return null;
            }
            Object invokeMethodQuietly2 = Utility.invokeMethodQuietly(null, methodQuietly, context);
            if (!(invokeMethodQuietly2 instanceof Integer) || ((Integer) invokeMethodQuietly2).intValue() != 0) {
                return null;
            }
            Method methodQuietly2 = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", (Class<?>[]) new Class[]{Context.class});
            if (methodQuietly2 != null && (invokeMethodQuietly = Utility.invokeMethodQuietly(null, methodQuietly2, context)) != null) {
                Method methodQuietly3 = Utility.getMethodQuietly(invokeMethodQuietly.getClass(), "getId", (Class<?>[]) new Class[0]);
                Method methodQuietly4 = Utility.getMethodQuietly(invokeMethodQuietly.getClass(), "isLimitAdTrackingEnabled", (Class<?>[]) new Class[0]);
                if (methodQuietly3 == null || methodQuietly4 == null) {
                    return null;
                }
                AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                attributionIdentifiers.androidAdvertiserId = (String) Utility.invokeMethodQuietly(invokeMethodQuietly, methodQuietly3, new Object[0]);
                attributionIdentifiers.limitTracking = ((Boolean) Utility.invokeMethodQuietly(invokeMethodQuietly, methodQuietly4, new Object[0])).booleanValue();
                return attributionIdentifiers;
            }
            return null;
        } catch (Exception e) {
            Utility.logd("android_id", e);
            return null;
        }
    }

    private static AttributionIdentifiers getAndroidIdViaService(Context context) {
        b bVar = new b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        try {
            if (context.bindService(intent, bVar, 1)) {
                a aVar = new a(bVar.a());
                AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                attributionIdentifiers.androidAdvertiserId = aVar.a();
                attributionIdentifiers.limitTracking = aVar.b();
                return attributionIdentifiers;
            }
        } catch (Exception e) {
            Utility.logd("android_id", e);
        } finally {
            context.unbindService(bVar);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.internal.AttributionIdentifiers getAttributionIdentifiers(android.content.Context r8) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.AttributionIdentifiers.getAttributionIdentifiers(android.content.Context):com.facebook.internal.AttributionIdentifiers");
    }

    private static AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers attributionIdentifiers) {
        attributionIdentifiers.fetchTime = System.currentTimeMillis();
        recentlyFetchedIdentifiers = attributionIdentifiers;
        return attributionIdentifiers;
    }

    public String getAttributionId() {
        return this.attributionId;
    }

    public String getAndroidAdvertiserId() {
        return this.androidAdvertiserId;
    }

    public String getAndroidInstallerPackage() {
        return this.androidInstallerPackage;
    }

    public boolean isTrackingLimited() {
        return this.limitTracking;
    }

    private static String getInstallerPackageName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            return packageManager.getInstallerPackageName(context.getPackageName());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        private AtomicBoolean f268a;
        private final BlockingQueue<IBinder> b;

        private b() {
            this.f268a = new AtomicBoolean(false);
            this.b = new LinkedBlockingDeque();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        public IBinder a() throws InterruptedException {
            if (this.f268a.compareAndSet(true, true)) {
                throw new IllegalStateException("Binder already consumed");
            }
            return this.b.take();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a implements IInterface {

        /* renamed from: a, reason: collision with root package name */
        private IBinder f267a;

        a(IBinder iBinder) {
            this.f267a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f267a;
        }

        public String a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f267a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean b() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.f267a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
