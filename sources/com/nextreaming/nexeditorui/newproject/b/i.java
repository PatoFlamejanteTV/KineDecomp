package com.nextreaming.nexeditorui.newproject.b;

import android.app.Activity;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThemeBrowserFragment.java */
/* loaded from: classes.dex */
public class i implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f4671a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.f4671a = fVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        EffectLibrary effectLibrary;
        ArrayList arrayList;
        Theme[] themeArr;
        ArrayList arrayList2;
        GridView gridView;
        a aVar;
        Theme theme;
        a aVar2;
        Theme theme2;
        int b;
        a aVar3;
        GridView gridView2;
        Toolbar toolbar;
        Theme theme3;
        if (this.f4671a.isAdded()) {
            f fVar = this.f4671a;
            effectLibrary = this.f4671a.f4667a;
            fVar.d = effectLibrary.c();
            this.f4671a.b = new ArrayList();
            arrayList = this.f4671a.b;
            themeArr = this.f4671a.d;
            Collections.addAll(arrayList, themeArr);
            f fVar2 = this.f4671a;
            Activity activity = this.f4671a.getActivity();
            arrayList2 = this.f4671a.b;
            fVar2.j = new a(activity, arrayList2);
            gridView = this.f4671a.i;
            aVar = this.f4671a.j;
            gridView.setAdapter((ListAdapter) aVar);
            this.f4671a.b();
            theme = this.f4671a.e;
            if (theme != null) {
                aVar2 = this.f4671a.j;
                f fVar3 = this.f4671a;
                theme2 = this.f4671a.e;
                b = fVar3.b(theme2);
                aVar2.a(b);
                aVar3 = this.f4671a.j;
                aVar3.notifyDataSetChanged();
                gridView2 = this.f4671a.i;
                gridView2.post(new j(this));
                toolbar = this.f4671a.h;
                theme3 = this.f4671a.e;
                toolbar.a(theme3.a(this.f4671a.getActivity()), 1);
            }
        }
    }
}
