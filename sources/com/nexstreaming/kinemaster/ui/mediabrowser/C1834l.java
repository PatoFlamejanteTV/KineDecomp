package com.nexstreaming.kinemaster.ui.mediabrowser;

import android.view.MenuItem;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.a.a.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.mediabrowser.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1834l implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1829g f21694a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1834l(C1829g c1829g) {
        this.f21694a = c1829g;
    }

    @Override // com.nextreaming.nexeditorui.a.a.b.a
    public final void a(MenuItem menuItem, int i) {
        InterfaceC1827e interfaceC1827e;
        InterfaceC1827e interfaceC1827e2;
        InterfaceC1827e interfaceC1827e3;
        kotlin.jvm.internal.h.a((Object) menuItem, "item");
        switch (menuItem.getItemId()) {
            case R.id.media_browser_menu_all /* 2131362983 */:
                interfaceC1827e = this.f21694a.f21687h;
                if (interfaceC1827e != null) {
                    interfaceC1827e.b(MediaViewerMode.ALL);
                    return;
                }
                return;
            case R.id.media_browser_menu_images /* 2131362984 */:
                interfaceC1827e2 = this.f21694a.f21687h;
                if (interfaceC1827e2 != null) {
                    interfaceC1827e2.b(MediaViewerMode.IMAGES);
                    return;
                }
                return;
            case R.id.media_browser_menu_video /* 2131362985 */:
                interfaceC1827e3 = this.f21694a.f21687h;
                if (interfaceC1827e3 != null) {
                    interfaceC1827e3.b(MediaViewerMode.VIDEO);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
