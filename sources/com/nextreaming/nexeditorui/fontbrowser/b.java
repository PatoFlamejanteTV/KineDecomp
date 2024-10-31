package com.nextreaming.nexeditorui.fontbrowser;

import android.content.Context;
import com.nexstreaming.kinemaster.kmpackage.y;
import java.util.Comparator;

/* compiled from: FontBrowserActivity.java */
/* loaded from: classes.dex */
class b implements Comparator<y> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FontBrowserActivity f4626a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FontBrowserActivity fontBrowserActivity) {
        this.f4626a = fontBrowserActivity;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(y yVar, y yVar2) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        context = this.f4626a.f4624a;
        String a2 = yVar.a(context);
        context2 = this.f4626a.f4624a;
        if (a2 == yVar2.a(context2)) {
            return 0;
        }
        context3 = this.f4626a.f4624a;
        if (yVar.a(context3) == null) {
            return -1;
        }
        context4 = this.f4626a.f4624a;
        if (yVar2.a(context4) == null) {
            return 1;
        }
        context5 = this.f4626a.f4624a;
        String a3 = yVar.a(context5);
        context6 = this.f4626a.f4624a;
        return a3.compareTo(yVar2.a(context6));
    }
}
