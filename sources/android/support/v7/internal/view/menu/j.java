package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.b.a;
import android.support.v7.internal.view.menu.k;
import android.support.v7.internal.view.menu.l;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import java.util.ArrayList;

/* compiled from: MenuPopupHelper.java */
/* loaded from: classes.dex */
public class j implements k, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {

    /* renamed from: a */
    static final int f140a = a.g.abc_popup_menu_item_layout;
    boolean b;
    private final Context c;
    private final LayoutInflater d;
    private final e e;
    private final a f;
    private final boolean g;
    private final int h;
    private final int i;
    private final int j;
    private View k;
    private android.support.v7.widget.f l;
    private ViewTreeObserver m;
    private k.a n;
    private ViewGroup o;
    private boolean p;
    private int q;
    private int r;

    public j(Context context, e eVar, View view) {
        this(context, eVar, view, false, a.C0016a.popupMenuStyle);
    }

    public j(Context context, e eVar, View view, boolean z, int i) {
        this(context, eVar, view, z, i, 0);
    }

    public j(Context context, e eVar, View view, boolean z, int i, int i2) {
        this.r = 0;
        this.c = context;
        this.d = LayoutInflater.from(context);
        this.e = eVar;
        this.f = new a(this.e);
        this.g = z;
        this.i = i;
        this.j = i2;
        Resources resources = context.getResources();
        this.h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.c.abc_config_prefDialogWidth));
        this.k = view;
        eVar.a(this, context);
    }

    public void a(View view) {
        this.k = view;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void a(int i) {
        this.r = i;
    }

    public void a() {
        if (!d()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public android.support.v7.widget.f c() {
        return this.l;
    }

    public boolean d() {
        this.l = new android.support.v7.widget.f(this.c, null, this.i, this.j);
        this.l.a((PopupWindow.OnDismissListener) this);
        this.l.a((AdapterView.OnItemClickListener) this);
        this.l.a(this.f);
        this.l.a(true);
        View view = this.k;
        if (view == null) {
            return false;
        }
        boolean z = this.m == null;
        this.m = view.getViewTreeObserver();
        if (z) {
            this.m.addOnGlobalLayoutListener(this);
        }
        this.l.a(view);
        this.l.b(this.r);
        if (!this.p) {
            this.q = g();
            this.p = true;
        }
        this.l.d(this.q);
        this.l.e(2);
        this.l.c();
        this.l.g().setOnKeyListener(this);
        return true;
    }

    public void e() {
        if (f()) {
            this.l.a();
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.l = null;
        this.e.close();
        if (this.m != null) {
            if (!this.m.isAlive()) {
                this.m = this.k.getViewTreeObserver();
            }
            this.m.removeGlobalOnLayoutListener(this);
            this.m = null;
        }
    }

    public boolean f() {
        return this.l != null && this.l.b();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a aVar = this.f;
        aVar.b.a(aVar.getItem(i), 0);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        e();
        return true;
    }

    private int g() {
        View view;
        a aVar = this.f;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = aVar.getCount();
        int i = 0;
        int i2 = 0;
        View view2 = null;
        int i3 = 0;
        while (i < count) {
            int itemViewType = aVar.getItemViewType(i);
            if (itemViewType != i2) {
                i2 = itemViewType;
                view = null;
            } else {
                view = view2;
            }
            if (this.o == null) {
                this.o = new FrameLayout(this.c);
            }
            view2 = aVar.getView(i, view, this.o);
            view2.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view2.getMeasuredWidth();
            if (measuredWidth >= this.h) {
                return this.h;
            }
            if (measuredWidth <= i3) {
                measuredWidth = i3;
            }
            i++;
            i3 = measuredWidth;
        }
        return i3;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (f()) {
            View view = this.k;
            if (view == null || !view.isShown()) {
                e();
            } else if (f()) {
                this.l.c();
            }
        }
    }

    @Override // android.support.v7.internal.view.menu.k
    public void a(Context context, e eVar) {
    }

    @Override // android.support.v7.internal.view.menu.k
    public void b(boolean z) {
        this.p = false;
        if (this.f != null) {
            this.f.notifyDataSetChanged();
        }
    }

    public void a(k.a aVar) {
        this.n = aVar;
    }

    @Override // android.support.v7.internal.view.menu.k
    public boolean a(o oVar) {
        boolean z;
        if (oVar.hasVisibleItems()) {
            j jVar = new j(this.c, oVar, this.k);
            jVar.a(this.n);
            int size = oVar.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = false;
                    break;
                }
                MenuItem item = oVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i++;
            }
            jVar.a(z);
            if (jVar.d()) {
                if (this.n == null) {
                    return true;
                }
                this.n.a(oVar);
                return true;
            }
        }
        return false;
    }

    @Override // android.support.v7.internal.view.menu.k
    public void a(e eVar, boolean z) {
        if (eVar == this.e) {
            e();
            if (this.n != null) {
                this.n.a(eVar, z);
            }
        }
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

    /* compiled from: MenuPopupHelper.java */
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private e b;
        private int c = -1;

        public a(e eVar) {
            this.b = eVar;
            a();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<f> k = j.this.g ? this.b.k() : this.b.h();
            if (this.c < 0) {
                return k.size();
            }
            return k.size() - 1;
        }

        @Override // android.widget.Adapter
        /* renamed from: a */
        public f getItem(int i) {
            ArrayList<f> k = j.this.g ? this.b.k() : this.b.h();
            if (this.c >= 0 && i >= this.c) {
                i++;
            }
            return k.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = view == null ? j.this.d.inflate(j.f140a, viewGroup, false) : view;
            l.a aVar = (l.a) inflate;
            if (j.this.b) {
                ((ListMenuItemView) inflate).setForceShowIcon(true);
            }
            aVar.a(getItem(i), 0);
            return inflate;
        }

        void a() {
            f n = j.this.e.n();
            if (n != null) {
                ArrayList<f> k = j.this.e.k();
                int size = k.size();
                for (int i = 0; i < size; i++) {
                    if (k.get(i) == n) {
                        this.c = i;
                        return;
                    }
                }
            }
            this.c = -1;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }
}
