package com.nexstreaming.kinemaster.ui.a;

import android.view.View;
import com.nexstreaming.kinemaster.ui.a.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexDialog.java */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f3650a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f3650a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag != null && (tag instanceof a.b)) {
            a.b bVar = (a.b) tag;
            if (bVar.c != null) {
                bVar.c.onClick(this.f3650a, bVar.f3649a);
            }
        }
    }
}
