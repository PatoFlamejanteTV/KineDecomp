package okio;

import java.io.EOFException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: Buffer.java */
/* loaded from: classes.dex */
public final class b implements Cloneable, c, d {

    /* renamed from: a, reason: collision with root package name */
    h f4930a;
    long b;

    public long a() {
        return this.b;
    }

    @Override // okio.d
    public boolean b() {
        return this.b == 0;
    }

    @Override // okio.d
    public void a(long j) throws EOFException {
        if (this.b < j) {
            throw new EOFException();
        }
    }

    @Override // okio.d
    public byte c() {
        if (this.b == 0) {
            throw new IllegalStateException("size == 0");
        }
        h hVar = this.f4930a;
        int i = hVar.b;
        int i2 = hVar.c;
        int i3 = i + 1;
        byte b = hVar.f4934a[i];
        this.b--;
        if (i3 == i2) {
            this.f4930a = hVar.a();
            i.f4935a.a(hVar);
        } else {
            hVar.b = i3;
        }
        return b;
    }

    public int d() {
        if (this.b < 4) {
            throw new IllegalStateException("size < 4: " + this.b);
        }
        h hVar = this.f4930a;
        int i = hVar.b;
        int i2 = hVar.c;
        if (i2 - i < 4) {
            return ((c() & 255) << 24) | ((c() & 255) << 16) | ((c() & 255) << 8) | (c() & 255);
        }
        byte[] bArr = hVar.f4934a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.b -= 4;
        if (i8 == i2) {
            this.f4930a = hVar.a();
            i.f4935a.a(hVar);
            return i9;
        }
        hVar.b = i8;
        return i9;
    }

    public long e() {
        if (this.b < 8) {
            throw new IllegalStateException("size < 8: " + this.b);
        }
        h hVar = this.f4930a;
        int i = hVar.b;
        int i2 = hVar.c;
        if (i2 - i < 8) {
            return ((d() & 4294967295L) << 32) | (d() & 4294967295L);
        }
        byte[] bArr = hVar.f4934a;
        long j = (bArr[i] & 255) << 56;
        int i3 = i + 1 + 1;
        long j2 = ((bArr[r4] & 255) << 48) | j;
        long j3 = j2 | ((bArr[i3] & 255) << 40);
        long j4 = j3 | ((bArr[r6] & 255) << 32);
        long j5 = j4 | ((bArr[r0] & 255) << 24);
        long j6 = j5 | ((bArr[r6] & 255) << 16);
        int i4 = i3 + 1 + 1 + 1 + 1 + 1 + 1;
        long j7 = (bArr[r6] & 255) | j6 | ((bArr[r0] & 255) << 8);
        this.b -= 8;
        if (i4 == i2) {
            this.f4930a = hVar.a();
            i.f4935a.a(hVar);
            return j7;
        }
        hVar.b = i4;
        return j7;
    }

    @Override // okio.d
    public int f() {
        return n.a(d());
    }

    @Override // okio.d
    public long g() {
        return n.a(e());
    }

    public ByteString h() {
        return new ByteString(i());
    }

    @Override // okio.d
    public ByteString b(long j) throws EOFException {
        return new ByteString(c(j));
    }

