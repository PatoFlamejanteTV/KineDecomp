package com.nextreaming.nexeditorui;

import android.view.MotionEvent;
import android.view.View;
import com.nextreaming.nexeditorui.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorEffectListAdapter.java */
/* loaded from: classes.dex */
public class c implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f4563a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f4563a = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        b.a aVar;
        int intValue;
        b.a aVar2;
        if (motionEvent.getAction() == 1) {
            aVar = this.f4563a.d;
            if (aVar != null && (intValue = ((Integer) view.getTag()).intValue()) >= 0 && intValue < this.f4563a.getCount()) {
                aVar2 = this.f4563a.d;
                aVar2.a(intValue);
            }
        }
        return true;
    }
}
