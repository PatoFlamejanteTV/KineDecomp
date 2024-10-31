package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.aw;

/* compiled from: RemoteInputCompatJellybean.java */
/* loaded from: classes.dex */
class ax {
    static Bundle a(aw.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", aVar.a());
        bundle.putCharSequence("label", aVar.b());
        bundle.putCharSequenceArray("choices", aVar.c());
        bundle.putBoolean("allowFreeFormInput", aVar.d());
        bundle.putBundle("extras", aVar.e());
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle[] a(aw.a[] aVarArr) {
        if (aVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            bundleArr[i] = a(aVarArr[i]);
        }
        return bundleArr;
    }
}
