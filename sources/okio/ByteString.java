package okio;

import com.facebook.share.internal.ShareConstants;
import com.umeng.commonsdk.proguard.ap;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    private static final long serialVersionUID = 1;
    final byte[] data;
    transient int hashCode;
    transient String utf8;
    static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final ByteString EMPTY = of(new byte[0]);

    public ByteString(byte[] bArr) {
        this.data = bArr;
    }

    private ByteString a(String str) {
        try {
            return of(MessageDigest.getInstance(str).digest(this.data));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    static int codePointIndexToCharIndex(String str, int i) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    @Nullable
    public static ByteString decodeBase64(String str) {
        if (str != null) {
            byte[] a2 = d.a(str);
            if (a2 != null) {
                return new ByteString(a2);
            }
            return null;
        }
        throw new IllegalArgumentException("base64 == null");
    }

    public static ByteString decodeHex(String str) {
        if (str != null) {
            if (str.length() % 2 == 0) {
                byte[] bArr = new byte[str.length() / 2];
                for (int i = 0; i < bArr.length; i++) {
                    int i2 = i * 2;
                    bArr[i] = (byte) ((a(str.charAt(i2)) << 4) + a(str.charAt(i2 + 1)));
                }
                return of(bArr);
            }
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        throw new IllegalArgumentException("hex == null");
    }

    public static ByteString encodeString(String str, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        if (charset != null) {
            return new ByteString(str.getBytes(charset));
        }
        throw new IllegalArgumentException("charset == null");
    }

    public static ByteString encodeUtf8(String str) {
        if (str != null) {
            ByteString byteString = new ByteString(str.getBytes(C.f29229a));
            byteString.utf8 = str;
            return byteString;
        }
        throw new IllegalArgumentException("s == null");
    }

    public static ByteString of(byte... bArr) {
        if (bArr != null) {
            return new ByteString((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static ByteString read(InputStream inputStream, int i) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (i >= 0) {
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
        throw new IllegalArgumentException("byteCount < 0: " + i);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString read = read(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = ByteString.class.getDeclaredField(ShareConstants.WEB_DIALOG_PARAM_DATA);
            declaredField.setAccessible(true);
            declaredField.set(this, read.data);
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (NoSuchFieldException unused2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.data).asReadOnlyBuffer();
    }

    public String base64() {
        return d.a(this.data);
    }

    public String base64Url() {
        return d.b(this.data);
    }

    public final boolean endsWith(ByteString byteString) {
        return rangeEquals(size() - byteString.size(), byteString, 0, byteString.size());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int size = byteString.size();
            byte[] bArr = this.data;
            if (size == bArr.length && byteString.rangeEquals(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public byte getByte(int i) {
        return this.data[i];
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.data);
        this.hashCode = hashCode;
        return hashCode;
    }

    public String hex() {
        byte[] bArr = this.data;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i] = cArr2[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & ap.m];
        }
        return new String(cArr);
    }

    public ByteString hmacSha1(ByteString byteString) {
        return a("HmacSHA1", byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        return a("HmacSHA256", byteString);
    }

    public ByteString hmacSha512(ByteString byteString) {
        return a("HmacSHA512", byteString);
    }

    public final int indexOf(ByteString byteString) {
        return indexOf(byteString.internalArray(), 0);
    }

    byte[] internalArray() {
        return this.data;
    }

    public final int lastIndexOf(ByteString byteString) {
        return lastIndexOf(byteString.internalArray(), size());
    }

    public ByteString md5() {
        return a("MD5");
    }

    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        return byteString.rangeEquals(i2, this.data, i, i3);
    }

    public ByteString sha1() {
        return a("SHA-1");
    }

    public ByteString sha256() {
        return a("SHA-256");
    }

    public ByteString sha512() {
        return a("SHA-512");
    }

    public int size() {
        return this.data.length;
    }

    public final boolean startsWith(ByteString byteString) {
        return rangeEquals(0, byteString, 0, byteString.size());
    }

    public String string(Charset charset) {
        if (charset != null) {
            return new String(this.data, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public ByteString substring(int i) {
        return substring(i, this.data.length);
    }

    public ByteString toAsciiLowercase() {
        int i = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i];
            if (b2 >= 65 && b2 <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b3 = bArr2[i2];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr2[i2] = (byte) (b3 + 32);
                    }
                }
                return new ByteString(bArr2);
            }
            i++;
        }
    }

    public ByteString toAsciiUppercase() {
        int i = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i];
            if (b2 >= 97 && b2 <= 122) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b2 - 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b3 = bArr2[i2];
                    if (b3 >= 97 && b3 <= 122) {
                        bArr2[i2] = (byte) (b3 - 32);
                    }
                }
                return new ByteString(bArr2);
            }
            i++;
        }
    }

    public byte[] toByteArray() {
        return (byte[]) this.data.clone();
    }

    public String toString() {
        if (this.data.length == 0) {
            return "[size=0]";
        }
        String utf8 = utf8();
        int codePointIndexToCharIndex = codePointIndexToCharIndex(utf8, 64);
        if (codePointIndexToCharIndex == -1) {
            if (this.data.length <= 64) {
                return "[hex=" + hex() + "]";
            }
            return "[size=" + this.data.length + " hex=" + substring(0, 64).hex() + "…]";
        }
        String replace = utf8.substring(0, codePointIndexToCharIndex).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (codePointIndexToCharIndex < utf8.length()) {
            return "[size=" + this.data.length + " text=" + replace + "…]";
        }
        return "[text=" + replace + "]";
    }

    public String utf8() {
        String str = this.utf8;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.data, C.f29229a);
        this.utf8 = str2;
        return str2;
    }

    public void write(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            outputStream.write(this.data);
            return;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // java.lang.Comparable
    public int compareTo(ByteString byteString) {
        int size = size();
        int size2 = byteString.size();
        int min = Math.min(size, size2);
        for (int i = 0; i < min; i++) {
            int i2 = getByte(i) & 255;
            int i3 = byteString.getByte(i) & 255;
            if (i2 != i3) {
                return i2 < i3 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public final boolean endsWith(byte[] bArr) {
        return rangeEquals(size() - bArr.length, bArr, 0, bArr.length);
    }

    public final int indexOf(ByteString byteString, int i) {
        return indexOf(byteString.internalArray(), i);
    }

    public final int lastIndexOf(ByteString byteString, int i) {
        return lastIndexOf(byteString.internalArray(), i);
    }

    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.data;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && C.a(bArr2, i, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public final boolean startsWith(byte[] bArr) {
        return rangeEquals(0, bArr, 0, bArr.length);
    }

    public ByteString substring(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.data;
            if (i2 > bArr.length) {
                throw new IllegalArgumentException("endIndex > length(" + this.data.length + ")");
            }
            int i3 = i2 - i;
            if (i3 >= 0) {
                if (i == 0 && i2 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i3];
                System.arraycopy(this.data, i, bArr2, 0, i3);
                return new ByteString(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    private ByteString a(String str, ByteString byteString) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            return of(mac.doFinal(this.data));
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new AssertionError(e3);
        }
    }

    public static ByteString of(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            C.a(bArr.length, i, i2);
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return new ByteString(bArr2);
        }
        throw new IllegalArgumentException("data == null");
    }

    public final int indexOf(byte[] bArr) {
        return indexOf(bArr, 0);
    }

    public final int lastIndexOf(byte[] bArr) {
        return lastIndexOf(bArr, size());
    }

    public void write(g gVar) {
        byte[] bArr = this.data;
        gVar.write(bArr, 0, bArr.length);
    }

    public int indexOf(byte[] bArr, int i) {
        int length = this.data.length - bArr.length;
        for (int max = Math.max(i, 0); max <= length; max++) {
            if (C.a(this.data, max, bArr, 0, bArr.length)) {
                return max;
            }
        }
        return -1;
    }

    public int lastIndexOf(byte[] bArr, int i) {
        for (int min = Math.min(i, this.data.length - bArr.length); min >= 0; min--) {
            if (C.a(this.data, min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    private static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: " + c2);
            }
        }
        return (c2 - c3) + 10;
    }

    public static ByteString of(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }
        throw new IllegalArgumentException("data == null");
    }
}
