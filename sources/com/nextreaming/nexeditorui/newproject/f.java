package com.nextreaming.nexeditorui.newproject;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.nexstreaming.kinemaster.ui.widget.AutoResizeTextView;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewProjectActivity.java */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ImageView f4687a;
    final /* synthetic */ View b;
    final /* synthetic */ NewProjectActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NewProjectActivity newProjectActivity, ImageView imageView, View view) {
        this.c = newProjectActivity;
        this.f4687a = imageView;
        this.b = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        LinearLayout linearLayout;
        int i;
        int i2;
        ArrayList arrayList;
        View view2;
        AutoResizeTextView autoResizeTextView;
        z = this.c.B;
        if (z && this.f4687a.getVisibility() == 0) {
            this.f4687a.setVisibility(8);
            this.b.setVisibility(8);
            linearLayout = this.c.t;
            i = this.c.C;
            linearLayout.removeViewAt(i);
            NewProjectActivity newProjectActivity = this.c;
            i2 = this.c.C;
            newProjectActivity.a(i2);
            arrayList = this.c.e;
            if (arrayList.size() <= 0) {
                view2 = this.c.q;
                view2.setEnabled(false);
                autoResizeTextView = this.c.r;
                autoResizeTextView.setEnabled(false);
            }
            this.c.c();
            this.c.B = false;
            this.c.C = -1;
        }
    }
}
