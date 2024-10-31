package com.nexstreaming.kinemaster.ui.settings;

import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import com.nexstreaming.kinemaster.codeccaps.CapabilityManager;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: CodecLimitsSettings.java */
/* loaded from: classes2.dex */
class F implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Spinner f23039a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Spinner f23040b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Spinner f23041c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ EditText f23042d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ View f23043e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ CodecLimitsSettings f23044f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public F(CodecLimitsSettings codecLimitsSettings, Spinner spinner, Spinner spinner2, Spinner spinner3, EditText editText, View view) {
        this.f23044f = codecLimitsSettings;
        this.f23039a = spinner;
        this.f23040b = spinner2;
        this.f23041c = spinner3;
        this.f23042d = editText;
        this.f23043e = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        boolean z;
        NexEditor z2;
        NexEditor z3;
        NexEditor z4;
        NexEditor z5;
        CapabilityManager capabilityManager = CapabilityManager.f20040b;
        CapabilityManager.CapabilitySource[] values = CapabilityManager.CapabilitySource.values();
        i = this.f23044f.I;
        capabilityManager.a(values[i]);
        String str = (String) this.f23039a.getSelectedItem();
        int parseInt = Integer.parseInt(str.substring(0, str.indexOf(112)));
        int parseInt2 = Integer.parseInt((String) this.f23040b.getSelectedItem());
        String str2 = (String) this.f23041c.getSelectedItem();
        int parseInt3 = Integer.parseInt(str2.substring(0, str2.indexOf(112)));
        z = this.f23044f.J;
        if (!z || String.valueOf(this.f23042d.getText()).equals("") || String.valueOf(this.f23042d.getText()) == null) {
            this.f23043e.callOnClick();
        }
        int parseInt4 = Integer.parseInt(String.valueOf(this.f23042d.getText()));
        CapabilityManager.f20040b.i(parseInt);
        CapabilityManager.f20040b.h(parseInt2);
        CapabilityManager.f20040b.j(parseInt3);
        CapabilityManager.f20040b.g(parseInt4);
        z2 = this.f23044f.z();
        z2.clearTrackCache();
        z3 = this.f23044f.z();
        z3.closeProject();
        z4 = this.f23044f.z();
        z4.b(-1, -1, -1);
        z5 = this.f23044f.z();
        z5.createProject();
        this.f23044f.finish();
    }
}
