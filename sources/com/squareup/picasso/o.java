package com.squareup.picasso;

import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* compiled from: DeferredRequestCreator.java */
/* loaded from: classes3.dex */
public class o implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a */
    final D f25650a;

    /* renamed from: b */
    final WeakReference<ImageView> f25651b;

    /* renamed from: c */
    InterfaceC2399l f25652c;

    public o(D d2, ImageView imageView, InterfaceC2399l interfaceC2399l) {
        this.f25650a = d2;
        this.f25651b = new WeakReference<>(imageView);
        this.f25652c = interfaceC2399l;
        imageView.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public void a() {
        this.f25652c = null;
        ImageView imageView = this.f25651b.get();
        if (imageView == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this);
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        ImageView imageView = this.f25651b.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        if (width > 0 && height > 0) {
            viewTreeObserver.removeOnPreDrawListener(this);
            D d2 = this.f25650a;
            d2.a();
            d2.a(width, height);
            d2.a(imageView, this.f25652c);
        }
        return true;
    }
}
