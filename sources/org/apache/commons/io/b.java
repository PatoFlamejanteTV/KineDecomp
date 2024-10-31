package org.apache.commons.io;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

/* compiled from: FileUtils.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final BigInteger f29307a = BigInteger.valueOf(PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);

    /* renamed from: b, reason: collision with root package name */
    public static final BigInteger f29308b;

    /* renamed from: c, reason: collision with root package name */
    public static final BigInteger f29309c;

    /* renamed from: d, reason: collision with root package name */
    public static final BigInteger f29310d;

    /* renamed from: e, reason: collision with root package name */
    public static final BigInteger f29311e;

    /* renamed from: f, reason: collision with root package name */
    public static final BigInteger f29312f;

    /* renamed from: g, reason: collision with root package name */
    public static final BigInteger f29313g;

    /* renamed from: h, reason: collision with root package name */
    public static final BigInteger f29314h;
    public static final File[] i;
    private static final Charset j;

    static {
        BigInteger bigInteger = f29307a;
        f29308b = bigInteger.multiply(bigInteger);
        f29309c = f29307a.multiply(f29308b);
        f29310d = f29307a.multiply(f29309c);
        f29311e = f29307a.multiply(f29310d);
        f29312f = f29307a.multiply(f29311e);
        f29313g = BigInteger.valueOf(PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID).multiply(BigInteger.valueOf(1152921504606846976L));
        f29314h = f29307a.multiply(f29313g);
        i = new File[0];
        j = Charset.forName("UTF-8");
    }

    public static String a() {
        return System.getProperty("java.io.tmpdir");
    }

    private static org.apache.commons.io.filefilter.d b(org.apache.commons.io.filefilter.d dVar) {
        return org.apache.commons.io.filefilter.c.a(dVar, org.apache.commons.io.filefilter.c.a(DirectoryFileFilter.INSTANCE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.OutputStream, java.io.FileOutputStream] */
    private static void c(File file, File file2, boolean z) throws IOException {
        FileInputStream fileInputStream;
        ?? r4;
        FileChannel fileChannel;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileChannel fileChannel2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
            r4 = 0;
        }
        try {
            r4 = new FileOutputStream(file2);
            try {
                fileChannel = fileInputStream.getChannel();
            } catch (Throwable th2) {
                th = th2;
                fileChannel = null;
            }
        } catch (Throwable th3) {
            th = th3;
            r4 = 0;
            fileChannel = r4;
            d.a(fileChannel2);
            d.a((OutputStream) r4);
            d.a(fileChannel);
            d.a((InputStream) fileInputStream);
            throw th;
        }
        try {
            fileChannel2 = r4.getChannel();
            long size = fileChannel.size();
            long j2 = 0;
            while (j2 < size) {
                long j3 = size - j2;
                j2 += fileChannel2.transferFrom(fileChannel, j2, j3 > 31457280 ? 31457280L : j3);
            }
            d.a(fileChannel2);
            d.a((OutputStream) r4);
            d.a(fileChannel);
            d.a((InputStream) fileInputStream);
            if (file.length() == file2.length()) {
                if (z) {
                    file2.setLastModified(file.lastModified());
                }
            } else {
                throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
            }
        } catch (Throwable th4) {
            th = th4;
            d.a(fileChannel2);
            d.a((OutputStream) r4);
            d.a(fileChannel);
            d.a((InputStream) fileInputStream);
            throw th;
        }
    }

    public static void d(File file) throws IOException {
        if (file.isDirectory()) {
            b(file);
            return;
        }
        boolean exists = file.exists();
        if (file.delete()) {
            return;
        }
        if (!exists) {
            throw new FileNotFoundException("File does not exist: " + file);
        }
        throw new IOException("Unable to delete file: " + file);
    }

    public static boolean e(File file) throws IOException {
        if (file != null) {
            if (c.a()) {
                return false;
            }
            if (file.getParent() != null) {
                file = new File(file.getParentFile().getCanonicalFile(), file.getName());
            }
            return !file.getCanonicalFile().equals(file.getAbsoluteFile());
        }
        throw new NullPointerException("File must not be null");
    }

    public static FileInputStream f(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (file.canRead()) {
                    return new FileInputStream(file);
                }
                throw new IOException("File '" + file + "' cannot be read");
            }
            throw new IOException("File '" + file + "' exists but is a directory");
        }
        throw new FileNotFoundException("File '" + file + "' does not exist");
    }

    public static byte[] g(File file) throws IOException {
        FileInputStream fileInputStream;
        try {
            fileInputStream = f(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            byte[] a2 = d.a(fileInputStream, file.length());
            d.a((InputStream) fileInputStream);
            return a2;
        } catch (Throwable th2) {
            th = th2;
            d.a((InputStream) fileInputStream);
            throw th;
        }
    }

    public static long h(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                return i(file);
            }
            return file.length();
        }
        throw new IllegalArgumentException(file + " does not exist");
    }

    public static long i(File file) {
        j(file);
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0L;
        }
        long j2 = 0;
        for (File file2 : listFiles) {
            try {
                if (!e(file2)) {
                    j2 += h(file2);
                    if (j2 < 0) {
                        break;
                    }
                } else {
                    continue;
                }
            } catch (IOException unused) {
            }
        }
        return j2;
    }

    private static void j(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            throw new IllegalArgumentException(file + " is not a directory");
        }
        throw new IllegalArgumentException(file + " does not exist");
    }

    private static void a(Collection<File> collection, File file, org.apache.commons.io.filefilter.d dVar, boolean z) {
        File[] listFiles = file.listFiles((FileFilter) dVar);
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    if (z) {
                        collection.add(file2);
                    }
                    a(collection, file2, dVar, z);
                } else {
                    collection.add(file2);
                }
            }
        }
    }

    public static Collection<File> b(File file, String[] strArr, boolean z) {
        org.apache.commons.io.filefilter.d suffixFileFilter;
        if (strArr == null) {
            suffixFileFilter = TrueFileFilter.INSTANCE;
        } else {
            suffixFileFilter = new SuffixFileFilter(a(strArr));
        }
        return a(file, suffixFileFilter, z ? TrueFileFilter.INSTANCE : FalseFileFilter.INSTANCE);
    }

    public static void b(File file, File file2) throws IOException {
        b(file, file2, true);
    }

    public static void b(File file, File file2, boolean z) throws IOException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 != null) {
            if (file.exists()) {
                if (!file.isDirectory()) {
                    if (!file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                        File parentFile = file2.getParentFile();
                        if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                            throw new IOException("Destination '" + parentFile + "' directory cannot be created");
                        }
                        if (file2.exists() && !file2.canWrite()) {
                            throw new IOException("Destination '" + file2 + "' exists but is read-only");
                        }
                        c(file, file2, z);
                        return;
                    }
                    throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
                }
                throw new IOException("Source '" + file + "' exists but is a directory");
            }
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        throw new NullPointerException("Destination must not be null");
    }

    public static Collection<File> a(File file, org.apache.commons.io.filefilter.d dVar, org.apache.commons.io.filefilter.d dVar2) {
        a(file, dVar);
        org.apache.commons.io.filefilter.d b2 = b(dVar);
        org.apache.commons.io.filefilter.d a2 = a(dVar2);
        LinkedList linkedList = new LinkedList();
        a((Collection<File>) linkedList, file, org.apache.commons.io.filefilter.c.b(b2, a2), false);
        return linkedList;
    }

    public static void d(File file, File file2) throws IOException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 != null) {
            if (file.exists()) {
                if (!file.isDirectory()) {
                    if (!file2.exists()) {
                        if (!file2.isDirectory()) {
                            if (file.renameTo(file2)) {
                                return;
                            }
                            b(file, file2);
                            if (file.delete()) {
                                return;
                            }
                            c(file2);
                            throw new IOException("Failed to delete original file '" + file + "' after copy to '" + file2 + "'");
                        }
                        throw new IOException("Destination '" + file2 + "' is a directory");
                    }
                    throw new FileExistsException("Destination '" + file2 + "' already exists");
                }
                throw new IOException("Source '" + file + "' is a directory");
            }
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        throw new NullPointerException("Destination must not be null");
    }

    private static void a(File file, org.apache.commons.io.filefilter.d dVar) {
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("Parameter 'directory' is not a directory");
        }
        if (dVar == null) {
            throw new NullPointerException("Parameter 'fileFilter' is null");
        }
    }

    private static org.apache.commons.io.filefilter.d a(org.apache.commons.io.filefilter.d dVar) {
        return dVar == null ? FalseFileFilter.INSTANCE : org.apache.commons.io.filefilter.c.a(dVar, DirectoryFileFilter.INSTANCE);
    }

    private static String[] a(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr2[i2] = "." + strArr[i2];
        }
        return strArr2;
    }

    public static Iterator<File> a(File file, String[] strArr, boolean z) {
        return b(file, strArr, z).iterator();
    }

    public static boolean c(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                a(file);
            }
        } catch (Exception unused) {
        }
        try {
            return file.delete();
        } catch (Exception unused2) {
            return false;
        }
    }

    public static void a(File file, File file2) throws IOException {
        a(file, file2, true);
    }

    public static void b(File file) throws IOException {
        if (file.exists()) {
            if (!e(file)) {
                a(file);
            }
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + ".");
        }
    }

    public static void a(File file, File file2, boolean z) throws IOException {
        a(file, file2, (FileFilter) null, z);
    }

    public static void a(File file, File file2, FileFilter fileFilter, boolean z) throws IOException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 != null) {
            if (file.exists()) {
                if (file.isDirectory()) {
                    if (!file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                        ArrayList arrayList = null;
                        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
                            File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
                            if (listFiles != null && listFiles.length > 0) {
                                arrayList = new ArrayList(listFiles.length);
                                for (File file3 : listFiles) {
                                    arrayList.add(new File(file2, file3.getName()).getCanonicalPath());
                                }
                            }
                        }
                        a(file, file2, fileFilter, z, arrayList);
                        return;
                    }
                    throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
                }
                throw new IOException("Source '" + file + "' exists but is not a directory");
            }
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        throw new NullPointerException("Destination must not be null");
    }

    public static void c(File file, File file2) throws IOException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 != null) {
            if (file.exists()) {
                if (file.isDirectory()) {
                    if (!file2.exists()) {
                        if (file.renameTo(file2)) {
                            return;
                        }
                        if (!file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
                            a(file, file2);
                            b(file);
                            if (file.exists()) {
                                throw new IOException("Failed to delete original directory '" + file + "' after copy to '" + file2 + "'");
                            }
                            return;
                        }
                        throw new IOException("Cannot move directory: " + file + " to a subdirectory of itself: " + file2);
                    }
                    throw new FileExistsException("Destination '" + file2 + "' already exists");
                }
                throw new IOException("Source '" + file + "' is not a directory");
            }
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        throw new NullPointerException("Destination must not be null");
    }

    private static void a(File file, File file2, FileFilter fileFilter, boolean z, List<String> list) throws IOException {
        File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        if (listFiles != null) {
            if (file2.exists()) {
                if (!file2.isDirectory()) {
                    throw new IOException("Destination '" + file2 + "' exists but is not a directory");
                }
            } else if (!file2.mkdirs() && !file2.isDirectory()) {
                throw new IOException("Destination '" + file2 + "' directory cannot be created");
            }
            if (file2.canWrite()) {
                for (File file3 : listFiles) {
                    File file4 = new File(file2, file3.getName());
                    if (list == null || !list.contains(file3.getCanonicalPath())) {
                        if (file3.isDirectory()) {
                            a(file3, file4, fileFilter, z, list);
                        } else {
                            c(file3, file4, z);
                        }
                    }
                }
                if (z) {
                    file2.setLastModified(file.lastModified());
                    return;
                }
                return;
            }
            throw new IOException("Destination '" + file2 + "' cannot be written to");
        }
        throw new IOException("Failed to list contents of " + file);
    }

    public static void a(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    IOException e2 = null;
                    for (File file2 : listFiles) {
                        try {
                            d(file2);
                        } catch (IOException e3) {
                            e2 = e3;
                        }
                    }
                    if (e2 != null) {
                        throw e2;
                    }
                    return;
                }
                throw new IOException("Failed to list contents of " + file);
            }
            throw new IllegalArgumentException(file + " is not a directory");
        }
        throw new IllegalArgumentException(file + " does not exist");
    }
}
