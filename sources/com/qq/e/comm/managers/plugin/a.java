package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.content.res.AssetManager;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a */
    private final File f24973a;

    /* renamed from: b */
    private final File f24974b;

    /* renamed from: c */
    private String f24975c;

    /* renamed from: d */
    private int f24976d;

    public a(File file, File file2) {
        this.f24973a = file;
        this.f24974b = file2;
    }

    public static File a(Context context) {
        return new File(context.getDir("e_qq_com_plugin", 0), "gdt_plugin.jar");
    }

    public static boolean a(Context context, File file, File file2) {
        AssetManager assets = context.getAssets();
        try {
            if (Arrays.binarySearch(assets.list(CustomPkgConstants.getAssetPluginDir()), CustomPkgConstants.getAssetPluginName()) < 0) {
                return false;
            }
            String str = CustomPkgConstants.getAssetPluginDir() + File.separator + CustomPkgConstants.getAssetPluginName();
            StringUtil.writeTo("910#####" + Constants.PLUGIN.ASSET_PLUGIN_SIG, file2);
            if (StringUtil.isEmpty(CustomPkgConstants.getAssetPluginXorKey())) {
                return FileUtil.copyTo(assets.open(str), file);
            }
            InputStream open = assets.open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bytes = CustomPkgConstants.getAssetPluginXorKey().getBytes(Charset.forName("UTF-8"));
            byte[] bArr = new byte[1024];
            int length = bytes.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                int read = open.read(bArr);
                if (read <= 0) {
                    open.close();
                    fileOutputStream.close();
                    return true;
                }
                int i3 = i2;
                int i4 = i;
                int i5 = 0;
                while (i5 < read) {
                    int i6 = i4 + 1;
                    if (i4 >= 64) {
                        bArr[i5] = (byte) (bArr[i5] ^ bytes[i3 % length]);
                        i3++;
                    }
                    i5++;
                    i4 = i6;
                }
                fileOutputStream.write(bArr, 0, read);
                i = i4;
                i2 = i3;
            }
        } catch (Throwable th) {
            GDTLogger.report("Exception while init default plugin manager", th);
            return false;
        }
    }

    public static File b(Context context) {
        return new File(context.getDir("e_qq_com_plugin", 0), "gdt_plugin.next");
    }

    public static File c(Context context) {
        return new File(context.getDir("e_qq_com_plugin", 0), "gdt_plugin.jar.sig");
    }

    public static File d(Context context) {
        return new File(context.getDir("e_qq_com_plugin", 0), "gdt_plugin.next.sig");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0045 A[Catch: Throwable -> 0x004b, TRY_LEAVE, TryCatch #0 {Throwable -> 0x004b, blocks: (B:3:0x0001, B:5:0x0009, B:7:0x0011, B:9:0x0021, B:11:0x0032, B:14:0x0039, B:16:0x0045), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a() {
        /*
            r7 = this;
            r0 = 0
            java.io.File r1 = r7.f24974b     // Catch: java.lang.Throwable -> L4b
            boolean r1 = r1.exists()     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L4a
            java.io.File r1 = r7.f24973a     // Catch: java.lang.Throwable -> L4b
            boolean r1 = r1.exists()     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L4a
            java.io.File r1 = r7.f24974b     // Catch: java.lang.Throwable -> L4b
            java.lang.String r1 = com.qq.e.comm.util.StringUtil.readAll(r1)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r2 = "#####"
            java.lang.String[] r1 = r1.split(r2)     // Catch: java.lang.Throwable -> L4b
            int r2 = r1.length     // Catch: java.lang.Throwable -> L4b
            r3 = 2
            if (r2 != r3) goto L4a
            r2 = 1
            r3 = r1[r2]     // Catch: java.lang.Throwable -> L4b
            r1 = r1[r0]     // Catch: java.lang.Throwable -> L4b
            int r1 = com.qq.e.comm.util.StringUtil.parseInteger(r1, r0)     // Catch: java.lang.Throwable -> L4b
            com.qq.e.comm.util.a r4 = com.qq.e.comm.util.a.a()     // Catch: java.lang.Throwable -> L4b
            java.io.File r5 = r7.f24973a     // Catch: java.lang.Throwable -> L4b
            if (r5 == 0) goto L42
            boolean r6 = r5.exists()     // Catch: java.lang.Throwable -> L4b
            if (r6 != 0) goto L39
            goto L42
        L39:
            java.lang.String r5 = com.qq.e.comm.util.Md5Util.encode(r5)     // Catch: java.lang.Throwable -> L4b
            boolean r4 = r4.b(r3, r5)     // Catch: java.lang.Throwable -> L4b
            goto L43
        L42:
            r4 = 0
        L43:
            if (r4 == 0) goto L4a
            r7.f24975c = r3     // Catch: java.lang.Throwable -> L4b
            r7.f24976d = r1     // Catch: java.lang.Throwable -> L4b
            return r2
        L4a:
            return r0
        L4b:
            r1 = move-exception
            java.lang.String r2 = "Exception while checking plugin"
            com.qq.e.comm.util.GDTLogger.report(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.plugin.a.a():boolean");
    }

    public boolean a(File file, File file2) {
        if (file == null || file2 == null) {
            return false;
        }
        return (file.equals(this.f24973a) || FileUtil.renameTo(this.f24973a, file)) && (file2.equals(this.f24974b) || FileUtil.renameTo(this.f24974b, file2));
    }

    public int b() {
        return this.f24976d;
    }

    public String c() {
        return this.f24975c;
    }
}
