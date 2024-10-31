package com.google.android.gms.wearable.internal;

import android.util.Log;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class zzq extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    private final OutputStream f2399a;
    private volatile u b;

    private IOException a(IOException iOException) {
        u uVar = this.b;
        if (uVar == null) {
            return iOException;
        }
        if (Log.isLoggable("ChannelOutputStream", 2)) {
            Log.v("ChannelOutputStream", "Caught IOException, but channel has been closed. Translating to ChannelIOException.", iOException);
        }
        return new ChannelIOException("Channel closed unexpectedly before stream was finished", uVar.f2380a, uVar.b);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.f2399a.close();
        } catch (IOException e) {
            throw a(e);
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        try {
            this.f2399a.flush();
        } catch (IOException e) {
            throw a(e);
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        try {
            this.f2399a.write(i);
        } catch (IOException e) {
            throw a(e);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        try {
            this.f2399a.write(bArr);
        } catch (IOException e) {
            throw a(e);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.f2399a.write(bArr, i, i2);
        } catch (IOException e) {
            throw a(e);
        }
    }
}
