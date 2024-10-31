package android.support.transition;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ViewGroupOverlayApi14.java */
/* loaded from: classes.dex */
public class X extends fa implements Z {
    public X(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    public static X a(ViewGroup viewGroup) {
        return (X) fa.c(viewGroup);
    }

    @Override // android.support.transition.Z
    public void b(View view) {
        this.f583a.b(view);
    }

    @Override // android.support.transition.Z
    public void a(View view) {
        this.f583a.a(view);
    }
}
