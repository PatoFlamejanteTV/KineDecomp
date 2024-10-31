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
    private static final String TAG = "com.facebook.internal.AttributionIdentifiers";
    private static AttributionIdentifiers recentlyFetchedIdentifiers;
    private String androidAdvertiserId;
    private String androidInstallerPackage;
    private String attributionId;
    private long fetchTime;
    private boolean limitTracking;

    /* loaded from: classes.dex */
    public static final class a implements IInterface {

        /* renamed from: a */
        private IBinder f9266a;

        a(IBinder iBinder) {
            this.f9266a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f9266a;
        }

        public String v() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f9266a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean w() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.f9266a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    private static AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers attributionIdentifiers) {
        attributionIdentifiers.fetchTime = System.currentTimeMillis();
        recentlyFetchedIdentifiers = attributionIdentifiers;
        return attributionIdentifiers;
    }

    private static AttributionIdentifiers getAndroidId(Context context) {
        AttributionIdentifiers androidIdViaReflection = getAndroidIdViaReflection(context);
        if (androidIdViaReflection != null) {
            return androidIdViaReflection;
        }
        AttributionIdentifiers androidIdViaService = getAndroidIdViaService(context);
        return androidIdViaService == null ? new AttributionIdentifiers() : androidIdViaService;
    }

    private static AttributionIdentifiers getAndroidIdViaReflection(Context context) {
        Method methodQuietly;
        Object invokeMethodQuietly;
        try {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                Method methodQuietly2 = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{Context.class});
                if (methodQuietly2 == null) {
                    return null;
                }
                Object invokeMethodQuietly2 = Utility.invokeMethodQuietly(null, methodQuietly2, context);
                if (!(invokeMethodQuietly2 instanceof Integer) || ((Integer) invokeMethodQuietly2).intValue() != 0 || (methodQuietly = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", (Class<?>[]) new Class[]{Context.class})) == null || (invokeMethodQuietly = Utility.invokeMethodQuietly(null, methodQuietly, context)) == null) {
                    return null;
                }
                Method methodQuietly3 = Utility.getMethodQuietly(invokeMethodQuietly.getClass(), "getId", (Class<?>[]) new Class[0]);
                Method methodQuietly4 = Utility.getMethodQuietly(invokeMethodQuietly.getClass(), "isLimitAdTrackingEnabled", (Class<?>[]) new Class[0]);
                if (methodQuietly3 != null && methodQuietly4 != null) {
                    AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                    attributionIdentifiers.androidAdvertiserId = (String) Utility.invokeMethodQuietly(invokeMethodQuietly, methodQuietly3, new Object[0]);
                    attributionIdentifiers.limitTracking = ((Boolean) Utility.invokeMethodQuietly(invokeMethodQuietly, methodQuietly4, new Object[0])).booleanValue();
                    return attributionIdentifiers;
                }
                return null;
            }
            throw new FacebookException("getAndroidId cannot be called on the main thread.");
        } catch (Exception e2) {
            Utility.logd("android_id", e2);
            return null;
        }
    }

    private static AttributionIdentifiers getAndroidIdViaService(Context context) {
        b bVar = new b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, bVar, 1)) {
            try {
                a aVar = new a(bVar.a());
                AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                attributionIdentifiers.androidAdvertiserId = aVar.v();
                attributionIdentifiers.limitTracking = aVar.w();
                return attributionIdentifiers;
            } catch (Exception e2) {
                Utility.logd("android_id", e2);
            } finally {
                context.unbindService(bVar);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006b A[Catch: all -> 0x00ce, Exception -> 0x00d0, TryCatch #5 {Exception -> 0x00d0, all -> 0x00ce, blocks: (B:12:0x0032, B:14:0x0049, B:16:0x0065, B:18:0x006b, B:20:0x006f, B:22:0x0073, B:57:0x0051, B:59:0x005d), top: B:11:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006f A[Catch: all -> 0x00ce, Exception -> 0x00d0, TryCatch #5 {Exception -> 0x00d0, all -> 0x00ce, blocks: (B:12:0x0032, B:14:0x0049, B:16:0x0065, B:18:0x006b, B:20:0x006f, B:22:0x0073, B:57:0x0051, B:59:0x005d), top: B:11:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0073 A[Catch: all -> 0x00ce, Exception -> 0x00d0, TRY_LEAVE, TryCatch #5 {Exception -> 0x00d0, all -> 0x00ce, blocks: (B:12:0x0032, B:14:0x0049, B:16:0x0065, B:18:0x006b, B:20:0x006f, B:22:0x0073, B:57:0x0051, B:59:0x005d), top: B:11:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.internal.AttributionIdentifiers getAttributionIdentifiers(android.content.Context r13) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.AttributionIdentifiers.getAttributionIdentifiers(android.content.Context):com.facebook.internal.AttributionIdentifiers");
    }

    private static String getInstallerPackageName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            return packageManager.getInstallerPackageName(context.getPackageName());
        }
        return null;
    }

    public String getAndroidAdvertiserId() {
        return this.androidAdvertiserId;
    }

    public String getAndroidInstallerPackage() {
        return this.androidInstallerPackage;
    }

    public String getAttributionId() {
        return this.attributionId;
    }

    public boolean isTrackingLimited() {
        return this.limitTracking;
    }

    /* loaded from: classes.dex */
    public static final class b implements ServiceConnection {

        /* renamed from: a */
        private AtomicBoolean f9267a;

        /* renamed from: b */
        private final BlockingQueue<IBinder> f9268b;

        private b() {
            this.f9267a = new AtomicBoolean(false);
            this.f9268b = new LinkedBlockingDeque();
        }

        public IBinder a() throws InterruptedException {
            if (!this.f9267a.compareAndSet(true, true)) {
                return this.f9268b.take();
            }
            throw new IllegalStateException("Binder already consumed");
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                try {
                    this.f9268b.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        /* synthetic */ b(C0731a c0731a) {
            this();
        }
    }
}
