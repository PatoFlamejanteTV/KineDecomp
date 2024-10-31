package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.ListView;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionListFragment.java */
/* loaded from: classes2.dex */
public class Vc implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Xc f22152a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Vc(Xc xc) {
        this.f22152a = xc;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        ListView listView;
        C1935kd c1935kd;
        listView = this.f22152a.l;
        listView.clearChoices();
        c1935kd = this.f22152a.o;
        c1935kd.notifyDataSetInvalidated();
    }
}
