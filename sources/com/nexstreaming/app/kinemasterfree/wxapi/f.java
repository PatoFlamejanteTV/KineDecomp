package com.nexstreaming.app.kinemasterfree.wxapi;

import android.util.Log;
import com.nexstreaming.app.general.task.Task;

/* compiled from: WXEntryActivity.java */
/* loaded from: classes.dex */
class f implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WXEntryActivity f3253a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(WXEntryActivity wXEntryActivity) {
        this.f3253a = wXEntryActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Log.e("WXEntryActivity", "Event promocode error : " + taskError.getLocalizedMessage(this.f3253a));
        this.f3253a.finish();
    }
}
