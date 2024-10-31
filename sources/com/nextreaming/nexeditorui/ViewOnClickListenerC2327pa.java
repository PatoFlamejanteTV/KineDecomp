package com.nextreaming.nexeditorui;

import android.view.View;
import com.nextreaming.nexeditorui.NexEditorHelp;

/* compiled from: NexEditorHelp.java */
/* renamed from: com.nextreaming.nexeditorui.pa */
/* loaded from: classes.dex */
class ViewOnClickListenerC2327pa implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ NexEditorHelp.a f24388a;

    /* renamed from: b */
    final /* synthetic */ NexEditorHelp f24389b;

    public ViewOnClickListenerC2327pa(NexEditorHelp nexEditorHelp, NexEditorHelp.a aVar) {
        this.f24389b = nexEditorHelp;
        this.f24388a = aVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:6:0x002d */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.view.View r6) {
        /*
            r5 = this;
            com.nextreaming.nexeditorui.NexEditorHelp$a r6 = r5.f24388a
            java.lang.String r6 = r6.f24102e
            if (r6 != 0) goto L8
            r6 = 0
            goto L23
        L8:
            com.nextreaming.nexeditorui.NexEditorHelp r6 = r5.f24389b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "file:///android_asset/help/"
            r0.append(r1)
            com.nextreaming.nexeditorui.NexEditorHelp$a r1 = r5.f24388a
            java.lang.String r1 = r1.f24102e
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r6 = com.nextreaming.nexeditorui.NexEditorHelp.a(r6, r0)
        L23:
            r0 = 0
            r1 = 0
        L25:
            com.nextreaming.nexeditorui.NexEditorHelp r2 = r5.f24389b
            com.nextreaming.nexeditorui.NexEditorHelp$a[] r2 = com.nextreaming.nexeditorui.NexEditorHelp.a(r2)
            int r2 = r2.length
            r3 = 4
            if (r1 >= r2) goto L5c
            com.nextreaming.nexeditorui.NexEditorHelp r2 = r5.f24389b
            com.nextreaming.nexeditorui.NexEditorHelp$a[] r2 = com.nextreaming.nexeditorui.NexEditorHelp.a(r2)
            r2 = r2[r1]
            android.view.View r2 = r2.f24100c
            r2.setSelected(r0)
            com.nextreaming.nexeditorui.NexEditorHelp r2 = r5.f24389b
            com.nextreaming.nexeditorui.NexEditorHelp$a[] r2 = com.nextreaming.nexeditorui.NexEditorHelp.a(r2)
            r2 = r2[r1]
            android.view.View r2 = r2.f24101d
            com.nextreaming.nexeditorui.NexEditorHelp$a r4 = r5.f24388a
            android.view.View r4 = r4.f24101d
            if (r2 == r4) goto L59
            com.nextreaming.nexeditorui.NexEditorHelp r2 = r5.f24389b
            com.nextreaming.nexeditorui.NexEditorHelp$a[] r2 = com.nextreaming.nexeditorui.NexEditorHelp.a(r2)
            r2 = r2[r1]
            android.view.View r2 = r2.f24101d
            r2.setVisibility(r3)
        L59:
            int r1 = r1 + 1
            goto L25
        L5c:
            com.nextreaming.nexeditorui.NexEditorHelp$a r1 = r5.f24388a
            android.view.View r1 = r1.f24100c
            com.nextreaming.nexeditorui.NexEditorHelp r2 = r5.f24389b
            com.nextreaming.nexeditorui.NexEditorHelp$a[] r2 = com.nextreaming.nexeditorui.NexEditorHelp.a(r2)
            r2 = r2[r0]
            android.view.View r2 = r2.f24100c
            if (r1 == r2) goto La1
            com.nextreaming.nexeditorui.NexEditorHelp$a r1 = r5.f24388a
            android.view.View r1 = r1.f24100c
            com.nextreaming.nexeditorui.NexEditorHelp r2 = r5.f24389b
            com.nextreaming.nexeditorui.NexEditorHelp$a[] r2 = com.nextreaming.nexeditorui.NexEditorHelp.a(r2)
            r4 = 3
            r2 = r2[r4]
            android.view.View r2 = r2.f24100c
            if (r1 == r2) goto La1
            com.nextreaming.nexeditorui.NexEditorHelp$a r1 = r5.f24388a
            android.view.View r1 = r1.f24100c
            com.nextreaming.nexeditorui.NexEditorHelp r2 = r5.f24389b
            com.nextreaming.nexeditorui.NexEditorHelp$a[] r2 = com.nextreaming.nexeditorui.NexEditorHelp.a(r2)
            r2 = r2[r3]
            android.view.View r2 = r2.f24100c
            if (r1 != r2) goto L8e
            goto La1
        L8e:
            com.nextreaming.nexeditorui.NexEditorHelp r1 = r5.f24389b
            android.view.View r1 = com.nextreaming.nexeditorui.NexEditorHelp.d(r1)
            r1.setVisibility(r0)
            com.nextreaming.nexeditorui.NexEditorHelp r1 = r5.f24389b
            android.view.View r1 = com.nextreaming.nexeditorui.NexEditorHelp.e(r1)
            r1.setVisibility(r0)
            goto Lb3
        La1:
            com.nextreaming.nexeditorui.NexEditorHelp r0 = r5.f24389b
            android.view.View r0 = com.nextreaming.nexeditorui.NexEditorHelp.d(r0)
            r0.setVisibility(r3)
            com.nextreaming.nexeditorui.NexEditorHelp r0 = r5.f24389b
            android.view.View r0 = com.nextreaming.nexeditorui.NexEditorHelp.e(r0)
            r0.setVisibility(r3)
        Lb3:
            com.nextreaming.nexeditorui.NexEditorHelp r0 = r5.f24389b
            android.webkit.WebView r0 = com.nextreaming.nexeditorui.NexEditorHelp.b(r0)
            r0.loadUrl(r6)
            com.nextreaming.nexeditorui.NexEditorHelp r6 = r5.f24389b
            com.nextreaming.nexeditorui.NexEditorHelp.c(r6)
            com.nextreaming.nexeditorui.NexEditorHelp$a r6 = r5.f24388a
            android.view.View r6 = r6.f24100c
            r0 = 1
            r6.setSelected(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexeditorui.ViewOnClickListenerC2327pa.onClick(android.view.View):void");
    }
}
