package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.common.zza;
import com.google.android.gms.internal.zzav;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class AdvertisingIdClient {
    private static boolean h = false;

    /* renamed from: a, reason: collision with root package name */
    zza f526a;
    zzav b;
    boolean c;
    Object d;
    a e;
    final long f;
    private final Context g;

    /* loaded from: classes.dex */
    public static final class Info {

        /* renamed from: a, reason: collision with root package name */
        private final String f527a;
        private final boolean b;

        public Info(String str, boolean z) {
            this.f527a = str;
            this.b = z;
        }

        public String a() {
            return this.f527a;
        }

        public boolean b() {
            return this.b;
        }

        public String toString() {
            return "{" + this.f527a + "}" + this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        CountDownLatch f528a = new CountDownLatch(1);
        boolean b = false;
        private WeakReference<AdvertisingIdClient> c;
        private long d;

        public a(AdvertisingIdClient advertisingIdClient, long j) {
            this.c = new WeakReference<>(advertisingIdClient);
            this.d = j;
            start();
        }

        private void c() {
            AdvertisingIdClient advertisingIdClient = this.c.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.c();
                this.b = true;
            }
        }

        public void a() {
            this.f528a.countDown();
        }

        public boolean b() {
            return this.b;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (this.f528a.await(this.d, TimeUnit.MILLISECONDS)) {
                    return;
                }
                c();
            } catch (InterruptedException e) {
                c();
            }
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000L);
    }

    public AdvertisingIdClient(Context context, long j) {
        this.d = new Object();
        zzx.a(context);
        this.g = context;
        this.c = false;
        this.f = j;
    }

    static zza a(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            if (h) {
                Log.d("Ads", "Skipping gmscore version check");
                switch (GoogleApiAvailability.a().a(context)) {
                    case 0:
                    case 2:
                        break;
                    case 1:
                    default:
                        throw new IOException("Google Play services not available");
                }
            } else {
                try {
                    GooglePlayServicesUtil.b(context);
                } catch (GooglePlayServicesNotAvailableException th) {
                    throw new IOException(th);
                }
            }
            zza zzaVar = new zza();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (zzb.a().a(context, intent, zzaVar, 1)) {
                    return zzaVar;
                }
                throw new IOException("Connection failure");
            } finally {
                IOException iOException = new IOException(th);
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    static zzav a(Context context, zza zzaVar) throws IOException {
        try {
            return zzav.zza.zzb(zzaVar.a());
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    public static Info b(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L);
        try {
            advertisingIdClient.a(false);
            return advertisingIdClient.b();
        } finally {
            advertisingIdClient.c();
        }
    }

    public static void b(boolean z) {
        h = z;
    }

    private void d() {
        synchronized (this.d) {
            if (this.e != null) {
                this.e.a();
                try {
                    this.e.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.f > 0) {
                this.e = new a(this, this.f);
            }
        }
    }

    public void a() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        a(true);
    }

    protected void a(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzx.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.c) {
                c();
            }
            this.f526a = a(this.g);
            this.b = a(this.g, this.f526a);
            this.c = true;
            if (z) {
                d();
            }
        }
    }

    public Info b() throws IOException {
        Info info;
        zzx.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.c) {
                synchronized (this.d) {
                    if (this.e == null || !this.e.b()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    a(false);
                    if (!this.c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                }
            }
            zzx.a(this.f526a);
            zzx.a(this.b);
            try {
                info = new Info(this.b.getId(), this.b.zzc(true));
            } catch (RemoteException e2) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                throw new IOException("Remote exception");
            }
        }
        d();
        return info;
    }

    public void c() {
        zzx.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.g == null || this.f526a == null) {
                return;
            }
            try {
                if (this.c) {
                    zzb.a().a(this.g, this.f526a);
                }
            } catch (IllegalArgumentException e) {
                Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", e);
            }
            this.c = false;
            this.b = null;
            this.f526a = null;
        }
    }

    protected void finalize() throws Throwable {
        c();
        super.finalize();
    }
}
