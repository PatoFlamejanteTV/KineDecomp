package com.google.api.client.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public class LoggingByteArrayOutputStream extends ByteArrayOutputStream {

    /* renamed from: a */
    private int f14959a;

    /* renamed from: b */
    private final int f14960b;

    /* renamed from: c */
    private boolean f14961c;

    /* renamed from: d */
    private final Level f14962d;

    /* renamed from: e */
    private final Logger f14963e;

    public LoggingByteArrayOutputStream(Logger logger, Level level, int i) {
        Preconditions.a(logger);
        this.f14963e = logger;
        Preconditions.a(level);
        this.f14962d = level;
        Preconditions.a(i >= 0);
        this.f14960b = i;
    }

    private static void a(StringBuilder sb, int i) {
        if (i == 1) {
            sb.append("1 byte");
        } else {
            sb.append(NumberFormat.getInstance().format(i));
            sb.append(" bytes");
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (!this.f14961c) {
            if (this.f14959a != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Total: ");
                a(sb, this.f14959a);
                if (((ByteArrayOutputStream) this).count != 0 && ((ByteArrayOutputStream) this).count < this.f14959a) {
                    sb.append(" (logging first ");
                    a(sb, ((ByteArrayOutputStream) this).count);
                    sb.append(")");
                }
                this.f14963e.config(sb.toString());
                if (((ByteArrayOutputStream) this).count != 0) {
                    this.f14963e.log(this.f14962d, toString("UTF-8").replaceAll("[\\x00-\\x09\\x0B\\x0C\\x0E-\\x1F\\x7F]", " "));
                }
            }
            this.f14961c = true;
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i) {
        Preconditions.a(!this.f14961c);
        this.f14959a++;
        if (((ByteArrayOutputStream) this).count < this.f14960b) {
            super.write(i);
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        Preconditions.a(!this.f14961c);
        this.f14959a += i2;
        if (((ByteArrayOutputStream) this).count < this.f14960b) {
            int i3 = ((ByteArrayOutputStream) this).count + i2;
            if (i3 > this.f14960b) {
                i2 += this.f14960b - i3;
            }
            super.write(bArr, i, i2);
        }
    }
}
