package com.birbit.android.jobqueue.a;

import com.birbit.android.jobqueue.h;
import com.birbit.android.jobqueue.p;
import com.birbit.android.jobqueue.v;
import java.util.Set;

/* compiled from: CachedJobQueue.java */
/* loaded from: classes.dex */
public class a implements v {

    /* renamed from: a */
    private v f8108a;

    /* renamed from: b */
    private Integer f8109b;

    public a(v vVar) {
        this.f8108a = vVar;
    }

    @Override // com.birbit.android.jobqueue.v
    public boolean a(p pVar) {
        a();
        return this.f8108a.a(pVar);
    }

    @Override // com.birbit.android.jobqueue.v
    public void b(p pVar) {
        a();
        this.f8108a.b(pVar);
    }

    @Override // com.birbit.android.jobqueue.v
    public int c(h hVar) {
        if (b()) {
            return 0;
        }
        return this.f8108a.c(hVar);
    }

    @Override // com.birbit.android.jobqueue.v
    public void clear() {
        a();
        this.f8108a.clear();
    }

    @Override // com.birbit.android.jobqueue.v
    public int count() {
        if (this.f8109b == null) {
            this.f8109b = Integer.valueOf(this.f8108a.count());
        }
        return this.f8109b.intValue();
    }

    @Override // com.birbit.android.jobqueue.v
    public boolean d(p pVar) {
        a();
        return this.f8108a.d(pVar);
    }

    private void a() {
        this.f8109b = null;
    }

    private boolean b() {
        Integer num = this.f8109b;
        return num != null && num.intValue() == 0;
    }

    @Override // com.birbit.android.jobqueue.v
    public void c(p pVar) {
        a();
        this.f8108a.c(pVar);
    }

    @Override // com.birbit.android.jobqueue.v
    public p d(h hVar) {
        Integer num;
        if (b()) {
            return null;
        }
        p d2 = this.f8108a.d(hVar);
        if (d2 != null && (num = this.f8109b) != null) {
            this.f8109b = Integer.valueOf(num.intValue() - 1);
        }
        return d2;
    }

    @Override // com.birbit.android.jobqueue.v
    public void a(p pVar, p pVar2) {
        a();
        this.f8108a.a(pVar, pVar2);
    }

    @Override // com.birbit.android.jobqueue.v
    public Long b(h hVar) {
        return this.f8108a.b(hVar);
    }

    @Override // com.birbit.android.jobqueue.v
    public Set<p> a(h hVar) {
        return this.f8108a.a(hVar);
    }

    @Override // com.birbit.android.jobqueue.v
    public p a(String str) {
        return this.f8108a.a(str);
    }
}
