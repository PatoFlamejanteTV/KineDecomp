package com.nextreaming.nexeditorui.newproject;

import android.view.View;

/* compiled from: NewProjectActivity.java */
/* loaded from: classes3.dex */
class g implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NewProjectActivity f24369a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(NewProjectActivity newProjectActivity) {
        this.f24369a = newProjectActivity;
    }

    /* JADX WARN: Incorrect condition in loop: B:14:0x0098 */
    @Override // android.view.View.OnLongClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onLongClick(android.view.View r7) {
        /*
            r6 = this;
            android.content.Context r0 = r7.getContext()
            java.lang.String r1 = "vibrator"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.os.Vibrator r0 = (android.os.Vibrator) r0
            r1 = 100
            r0.vibrate(r1)
            android.view.ViewParent r0 = r7.getParent()
            boolean r1 = r0 instanceof android.view.ViewGroup
            r2 = 0
            if (r1 == 0) goto L32
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r1 = 0
        L1d:
            int r3 = r0.getChildCount()
            if (r1 >= r3) goto L32
            android.view.View r3 = r0.getChildAt(r1)
            if (r3 != r7) goto L2f
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r0 = r6.f24369a
            com.nextreaming.nexeditorui.newproject.NewProjectActivity.a(r0, r1)
            goto L32
        L2f:
            int r1 = r1 + 1
            goto L1d
        L32:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "LongClick position : "
            r0.append(r1)
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r1 = r6.f24369a
            int r1 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.a(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "NewProjectActivity"
            android.util.Log.i(r1, r0)
            android.content.ClipData$Item r0 = new android.content.ClipData$Item
            java.lang.String r1 = r7.toString()
            r0.<init>(r1)
            r1 = 1
            java.lang.String[] r3 = new java.lang.String[r1]
            java.lang.String r4 = "application/vnd.nexstreaming.kinemaster.cliporder"
            r3[r2] = r4
            android.content.ClipData r4 = new android.content.ClipData
            java.lang.String r5 = "selectedViewId"
            r4.<init>(r5, r3, r0)
            android.view.View$DragShadowBuilder r0 = new android.view.View$DragShadowBuilder
            r0.<init>(r7)
            r7.startDrag(r4, r0, r7, r2)
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r7 = r6.f24369a
            r0 = 2
            int[] r0 = new int[r0]
            com.nextreaming.nexeditorui.newproject.NewProjectActivity.a(r7, r0)
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r7 = r6.f24369a
            android.widget.LinearLayout r7 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.e(r7)
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r0 = r6.f24369a
            int[] r0 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.b(r0)
            r7.getLocationInWindow(r0)
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r7 = r6.f24369a
            java.util.ArrayList r7 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.f(r7)
            r7.clear()
            r7 = 0
        L8e:
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r0 = r6.f24369a
            android.widget.LinearLayout r0 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.e(r0)
            int r0 = r0.getChildCount()
            if (r7 >= r0) goto Le8
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r0 = r6.f24369a
            android.widget.LinearLayout r0 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.e(r0)
            android.view.View r0 = r0.getChildAt(r7)
            int r3 = r0.getLeft()
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r4 = r6.f24369a
            java.util.ArrayList r4 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.f(r4)
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r5 = r6.f24369a
            int[] r5 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.b(r5)
            r5 = r5[r2]
            int r5 = r5 + r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r3 = r6.f24369a
            android.widget.LinearLayout r3 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.e(r3)
            int r3 = r3.getChildCount()
            int r3 = r3 - r1
            if (r7 != r3) goto Le5
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r3 = r6.f24369a
            java.util.ArrayList r3 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.f(r3)
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r4 = r6.f24369a
            int[] r4 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.b(r4)
            r4 = r4[r2]
            int r0 = r0.getRight()
            int r4 = r4 + r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            r3.add(r0)
        Le5:
            int r7 = r7 + 1
            goto L8e
        Le8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexeditorui.newproject.g.onLongClick(android.view.View):boolean");
    }
}
