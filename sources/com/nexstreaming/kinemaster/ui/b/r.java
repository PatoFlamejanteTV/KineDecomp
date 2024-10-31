package com.nexstreaming.kinemaster.ui.b;

import android.util.Log;
import android.widget.ExpandableListView;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MiniFxGroupBrowserFragment.java */
/* loaded from: classes.dex */
public class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ o f3705a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.f3705a = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        ExpandableListView expandableListView;
        b bVar5;
        ExpandableListView expandableListView2;
        b bVar6;
        b bVar7;
        bVar = this.f3705a.c;
        if (bVar.c >= 0) {
            bVar2 = this.f3705a.c;
            if (bVar2.b >= 0 && this.f3705a.isAdded()) {
                StringBuilder append = new StringBuilder().append("sc=");
                bVar3 = this.f3705a.c;
                StringBuilder append2 = append.append(bVar3.c).append(" sg=");
                bVar4 = this.f3705a.c;
                Log.i("MiniFxGBrowsr", append2.append(bVar4.b).toString());
                expandableListView = this.f3705a.b;
                bVar5 = this.f3705a.c;
                expandableListView.expandGroup(bVar5.b);
                expandableListView2 = this.f3705a.b;
                bVar6 = this.f3705a.c;
                int i = bVar6.b;
                bVar7 = this.f3705a.c;
                expandableListView2.setSelectedChild(i, bVar7.c, true);
                this.f3705a.g(R.id.editmode_fxtime);
            }
        }
    }
}
