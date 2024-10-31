package com.nexstreaming.app.general.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: UndoManager.java */
/* loaded from: classes2.dex */
public abstract class M<UndoStep> {

    /* renamed from: a */
    private List<UndoStep> f19836a = new ArrayList();

    /* renamed from: b */
    private List<UndoStep> f19837b = new ArrayList();

    /* renamed from: c */
    private UndoStep f19838c = null;

    /* renamed from: d */
    private int f19839d = -1;

    /* renamed from: e */
    private int f19840e = -1;

    /* renamed from: f */
    private boolean f19841f = false;

    /* renamed from: g */
    private boolean f19842g = false;

    /* renamed from: h */
    private boolean f19843h = false;

    private void e() {
        if (this.f19842g == a() && this.f19841f == b()) {
            return;
        }
        this.f19841f = b();
        this.f19842g = a();
        a(this.f19841f, this.f19842g);
    }

    private boolean f() {
        if (this.f19836a.size() < 2) {
            return false;
        }
        if (this.f19839d > -1 && this.f19836a.size() > this.f19839d) {
            return true;
        }
        if (this.f19840e > -1) {
            Iterator<UndoStep> it = this.f19836a.iterator();
            int i = 0;
            while (it.hasNext()) {
                i += a((M<UndoStep>) it.next());
            }
            if (i > this.f19840e) {
                return true;
            }
        }
        return false;
    }

    protected abstract int a(UndoStep undostep);

    public void a(int i) {
        this.f19840e = i;
    }

    protected abstract void a(UndoStep undostep, UndoStep undostep2);

    protected abstract void a(boolean z, boolean z2);

    public void b(UndoStep undostep) {
        if (this.f19843h) {
            return;
        }
        this.f19836a.clear();
        this.f19837b.clear();
        this.f19838c = undostep;
        e();
    }

    public void c(UndoStep undostep) {
        if (this.f19843h) {
            return;
        }
        UndoStep undostep2 = this.f19838c;
        if (undostep2 != null) {
            this.f19836a.add(undostep2);
            this.f19838c = null;
            while (f()) {
                this.f19836a.remove(0);
            }
        }
        this.f19838c = undostep;
        this.f19837b.clear();
        e();
    }

    public void d() {
        if (b()) {
            this.f19837b.add(this.f19838c);
            UndoStep undostep = this.f19838c;
            this.f19838c = this.f19836a.remove(r1.size() - 1);
            b(this.f19838c, undostep);
            e();
        }
    }

    public boolean a() {
        return this.f19837b.size() > 0;
    }

    private void b(UndoStep undostep, UndoStep undostep2) {
        if (this.f19843h) {
            return;
        }
        this.f19843h = true;
        a(undostep, undostep2);
        this.f19843h = false;
    }

    public boolean b() {
        return this.f19836a.size() > 0;
    }

    public void c() {
        if (a()) {
            this.f19836a.add(this.f19838c);
            UndoStep undostep = this.f19838c;
            this.f19838c = this.f19837b.remove(r1.size() - 1);
            b(this.f19838c, undostep);
            e();
        }
    }
}
