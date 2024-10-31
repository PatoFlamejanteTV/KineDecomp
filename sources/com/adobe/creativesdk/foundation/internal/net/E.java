package com.adobe.creativesdk.foundation.internal.net;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.net.C0324c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

/* compiled from: AdobeNetworkHttpTaskHandle.java */
/* loaded from: classes.dex */
public class E {

    /* renamed from: d */
    private ArrayList<Object> f5086d;

    /* renamed from: a */
    private Future<l> f5083a = null;

    /* renamed from: b */
    private int f5084b = 0;

    /* renamed from: c */
    private String f5085c = null;

    /* renamed from: e */
    protected boolean f5087e = false;

    /* renamed from: f */
    private boolean f5088f = false;

    /* renamed from: g */
    private Handler f5089g = null;

    /* renamed from: h */
    private boolean f5090h = false;
    protected List<C0324c.a> i = Collections.synchronizedList(new ArrayList());

    public E() {
        this.f5086d = null;
        this.f5086d = new ArrayList<>();
    }

    public String b() {
        return this.f5085c;
    }

    public synchronized boolean c() {
        return this.f5087e;
    }

    public synchronized boolean d() {
        return this.f5090h;
    }

    public synchronized void e() {
        this.f5088f = true;
    }

    public void b(H h2) {
        this.f5086d.remove(h2);
    }

    public synchronized void a(Handler handler) {
        this.f5089g = handler;
    }

    public synchronized void a(Future<l> future) {
        this.f5083a = future;
    }

    public void a(String str) {
        this.f5085c = str;
    }

    public synchronized void a() {
        if (this.f5083a != null) {
            this.f5083a.cancel(true);
        }
        this.f5087e = this.f5083a.isCancelled();
        if (!d() || getClass() == C0324c.class) {
            synchronized (this.i) {
                Iterator<C0324c.a> it = this.i.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
            }
        }
    }

    public void a(H h2) {
        this.f5086d.add(h2);
    }

    public synchronized void a(int i) {
        D d2 = new D(this, i);
        if (this.f5089g != null) {
            this.f5089g.post(d2);
        } else {
            d2.run();
        }
    }

    public synchronized void a(boolean z) {
        this.f5090h = z;
    }

    public void a(C0324c.a aVar) {
        this.i.add(aVar);
    }
}
