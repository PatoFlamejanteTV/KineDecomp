package com.nexstreaming.kinemaster.codeccaps;

import android.app.Activity;
import android.widget.Toast;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.lang.ref.WeakReference;

/* compiled from: CapabilityCheckPopup.java */
/* renamed from: com.nexstreaming.kinemaster.codeccaps.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C1724l implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WeakReference f20104a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C1727o f20105b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1724l(C1727o c1727o, WeakReference weakReference) {
        this.f20105b = c1727o;
        this.f20104a = weakReference;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Activity activity = (Activity) this.f20104a.get();
        if (activity != null) {
            e.a a2 = com.nexstreaming.kinemaster.ui.a.e.a(activity);
            a2.a("Firebase upload success!");
            a2.a().show();
            return;
        }
        Toast.makeText(KineMasterApplication.f24056d.getApplicationContext(), "Firebase upload OK", 1).show();
    }
}
