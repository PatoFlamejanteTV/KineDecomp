package com.nexstreaming.app.general.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: UndoManager.java */
/* loaded from: classes.dex */
public abstract class y<UndoStep> {

    /* renamed from: a, reason: collision with root package name */
    private List<UndoStep> f3244a = new ArrayList();
    private List<UndoStep> b = new ArrayList();
    private UndoStep c = null;
    private int d = -1;
    private int e = -1;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;

    protected abstract int a(UndoStep undostep);

    protected abstract void a(UndoStep undostep, UndoStep undostep2);

    protected abstract void a(boolean z, boolean z2);

    public void a(int i) {
        this.e = i;
    }

    private boolean e() {
        if (this.f3244a.size() < 2) {
            return false;
        }
        if (this.d > -1 && this.f3244a.size() > this.d) {
            return true;
        }
        if (this.e <= -1) {
            return false;
        }
        Iterator<UndoStep> it = this.f3244a.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += a((y<UndoStep>) it.next());
        }
        return i > this.e;
    }

    public void b(UndoStep undostep) {
        if (!this.h) {
            this.f3244a.clear();
            this.b.clear();
            this.c = undostep;
            f();
        }
    }

    public void c(UndoStep undostep) {
        if (!this.h) {
            if (this.c != null) {
                this.f3244a.add(this.c);
                this.c = null;
                while (e()) {
                    this.f3244a.remove(0);
                }
            }
            this.c = undostep;
            this.b.clear();
            f();
        }
    }

    private void f() {
        if (this.g != d() || this.f != c()) {
            this.f = c();
            this.g = d();
            a(this.f, this.g);
        }
    }

    public void a() {
        if (c()) {
            this.b.add(this.c);
            UndoStep undostep = this.c;
            this.c = this.f3244a.remove(this.f3244a.size() - 1);
            b(this.c, undostep);
            f();
        }
    }

    private void b(UndoStep undostep, UndoStep undostep2) {
        if (!this.h) {
            this.h = true;
            a(undostep, undostep2);
            this.h = false;
        }
    }

    public void b() {
        if (d()) {
            this.f3244a.add(this.c);
            UndoStep undostep = this.c;
            this.c = this.b.remove(this.b.size() - 1);
            b(this.c, undostep);
            f();
        }
    }

    public boolean c() {
        return this.f3244a.size() > 0;
    }

    public boolean d() {
        return this.b.size() > 0;
    }
}
