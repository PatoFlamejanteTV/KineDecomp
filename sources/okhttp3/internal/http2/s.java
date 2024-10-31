package okhttp3.internal.http2;

import android.support.v4.view.PointerIconCompat;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.umeng.commonsdk.proguard.ap;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import okio.ByteString;

/* compiled from: Huffman.java */
/* loaded from: classes3.dex */
class s {

    /* renamed from: a */
    private static final int[] f29148a = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 4090, 8185, 21, 248, 2042, PointerIconCompat.TYPE_ZOOM_IN, PointerIconCompat.TYPE_ZOOM_OUT, 249, 2043, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, PointerIconCompat.TYPE_GRAB, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    /* renamed from: b */
    private static final byte[] f29149b = {ap.k, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, ap.k, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, ap.m, 6, 12, 10, ap.k, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, ap.k, 19, ap.k, ap.l, 6, ap.m, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, ap.m, 11, ap.l, ap.k, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};

    /* renamed from: c */
    private static final s f29150c = new s();

    /* renamed from: d */
    private final a f29151d = new a();

    private s() {
        b();
    }

    public static s a() {
        return f29150c;
    }

    private void b() {
        int i = 0;
        while (true) {
            byte[] bArr = f29149b;
            if (i >= bArr.length) {
                return;
            }
            a(i, f29148a[i], bArr[i]);
            i++;
        }
    }

    public void a(ByteString byteString, okio.h hVar) throws IOException {
        long j = 0;
        int i = 0;
        for (int i2 = 0; i2 < byteString.size(); i2++) {
            int i3 = byteString.getByte(i2) & 255;
            int i4 = f29148a[i3];
            byte b2 = f29149b[i3];
            j = (j << b2) | i4;
            i += b2;
            while (i >= 8) {
                i -= 8;
                hVar.writeByte((int) (j >> i));
            }
        }
        if (i > 0) {
            hVar.writeByte((int) ((255 >>> i) | (j << (8 - i))));
        }
    }

    /* compiled from: Huffman.java */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a */
        final a[] f29152a;

        /* renamed from: b */
        final int f29153b;

        /* renamed from: c */
        final int f29154c;

        a() {
            this.f29152a = new a[256];
            this.f29153b = 0;
            this.f29154c = 0;
        }

        a(int i, int i2) {
            this.f29152a = null;
            this.f29153b = i;
            int i3 = i2 & 7;
            this.f29154c = i3 == 0 ? 8 : i3;
        }
    }

    public int a(ByteString byteString) {
        long j = 0;
        for (int i = 0; i < byteString.size(); i++) {
            j += f29149b[byteString.getByte(i) & 255];
        }
        return (int) ((j + 7) >> 3);
    }

    public byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a aVar = this.f29151d;
        int i = 0;
        int i2 = 0;
        for (byte b2 : bArr) {
            i = (i << 8) | (b2 & 255);
            i2 += 8;
            while (i2 >= 8) {
                aVar = aVar.f29152a[(i >>> (i2 - 8)) & 255];
                if (aVar.f29152a == null) {
                    byteArrayOutputStream.write(aVar.f29153b);
                    i2 -= aVar.f29154c;
                    aVar = this.f29151d;
                } else {
                    i2 -= 8;
                }
            }
        }
        while (i2 > 0) {
            a aVar2 = aVar.f29152a[(i << (8 - i2)) & 255];
            if (aVar2.f29152a != null || aVar2.f29154c > i2) {
                break;
            }
            byteArrayOutputStream.write(aVar2.f29153b);
            i2 -= aVar2.f29154c;
            aVar = this.f29151d;
        }
        return byteArrayOutputStream.toByteArray();
    }

    private void a(int i, int i2, byte b2) {
        a aVar = new a(i, b2);
        a aVar2 = this.f29151d;
        while (b2 > 8) {
            b2 = (byte) (b2 - 8);
            int i3 = (i2 >>> b2) & 255;
            a[] aVarArr = aVar2.f29152a;
            if (aVarArr != null) {
                if (aVarArr[i3] == null) {
                    aVarArr[i3] = new a();
                }
                aVar2 = aVar2.f29152a[i3];
            } else {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
        }
        int i4 = 8 - b2;
        int i5 = (i2 << i4) & 255;
        int i6 = 1 << i4;
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            aVar2.f29152a[i7] = aVar;
        }
    }
}
