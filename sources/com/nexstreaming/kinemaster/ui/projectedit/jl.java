package com.nexstreaming.kinemaster.ui.projectedit;

import com.facebook.internal.NativeProtocol;
import com.nexstreaming.kinemaster.ui.widget.g;
import com.nexstreaming.kinemaster.usage.KMUsage;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class jl implements g.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WeakReference f4009a;
    final /* synthetic */ ProjectEditActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jl(ProjectEditActivity projectEditActivity, WeakReference weakReference) {
        this.b = projectEditActivity;
        this.f4009a = weakReference;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.g.b
    public void a(com.nexstreaming.kinemaster.ui.widget.g gVar, int i) {
        a aVar = this.f4009a == null ? null : (a) this.f4009a.get();
        KMUsage.EditScreen_OverflowAction.logEvent(NativeProtocol.WEB_DIALOG_ACTION, this.b.getResources().getResourceEntryName(i));
        if (!(aVar != null ? aVar.a(i) : false)) {
            this.b.a(i, aVar);
        }
    }
}
