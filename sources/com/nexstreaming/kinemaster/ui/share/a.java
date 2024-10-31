package com.nexstreaming.kinemaster.ui.share;

import android.util.Log;

/* compiled from: ExportLoggerFactory.java */
/* loaded from: classes2.dex */
class A implements InterfaceC2240y {
    @Override // com.nexstreaming.kinemaster.ui.share.InterfaceC2240y
    public void a(String str, String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArr) {
            sb.append(str2);
        }
        Log.i("ExportLogger", sb.toString());
    }

    @Override // com.nexstreaming.kinemaster.ui.share.InterfaceC2240y
    public boolean a() {
        return true;
    }
}
