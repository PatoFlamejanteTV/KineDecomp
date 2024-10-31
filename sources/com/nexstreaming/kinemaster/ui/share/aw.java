package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareIntentActivity.java */
/* loaded from: classes.dex */
public class aw implements Task.OnProgressListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareIntentActivity f4307a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(ShareIntentActivity shareIntentActivity) {
        this.f4307a = shareIntentActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        com.nexstreaming.kinemaster.ui.a.e eVar;
        com.nexstreaming.kinemaster.ui.a.e eVar2;
        com.nexstreaming.kinemaster.ui.a.e eVar3;
        com.nexstreaming.kinemaster.ui.a.e eVar4;
        eVar = this.f4307a.f;
        if (eVar != null) {
            eVar2 = this.f4307a.f;
            if (eVar2.isShowing()) {
                eVar3 = this.f4307a.f;
                eVar3.h(i);
                eVar4 = this.f4307a.f;
                eVar4.i(i2);
            }
        }
    }
}
