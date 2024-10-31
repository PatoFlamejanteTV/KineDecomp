package com.nextreaming.nexeditorui.newproject.b;

import android.util.Log;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import com.nextreaming.nexeditorui.newproject.b.s;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThemeDownloadServerConnector.java */
/* loaded from: classes.dex */
public class t implements ResultTask.OnResultAvailableListener<Theme[]> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ s f4682a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.f4682a = sVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Theme[]> resultTask, Task.Event event, Theme[] themeArr) {
        WeakReference weakReference;
        weakReference = this.f4682a.c;
        s.a aVar = (s.a) weakReference.get();
        Log.d("ThemeDownloadServerConnector", "onResultAvailable");
        if (aVar != null) {
            aVar.a(themeArr);
        } else {
            Log.d("ThemeDownloadServerConnector", "onResultAvailable    listener is null");
        }
    }
}
