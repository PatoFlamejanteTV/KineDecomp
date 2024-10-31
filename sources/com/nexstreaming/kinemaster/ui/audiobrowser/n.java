package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.widget.ListView;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.NexIndexableListView;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioBrowserFragment.kt */
/* loaded from: classes.dex */
public final class n<T> implements ResultTask.OnResultAvailableListener<List<? extends u>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f21450a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ t f21451b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(a aVar, t tVar) {
        this.f21450a = aVar;
        this.f21451b = tVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onResultAvailable(ResultTask<List<u>> resultTask, Task.Event event, List<? extends u> list) {
        ListView listView;
        NexIndexableListView nexIndexableListView;
        ListView listView2;
        listView = this.f21450a.f21409e;
        if (listView != null) {
            nexIndexableListView = this.f21450a.f21410f;
            if (nexIndexableListView == null) {
                return;
            }
            if (!this.f21451b.a()) {
                listView2 = this.f21450a.f21409e;
                if (listView2 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                listView2.setVisibility(8);
            }
            a aVar = this.f21450a;
            t tVar = this.f21451b;
            kotlin.jvm.internal.h.a((Object) tVar, "lister");
            kotlin.jvm.internal.h.a((Object) list, "result");
            aVar.a(tVar, (List<? extends u>) list);
        }
    }
}
