package com.nexstreaming.kinemaster.ui.settings;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nexstreaming.kinemaster.ui.settings.x;

/* compiled from: SettingFragment.java */
/* loaded from: classes.dex */
class ao implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String[] f4242a;
    final /* synthetic */ x.b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(x.b bVar, String[] strArr) {
        this.b = bVar;
        this.f4242a = strArr;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        SharedPreferences sharedPreferences = this.b.getActivity().getSharedPreferences("sdcardloc", 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            String[] strArr = this.f4242a;
            i2 = this.b.b;
            edit.putString("sdcardlocation", strArr[i2]);
            edit.apply();
            KMAppUsage.a(this.b.getActivity()).a(KMAppUsage.KMMetric.ChangeExportLocation);
        }
    }
}
