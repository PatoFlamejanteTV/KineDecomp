package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;

@Beta
/* loaded from: classes2.dex */
public final class LittleEndianDataInputStream extends FilterInputStream implements DataInput {
    @Override // java.io.DataInput
    public String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        ByteStreams.a(this, bArr);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        ByteStreams.a(this, bArr, i, i2);
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) throws IOException {
        return (int) this.in.skip(i);
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        int read = this.in.read();
        if (read < 0) {
            throw new EOFException();
        }
        return read;
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        return Ints.a((byte) 0, (byte) 0, a(), a());
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        byte a2 = a();
        byte a3 = a();
        return Ints.a(a(), a(), a3, a2);
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        byte a2 = a();
        byte a3 = a();
        byte a4 = a();
        byte a5 = a();
        byte a6 = a();
        byte a7 = a();
        return Longs.a(a(), a(), a7, a6, a5, a4, a3, a2);
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        return new DataInputStream(this.in).readUTF();
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        return (short) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        return (char) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        return (byte) readUnsignedByte();
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        return readUnsignedByte() != 0;
    }

    private byte a() throws IOException, EOFException {
        int read = this.in.read();
        if (-1 == read) {
            throw new EOFException();
        }
        return (byte) read;
    }
}
