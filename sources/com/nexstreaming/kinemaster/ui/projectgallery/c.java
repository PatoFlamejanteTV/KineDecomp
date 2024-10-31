package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.Font;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import com.nexstreaming.kinemaster.project.ProjectDependency;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* loaded from: classes.dex */
public class c implements ResultTask.OnResultAvailableListener<Theme[]> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EffectLibrary f4180a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, EffectLibrary effectLibrary) {
        this.b = aVar;
        this.f4180a = effectLibrary;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Theme[]> resultTask, Task.Event event, Theme[] themeArr) {
        boolean z;
        Set set;
        List list;
        com.nexstreaming.kinemaster.ui.a.e eVar;
        boolean z2;
        Task task;
        List list2;
        Set<ProjectDependency> set2;
        List list3;
        Set<ProjectDependency> set3;
        List list4;
        z = this.b.j;
        if (!z) {
            HashSet hashSet = new HashSet();
            this.b.i = new ArrayList();
            HashSet hashSet2 = new HashSet();
            for (Theme theme : themeArr) {
                set3 = this.b.e;
                for (ProjectDependency projectDependency : set3) {
                    if (projectDependency.a(theme)) {
                        hashSet2.add(projectDependency);
                        if (!hashSet.contains(theme.i())) {
                            hashSet.add(theme.i());
                            list4 = this.b.i;
                            list4.add(theme.u());
                        }
                    }
                }
            }
            ArrayList<Font> arrayList = new ArrayList();
            Iterator<com.nexstreaming.kinemaster.kmpackage.y> it = this.f4180a.a().iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().a());
            }
            hashSet.clear();
            for (Font font : arrayList) {
                set2 = this.b.e;
                for (ProjectDependency projectDependency2 : set2) {
                    if (!font.d() && projectDependency2.a(font)) {
                        hashSet2.add(projectDependency2);
                        if (!hashSet.contains(font.m())) {
                            hashSet.add(font.m());
                            list3 = this.b.i;
                            list3.add(font.i());
                        }
                    }
                }
            }
            a aVar = this.b;
            set = this.b.e;
            aVar.k = set.size() > hashSet2.size();
            list = this.b.i;
            if (list.size() > 0) {
                list2 = this.b.i;
                Task.combinedTask(list2).onProgress(new f(this)).onFailure(new e(this)).onComplete(new d(this));
                return;
            }
            eVar = this.b.h;
            eVar.dismiss();
            z2 = this.b.k;
            if (z2) {
                this.b.a(Task.Event.COMPLETE, R.string.resource_not_available_popup);
            } else {
                task = this.b.d;
                task.signalEvent(Task.Event.COMPLETE);
            }
        }
    }
}
