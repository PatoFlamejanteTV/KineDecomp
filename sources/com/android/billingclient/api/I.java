package com.android.billingclient.api;

import com.android.billingclient.api.H;

/* compiled from: BillingResults.java */
/* loaded from: classes.dex */
final class I {

    /* renamed from: a */
    static final H f7875a;

    /* renamed from: b */
    static final H f7876b;

    /* renamed from: c */
    static final H f7877c;

    /* renamed from: d */
    static final H f7878d;

    /* renamed from: e */
    static final H f7879e;

    /* renamed from: f */
    static final H f7880f;

    /* renamed from: g */
    static final H f7881g;

    /* renamed from: h */
    static final H f7882h;
    static final H i;
    static final H j;
    static final H k;
    static final H l;
    static final H m;
    static final H n;
    static final H o;
    static final H p;
    static final H q;
    static final H r;
    static final H s;
    static final H t;

    static {
        H.a b2 = H.b();
        b2.a(3);
        b2.a("Google Play In-app Billing API version is less than 3");
        f7875a = b2.a();
        H.a b3 = H.b();
        b3.a(3);
        b3.a("Google Play In-app Billing API version is less than 9");
        f7876b = b3.a();
        H.a b4 = H.b();
        b4.a(3);
        b4.a("Billing service unavailable on device.");
        f7877c = b4.a();
        H.a b5 = H.b();
        b5.a(5);
        b5.a("Client is already in the process of connecting to billing service.");
        f7878d = b5.a();
        H.a b6 = H.b();
        b6.a(5);
        b6.a("The list of SKUs can't be empty.");
        f7879e = b6.a();
        H.a b7 = H.b();
        b7.a(5);
        b7.a("SKU type can't be empty.");
        f7880f = b7.a();
        H.a b8 = H.b();
        b8.a(-2);
        b8.a("Client does not support extra params.");
        f7881g = b8.a();
        H.a b9 = H.b();
        b9.a(-2);
        b9.a("Client does not support the feature.");
        f7882h = b9.a();
        H.a b10 = H.b();
        b10.a(-2);
        b10.a("Client does not support get purchase history.");
        i = b10.a();
        H.a b11 = H.b();
        b11.a(5);
        b11.a("Invalid purchase token.");
        j = b11.a();
        H.a b12 = H.b();
        b12.a(6);
        b12.a("An internal error occurred.");
        k = b12.a();
        H.a b13 = H.b();
        b13.a(4);
        b13.a("Item is unavailable for purchase.");
        l = b13.a();
        H.a b14 = H.b();
        b14.a(5);
        b14.a("SKU can't be null.");
        m = b14.a();
        H.a b15 = H.b();
        b15.a(5);
        b15.a("SKU type can't be null.");
        n = b15.a();
        H.a b16 = H.b();
        b16.a(0);
        o = b16.a();
        H.a b17 = H.b();
        b17.a(-1);
        b17.a("Service connection is disconnected.");
        p = b17.a();
        H.a b18 = H.b();
        b18.a(-3);
        b18.a("Timeout communicating with service.");
        q = b18.a();
        H.a b19 = H.b();
        b19.a(-2);
        b19.a("Client doesn't support subscriptions.");
        r = b19.a();
        H.a b20 = H.b();
        b20.a(-2);
        b20.a("Client doesn't support subscriptions update.");
        s = b20.a();
        H.a b21 = H.b();
        b21.a(5);
        b21.a("Unknown feature");
        t = b21.a();
    }
}
