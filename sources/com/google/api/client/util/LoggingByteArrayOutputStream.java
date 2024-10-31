package com.google.api.client.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.keyczar.Keyczar;

/* loaded from: classes.dex */
public class LoggingByteArrayOutputStream extends ByteArrayOutputStream {

    /* renamed from: a, reason: collision with root package name */
    private int f2540a;
    private final int b;
    private boolean c;
    private final Level d;
    private final Logger e;

    public LoggingByteArrayOutputStream(Logger logger, Level level, int i) {
        this.e = (Logger) Preconditions.a(logger);
        this.d = (Level) Preconditions.a(level);
        Preconditions.a(i >= 0);
        this.b = i;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i) {
        Preconditions.a(!this.c);
        this.f2540a++;
        if (this.count < this.b) {
            super.write(i);
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        Preconditions.a(!this.c);
        this.f2540a += i2;
        if (this.count < this.b) {
            int i3 = this.count + i2;
            if (i3 > this.b) {
                i2 += this.b - i3;
            }
            super.write(bArr, i, i2);
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (!this.c) {
            if (this.f2540a != 0) {
                StringBuilder append = new StringBuilder().append("Total: ");
                a(append, this.f2540a);
                if (this.count != 0 && this.count < this.f2540a) {
                    append.append(" (logging first ");
                    a(append, this.count);
                    append.append(")");
                }
                this.e.config(append.toString());
                if (this.count != 0) {
                    this.e.log(this.d, toString(Keyczar.DEFAULT_ENCODING).replaceAll("[\\x00-\\x09\\x0B\\x0C\\x0E-\\x1F\\x7F]", " "));
                }
            }
            this.c = true;
        }
    }

    private static void a(StringBuilder sb, int i) {
        if (i == 1) {
            sb.append("1 byte");
        } else {
            sb.append(NumberFormat.getInstance().format(i)).append(" bytes");
        }
    }
}
