package android.support.transition;

import android.support.transition.M;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionSet.java */
/* loaded from: classes.dex */
public class T extends M {
    private int M;
    private ArrayList<M> K = new ArrayList<>();
    private boolean L = true;
    private boolean N = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TransitionSet.java */
    /* loaded from: classes.dex */
    public static class a extends N {

        /* renamed from: a, reason: collision with root package name */
        T f559a;

        a(T t) {
            this.f559a = t;
        }

        @Override // android.support.transition.N, android.support.transition.M.c
        public void c(M m) {
            if (this.f559a.N) {
                return;
            }
            this.f559a.m();
            this.f559a.N = true;
        }

        @Override // android.support.transition.M.c
        public void d(M m) {
            T.c(this.f559a);
            if (this.f559a.M == 0) {
                this.f559a.N = false;
                this.f559a.a();
            }
            m.b(this);
        }
    }

    static /* synthetic */ int c(T t) {
        int i = t.M - 1;
        t.M = i;
        return i;
    }

    private void o() {
        a aVar = new a(this);
        Iterator<M> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
        this.M = this.K.size();
    }

    @Override // android.support.transition.M
    public void e(View view) {
        super.e(view);
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).e(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.transition.M
    public void l() {
        if (this.K.isEmpty()) {
            m();
            a();
            return;
        }
        o();
        if (!this.L) {
            for (int i = 1; i < this.K.size(); i++) {
                this.K.get(i - 1).a(new S(this, this.K.get(i)));
            }
            M m = this.K.get(0);
            if (m != null) {
                m.l();
                return;
            }
            return;
        }
        Iterator<M> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().l();
        }
    }

    public int n() {
        return this.K.size();
    }

    @Override // android.support.transition.M
    public void c(V v) {
        if (b(v.f561b)) {
            Iterator<M> it = this.K.iterator();
            while (it.hasNext()) {
                M next = it.next();
                if (next.b(v.f561b)) {
                    next.c(v);
                    v.f562c.add(next);
                }
            }
        }
    }

    @Override // android.support.transition.M
    /* renamed from: clone */
    public M mo1clone() {
        T t = (T) super.mo1clone();
        t.K = new ArrayList<>();
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            t.b(this.K.get(i).mo1clone());
        }
        return t;
    }

    @Override // android.support.transition.M
    public T d(View view) {
        for (int i = 0; i < this.K.size(); i++) {
            this.K.get(i).d(view);
        }
        super.d(view);
        return this;
    }

    public T b(int i) {
        if (i == 0) {
            this.L = true;
        } else if (i == 1) {
            this.L = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
        return this;
    }

    @Override // android.support.transition.M
    public /* bridge */ /* synthetic */ M a(long j) {
        a(j);
        return this;
    }

    public M a(int i) {
        if (i < 0 || i >= this.K.size()) {
            return null;
        }
        return this.K.get(i);
    }

    public T b(M m) {
        this.K.add(m);
        m.u = this;
        long j = this.f542f;
        if (j >= 0) {
            m.a(j);
        }
        return this;
    }

    @Override // android.support.transition.M
    public void c(View view) {
        super.c(view);
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).c(view);
        }
    }

    @Override // android.support.transition.M
    public T a(long j) {
        super.a(j);
        if (this.f542f >= 0) {
            int size = this.K.size();
            for (int i = 0; i < size; i++) {
                this.K.get(i).a(j);
            }
        }
        return this;
    }

    @Override // android.support.transition.M
    public T b(long j) {
        super.b(j);
        return this;
    }

    @Override // android.support.transition.M
    public T a(View view) {
        for (int i = 0; i < this.K.size(); i++) {
            this.K.get(i).a(view);
        }
        super.a(view);
        return this;
    }

    @Override // android.support.transition.M
    public T b(M.c cVar) {
        super.b(cVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.transition.M
    public void b(V v) {
        super.b(v);
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).b(v);
        }
    }

    @Override // android.support.transition.M
    public T a(M.c cVar) {
        super.a(cVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.transition.M
    public void a(ViewGroup viewGroup, W w, W w2, ArrayList<V> arrayList, ArrayList<V> arrayList2) {
        long f2 = f();
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            M m = this.K.get(i);
            if (f2 > 0 && (this.L || i == 0)) {
                long f3 = m.f();
                if (f3 > 0) {
                    m.b(f3 + f2);
                } else {
                    m.b(f2);
                }
            }
            m.a(viewGroup, w, w2, arrayList, arrayList2);
        }
    }

    @Override // android.support.transition.M
    public void a(V v) {
        if (b(v.f561b)) {
            Iterator<M> it = this.K.iterator();
            while (it.hasNext()) {
                M next = it.next();
                if (next.b(v.f561b)) {
                    next.a(v);
                    v.f562c.add(next);
                }
            }
        }
    }

    @Override // android.support.transition.M
    public void a(M.b bVar) {
        super.a(bVar);
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.transition.M
    public String a(String str) {
        String a2 = super.a(str);
        for (int i = 0; i < this.K.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append("\n");
            sb.append(this.K.get(i).a(str + "  "));
            a2 = sb.toString();
        }
        return a2;
    }
}
