package com.nexstreaming.app.general.iab.a;

import android.util.Log;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.task.Task;
import java.util.Map;

/* compiled from: GoogleIABHelper.java */
/* loaded from: classes.dex */
class f implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IABHelper.d f3148a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, IABHelper.d dVar) {
        this.b = aVar;
        this.f3148a = dVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Map<IABHelper.SKUType, Map<String, SKUDetails>> n;
        Log.e("GoogleIABHelper", IABError.NetworkError + taskError.toString());
        IABHelper.d dVar = this.f3148a;
        n = this.b.n();
        dVar.b(n);
    }
}
