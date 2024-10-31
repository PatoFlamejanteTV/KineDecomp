package okio;

import com.facebook.share.internal.ShareConstants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class ByteString implements Serializable {
    private static final long serialVersionUID = 1;
    private transient int b;
    private transient String c;
    final byte[] data;

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f4928a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final ByteString EMPTY = of(new byte[0]);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteString(byte[] bArr) {
        this.data = bArr;
    }

    public static ByteString of(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new ByteString((byte[]) bArr.clone());
    }

    public static ByteString of(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        n.a(bArr.length, i, i2);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new ByteString(bArr2);
    }

    public static ByteString encodeUtf8(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        ByteString byteString = new ByteString(str.getBytes(n.f4937a));
        byteString.c = str;
        return byteString;
    }

    public String utf8() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.data, n.f4937a);
        this.c = str2;
        return str2;
    }

    public String base64() {
        return a.a(this.data);
    }

    public static ByteString decodeBase64(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] a2 = a.a(str);
        if (a2 != null) {
            return new ByteString(a2);
        }
        return null;
    }

    public String hex() {
        char[] cArr = new char[this.data.length * 2];
        int i = 0;
        for (byte b : this.data) {
            int i2 = i + 1;
            cArr[i] = f4928a[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = f4928a[b & 15];
        }
        return new String(cArr);
    }

    public static ByteString decodeHex(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) ((a(str.charAt(i * 2)) << 4) + a(str.charAt((i * 2) + 1)));
        }
        return of(bArr);
    }

    private static int a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 'a') + 10;
        }
        if (c < 'A' || c > 'F') {
            throw new IllegalArgumentException("Unexpected hex digit: " + c);
        }
        return (c - 'A') + 10;
    }

    public static ByteString read(InputStream inputStream, int i) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + i);
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                throw new EOFException();
            }
            i2 += read;
        }
        return new ByteString(bArr);
    }

    public ByteString toAsciiLowercase() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.data.length) {
                byte b = this.data[i2];
                if (b < 65 || b > 90) {
                    i = i2 + 1;
                } else {
                    byte[] bArr = (byte[]) this.data.clone();
                    bArr[i2] = (byte) (b + 32);
                    for (int i3 = i2 + 1; i3 < bArr.length; i3++) {
                        byte b2 = bArr[i3];
                        if (b2 >= 65 && b2 <= 90) {
                            bArr[i3] = (byte) (b2 + 32);
                        }
                    }
                    return new ByteString(bArr);
                }
            } else {
                return this;
            }
        }
    }

    public ByteString toAsciiUppercase() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.data.length) {
                byte b = this.data[i2];
                if (b < 97 || b > 122) {
                    i = i2 + 1;
                } else {
                    byte[] bArr = (byte[]) this.data.clone();
                    bArr[i2] = (byte) (b - 32);
                    for (int i3 = i2 + 1; i3 < bArr.length; i3++) {
                        byte b2 = bArr[i3];
                        if (b2 >= 97 && b2 <= 122) {
                            bArr[i3] = (byte) (b2 - 32);
                        }
                    }
                    return new ByteString(bArr);
                }
            } else {
                return this;
            }
        }
    }

    public byte getByte(int i) {
        return this.data[i];
    }

    public int size() {
        return this.data.length;
    }

    public byte[] toByteArray() {
        return (byte[]) this.data.clone();
    }

    public void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        outputStream.write(this.data);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof ByteString) && Arrays.equals(((ByteString) obj).data, this.data));
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.data);
        this.b = hashCode;
        return hashCode;
    }

    public String toString() {
        if (this.data.length == 0) {
            return "ByteString[size=0]";
        }
        if (this.data.length <= 16) {
            return String.format("ByteString[size=%s data=%s]", Integer.valueOf(this.data.length), hex());
        }
        try {
            return String.format("ByteString[size=%s md5=%s]", Integer.valueOf(this.data.length), of(MessageDigest.getInstance("MD5").digest(this.data)).hex());
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString read = read(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = ByteString.class.getDeclaredField(ShareConstants.WEB_DIALOG_PARAM_DATA);
            declaredField.setAccessible(true);
            declaredField.set(this, read.data);
        } catch (IllegalAccessException e) {
            throw new AssertionError();
        } catch (NoSuchFieldException e2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }
}
