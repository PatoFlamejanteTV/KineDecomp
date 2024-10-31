package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.g.a;
import android.support.v7.b.a;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.internal.view.menu.k;
import android.support.v7.internal.view.menu.l;
import android.support.v7.internal.widget.TintImageView;
import android.support.v7.widget.ActionMenuView;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* compiled from: ActionMenuPresenter.java */
/* loaded from: classes.dex */
public class a extends android.support.v7.internal.view.menu.b implements a.InterfaceC0009a {
    final f g;
    int h;
    private View i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private int s;
    private final SparseBooleanArray t;
    private View u;
    private e v;
    private C0020a w;
    private c x;
    private b y;

    public a(Context context) {
        super(context, a.g.abc_action_menu_layout, a.g.abc_action_menu_item_layout);
        this.t = new SparseBooleanArray();
        this.g = new f();
    }

    @Override // android.support.v7.internal.view.menu.b, android.support.v7.internal.view.menu.k
    public void a(Context context, android.support.v7.internal.view.menu.e eVar) {
        super.a(context, eVar);
        Resources resources = context.getResources();
        android.support.v7.internal.view.a a2 = android.support.v7.internal.view.a.a(context);
        if (!this.k) {
            this.j = a2.b();
        }
        if (!this.q) {
            this.l = a2.c();
        }
        if (!this.o) {
            this.n = a2.a();
        }
        int i = this.l;
        if (this.j) {
            if (this.i == null) {
                this.i = new d(this.f131a);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.i.getMeasuredWidth();
        } else {
            this.i = null;
        }
        this.m = i;
        this.s = (int) (56.0f * resources.getDisplayMetrics().density);
        this.u = null;
    }

    public void a(Configuration configuration) {
        if (!this.o) {
            this.n = this.b.getResources().getInteger(a.f.abc_max_action_buttons);
        }
        if (this.c != null) {
            this.c.b(true);
        }
    }

    public void a(int i, boolean z) {
        this.l = i;
        this.p = z;
        this.q = true;
    }

    public void c(boolean z) {
        this.j = z;
        this.k = true;
    }

    public void a(int i) {
        this.n = i;
        this.o = true;
    }

    public void d(boolean z) {
        this.r = z;
    }

    @Override // android.support.v7.internal.view.menu.b
    public android.support.v7.internal.view.menu.l a(ViewGroup viewGroup) {
        android.support.v7.internal.view.menu.l a2 = super.a(viewGroup);
        ((ActionMenuView) a2).setPresenter(this);
        return a2;
    }

    @Override // android.support.v7.internal.view.menu.b
    public View a(android.support.v7.internal.view.menu.f fVar, View view, ViewGroup viewGroup) {
        View actionView = fVar.getActionView();
        if (actionView == null || fVar.n()) {
            actionView = super.a(fVar, view, viewGroup);
        }
        actionView.setVisibility(fVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // android.support.v7.internal.view.menu.b
    public void a(android.support.v7.internal.view.menu.f fVar, l.a aVar) {
        aVar.a(fVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.y == null) {
            this.y = new b();
        }
        actionMenuItemView.setPopupCallback(this.y);
    }

    @Override // android.support.v7.internal.view.menu.b
    public boolean a(int i, android.support.v7.internal.view.menu.f fVar) {
        return fVar.j();
    }

    @Override // android.support.v7.internal.view.menu.b, android.support.v7.internal.view.menu.k
    public void b(boolean z) {
        boolean z2 = false;
        ViewGroup viewGroup = (ViewGroup) ((View) this.f).getParent();
        if (viewGroup != null) {
            android.support.v7.internal.b.a.a(viewGroup);
        }
        super.b(z);
        ((View) this.f).requestLayout();
        if (this.c != null) {
            ArrayList<android.support.v7.internal.view.menu.f> j = this.c.j();
            int size = j.size();
            for (int i = 0; i < size; i++) {
                android.support.v4.g.a a2 = j.get(i).a();
                if (a2 != null) {
                    a2.a(this);
                }
            }
        }
        ArrayList<android.support.v7.internal.view.menu.f> k = this.c != null ? this.c.k() : null;
        if (this.j && k != null) {
            int size2 = k.size();
            if (size2 == 1) {
                z2 = !k.get(0).isActionViewExpanded();
            } else {
                z2 = size2 > 0;
            }
        }
        if (z2) {
            if (this.i == null) {
                this.i = new d(this.f131a);
            }
            ViewGroup viewGroup2 = (ViewGroup) this.i.getParent();
            if (viewGroup2 != this.f) {
                if (viewGroup2 != null) {
                    viewGroup2.removeView(this.i);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.i, actionMenuView.b());
            }
        } else if (this.i != null && this.i.getParent() == this.f) {
            ((ViewGroup) this.f).removeView(this.i);
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.j);
    }

    @Override // android.support.v7.internal.view.menu.b
    public boolean a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.i) {
            return false;
        }
        return super.a(viewGroup, i);
    }

    @Override // android.support.v7.internal.view.menu.b, android.support.v7.internal.view.menu.k
    public boolean a(android.support.v7.internal.view.menu.o oVar) {
        if (!oVar.hasVisibleItems()) {
            return false;
        }
        android.support.v7.internal.view.menu.o oVar2 = oVar;
        while (oVar2.o() != this.c) {
            oVar2 = (android.support.v7.internal.view.menu.o) oVar2.o();
        }
        View a2 = a(oVar2.getItem());
        if (a2 == null) {
            if (this.i == null) {
                return false;
            }
            a2 = this.i;
        }
        this.h = oVar.getItem().getItemId();
        this.w = new C0020a(this, this.b, oVar);
        this.w.a(a2);
        this.w.a();
        super.a(oVar);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof l.a) && ((l.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean c() {
        if (!this.j || g() || this.c == null || this.f == null || this.x != null || this.c.k().isEmpty()) {
            return false;
        }
        this.x = new c(new e(this.b, this.c, this.i, true));
        ((View) this.f).post(this.x);
        super.a((android.support.v7.internal.view.menu.o) null);
        return true;
    }

    public boolean d() {
        if (this.x != null && this.f != null) {
            ((View) this.f).removeCallbacks(this.x);
            this.x = null;
            return true;
        }
        e eVar = this.v;
        if (eVar != null) {
            eVar.e();
            return true;
        }
        return false;
    }

    public boolean e() {
        return d() | f();
    }

    public boolean f() {
        if (this.w == null) {
            return false;
        }
        this.w.e();
        return true;
    }

    public boolean g() {
        return this.v != null && this.v.f();
    }

    @Override // android.support.v7.internal.view.menu.b, android.support.v7.internal.view.menu.k
    public boolean b() {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z2;
        ArrayList<android.support.v7.internal.view.menu.f> h = this.c.h();
        int size = h.size();
        int i9 = this.n;
        int i10 = this.m;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f;
        int i11 = 0;
        int i12 = 0;
        boolean z3 = false;
        int i13 = 0;
        while (i13 < size) {
            android.support.v7.internal.view.menu.f fVar = h.get(i13);
            if (fVar.l()) {
                i11++;
            } else if (fVar.k()) {
                i12++;
            } else {
                z3 = true;
            }
            i13++;
            i9 = (this.r && fVar.isActionViewExpanded()) ? 0 : i9;
        }
        if (this.j && (z3 || i11 + i12 > i9)) {
            i9--;
        }
        int i14 = i9 - i11;
        SparseBooleanArray sparseBooleanArray = this.t;
        sparseBooleanArray.clear();
        int i15 = 0;
        if (!this.p) {
            i = 0;
        } else {
            i15 = i10 / this.s;
            i = ((i10 % this.s) / i15) + this.s;
        }
        int i16 = 0;
        int i17 = 0;
        int i18 = i15;
        while (i16 < size) {
            android.support.v7.internal.view.menu.f fVar2 = h.get(i16);
            if (fVar2.l()) {
                View a2 = a(fVar2, this.u, viewGroup);
                if (this.u == null) {
                    this.u = a2;
                }
                if (this.p) {
                    i18 -= ActionMenuView.a(a2, i, i18, makeMeasureSpec, 0);
                } else {
                    a2.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i2 = a2.getMeasuredWidth();
                int i19 = i10 - i2;
                if (i17 != 0) {
                    i2 = i17;
                }
                int groupId = fVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                fVar2.d(true);
                i3 = i19;
                i4 = i14;
            } else if (fVar2.k()) {
                int groupId2 = fVar2.getGroupId();
                boolean z4 = sparseBooleanArray.get(groupId2);
                boolean z5 = (i14 > 0 || z4) && i10 > 0 && (!this.p || i18 > 0);
                if (z5) {
                    View a3 = a(fVar2, this.u, viewGroup);
                    if (this.u == null) {
                        this.u = a3;
                    }
                    if (this.p) {
                        int a4 = ActionMenuView.a(a3, i, i18, makeMeasureSpec, 0);
                        int i20 = i18 - a4;
                        z2 = a4 == 0 ? false : z5;
                        i8 = i20;
                    } else {
                        a3.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z6 = z5;
                        i8 = i18;
                        z2 = z6;
                    }
                    int measuredWidth = a3.getMeasuredWidth();
                    i10 -= measuredWidth;
                    if (i17 == 0) {
                        i17 = measuredWidth;
                    }
                    if (this.p) {
                        z = z2 & (i10 >= 0);
                        i5 = i17;
                        i6 = i8;
                    } else {
                        z = z2 & (i10 + i17 > 0);
                        i5 = i17;
                        i6 = i8;
                    }
                } else {
                    z = z5;
                    i5 = i17;
                    i6 = i18;
                }
                if (z && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                    i7 = i14;
                } else if (z4) {
                    sparseBooleanArray.put(groupId2, false);
                    int i21 = i14;
                    for (int i22 = 0; i22 < i16; i22++) {
                        android.support.v7.internal.view.menu.f fVar3 = h.get(i22);
                        if (fVar3.getGroupId() == groupId2) {
                            if (fVar3.j()) {
                                i21++;
                            }
                            fVar3.d(false);
                        }
                    }
                    i7 = i21;
                } else {
                    i7 = i14;
                }
                if (z) {
                    i7--;
                }
                fVar2.d(z);
                i2 = i5;
                i3 = i10;
                int i23 = i6;
                i4 = i7;
                i18 = i23;
            } else {
                fVar2.d(false);
                i2 = i17;
                i3 = i10;
                i4 = i14;
            }
            i16++;
            i10 = i3;
            i14 = i4;
            i17 = i2;
        }
        return true;
    }

    @Override // android.support.v7.internal.view.menu.b, android.support.v7.internal.view.menu.k
    public void a(android.support.v7.internal.view.menu.e eVar, boolean z) {
        e();
        super.a(eVar, z);
    }

    @Override // android.support.v4.g.a.InterfaceC0009a
    public void a(boolean z) {
        if (z) {
            super.a((android.support.v7.internal.view.menu.o) null);
        } else {
            this.c.a(false);
        }
    }

    public void a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ActionMenuPresenter.java */
    /* loaded from: classes.dex */
    public class d extends TintImageView implements ActionMenuView.a {
        private final float[] b;

        public d(Context context) {
            super(context, null, a.C0016a.actionOverflowButtonStyle);
            this.b = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new android.support.v7.widget.b(this, this, a.this));
        }

        @Override // android.view.View
        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                a.this.c();
            }
            return true;
        }

        @Override // android.support.v7.widget.ActionMenuView.a
        public boolean c() {
            return false;
        }

        @Override // android.support.v7.widget.ActionMenuView.a
        public boolean d() {
            return false;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                android.support.v4.b.a.a.a(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ActionMenuPresenter.java */
    /* loaded from: classes.dex */
    public class e extends android.support.v7.internal.view.menu.j {
        public e(Context context, android.support.v7.internal.view.menu.e eVar, View view, boolean z) {
            super(context, eVar, view, z, a.C0016a.actionOverflowMenuStyle);
            a(8388613);
            a(a.this.g);
        }

        @Override // android.support.v7.internal.view.menu.j, android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            super.onDismiss();
            a.this.c.close();
            a.this.v = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: android.support.v7.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0020a extends android.support.v7.internal.view.menu.j {
        final /* synthetic */ a c;
        private android.support.v7.internal.view.menu.o d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0020a(a aVar, Context context, android.support.v7.internal.view.menu.o oVar) {
            super(context, oVar, null, false, a.C0016a.actionOverflowMenuStyle);
            boolean z = false;
            this.c = aVar;
            this.d = oVar;
            if (!((android.support.v7.internal.view.menu.f) oVar.getItem()).j()) {
                a(aVar.i == null ? (View) aVar.f : aVar.i);
            }
            a(aVar.g);
            int size = oVar.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                MenuItem item = oVar.getItem(i);
                if (!item.isVisible() || item.getIcon() == null) {
                    i++;
                } else {
                    z = true;
                    break;
                }
            }
            a(z);
        }

        @Override // android.support.v7.internal.view.menu.j, android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            super.onDismiss();
            this.c.w = null;
            this.c.h = 0;
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* loaded from: classes.dex */
    private class f implements k.a {
        private f() {
        }

        @Override // android.support.v7.internal.view.menu.k.a
        public boolean a(android.support.v7.internal.view.menu.e eVar) {
            if (eVar == null) {
                return false;
            }
            a.this.h = ((android.support.v7.internal.view.menu.o) eVar).getItem().getItemId();
            k.a a2 = a.this.a();
            return a2 != null ? a2.a(eVar) : false;
        }

        @Override // android.support.v7.internal.view.menu.k.a
        public void a(android.support.v7.internal.view.menu.e eVar, boolean z) {
            if (eVar instanceof android.support.v7.internal.view.menu.o) {
                ((android.support.v7.internal.view.menu.o) eVar).l().a(false);
            }
            k.a a2 = a.this.a();
            if (a2 != null) {
                a2.a(eVar, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ActionMenuPresenter.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        private e b;

        public c(e eVar) {
            this.b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.c.e();
            View view = (View) a.this.f;
            if (view != null && view.getWindowToken() != null && this.b.d()) {
                a.this.v = this.b;
            }
            a.this.x = null;
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* loaded from: classes.dex */
    private class b extends ActionMenuItemView.b {
        private b() {
        }

        @Override // android.support.v7.internal.view.menu.ActionMenuItemView.b
        public android.support.v7.widget.f a() {
            if (a.this.w != null) {
                return a.this.w.c();
            }
            return null;
        }
    }
}
