package com.squareup.picasso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.facebook.internal.ServerProtocol;
import com.squareup.picasso.NetworkRequestHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* compiled from: Dispatcher.java */
/* loaded from: classes3.dex */
public class q {

    /* renamed from: a */
    final b f25655a = new b();

    /* renamed from: b */
    final Context f25656b;

    /* renamed from: c */
    final ExecutorService f25657c;

    /* renamed from: d */
    final Downloader f25658d;

    /* renamed from: e */
    final Map<String, RunnableC2396i> f25659e;

    /* renamed from: f */
    final Map<Object, AbstractC2388a> f25660f;

    /* renamed from: g */
    final Map<Object, AbstractC2388a> f25661g;

    /* renamed from: h */
    final Set<Object> f25662h;
    final Handler i;
    final Handler j;
    final InterfaceC2398k k;
    final H l;
    final List<RunnableC2396i> m;
    final c n;
    final boolean o;
    boolean p;

    /* compiled from: Dispatcher.java */
    /* loaded from: classes3.dex */
    public static class a extends Handler {

        /* renamed from: a */
        private final q f25663a;

        public a(Looper looper, q qVar) {
            super(looper);
            this.f25663a = qVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.f25663a.d((AbstractC2388a) message.obj);
                    return;
                case 2:
                    this.f25663a.c((AbstractC2388a) message.obj);
                    return;
                case 3:
                case 8:
                default:
                    Picasso.f25603a.post(new p(this, message));
                    return;
                case 4:
                    this.f25663a.d((RunnableC2396i) message.obj);
                    return;
                case 5:
                    this.f25663a.e((RunnableC2396i) message.obj);
                    return;
                case 6:
                    this.f25663a.a((RunnableC2396i) message.obj, false);
                    return;
                case 7:
                    this.f25663a.a();
                    return;
                case 9:
                    this.f25663a.b((NetworkInfo) message.obj);
                    return;
                case 10:
                    this.f25663a.b(message.arg1 == 1);
                    return;
                case 11:
                    this.f25663a.a(message.obj);
                    return;
                case 12:
                    this.f25663a.b(message.obj);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Dispatcher.java */
    /* loaded from: classes3.dex */
    public static class b extends HandlerThread {
        b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Dispatcher.java */
    /* loaded from: classes3.dex */
    public static class c extends BroadcastReceiver {

        /* renamed from: a */
        private final q f25664a;

        c(q qVar) {
            this.f25664a = qVar;
        }

        void a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.f25664a.o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.f25664a.f25656b.registerReceiver(this, intentFilter);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                if (intent.hasExtra(ServerProtocol.DIALOG_PARAM_STATE)) {
                    this.f25664a.a(intent.getBooleanExtra(ServerProtocol.DIALOG_PARAM_STATE, false));
                }
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                this.f25664a.a(((ConnectivityManager) N.a(context, "connectivity")).getActiveNetworkInfo());
            }
        }
    }

    public q(Context context, ExecutorService executorService, Handler handler, Downloader downloader, InterfaceC2398k interfaceC2398k, H h2) {
        this.f25655a.start();
        N.a(this.f25655a.getLooper());
        this.f25656b = context;
        this.f25657c = executorService;
        this.f25659e = new LinkedHashMap();
        this.f25660f = new WeakHashMap();
        this.f25661g = new WeakHashMap();
        this.f25662h = new HashSet();
        this.i = new a(this.f25655a.getLooper(), this);
        this.f25658d = downloader;
        this.j = handler;
        this.k = interfaceC2398k;
        this.l = h2;
        this.m = new ArrayList(4);
        this.p = N.d(this.f25656b);
        this.o = N.b(context, "android.permission.ACCESS_NETWORK_STATE");
        this.n = new c(this);
        this.n.a();
    }

    private void f(RunnableC2396i runnableC2396i) {
        if (runnableC2396i.n()) {
            return;
        }
        this.m.add(runnableC2396i);
        if (this.i.hasMessages(7)) {
            return;
        }
        this.i.sendEmptyMessageDelayed(7, 200L);
    }

    private void g(RunnableC2396i runnableC2396i) {
        AbstractC2388a c2 = runnableC2396i.c();
        if (c2 != null) {
            e(c2);
        }
        List<AbstractC2388a> d2 = runnableC2396i.d();
        if (d2 != null) {
            int size = d2.size();
            for (int i = 0; i < size; i++) {
                e(d2.get(i));
            }
        }
    }

