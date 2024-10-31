package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.TimelineView;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f;
import com.nexstreaming.kinemaster.ui.widget.PopoutBookmarkListMenu;

/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.gf, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1902gf implements PopoutBookmarkListMenu.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f22351a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ViewOnLongClickListenerC1911hf f22352b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1902gf(ViewOnLongClickListenerC1911hf viewOnLongClickListenerC1911hf, int i) {
        this.f22352b = viewOnLongClickListenerC1911hf;
        this.f22351a = i;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.PopoutBookmarkListMenu.b
    public void a(PopoutBookmarkListMenu popoutBookmarkListMenu, int i) {
        InterfaceC2025f interfaceC2025f;
        InterfaceC2025f interfaceC2025f2;
        TimelineView.d dVar;
        InterfaceC2025f interfaceC2025f3;
        InterfaceC2025f interfaceC2025f4;
        TimelineView.d dVar2;
        InterfaceC2025f interfaceC2025f5;
        if (i == -1) {
            interfaceC2025f4 = this.f22352b.f22369a.T;
            interfaceC2025f4.getTimeline().clearAllBookmarks();
            this.f22352b.f22369a.ja().J();
            dVar2 = this.f22352b.f22369a.jb;
            dVar2.a(this.f22351a, true);
            interfaceC2025f5 = this.f22352b.f22369a.T;
            interfaceC2025f5.invalidate();
            return;
        }
        if (i != -2) {
            if (i >= 0) {
                interfaceC2025f = this.f22352b.f22369a.T;
                interfaceC2025f.a(i, true);
                return;
            }
            return;
        }
        interfaceC2025f2 = this.f22352b.f22369a.T;
        interfaceC2025f2.getTimeline().toggleBookmark(this.f22351a);
        this.f22352b.f22369a.ja().J();
        dVar = this.f22352b.f22369a.jb;
        dVar.a(this.f22351a, true);
        interfaceC2025f3 = this.f22352b.f22369a.T;
        interfaceC2025f3.invalidate();
    }
}
