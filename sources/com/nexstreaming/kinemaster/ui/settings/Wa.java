package com.nexstreaming.kinemaster.ui.settings;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.nexstreaming.kinemaster.ui.settings.Ua;

/* compiled from: SettingFragment.java */
/* loaded from: classes2.dex */
class Wa implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String[] f23094a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ua.b f23095b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Wa(Ua.b bVar, String[] strArr) {
        this.f23095b = bVar;
        this.f23094a = strArr;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        SharedPreferences sharedPreferences = this.f23095b.getActivity().getSharedPreferences("sdcardloc", 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            String[] strArr = this.f23094a;
            i2 = this.f23095b.f23092b;
            edit.putString("sdcardlocation", strArr[i2]);
            edit.apply();
        }
    }
}
