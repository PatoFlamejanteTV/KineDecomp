package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.ListView;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionListFragment.java */
/* loaded from: classes.dex */
public class el implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ed f3872a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public el(ed edVar) {
        this.f3872a = edVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        ListView listView;
        ep epVar;
        listView = this.f3872a.f3864a;
        listView.clearChoices();
        epVar = this.f3872a.b;
        epVar.notifyDataSetInvalidated();
    }
}
