package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* loaded from: classes2.dex */
public class N implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ O f22864a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public N(O o) {
        this.f22864a = o;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f22864a.a(Task.Event.COMPLETE, R.string.asset_not_available_popup);
    }
}
