package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.ComponentCallbacks2;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import java.util.List;

/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
class ik implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f3981a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ik(ProjectEditActivity projectEditActivity) {
        this.f3981a = projectEditActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        List<ComponentCallbacks2> z;
        z = this.f3981a.z();
        for (ComponentCallbacks2 componentCallbacks2 : z) {
            if (componentCallbacks2 instanceof ProjectEditActivity.b) {
                ((ProjectEditActivity.b) componentCallbacks2).a(this.f3981a);
            }
        }
    }
}
