package com.nextreaming.nexeditorui;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nextreaming.nexeditorui.cl;

/* compiled from: NexPrefsFrag.java */
/* loaded from: classes.dex */
class cu implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String[] f4583a;
    final /* synthetic */ cl.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(cl.a aVar, String[] strArr) {
        this.b = aVar;
        this.f4583a = strArr;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        SharedPreferences sharedPreferences = this.b.getActivity().getSharedPreferences("sdcardloc", 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            String[] strArr = this.f4583a;
            i2 = this.b.b;
            edit.putString("sdcardlocation", strArr[i2]);
            edit.apply();
            KMAppUsage.a(this.b.getActivity()).a(KMAppUsage.KMMetric.ChangeExportLocation);
        }
    }
}
