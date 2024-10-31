package com.nextreaming.nexeditorui.fontbrowser;

import android.content.Context;
import com.nexstreaming.kinemaster.kmpackage.y;
import java.util.Comparator;

/* compiled from: FontBrowserActivity.java */
/* loaded from: classes.dex */
class j implements Comparator<y> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f4634a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.f4634a = iVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(y yVar, y yVar2) {
        Context context;
        Context context2;
        context = this.f4634a.f4633a.f4624a;
        String a2 = yVar.a(context);
        context2 = this.f4634a.f4633a.f4624a;
        return a2.compareTo(yVar2.a(context2));
    }
}
