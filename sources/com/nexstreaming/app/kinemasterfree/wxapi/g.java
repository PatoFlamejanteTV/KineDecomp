package com.nexstreaming.app.kinemasterfree.wxapi;

import android.util.Log;
import com.nexstreaming.app.general.task.Task;

/* compiled from: WXEntryActivity.java */
/* loaded from: classes2.dex */
class g implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WXEntryActivity f19928a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(WXEntryActivity wXEntryActivity) {
        this.f19928a = wXEntryActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Log.e("WXEntryActivity", "Event promocode error : " + taskError.getLocalizedMessage(this.f19928a));
        this.f19928a.finish();
    }
}
