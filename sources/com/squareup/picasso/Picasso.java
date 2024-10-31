package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.v4.internal.view.SupportMenu;
import android.widget.ImageView;
import com.squareup.picasso.AbstractC2388a;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public class Picasso {

    /* renamed from: a, reason: collision with root package name */
    static final Handler f25603a = new w(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    static volatile Picasso f25604b = null;

    /* renamed from: c, reason: collision with root package name */
    private final c f25605c;

    /* renamed from: d, reason: collision with root package name */
    private final d f25606d;

    /* renamed from: e, reason: collision with root package name */
    private final b f25607e;

    /* renamed from: f, reason: collision with root package name */
    private final List<E> f25608f;

    /* renamed from: g, reason: collision with root package name */
    final Context f25609g;

    /* renamed from: h, reason: collision with root package name */
    final q f25610h;
    final InterfaceC2398k i;
    final H j;
    final Map<Object, AbstractC2388a> k;
    final Map<ImageView, o> l;
    final ReferenceQueue<Object> m;
    final Bitmap.Config n;
    boolean o;
    volatile boolean p;
    boolean q;

    /* loaded from: classes3.dex */
    public enum LoadedFrom {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(SupportMenu.CATEGORY_MASK);

        final int debugColor;

        LoadedFrom(int i) {
            this.debugColor = i;
        }
    }

    /* loaded from: classes3.dex */
    public enum Priority {
        LOW,
        NORMAL,
        HIGH
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private final ReferenceQueue<Object> f25619a;

        /* renamed from: b, reason: collision with root package name */
        private final Handler f25620b;

        b(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.f25619a = referenceQueue;
            this.f25620b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    AbstractC2388a.C0131a c0131a = (AbstractC2388a.C0131a) this.f25619a.remove(1000L);
                    Message obtainMessage = this.f25620b.obtainMessage();
                    if (c0131a != null) {
                        obtainMessage.what = 3;
                        obtainMessage.obj = c0131a.f25630a;
                        this.f25620b.sendMessage(obtainMessage);
                    } else {
                        obtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e2) {
                    this.f25620b.post(new x(this, e2));
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(Picasso picasso, Uri uri, Exception exc);
    }

    /* loaded from: classes3.dex */
    public interface d {

        /* renamed from: a, reason: collision with root package name */
        public static final d f25621a = new y();

        C a(C c2);
    }

    Picasso(Context context, q qVar, InterfaceC2398k interfaceC2398k, c cVar, d dVar, List<E> list, H h2, Bitmap.Config config, boolean z, boolean z2) {
        this.f25609g = context;
        this.f25610h = qVar;
        this.i = interfaceC2398k;
        this.f25605c = cVar;
        this.f25606d = dVar;
        this.n = config;
        ArrayList arrayList = new ArrayList((list != null ? list.size() : 0) + 7);
        arrayList.add(new F(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new C2400m(context));
        arrayList.add(new MediaStoreRequestHandler(context));
        arrayList.add(new C2401n(context));
        arrayList.add(new C2389b(context));
        arrayList.add(new r(context));
        arrayList.add(new NetworkRequestHandler(qVar.f25658d, h2));
        this.f25608f = Collections.unmodifiableList(arrayList);
        this.j = h2;
        this.k = new WeakHashMap();
        this.l = new WeakHashMap();
        this.o = z;
        this.p = z2;
        this.m = new ReferenceQueue<>();
        this.f25607e = new b(this.m, f25603a);
        this.f25607e.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap b(String str) {
        Bitmap a2 = this.i.a(str);
        if (a2 != null) {
            this.j.b();
        } else {
            this.j.c();
        }
        return a2;
    }

    void c(AbstractC2388a abstractC2388a) {
        this.f25610h.b(abstractC2388a);
    }

    public void a(ImageView imageView) {
        b(imageView);
    }

    public void a(Object obj) {
        N.a();
        ArrayList arrayList = new ArrayList(this.k.values());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            AbstractC2388a abstractC2388a = (AbstractC2388a) arrayList.get(i);
            if (abstractC2388a.i().equals(obj)) {
                b(abstractC2388a.j());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f25611a;

        /* renamed from: b, reason: collision with root package name */
        private Downloader f25612b;

        /* renamed from: c, reason: collision with root package name */
        private ExecutorService f25613c;

        /* renamed from: d, reason: collision with root package name */
        private InterfaceC2398k f25614d;

        /* renamed from: e, reason: collision with root package name */
        private c f25615e;

        /* renamed from: f, reason: collision with root package name */
        private d f25616f;

        /* renamed from: g, reason: collision with root package name */
        private List<E> f25617g;

        /* renamed from: h, reason: collision with root package name */
        private Bitmap.Config f25618h;
        private boolean i;
        private boolean j;

        public a(Context context) {
            if (context != null) {
                this.f25611a = context.getApplicationContext();
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        public a a(Downloader downloader) {
            if (downloader != null) {
                if (this.f25612b == null) {
                    this.f25612b = downloader;
                    return this;
                }
                throw new IllegalStateException("Downloader already set.");
            }
            throw new IllegalArgumentException("Downloader must not be null.");
        }

        public a a(c cVar) {
            if (cVar != null) {
                if (this.f25615e == null) {
                    this.f25615e = cVar;
                    return this;
                }
                throw new IllegalStateException("Listener already set.");
            }
            throw new IllegalArgumentException("Listener must not be null.");
        }

        public Picasso a() {
            Context context = this.f25611a;
            if (this.f25612b == null) {
                this.f25612b = N.c(context);
            }
            if (this.f25614d == null) {
                this.f25614d = new t(context);
            }
            if (this.f25613c == null) {
                this.f25613c = new A();
            }
            if (this.f25616f == null) {
                this.f25616f = d.f25621a;
            }
            H h2 = new H(this.f25614d);
            return new Picasso(context, new q(context, this.f25613c, Picasso.f25603a, this.f25612b, this.f25614d, h2), this.f25614d, this.f25615e, this.f25616f, this.f25617g, h2, this.f25618h, this.i, this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(AbstractC2388a abstractC2388a) {
        Bitmap b2 = MemoryPolicy.shouldReadFromMemoryCache(abstractC2388a.f25626e) ? b(abstractC2388a.c()) : null;
        if (b2 != null) {
            a(b2, LoadedFrom.MEMORY, abstractC2388a);
            if (this.p) {
                N.a("Main", "completed", abstractC2388a.f25623b.d(), "from " + LoadedFrom.MEMORY);
                return;
            }
            return;
        }
        a(abstractC2388a);
        if (this.p) {
            N.a("Main", "resumed", abstractC2388a.f25623b.d());
        }
    }

    public D a(Uri uri) {
        return new D(this, uri, 0);
    }

    public D a(String str) {
        if (str == null) {
            return new D(this, null, 0);
        }
        if (str.trim().length() != 0) {
            return a(Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Object obj) {
        N.a();
        AbstractC2388a remove = this.k.remove(obj);
        if (remove != null) {
            remove.a();
            this.f25610h.a(remove);
        }
        if (obj instanceof ImageView) {
            o remove2 = this.l.remove((ImageView) obj);
            if (remove2 != null) {
                remove2.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<E> a() {
        return this.f25608f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C a(C c2) {
        this.f25606d.a(c2);
        if (c2 != null) {
            return c2;
        }
        throw new IllegalStateException("Request transformer " + this.f25606d.getClass().getCanonicalName() + " returned null for " + c2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImageView imageView, o oVar) {
        this.l.put(imageView, oVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AbstractC2388a abstractC2388a) {
        Object j = abstractC2388a.j();
        if (j != null && this.k.get(j) != abstractC2388a) {
            b(j);
            this.k.put(j, abstractC2388a);
        }
        c(abstractC2388a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RunnableC2396i runnableC2396i) {
        AbstractC2388a c2 = runnableC2396i.c();
        List<AbstractC2388a> d2 = runnableC2396i.d();
        boolean z = true;
        boolean z2 = (d2 == null || d2.isEmpty()) ? false : true;
        if (c2 == null && !z2) {
            z = false;
        }
        if (z) {
            Uri uri = runnableC2396i.e().f25547e;
            Exception f2 = runnableC2396i.f();
            Bitmap l = runnableC2396i.l();
            LoadedFrom h2 = runnableC2396i.h();
            if (c2 != null) {
                a(l, h2, c2);
            }
            if (z2) {
                int size = d2.size();
                for (int i = 0; i < size; i++) {
                    a(l, h2, d2.get(i));
                }
            }
            c cVar = this.f25605c;
            if (cVar == null || f2 == null) {
                return;
            }
            cVar.a(this, uri, f2);
        }
    }

    private void a(Bitmap bitmap, LoadedFrom loadedFrom, AbstractC2388a abstractC2388a) {
        if (abstractC2388a.k()) {
            return;
        }
        if (!abstractC2388a.l()) {
            this.k.remove(abstractC2388a.j());
        }
        if (bitmap == null) {
            abstractC2388a.b();
            if (this.p) {
                N.a("Main", "errored", abstractC2388a.f25623b.d());
                return;
            }
            return;
        }
        if (loadedFrom != null) {
            abstractC2388a.a(bitmap, loadedFrom);
            if (this.p) {
                N.a("Main", "completed", abstractC2388a.f25623b.d(), "from " + loadedFrom);
                return;
            }
            return;
        }
        throw new AssertionError("LoadedFrom cannot be null.");
    }
}
