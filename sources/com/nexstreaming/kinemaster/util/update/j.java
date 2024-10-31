package com.nexstreaming.kinemaster.util.update;

import android.util.Log;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: AssetUpdateActivity.java */
/* loaded from: classes2.dex */
class j implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ n f23961a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(n nVar) {
        this.f23961a = nVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        String str;
        str = AssetUpdateActivity.TAG;
        Log.d(str, "service connection error: onFail: " + taskError);
        this.f23961a.f23967b.d(R.string.asset_download_failed);
    }
}
