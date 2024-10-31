package com.umeng.commonsdk.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: TIOStreamTransport.java */
/* loaded from: classes3.dex */
public class au extends aw {

    /* renamed from: a */
    protected InputStream f26207a;

    /* renamed from: b */
    protected OutputStream f26208b;

    protected au() {
        this.f26207a = null;
        this.f26208b = null;
    }

    @Override // com.umeng.commonsdk.proguard.aw
    public int a(byte[] bArr, int i, int i2) throws ax {
        InputStream inputStream = this.f26207a;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i, i2);
                if (read >= 0) {
                    return read;
                }
                throw new ax(4);
            } catch (IOException e2) {
                throw new ax(0, e2);
            }
        }
        throw new ax(1, "Cannot read from null inputStream");
    }

    @Override // com.umeng.commonsdk.proguard.aw
    public boolean a() {
        return true;
    }

    @Override // com.umeng.commonsdk.proguard.aw
    public void b() throws ax {
    }

    @Override // com.umeng.commonsdk.proguard.aw
    public void b(byte[] bArr, int i, int i2) throws ax {
        OutputStream outputStream = this.f26208b;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i, i2);
                return;
            } catch (IOException e2) {
                throw new ax(0, e2);
            }
        }
        throw new ax(1, "Cannot write to null outputStream");
    }

    @Override // com.umeng.commonsdk.proguard.aw
    public void c() {
        InputStream inputStream = this.f26207a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f26207a = null;
        }
        OutputStream outputStream = this.f26208b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            this.f26208b = null;
        }
    }

    @Override // com.umeng.commonsdk.proguard.aw
    public void d() throws ax {
        OutputStream outputStream = this.f26208b;
        if (outputStream != null) {
            try {
                outputStream.flush();
                return;
            } catch (IOException e2) {
                throw new ax(0, e2);
            }
        }
        throw new ax(1, "Cannot flush null outputStream");
    }

    public au(InputStream inputStream) {
        this.f26207a = null;
        this.f26208b = null;
        this.f26207a = inputStream;
    }

    public au(OutputStream outputStream) {
        this.f26207a = null;
        this.f26208b = null;
        this.f26208b = outputStream;
    }

    public au(InputStream inputStream, OutputStream outputStream) {
        this.f26207a = null;
        this.f26208b = null;
        this.f26207a = inputStream;
        this.f26208b = outputStream;
    }
}
