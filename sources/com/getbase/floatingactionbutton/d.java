package com.getbase.floatingactionbutton;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.animation.OvershootInterpolator;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

/* compiled from: FloatingActionsMenu.java */
/* loaded from: classes.dex */
public class d extends b {
    final /* synthetic */ FloatingActionsMenu n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(FloatingActionsMenu floatingActionsMenu, Context context) {
        super(context);
        this.n = floatingActionsMenu;
    }

    @Override // com.getbase.floatingactionbutton.FloatingActionButton
    public void a() {
        int i;
        int i2;
        int i3;
        boolean z;
        i = this.n.f9836d;
        this.m = i;
        i2 = this.n.f9837e;
        this.f9824a = i2;
        i3 = this.n.f9838f;
        this.f9825b = i3;
        z = this.n.f9840h;
        this.l = z;
        super.a();
    }

    @Override // com.getbase.floatingactionbutton.b, com.getbase.floatingactionbutton.FloatingActionButton
    public Drawable getIconDrawable() {
        FloatingActionsMenu.c cVar = new FloatingActionsMenu.c(super.getIconDrawable());
        this.n.q = cVar;
        OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cVar, "rotation", 135.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(cVar, "rotation", 0.0f, 135.0f);
        ofFloat.setInterpolator(overshootInterpolator);
        ofFloat2.setInterpolator(overshootInterpolator);
        this.n.n.play(ofFloat2);
        this.n.o.play(ofFloat);
        return cVar;
    }
}
