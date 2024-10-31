package android.support.design.widget;

import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;

/* compiled from: AppBarLayout.java */
/* renamed from: android.support.design.widget.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0176b implements OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppBarLayout f467a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0176b(AppBarLayout appBarLayout) {
        this.f467a = appBarLayout;
    }

    @Override // android.support.v4.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return this.f467a.a(windowInsetsCompat);
    }
}
