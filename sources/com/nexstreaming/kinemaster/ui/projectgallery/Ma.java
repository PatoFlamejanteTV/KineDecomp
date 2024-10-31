package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.EditorGlobal;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
class Ma implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22863a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ma(ProjectGalleryActivity projectGalleryActivity) {
        this.f22863a = projectGalleryActivity;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View view;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        Eb eb;
        Eb eb2;
        RecyclerView recyclerView3;
        View view2;
        view = this.f22863a.W;
        if (view.getViewTreeObserver().isAlive()) {
            view2 = this.f22863a.W;
            view2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        int dimension = (int) this.f22863a.getResources().getDimension(R.dimen.project_gallery_thumb_width);
        DisplayMetrics displayMetrics = this.f22863a.getResources().getDisplayMetrics();
        int max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        int dimension2 = (int) this.f22863a.getResources().getDimension(R.dimen.project_gallery_gridview_padding);
        int dimension3 = (int) this.f22863a.getResources().getDimension(R.dimen.project_gallery_thumb_vertical_spacing);
        int a2 = Eb.f22826d.a(this.f22863a, dimension, max);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f22863a, a2);
        recyclerView = this.f22863a.sa;
        recyclerView.setLayoutManager(gridLayoutManager);
        int dimension4 = max - ((int) this.f22863a.getResources().getDimension(R.dimen.project_gallery_left_width));
        int a3 = EditorGlobal.a((Context) this.f22863a, 4);
        recyclerView2 = this.f22863a.sa;
        if (recyclerView2.getItemDecorationCount() == 0) {
            recyclerView3 = this.f22863a.sa;
            recyclerView3.addItemDecoration(new Jb(a2, dimension, dimension4, a3, dimension2, dimension2, dimension3));
        }
        eb = this.f22863a.ua;
        if (eb != null) {
            eb2 = this.f22863a.ua;
            eb2.b(max, dimension);
        }
    }
}
