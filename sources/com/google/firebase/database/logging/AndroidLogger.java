package com.google.firebase.database.logging;

import android.util.Log;
import com.google.firebase.database.logging.Logger;
import java.util.List;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class AndroidLogger extends DefaultLogger {
    public AndroidLogger(Logger.Level level, List<String> list) {
        super(level, list);
    }

    @Override // com.google.firebase.database.logging.DefaultLogger
    protected void a(String str, String str2) {
        Log.d(str, str2);
    }

    @Override // com.google.firebase.database.logging.DefaultLogger
    protected String b(Logger.Level level, String str, String str2, long j) {
        return str2;
    }

    @Override // com.google.firebase.database.logging.DefaultLogger
    protected void b(String str, String str2) {
        Log.e(str, str2);
    }

    @Override // com.google.firebase.database.logging.DefaultLogger
    protected void c(String str, String str2) {
        Log.i(str, str2);
    }

    @Override // com.google.firebase.database.logging.DefaultLogger
    protected void d(String str, String str2) {
        Log.w(str, str2);
    }
}
