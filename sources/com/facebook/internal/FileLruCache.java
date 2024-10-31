package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes.dex */
public final class FileLruCache {
    private static final String HEADER_CACHEKEY_KEY = "key";
    private static final String HEADER_CACHE_CONTENT_TAG_KEY = "tag";
    static final String TAG = FileLruCache.class.getSimpleName();
    private static final AtomicLong bufferIndex = new AtomicLong();
    private final File directory;
    private boolean isTrimInProgress;
    private boolean isTrimPending;
    private final Limits limits;
    private final String tag;
    private AtomicLong lastClearCacheTime = new AtomicLong(0);
    private final Object lock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface e {
        void a();
    }

    public FileLruCache(String str, Limits limits) {
        this.tag = str;
        this.limits = limits;
        this.directory = new File(FacebookSdk.getCacheDir(), str);
        if (this.directory.mkdirs() || this.directory.isDirectory()) {
            a.a(this.directory);
        }
    }

    long sizeInBytesForTest() {
        synchronized (this.lock) {
            while (true) {
                if (!this.isTrimPending && !this.isTrimInProgress) {
                    break;
                }
                try {
                    this.lock.wait();
                } catch (InterruptedException e2) {
                }
            }
        }
        File[] listFiles = this.directory.listFiles();
        long j = 0;
        if (listFiles != null) {
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                long length2 = listFiles[i].length() + j;
                i++;
                j = length2;
            }
        }
        return j;
    }

    public InputStream get(String str) throws IOException {
        return get(str, null);
    }

    public InputStream get(String str, String str2) throws IOException {
        File file = new File(this.directory, Utility.md5hash(str));
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), Utility.DEFAULT_STREAM_BUFFER_SIZE);
            try {
                JSONObject a2 = f.a(bufferedInputStream);
                if (a2 == null) {
                    return null;
                }
                String optString = a2.optString(HEADER_CACHEKEY_KEY);
                if (optString == null || !optString.equals(str)) {
                    return null;
                }
                String optString2 = a2.optString(HEADER_CACHE_CONTENT_TAG_KEY, null);
                if ((str2 == null && optString2 != null) || (str2 != null && !str2.equals(optString2))) {
                    return null;
                }
                long time = new Date().getTime();
                Logger.log(LoggingBehavior.CACHE, TAG, "Setting lastModified to " + Long.valueOf(time) + " for " + file.getName());
                file.setLastModified(time);
                return bufferedInputStream;
            } finally {
                bufferedInputStream.close();
            }
        } catch (IOException e2) {
            return null;
        }
    }

    public OutputStream openPutStream(String str) throws IOException {
        return openPutStream(str, null);
    }

    public OutputStream openPutStream(String str, String str2) throws IOException {
        File b2 = a.b(this.directory);
        b2.delete();
        if (!b2.createNewFile()) {
            throw new IOException("Could not create file at " + b2.getAbsolutePath());
        }
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new b(new FileOutputStream(b2), new o(this, System.currentTimeMillis(), b2, str)), Utility.DEFAULT_STREAM_BUFFER_SIZE);
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(HEADER_CACHEKEY_KEY, str);
                    if (!Utility.isNullOrEmpty(str2)) {
                        jSONObject.put(HEADER_CACHE_CONTENT_TAG_KEY, str2);
                    }
                    f.a(bufferedOutputStream, jSONObject);
                    return bufferedOutputStream;
                } catch (Throwable th) {
                    bufferedOutputStream.close();
                    throw th;
                }
            } catch (JSONException e2) {
                Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error creating JSON header for cache file: " + e2);
                throw new IOException(e2.getMessage());
            }
        } catch (FileNotFoundException e3) {
            Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error creating buffer output stream: " + e3);
            throw new IOException(e3.getMessage());
        }
    }

    public void clearCache() {
        File[] listFiles = this.directory.listFiles(a.a());
        this.lastClearCacheTime.set(System.currentTimeMillis());
        if (listFiles != null) {
            FacebookSdk.getExecutor().execute(new p(this, listFiles));
        }
    }

    public String getLocation() {
        return this.directory.getPath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renameToTargetAndTrim(String str, File file) {
        if (!file.renameTo(new File(this.directory, Utility.md5hash(str)))) {
            file.delete();
        }
        postTrim();
    }

    public InputStream interceptAndPut(String str, InputStream inputStream) throws IOException {
        return new c(inputStream, openPutStream(str));
    }

    public String toString() {
        return "{FileLruCache: tag:" + this.tag + " file:" + this.directory.getName() + "}";
    }

    private void postTrim() {
        synchronized (this.lock) {
            if (!this.isTrimPending) {
                this.isTrimPending = true;
                FacebookSdk.getExecutor().execute(new q(this));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trim() {
        synchronized (this.lock) {
            this.isTrimPending = false;
            this.isTrimInProgress = true;
        }
        try {
            Logger.log(LoggingBehavior.CACHE, TAG, "trim started");
            PriorityQueue priorityQueue = new PriorityQueue();
            long j = 0;
            long j2 = 0;
            File[] listFiles = this.directory.listFiles(a.a());
            if (listFiles != null) {
                int length = listFiles.length;
                int i = 0;
                while (i < length) {
                    File file = listFiles[i];
                    d dVar = new d(file);
                    priorityQueue.add(dVar);
                    Logger.log(LoggingBehavior.CACHE, TAG, "  trim considering time=" + Long.valueOf(dVar.b()) + " name=" + dVar.a().getName());
                    i++;
                    j2 = 1 + j2;
                    j = file.length() + j;
                }
            }
            long j3 = j;
            while (true) {
                long j4 = j2;
                if (j3 > this.limits.getByteCount() || j4 > this.limits.getFileCount()) {
                    File a2 = ((d) priorityQueue.remove()).a();
                    Logger.log(LoggingBehavior.CACHE, TAG, "  trim removing " + a2.getName());
                    j3 -= a2.length();
                    j2 = j4 - 1;
                    a2.delete();
                } else {
                    synchronized (this.lock) {
                        this.isTrimInProgress = false;
                        this.lock.notifyAll();
                    }
                    return;
                }
            }
        } catch (Throwable th) {
            synchronized (this.lock) {
                this.isTrimInProgress = false;
                this.lock.notifyAll();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final FilenameFilter f269a = new r();
        private static final FilenameFilter b = new s();

        static void a(File file) {
            File[] listFiles = file.listFiles(b());
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }

        static FilenameFilter a() {
            return f269a;
        }

        static FilenameFilter b() {
            return b;
        }

        static File b(File file) {
            return new File(file, "buffer" + Long.valueOf(FileLruCache.bufferIndex.incrementAndGet()).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class f {
        static void a(OutputStream outputStream, JSONObject jSONObject) throws IOException {
            byte[] bytes = jSONObject.toString().getBytes();
            outputStream.write(0);
            outputStream.write((bytes.length >> 16) & 255);
            outputStream.write((bytes.length >> 8) & 255);
            outputStream.write((bytes.length >> 0) & 255);
            outputStream.write(bytes);
        }

        static JSONObject a(InputStream inputStream) throws IOException {
            JSONObject jSONObject;
            int i = 0;
            if (inputStream.read() != 0) {
                return null;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < 3; i3++) {
                int read = inputStream.read();
                if (read == -1) {
                    Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read returned -1 while reading header size");
                    return null;
                }
                i2 = (i2 << 8) + (read & 255);
            }
            byte[] bArr = new byte[i2];
            while (i < bArr.length) {
                int read2 = inputStream.read(bArr, i, bArr.length - i);
                if (read2 < 1) {
                    Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read stopped at " + Integer.valueOf(i) + " when expected " + bArr.length);
                    return null;
                }
                i += read2;
            }
            try {
                Object nextValue = new JSONTokener(new String(bArr)).nextValue();
                if (!(nextValue instanceof JSONObject)) {
                    Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: expected JSONObject, got " + nextValue.getClass().getCanonicalName());
                    jSONObject = null;
                } else {
                    jSONObject = (JSONObject) nextValue;
                }
                return jSONObject;
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends OutputStream {

        /* renamed from: a, reason: collision with root package name */
        final OutputStream f270a;
        final e b;

        b(OutputStream outputStream, e eVar) {
            this.f270a = outputStream;
            this.b = eVar;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.f270a.close();
            } finally {
                this.b.a();
            }
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.f270a.flush();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.f270a.write(bArr, i, i2);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f270a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.f270a.write(i);
        }
    }

    /* loaded from: classes.dex */
    private static final class c extends InputStream {

        /* renamed from: a, reason: collision with root package name */
        final InputStream f271a;
        final OutputStream b;

        c(InputStream inputStream, OutputStream outputStream) {
            this.f271a = inputStream;
            this.b = outputStream;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.f271a.available();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.f271a.close();
            } finally {
                this.b.close();
            }
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return false;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            int read = this.f271a.read(bArr);
            if (read > 0) {
                this.b.write(bArr, 0, read);
            }
            return read;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int read = this.f271a.read();
            if (read >= 0) {
                this.b.write(read);
            }
            return read;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = this.f271a.read(bArr, i, i2);
            if (read > 0) {
                this.b.write(bArr, i, read);
            }
            return read;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            throw new UnsupportedOperationException();
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            int read;
            byte[] bArr = new byte[1024];
            long j2 = 0;
            while (j2 < j && (read = read(bArr, 0, (int) Math.min(j - j2, bArr.length))) >= 0) {
                j2 += read;
            }
            return j2;
        }
    }

    /* loaded from: classes.dex */
    public static final class Limits {
        private int fileCount = 1024;
        private int byteCount = 1048576;

        int getByteCount() {
            return this.byteCount;
        }

        int getFileCount() {
            return this.fileCount;
        }

        void setByteCount(int i) {
            if (i < 0) {
                throw new InvalidParameterException("Cache byte-count limit must be >= 0");
            }
            this.byteCount = i;
        }

        void setFileCount(int i) {
            if (i < 0) {
                throw new InvalidParameterException("Cache file count limit must be >= 0");
            }
            this.fileCount = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d implements Comparable<d> {

        /* renamed from: a, reason: collision with root package name */
        private final File f272a;
        private final long b;

        d(File file) {
            this.f272a = file;
            this.b = file.lastModified();
        }

        File a() {
            return this.f272a;
        }

        long b() {
            return this.b;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            if (b() < dVar.b()) {
                return -1;
            }
            if (b() > dVar.b()) {
                return 1;
            }
            return a().compareTo(dVar.a());
        }

        public boolean equals(Object obj) {
            return (obj instanceof d) && compareTo((d) obj) == 0;
        }

        public int hashCode() {
            return ((this.f272a.hashCode() + 1073) * 37) + ((int) (this.b % 2147483647L));
        }
    }
}
