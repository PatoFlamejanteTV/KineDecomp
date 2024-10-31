package android.support.v4.g;

import android.view.View;

/* compiled from: ViewPropertyAnimatorCompatJB.java */
/* loaded from: classes.dex */
class ab {
    public static void a(View view, ad adVar) {
        if (adVar != null) {
            view.animate().setListener(new ac(adVar, view));
        } else {
            view.animate().setListener(null);
        }
    }
}
