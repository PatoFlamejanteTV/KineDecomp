package com.nexstreaming.kinemaster.ui.settings;

import android.view.View;

/* compiled from: SettingsActivity.java */
/* loaded from: classes.dex */
class as implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SettingsActivity f4245a;
    private boolean b = false;
    private int c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(SettingsActivity settingsActivity) {
        this.f4245a = settingsActivity;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0009, code lost:            return true;     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            r4 = 1
            r3 = 0
            int r0 = r7.getActionMasked()
            switch(r0) {
                case 0: goto La;
                case 1: goto L44;
                case 2: goto L9;
                case 3: goto L44;
                case 4: goto L9;
                case 5: goto L9;
                case 6: goto Lf;
                default: goto L9;
            }
        L9:
            return r4
        La:
            r5.b = r4
            r5.c = r3
            goto L9
        Lf:
            boolean r0 = r5.b
            if (r0 == 0) goto L9
            int r0 = r7.getActionIndex()
            if (r0 != r4) goto L9
            int r0 = r5.c
            int r0 = r0 + 1
            r5.c = r0
            int r0 = r5.c
            r1 = 3
            if (r0 < r1) goto L9
            com.nexstreaming.kinemaster.ui.settings.SettingsActivity r0 = r5.f4245a
            android.app.FragmentManager r0 = r0.getFragmentManager()
            android.app.FragmentTransaction r0 = r0.beginTransaction()
            r1 = 2131820864(0x7f110140, float:1.9274455E38)
            com.nexstreaming.kinemaster.ui.settings.w r2 = new com.nexstreaming.kinemaster.ui.settings.w
            r2.<init>()
            r0.replace(r1, r2)
            java.lang.String r1 = ""
            r0.addToBackStack(r1)
            r0.commit()
            r5.b = r3
            goto L9
        L44:
            r5.b = r3
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.settings.as.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
