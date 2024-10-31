package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class SerializedString implements com.fasterxml.jackson.core.e, Serializable {
    protected transient String _jdkSerializeValue;
    protected char[] _quotedChars;
    protected byte[] _quotedUTF8Ref;
    protected byte[] _unquotedUTF8Ref;
    protected final String _value;

    public SerializedString(String str) {
        if (str == null) {
            throw new IllegalStateException("Null String illegal for SerializedString");
        }
        this._value = str;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        this._jdkSerializeValue = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this._value);
    }

    protected Object readResolve() {
        return new SerializedString(this._jdkSerializeValue);
    }

    @Override // com.fasterxml.jackson.core.e
    public final String getValue() {
        return this._value;
    }

    public final int charLength() {
        return this._value.length();
    }

    public final char[] asQuotedChars() {
        char[] cArr = this._quotedChars;
        if (cArr == null) {
            char[] a2 = d.a().a(this._value);
            this._quotedChars = a2;
            return a2;
        }
        return cArr;
    }

    @Override // com.fasterxml.jackson.core.e
    public final byte[] asUnquotedUTF8() {
        byte[] bArr = this._unquotedUTF8Ref;
        if (bArr == null) {
            byte[] c = d.a().c(this._value);
            this._unquotedUTF8Ref = c;
            return c;
        }
        return bArr;
    }

    public final byte[] asQuotedUTF8() {
        byte[] bArr = this._quotedUTF8Ref;
        if (bArr == null) {
            byte[] b = d.a().b(this._value);
            this._quotedUTF8Ref = b;
            return b;
        }
        return bArr;
    }

    public int appendQuotedUTF8(byte[] bArr, int i) {
        byte[] bArr2 = this._quotedUTF8Ref;
        if (bArr2 == null) {
            bArr2 = d.a().b(this._value);
            this._quotedUTF8Ref = bArr2;
        }
        int length = bArr2.length;
        if (i + length > bArr.length) {
            return -1;
        }
        System.arraycopy(bArr2, 0, bArr, i, length);
        return length;
    }

    public int appendQuoted(char[] cArr, int i) {
        char[] cArr2 = this._quotedChars;
        if (cArr2 == null) {
            cArr2 = d.a().a(this._value);
            this._quotedChars = cArr2;
        }
        int length = cArr2.length;
        if (i + length > cArr.length) {
            return -1;
        }
        System.arraycopy(cArr2, 0, cArr, i, length);
        return length;
    }

    public int appendUnquotedUTF8(byte[] bArr, int i) {
        byte[] bArr2 = this._unquotedUTF8Ref;
        if (bArr2 == null) {
            bArr2 = d.a().c(this._value);
            this._unquotedUTF8Ref = bArr2;
        }
        int length = bArr2.length;
        if (i + length > bArr.length) {
            return -1;
        }
        System.arraycopy(bArr2, 0, bArr, i, length);
        return length;
    }

    public int appendUnquoted(char[] cArr, int i) {
        String str = this._value;
        int length = str.length();
        if (i + length > cArr.length) {
            return -1;
        }
        str.getChars(0, length, cArr, i);
        return length;
    }

    public int writeQuotedUTF8(OutputStream outputStream) throws IOException {
        byte[] bArr = this._quotedUTF8Ref;
        if (bArr == null) {
            bArr = d.a().b(this._value);
            this._quotedUTF8Ref = bArr;
        }
        int length = bArr.length;
        outputStream.write(bArr, 0, length);
        return length;
    }

    public int writeUnquotedUTF8(OutputStream outputStream) throws IOException {
        byte[] bArr = this._unquotedUTF8Ref;
        if (bArr == null) {
            bArr = d.a().c(this._value);
            this._unquotedUTF8Ref = bArr;
        }
        int length = bArr.length;
        outputStream.write(bArr, 0, length);
        return length;
    }

    public int putQuotedUTF8(ByteBuffer byteBuffer) {
        byte[] bArr = this._quotedUTF8Ref;
        if (bArr == null) {
            bArr = d.a().b(this._value);
            this._quotedUTF8Ref = bArr;
        }
        int length = bArr.length;
        if (length > byteBuffer.remaining()) {
            return -1;
        }
        byteBuffer.put(bArr, 0, length);
        return length;
    }

    public int putUnquotedUTF8(ByteBuffer byteBuffer) {
        byte[] bArr = this._unquotedUTF8Ref;
        if (bArr == null) {
            bArr = d.a().c(this._value);
            this._unquotedUTF8Ref = bArr;
        }
        int length = bArr.length;
        if (length > byteBuffer.remaining()) {
            return -1;
        }
        byteBuffer.put(bArr, 0, length);
        return length;
    }

    public final String toString() {
        return this._value;
    }

    public final int hashCode() {
        return this._value.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return this._value.equals(((SerializedString) obj)._value);
    }
}
