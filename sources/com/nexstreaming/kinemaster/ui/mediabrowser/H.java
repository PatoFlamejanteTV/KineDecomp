package com.nexstreaming.kinemaster.ui.mediabrowser;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserPresenter.kt */
/* loaded from: classes.dex */
public final class H<T> implements ResultTask.OnResultAvailableListener<List<com.nexstreaming.kinemaster.mediastore.item.c>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ S f21652a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MediaViewerMode f21653b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H(S s, MediaViewerMode mediaViewerMode) {
        this.f21652a = s;
        this.f21653b = mediaViewerMode;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onResultAvailable(ResultTask<List<com.nexstreaming.kinemaster.mediastore.item.c>> resultTask, Task.Event event, List<com.nexstreaming.kinemaster.mediastore.item.c> list) {
        InterfaceC1825c interfaceC1825c;
        InterfaceC1828f interfaceC1828f;
        InterfaceC1828f interfaceC1828f2;
        if (resultTask != null) {
            resultTask.setCancellable(true);
        }
        Boolean valueOf = resultTask != null ? Boolean.valueOf(resultTask.isCancelRequested()) : null;
        if (valueOf == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        if (valueOf.booleanValue()) {
            return;
        }
        List<com.nexstreaming.kinemaster.mediastore.item.c> arrayList = new ArrayList<>();
        if (list != null) {
            arrayList = list;
        }
        if (!arrayList.isEmpty()) {
            interfaceC1825c = this.f21652a.f21669d;
            if (interfaceC1825c != null) {
                interfaceC1825c.a(arrayList);
            }
            interfaceC1828f = this.f21652a.f21668c;
            if (interfaceC1828f != null) {
                interfaceC1828f.p();
            }
            interfaceC1828f2 = this.f21652a.f21668c;
            if (interfaceC1828f2 != null) {
                interfaceC1828f2.b();
                return;
            }
            return;
        }
        this.f21652a.c(this.f21653b);
    }
}
