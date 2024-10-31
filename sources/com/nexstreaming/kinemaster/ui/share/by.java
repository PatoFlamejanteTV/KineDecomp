package com.nexstreaming.kinemaster.ui.share;

import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import java.util.List;
import org.apmem.tools.layouts.FlowLayout;

/* compiled from: ShareSNSActivity.java */
/* loaded from: classes.dex */
class by implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f4336a;
    final /* synthetic */ bw b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bw bwVar, View view) {
        this.b = bwVar;
        this.f4336a = view;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        List list;
        List list2;
        List list3;
        FlowLayout flowLayout;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            list = this.b.f4334a.s;
            if (i3 < list.size()) {
                list2 = this.b.f4334a.s;
                if (((String) list2.get(i3)) == ((TextView) this.f4336a).getText().toString()) {
                    list3 = this.b.f4334a.s;
                    list3.remove(i3);
                    flowLayout = this.b.f4334a.j;
                    flowLayout.removeView(this.f4336a);
                }
                i2 = i3 + 1;
            } else {
                dialogInterface.dismiss();
                return;
            }
        }
    }
}
