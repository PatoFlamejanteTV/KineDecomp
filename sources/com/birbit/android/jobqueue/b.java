package com.birbit.android.jobqueue;

import android.content.Context;
import com.birbit.android.jobqueue.h.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: BatchingScheduler.java */
/* loaded from: classes.dex */
public class b extends com.birbit.android.jobqueue.h.a {

    /* renamed from: c */
    public static final long f8110c = TimeUnit.SECONDS.toMillis(900);

    /* renamed from: d */
    final long f8111d;

    /* renamed from: e */
    final long f8112e;

    /* renamed from: f */
    private final com.birbit.android.jobqueue.h.a f8113f;

    /* renamed from: g */
    private final List<a> f8114g;

    /* renamed from: h */
    private final com.birbit.android.jobqueue.i.b f8115h;

    /* compiled from: BatchingScheduler.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        final long f8116a;

        /* renamed from: b */
        final Long f8117b;

        /* renamed from: c */
        final com.birbit.android.jobqueue.h.b f8118c;

        public a(long j, Long l, com.birbit.android.jobqueue.h.b bVar) {
            this.f8116a = j;
            this.f8117b = l;
            this.f8118c = bVar;
        }
    }

    public b(com.birbit.android.jobqueue.h.a aVar, com.birbit.android.jobqueue.i.b bVar) {
        this(aVar, bVar, f8110c);
    }

    private boolean b(com.birbit.android.jobqueue.h.b bVar) {
        Long l;
        long b2 = this.f8115h.b();
        long nanos = TimeUnit.MILLISECONDS.toNanos(bVar.a()) + b2;
        Long l2 = null;
        Long valueOf = bVar.c() == null ? null : Long.valueOf(TimeUnit.MILLISECONDS.toNanos(bVar.c().longValue()) + b2);
        synchronized (this.f8114g) {
            Iterator<a> it = this.f8114g.iterator();
            while (it.hasNext()) {
                if (a(it.next(), bVar, nanos, valueOf)) {
                    return false;
                }
            }
            long a2 = ((bVar.a() / this.f8111d) + 1) * this.f8111d;
            bVar.a(a2);
            if (bVar.c() != null) {
                l = Long.valueOf(((bVar.c().longValue() / this.f8111d) + 1) * this.f8111d);
                bVar.a(l);
            } else {
                l = null;
            }
            List<a> list = this.f8114g;
            long nanos2 = TimeUnit.MILLISECONDS.toNanos(a2) + b2;
            if (l != null) {
                l2 = Long.valueOf(b2 + TimeUnit.MILLISECONDS.toNanos(l.longValue()));
            }
            list.add(new a(nanos2, l2, bVar));
            return true;
        }
    }

    private void c(com.birbit.android.jobqueue.h.b bVar) {
        synchronized (this.f8114g) {
            for (int size = this.f8114g.size() - 1; size >= 0; size--) {
                if (this.f8114g.get(size).f8118c.d().equals(bVar.d())) {
                    this.f8114g.remove(size);
                }
            }
        }
    }

    @Override // com.birbit.android.jobqueue.h.a
    public void a(Context context, a.InterfaceC0043a interfaceC0043a) {
        super.a(context, interfaceC0043a);
        this.f8113f.a(context, new com.birbit.android.jobqueue.a(this));
    }

    public b(com.birbit.android.jobqueue.h.a aVar, com.birbit.android.jobqueue.i.b bVar, long j) {
        this.f8114g = new ArrayList();
        this.f8113f = aVar;
        this.f8115h = bVar;
        this.f8111d = j;
        this.f8112e = TimeUnit.MILLISECONDS.toNanos(j);
    }

    private boolean a(a aVar, com.birbit.android.jobqueue.h.b bVar, long j, Long l) {
        if (aVar.f8118c.b() != bVar.b()) {
            return false;
        }
        if (l != null) {
            Long l2 = aVar.f8117b;
            if (l2 == null) {
                return false;
            }
            long longValue = l2.longValue() - l.longValue();
            if (longValue < 1 || longValue > this.f8112e) {
                return false;
            }
        } else if (aVar.f8117b != null) {
            return false;
        }
        long j2 = aVar.f8116a - j;
        return j2 > 0 && j2 <= this.f8112e;
    }

    @Override // com.birbit.android.jobqueue.h.a
    public void a(com.birbit.android.jobqueue.h.b bVar) {
        if (b(bVar)) {
            this.f8113f.a(bVar);
        }
    }

    @Override // com.birbit.android.jobqueue.h.a
    public void a(com.birbit.android.jobqueue.h.b bVar, boolean z) {
        c(bVar);
        this.f8113f.a(bVar, false);
        if (z) {
            a(bVar);
        }
    }

    @Override // com.birbit.android.jobqueue.h.a
    public void a() {
        synchronized (this.f8114g) {
            this.f8114g.clear();
        }
        this.f8113f.a();
    }
}
