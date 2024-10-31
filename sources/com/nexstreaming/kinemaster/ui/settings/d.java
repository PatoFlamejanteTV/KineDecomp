package com.nexstreaming.kinemaster.ui.settings;

import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

/* compiled from: CodecLimitsSettings.java */
/* loaded from: classes2.dex */
class D implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Spinner f23025a;

    /* renamed from: b */
    final /* synthetic */ Spinner f23026b;

    /* renamed from: c */
    final /* synthetic */ EditText f23027c;

    /* renamed from: d */
    final /* synthetic */ CodecLimitsSettings f23028d;

    public D(CodecLimitsSettings codecLimitsSettings, Spinner spinner, Spinner spinner2, EditText editText) {
        this.f23028d = codecLimitsSettings;
        this.f23025a = spinner;
        this.f23026b = spinner2;
        this.f23027c = editText;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int c2;
        String str = (String) this.f23025a.getSelectedItem();
        int indexOf = str.indexOf(112);
        if (indexOf > -1) {
            int parseInt = Integer.parseInt(str.substring(0, indexOf));
            int parseInt2 = Integer.parseInt((String) this.f23026b.getSelectedItem());
            c2 = CodecLimitsSettings.c((parseInt * 16) / 9, parseInt);
            this.f23027c.setText(String.valueOf(c2 * parseInt2));
            this.f23028d.J = true;
        }
    }
}
