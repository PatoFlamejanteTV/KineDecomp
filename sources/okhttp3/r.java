package okhttp3;

import android.support.v7.widget.ActivityChooserView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.H;

/* compiled from: Dispatcher.java */
/* loaded from: classes3.dex */
public final class r {

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private Runnable f29205c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private ExecutorService f29206d;

    /* renamed from: a, reason: collision with root package name */
    private int f29203a = 64;

    /* renamed from: b, reason: collision with root package name */
    private int f29204b = 5;

    /* renamed from: e, reason: collision with root package name */
    private final Deque<H.a> f29207e = new ArrayDeque();

    /* renamed from: f, reason: collision with root package name */
    private final Deque<H.a> f29208f = new ArrayDeque();

    /* renamed from: g, reason: collision with root package name */
    private final Deque<H> f29209g = new ArrayDeque();

    private boolean c() {
        int i;
        boolean z;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<H.a> it = this.f29207e.iterator();
            while (it.hasNext()) {
                H.a next = it.next();
                if (this.f29208f.size() >= this.f29203a) {
                    break;
                }
                if (c(next) < this.f29204b) {
                    it.remove();
                    arrayList.add(next);
                    this.f29208f.add(next);
                }
            }
            z = b() > 0;
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((H.a) arrayList.get(i)).a(a());
        }
        return z;
    }

    public synchronized ExecutorService a() {
        if (this.f29206d == null) {
            this.f29206d = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60L, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.a.e.a("OkHttp Dispatcher", false));
        }
        return this.f29206d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(H.a aVar) {
        a(this.f29208f, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(H h2) {
        a(this.f29209g, h2);
    }

    public synchronized int b() {
        return this.f29208f.size() + this.f29209g.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(H.a aVar) {
        synchronized (this) {
            this.f29207e.add(aVar);
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(H h2) {
        this.f29209g.add(h2);
    }

    private <T> void a(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                runnable = this.f29205c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (c() || runnable == null) {
            return;
        }
        runnable.run();
    }

    private int c(H.a aVar) {
        int i = 0;
        for (H.a aVar2 : this.f29208f) {
            if (!aVar2.d().f28798f && aVar2.e().equals(aVar.e())) {
                i++;
            }
        }
        return i;
    }
}
