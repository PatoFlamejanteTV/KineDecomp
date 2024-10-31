package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.audiobrowser.q;
import com.nextreaming.nexeditorui.NexIndexableListView;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioBrowserFragment.java */
/* loaded from: classes.dex */
public class g implements ResultTask.OnResultAvailableListener<List<n>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f3672a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar, m mVar) {
        this.b = aVar;
        this.f3672a = mVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<List<n>> resultTask, Task.Event event, List<n> list) {
        ListView listView;
        NexIndexableListView nexIndexableListView;
        NexIndexableListView nexIndexableListView2;
        View view;
        q.a aVar;
        NexIndexableListView nexIndexableListView3;
        q qVar;
        NexIndexableListView nexIndexableListView4;
        View view2;
        ListView listView2;
        listView = this.b.c;
        if (listView != null) {
            nexIndexableListView = this.b.e;
            if (nexIndexableListView != null) {
                if (!this.f3672a.a()) {
                    listView2 = this.b.c;
                    listView2.setVisibility(8);
                }
                if (list.size() < 1) {
                    nexIndexableListView4 = this.b.e;
                    nexIndexableListView4.setVisibility(4);
                    view2 = this.b.d;
                    view2.setVisibility(0);
                    return;
                }
                nexIndexableListView2 = this.b.e;
                nexIndexableListView2.setVisibility(0);
                view = this.b.d;
                view.setVisibility(4);
                a aVar2 = this.b;
                aVar = this.b.u;
                aVar2.l = new q(list, aVar);
                nexIndexableListView3 = this.b.e;
                qVar = this.b.l;
                nexIndexableListView3.setAdapter((ListAdapter) qVar);
            }
        }
    }
}
