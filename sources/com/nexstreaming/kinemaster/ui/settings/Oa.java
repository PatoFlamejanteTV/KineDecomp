package com.nexstreaming.kinemaster.ui.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.Toast;
import com.nexstreaming.app.general.service.alarm.AlarmData;

/* compiled from: SettingFragment.java */
/* loaded from: classes2.dex */
public class Oa implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EditText f23072a;

    /* renamed from: b */
    final /* synthetic */ Context f23073b;

    public Oa(EditText editText, Context context) {
        this.f23072a = editText;
        this.f23073b = context;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f23072a.getText() != null) {
            int i2 = 0;
            try {
                i2 = Integer.parseInt(this.f23072a.getText().toString().trim());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (i2 > 0) {
                AlarmData b2 = com.nexstreaming.app.general.service.alarm.a.a(this.f23073b).b();
                if (b2 != null) {
                    b2.dTime = System.currentTimeMillis() + (i2 * 1000);
                    com.nexstreaming.app.general.service.alarm.a.a(this.f23073b).a(b2);
                    Toast.makeText(this.f23073b, "set trigger time to" + i2 + " sec", 1).show();
                    return;
                }
                return;
            }
            Toast.makeText(this.f23073b, "invalid value", 1).show();
        }
    }
}
