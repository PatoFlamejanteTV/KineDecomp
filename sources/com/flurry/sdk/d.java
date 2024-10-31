package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private int f478a;
    private long b;
    private String c;
    private String d;
    private String e;
    private Throwable f;

    public d(int i, long j, String str, String str2, String str3, Throwable th) {
        this.f478a = i;
        this.b = j;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = th;
    }

    public int a() {
        return b().length;
    }

    public byte[] b() {
        Throwable th;
        DataOutputStream dataOutputStream;
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            } catch (IOException e) {
                dataOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                bb.a((Closeable) null);
                throw th;
            }
            try {
                dataOutputStream.writeShort(this.f478a);
                dataOutputStream.writeLong(this.b);
                dataOutputStream.writeUTF(this.c);
                dataOutputStream.writeUTF(this.d);
                dataOutputStream.writeUTF(this.e);
                if (this.f != null) {
                    if (this.c == "uncaught") {
                        dataOutputStream.writeByte(3);
                    } else {
                        dataOutputStream.writeByte(2);
                    }
                    dataOutputStream.writeByte(2);
                    StringBuilder sb = new StringBuilder("");
                    String property = System.getProperty("line.separator");
                    for (StackTraceElement stackTraceElement : this.f.getStackTrace()) {
                        sb.append(stackTraceElement);
                        sb.append(property);
                    }
                    if (this.f.getCause() != null) {
                        sb.append(property);
                        sb.append("Caused by: ");
                        for (StackTraceElement stackTraceElement2 : this.f.getCause().getStackTrace()) {
                            sb.append(stackTraceElement2);
                            sb.append(property);
                        }
                    }
                    byte[] bytes = sb.toString().getBytes();
                    dataOutputStream.writeInt(bytes.length);
                    dataOutputStream.write(bytes);
                } else {
                    dataOutputStream.writeByte(1);
                    dataOutputStream.writeByte(0);
                }
                dataOutputStream.flush();
                bArr = byteArrayOutputStream.toByteArray();
                bb.a(dataOutputStream);
            } catch (IOException e2) {
                bArr = new byte[0];
                bb.a(dataOutputStream);
                return bArr;
            }
            return bArr;
        } catch (Throwable th3) {
            th = th3;
            bb.a((Closeable) null);
            throw th;
        }
    }

    public String c() {
        return this.c;
    }
}
