package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.widget.ListAdapter;
import android.widget.ListView;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioBrowserFragment.kt */
/* loaded from: classes.dex */
public final class k<T> implements ResultTask.OnResultAvailableListener<List<? extends s>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f21445a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ t f21446b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar, t tVar) {
        this.f21445a = aVar;
        this.f21446b = tVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onResultAvailable(ResultTask<List<s>> resultTask, Task.Event event, List<? extends s> list) {
        ListView listView;
        ListView listView2;
        boolean C;
        if (this.f21445a.isDetached() || this.f21445a.isRemoving() || !this.f21445a.isVisible()) {
            return;
        }
        this.f21445a.k = list;
        listView = this.f21445a.f21409e;
        if (listView != null) {
            listView.setVisibility(0);
        }
        boolean z = this.f21446b instanceof com.nexstreaming.kinemaster.ui.audiobrowser.a.b;
        listView2 = this.f21445a.f21409e;
        if (listView2 != null) {
            C = this.f21445a.C();
            listView2.setAdapter((ListAdapter) new w(list, z, C));
        }
        this.f21445a.E();
    }
}