    public void a(AbstractC2388a abstractC2388a) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(2, abstractC2388a));
    }

    public void b(AbstractC2388a abstractC2388a) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(1, abstractC2388a));
    }

    public void c(RunnableC2396i runnableC2396i) {
        Handler handler = this.i;
        handler.sendMessageDelayed(handler.obtainMessage(5, runnableC2396i), 500L);
    }

    void d(AbstractC2388a abstractC2388a) {
        a(abstractC2388a, true);
    }

    void e(RunnableC2396i runnableC2396i) {
        if (runnableC2396i.n()) {
            return;
        }
        boolean z = false;
        if (this.f25657c.isShutdown()) {
            a(runnableC2396i, false);
            return;
        }
        NetworkInfo activeNetworkInfo = this.o ? ((ConnectivityManager) N.a(this.f25656b, "connectivity")).getActiveNetworkInfo() : null;
        boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        boolean a2 = runnableC2396i.a(this.p, activeNetworkInfo);
        boolean o = runnableC2396i.o();
        if (!a2) {
            if (this.o && o) {
                z = true;
            }
            a(runnableC2396i, z);
            if (z) {
                g(runnableC2396i);
                return;
            }
            return;
        }
        if (this.o && !z2) {
            a(runnableC2396i, o);
            if (o) {
                g(runnableC2396i);
                return;
            }
            return;
        }
        if (runnableC2396i.j().p) {
            N.a("Dispatcher", "retrying", N.a(runnableC2396i));
        }
        if (runnableC2396i.f() instanceof NetworkRequestHandler.ContentLengthException) {
            runnableC2396i.m |= NetworkPolicy.NO_CACHE.index;
        }
        runnableC2396i.r = this.f25657c.submit(runnableC2396i);
    }

    public void a(RunnableC2396i runnableC2396i) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(4, runnableC2396i));
    }

    public void b(RunnableC2396i runnableC2396i) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(6, runnableC2396i));
    }

    void c(AbstractC2388a abstractC2388a) {
        String c2 = abstractC2388a.c();
        RunnableC2396i runnableC2396i = this.f25659e.get(c2);
        if (runnableC2396i != null) {
            runnableC2396i.b(abstractC2388a);
            if (runnableC2396i.b()) {
                this.f25659e.remove(c2);
                if (abstractC2388a.f().p) {
                    N.a("Dispatcher", "canceled", abstractC2388a.h().d());
                }
            }
        }
        if (this.f25662h.contains(abstractC2388a.i())) {
            this.f25661g.remove(abstractC2388a.j());
            if (abstractC2388a.f().p) {
                N.a("Dispatcher", "canceled", abstractC2388a.h().d(), "because paused request got canceled");
            }
        }
        AbstractC2388a remove = this.f25660f.remove(abstractC2388a.j());
        if (remove == null || !remove.f().p) {
            return;
        }
        N.a("Dispatcher", "canceled", remove.h().d(), "from replaying");
    }

    void d(RunnableC2396i runnableC2396i) {
        if (MemoryPolicy.shouldWriteToMemoryCache(runnableC2396i.i())) {
            this.k.a(runnableC2396i.g(), runnableC2396i.l());
        }
        this.f25659e.remove(runnableC2396i.g());
        f(runnableC2396i);
        if (runnableC2396i.j().p) {
            N.a("Dispatcher", "batched", N.a(runnableC2396i), "for completion");
        }
    }

    void a(NetworkInfo networkInfo) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(9, networkInfo));
    }

    void b(Object obj) {
        if (this.f25662h.remove(obj)) {
            ArrayList arrayList = null;
            Iterator<AbstractC2388a> it = this.f25661g.values().iterator();
            while (it.hasNext()) {
                AbstractC2388a next = it.next();
                if (next.i().equals(obj)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(next);
                    it.remove();
                }
            }
            if (arrayList != null) {
                Handler handler = this.j;
                handler.sendMessage(handler.obtainMessage(13, arrayList));
            }
        }
    }

    void a(boolean z) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(10, z ? 1 : 0, 0));
    }

    void a(AbstractC2388a abstractC2388a, boolean z) {
        if (this.f25662h.contains(abstractC2388a.i())) {
            this.f25661g.put(abstractC2388a.j(), abstractC2388a);
            if (abstractC2388a.f().p) {
                N.a("Dispatcher", "paused", abstractC2388a.f25623b.d(), "because tag '" + abstractC2388a.i() + "' is paused");
                return;
            }
            return;
        }
        RunnableC2396i runnableC2396i = this.f25659e.get(abstractC2388a.c());
        if (runnableC2396i != null) {
            runnableC2396i.a(abstractC2388a);
            return;
        }
        if (this.f25657c.isShutdown()) {
            if (abstractC2388a.f().p) {
                N.a("Dispatcher", "ignored", abstractC2388a.f25623b.d(), "because shut down");
                return;
            }
            return;
        }
        RunnableC2396i a2 = RunnableC2396i.a(abstractC2388a.f(), this, this.k, this.l, abstractC2388a);
        a2.r = this.f25657c.submit(a2);
        this.f25659e.put(abstractC2388a.c(), a2);
        if (z) {
            this.f25660f.remove(abstractC2388a.j());
        }
        if (abstractC2388a.f().p) {
            N.a("Dispatcher", "enqueued", abstractC2388a.f25623b.d());
        }
    }

    void b(boolean z) {
        this.p = z;
    }

    void b(NetworkInfo networkInfo) {
        ExecutorService executorService = this.f25657c;
        if (executorService instanceof A) {
            ((A) executorService).a(networkInfo);
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return;
        }
        b();
    }

    private void b() {
        if (this.f25660f.isEmpty()) {
            return;
        }
        Iterator<AbstractC2388a> it = this.f25660f.values().iterator();
        while (it.hasNext()) {
            AbstractC2388a next = it.next();
            it.remove();
            if (next.f().p) {
                N.a("Dispatcher", "replaying", next.h().d());
            }
            a(next, false);
        }
    }

    private void e(AbstractC2388a abstractC2388a) {
        Object j = abstractC2388a.j();
        if (j != null) {
            abstractC2388a.k = true;
            this.f25660f.put(j, abstractC2388a);
        }
    }

    void a(Object obj) {
        if (this.f25662h.add(obj)) {
            Iterator<RunnableC2396i> it = this.f25659e.values().iterator();
            while (it.hasNext()) {
                RunnableC2396i next = it.next();
                boolean z = next.j().p;
                AbstractC2388a c2 = next.c();
                List<AbstractC2388a> d2 = next.d();
                boolean z2 = (d2 == null || d2.isEmpty()) ? false : true;
                if (c2 != null || z2) {
                    if (c2 != null && c2.i().equals(obj)) {
                        next.b(c2);
                        this.f25661g.put(c2.j(), c2);
                        if (z) {
                            N.a("Dispatcher", "paused", c2.f25623b.d(), "because tag '" + obj + "' was paused");
                        }
                    }
                    if (z2) {
                        for (int size = d2.size() - 1; size >= 0; size--) {
                            AbstractC2388a abstractC2388a = d2.get(size);
                            if (abstractC2388a.i().equals(obj)) {
                                next.b(abstractC2388a);
                                this.f25661g.put(abstractC2388a.j(), abstractC2388a);
                                if (z) {
                                    N.a("Dispatcher", "paused", abstractC2388a.f25623b.d(), "because tag '" + obj + "' was paused");
                                }
                            }
                        }
                    }
                    if (next.b()) {
                        it.remove();
                        if (z) {
                            N.a("Dispatcher", "canceled", N.a(next), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    void a() {
        ArrayList arrayList = new ArrayList(this.m);
        this.m.clear();
        Handler handler = this.j;
        handler.sendMessage(handler.obtainMessage(8, arrayList));
        a((List<RunnableC2396i>) arrayList);
    }

    void a(RunnableC2396i runnableC2396i, boolean z) {
        if (runnableC2396i.j().p) {
            String a2 = N.a(runnableC2396i);
            StringBuilder sb = new StringBuilder();
            sb.append("for error");
            sb.append(z ? " (will replay)" : "");
            N.a("Dispatcher", "batched", a2, sb.toString());
        }
        this.f25659e.remove(runnableC2396i.g());
        f(runnableC2396i);
    }

    private void a(List<RunnableC2396i> list) {
        if (list == null || list.isEmpty() || !list.get(0).j().p) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (RunnableC2396i runnableC2396i : list) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(N.a(runnableC2396i));
        }
        N.a("Dispatcher", "delivered", sb.toString());
    }
}
