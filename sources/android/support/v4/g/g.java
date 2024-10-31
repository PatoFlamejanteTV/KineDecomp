package android.support.v4.g;

import android.support.v4.g.f;
import android.view.LayoutInflater;

/* compiled from: LayoutInflaterCompatLollipop.java */
/* loaded from: classes2.dex */
class g {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LayoutInflater layoutInflater, h hVar) {
        layoutInflater.setFactory2(hVar != null ? new f.a(hVar) : null);
    }
}
