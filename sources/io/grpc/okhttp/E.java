package io.grpc.okhttp;

import android.support.v4.app.NotificationCompat;
import android.support.v4.internal.view.SupportMenu;
import android.support.v7.widget.ActivityChooserView;
import com.facebook.share.internal.ShareConstants;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OutboundFlowController.java */
/* loaded from: classes3.dex */
public class E {

    /* renamed from: a, reason: collision with root package name */
    private final w f27826a;

    /* renamed from: b, reason: collision with root package name */
    private final io.grpc.okhttp.internal.framed.b f27827b;

    /* renamed from: c, reason: collision with root package name */
    private int f27828c = SupportMenu.USER_MASK;

    /* renamed from: d, reason: collision with root package name */
    private final a f27829d = new a(0);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OutboundFlowController.java */
    /* loaded from: classes3.dex */
    public final class a {

        /* renamed from: a, reason: collision with root package name */
        final Queue<C0158a> f27830a;

        /* renamed from: b, reason: collision with root package name */
        final int f27831b;

        /* renamed from: c, reason: collision with root package name */
        int f27832c;

        /* renamed from: d, reason: collision with root package name */
        int f27833d;

        /* renamed from: e, reason: collision with root package name */
        int f27834e;

        /* renamed from: f, reason: collision with root package name */
        s f27835f;

        a(int i) {
            this.f27833d = E.this.f27828c;
            this.f27831b = i;
            this.f27830a = new ArrayDeque(2);
        }

        private C0158a h() {
            return this.f27830a.peek();
        }

        void a(int i) {
            this.f27834e += i;
        }

        void b() {
            this.f27834e = 0;
        }

        boolean c() {
            return !this.f27830a.isEmpty();
        }

        int d() {
            return Math.max(0, Math.min(this.f27833d, this.f27832c));
        }

        int e() {
            return d() - this.f27834e;
        }

        int f() {
            return this.f27833d;
        }

        int g() {
            return Math.min(this.f27833d, E.this.f27829d.f());
        }

        int a() {
            return this.f27834e;
        }

        int b(int i) {
            if (i > 0 && ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i < this.f27833d) {
                throw new IllegalArgumentException("Window size overflow for stream: " + this.f27831b);
            }
            this.f27833d += i;
            return this.f27833d;
        }

