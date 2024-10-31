package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public class zzb {

    /* renamed from: a, reason: collision with root package name */
    Object f611a;
    private final Context b;
    private final boolean c;

    public zzb(Context context) {
        this(context, true);
    }

    public zzb(Context context, boolean z) {
        this.b = context;
        this.c = z;
    }

    public int a(int i, String str, String str2) {
        try {
            Class<?> loadClass = this.b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return ((Integer) loadClass.getDeclaredMethod("isBillingSupported", Integer.TYPE, String.class, String.class).invoke(loadClass.cast(this.f611a), Integer.valueOf(i), str, str2)).intValue();
        } catch (Exception e) {
            if (this.c) {
                com.google.android.gms.ads.internal.util.client.zzb.d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return 5;
        }
    }

    public int a(String str, String str2) {
        try {
            Class<?> loadClass = this.b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return ((Integer) loadClass.getDeclaredMethod("consumePurchase", Integer.TYPE, String.class, String.class).invoke(loadClass.cast(this.f611a), 3, str, str2)).intValue();
        } catch (Exception e) {
            if (this.c) {
                com.google.android.gms.ads.internal.util.client.zzb.d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return 5;
        }
    }

    public Bundle a(String str, String str2, String str3) {
        try {
            Class<?> loadClass = this.b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) loadClass.getDeclaredMethod("getBuyIntent", Integer.TYPE, String.class, String.class, String.class, String.class).invoke(loadClass.cast(this.f611a), 3, str, str2, "inapp", str3);
        } catch (Exception e) {
            if (this.c) {
                com.google.android.gms.ads.internal.util.client.zzb.d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return null;
        }
    }

    public void a() {
        this.f611a = null;
    }

    public void a(IBinder iBinder) {
        try {
            this.f611a = this.b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService$Stub").getDeclaredMethod("asInterface", IBinder.class).invoke(null, iBinder);
        } catch (Exception e) {
            if (this.c) {
                com.google.android.gms.ads.internal.util.client.zzb.e("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.");
            }
        }
    }

    public Bundle b(String str, String str2) {
        try {
            Class<?> loadClass = this.b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) loadClass.getDeclaredMethod("getPurchases", Integer.TYPE, String.class, String.class, String.class).invoke(loadClass.cast(this.f611a), 3, str, "inapp", str2);
        } catch (Exception e) {
            if (this.c) {
                com.google.android.gms.ads.internal.util.client.zzb.d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return null;
        }
    }
}
