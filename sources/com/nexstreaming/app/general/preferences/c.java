package com.nexstreaming.app.general.preferences;

import android.support.v7.widget.SwitchCompat;
import android.view.View;
import com.nexstreaming.app.general.preferences.NexSwitchPreference;

/* compiled from: NexSwitchPreference.java */
/* loaded from: classes2.dex */
class c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SwitchCompat f19664a;

    /* renamed from: b */
    final /* synthetic */ NexSwitchPreference f19665b;

    public c(NexSwitchPreference nexSwitchPreference, SwitchCompat switchCompat) {
        this.f19665b = nexSwitchPreference;
        this.f19664a = switchCompat;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexSwitchPreference.a aVar;
        NexSwitchPreference.a aVar2;
        aVar = this.f19665b.f19660a;
        if (aVar != null) {
            aVar2 = this.f19665b.f19660a;
            SwitchCompat switchCompat = this.f19664a;
            aVar2.onCheckedChanged(switchCompat, !switchCompat.isChecked());
        }
    }
}