    @Override // okio.d
    public String a(long j, Charset charset) throws EOFException {
        n.a(this.b, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        h hVar = this.f4930a;
        if (hVar.b + j > hVar.c) {
            return new String(c(j), charset);
        }
        String str = new String(hVar.f4934a, hVar.b, (int) j, charset);
        hVar.b = (int) (hVar.b + j);
        this.b -= j;
        if (hVar.b == hVar.c) {
            this.f4930a = hVar.a();
            i.f4935a.a(hVar);
            return str;
        }
        return str;
    }

    public byte[] i() {
        try {
            return c(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public byte[] c(long j) throws EOFException {
        n.a(this.b, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[(int) j];
        a(bArr);
        return bArr;
    }

    public void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a2 = a(bArr, i, bArr.length - i);
            if (a2 == -1) {
                throw new EOFException();
            }
            i += a2;
        }
    }

    public int a(byte[] bArr, int i, int i2) {
        n.a(bArr.length, i, i2);
        h hVar = this.f4930a;
        if (hVar == null) {
            return -1;
        }
        int min = Math.min(i2, hVar.c - hVar.b);
        System.arraycopy(hVar.f4934a, hVar.b, bArr, i, min);
        hVar.b += min;
        this.b -= min;
        if (hVar.b == hVar.c) {
            this.f4930a = hVar.a();
            i.f4935a.a(hVar);
            return min;
        }
        return min;
    }

    public void j() {
        try {
            d(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.d
    public void d(long j) throws EOFException {
        while (j > 0) {
            if (this.f4930a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, this.f4930a.c - this.f4930a.b);
            this.b -= min;
            j -= min;
            h hVar = this.f4930a;
            hVar.b = min + hVar.b;
            if (this.f4930a.b == this.f4930a.c) {
                h hVar2 = this.f4930a;
                this.f4930a = hVar2.a();
                i.f4935a.a(hVar2);
            }
        }
    }

    public b b(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return b(bArr, 0, bArr.length);
    }

    public b b(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        n.a(bArr.length, i, i2);
        int i3 = i + i2;
        while (i < i3) {
            h a2 = a(1);
            int min = Math.min(i3 - i, 2048 - a2.c);
            System.arraycopy(bArr, i, a2.f4934a, a2.c, min);
            i += min;
            a2.c = min + a2.c;
        }
        this.b += i2;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h a(int i) {
        if (i < 1 || i > 2048) {
            throw new IllegalArgumentException();
        }
        if (this.f4930a == null) {
            this.f4930a = i.f4935a.a();
            h hVar = this.f4930a;
            h hVar2 = this.f4930a;
            h hVar3 = this.f4930a;
            hVar2.e = hVar3;
            hVar.d = hVar3;
            return hVar3;
        }
        h hVar4 = this.f4930a.e;
        if (hVar4.c + i > 2048) {
            return hVar4.a(i.f4935a.a());
        }
        return hVar4;
    }

    public void a(b bVar, long j) {
        if (bVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (bVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        n.a(bVar.b, 0L, j);
        while (j > 0) {
            if (j < bVar.f4930a.c - bVar.f4930a.b) {
                h hVar = this.f4930a != null ? this.f4930a.e : null;
                if (hVar == null || (hVar.c - hVar.b) + j > 2048) {
                    bVar.f4930a = bVar.f4930a.a((int) j);
                } else {
                    bVar.f4930a.a(hVar, (int) j);
                    bVar.b -= j;
                    this.b += j;
                    return;
                }
            }
            h hVar2 = bVar.f4930a;
            long j2 = hVar2.c - hVar2.b;
            bVar.f4930a = hVar2.a();
            if (this.f4930a == null) {
                this.f4930a = hVar2;
                h hVar3 = this.f4930a;
                h hVar4 = this.f4930a;
                h hVar5 = this.f4930a;
                hVar4.e = hVar5;
                hVar3.d = hVar5;
            } else {
                this.f4930a.e.a(hVar2).b();
            }
            bVar.b -= j2;
            this.b += j2;
            j -= j2;
        }
    }

    @Override // okio.k
    public long b(b bVar, long j) {
        if (bVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.b == 0) {
            return -1L;
        }
        if (j > this.b) {
            j = this.b;
        }
        bVar.a(this, j);
        return j;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, okio.k
    public void close() {
    }

    public boolean equals(Object obj) {
        long j = 0;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.b != bVar.b) {
            return false;
        }
        if (this.b == 0) {
            return true;
        }
        h hVar = this.f4930a;
        h hVar2 = bVar.f4930a;
        int i = hVar.b;
        int i2 = hVar2.b;
        while (j < this.b) {
            long min = Math.min(hVar.c - i, hVar2.c - i2);
            int i3 = 0;
            while (i3 < min) {
                int i4 = i + 1;
                byte b = hVar.f4934a[i];
                int i5 = i2 + 1;
                if (b != hVar2.f4934a[i2]) {
                    return false;
                }
                i3++;
                i2 = i5;
                i = i4;
            }
            if (i == hVar.c) {
                hVar = hVar.d;
                i = hVar.b;
            }
            if (i2 == hVar2.c) {
                hVar2 = hVar2.d;
                i2 = hVar2.b;
            }
            j += min;
        }
        return true;
    }

    public int hashCode() {
        h hVar = this.f4930a;
        if (hVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = hVar.b;
            int i3 = hVar.c;
            while (i2 < i3) {
                int i4 = hVar.f4934a[i2] + (i * 31);
                i2++;
                i = i4;
            }
            hVar = hVar.d;
        } while (hVar != this.f4930a);
        return i;
    }

    public String toString() {
        if (this.b == 0) {
            return "Buffer[size=0]";
        }
        if (this.b <= 16) {
            return String.format("Buffer[size=%s data=%s]", Long.valueOf(this.b), clone().h().hex());
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(this.f4930a.f4934a, this.f4930a.b, this.f4930a.c - this.f4930a.b);
            for (h hVar = this.f4930a.d; hVar != this.f4930a; hVar = hVar.d) {
                messageDigest.update(hVar.f4934a, hVar.b, hVar.c - hVar.b);
            }
            return String.format("Buffer[size=%s md5=%s]", Long.valueOf(this.b), ByteString.of(messageDigest.digest()).hex());
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }

    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public b clone() {
        b bVar = new b();
        if (this.b == 0) {
            return bVar;
        }
        bVar.b(this.f4930a.f4934a, this.f4930a.b, this.f4930a.c - this.f4930a.b);
        for (h hVar = this.f4930a.d; hVar != this.f4930a; hVar = hVar.d) {
            bVar.b(hVar.f4934a, hVar.b, hVar.c - hVar.b);
        }
        return bVar;
    }
}
