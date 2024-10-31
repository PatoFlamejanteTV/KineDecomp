package com.nexstreaming.kinemaster.ui.share;

import android.util.Log;
import java.util.Locale;

/* compiled from: ExportLoggerFactory.java */
/* loaded from: classes.dex */
final class i implements f {
    @Override // com.nexstreaming.kinemaster.ui.share.f
    public void a(String str, String... strArr) {
        Log.i("ExportLogger", String.format(Locale.US, str, strArr));
    }

    @Override // com.nexstreaming.kinemaster.ui.share.f
    public boolean a() {
        return true;
    }
}
