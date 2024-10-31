package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.widget.PopoutListMenu;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
public class Sf implements PopoutListMenu.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WeakReference f22081a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22082b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Sf(ProjectEditActivity projectEditActivity, WeakReference weakReference) {
        this.f22082b = projectEditActivity;
        this.f22081a = weakReference;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.PopoutListMenu.b
    public void a(PopoutListMenu popoutListMenu, int i) {
        WeakReference weakReference = this.f22081a;
        InterfaceC1976p interfaceC1976p = weakReference == null ? null : (InterfaceC1976p) weakReference.get();
        if (interfaceC1976p != null ? interfaceC1976p.h(i) : false) {
            return;
        }
        this.f22082b.a(i, interfaceC1976p);
    }
}
