package com.android.billingclient.api;

import android.app.Activity;
import android.content.Context;
import com.android.billingclient.api.M;

/* compiled from: BillingClient.java */
/* renamed from: com.android.billingclient.api.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0693g {

    /* compiled from: BillingClient.java */
    /* renamed from: com.android.billingclient.api.g$a */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f7911a;

        /* renamed from: b, reason: collision with root package name */
        private int f7912b;

        /* renamed from: c, reason: collision with root package name */
        private int f7913c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f7914d;

        /* renamed from: e, reason: collision with root package name */
        private O f7915e;

        public a a(O o) {
            this.f7915e = o;
            return this;
        }

        public a b() {
            this.f7914d = true;
            return this;
        }

        private a(Context context) {
            this.f7912b = 0;
            this.f7913c = 0;
            this.f7911a = context;
        }

        public AbstractC0693g a() {
            Context context = this.f7911a;
            if (context != null) {
                O o = this.f7915e;
                if (o != null) {
                    boolean z = this.f7914d;
                    if (z) {
                        return new C(context, this.f7912b, this.f7913c, z, o);
                    }
                    throw new IllegalArgumentException("Support for pending purchases must be enabled. Enable this by calling 'enablePendingPurchases()' on BillingClientBuilder.");
                }
                throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
            }
            throw new IllegalArgumentException("Please provide a valid Context.");
        }
    }

    public static a a(Context context) {
        return new a(context);
    }

    public abstract H a(Activity activity, F f2);

    public abstract M.a a(String str);

    public abstract void a();

    public abstract void a(D d2);

    public abstract void a(K k, L l);

    public abstract void a(S s, T t);

    public abstract void a(C0688b c0688b, InterfaceC0689c interfaceC0689c);

    public abstract boolean b();
}
