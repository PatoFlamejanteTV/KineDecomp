package com.nexstreaming.kinemaster.ui.mediabrowser;

import android.content.DialogInterface;
import com.nexstreaming.kinemaster.mediastore.provider.F;

/* compiled from: MediaBrowserFragment.kt */
/* loaded from: classes.dex */
final class z implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1829g f21715a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ F.b f21716b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(C1829g c1829g, F.b bVar) {
        this.f21715a = c1829g;
        this.f21716b = bVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        InterfaceC1827e interfaceC1827e;
        interfaceC1827e = this.f21715a.f21687h;
        if (interfaceC1827e != null) {
            interfaceC1827e.a(this.f21716b);
        }
        dialogInterface.dismiss();
    }
}
