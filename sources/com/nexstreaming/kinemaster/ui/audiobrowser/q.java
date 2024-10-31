package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioBrowserFragment.kt */
/* loaded from: classes.dex */
public final class q implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f21455a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(a aVar) {
        this.f21455a = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003c, code lost:            r4 = r3.f21455a.v;     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onClick(android.view.View r4) {
        /*
            r3 = this;
            com.nexstreaming.kinemaster.ui.audiobrowser.a r0 = r3.f21455a
            android.support.v4.app.FragmentActivity r0 = r0.getActivity()
            java.lang.String r1 = "v"
            if (r0 == 0) goto L51
            com.nexstreaming.kinemaster.ui.audiobrowser.a r0 = r3.f21455a
            android.support.v4.app.FragmentActivity r0 = r0.getActivity()
            boolean r0 = r0 instanceof com.nextreaming.nexeditorui.InterfaceC2301ca
            if (r0 == 0) goto L51
            kotlin.jvm.internal.h.a(r4, r1)
            int r0 = r4.getId()
            r2 = 2131362530(0x7f0a02e2, float:1.8344843E38)
            if (r0 != r2) goto L51
            com.nexstreaming.kinemaster.ui.audiobrowser.a r4 = r3.f21455a
            android.support.v4.app.FragmentActivity r4 = r4.getActivity()
            if (r4 == 0) goto L49
            com.nextreaming.nexeditorui.ca r4 = (com.nextreaming.nexeditorui.InterfaceC2301ca) r4
            com.nexstreaming.kinemaster.ui.audiobrowser.a r0 = r3.f21455a
            int r0 = com.nexstreaming.kinemaster.ui.audiobrowser.a.l(r0)
            r1 = 0
            r4.a(r1, r1, r0)
            com.nexstreaming.kinemaster.ui.audiobrowser.a r4 = r3.f21455a
            com.nexstreaming.kinemaster.ui.widget.Toolbar r4 = com.nexstreaming.kinemaster.ui.audiobrowser.a.m(r4)
            if (r4 == 0) goto L9c
            com.nexstreaming.kinemaster.ui.audiobrowser.a r4 = r3.f21455a
            com.nexstreaming.kinemaster.ui.widget.Toolbar r4 = com.nexstreaming.kinemaster.ui.audiobrowser.a.m(r4)
            if (r4 == 0) goto L9c
            r0 = 1
            r4.a(r0)
            goto L9c
        L49:
            kotlin.TypeCastException r4 = new kotlin.TypeCastException
            java.lang.String r0 = "null cannot be cast to non-null type com.nextreaming.nexeditorui.NexAMediaReceiver"
            r4.<init>(r0)
            throw r4
        L51:
            kotlin.jvm.internal.h.a(r4, r1)
            int r0 = r4.getId()
            r1 = 2131361820(0x7f0a001c, float:1.8343403E38)
            if (r0 != r1) goto L69
            com.nexstreaming.kinemaster.ui.audiobrowser.a r4 = r3.f21455a
            android.support.v4.app.FragmentManager r4 = r4.getFragmentManager()
            if (r4 == 0) goto L9c
            r4.popBackStackImmediate()
            goto L9c
        L69:
            int r4 = r4.getId()
            r0 = 2131363586(0x7f0a0702, float:1.8346985E38)
            if (r4 != r0) goto L9c
            android.content.Intent r4 = new android.content.Intent
            com.nexstreaming.kinemaster.ui.audiobrowser.a r0 = r3.f21455a
            android.support.v4.app.FragmentActivity r0 = r0.getActivity()
            java.lang.Class<com.nexstreaming.kinemaster.ui.store.controller.StoreActivity> r1 = com.nexstreaming.kinemaster.ui.store.controller.StoreActivity.class
            r4.<init>(r0, r1)
            com.nexstreaming.kinemaster.ui.audiobrowser.a r0 = r3.f21455a
            java.lang.String r0 = com.nexstreaming.kinemaster.ui.audiobrowser.a.h(r0)
            if (r0 == 0) goto L8c
            java.lang.String r1 = "SELECTED_PROJECT"
            r4.putExtra(r1, r0)
        L8c:
            com.nexstreaming.app.general.nexasset.assetpackage.AssetCategoryAlias r0 = com.nexstreaming.app.general.nexasset.assetpackage.AssetCategoryAlias.Audio
            java.lang.String r0 = r0.name()
            java.lang.String r1 = "SPECIFIC_URL"
            r4.putExtra(r1, r0)
            com.nexstreaming.kinemaster.ui.audiobrowser.a r0 = r3.f21455a
            r0.startActivity(r4)
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.audiobrowser.q.onClick(android.view.View):void");
    }
}
