package com.nextreaming.nexeditorui;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.nextreaming.nexeditorui.La;

/* compiled from: NexPrefsFrag.java */
/* loaded from: classes.dex */
class Ja implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String[] f24048a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ La.a f24049b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ja(La.a aVar, String[] strArr) {
        this.f24049b = aVar;
        this.f24048a = strArr;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        SharedPreferences sharedPreferences = this.f24049b.getActivity().getSharedPreferences("sdcardloc", 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            String[] strArr = this.f24048a;
            i2 = this.f24049b.f24065b;
            edit.putString("sdcardlocation", strArr[i2]);
            edit.apply();
        }
    }
}
