package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v7.internal.view.menu.k;
import android.support.v7.internal.view.menu.l;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* compiled from: BaseMenuPresenter.java */
/* loaded from: classes.dex */
public abstract class b implements k {

    /* renamed from: a, reason: collision with root package name */
    protected Context f131a;
    protected Context b;
    protected e c;
    protected LayoutInflater d;
    protected LayoutInflater e;
    protected l f;
    private k.a g;
    private int h;
    private int i;

    public abstract void a(f fVar, l.a aVar);

    public b(Context context, int i, int i2) {
        this.f131a = context;
        this.d = LayoutInflater.from(context);
        this.h = i;
        this.i = i2;
    }

    @Override // android.support.v7.internal.view.menu.k
    public void a(Context context, e eVar) {
        this.b = context;
        this.e = LayoutInflater.from(this.b);
        this.c = eVar;
    }

    public l a(ViewGroup viewGroup) {
        if (this.f == null) {
            this.f = (l) this.d.inflate(this.h, viewGroup, false);
            this.f.a(this.c);
            b(true);
        }
        return this.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v7.internal.view.menu.k
    public void b(boolean z) {
        int i;
        int i2;
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup != null) {
            if (this.c != null) {
                this.c.i();
                ArrayList<f> h = this.c.h();
                int size = h.size();
                int i3 = 0;
                i = 0;
                while (i3 < size) {
                    f fVar = h.get(i3);
                    if (a(i, fVar)) {
                        View childAt = viewGroup.getChildAt(i);
                        f itemData = childAt instanceof l.a ? ((l.a) childAt).getItemData() : null;
                        View a2 = a(fVar, childAt, viewGroup);
                        if (fVar != itemData) {
                            a2.setPressed(false);
                            android.support.v4.g.p.i(a2);
                        }
                        if (a2 != childAt) {
                            a(a2, i);
                        }
                        i2 = i + 1;
                    } else {
                        i2 = i;
                    }
                    i3++;
                    i = i2;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    protected void a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f).addView(view, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public void a(k.a aVar) {
        this.g = aVar;
    }

    public k.a a() {
        return this.g;
    }

    public l.a b(ViewGroup viewGroup) {
        return (l.a) this.d.inflate(this.i, viewGroup, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View a(f fVar, View view, ViewGroup viewGroup) {
        l.a aVar;
        if (view instanceof l.a) {
            aVar = (l.a) view;
        } else {
            aVar = b(viewGroup);
        }
        a(fVar, aVar);
        return (View) aVar;
    }

    public boolean a(int i, f fVar) {
        return true;
    }

    @Override // android.support.v7.internal.view.menu.k
    public void a(e eVar, boolean z) {
        if (this.g != null) {
            this.g.a(eVar, z);
        }
    }

    @Override // android.support.v7.internal.view.menu.k
    public boolean a(o oVar) {
        if (this.g != null) {
            return this.g.a(oVar);
        }
        return false;
    }

    @Override // android.support.v7.internal.view.menu.k
    public boolean b() {
        return false;
    }

    @Override // android.support.v7.internal.view.menu.k
    public boolean a(e eVar, f fVar) {
        return false;
    }

    @Override // android.support.v7.internal.view.menu.k
    public boolean b(e eVar, f fVar) {
        return false;
    }
}
