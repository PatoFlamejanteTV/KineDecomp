package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import java.util.LinkedList;

/* loaded from: classes.dex */
public abstract class zza<T extends LifecycleDelegate> {

    /* renamed from: a, reason: collision with root package name */
    private T f1208a;
    private Bundle b;
    private LinkedList<a> c;
    private final zzf<T> d = new com.google.android.gms.dynamic.a(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface a {
        int a();

        void a(LifecycleDelegate lifecycleDelegate);
    }

    private void a(int i) {
        while (!this.c.isEmpty() && this.c.getLast().a() >= i) {
            this.c.removeLast();
        }
    }

    private void a(Bundle bundle, a aVar) {
        if (this.f1208a != null) {
            aVar.a(this.f1208a);
            return;
        }
        if (this.c == null) {
            this.c = new LinkedList<>();
        }
        this.c.add(aVar);
        if (bundle != null) {
            if (this.b == null) {
                this.b = (Bundle) bundle.clone();
            } else {
                this.b.putAll(bundle);
            }
        }
        a(this.d);
    }

    public static void b(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        int a2 = GooglePlayServicesUtil.a(context);
        String a3 = com.google.android.gms.common.internal.zzg.a(context, a2, GooglePlayServicesUtil.f(context));
        String b = com.google.android.gms.common.internal.zzg.b(context, a2);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(a3);
        linearLayout.addView(textView);
        if (b != null) {
            Button button = new Button(context);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(b);
            linearLayout.addView(button);
            button.setOnClickListener(new e(context, a2));
        }
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        a(bundle, new d(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.f1208a == null) {
            a(frameLayout);
        }
        return frameLayout;
    }

    public T a() {
        return this.f1208a;
    }

    public void a(Activity activity, Bundle bundle, Bundle bundle2) {
        a(bundle2, new b(this, activity, bundle, bundle2));
    }

    public void a(Bundle bundle) {
        a(bundle, new c(this, bundle));
    }

    protected void a(FrameLayout frameLayout) {
        b(frameLayout);
    }

    protected abstract void a(zzf<T> zzfVar);

    public void b() {
        a((Bundle) null, new f(this));
    }

    public void b(Bundle bundle) {
        if (this.f1208a != null) {
            this.f1208a.b(bundle);
        } else if (this.b != null) {
            bundle.putAll(this.b);
        }
    }

    public void c() {
        a((Bundle) null, new g(this));
    }

    public void d() {
        if (this.f1208a != null) {
            this.f1208a.c();
        } else {
            a(5);
        }
    }

    public void e() {
        if (this.f1208a != null) {
            this.f1208a.d();
        } else {
            a(4);
        }
    }

    public void f() {
        if (this.f1208a != null) {
            this.f1208a.e();
        } else {
            a(2);
        }
    }

    public void g() {
        if (this.f1208a != null) {
            this.f1208a.f();
        } else {
            a(1);
        }
    }

    public void h() {
        if (this.f1208a != null) {
            this.f1208a.g();
        }
    }
}
