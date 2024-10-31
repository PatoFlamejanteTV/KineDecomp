package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.android.billingclient.api.H;
import com.android.billingclient.api.M;
import com.android.billingclient.api.P;
import com.android.vending.billing.IInAppBillingService;
import com.umeng.commonsdk.statistics.SdkVersion;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BillingClientImpl.java */
/* loaded from: classes.dex */
public class C extends AbstractC0693g {

    /* renamed from: a, reason: collision with root package name */
    private int f7849a;

    /* renamed from: b, reason: collision with root package name */
    private final String f7850b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f7851c;

    /* renamed from: d, reason: collision with root package name */
    private final C0691e f7852d;

    /* renamed from: e, reason: collision with root package name */
    private final Context f7853e;

    /* renamed from: f, reason: collision with root package name */
    private final int f7854f;

    /* renamed from: g, reason: collision with root package name */
    private final int f7855g;

    /* renamed from: h, reason: collision with root package name */
    private IInAppBillingService f7856h;
    private ServiceConnection i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private final boolean o;
    private ExecutorService p;
    private final ResultReceiver q;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BillingClientImpl.java */
    /* loaded from: classes.dex */
    public final class a implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        private final D f7857a;

        /* synthetic */ a(C c2, D d2, ResultReceiverC0703q resultReceiverC0703q) {
            this(d2);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            c.b.a.a.a.a("BillingClient", "Billing service connected.");
            C.this.f7856h = IInAppBillingService.Stub.a(iBinder);
            C.this.a(new A(this), com.umeng.commonsdk.proguard.c.f26227d, new B(this));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.b.a.a.a.b("BillingClient", "Billing service disconnected.");
            C.this.f7856h = null;
            C.this.f7849a = 0;
            this.f7857a.a();
        }

