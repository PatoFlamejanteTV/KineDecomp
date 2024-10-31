package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class ab implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4128a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(ProjectGalleryActivity projectGalleryActivity) {
        this.f4128a = projectGalleryActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z;
        Runnable runnable;
        x xVar;
        GridView gridView;
        Runnable runnable2;
        GridView gridView2;
        Runnable runnable3;
        x xVar2;
        z = this.f4128a.b;
        if (!z) {
            runnable = this.f4128a.z;
            if (runnable != null) {
                gridView2 = this.f4128a.e;
                runnable3 = this.f4128a.z;
                gridView2.removeCallbacks(runnable3);
                this.f4128a.z = null;
                xVar2 = this.f4128a.g;
                this.f4128a.a(xVar2.getItem(i), "double_tap");
                return;
            }
            xVar = this.f4128a.g;
            com.nexstreaming.kinemaster.project.f item = xVar.getItem(i);
            if (item != null) {
                ((TextView) this.f4128a.findViewById(R.id.projectDetailsTitle)).setText(item.f());
            }
            this.f4128a.z = new ac(this, i, view);
            gridView = this.f4128a.e;
            runnable2 = this.f4128a.z;
            gridView.postDelayed(runnable2, 200L);
        }
    }
}
