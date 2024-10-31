package com.nextreaming.nexeditorui;

import android.view.MotionEvent;
import android.view.View;
import com.nextreaming.nexeditorui.C2300c;

/* compiled from: ColorEffectListAdapter.java */
/* renamed from: com.nextreaming.nexeditorui.b */
/* loaded from: classes.dex */
public class ViewOnTouchListenerC2298b implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ C2300c f24215a;

    public ViewOnTouchListenerC2298b(C2300c c2300c) {
        this.f24215a = c2300c;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        C2300c.a aVar;
        int intValue;
        C2300c.a aVar2;
        if (motionEvent.getAction() == 1) {
            aVar = this.f24215a.f24220d;
            if (aVar != null && (intValue = ((Integer) view.getTag()).intValue()) >= 0 && intValue < this.f24215a.getCount()) {
                aVar2 = this.f24215a.f24220d;
                aVar2.a(intValue);
            }
        }
        return true;
    }
}
