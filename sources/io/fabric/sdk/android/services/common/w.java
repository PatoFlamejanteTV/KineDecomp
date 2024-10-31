package io.fabric.sdk.android.services.common;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: QueueFile.java */
/* loaded from: classes3.dex */
public class w implements Closeable {

    /* renamed from: a */
    private static final Logger f26912a = Logger.getLogger(w.class.getName());

    /* renamed from: b */
    private final RandomAccessFile f26913b;

    /* renamed from: c */
    int f26914c;

    /* renamed from: d */
    private int f26915d;

    /* renamed from: e */
    private a f26916e;

    /* renamed from: f */
    private a f26917f;

    /* renamed from: g */
    private final byte[] f26918g = new byte[16];

    /* compiled from: QueueFile.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a */
        static final a f26919a = new a(0, 0);

        /* renamed from: b */
        final int f26920b;

        /* renamed from: c */
        final int f26921c;

        a(int i, int i2) {
            this.f26920b = i;
            this.f26921c = i2;
        }

        public String toString() {
            return a.class.getSimpleName() + "[position = " + this.f26920b + ", length = " + this.f26921c + "]";
        }
    }

    /* compiled from: QueueFile.java */
    /* loaded from: classes3.dex */
    public final class b extends InputStream {

        /* renamed from: a */
        private int f26922a;

        /* renamed from: b */
        private int f26923b;

        /* synthetic */ b(w wVar, a aVar, v vVar) {
            this(aVar);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            w.a(bArr, "buffer");
            if ((i | i2) >= 0 && i2 <= bArr.length - i) {
                int i3 = this.f26923b;
                if (i3 <= 0) {
                    return -1;
                }
                if (i2 > i3) {
                    i2 = i3;
                }
                w.this.a(this.f26922a, bArr, i, i2);
                this.f26922a = w.this.d(this.f26922a + i2);
                this.f26923b -= i2;
                return i2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }

        private b(a aVar) {
            this.f26922a = w.this.d(aVar.f26920b + 4);
            this.f26923b = aVar.f26921c;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f26923b == 0) {
                return -1;
            }
            w.this.f26913b.seek(this.f26922a);
            int read = w.this.f26913b.read();
            this.f26922a = w.this.d(this.f26922a + 1);
            this.f26923b--;
            return read;
        }
    }

    /* compiled from: QueueFile.java */
    /* loaded from: classes3.dex */
    public interface c {
        void read(InputStream inputStream, int i) throws IOException;
    }

    public w(File file) throws IOException {
        if (!file.exists()) {
            a(file);
        }
        this.f26913b = b(file);
        s();
    }

    private a b(int i) throws IOException {
        if (i == 0) {
            return a.f26919a;
        }
        this.f26913b.seek(i);
        return new a(i, this.f26913b.readInt());
    }

    private static void c(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    public int d(int i) {
        int i2 = this.f26914c;
        return i < i2 ? i : (i + 16) - i2;
    }

    private void s() throws IOException {
        this.f26913b.seek(0L);
        this.f26913b.readFully(this.f26918g);
        this.f26914c = a(this.f26918g, 0);
        if (this.f26914c <= this.f26913b.length()) {
            this.f26915d = a(this.f26918g, 4);
            int a2 = a(this.f26918g, 8);
            int a3 = a(this.f26918g, 12);
            this.f26916e = b(a2);
            this.f26917f = b(a3);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f26914c + ", Actual length: " + this.f26913b.length());
    }

    private int u() {
        return this.f26914c - r();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f26913b.close();
    }

    public int r() {
        if (this.f26915d == 0) {
            return 16;
        }
        a aVar = this.f26917f;
        int i = aVar.f26920b;
        int i2 = this.f26916e.f26920b;
        if (i >= i2) {
            return (i - i2) + 4 + aVar.f26921c + 16;
        }
        return (((i + 4) + aVar.f26921c) + this.f26914c) - i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(w.class.getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.f26914c);
        sb.append(", size=");
        sb.append(this.f26915d);
        sb.append(", first=");
        sb.append(this.f26916e);
        sb.append(", last=");
        sb.append(this.f26917f);
        sb.append(", element lengths=[");
        try {
            a(new v(this, sb));
        } catch (IOException e2) {
            f26912a.log(Level.WARNING, "read error", (Throwable) e2);
        }
        sb.append("]]");
        return sb.toString();
    }

    static /* synthetic */ Object a(Object obj, String str) {
        b(obj, str);
        return obj;
    }

    private static RandomAccessFile b(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    private static void a(byte[] bArr, int... iArr) {
        int i = 0;
        for (int i2 : iArr) {
            c(bArr, i, i2);
            i += 4;
        }
    }

    private void b(int i, byte[] bArr, int i2, int i3) throws IOException {
        int d2 = d(i);
        int i4 = d2 + i3;
        int i5 = this.f26914c;
        if (i4 <= i5) {
            this.f26913b.seek(d2);
            this.f26913b.write(bArr, i2, i3);
            return;
        }
        int i6 = i5 - d2;
        this.f26913b.seek(d2);
        this.f26913b.write(bArr, i2, i6);
        this.f26913b.seek(16L);
        this.f26913b.write(bArr, i2 + i6, i3 - i6);
    }

    private void c(int i) throws IOException {
        this.f26913b.setLength(i);
        this.f26913b.getChannel().force(true);
    }

    private static int a(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    public synchronized void c() throws IOException {
        if (!b()) {
            if (this.f26915d == 1) {
                a();
            } else {
                int d2 = d(this.f26916e.f26920b + 4 + this.f26916e.f26921c);
                a(d2, this.f26918g, 0, 4);
                int a2 = a(this.f26918g, 0);
                a(this.f26914c, this.f26915d - 1, d2, this.f26917f.f26920b);
                this.f26915d--;
                this.f26916e = new a(d2, a2);
            }
        } else {
            throw new NoSuchElementException();
        }
    }

    private void a(int i, int i2, int i3, int i4) throws IOException {
        a(this.f26918g, i, i2, i3, i4);
        this.f26913b.seek(0L);
        this.f26913b.write(this.f26918g);
    }

    private static void a(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile b2 = b(file2);
        try {
            b2.setLength(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
            b2.seek(0L);
            byte[] bArr = new byte[16];
            a(bArr, 4096, 0, 0, 0);
            b2.write(bArr);
            b2.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }

    public synchronized void b(byte[] bArr, int i, int i2) throws IOException {
        b(bArr, "buffer");
        if ((i | i2) >= 0 && i2 <= bArr.length - i) {
            a(i2);
            boolean b2 = b();
            a aVar = new a(b2 ? 16 : d(this.f26917f.f26920b + 4 + this.f26917f.f26921c), i2);
            c(this.f26918g, 0, i2);
            b(aVar.f26920b, this.f26918g, 0, 4);
            b(aVar.f26920b + 4, bArr, i, i2);
            a(this.f26914c, this.f26915d + 1, b2 ? aVar.f26920b : this.f26916e.f26920b, aVar.f26920b);
            this.f26917f = aVar;
            this.f26915d++;
            if (b2) {
                this.f26916e = this.f26917f;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void a(int i, byte[] bArr, int i2, int i3) throws IOException {
        int d2 = d(i);
        int i4 = d2 + i3;
        int i5 = this.f26914c;
        if (i4 <= i5) {
            this.f26913b.seek(d2);
            this.f26913b.readFully(bArr, i2, i3);
            return;
        }
        int i6 = i5 - d2;
        this.f26913b.seek(d2);
        this.f26913b.readFully(bArr, i2, i6);
        this.f26913b.seek(16L);
        this.f26913b.readFully(bArr, i2 + i6, i3 - i6);
    }

    public synchronized boolean b() {
        return this.f26915d == 0;
    }

    private static <T> T b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public void a(byte[] bArr) throws IOException {
        b(bArr, 0, bArr.length);
    }

    private void a(int i) throws IOException {
        int i2 = i + 4;
        int u = u();
        if (u >= i2) {
            return;
        }
        int i3 = this.f26914c;
        do {
            u += i3;
            i3 <<= 1;
        } while (u < i2);
        c(i3);
        a aVar = this.f26917f;
        int d2 = d(aVar.f26920b + 4 + aVar.f26921c);
        if (d2 < this.f26916e.f26920b) {
            FileChannel channel = this.f26913b.getChannel();
            channel.position(this.f26914c);
            long j = d2 - 4;
            if (channel.transferTo(16L, j, channel) != j) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i4 = this.f26917f.f26920b;
        int i5 = this.f26916e.f26920b;
        if (i4 < i5) {
            int i6 = (this.f26914c + i4) - 16;
            a(i3, this.f26915d, i5, i6);
            this.f26917f = new a(i6, this.f26917f.f26921c);
        } else {
            a(i3, this.f26915d, i5, i4);
        }
        this.f26914c = i3;
    }

    public synchronized void a(c cVar) throws IOException {
        int i = this.f26916e.f26920b;
        for (int i2 = 0; i2 < this.f26915d; i2++) {
            a b2 = b(i);
            cVar.read(new b(this, b2, null), b2.f26921c);
            i = d(b2.f26920b + 4 + b2.f26921c);
        }
    }

    public synchronized void a() throws IOException {
        a(4096, 0, 0, 0);
        this.f26915d = 0;
        this.f26916e = a.f26919a;
        this.f26917f = a.f26919a;
        if (this.f26914c > 4096) {
            c(4096);
        }
        this.f26914c = 4096;
    }

    public boolean a(int i, int i2) {
        return (r() + 4) + i <= i2;
    }
}