        private a(D d2) {
            this.f7857a = d2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(H h2) {
            C.this.a(new z(this, h2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C(Context context, int i, int i2, boolean z, O o) {
        this(context, i, i2, z, o, SdkVersion.SDK_VERSION);
    }

    private C(Context context, int i, int i2, boolean z, O o, String str) {
        this.f7849a = 0;
        this.f7851c = new Handler(Looper.getMainLooper());
        this.q = new ResultReceiverC0703q(this, this.f7851c);
        this.f7853e = context.getApplicationContext();
        this.f7854f = i;
        this.f7855g = i2;
        this.o = z;
        this.f7852d = new C0691e(this.f7853e, o);
        this.f7850b = str;
    }

    @Override // com.android.billingclient.api.AbstractC0693g
    public boolean b() {
        return (this.f7849a != 2 || this.f7856h == null || this.i == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public M.a b(String str) {
        Bundle a2;
        c.b.a.a.a.a("BillingClient", "Querying owned items, item type: " + str);
        ArrayList arrayList = new ArrayList();
        Bundle a3 = c.b.a.a.a.a(this.n, this.o, this.f7850b);
        String str2 = null;
        do {
            try {
                if (this.n) {
                    a2 = this.f7856h.a(9, this.f7853e.getPackageName(), str, str2, a3);
                } else {
                    a2 = this.f7856h.a(3, this.f7853e.getPackageName(), str, str2);
                }
                H a4 = N.a(a2, "BillingClient", "getPurchase()");
                if (a4 != I.o) {
                    return new M.a(a4, null);
                }
                ArrayList<String> stringArrayList = a2.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = a2.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = a2.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                for (int i = 0; i < stringArrayList2.size(); i++) {
                    String str3 = stringArrayList2.get(i);
                    String str4 = stringArrayList3.get(i);
                    c.b.a.a.a.a("BillingClient", "Sku is owned: " + stringArrayList.get(i));
                    try {
                        M m = new M(str3, str4);
                        if (TextUtils.isEmpty(m.c())) {
                            c.b.a.a.a.b("BillingClient", "BUG: empty/null token!");
                        }
                        arrayList.add(m);
                    } catch (JSONException e2) {
                        c.b.a.a.a.b("BillingClient", "Got an exception trying to decode the purchase: " + e2);
                        return new M.a(I.k, null);
                    }
                }
                str2 = a2.getString("INAPP_CONTINUATION_TOKEN");
                c.b.a.a.a.a("BillingClient", "Continuation token: " + str2);
            } catch (Exception e3) {
                c.b.a.a.a.b("BillingClient", "Got exception trying to get purchases: " + e3 + "; try to reconnect");
                return new M.a(I.p, null);
            }
        } while (!TextUtils.isEmpty(str2));
        return new M.a(I.o, arrayList);
    }

    @Override // com.android.billingclient.api.AbstractC0693g
    public void a(D d2) {
        ResolveInfo resolveInfo;
        ServiceInfo serviceInfo;
        if (b()) {
            c.b.a.a.a.a("BillingClient", "Service connection is valid. No need to re-initialize.");
            d2.a(I.o);
            return;
        }
        int i = this.f7849a;
        if (i == 1) {
            c.b.a.a.a.b("BillingClient", "Client is already in the process of connecting to billing service.");
            d2.a(I.f7878d);
            return;
        }
        if (i == 3) {
            c.b.a.a.a.b("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            d2.a(I.p);
            return;
        }
        this.f7849a = 1;
        this.f7852d.c();
        c.b.a.a.a.a("BillingClient", "Starting in-app billing setup.");
        this.i = new a(this, d2, null);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> queryIntentServices = this.f7853e.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices != null && !queryIntentServices.isEmpty() && (serviceInfo = (resolveInfo = queryIntentServices.get(0)).serviceInfo) != null) {
            String str = serviceInfo.packageName;
            String str2 = resolveInfo.serviceInfo.name;
            if ("com.android.vending".equals(str) && str2 != null) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                intent2.putExtra("playBillingLibraryVersion", this.f7850b);
                if (this.f7853e.bindService(intent2, this.i, 1)) {
                    c.b.a.a.a.a("BillingClient", "Service was bonded successfully.");
                    return;
                }
                c.b.a.a.a.b("BillingClient", "Connection to Billing service is blocked.");
            } else {
                c.b.a.a.a.b("BillingClient", "The device doesn't have valid Play Store.");
            }
        }
        this.f7849a = 0;
        c.b.a.a.a.a("BillingClient", "Billing service unavailable on device.");
        d2.a(I.f7877c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(K k, L l) {
        int c2;
        String str;
        String b2 = k.b();
        try {
            c.b.a.a.a.a("BillingClient", "Consuming purchase with token: " + b2);
            if (this.n) {
                Bundle c3 = this.f7856h.c(9, this.f7853e.getPackageName(), b2, c.b.a.a.a.a(k, this.n));
                int i = c3.getInt("RESPONSE_CODE");
                str = c.b.a.a.a.a(c3, "BillingClient");
                c2 = i;
            } else {
                c2 = this.f7856h.c(3, this.f7853e.getPackageName(), b2);
                str = "";
            }
            H.a b3 = H.b();
            b3.a(c2);
            b3.a(str);
            H a2 = b3.a();
            if (c2 == 0) {
                a(new RunnableC0704s(this, l, a2, b2));
            } else {
                a(new RunnableC0705t(this, c2, l, a2, b2));
            }
        } catch (Exception e2) {
            a(new u(this, e2, l, b2));
        }
    }

    @Override // com.android.billingclient.api.AbstractC0693g
    public void a() {
        try {
            try {
                this.f7852d.a();
                if (this.i != null && this.f7856h != null) {
                    c.b.a.a.a.a("BillingClient", "Unbinding from service.");
                    this.f7853e.unbindService(this.i);
                    this.i = null;
                }
                this.f7856h = null;
                if (this.p != null) {
                    this.p.shutdownNow();
                    this.p = null;
                }
            } catch (Exception e2) {
                c.b.a.a.a.b("BillingClient", "There was an exception while ending connection: " + e2);
            }
        } finally {
            this.f7849a = 3;
        }
    }

    @Override // com.android.billingclient.api.AbstractC0693g
    public H a(Activity activity, F f2) {
        Future a2;
        int i;
        if (!b()) {
            H h2 = I.p;
            a(h2);
            return h2;
        }
        String g2 = f2.g();
        String e2 = f2.e();
        P f3 = f2.f();
        boolean z = f3 != null && f3.p();
        if (e2 == null) {
            c.b.a.a.a.b("BillingClient", "Please fix the input params. SKU can't be null.");
            H h3 = I.m;
            a(h3);
            return h3;
        }
        if (g2 == null) {
            c.b.a.a.a.b("BillingClient", "Please fix the input params. SkuType can't be null.");
            H h4 = I.n;
            a(h4);
            return h4;
        }
        if (g2.equals("subs") && !this.j) {
            c.b.a.a.a.b("BillingClient", "Current client doesn't support subscriptions.");
            H h5 = I.r;
            a(h5);
            return h5;
        }
        boolean z2 = f2.c() != null;
        if (z2 && !this.k) {
            c.b.a.a.a.b("BillingClient", "Current client doesn't support subscriptions update.");
            H h6 = I.s;
            a(h6);
            return h6;
        }
        if (f2.i() && !this.l) {
            c.b.a.a.a.b("BillingClient", "Current client doesn't support extra params for buy intent.");
            H h7 = I.f7881g;
            a(h7);
            return h7;
        }
        if (z && !this.l) {
            c.b.a.a.a.b("BillingClient", "Current client doesn't support extra params for buy intent.");
            H h8 = I.f7881g;
            a(h8);
            return h8;
        }
        c.b.a.a.a.a("BillingClient", "Constructing buy intent for " + e2 + ", item type: " + g2);
        if (this.l) {
            Bundle a3 = c.b.a.a.a.a(f2, this.n, this.o, this.f7850b);
            if (!f3.l().isEmpty()) {
                a3.putString("skuDetailsToken", f3.l());
            }
            if (z) {
                a3.putString("rewardToken", f3.q());
                int i2 = this.f7854f;
                if (i2 != 0) {
                    a3.putInt("childDirected", i2);
                }
                int i3 = this.f7855g;
                if (i3 != 0) {
                    a3.putInt("underAgeOfConsent", i3);
                }
            }
            if (this.n) {
                i = 9;
            } else {
                i = f2.h() ? 7 : 6;
            }
            a2 = a(new v(this, i, e2, g2, a3), 5000L, (Runnable) null);
        } else if (z2) {
            a2 = a(new w(this, f2, e2), 5000L, (Runnable) null);
        } else {
            a2 = a(new x(this, e2, g2), 5000L, (Runnable) null);
        }
        try {
            Bundle bundle = (Bundle) a2.get(5000L, TimeUnit.MILLISECONDS);
            int b2 = c.b.a.a.a.b(bundle, "BillingClient");
            String a4 = c.b.a.a.a.a(bundle, "BillingClient");
            if (b2 != 0) {
                c.b.a.a.a.b("BillingClient", "Unable to buy item, Error response code: " + b2);
                H.a b3 = H.b();
                b3.a(b2);
                b3.a(a4);
                H a5 = b3.a();
                a(a5);
                return a5;
            }
            Intent intent = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
            intent.putExtra("result_receiver", this.q);
            intent.putExtra("BUY_INTENT", (PendingIntent) bundle.getParcelable("BUY_INTENT"));
            activity.startActivity(intent);
            return I.o;
        } catch (CancellationException | TimeoutException unused) {
            c.b.a.a.a.b("BillingClient", "Time out while launching billing flow: ; for sku: " + e2 + "; try to reconnect");
            H h9 = I.q;
            a(h9);
            return h9;
        } catch (Exception unused2) {
            c.b.a.a.a.b("BillingClient", "Exception while launching billing flow: ; for sku: " + e2 + "; try to reconnect");
            H h10 = I.p;
            a(h10);
            return h10;
        }
    }

    private H a(H h2) {
        this.f7852d.b().a(h2, null);
        return h2;
    }

    @Override // com.android.billingclient.api.AbstractC0693g
    public M.a a(String str) {
        if (!b()) {
            return new M.a(I.p, null);
        }
        if (TextUtils.isEmpty(str)) {
            c.b.a.a.a.b("BillingClient", "Please provide a valid SKU type.");
            return new M.a(I.f7880f, null);
        }
        try {
            return (M.a) a(new y(this, str), 5000L, (Runnable) null).get(5000L, TimeUnit.MILLISECONDS);
        } catch (CancellationException | TimeoutException unused) {
            return new M.a(I.q, null);
        } catch (Exception unused2) {
            return new M.a(I.k, null);
        }
    }

    @Override // com.android.billingclient.api.AbstractC0693g
    public void a(S s, T t) {
        if (!b()) {
            t.a(I.p, null);
            return;
        }
        String a2 = s.a();
        List<String> b2 = s.b();
        if (TextUtils.isEmpty(a2)) {
            c.b.a.a.a.b("BillingClient", "Please fix the input params. SKU type can't be empty.");
            t.a(I.f7880f, null);
        } else if (b2 == null) {
            c.b.a.a.a.b("BillingClient", "Please fix the input params. The list of SKUs can't be empty.");
            t.a(I.f7879e, null);
        } else {
            a(new CallableC0695i(this, a2, b2, t), com.umeng.commonsdk.proguard.c.f26227d, new RunnableC0696j(this, t));
        }
    }

    @Override // com.android.billingclient.api.AbstractC0693g
    public void a(K k, L l) {
        if (!b()) {
            l.a(I.p, null);
        } else {
            a(new CallableC0697k(this, k, l), com.umeng.commonsdk.proguard.c.f26227d, new RunnableC0698l(this, l));
        }
    }

    @Override // com.android.billingclient.api.AbstractC0693g
    public void a(C0688b c0688b, InterfaceC0689c interfaceC0689c) {
        if (!b()) {
            interfaceC0689c.a(I.p);
            return;
        }
        if (TextUtils.isEmpty(c0688b.b())) {
            c.b.a.a.a.b("BillingClient", "Please provide a valid purchase token.");
            interfaceC0689c.a(I.j);
        } else if (!this.n) {
            interfaceC0689c.a(I.f7876b);
        } else {
            a(new CallableC0701o(this, c0688b, interfaceC0689c), com.umeng.commonsdk.proguard.c.f26227d, new RunnableC0702p(this, interfaceC0689c));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> Future<T> a(Callable<T> callable, long j, Runnable runnable) {
        double d2 = j;
        Double.isNaN(d2);
        long j2 = (long) (d2 * 0.95d);
        if (this.p == null) {
            this.p = Executors.newFixedThreadPool(c.b.a.a.a.f3458a);
        }
        try {
            Future<T> submit = this.p.submit(callable);
            this.f7851c.postDelayed(new r(this, submit, runnable), j2);
            return submit;
        } catch (Exception e2) {
            c.b.a.a.a.b("BillingClient", "Async task throws exception " + e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public P.a a(String str, List<String> list) {
        Bundle skuDetails;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 20;
            ArrayList<String> arrayList2 = new ArrayList<>(list.subList(i, i2 > size ? size : i2));
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList2);
            bundle.putString("playBillingLibraryVersion", this.f7850b);
            try {
                if (this.n) {
                    skuDetails = this.f7856h.a(9, this.f7853e.getPackageName(), str, bundle, c.b.a.a.a.a(this.n, this.o));
                } else {
                    skuDetails = this.f7856h.getSkuDetails(3, this.f7853e.getPackageName(), str, bundle);
                }
                if (skuDetails == null) {
                    c.b.a.a.a.b("BillingClient", "querySkuDetailsAsync got null sku details list");
                    return new P.a(4, "Null sku details list", null);
                }
                if (!skuDetails.containsKey("DETAILS_LIST")) {
                    int b2 = c.b.a.a.a.b(skuDetails, "BillingClient");
                    String a2 = c.b.a.a.a.a(skuDetails, "BillingClient");
                    if (b2 != 0) {
                        c.b.a.a.a.b("BillingClient", "getSkuDetails() failed. Response code: " + b2);
                        return new P.a(b2, a2, arrayList);
                    }
                    c.b.a.a.a.b("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a detail list.");
                    return new P.a(6, a2, arrayList);
                }
                ArrayList<String> stringArrayList = skuDetails.getStringArrayList("DETAILS_LIST");
                if (stringArrayList == null) {
                    c.b.a.a.a.b("BillingClient", "querySkuDetailsAsync got null response list");
                    return new P.a(4, "querySkuDetailsAsync got null response list", null);
                }
                for (int i3 = 0; i3 < stringArrayList.size(); i3++) {
                    try {
                        P p = new P(stringArrayList.get(i3));
                        c.b.a.a.a.a("BillingClient", "Got sku details: " + p);
                        arrayList.add(p);
                    } catch (JSONException unused) {
                        c.b.a.a.a.b("BillingClient", "Got a JSON exception trying to decode SkuDetails.");
                        return new P.a(6, "Error trying to decode SkuDetails.", null);
                    }
                }
                i = i2;
            } catch (Exception e2) {
                c.b.a.a.a.b("BillingClient", "querySkuDetailsAsync got a remote exception (try to reconnect)." + e2);
                return new P.a(-1, "Service connection is disconnected.", null);
            }
        }
        return new P.a(0, "", arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Runnable runnable) {
        if (Thread.interrupted()) {
            return;
        }
        this.f7851c.post(runnable);
    }
}
