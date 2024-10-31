package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.res.Configuration;
import android.view.View;
import android.widget.GridView;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class z implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4227a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(ProjectGalleryActivity projectGalleryActivity) {
        this.f4227a = projectGalleryActivity;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        GridView gridView;
        GridView gridView2;
        GridView gridView3;
        GridView gridView4;
        GridView gridView5;
        GridView gridView6;
        GridView gridView7;
        Configuration configuration = this.f4227a.getResources().getConfiguration();
        if (configuration.screenWidthDp >= configuration.screenHeightDp) {
            view.removeOnLayoutChangeListener(this);
            gridView = this.f4227a.e;
            int horizontalSpacing = gridView.getHorizontalSpacing();
            gridView2 = this.f4227a.e;
            int numColumns = (i3 - i) - (horizontalSpacing * gridView2.getNumColumns());
            gridView3 = this.f4227a.e;
            int requestedColumnWidth = gridView3.getRequestedColumnWidth();
            if (requestedColumnWidth > numColumns / 2 && numColumns / 2 > (requestedColumnWidth * 2) / 3) {
                gridView4 = this.f4227a.e;
                if (gridView4.getNumColumns() <= 2) {
                    gridView5 = this.f4227a.e;
                    gridView5.setColumnWidth(numColumns / 2);
                    gridView6 = this.f4227a.e;
                    gridView6.setVerticalSpacing(0);
                    gridView7 = this.f4227a.e;
                    gridView7.post(new aa(this));
                }
            }
        }
    }
}
