package com.nexstreaming.app.general.preferences;

import android.support.v7.widget.SwitchCompat;
import android.view.KeyEvent;
import android.view.View;
import com.nexstreaming.app.general.preferences.NexSwitchPreference;

/* compiled from: NexSwitchPreference.java */
/* loaded from: classes2.dex */
class d implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ SwitchCompat f19666a;

    /* renamed from: b */
    final /* synthetic */ NexSwitchPreference f19667b;

    public d(NexSwitchPreference nexSwitchPreference, SwitchCompat switchCompat) {
        this.f19667b = nexSwitchPreference;
        this.f19666a = switchCompat;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        NexSwitchPreference.a aVar;
        NexSwitchPreference.a aVar2;
        if (keyEvent.getAction() != 0 || i != 66) {
            return false;
        }
        aVar = this.f19667b.f19660a;
        if (aVar != null) {
            aVar2 = this.f19667b.f19660a;
            SwitchCompat switchCompat = this.f19666a;
            aVar2.onCheckedChanged(switchCompat, switchCompat.isChecked() ? false : true);
        }
        return true;
    }
}
