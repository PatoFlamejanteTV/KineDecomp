package com.nextreaming.nexeditorui.newproject;

import android.view.View;
import android.widget.ImageView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewProjectActivity.java */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ImageView f4685a;
    final /* synthetic */ View b;
    final /* synthetic */ NewProjectActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NewProjectActivity newProjectActivity, ImageView imageView, View view) {
        this.c = newProjectActivity;
        this.f4685a = imageView;
        this.b = view;
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x001e */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.view.View r4) {
        /*
            r3 = this;
            r1 = 0
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r0 = r3.c
            boolean r0 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.b(r0)
            if (r0 != 0) goto L41
            android.widget.ImageView r0 = r3.f4685a
            int r0 = r0.getVisibility()
            r2 = 8
            if (r0 != r2) goto L41
            r0 = r1
        L14:
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r2 = r3.c
            android.widget.LinearLayout r2 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.c(r2)
            int r2 = r2.getChildCount()
            if (r0 >= r2) goto L41
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r2 = r3.c
            android.widget.LinearLayout r2 = com.nextreaming.nexeditorui.newproject.NewProjectActivity.c(r2)
            android.view.View r2 = r2.getChildAt(r0)
            if (r2 != r4) goto L42
            android.widget.ImageView r2 = r3.f4685a
            r2.setVisibility(r1)
            android.view.View r2 = r3.b
            r2.setVisibility(r1)
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r1 = r3.c
            com.nextreaming.nexeditorui.newproject.NewProjectActivity.a(r1, r0)
            com.nextreaming.nexeditorui.newproject.NewProjectActivity r0 = r3.c
            r1 = 1
            com.nextreaming.nexeditorui.newproject.NewProjectActivity.a(r0, r1)
        L41:
            return
        L42:
            int r0 = r0 + 1
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexeditorui.newproject.d.onClick(android.view.View):void");
    }
}
