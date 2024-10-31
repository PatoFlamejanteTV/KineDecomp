package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.uf, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2049uf extends com.nexstreaming.app.general.util.A {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ LinearLayout f22729b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ WeakReference f22730c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f22731d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22732e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2049uf(ProjectEditActivity projectEditActivity, LinearLayout linearLayout, WeakReference weakReference, int i) {
        this.f22732e = projectEditActivity;
        this.f22729b = linearLayout;
        this.f22730c = weakReference;
        this.f22731d = i;
    }

    @Override // com.nexstreaming.app.general.util.A
    public void a(View view) {
        if (this.f22729b.isEnabled()) {
            WeakReference weakReference = this.f22730c;
            InterfaceC1976p interfaceC1976p = weakReference == null ? null : (InterfaceC1976p) weakReference.get();
            if (interfaceC1976p != null ? interfaceC1976p.h(this.f22731d) : false) {
                return;
            }
            this.f22732e.a(this.f22731d, interfaceC1976p);
        }
    }
}
