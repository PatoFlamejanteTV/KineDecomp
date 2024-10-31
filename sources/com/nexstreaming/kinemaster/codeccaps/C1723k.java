package com.nexstreaming.kinemaster.codeccaps;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.lang.ref.WeakReference;

/* compiled from: CapabilityCheckPopup.java */
/* renamed from: com.nexstreaming.kinemaster.codeccaps.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C1723k implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WeakReference f20102a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C1727o f20103b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1723k(C1727o c1727o, WeakReference weakReference) {
        this.f20103b = c1727o;
        this.f20102a = weakReference;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Log.e("CapabilityCheckPopup", "Firebase Upload Error", taskError.getException());
        Activity activity = (Activity) this.f20102a.get();
        if (activity != null) {
            e.a a2 = com.nexstreaming.kinemaster.ui.a.e.a(activity);
            a2.a("Firebase upload ERROR");
            a2.b(taskError.getMessage());
            a2.a().show();
            return;
        }
        Toast.makeText(KineMasterApplication.f24056d.getApplicationContext(), "Firebase upload ERROR!!!", 1).show();
    }
}
