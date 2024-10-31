package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.graphics.Rect;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.J;

/* compiled from: TimelineItemTrimDecoration.java */
/* loaded from: classes2.dex */
public class K implements View.OnLayoutChangeListener {

    /* renamed from: a */
    final /* synthetic */ View f22596a;

    /* renamed from: b */
    final /* synthetic */ J.b f22597b;

    public K(J.b bVar, View view) {
        this.f22597b = bVar;
        this.f22596a = view;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9;
        view.removeOnLayoutChangeListener(this);
        int width = view.getWidth();
        int height = view.getHeight();
        Rect rect = new Rect();
        this.f22596a.getGlobalVisibleRect(rect);
        i9 = J.this.A;
        int i10 = width / 2;
        this.f22597b.update((i9 == 1 ? rect.left : rect.right) - i10, rect.top - height, width, height);
        view.setVisibility(0);
        view.setPivotX(i10);
        view.setPivotY(height);
        view.setScaleX(0.95f);
        view.setScaleY(0.95f);
        view.setAlpha(0.0f);
        view.animate().setInterpolator(new LinearOutSlowInInterpolator()).setDuration(300L).setListener(null).scaleX(1.0f).scaleY(1.0f).alpha(1.0f).start();
        this.f22597b.f22593a = true;
    }
}
