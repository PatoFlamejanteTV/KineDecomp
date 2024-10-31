package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.widget.PopoutListMenu;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.zf, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2091zf implements PopoutListMenu.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WeakReference f22807a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22808b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2091zf(ProjectEditActivity projectEditActivity, WeakReference weakReference) {
        this.f22808b = projectEditActivity;
        this.f22807a = weakReference;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.PopoutListMenu.b
    public void a(PopoutListMenu popoutListMenu, int i) {
        WeakReference weakReference = this.f22807a;
        InterfaceC1976p interfaceC1976p = weakReference == null ? null : (InterfaceC1976p) weakReference.get();
        if (interfaceC1976p != null ? interfaceC1976p.h(i) : false) {
            return;
        }
        this.f22808b.a(i, interfaceC1976p);
    }
}
