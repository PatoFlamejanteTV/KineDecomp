package com.nextreaming.nexeditorui.newproject;

import android.view.View;

/* compiled from: NewProjectActivity.java */
/* loaded from: classes.dex */
class i implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NewProjectActivity f4690a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NewProjectActivity newProjectActivity) {
        this.f4690a = newProjectActivity;
    }

    /* JADX WARN: Incorrect condition in loop: B:14:0x0096 */
    @Override // android.view.View.OnLongClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onLongClick(android.view.View r8) {
        /*
            r7 = this;
            r6 = 1
            r2 = 0
            android.content.Context r0 = r8.getContext()
            java.lang.String r1 = "vibrator"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.os.Vibrator r0 = (android.os.Vibrator) r0
            r4 = 100
            r0.vibrate(r4)
            android.view.ViewParent r0 = r8.getParent()
            boolean r1 = r0 instanceof android.view.ViewGroup
            if (r1 == 0) goto L2f
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r1 = r2
        L1e:
            int r3 = r0.getChildCount()
            if (r1 >= r3) goto L2f
            android.view.View r3 = r0.getChildAt(r1)
            if (r3 != r8) goto Le7
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r0 = r7.f4690a
            com.nextreaming.nexeditorui.newproject.NewProjectActivity.c(r0, r1)
        L2f:
            java.lang.String r0 = "NewProjectActivity"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "LongClick position : "
            java.lang.StringBuilder r1 = r1.append(r3)
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r3 = r7.f4690a
            int r3 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.i(r3)
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            android.util.Log.i(r0, r1)
            android.content.ClipData$Item r0 = new android.content.ClipData$Item
            java.lang.String r1 = r8.toString()
            r0.<init>(r1)
            java.lang.String[] r1 = new java.lang.String[r6]
            java.lang.String r3 = "application/vnd.nexstreaming.kinemaster.cliporder"
            r1[r2] = r3
            android.content.ClipData r3 = new android.content.ClipData
            java.lang.String r4 = "selectedViewId"
            r3.<init>(r4, r1, r0)
            android.view.View$DragShadowBuilder r0 = new android.view.View$DragShadowBuilder
            r0.<init>(r8)
            r8.startDrag(r3, r0, r8, r2)
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r0 = r7.f4690a
            r1 = 2
            int[] r1 = new int[r1]
            com.nextreaming.nexeditorui.newproject.NewProjectActivity.a(r0, r1)
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r0 = r7.f4690a
            android.widget.LinearLayout r0 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.c(r0)
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r1 = r7.f4690a
            int[] r1 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.j(r1)
            r0.getLocationInWindow(r1)
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r0 = r7.f4690a
            java.util.ArrayList r0 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.k(r0)
            r0.clear()
            r0 = r2
        L8c:
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r1 = r7.f4690a
            android.widget.LinearLayout r1 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.c(r1)
            int r1 = r1.getChildCount()
            if (r0 >= r1) goto Leb
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r1 = r7.f4690a
            android.widget.LinearLayout r1 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.c(r1)
            android.view.View r1 = r1.getChildAt(r0)
            int r3 = r1.getLeft()
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r4 = r7.f4690a
            java.util.ArrayList r4 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.k(r4)
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r5 = r7.f4690a
            int[] r5 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.j(r5)
            r5 = r5[r2]
            int r3 = r3 + r5
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4.add(r3)
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r3 = r7.f4690a
            android.widget.LinearLayout r3 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.c(r3)
            int r3 = r3.getChildCount()
            int r3 = r3 + (-1)
            if (r0 != r3) goto Le4
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r3 = r7.f4690a
            java.util.ArrayList r3 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.k(r3)
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r4 = r7.f4690a
            int[] r4 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.j(r4)
            r4 = r4[r2]
            int r1 = r1.getRight()
            int r1 = r1 + r4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3.add(r1)
        Le4:
            int r0 = r0 + 1
            goto L8c
        Le7:
            int r1 = r1 + 1
            goto L1e
        Leb:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexeditorui.newproject.i.onLongClick(android.view.View):boolean");
    }
}
