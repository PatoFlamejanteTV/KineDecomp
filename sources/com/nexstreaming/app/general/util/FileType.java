package com.nexstreaming.app.general.util;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public enum FileType {
    JPEG(FileCategory.Image, new String[]{"jpeg", "jpg"}, new int[]{255, 216, 255}),
    PNG(FileCategory.Image, new String[]{"png"}, new int[]{137, 80, 78, 71, 13, 10, 26, 10}),
    SVG(FileCategory.Image, new String[]{"svg"}, new int[]{60, 115, 118, 103}, new int[]{60, 83, 86, 71}),
    WEBP(FileCategory.Image, new String[]{"webp"}, new int[]{82, 73, 70, 70, -1, -1, -1, -1, 87, 69, 66, 80}),
    GIF(FileCategory.Image, new String[]{"gif"}, new int[]{71, 73, 70, 56, 55, 97}, new int[]{71, 73, 70, 56, 57, 97}),
    M4A(FileCategory.Audio, new String[]{"m4a"}, new int[]{0, 0, 0, 32, 102, 116, 121, 112, 77, 52, 65, 32}, new int[]{-1, -1, -1, -1, 102, 116, 121, 112, 77, 52, 65, 32}),
    M4V(FileCategory.Video, new String[]{"m4v"}, new int[]{0, 0, 0, 24, 102, 116, 121, 112, 109, 112, 52, 50}, new int[]{-1, -1, -1, -1, 102, 116, 121, 112, 109, 112, 52, 50}),
    MP4(FileCategory.Video, new String[]{"mp4"}, new int[]{0, 0, 0, 20, 102, 116, 121, 112, 105, 115, 111, 109}, new int[]{0, 0, 0, 24, 102, 116, 121, 112, 105, 115, 111, 109}, new int[]{0, 0, 0, 24, 102, 116, 121, 112, 51, 103, 112, 53}, new int[]{0, 0, 0, 28, 102, 116, 121, 112, 77, 83, 78, 86, 1, 41, 0, 70, 77, 83, 78, 86, 109, 112, 52, 50}, new int[]{-1, -1, -1, -1, 102, 116, 121, 112, 51, 103, 112, 53}, new int[]{-1, -1, -1, -1, 102, 116, 121, 112, 77, 83, 78, 86}, new int[]{-1, -1, -1, -1, 102, 116, 121, 112, 105, 115, 111, 109}, new int[]{0, 0, 0, 24, 102, 116, 121, 112, 109, 112, 52, 49}),
    F_3GP(FileCategory.VideoOrAudio, new String[]{"3gp", "3gpp", "3g2"}, new int[]{0, 0, 0, -1, 102, 116, 121, 112, 51, 103, 112}, new int[]{0, 0, 0, -1, 102, 116, 121, 112, 51, 103, 50}),
    K3G(FileCategory.Video, new String[]{"k3g"}),
    ACC(FileCategory.Video, new String[]{"acc"}),
    AVI(FileCategory.Video, new String[]{"avi"}, new int[]{82, 73, 70, 70, -1, -1, -1, -1, 65, 86, 73, 32, 76, 73, 83, 84}),
    MOV(FileCategory.Video, new String[]{"mov"}, new int[]{0, 0, 0, 20, 102, 116, 121, 112, 113, 116, 32, 32}, new int[]{102, 116, 121, 112, 113, 116, 32, 32}, new int[]{-1, -1, -1, -1, 109, 111, 111, 118}),
    WMV(FileCategory.Video, new String[]{"wmv"}, new int[]{48, 38, 178, 117, 142, 102, 207, 17, 166, 217, 0, 170, 0, 98, 206, 108}),
    MP3(FileCategory.Audio, new String[]{"mp3"}, new int[]{73, 68, 51}, new int[]{255, 251}),
    AAC(FileCategory.Audio, new String[]{"aac"}, new int[]{255, 241}, new int[]{255, 249}),
    BMP(FileCategory.Image, new String[]{"bmp"}, new int[]{66, 77}),
    TTF(FileCategory.Font, new String[]{"ttf", "otf"});

    private static final int CHECK_SIZE = 32;
    private static final String LOG_TAG = "FileType";
    private final FileCategory category;
    private final boolean extensionOnly;
    private final String[] extensions;
    private final a imp;
    private static final Map<String, FileType> extensionMap = new HashMap();
    private static final byte[] WEBP_HEADER = {82, 73, 70, 70, 87, 69, 66, 80};

    /* loaded from: classes.dex */
    public enum FileCategory {
        Audio,
        Video,
        VideoOrAudio,
        Image,
        Font
    }

    FileType(FileCategory fileCategory, String[] strArr) {
        this.imp = new f(this);
        this.category = fileCategory;
        this.extensions = strArr;
        this.extensionOnly = true;
    }

    FileType(FileCategory fileCategory, String[] strArr, int[]... iArr) {
        this.imp = new g(this, iArr);
        this.category = fileCategory;
        this.extensions = strArr;
        this.extensionOnly = false;
    }

    private static void a() {
        if (extensionMap.isEmpty()) {
            for (FileType fileType : values()) {
                for (String str : fileType.extensions) {
                    extensionMap.put(str, fileType);
                }
            }
        }
    }

    public boolean isImage() {
        return this.category == FileCategory.Image;
    }

    public boolean isVideo() {
        return this.category == FileCategory.Video || this.category == FileCategory.VideoOrAudio;
    }

    public boolean isAudio() {
        return this.category == FileCategory.Audio || this.category == FileCategory.VideoOrAudio;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class a {
        abstract boolean a(byte[] bArr);

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public FileCategory getCategory() {
        return this.category;
    }

    public static FileType fromExtension(String str) {
        int lastIndexOf;
        if (str == null || (lastIndexOf = str.lastIndexOf(46)) < 0 || lastIndexOf < str.lastIndexOf(47)) {
            return null;
        }
        String lowerCase = str.substring(lastIndexOf + 1).toLowerCase(Locale.US);
        if (extensionMap.isEmpty()) {
            a();
        }
        return extensionMap.get(lowerCase);
    }

    public static FileType fromExtension(File file) {
        if (file == null) {
            return null;
        }
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        String lowerCase = lastIndexOf >= 0 ? name.substring(lastIndexOf + 1).toLowerCase(Locale.US) : null;
        if (lowerCase == null) {
            return null;
        }
        if (extensionMap.isEmpty()) {
            a();
        }
        return extensionMap.get(lowerCase);
    }

    public static FileType fromFile(String str) {
        if (str == null) {
            return null;
        }
        return fromFile(new File(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.nexstreaming.app.general.util.FileType fromFile(java.io.File r13) {
        /*
            r12 = 32
            r2 = 0
            r3 = 0
            if (r13 != 0) goto L8
            r0 = r2
        L7:
            return r0
        L8:
            java.lang.String r0 = r13.getName()
            r1 = 46
            int r1 = r0.lastIndexOf(r1)
            if (r1 < 0) goto L3c
            int r1 = r1 + 1
            java.lang.String r0 = r0.substring(r1)
            r6 = r0
        L1b:
            if (r6 == 0) goto L42
            com.nexstreaming.app.general.util.FileType[] r5 = values()
            int r7 = r5.length
            r4 = r3
        L23:
            if (r4 >= r7) goto L42
            r0 = r5[r4]
            java.lang.String[] r8 = r0.extensions
            int r9 = r8.length
            r1 = r3
        L2b:
            if (r1 >= r9) goto L3e
            r10 = r8[r1]
            boolean r11 = r0.extensionOnly
            if (r11 == 0) goto L39
            boolean r10 = r10.equalsIgnoreCase(r6)
            if (r10 != 0) goto L7
        L39:
            int r1 = r1 + 1
            goto L2b
        L3c:
            r6 = r2
            goto L1b
        L3e:
            int r0 = r4 + 1
            r4 = r0
            goto L23
        L42:
            boolean r0 = r13.exists()
            if (r0 == 0) goto L7d
            long r0 = r13.length()
            r4 = 32
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 < 0) goto L7d
            byte[] r1 = new byte[r12]
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.io.IOException -> L9f
            r4.<init>(r13)     // Catch: java.io.IOException -> L9f
            int r0 = r4.read(r1)     // Catch: java.lang.Throwable -> L9a
            r4.close()     // Catch: java.io.IOException -> Lb0
            r5 = r1
        L61:
            if (r5 == 0) goto L7d
            if (r0 < r12) goto L7d
            com.nexstreaming.app.general.util.FileType[] r7 = values()
            int r8 = r7.length
            r4 = r3
            r1 = r2
        L6c:
            if (r4 >= r8) goto Lb2
            r0 = r7[r4]
            com.nexstreaming.app.general.util.FileType$a r9 = r0.imp
            boolean r9 = r9.a(r5)
            if (r9 == 0) goto La3
            if (r1 == 0) goto La4
            r0 = r2
        L7b:
            if (r0 != 0) goto L7
        L7d:
            if (r6 == 0) goto Lad
            com.nexstreaming.app.general.util.FileType[] r5 = values()
            int r7 = r5.length
            r4 = r3
        L85:
            if (r4 >= r7) goto Lad
            r0 = r5[r4]
            java.lang.String[] r8 = r0.extensions
            int r9 = r8.length
            r1 = r3
        L8d:
            if (r1 >= r9) goto La9
            r10 = r8[r1]
            boolean r10 = r10.equalsIgnoreCase(r6)
            if (r10 != 0) goto L7
            int r1 = r1 + 1
            goto L8d
        L9a:
            r0 = move-exception
            r4.close()     // Catch: java.io.IOException -> L9f
            throw r0     // Catch: java.io.IOException -> L9f
        L9f:
            r0 = move-exception
            r0 = r3
        La1:
            r5 = r2
            goto L61
        La3:
            r0 = r1
        La4:
            int r1 = r4 + 1
            r4 = r1
            r1 = r0
            goto L6c
        La9:
            int r0 = r4 + 1
            r4 = r0
            goto L85
        Lad:
            r0 = r2
            goto L7
        Lb0:
            r1 = move-exception
            goto La1
        Lb2:
            r0 = r1
            goto L7b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.app.general.util.FileType.fromFile(java.io.File):com.nexstreaming.app.general.util.FileType");
    }
}
