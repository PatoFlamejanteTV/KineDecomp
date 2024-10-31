package com.nexstreaming.kinemaster.ui.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.Toast;
import com.nexstreaming.app.general.service.NexNotificationService;
import com.nexstreaming.app.general.service.alarm.AlarmData;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingFragment.java */
/* loaded from: classes.dex */
public final class ag implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EditText f4237a;
    final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(EditText editText, Context context) {
        this.f4237a = editText;
        this.b = context;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        if (this.f4237a.getText() != null) {
            try {
                i2 = Integer.parseInt(this.f4237a.getText().toString().trim());
            } catch (Exception e) {
                e.printStackTrace();
                i2 = 0;
            }
            if (i2 > 0) {
                AlarmData c = com.nexstreaming.app.general.service.alarm.b.a(this.b).c();
                if (c != null) {
                    c.dTime = System.currentTimeMillis() + (i2 * LicenseErrCode.LICENSE_STATUS_NOT_LICENSED);
                    NexNotificationService.a(this.b, c);
                    Toast.makeText(this.b, "set trigger time to" + i2 + " sec", 1).show();
                    return;
                }
                return;
            }
            Toast.makeText(this.b, "invalid value", 1).show();
        }
    }
}
