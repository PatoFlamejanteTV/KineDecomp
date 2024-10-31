package com.flurry.sdk;

import android.os.Looper;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

/* loaded from: classes.dex */
public class r {
    private static final String d = r.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    String f492a;
    long b = -1;
    int c = -1;
    private File e;

    public r() {
        this.f492a = null;
        this.e = null;
        this.f492a = UUID.randomUUID().toString();
        this.e = ad.a().b().getFileStreamPath(".flurrydatasenderblock." + this.f492a);
    }

    public r(String str) {
        this.f492a = null;
        this.e = null;
        this.f492a = str;
        this.e = ad.a().b().getFileStreamPath(".flurrydatasenderblock." + this.f492a);
    }

    public String a() {
        return this.f492a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7 */
    public boolean a(byte[] bArr) {
        DataOutputStream dataOutputStream;
        boolean z = false;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            as.a(6, d, "setData(byte[]) running on the MAIN thread!");
        }
        ?? r2 = d;
        as.a(4, (String) r2, "Writing FlurryDataSenderBlockInfo: " + this.e.getAbsolutePath());
        try {
            try {
            } catch (Throwable th) {
                th = th;
                r2 = 0;
                bb.a((Closeable) r2);
                throw th;
            }
            if (ao.a(this.e)) {
                dataOutputStream = new DataOutputStream(new FileOutputStream(this.e));
                try {
                    int length = bArr.length;
                    dataOutputStream.writeShort(length);
                    dataOutputStream.write(bArr);
                    dataOutputStream.writeShort(0);
                    z = true;
                    this.c = length;
                    this.b = System.currentTimeMillis();
                    bb.a(dataOutputStream);
                    r2 = dataOutputStream;
                } catch (Throwable th2) {
                    th = th2;
                    as.a(6, d, "", th);
                    bb.a(dataOutputStream);
                    r2 = dataOutputStream;
                    return z;
                }
                return z;
            }
            bb.a((Closeable) null);
            return z;
        } catch (Throwable th3) {
            th = th3;
            bb.a((Closeable) r2);
            throw th;
        }
    }

    public byte[] b() {
        DataInputStream dataInputStream;
        Throwable th;
        byte[] bArr = null;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            as.a(6, d, "getData() running on the MAIN thread!");
        }
        if (this.e.exists()) {
            as.a(4, d, "Reading FlurryDataSenderBlockInfo: " + this.e.getAbsolutePath());
            try {
                dataInputStream = new DataInputStream(new FileInputStream(this.e));
            } catch (Throwable th2) {
                th = th2;
                dataInputStream = null;
            }
            try {
                try {
                    int readUnsignedShort = dataInputStream.readUnsignedShort();
                    if (readUnsignedShort == 0) {
                        bb.a(dataInputStream);
                    } else {
                        bArr = new byte[readUnsignedShort];
                        dataInputStream.readFully(bArr);
                        if (dataInputStream.readUnsignedShort() == 0) {
                        }
                        bb.a(dataInputStream);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bb.a(dataInputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                as.a(6, d, "Error when loading persistent file", th);
                bb.a(dataInputStream);
                return bArr;
            }
        } else {
            as.a(4, d, "Agent cache file doesn't exist.");
        }
        return bArr;
    }

    public boolean c() {
        if (this.e.exists()) {
            if (this.e.delete()) {
                as.a(4, d, "Deleted persistence file");
                this.b = -1L;
                this.c = -1;
                return true;
            }
            as.a(6, d, "Cannot delete persistence file");
        }
        return false;
    }
}
