package com.nexstreaming.app.general.util;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public enum FileCategory {
        Audio,
        Video,
        VideoOrAudio,
        Image,
        Font
    }

    /* loaded from: classes2.dex */
    public static abstract class a {
        private a() {
        }

        abstract boolean a(byte[] bArr);

        public /* synthetic */ a(C1706j c1706j) {
            this();
        }
    }

    FileType(FileCategory fileCategory, String[] strArr) {
        this.imp = new C1706j(this);
        this.category = fileCategory;
        this.extensions = strArr;
        this.extensionOnly = true;
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

    public static FileType fromFile(String str) {
        if (str == null) {
            return null;
        }
        return fromFile(new File(str));
    }

    public FileCategory getCategory() {
        return this.category;
    }

    public boolean isAudio() {
        FileCategory fileCategory = this.category;
        return fileCategory == FileCategory.Audio || fileCategory == FileCategory.VideoOrAudio;
    }

    public boolean isImage() {
        return this.category == FileCategory.Image;
    }

    public boolean isVideo() {
        FileCategory fileCategory = this.category;
        return fileCategory == FileCategory.Video || fileCategory == FileCategory.VideoOrAudio;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0085 A[EDGE_INSN: B:52:0x0085->B:49:0x0085 BREAK  A[LOOP:2: B:40:0x0071->B:46:0x0082], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.nexstreaming.app.general.util.FileType fromFile(java.io.File r12) {
        /*
            r0 = 0
            if (r12 != 0) goto L4
            return r0
        L4:
            java.lang.String r1 = r12.getName()
            r2 = 46
            int r2 = r1.lastIndexOf(r2)
            if (r2 < 0) goto L17
            int r2 = r2 + 1
            java.lang.String r1 = r1.substring(r2)
            goto L18
        L17:
            r1 = r0
        L18:
            r2 = 0
            if (r1 == 0) goto L3e
            com.nexstreaming.app.general.util.FileType[] r3 = values()
            int r4 = r3.length
            r5 = 0
        L21:
            if (r5 >= r4) goto L3e
            r6 = r3[r5]
            java.lang.String[] r7 = r6.extensions
            int r8 = r7.length
            r9 = 0
        L29:
            if (r9 >= r8) goto L3b
            r10 = r7[r9]
            boolean r11 = r6.extensionOnly
            if (r11 == 0) goto L38
            boolean r10 = r10.equalsIgnoreCase(r1)
            if (r10 == 0) goto L38
            return r6
        L38:
            int r9 = r9 + 1
            goto L29
        L3b:
            int r5 = r5 + 1
            goto L21
        L3e:
            boolean r3 = r12.exists()
            if (r3 == 0) goto L88
            long r3 = r12.length()
            r5 = 32
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 < 0) goto L88
            r3 = 32
            byte[] r4 = new byte[r3]
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.io.IOException -> L64
            r5.<init>(r12)     // Catch: java.io.IOException -> L64
            int r12 = r5.read(r4)     // Catch: java.lang.Throwable -> L5f
            r5.close()     // Catch: java.io.IOException -> L65
            goto L66
        L5f:
            r12 = move-exception
            r5.close()     // Catch: java.io.IOException -> L64
            throw r12     // Catch: java.io.IOException -> L64
        L64:
            r12 = 0
        L65:
            r4 = r0
        L66:
            if (r4 == 0) goto L88
            if (r12 < r3) goto L88
            com.nexstreaming.app.general.util.FileType[] r12 = values()
            int r3 = r12.length
            r6 = r0
            r5 = 0
        L71:
            if (r5 >= r3) goto L85
            r7 = r12[r5]
            com.nexstreaming.app.general.util.FileType$a r8 = r7.imp
            boolean r8 = r8.a(r4)
            if (r8 == 0) goto L82
            if (r6 == 0) goto L81
            r6 = r0
            goto L85
        L81:
            r6 = r7
        L82:
            int r5 = r5 + 1
            goto L71
        L85:
            if (r6 == 0) goto L88
            return r6
        L88:
            if (r1 == 0) goto La9
            com.nexstreaming.app.general.util.FileType[] r12 = values()
            int r3 = r12.length
            r4 = 0
        L90:
            if (r4 >= r3) goto La9
            r5 = r12[r4]
            java.lang.String[] r6 = r5.extensions
            int r7 = r6.length
            r8 = 0
        L98:
            if (r8 >= r7) goto La6
            r9 = r6[r8]
            boolean r9 = r9.equalsIgnoreCase(r1)
            if (r9 == 0) goto La3
            return r5
        La3:
            int r8 = r8 + 1
            goto L98
        La6:
            int r4 = r4 + 1
            goto L90
        La9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.app.general.util.FileType.fromFile(java.io.File):com.nexstreaming.app.general.util.FileType");
    }

    FileType(FileCategory fileCategory, String[] strArr, int[]... iArr) {
        this.imp = new C1707k(this, iArr);
        this.category = fileCategory;
        this.extensions = strArr;
        this.extensionOnly = false;
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
}
