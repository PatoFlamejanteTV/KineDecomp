package android.support.v7.internal.widget;

import android.R;
import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ToolbarWidgetWrapper.java */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final android.support.v7.internal.view.menu.a f165a;
    final /* synthetic */ ad b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        Toolbar toolbar;
        CharSequence charSequence;
        this.b = adVar;
        toolbar = this.b.f164a;
        Context context = toolbar.getContext();
        charSequence = this.b.h;
        this.f165a = new android.support.v7.internal.view.menu.a(context, 0, R.id.home, 0, 0, charSequence);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Window.Callback callback;
        boolean z;
        Window.Callback callback2;
        callback = this.b.k;
        if (callback != null) {
            z = this.b.l;
            if (z) {
                callback2 = this.b.k;
                callback2.onMenuItemSelected(0, this.f165a);
            }
        }
    }
}
