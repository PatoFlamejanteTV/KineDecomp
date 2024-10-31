package com.nextreaming.nexeditorui.fontbrowser;

import android.content.Context;
import java.util.Comparator;

/* compiled from: FontBrowserActivity.java */
/* loaded from: classes2.dex */
class i implements Comparator<com.nexstreaming.kinemaster.fonts.c> {

    /* renamed from: a */
    final /* synthetic */ Context f24271a;

    public i(Context context) {
        this.f24271a = context;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(com.nexstreaming.kinemaster.fonts.c cVar, com.nexstreaming.kinemaster.fonts.c cVar2) {
        if (cVar.getName(this.f24271a) == cVar2.getName(this.f24271a)) {
            return 0;
        }
        if (cVar.getName(this.f24271a) == null) {
            return -1;
        }
        if (cVar2.getName(this.f24271a) == null) {
            return 1;
        }
        return cVar.getName(this.f24271a).compareTo(cVar2.getName(this.f24271a));
    }
}
