package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzal;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class zzam extends zzal {
    private static AdvertisingIdClient zznq = null;
    private static CountDownLatch zznr = new CountDownLatch(1);
    private static volatile boolean zzns;
    private boolean zznt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {
        private String b;
        private boolean c;

        public a(String str, boolean z) {
            this.b = str;
            this.c = z;
        }

        public String a() {
            return this.b;
        }

        public boolean b() {
            return this.c;
        }
    }

    /* loaded from: classes.dex */
    private static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private Context f1683a;

        public b(Context context) {
            this.f1683a = context.getApplicationContext();
            if (this.f1683a == null) {
                this.f1683a = context;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (zzam.class) {
                try {
                    try {
                        try {
                            if (zzam.zznq == null) {
                                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.f1683a);
                                advertisingIdClient.a();
                                AdvertisingIdClient unused = zzam.zznq = advertisingIdClient;
                            }
                        } catch (GooglePlayServicesRepairableException e) {
                            zzam.zznr.countDown();
                        } catch (IOException e2) {
                            zzam.zznr.countDown();
                        }
                    } catch (GooglePlayServicesNotAvailableException e3) {
                        boolean unused2 = zzam.zzns = true;
                        zzam.zznr.countDown();
                    }
                } finally {
                    zzam.zznr.countDown();
                }
            }
        }
    }

    protected zzam(Context context, zzap zzapVar, c cVar, boolean z) {
        super(context, zzapVar, cVar);
        this.zznt = z;
    }

    public static zzam zza(String str, Context context, boolean z) {
        com.google.android.gms.internal.a aVar = new com.google.android.gms.internal.a();
        zza(str, context, aVar);
        if (z) {
            synchronized (zzam.class) {
                if (zznq == null) {
                    new Thread(new b(context)).start();
                }
            }
        }
        return new zzam(context, aVar, new d(239), z);
    }

    a zzY() throws IOException {
        a aVar;
        try {
            if (!zznr.await(2L, TimeUnit.SECONDS)) {
                return new a(null, false);
            }
            synchronized (zzam.class) {
                if (zznq == null) {
                    aVar = new a(null, false);
                } else {
                    AdvertisingIdClient.Info b2 = zznq.b();
                    aVar = new a(zzk(b2.a()), b2.b());
                }
            }
            return aVar;
        } catch (InterruptedException e) {
            return new a(null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzal, com.google.android.gms.internal.zzak
    public void zzc(Context context) {
        super.zzc(context);
        try {
            if (zzns || !this.zznt) {
                zza(24, zze(context));
            } else {
                a zzY = zzY();
                String a2 = zzY.a();
                if (a2 != null) {
                    zza(28, zzY.b() ? 1L : 0L);
                    zza(26, 5L);
                    zza(24, a2);
                }
            }
        } catch (zzal.zza e) {
        } catch (IOException e2) {
        }
    }
}
