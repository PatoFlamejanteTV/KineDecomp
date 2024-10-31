package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.widget.AbsListView;

/* compiled from: StickerEditFragment.java */
/* loaded from: classes2.dex */
class Tg implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Xg f22104a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tg(Xg xg) {
        this.f22104a = xg;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View view;
        View view2;
        View view3;
        View view4;
        View view5;
        View view6;
        view = this.f22104a.K;
        if (view != null) {
            view2 = this.f22104a.L;
            if (view2 == null) {
                return;
            }
            int height = absListView.getHeight();
            int height2 = absListView.getChildAt(0) != null ? absListView.getChildAt(0).getHeight() : 0;
            if (i != 0 || (absListView.getChildAt(0) != null && absListView.getChildAt(0).getTop() < 0)) {
                view3 = this.f22104a.K;
                view3.setVisibility(0);
            } else {
                view6 = this.f22104a.K;
                view6.setVisibility(8);
            }
            if (i3 <= 0 || i + i2 < i3 || absListView.getChildAt(i2 - 1).getTop() > height - height2) {
                view4 = this.f22104a.L;
                view4.setVisibility(0);
            } else {
                view5 = this.f22104a.L;
                view5.setVisibility(8);
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
