package com.nextreaming.nexeditorui;

import android.view.View;
import com.nextreaming.nexeditorui.NexEditorHelp;

/* compiled from: NexEditorHelp.java */
/* loaded from: classes.dex */
class bz implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditorHelp.a f4562a;
    final /* synthetic */ NexEditorHelp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(NexEditorHelp nexEditorHelp, NexEditorHelp.a aVar) {
        this.b = nexEditorHelp;
        this.f4562a = aVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:9:0x0024 */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.view.View r7) {
        /*
            r6 = this;
            r5 = 4
            r2 = 0
            com.nextreaming.nexeditorui.NexEditorHelp$a r0 = r6.f4562a
            java.lang.String r0 = r0.e
            if (r0 != 0) goto L53
            r0 = 0
        L9:
            com.nextreaming.nexeditorui.NexEditorHelp$a r1 = r6.f4562a
            com.nexstreaming.kinemaster.tracelog.KMAppUsage$KMMetric r1 = r1.g
            if (r1 == 0) goto L1c
            com.nextreaming.nexeditorui.NexEditorHelp r1 = r6.b
            com.nexstreaming.app.general.tracelog.AppUsage r1 = com.nexstreaming.kinemaster.tracelog.KMAppUsage.a(r1)
            com.nextreaming.nexeditorui.NexEditorHelp$a r3 = r6.f4562a
            com.nexstreaming.kinemaster.tracelog.KMAppUsage$KMMetric r3 = r3.g
            r1.a(r3)
        L1c:
            r1 = r2
        L1d:
            com.nextreaming.nexeditorui.NexEditorHelp r3 = r6.b
            com.nextreaming.nexeditorui.NexEditorHelp$a[] r3 = com.nextreaming.nexeditorui.NexEditorHelp.a(r3)
            int r3 = r3.length
            if (r1 >= r3) goto L71
            com.nextreaming.nexeditorui.NexEditorHelp r3 = r6.b
            com.nextreaming.nexeditorui.NexEditorHelp$a[] r3 = com.nextreaming.nexeditorui.NexEditorHelp.a(r3)
            r3 = r3[r1]
            android.view.View r3 = r3.c
            r3.setSelected(r2)
            com.nextreaming.nexeditorui.NexEditorHelp r3 = r6.b
            com.nextreaming.nexeditorui.NexEditorHelp$a[] r3 = com.nextreaming.nexeditorui.NexEditorHelp.a(r3)
            r3 = r3[r1]
            android.view.View r3 = r3.d
            com.nextreaming.nexeditorui.NexEditorHelp$a r4 = r6.f4562a
            android.view.View r4 = r4.d
            if (r3 == r4) goto L50
            com.nextreaming.nexeditorui.NexEditorHelp r3 = r6.b
            com.nextreaming.nexeditorui.NexEditorHelp$a[] r3 = com.nextreaming.nexeditorui.NexEditorHelp.a(r3)
            r3 = r3[r1]
            android.view.View r3 = r3.d
            r3.setVisibility(r5)
        L50:
            int r1 = r1 + 1
            goto L1d
        L53:
            com.nextreaming.nexeditorui.NexEditorHelp r0 = r6.b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "file:///android_asset/help/"
            java.lang.StringBuilder r1 = r1.append(r3)
            com.nextreaming.nexeditorui.NexEditorHelp$a r3 = r6.f4562a
            java.lang.String r3 = r3.e
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.String r0 = com.nextreaming.nexeditorui.NexEditorHelp.a(r0, r1)
            goto L9
        L71:
            com.nextreaming.nexeditorui.NexEditorHelp$a r1 = r6.f4562a
            android.view.View r1 = r1.c
            com.nextreaming.nexeditorui.NexEditorHelp r3 = r6.b
            com.nextreaming.nexeditorui.NexEditorHelp$a[] r3 = com.nextreaming.nexeditorui.NexEditorHelp.a(r3)
            r3 = r3[r2]
            android.view.View r3 = r3.c
            if (r1 == r3) goto La2
            com.nextreaming.nexeditorui.NexEditorHelp$a r1 = r6.f4562a
            android.view.View r1 = r1.c
            com.nextreaming.nexeditorui.NexEditorHelp r3 = r6.b
            com.nextreaming.nexeditorui.NexEditorHelp$a[] r3 = com.nextreaming.nexeditorui.NexEditorHelp.a(r3)
            r4 = 3
            r3 = r3[r4]
            android.view.View r3 = r3.c
            if (r1 == r3) goto La2
            com.nextreaming.nexeditorui.NexEditorHelp$a r1 = r6.f4562a
            android.view.View r1 = r1.c
            com.nextreaming.nexeditorui.NexEditorHelp r3 = r6.b
            com.nextreaming.nexeditorui.NexEditorHelp$a[] r3 = com.nextreaming.nexeditorui.NexEditorHelp.a(r3)
            r3 = r3[r5]
            android.view.View r3 = r3.c
            if (r1 != r3) goto Lcb
        La2:
            com.nextreaming.nexeditorui.NexEditorHelp r1 = r6.b
            android.view.View r1 = com.nextreaming.nexeditorui.NexEditorHelp.d(r1)
            r1.setVisibility(r5)
            com.nextreaming.nexeditorui.NexEditorHelp r1 = r6.b
            android.view.View r1 = com.nextreaming.nexeditorui.NexEditorHelp.e(r1)
            r1.setVisibility(r5)
        Lb4:
            com.nextreaming.nexeditorui.NexEditorHelp r1 = r6.b
            android.webkit.WebView r1 = com.nextreaming.nexeditorui.NexEditorHelp.b(r1)
            r1.loadUrl(r0)
            com.nextreaming.nexeditorui.NexEditorHelp r0 = r6.b
            com.nextreaming.nexeditorui.NexEditorHelp.c(r0)
            com.nextreaming.nexeditorui.NexEditorHelp$a r0 = r6.f4562a
            android.view.View r0 = r0.c
            r1 = 1
            r0.setSelected(r1)
            return
        Lcb:
            com.nextreaming.nexeditorui.NexEditorHelp r1 = r6.b
            android.view.View r1 = com.nextreaming.nexeditorui.NexEditorHelp.d(r1)
            r1.setVisibility(r2)
            com.nextreaming.nexeditorui.NexEditorHelp r1 = r6.b
            android.view.View r1 = com.nextreaming.nexeditorui.NexEditorHelp.e(r1)
            r1.setVisibility(r2)
            goto Lb4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexeditorui.bz.onClick(android.view.View):void");
    }
}
