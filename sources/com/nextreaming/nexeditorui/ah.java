package com.nextreaming.nexeditorui;

import android.app.Activity;
import android.os.Handler;
import com.nexstreaming.app.general.iab.IABHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABWrapper.java */
/* loaded from: classes.dex */
public class ah implements IABHelper.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ af f4516a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar) {
        this.f4516a = afVar;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper.e
    public void a(boolean z, int i) {
        Activity activity;
        activity = this.f4516a.w;
        new Handler(activity.getMainLooper()).post(new ai(this, z, i));
    }
}
