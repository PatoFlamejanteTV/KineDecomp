package android.support.v4.graphics;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;

/* loaded from: classes.dex */
class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {
    private File a(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0054 A[Catch: all -> 0x0058, Throwable -> 0x005b, TRY_ENTER, TryCatch #0 {Throwable -> 0x005b, blocks: (B:9:0x0018, B:11:0x001e, B:14:0x0025, B:18:0x002f, B:21:0x003c, B:33:0x0054, B:34:0x0057), top: B:8:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[Catch: IOException -> 0x006d, SYNTHETIC, TRY_LEAVE, TryCatch #6 {IOException -> 0x006d, blocks: (B:7:0x000e, B:16:0x002b, B:23:0x0041, B:51:0x0069, B:52:0x006c), top: B:6:0x000e }] */
    @Override // android.support.v4.graphics.TypefaceCompatBaseImpl, android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Typeface createFromFontInfo(android.content.Context r5, android.os.CancellationSignal r6, android.support.v4.provider.FontsContractCompat.FontInfo[] r7, int r8) {
        /*
            r4 = this;
            int r0 = r7.length
            r1 = 0
            r2 = 1
            if (r0 >= r2) goto L6
            return r1
        L6:
            android.support.v4.provider.FontsContractCompat$FontInfo r7 = r4.a(r7, r8)
            android.content.ContentResolver r8 = r5.getContentResolver()
            android.net.Uri r7 = r7.getUri()     // Catch: java.io.IOException -> L6d
            java.lang.String r0 = "r"
            android.os.ParcelFileDescriptor r6 = r8.openFileDescriptor(r7, r0, r6)     // Catch: java.io.IOException -> L6d
            java.io.File r7 = r4.a(r6)     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5b
            if (r7 == 0) goto L2f
            boolean r8 = r7.canRead()     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5b
            if (r8 != 0) goto L25
            goto L2f
        L25:
            android.graphics.Typeface r5 = android.graphics.Typeface.createFromFile(r7)     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5b
            if (r6 == 0) goto L2e
            r6.close()     // Catch: java.io.IOException -> L6d
        L2e:
            return r5
        L2f:
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5b
            java.io.FileDescriptor r8 = r6.getFileDescriptor()     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5b
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5b
            android.graphics.Typeface r5 = super.a(r5, r7)     // Catch: java.lang.Throwable -> L45 java.lang.Throwable -> L48
            r7.close()     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5b
            if (r6 == 0) goto L44
            r6.close()     // Catch: java.io.IOException -> L6d
        L44:
            return r5
        L45:
            r5 = move-exception
            r8 = r1
            goto L4e
        L48:
            r5 = move-exception
            throw r5     // Catch: java.lang.Throwable -> L4a
        L4a:
            r8 = move-exception
            r3 = r8
            r8 = r5
            r5 = r3
        L4e:
            if (r8 == 0) goto L54
            r7.close()     // Catch: java.lang.Throwable -> L57 java.lang.Throwable -> L58
            goto L57
        L54:
            r7.close()     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5b
        L57:
            throw r5     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5b
        L58:
            r5 = move-exception
            r7 = r1
            goto L61
        L5b:
            r5 = move-exception
            throw r5     // Catch: java.lang.Throwable -> L5d
        L5d:
            r7 = move-exception
            r3 = r7
            r7 = r5
            r5 = r3
        L61:
            if (r6 == 0) goto L6c
            if (r7 == 0) goto L69
            r6.close()     // Catch: java.lang.Throwable -> L6c
            goto L6c
        L69:
            r6.close()     // Catch: java.io.IOException -> L6d
        L6c:
            throw r5     // Catch: java.io.IOException -> L6d
        L6d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi21Impl.createFromFontInfo(android.content.Context, android.os.CancellationSignal, android.support.v4.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }
}
