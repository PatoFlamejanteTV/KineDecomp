package android.support.v4.util;

import android.util.Log;
import java.io.Writer;

/* loaded from: classes.dex */
public class LogWriter extends Writer {

    /* renamed from: a */
    private final String f1719a;

    /* renamed from: b */
    private StringBuilder f1720b = new StringBuilder(128);

    public LogWriter(String str) {
        this.f1719a = str;
    }

    private void a() {
        if (this.f1720b.length() > 0) {
            Log.d(this.f1719a, this.f1720b.toString());
            StringBuilder sb = this.f1720b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c2 = cArr[i + i3];
            if (c2 == '\n') {
                a();
            } else {
                this.f1720b.append(c2);
            }
        }
    }
}
