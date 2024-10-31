package android.support.design.widget;

import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CoordinatorLayout.java */
/* renamed from: android.support.design.widget.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0188n implements OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CoordinatorLayout f483a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0188n(CoordinatorLayout coordinatorLayout) {
        this.f483a = coordinatorLayout;
    }

    @Override // android.support.v4.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return this.f483a.a(windowInsetsCompat);
    }
}
