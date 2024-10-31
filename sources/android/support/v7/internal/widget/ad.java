package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.b.a;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* compiled from: ToolbarWidgetWrapper.java */
/* loaded from: classes.dex */
public class ad implements m {

    /* renamed from: a, reason: collision with root package name */
    private Toolbar f164a;
    private int b;
    private View c;
    private Drawable d;
    private Drawable e;
    private Drawable f;
    private boolean g;
    private CharSequence h;
    private CharSequence i;
    private CharSequence j;
    private Window.Callback k;
    private boolean l;
    private int m;
    private final ab n;
    private int o;
    private Drawable p;

    public ad(Toolbar toolbar, boolean z) {
        this(toolbar, z, a.h.abc_action_bar_up_description, a.d.abc_ic_ab_back_mtrl_am_alpha);
    }

    public ad(Toolbar toolbar, boolean z, int i, int i2) {
        this.m = 0;
        this.o = 0;
        this.f164a = toolbar;
        this.h = toolbar.getTitle();
        this.i = toolbar.getSubtitle();
        this.g = this.h != null;
        this.f = toolbar.getNavigationIcon();
        if (z) {
            ac a2 = ac.a(toolbar.getContext(), null, a.i.ActionBar, a.C0016a.actionBarStyle, 0);
            CharSequence b = a2.b(a.i.ActionBar_title);
            if (!TextUtils.isEmpty(b)) {
                b(b);
            }
            CharSequence b2 = a2.b(a.i.ActionBar_subtitle);
            if (!TextUtils.isEmpty(b2)) {
                c(b2);
            }
            Drawable a3 = a2.a(a.i.ActionBar_logo);
            if (a3 != null) {
                c(a3);
            }
            Drawable a4 = a2.a(a.i.ActionBar_icon);
            if (this.f == null && a4 != null) {
                a(a4);
            }
            Drawable a5 = a2.a(a.i.ActionBar_homeAsUpIndicator);
            if (a5 != null) {
                d(a5);
            }
            d(a2.a(a.i.ActionBar_displayOptions, 0));
            int f = a2.f(a.i.ActionBar_customNavigationLayout, 0);
            if (f != 0) {
                a(LayoutInflater.from(this.f164a.getContext()).inflate(f, (ViewGroup) this.f164a, false));
                d(this.b | 16);
            }
            int e = a2.e(a.i.ActionBar_height, 0);
            if (e > 0) {
                ViewGroup.LayoutParams layoutParams = this.f164a.getLayoutParams();
                layoutParams.height = e;
                this.f164a.setLayoutParams(layoutParams);
            }
            int c = a2.c(a.i.ActionBar_contentInsetStart, -1);
            int c2 = a2.c(a.i.ActionBar_contentInsetEnd, -1);
            if (c >= 0 || c2 >= 0) {
                this.f164a.a(Math.max(c, 0), Math.max(c2, 0));
            }
            int f2 = a2.f(a.i.ActionBar_titleTextStyle, 0);
            if (f2 != 0) {
                this.f164a.a(this.f164a.getContext(), f2);
            }
            int f3 = a2.f(a.i.ActionBar_subtitleTextStyle, 0);
            if (f3 != 0) {
                this.f164a.b(this.f164a.getContext(), f3);
            }
            int f4 = a2.f(a.i.ActionBar_popupTheme, 0);
            if (f4 != 0) {
                this.f164a.setPopupTheme(f4);
            }
            a2.b();
            this.n = a2.c();
        } else {
            this.b = d();
            this.n = ab.a(toolbar.getContext());
        }
        c(i);
        this.j = this.f164a.getNavigationContentDescription();
        b(this.n.a(i2));
        this.f164a.setNavigationOnClickListener(new ae(this));
    }

    public void c(int i) {
        if (i != this.o) {
            this.o = i;
            if (TextUtils.isEmpty(this.f164a.getNavigationContentDescription())) {
                e(this.o);
            }
        }
    }

    public void b(Drawable drawable) {
        if (this.p != drawable) {
            this.p = drawable;
            g();
        }
    }

    private int d() {
        if (this.f164a.getNavigationIcon() == null) {
            return 11;
        }
        return 15;
    }

    public Context c() {
        return this.f164a.getContext();
    }

    @Override // android.support.v7.internal.widget.m
    public boolean a() {
        return false;
    }

    @Override // android.support.v7.internal.widget.m
    public void a(Window.Callback callback) {
        this.k = callback;
    }

    @Override // android.support.v7.internal.widget.m
    public void a(CharSequence charSequence) {
        if (!this.g) {
            e(charSequence);
        }
    }

    @Override // android.support.v7.internal.widget.m
    public CharSequence b() {
        return this.f164a.getTitle();
    }

    public void b(CharSequence charSequence) {
        this.g = true;
        e(charSequence);
    }

    private void e(CharSequence charSequence) {
        this.h = charSequence;
        if ((this.b & 8) != 0) {
            this.f164a.setTitle(charSequence);
        }
    }

    public void c(CharSequence charSequence) {
        this.i = charSequence;
        if ((this.b & 8) != 0) {
            this.f164a.setSubtitle(charSequence);
        }
    }

    @Override // android.support.v7.internal.widget.m
    public void a(int i) {
        a(i != 0 ? this.n.a(i) : null);
    }

    @Override // android.support.v7.internal.widget.m
    public void a(Drawable drawable) {
        this.d = drawable;
        e();
    }

    @Override // android.support.v7.internal.widget.m
    public void b(int i) {
        c(i != 0 ? this.n.a(i) : null);
    }

    public void c(Drawable drawable) {
        this.e = drawable;
        e();
    }

    private void e() {
        Drawable drawable = null;
        if ((this.b & 2) != 0) {
            if ((this.b & 1) != 0) {
                drawable = this.e != null ? this.e : this.d;
            } else {
                drawable = this.d;
            }
        }
        this.f164a.setLogo(drawable);
    }

    public void d(int i) {
        int i2 = this.b ^ i;
        this.b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    g();
                    f();
                } else {
                    this.f164a.setNavigationIcon((Drawable) null);
                }
            }
            if ((i2 & 3) != 0) {
                e();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f164a.setTitle(this.h);
                    this.f164a.setSubtitle(this.i);
                } else {
                    this.f164a.setTitle((CharSequence) null);
                    this.f164a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) != 0 && this.c != null) {
                if ((i & 16) != 0) {
                    this.f164a.addView(this.c);
                } else {
                    this.f164a.removeView(this.c);
                }
            }
        }
    }

    public void a(View view) {
        if (this.c != null && (this.b & 16) != 0) {
            this.f164a.removeView(this.c);
        }
        this.c = view;
        if (view != null && (this.b & 16) != 0) {
            this.f164a.addView(this.c);
        }
    }

    public void d(Drawable drawable) {
        this.f = drawable;
        g();
    }

    public void d(CharSequence charSequence) {
        this.j = charSequence;
        f();
    }

    public void e(int i) {
        d(i == 0 ? null : c().getString(i));
    }

    private void f() {
        if ((this.b & 4) != 0) {
            if (TextUtils.isEmpty(this.j)) {
                this.f164a.setNavigationContentDescription(this.o);
            } else {
                this.f164a.setNavigationContentDescription(this.j);
            }
        }
    }

    private void g() {
        if ((this.b & 4) != 0) {
            this.f164a.setNavigationIcon(this.f != null ? this.f : this.p);
        }
    }
}
