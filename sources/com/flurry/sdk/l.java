package com.flurry.sdk;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public abstract class l implements ay {
    protected static String d;
    protected ExecutorService f;
    protected ExecutorService g;
    t h;
    Set<String> e = new HashSet();
    protected String i = "defaultDataKey_";

    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    protected abstract void a(byte[] bArr, String str, String str2);

    public l(String str, String str2) {
        d = str2;
        az.a().a(this);
        this.f = Executors.newSingleThreadExecutor(new ba("FlurryAgent", 1));
        this.g = Executors.newCachedThreadPool(new ba("FlurryAgent", 1));
        a(str);
    }

    protected void a(String str) {
        this.f.submit(new m(this, str));
    }

    @Override // com.flurry.sdk.ay
    public void a(boolean z) {
        as.a(4, d, "onNetworkStateChanged : isNetworkEnable = " + z);
        if (z) {
            c();
        }
    }

    public void b(byte[] bArr, String str, String str2) {
        a(bArr, str, str2, null);
    }

    protected void a(byte[] bArr, String str, String str2, a aVar) {
        if (bArr == null || bArr.length == 0) {
            as.a(6, d, "Report that has to be sent is EMPTY or NULL");
        } else {
            c(bArr, str, str2);
            a(aVar);
        }
    }

    protected int b() {
        return this.e.size();
    }

    protected void c(byte[] bArr, String str, String str2) {
        this.f.submit(new n(this, bArr, str, str2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        a((a) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.f.submit(new o(this, aVar));
    }

    protected boolean d() {
        return b() <= 8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        Thread.currentThread().setName("DataSender Main Single Thread , id = " + Thread.currentThread().getId());
    }

    protected String a(String str, String str2) {
        return this.i + str + "_" + str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String d(byte[] bArr, String str, String str2) {
        String a2 = a(str, str2);
        r rVar = new r();
        rVar.a(bArr);
        String a3 = rVar.a();
        this.h.a(rVar, a2);
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        if (!az.a().c()) {
            as.a(5, d, "Reports were not sent! No Internet connection!");
            return;
        }
        List<String> a2 = this.h.a();
        if (a2 == null || a2.isEmpty()) {
            as.a(4, d, "No more reports to send.");
            return;
        }
        for (String str : a2) {
            if (d()) {
                List<String> c = this.h.c(str);
                as.a(4, d, "Number of not sent blocks = " + c.size());
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < c.size()) {
                        String str2 = c.get(i2);
                        if (!this.e.contains(str2)) {
                            if (d()) {
                                byte[] b = new r(str2).b();
                                if (b == null || b.length == 0) {
                                    as.a(6, d, "Internal ERROR! Report is empty!");
                                    this.h.a(str2, str);
                                } else {
                                    this.e.add(str2);
                                    a(b, str2, str);
                                }
                            }
                        }
                        i = i2 + 1;
                    }
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, String str2, int i) {
        this.f.submit(new p(this, str, str2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str, String str2) {
        this.f.submit(new q(this, str));
    }
}
