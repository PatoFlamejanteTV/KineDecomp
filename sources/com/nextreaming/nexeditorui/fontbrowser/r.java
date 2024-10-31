package com.nextreaming.nexeditorui.fontbrowser;

import android.content.Context;
import android.widget.Toast;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontListAdapter.java */
/* loaded from: classes.dex */
public class r implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f4642a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar) {
        this.f4642a = lVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Context context;
        context = this.f4642a.b;
        Toast.makeText(context, R.string.download_failed, 0).show();
    }
}
