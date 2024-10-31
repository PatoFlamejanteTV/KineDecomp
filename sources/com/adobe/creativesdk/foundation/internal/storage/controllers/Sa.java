package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Date;

/* compiled from: AssetListCellView.java */
/* loaded from: classes.dex */
public abstract class Sa {

    /* renamed from: a */
    protected static Typeface f5814a;

    /* renamed from: b */
    private static Context f5815b;
    protected RelativeLayout A;
    protected TextView B;
    protected RelativeLayout C;
    protected RelativeLayout D;
    protected ImageView E;
    protected RelativeLayout F;
    protected View G;
    protected View H;
    private int J;
    private boolean K;
    private String M;
    private WeakReference<InterfaceC0377dd> N;

    /* renamed from: c */
    protected View f5816c;

    /* renamed from: e */
    protected String f5818e;

    /* renamed from: f */
    protected String f5819f;

    /* renamed from: g */
    protected boolean f5820g;

    /* renamed from: h */
    protected TextView f5821h;
    protected TextView i;
    protected TextView j;
    protected TextView k;
    protected ImageView l;
    protected ImageView m;
    protected TextView n;
    protected ImageView o;
    protected ImageView p;
    protected TextView q;
    protected LinearLayout r;
    protected LinearLayout s;
    protected LinearLayout t;
    protected LinearLayout u;
    protected RelativeLayout v;
    protected LinearLayout w;
    protected RelativeLayout x;
    protected ImageView y;
    protected ImageView z;

    /* renamed from: d */
    protected boolean f5817d = false;
    protected float I = 1.0f;
    private boolean L = false;
    private boolean P = false;
    private boolean Q = false;
    private boolean O = false;

    public Sa() {
        if (f5814a == null) {
            f5814a = Typeface.createFromAsset(b().getAssets(), "fonts/AdobeClean-SemiLight.otf");
        }
    }

    public static void a(Context context) {
        f5815b = context;
    }

    private String e(int i) {
        if (i == 1) {
            return b().getResources().getString(c.a.a.a.b.i.adobe_csdk_folder_count_string_single);
        }
        return b().getResources().getString(c.a.a.a.b.i.adobe_csdk_folder_count_string_multiple);
    }

    private void y() {
        View view = this.H;
        if (view != null) {
            view.setVisibility((!this.O || r()) ? 8 : 0);
        }
    }

    public Context b() {
        return f5815b;
    }

    public abstract void b(View.OnClickListener onClickListener);

    public void c(int i) {
        this.J = i;
    }

    public void d(boolean z) {
        this.P = z;
    }

    public abstract View e();

    public int f() {
        return this.J;
    }

    public View g() {
        return this.f5816c;
    }

    public String h() {
        return this.f5818e;
    }

    public void i() {
    }

    protected void j() {
        w();
    }

    protected void k() {
        ImageView imageView = this.l;
        if (imageView != null) {
            ViewCompat.setAlpha(imageView, this.f5820g ? 0.3f : 1.0f);
        }
    }

    protected void l() {
    }

    protected abstract void m();

    public void n() {
    }

    protected void o() {
        View view = this.H;
        if (view == null) {
            return;
        }
        view.setSelected(this.f5817d);
        a();
    }

    protected void p() {
        this.f5821h.setText(this.f5818e);
    }

    public abstract void q();

    public boolean r() {
        return this.f5820g;
    }

    public boolean s() {
        return this.f5817d;
    }

    public void t() {
        m();
        n();
    }

    public void u() {
        this.f5819f = null;
        this.J = 0;
        this.f5818e = null;
        this.l.setVisibility(4);
        View view = this.H;
        if (view != null) {
            view.setVisibility(8);
        }
        this.f5820g = false;
        this.L = true;
        this.I = 1.0f;
        this.N = null;
        this.K = false;
    }

    protected abstract boolean v();

    protected void w() {
        if (v() && this.H != null) {
            InterfaceC0377dd interfaceC0377dd = this.N.get();
            if (interfaceC0377dd != null) {
                this.O = interfaceC0377dd.a();
                if (this.O) {
                    a(false);
                    this.H.setOnClickListener(new Qa(this));
                    return;
                }
                return;
            }
            return;
        }
        this.O = false;
    }

