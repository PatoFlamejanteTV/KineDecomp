package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.widget.ListView;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.NexIndexableListView;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioBrowserFragment.kt */
/* loaded from: classes.dex */
public final class l<T> implements ResultTask.OnResultAvailableListener<List<u>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f21447a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ t f21448b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar, t tVar) {
        this.f21447a = aVar;
        this.f21448b = tVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onResultAvailable(ResultTask<List<u>> resultTask, Task.Event event, List<u> list) {
        ListView listView;
        NexIndexableListView nexIndexableListView;
        ListView listView2;
        listView = this.f21447a.f21409e;
        if (listView != null) {
            nexIndexableListView = this.f21447a.f21410f;
            if (nexIndexableListView == null) {
                return;
            }
            listView2 = this.f21447a.f21409e;
            if (listView2 != null) {
                listView2.setVisibility(8);
                a aVar = this.f21447a;
                t tVar = this.f21448b;
                kotlin.jvm.internal.h.a((Object) list, "result");
                aVar.a(tVar, (List<? extends u>) list);
                return;
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }
}
