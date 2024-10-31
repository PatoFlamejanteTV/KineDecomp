package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.g.l;
import com.bumptech.glide.g.n;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.request.SingleRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: RequestBuilder.java */
/* loaded from: classes.dex */
public class h<TranscodeType> extends com.bumptech.glide.request.a<h<TranscodeType>> implements Cloneable, f<h<TranscodeType>> {
    protected static final com.bumptech.glide.request.f A = new com.bumptech.glide.request.f().a(q.f8927c).a(Priority.LOW).a(true);
    private final Context B;
    private final j C;
    private final Class<TranscodeType> D;
    private final c E;
    private final e F;
    private k<?, ? super TranscodeType> G;
    private Object H;
    private List<com.bumptech.glide.request.e<TranscodeType>> I;
    private h<TranscodeType> J;
    private h<TranscodeType> K;
    private Float L;
    private boolean M = true;
    private boolean N;
    private boolean O;

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"CheckResult"})
    public h(c cVar, j jVar, Class<TranscodeType> cls, Context context) {
        this.E = cVar;
        this.C = jVar;
        this.D = cls;
        this.B = context;
        this.G = jVar.b(cls);
        this.F = cVar.f();
        a(jVar.c());
        a((com.bumptech.glide.request.a<?>) jVar.d());
    }

    @Override // com.bumptech.glide.request.a
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a a(com.bumptech.glide.request.a aVar) {
        return a((com.bumptech.glide.request.a<?>) aVar);
    }

    public h<TranscodeType> b(com.bumptech.glide.request.e<TranscodeType> eVar) {
        this.I = null;
        a((com.bumptech.glide.request.e) eVar);
        return this;
    }

    @SuppressLint({"CheckResult"})
    private void a(List<com.bumptech.glide.request.e<Object>> list) {
        Iterator<com.bumptech.glide.request.e<Object>> it = list.iterator();
        while (it.hasNext()) {
            a((com.bumptech.glide.request.e) it.next());
        }
    }

    public h<TranscodeType> b(float f2) {
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.L = Float.valueOf(f2);
            return this;
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @Override // com.bumptech.glide.request.a
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> mo7clone() {
        h<TranscodeType> hVar = (h) super.mo7clone();
        hVar.G = (k<?, ? super TranscodeType>) hVar.G.m8clone();
        return hVar;
    }

    @Override // com.bumptech.glide.request.a
    public h<TranscodeType> a(com.bumptech.glide.request.a<?> aVar) {
        l.a(aVar);
        return (h) super.a(aVar);
    }

    private h<TranscodeType> b(Object obj) {
        this.H = obj;
        this.N = true;
        return this;
    }

    public h<TranscodeType> a(k<?, ? super TranscodeType> kVar) {
        l.a(kVar);
        this.G = kVar;
        this.M = false;
        return this;
    }

    private <Y extends com.bumptech.glide.request.a.i<TranscodeType>> Y b(Y y, com.bumptech.glide.request.e<TranscodeType> eVar, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        l.a(y);
        if (this.N) {
            com.bumptech.glide.request.c a2 = a(y, eVar, aVar, executor);
            com.bumptech.glide.request.c request = y.getRequest();
            if (a2.a(request) && !a(aVar, request)) {
                a2.b();
                l.a(request);
                if (!request.isRunning()) {
                    request.a();
                }
                return y;
            }
            this.C.a((com.bumptech.glide.request.a.i<?>) y);
            y.a(a2);
            this.C.a(y, a2);
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    public h<TranscodeType> a(com.bumptech.glide.request.e<TranscodeType> eVar) {
        if (eVar != null) {
            if (this.I == null) {
                this.I = new ArrayList();
            }
            this.I.add(eVar);
        }
        return this;
    }

    public h<TranscodeType> a(Object obj) {
        b(obj);
        return this;
    }

    public h<TranscodeType> a(Bitmap bitmap) {
        b(bitmap);
        return a((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.f.b(q.f8926b));
    }

    public h<TranscodeType> a(String str) {
        b(str);
        return this;
    }

    public h<TranscodeType> a(Integer num) {
        b(num);
        return a((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.f.b(com.bumptech.glide.f.a.a(this.B)));
    }

    public <Y extends com.bumptech.glide.request.a.i<TranscodeType>> Y a(Y y) {
        a((h<TranscodeType>) y, (com.bumptech.glide.request.e) null, com.bumptech.glide.g.g.b());
        return y;
    }

    <Y extends com.bumptech.glide.request.a.i<TranscodeType>> Y a(Y y, com.bumptech.glide.request.e<TranscodeType> eVar, Executor executor) {
        b(y, eVar, this, executor);
        return y;
    }

    private boolean a(com.bumptech.glide.request.a<?> aVar, com.bumptech.glide.request.c cVar) {
        return !aVar.v() && cVar.isComplete();
    }

    public com.bumptech.glide.request.a.j<ImageView, TranscodeType> a(ImageView imageView) {
        com.bumptech.glide.request.a<?> aVar;
        n.a();
        l.a(imageView);
        if (!A() && y() && imageView.getScaleType() != null) {
            switch (g.f8488a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVar = mo7clone().D();
                    break;
                case 2:
                    aVar = mo7clone().E();
                    break;
                case 3:
                case 4:
                case 5:
                    aVar = mo7clone().F();
                    break;
                case 6:
                    aVar = mo7clone().E();
                    break;
            }
            com.bumptech.glide.request.a.j<ImageView, TranscodeType> a2 = this.F.a(imageView, this.D);
            b(a2, null, aVar, com.bumptech.glide.g.g.b());
            return a2;
        }
        aVar = this;
        com.bumptech.glide.request.a.j<ImageView, TranscodeType> a22 = this.F.a(imageView, this.D);
        b(a22, null, aVar, com.bumptech.glide.g.g.b());
        return a22;
    }

    private Priority b(Priority priority) {
        int i = g.f8489b[priority.ordinal()];
        if (i == 1) {
            return Priority.NORMAL;
        }
        if (i == 2) {
            return Priority.HIGH;
        }
        if (i != 3 && i != 4) {
            throw new IllegalArgumentException("unknown priority: " + n());
        }
        return Priority.IMMEDIATE;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.bumptech.glide.request.a] */
    private com.bumptech.glide.request.c b(com.bumptech.glide.request.a.i<TranscodeType> iVar, com.bumptech.glide.request.e<TranscodeType> eVar, com.bumptech.glide.request.d dVar, k<?, ? super TranscodeType> kVar, Priority priority, int i, int i2, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        h<TranscodeType> hVar = this.J;
        if (hVar != null) {
            if (!this.O) {
                k<?, ? super TranscodeType> kVar2 = hVar.M ? kVar : hVar.G;
                Priority n = this.J.w() ? this.J.n() : b(priority);
                int k = this.J.k();
                int j = this.J.j();
                if (n.b(i, i2) && !this.J.B()) {
                    k = aVar.k();
                    j = aVar.j();
                }
                int i3 = k;
                int i4 = j;
                com.bumptech.glide.request.i iVar2 = new com.bumptech.glide.request.i(dVar);
                com.bumptech.glide.request.c a2 = a(iVar, eVar, aVar, iVar2, kVar, priority, i, i2, executor);
                this.O = true;
                h hVar2 = (h<TranscodeType>) this.J;
                com.bumptech.glide.request.c a3 = hVar2.a(iVar, eVar, iVar2, kVar2, n, i3, i4, hVar2, executor);
                this.O = false;
                iVar2.a(a2, a3);
                return iVar2;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        if (this.L != null) {
            com.bumptech.glide.request.i iVar3 = new com.bumptech.glide.request.i(dVar);
            iVar3.a(a(iVar, eVar, aVar, iVar3, kVar, priority, i, i2, executor), a(iVar, eVar, aVar.mo7clone().a(this.L.floatValue()), iVar3, kVar, b(priority), i, i2, executor));
            return iVar3;
        }
        return a(iVar, eVar, aVar, dVar, kVar, priority, i, i2, executor);
    }

    private com.bumptech.glide.request.c a(com.bumptech.glide.request.a.i<TranscodeType> iVar, com.bumptech.glide.request.e<TranscodeType> eVar, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        return a(iVar, eVar, (com.bumptech.glide.request.d) null, this.G, aVar.n(), aVar.k(), aVar.j(), aVar, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.bumptech.glide.request.c a(com.bumptech.glide.request.a.i<TranscodeType> iVar, com.bumptech.glide.request.e<TranscodeType> eVar, com.bumptech.glide.request.d dVar, k<?, ? super TranscodeType> kVar, Priority priority, int i, int i2, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        com.bumptech.glide.request.d dVar2;
        com.bumptech.glide.request.d dVar3;
        if (this.K != null) {
            dVar3 = new com.bumptech.glide.request.b(dVar);
            dVar2 = dVar3;
        } else {
            dVar2 = null;
            dVar3 = dVar;
        }
        com.bumptech.glide.request.c b2 = b(iVar, eVar, dVar3, kVar, priority, i, i2, aVar, executor);
        if (dVar2 == null) {
            return b2;
        }
        int k = this.K.k();
        int j = this.K.j();
        if (n.b(i, i2) && !this.K.B()) {
            k = aVar.k();
            j = aVar.j();
        }
        h<TranscodeType> hVar = this.K;
        com.bumptech.glide.request.b bVar = dVar2;
        bVar.a(b2, hVar.a(iVar, eVar, dVar2, hVar.G, hVar.n(), k, j, this.K, executor));
        return bVar;
    }

    private com.bumptech.glide.request.c a(com.bumptech.glide.request.a.i<TranscodeType> iVar, com.bumptech.glide.request.e<TranscodeType> eVar, com.bumptech.glide.request.a<?> aVar, com.bumptech.glide.request.d dVar, k<?, ? super TranscodeType> kVar, Priority priority, int i, int i2, Executor executor) {
        Context context = this.B;
        e eVar2 = this.F;
        return SingleRequest.a(context, eVar2, this.H, this.D, aVar, i, i2, priority, iVar, eVar, this.I, dVar, eVar2.d(), kVar.a(), executor);
    }
}
