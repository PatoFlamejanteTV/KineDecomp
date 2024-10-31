package com.nexstreaming.app.general.preferences;

import android.support.v7.widget.SwitchCompat;
import android.view.View;
import com.nexstreaming.app.general.preferences.NexSwitchPreference;

/* compiled from: NexSwitchPreference.java */
/* loaded from: classes.dex */
class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SwitchCompat f3182a;
    final /* synthetic */ NexSwitchPreference b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(NexSwitchPreference nexSwitchPreference, SwitchCompat switchCompat) {
        this.b = nexSwitchPreference;
        this.f3182a = switchCompat;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexSwitchPreference.a aVar;
        NexSwitchPreference.a aVar2;
        aVar = this.b.f3180a;
        if (aVar != null) {
            aVar2 = this.b.f3180a;
            aVar2.onCheckedChanged(this.f3182a, !this.f3182a.isChecked());
        }
    }
}
