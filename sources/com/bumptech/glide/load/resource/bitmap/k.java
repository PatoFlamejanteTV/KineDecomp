package com.bumptech.glide.load.resource.bitmap;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* compiled from: DefaultImageHeaderParser.java */
/* loaded from: classes.dex */
public final class k implements ImageHeaderParser {

    /* renamed from: a */
    static final byte[] f9023a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b */
    private static final int[] f9024b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* compiled from: DefaultImageHeaderParser.java */
    /* loaded from: classes.dex */
    private static final class a implements c {

        /* renamed from: a */
        private final ByteBuffer f9025a;

        a(ByteBuffer byteBuffer) {
            this.f9025a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k.c
        public int a() {
            return ((b() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (b() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k.c
        public int b() {
            if (this.f9025a.remaining() < 1) {
                return -1;
            }
            return this.f9025a.get();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k.c
        public short c() {
            return (short) (b() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k.c
        public long skip(long j) {
            int min = (int) Math.min(this.f9025a.remaining(), j);
            ByteBuffer byteBuffer = this.f9025a;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k.c
        public int a(byte[] bArr, int i) {
            int min = Math.min(i, this.f9025a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f9025a.get(bArr, 0, min);
            return min;
        }
    }

    /* compiled from: DefaultImageHeaderParser.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a */
        private final ByteBuffer f9026a;

        b(byte[] bArr, int i) {
            this.f9026a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        void a(ByteOrder byteOrder) {
            this.f9026a.order(byteOrder);
        }

        int b(int i) {
            if (a(i, 4)) {
                return this.f9026a.getInt(i);
            }
            return -1;
        }

        int a() {
            return this.f9026a.remaining();
        }

        short a(int i) {
            if (a(i, 2)) {
                return this.f9026a.getShort(i);
            }
            return (short) -1;
        }

        private boolean a(int i, int i2) {
            return this.f9026a.remaining() - i >= i2;
        }
    }

    /* compiled from: DefaultImageHeaderParser.java */
    /* loaded from: classes.dex */
    public interface c {
        int a() throws IOException;

        int a(byte[] bArr, int i) throws IOException;

        int b() throws IOException;

        short c() throws IOException;

        long skip(long j) throws IOException;
    }

    /* compiled from: DefaultImageHeaderParser.java */
    /* loaded from: classes.dex */
    private static final class d implements c {

        /* renamed from: a */
        private final InputStream f9027a;

        d(InputStream inputStream) {
            this.f9027a = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k.c
        public int a() throws IOException {
            return ((this.f9027a.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (this.f9027a.read() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k.c
        public int b() throws IOException {
            return this.f9027a.read();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k.c
        public short c() throws IOException {
            return (short) (this.f9027a.read() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k.c
        public long skip(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f9027a.skip(j2);
                if (skip <= 0) {
                    if (this.f9027a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k.c
        public int a(byte[] bArr, int i) throws IOException {
            int i2 = i;
            while (i2 > 0) {
                int read = this.f9027a.read(bArr, i - i2, i2);
                if (read == -1) {
                    break;
                }
                i2 -= read;
            }
            return i - i2;
        }
    }

    private static int a(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    private static boolean a(int i) {
        return (i & 65496) == 65496 || i == 19789 || i == 18761;
    }

    private int b(c cVar) throws IOException {
        short c2;
        int a2;
        long j;
        long skip;
        do {
            short c3 = cVar.c();
            if (c3 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) c3));
                }
                return -1;
            }
            c2 = cVar.c();
            if (c2 == 218) {
                return -1;
            }
            if (c2 == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            a2 = cVar.a() - 2;
            if (c2 == 225) {
                return a2;
            }
            j = a2;
            skip = cVar.skip(j);
        } while (skip == j);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) c2) + ", wanted to skip: " + a2 + ", but actually skipped: " + skip);
        }
        return -1;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType a(InputStream inputStream) throws IOException {
        com.bumptech.glide.g.l.a(inputStream);
        return a(new d(inputStream));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) throws IOException {
        com.bumptech.glide.g.l.a(byteBuffer);
        return a(new a(byteBuffer));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(InputStream inputStream, com.bumptech.glide.load.engine.a.b bVar) throws IOException {
        com.bumptech.glide.g.l.a(inputStream);
        d dVar = new d(inputStream);
        com.bumptech.glide.g.l.a(bVar);
        return a(dVar, bVar);
    }

    private ImageHeaderParser.ImageType a(c cVar) throws IOException {
        int a2 = cVar.a();
        if (a2 == 65496) {
            return ImageHeaderParser.ImageType.JPEG;
        }
        int a3 = ((a2 << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & SupportMenu.USER_MASK);
        if (a3 == -1991225785) {
            cVar.skip(21L);
            return cVar.b() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
        }
        if ((a3 >> 8) == 4671814) {
            return ImageHeaderParser.ImageType.GIF;
        }
        if (a3 != 1380533830) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        cVar.skip(4L);
        if ((((cVar.a() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & SupportMenu.USER_MASK)) != 1464156752) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int a4 = ((cVar.a() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & SupportMenu.USER_MASK);
        if ((a4 & InputDeviceCompat.SOURCE_ANY) != 1448097792) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int i = a4 & 255;
        if (i == 88) {
            cVar.skip(4L);
            return (cVar.b() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
        }
        if (i == 76) {
            cVar.skip(4L);
            return (cVar.b() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
        }
        return ImageHeaderParser.ImageType.WEBP;
    }

    private int a(c cVar, com.bumptech.glide.load.engine.a.b bVar) throws IOException {
        int a2 = cVar.a();
        if (!a(a2)) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + a2);
            }
            return -1;
        }
        int b2 = b(cVar);
        if (b2 == -1) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        byte[] bArr = (byte[]) bVar.a(b2, byte[].class);
        try {
            return a(cVar, bArr, b2);
        } finally {
            bVar.put(bArr);
        }
    }

    private int a(c cVar, byte[] bArr, int i) throws IOException {
        int a2 = cVar.a(bArr, i);
        if (a2 != i) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i + ", actually read: " + a2);
            }
            return -1;
        }
        if (a(bArr, i)) {
            return a(new b(bArr, i));
        }
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
        }
        return -1;
    }

    private boolean a(byte[] bArr, int i) {
        boolean z = bArr != null && i > f9023a.length;
        if (!z) {
            return z;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = f9023a;
            if (i2 >= bArr2.length) {
                return z;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    private static int a(b bVar) {
        ByteOrder byteOrder;
        short a2 = bVar.a(6);
        if (a2 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (a2 != 19789) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) a2));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        bVar.a(byteOrder);
        int b2 = bVar.b(10) + 6;
        short a3 = bVar.a(b2);
        for (int i = 0; i < a3; i++) {
            int a4 = a(b2, i);
            short a5 = bVar.a(a4);
            if (a5 == 274) {
                short a6 = bVar.a(a4 + 2);
                if (a6 >= 1 && a6 <= 12) {
                    int b3 = bVar.b(a4 + 4);
                    if (b3 < 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Negative tiff component count");
                        }
                    } else {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i + " tagType=" + ((int) a5) + " formatCode=" + ((int) a6) + " componentCount=" + b3);
                        }
                        int i2 = b3 + f9024b[a6];
                        if (i2 > 4) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) a6));
                            }
                        } else {
                            int i3 = a4 + 8;
                            if (i3 >= 0 && i3 <= bVar.a()) {
                                if (i2 >= 0 && i2 + i3 <= bVar.a()) {
                                    return bVar.a(i3);
                                }
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) a5));
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i3 + " tagType=" + ((int) a5));
                            }
                        }
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) a6));
                }
            }
        }
        return -1;
    }
}
