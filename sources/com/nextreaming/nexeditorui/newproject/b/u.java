package com.nextreaming.nexeditorui.newproject.b;

import android.util.Log;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.newproject.b.s;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThemeDownloadServerConnector.java */
/* loaded from: classes.dex */
public class u implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ s f4683a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.f4683a = sVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        WeakReference weakReference;
        weakReference = this.f4683a.c;
        s.a aVar = (s.a) weakReference.get();
        if (aVar != null) {
            aVar.a(100);
        } else {
            Log.d("ThemeDownloadServerConnector", "onFail    listener is null");
        }
    }
}
