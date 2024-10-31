package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class SegmentedByteString extends ByteString {
    final transient int[] directory;
    final transient byte[][] segments;

    public SegmentedByteString(g gVar, int i) {
        super(null);
        C.a(gVar.f29244c, 0L, i);
        int i2 = 0;
        w wVar = gVar.f29243b;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = wVar.f29274c;
            int i6 = wVar.f29273b;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                wVar = wVar.f29277f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.segments = new byte[i4];
        this.directory = new int[i4 * 2];
        w wVar2 = gVar.f29243b;
        int i7 = 0;
        while (i2 < i) {
            this.segments[i7] = wVar2.f29272a;
            i2 += wVar2.f29274c - wVar2.f29273b;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.directory;
            iArr[i7] = i2;
            iArr[this.segments.length + i7] = wVar2.f29273b;
            wVar2.f29275d = true;
            i7++;
            wVar2 = wVar2.f29277f;
        }
    }

    private ByteString a() {
        return new ByteString(toByteArray());
    }

    private int f(int i) {
        int binarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ (-1);
    }

    private Object writeReplace() {
        return a();
    }

    @Override // okio.ByteString
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // okio.ByteString
    public String base64() {
        return a().base64();
    }

    @Override // okio.ByteString
    public String base64Url() {
        return a().base64Url();
    }

    @Override // okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    public byte getByte(int i) {
        C.a(this.directory[this.segments.length - 1], i, 1L);
        int f2 = f(i);
        int i2 = f2 == 0 ? 0 : this.directory[f2 - 1];
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        return bArr[f2][(i - i2) + iArr[bArr.length + f2]];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int length = this.segments.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.segments[i2];
            int[] iArr = this.directory;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.hashCode = i3;
        return i3;
    }

    @Override // okio.ByteString
    public String hex() {
        return a().hex();
    }

    @Override // okio.ByteString
    public ByteString hmacSha1(ByteString byteString) {
        return a().hmacSha1(byteString);
    }

    @Override // okio.ByteString
    public ByteString hmacSha256(ByteString byteString) {
        return a().hmacSha256(byteString);
    }

    @Override // okio.ByteString
    public int indexOf(byte[] bArr, int i) {
        return a().indexOf(bArr, i);
    }

    @Override // okio.ByteString
    byte[] internalArray() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public int lastIndexOf(byte[] bArr, int i) {
        return a().lastIndexOf(bArr, i);
    }

    @Override // okio.ByteString
    public ByteString md5() {
        return a().md5();
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        if (i < 0 || i > size() - i3) {
            return false;
        }
        int f2 = f(i);
        while (i3 > 0) {
            int i4 = f2 == 0 ? 0 : this.directory[f2 - 1];
            int min = Math.min(i3, ((this.directory[f2] - i4) + i4) - i);
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            if (!byteString.rangeEquals(i2, bArr[f2], (i - i4) + iArr[bArr.length + f2], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            f2++;
        }
        return true;
    }

    @Override // okio.ByteString
    public ByteString sha1() {
        return a().sha1();
    }

    @Override // okio.ByteString
    public ByteString sha256() {
        return a().sha256();
    }

    @Override // okio.ByteString
    public int size() {
        return this.directory[this.segments.length - 1];
    }

    @Override // okio.ByteString
    public String string(Charset charset) {
        return a().string(charset);
    }

    @Override // okio.ByteString
    public ByteString substring(int i) {
        return a().substring(i);
    }

    @Override // okio.ByteString
    public ByteString toAsciiLowercase() {
        return a().toAsciiLowercase();
    }

    @Override // okio.ByteString
    public ByteString toAsciiUppercase() {
        return a().toAsciiUppercase();
    }

    @Override // okio.ByteString
    public byte[] toByteArray() {
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.directory;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.segments[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // okio.ByteString
    public String toString() {
        return a().toString();
    }

    @Override // okio.ByteString
    public String utf8() {
        return a().utf8();
    }

    @Override // okio.ByteString
    public void write(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            int length = this.segments.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int[] iArr = this.directory;
                int i3 = iArr[length + i];
                int i4 = iArr[i];
                outputStream.write(this.segments[i], i3, i4 - i2);
                i++;
                i2 = i4;
            }
            return;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // okio.ByteString
    public ByteString substring(int i, int i2) {
        return a().substring(i, i2);
    }

    @Override // okio.ByteString
    public void write(g gVar) {
        int length = this.segments.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.directory;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            w wVar = new w(this.segments[i], i3, (i3 + i4) - i2, true, false);
            w wVar2 = gVar.f29243b;
            if (wVar2 == null) {
                wVar.f29278g = wVar;
                wVar.f29277f = wVar;
                gVar.f29243b = wVar;
            } else {
                wVar2.f29278g.a(wVar);
            }
            i++;
            i2 = i4;
        }
        gVar.f29244c += i2;
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int f2 = f(i);
        while (i3 > 0) {
            int i4 = f2 == 0 ? 0 : this.directory[f2 - 1];
            int min = Math.min(i3, ((this.directory[f2] - i4) + i4) - i);
            int[] iArr = this.directory;
            byte[][] bArr2 = this.segments;
            if (!C.a(bArr2[f2], (i - i4) + iArr[bArr2.length + f2], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            f2++;
        }
        return true;
    }
}