        C0158a a(okio.g gVar, boolean z) {
            return new C0158a(gVar, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: OutboundFlowController.java */
        /* renamed from: io.grpc.okhttp.E$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public final class C0158a {

            /* renamed from: a, reason: collision with root package name */
            final okio.g f27837a;

            /* renamed from: b, reason: collision with root package name */
            final boolean f27838b;

            /* renamed from: c, reason: collision with root package name */
            boolean f27839c;

            C0158a(okio.g gVar, boolean z) {
                this.f27837a = gVar;
                this.f27838b = z;
            }

            void a() {
                if (this.f27839c) {
                    return;
                }
                this.f27839c = true;
                a.this.f27830a.offer(this);
                a.this.f27832c += b();
            }

            int b() {
                return (int) this.f27837a.size();
            }

            void c() {
                do {
                    int b2 = b();
                    int min = Math.min(b2, E.this.f27827b.t());
                    if (min == b2) {
                        int i = -b2;
                        E.this.f27829d.b(i);
                        a.this.b(i);
                        try {
                            E.this.f27827b.a(this.f27838b, a.this.f27831b, this.f27837a, b2);
                            a.this.f27835f.d().a(b2);
                            if (this.f27839c) {
                                a aVar = a.this;
                                aVar.f27832c -= b2;
                                aVar.f27830a.remove(this);
                                return;
                            }
                            return;
                        } catch (IOException e2) {
                            throw new RuntimeException(e2);
                        }
                    }
                    a(min).c();
                } while (b() > 0);
            }

            C0158a a(int i) {
                int min = Math.min(i, (int) this.f27837a.size());
                okio.g gVar = new okio.g();
                gVar.a(this.f27837a, min);
                C0158a c0158a = new C0158a(gVar, false);
                if (this.f27839c) {
                    a.this.f27832c -= min;
                }
                return c0158a;
            }
        }

        int a(int i, b bVar) {
            int min = Math.min(i, g());
            int i2 = 0;
            while (c()) {
                C0158a h2 = h();
                if (min >= h2.b()) {
                    bVar.b();
                    i2 += h2.b();
                    h2.c();
                } else {
                    if (min <= 0) {
                        break;
                    }
                    C0158a a2 = h2.a(min);
                    bVar.b();
                    i2 += a2.b();
                    a2.c();
                }
                min = Math.min(i - i2, g());
            }
            return i2;
        }

        a(E e2, s sVar) {
            this(sVar.k());
            this.f27835f = sVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OutboundFlowController.java */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        int f27841a;

        private b() {
        }

        boolean a() {
            return this.f27841a > 0;
        }

        void b() {
            this.f27841a++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public E(w wVar, io.grpc.okhttp.internal.framed.b bVar) {
        Preconditions.a(wVar, NotificationCompat.CATEGORY_TRANSPORT);
        this.f27826a = wVar;
        Preconditions.a(bVar, "frameWriter");
        this.f27827b = bVar;
    }

    private void b() {
        int i;
        s[] c2 = this.f27826a.c();
        int f2 = this.f27829d.f();
        int length = c2.length;
        while (true) {
            i = 0;
            if (length <= 0 || f2 <= 0) {
                break;
            }
            int ceil = (int) Math.ceil(f2 / length);
            int i2 = 0;
            while (i < length && f2 > 0) {
                s sVar = c2[i];
                a a2 = a(sVar);
                int min = Math.min(f2, Math.min(a2.e(), ceil));
                if (min > 0) {
                    a2.a(min);
                    f2 -= min;
                }
                if (a2.e() > 0) {
                    c2[i2] = sVar;
                    i2++;
                }
                i++;
            }
            length = i2;
        }
        b bVar = new b();
        s[] c3 = this.f27826a.c();
        int length2 = c3.length;
        while (i < length2) {
            a a3 = a(c3[i]);
            a3.a(a3.a(), bVar);
            a3.b();
            i++;
        }
        if (bVar.a()) {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        if (i >= 0) {
            int i2 = i - this.f27828c;
            this.f27828c = i;
            for (s sVar : this.f27826a.c()) {
                a aVar = (a) sVar.i();
                if (aVar == null) {
                    sVar.a(new a(this, sVar));
                } else {
                    aVar.b(i2);
                }
            }
            if (i2 > 0) {
                b();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid initial window size: " + i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(@Nullable s sVar, int i) {
        if (sVar == null) {
            int b2 = this.f27829d.b(i);
            b();
            return b2;
        }
        a a2 = a(sVar);
        int b3 = a2.b(i);
        b bVar = new b();
        a2.a(a2.g(), bVar);
        if (bVar.a()) {
            a();
        }
        return b3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z, int i, okio.g gVar, boolean z2) {
        Preconditions.a(gVar, ShareConstants.FEED_SOURCE_PARAM);
        s a2 = this.f27826a.a(i);
        if (a2 == null) {
            return;
        }
        a a3 = a(a2);
        int g2 = a3.g();
        boolean c2 = a3.c();
        a.C0158a a4 = a3.a(gVar, z);
        if (!c2 && g2 >= a4.b()) {
            a4.c();
            if (z2) {
                a();
                return;
            }
            return;
        }
        a4.a();
        if (c2 || g2 <= 0) {
            if (z2) {
                a();
            }
        } else {
            a4.a(g2).c();
            if (z2) {
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        try {
            this.f27827b.flush();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private a a(s sVar) {
        a aVar = (a) sVar.i();
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(this, sVar);
        sVar.a(aVar2);
        return aVar2;
    }
}
