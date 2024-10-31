package com.nexstreaming.kinemaster.ui.projectedit;

import com.facebook.internal.NativeProtocol;
import com.nexstreaming.kinemaster.ui.widget.g;
import com.nexstreaming.kinemaster.usage.KMUsage;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class iq implements g.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WeakReference f3987a;
    final /* synthetic */ ProjectEditActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public iq(ProjectEditActivity projectEditActivity, WeakReference weakReference) {
        this.b = projectEditActivity;
        this.f3987a = weakReference;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.g.b
    public void a(com.nexstreaming.kinemaster.ui.widget.g gVar, int i) {
        a aVar = this.f3987a == null ? null : (a) this.f3987a.get();
        KMUsage.EditScreen_CaptureAction.logEvent(NativeProtocol.WEB_DIALOG_ACTION, this.b.getResources().getResourceEntryName(i));
        if (!(aVar != null ? aVar.a(i) : false)) {
            this.b.a(i, aVar);
        }
    }
}
