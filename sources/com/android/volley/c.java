package com.android.volley;

import android.os.Process;
import com.android.volley.Request;
import com.android.volley.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* compiled from: CacheDispatcher.java */
/* loaded from: classes.dex */
public class c extends Thread {

    /* renamed from: a */
    private static final boolean f8043a = p.f8092b;

    /* renamed from: b */
    private final BlockingQueue<Request<?>> f8044b;

    /* renamed from: c */
    private final BlockingQueue<Request<?>> f8045c;

    /* renamed from: d */
    private final com.android.volley.a f8046d;

    /* renamed from: e */
    private final n f8047e;

    /* renamed from: f */
    private volatile boolean f8048f = false;

    /* renamed from: g */
    private final a f8049g = new a(this);

    /* compiled from: CacheDispatcher.java */
    /* loaded from: classes.dex */
    public static class a implements Request.a {

        /* renamed from: a */
        private final Map<String, List<Request<?>>> f8050a = new HashMap();

        /* renamed from: b */
        private final c f8051b;

        a(c cVar) {
            this.f8051b = cVar;
        }

        public synchronized boolean b(Request<?> request) {
            String f2 = request.f();
            if (this.f8050a.containsKey(f2)) {
                List<Request<?>> list = this.f8050a.get(f2);
                if (list == null) {
                    list = new ArrayList<>();
                }
                request.a("waiting-for-response");
                list.add(request);
                this.f8050a.put(f2, list);
                if (p.f8092b) {
                    p.a("Request for cacheKey=%s is in flight, putting on hold.", f2);
                }
                return true;
            }
            this.f8050a.put(f2, null);
            request.a((Request.a) this);
            if (p.f8092b) {
                p.a("new request, sending to network %s", f2);
            }
            return false;
        }

        @Override // com.android.volley.Request.a
        public void a(Request<?> request, m<?> mVar) {
            List<Request<?>> remove;
            a.C0040a c0040a = mVar.f8088b;
            if (c0040a != null && !c0040a.a()) {
                String f2 = request.f();
                synchronized (this) {
                    remove = this.f8050a.remove(f2);
                }
                if (remove != null) {
                    if (p.f8092b) {
                        p.c("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), f2);
                    }
                    Iterator<Request<?>> it = remove.iterator();
                    while (it.hasNext()) {
                        this.f8051b.f8047e.a(it.next(), mVar);
                    }
                    return;
                }
                return;
            }
            a(request);
        }

        @Override // com.android.volley.Request.a
        public synchronized void a(Request<?> request) {
            String f2 = request.f();
            List<Request<?>> remove = this.f8050a.remove(f2);
            if (remove != null && !remove.isEmpty()) {
                if (p.f8092b) {
                    p.c("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), f2);
                }
                Request<?> remove2 = remove.remove(0);
                this.f8050a.put(f2, remove);
                remove2.a((Request.a) this);
                try {
                    this.f8051b.f8045c.put(remove2);
                } catch (InterruptedException e2) {
                    p.b("Couldn't add request to queue. %s", e2.toString());
                    Thread.currentThread().interrupt();
                    this.f8051b.b();
                }
            }
        }
    }

    public c(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, com.android.volley.a aVar, n nVar) {
        this.f8044b = blockingQueue;
        this.f8045c = blockingQueue2;
        this.f8046d = aVar;
        this.f8047e = nVar;
    }

    private void c() throws InterruptedException {
        Request<?> take = this.f8044b.take();
        take.a("cache-queue-take");
        if (take.B()) {
            take.b("cache-discard-canceled");
            return;
        }
        a.C0040a a2 = this.f8046d.a(take.f());
        if (a2 == null) {
            take.a("cache-miss");
            if (this.f8049g.b(take)) {
                return;
            }
            this.f8045c.put(take);
            return;
        }
        if (a2.a()) {
            take.a("cache-hit-expired");
            take.a(a2);
            if (this.f8049g.b(take)) {
                return;
            }
            this.f8045c.put(take);
            return;
        }
        take.a("cache-hit");
        m<?> a3 = take.a(new j(a2.f7981a, a2.f7987g));
        take.a("cache-hit-parsed");
        if (!a2.b()) {
            this.f8047e.a(take, a3);
            return;
        }
        take.a("cache-hit-refresh-needed");
        take.a(a2);
        a3.f8090d = true;
        if (!this.f8049g.b(take)) {
            this.f8047e.a(take, a3, new b(this, take));
        } else {
            this.f8047e.a(take, a3);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (f8043a) {
            p.c("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f8046d.d();
        while (true) {
            try {
                c();
            } catch (InterruptedException unused) {
                if (this.f8048f) {
                    return;
                }
            }
        }
    }

    public void b() {
        this.f8048f = true;
        interrupt();
    }
}
