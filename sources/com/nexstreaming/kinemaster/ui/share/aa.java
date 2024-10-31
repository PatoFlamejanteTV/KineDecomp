package com.nexstreaming.kinemaster.ui.share;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareActivity.java */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareActivity f4285a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(ShareActivity shareActivity) {
        this.f4285a = shareActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ba  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.view.View r7) {
        /*
            r6 = this;
            r1 = 1
            r2 = 0
            com.nexstreaming.kinemaster.ui.share.ShareActivity r0 = r6.f4285a
            int r3 = r7.getId()
            com.nexstreaming.kinemaster.ui.share.ShareActivity.a(r0, r3)
            com.nexstreaming.kinemaster.ui.share.ShareActivity r0 = r6.f4285a
            int r0 = com.nexstreaming.kinemaster.ui.share.ShareActivity.a(r0)
            r3 = 2131821512(0x7f1103c8, float:1.927577E38)
            if (r0 == r3) goto L4e
            com.nexstreaming.kinemaster.ui.share.ShareActivity r0 = r6.f4285a
            int r0 = com.nexstreaming.kinemaster.ui.share.ShareActivity.a(r0)
            r3 = 2131821505(0x7f1103c1, float:1.9275755E38)
            if (r0 == r3) goto L4e
            r0 = r1
        L22:
            if (r0 == 0) goto L50
            com.nexstreaming.kinemaster.ui.share.ShareActivity r0 = r6.f4285a
            boolean r0 = com.nexstreaming.kinemaster.h.a.c(r0)
            if (r0 != 0) goto L50
            com.nexstreaming.kinemaster.ui.a.a$a r0 = new com.nexstreaming.kinemaster.ui.a.a$a
            com.nexstreaming.kinemaster.ui.share.ShareActivity r1 = r6.f4285a
            r0.<init>(r1)
            r1 = 2131231829(0x7f080455, float:1.807975E38)
            com.nexstreaming.kinemaster.ui.a.a$a r0 = r0.a(r1)
            r1 = 2131230885(0x7f0800a5, float:1.8077835E38)
            com.nexstreaming.kinemaster.ui.share.ab r2 = new com.nexstreaming.kinemaster.ui.share.ab
            r2.<init>(r6)
            com.nexstreaming.kinemaster.ui.a.a$a r0 = r0.a(r1, r2)
            com.nexstreaming.kinemaster.ui.a.a r0 = r0.a()
            r0.show()
        L4d:
            return
        L4e:
            r0 = r2
            goto L22
        L50:
            com.nexstreaming.kinemaster.ui.share.ShareActivity r0 = r6.f4285a
            boolean r0 = r0.B()
            if (r0 == 0) goto Lba
            com.nexstreaming.kinemaster.usage.KMUsage r0 = com.nexstreaming.kinemaster.usage.KMUsage.Share_SelectTarget
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]
            java.lang.String r4 = "target"
            r3[r2] = r4
            com.nexstreaming.kinemaster.ui.share.ShareActivity r4 = r6.f4285a
            android.content.res.Resources r4 = r4.getResources()
            com.nexstreaming.kinemaster.ui.share.ShareActivity r5 = r6.f4285a
            int r5 = com.nexstreaming.kinemaster.ui.share.ShareActivity.a(r5)
            java.lang.String r4 = r4.getResourceName(r5)
            r3[r1] = r4
            r0.logEvent(r3)
            android.content.Intent r0 = new android.content.Intent
            com.nexstreaming.kinemaster.ui.share.ShareActivity r1 = r6.f4285a
            java.lang.Class<com.nexstreaming.kinemaster.ui.share.ShareQualityActivity> r3 = com.nexstreaming.kinemaster.ui.share.ShareQualityActivity.class
            r0.<init>(r1, r3)
            com.nexstreaming.kinemaster.ui.share.ShareActivity r1 = r6.f4285a
            com.nexstreaming.kinemaster.ui.widget.ImageCyclerView r1 = r1.f()
            r1.a(r0)
            com.nexstreaming.kinemaster.ui.share.ShareActivity r1 = r6.f4285a
            android.content.Intent r1 = r1.getIntent()
            r0.putExtras(r1)
            com.nexstreaming.kinemaster.ui.share.ShareActivity r1 = r6.f4285a
            android.content.Intent r1 = r1.getIntent()
            android.net.Uri r1 = r1.getData()
            r0.setData(r1)
            java.lang.String r1 = "kinemaster.shareTo"
            com.nexstreaming.kinemaster.ui.share.ShareActivity r3 = r6.f4285a
            int r3 = com.nexstreaming.kinemaster.ui.share.ShareActivity.a(r3)
            r0.putExtra(r1, r3)
            com.nexstreaming.kinemaster.ui.share.ShareActivity r1 = r6.f4285a
            r1.startActivity(r0)
            com.nexstreaming.kinemaster.ui.share.ShareActivity r0 = r6.f4285a
            r0.overridePendingTransition(r2, r2)
            com.nexstreaming.kinemaster.ui.share.ShareActivity r0 = r6.f4285a
            r1 = -1
            com.nexstreaming.kinemaster.ui.share.ShareActivity.a(r0, r1)
            goto L4d
        Lba:
            com.nexstreaming.kinemaster.ui.share.ShareActivity r0 = r6.f4285a
            com.nexstreaming.kinemaster.ui.share.ShareActivity.b(r0)
            goto L4d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.share.aa.onClick(android.view.View):void");
    }
}
