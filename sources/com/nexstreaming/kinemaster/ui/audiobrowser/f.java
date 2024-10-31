package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.widget.ListAdapter;
import android.widget.ListView;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioBrowserFragment.java */
/* loaded from: classes.dex */
public class f implements ResultTask.OnResultAvailableListener<List<l>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f3671a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, m mVar) {
        this.b = aVar;
        this.f3671a = mVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<List<l>> resultTask, Task.Event event, List<l> list) {
        ListView listView;
        ListView listView2;
        this.b.h = list;
        listView = this.b.c;
        listView.setVisibility(0);
        boolean z = this.f3671a instanceof com.nexstreaming.kinemaster.ui.audiobrowser.a.b;
        listView2 = this.b.c;
        listView2.setAdapter((ListAdapter) new p(list, z));
        this.b.c();
    }
}
