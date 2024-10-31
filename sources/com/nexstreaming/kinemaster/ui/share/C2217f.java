package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: ExportAndShareActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.share.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C2217f implements ResultTask.OnResultAvailableListener<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ExportAndShareActivity f23341a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2217f(ExportAndShareActivity exportAndShareActivity) {
        this.f23341a = exportAndShareActivity;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Boolean> resultTask, Task.Event event, Boolean bool) {
        this.f23341a.ga = bool.booleanValue();
    }
}