    public void x() {
        InterfaceC0377dd interfaceC0377dd = this.N.get();
        if (interfaceC0377dd != null) {
            interfaceC0377dd.a(this);
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.f5816c.setOnClickListener(onClickListener);
    }

    public void b(int i) {
        TextView textView = this.n;
        if (textView != null) {
            textView.setText(String.format(b().getResources().getString(c.a.a.a.b.i.adobe_csdk_photos_count_inside_collection), Integer.valueOf(i)));
        }
    }

    public void c(String str) {
        this.f5818e = str;
        p();
    }

    public String d() {
        return this.M;
    }

    private String d(int i) {
        if (i == 1) {
            return b().getResources().getString(c.a.a.a.b.i.adobe_csdk_file_count_string_single);
        }
        return b().getResources().getString(c.a.a.a.b.i.adobe_csdk_file_count_string_multiple);
    }

    public View a(int i) {
        return this.f5816c.findViewById(i);
    }

    public void a(View view) {
        this.f5816c = view;
    }

    public void b(boolean z) {
        this.f5820g = z;
        k();
    }

    public String c() {
        return this.f5819f;
    }

    public void a(InterfaceC0377dd interfaceC0377dd) {
        this.N = new WeakReference<>(interfaceC0377dd);
        if (interfaceC0377dd != null) {
            j();
        }
    }

    public void c(boolean z) {
        this.Q = z;
    }

    public void b(float f2) {
        ViewCompat.setAlpha(this.l, f2);
    }

    protected void a() {
        if (this.f5817d) {
            this.f5816c.setBackgroundColor(Color.rgb(237, 240, 241));
        } else {
            this.f5816c.setBackgroundColor(0);
        }
    }

    public void b(String str) {
        this.M = str;
    }

    public void a(boolean z) {
        this.f5817d = z;
        o();
    }

    public void a(long j) {
        if (this.i == null) {
            return;
        }
        this.i.setText(com.adobe.creativesdk.foundation.internal.utils.a.a(b(), j) + ", ");
    }

    public void a(Date date) {
        if (this.j == null) {
            return;
        }
        this.j.setText(com.adobe.creativesdk.foundation.internal.utils.a.a(b(), date));
    }

    public void a(String str) {
        this.f5819f = str;
        l();
    }

    public void a(Bitmap bitmap) {
        if (bitmap != null) {
            this.l.setImageBitmap(bitmap);
            if (bitmap.getWidth() <= 270 && bitmap.getHeight() <= 270) {
                this.l.setScaleType(ImageView.ScaleType.CENTER);
            } else {
                this.l.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        } else {
            this.l.setImageDrawable(null);
            this.l.setBackgroundColor(-1);
        }
        i();
    }

    public void a(Bitmap bitmap, float f2, boolean z) {
        this.L = false;
        this.l.setVisibility(0);
        this.K = bitmap != null;
        a(bitmap);
        y();
        if (z) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f5816c.getContext(), R.anim.fade_in);
            loadAnimation.setAnimationListener(new Ra(this, f2));
            loadAnimation.setDuration(200L);
            this.l.startAnimation(loadAnimation);
            return;
        }
        b(f2);
    }

    public void a(float f2) {
        this.I = f2;
    }

    public void a(LayoutInflater layoutInflater, int i, ViewGroup viewGroup) {
        a(layoutInflater.inflate(i, viewGroup, false));
        t();
    }

    public void a(int i, int i2) {
        if (this.k == null || b() == null) {
            return;
        }
        if (i == 0 && i2 == 0) {
            this.k.setVisibility(8);
            this.f5821h.setGravity(1);
            return;
        }
        this.f5821h.setGravity(0);
        this.k.setVisibility(0);
        if (i == 0) {
            this.k.setText(String.format(e(i2), Integer.valueOf(i2)));
            return;
        }
        if (i2 == 0) {
            this.k.setText(String.format(d(i), Integer.valueOf(i)));
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(d(i));
        stringBuffer.append(", ");
        stringBuffer.append(e(i2));
        this.k.setText(String.format(stringBuffer.toString(), Integer.valueOf(i), Integer.valueOf(i2)));
    }
}
