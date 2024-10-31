package com.nexstreaming.kinemaster.ui.b;

import com.nexstreaming.kinemaster.ui.b.f;

/* compiled from: EffectSettingsFragment.java */
/* loaded from: classes.dex */
class j implements f.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f3697a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.f3697a = iVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00da  */
    @Override // com.nexstreaming.kinemaster.ui.b.f.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            r7 = 1
            com.nexstreaming.kinemaster.ui.b.i r0 = r8.f3697a
            com.nexstreaming.kinemaster.kmpackage.au r0 = r0.f3696a
            java.lang.String r0 = r0.b()
            com.nexstreaming.kinemaster.ui.b.i r1 = r8.f3697a
            com.nexstreaming.kinemaster.ui.b.f r1 = r1.e
            android.view.View r1 = com.nexstreaming.kinemaster.ui.b.f.f(r1)
            if (r1 != 0) goto L14
        L13:
            return
        L14:
            com.nexstreaming.kinemaster.ui.b.i r1 = r8.f3697a
            com.nexstreaming.kinemaster.ui.b.f r1 = r1.e
            android.view.View r1 = com.nexstreaming.kinemaster.ui.b.f.f(r1)
            android.view.View r0 = r1.findViewWithTag(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L13
            if (r9 == 0) goto Lad
            com.nexstreaming.kinemaster.ui.b.i r1 = r8.f3697a
            com.nexstreaming.kinemaster.ui.b.f r1 = r1.e
            com.nextreaming.nexeditorui.NexTimelineItem$j r1 = com.nexstreaming.kinemaster.ui.b.f.e(r1)
            if (r1 == 0) goto L5a
            com.nexstreaming.kinemaster.ui.b.i r1 = r8.f3697a
            com.nexstreaming.kinemaster.ui.b.f r1 = r1.e
            com.nextreaming.nexeditorui.NexTimelineItem$j r1 = com.nexstreaming.kinemaster.ui.b.f.e(r1)
            java.util.Map r1 = r1.getEffectOptions()
            com.nexstreaming.kinemaster.ui.b.i r2 = r8.f3697a
            java.lang.String r2 = r2.b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r10)
            java.lang.String r4 = "\u001b"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r9)
            java.lang.String r3 = r3.toString()
            r1.put(r2, r3)
        L5a:
            if (r9 == 0) goto L62
            int r1 = r9.length()
            if (r1 >= r7) goto Lb2
        L62:
            r1 = -8947849(0xffffffffff777777, float:-3.2893961E38)
            r0.setTextColor(r1)
            com.nexstreaming.kinemaster.ui.b.i r1 = r8.f3697a
            java.lang.String r1 = r1.c
            r0.setText(r1)
        L6f:
            r2 = 0
            com.nexstreaming.kinemaster.ui.b.i r1 = r8.f3697a
            com.nexstreaming.kinemaster.ui.b.f r1 = r1.e
            com.nexstreaming.kinemaster.kmpackage.EffectLibrary r1 = com.nexstreaming.kinemaster.ui.b.f.g(r1)
            if (r1 == 0) goto Ld8
            if (r10 == 0) goto Ld8
            com.nexstreaming.kinemaster.ui.b.i r1 = r8.f3697a
            com.nexstreaming.kinemaster.ui.b.f r1 = r1.e
            com.nexstreaming.kinemaster.kmpackage.EffectLibrary r1 = com.nexstreaming.kinemaster.ui.b.f.g(r1)
            com.nexstreaming.kinemaster.kmpackage.Font r3 = r1.f(r10)
            if (r3 == 0) goto Ld8
            com.nexstreaming.kinemaster.ui.b.i r1 = r8.f3697a     // Catch: com.nexstreaming.kinemaster.kmpackage.Font.TypefaceLoadException -> Lbb
            com.nexstreaming.kinemaster.ui.b.f r1 = r1.e     // Catch: com.nexstreaming.kinemaster.kmpackage.Font.TypefaceLoadException -> Lbb
            android.app.Activity r1 = r1.getActivity()     // Catch: com.nexstreaming.kinemaster.kmpackage.Font.TypefaceLoadException -> Lbb
            android.graphics.Typeface r1 = r3.b(r1)     // Catch: com.nexstreaming.kinemaster.kmpackage.Font.TypefaceLoadException -> Lbb
        L96:
            if (r1 == 0) goto Lda
            r0.setTypeface(r1)
        L9b:
            com.nexstreaming.kinemaster.ui.b.i r1 = r8.f3697a
            com.nexstreaming.kinemaster.ui.b.f r1 = r1.e
            r1.d()
            com.nexstreaming.kinemaster.ui.b.i r1 = r8.f3697a
            com.nexstreaming.kinemaster.ui.b.f r1 = r1.e
            com.nexstreaming.kinemaster.editorwrapper.VideoEditor r1 = com.nexstreaming.kinemaster.ui.b.f.h(r1)
            r1.n()
        Lad:
            r0.setEnabled(r7)
            goto L13
        Lb2:
            r1 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0.setTextColor(r1)
            r0.setText(r9)
            goto L6f
        Lbb:
            r1 = move-exception
            java.lang.String r4 = "EffectSettingsFragment"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to get typeface (on change) for : "
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r3 = r3.m()
            java.lang.StringBuilder r3 = r5.append(r3)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r4, r3, r1)
        Ld8:
            r1 = r2
            goto L96
        Lda:
            android.graphics.Typeface r1 = android.graphics.Typeface.DEFAULT
            r0.setTypeface(r1)
            goto L9b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.b.j.a(java.lang.String, java.lang.String):void");
    }
}
