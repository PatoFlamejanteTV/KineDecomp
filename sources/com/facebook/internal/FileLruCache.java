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
    static final String TAG = "FileLruCache";
    private static final AtomicLong bufferIndex = new AtomicLong();
    private final File directory;
    private boolean isTrimInProgress;
    private boolean isTrimPending;
    private final Limits limits;
    private final String tag;
    private AtomicLong lastClearCacheTime = new AtomicLong(0);
    private final Object lock = new Object();

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
            if (i >= 0) {
                this.byteCount = i;
                return;
            }
            throw new InvalidParameterException("Cache byte-count limit must be >= 0");
        }

        void setFileCount(int i) {
            if (i >= 0) {
                this.fileCount = i;
                return;
            }
            throw new InvalidParameterException("Cache file count limit must be >= 0");
        }
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        private static final FilenameFilter f9276a = new s();

        /* renamed from: b */
        private static final FilenameFilter f9277b = new t();

        static void a(File file) {
            File[] listFiles = file.listFiles(b());
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }

        static FilenameFilter b() {
            return f9277b;
        }

        static File b(File file) {
            return new File(file, "buffer" + Long.valueOf(FileLruCache.bufferIndex.incrementAndGet()).toString());
        }

        static FilenameFilter a() {
            return f9276a;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends OutputStream {

        /* renamed from: a */
        final OutputStream f9278a;

        /* renamed from: b */
        final e f9279b;

        b(OutputStream outputStream, e eVar) {
            this.f9278a = outputStream;
            this.f9279b = eVar;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.f9278a.close();
            } finally {
                this.f9279b.onClose();
            }
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.f9278a.flush();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.f9278a.write(bArr, i, i2);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f9278a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.f9278a.write(i);
        }
    }

    /* loaded from: classes.dex */
    public static final class d implements Comparable<d> {

        /* renamed from: a */
        private final File f9282a;

        /* renamed from: b */
        private final long f9283b;

        d(File file) {
            this.f9282a = file;
            this.f9283b = file.lastModified();
        }

        File a() {
            return this.f9282a;
        }

        long d() {
            return this.f9283b;
        }

        public boolean equals(Object obj) {
            return (obj instanceof d) && compareTo((d) obj) == 0;
        }

        public int hashCode() {
            return ((1073 + this.f9282a.hashCode()) * 37) + ((int) (this.f9283b % 2147483647L));
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(d dVar) {
            if (d() < dVar.d()) {
                return -1;
            }
            if (d() > dVar.d()) {
                return 1;
            }
            return a().compareTo(dVar.a());
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void onClose();
    }

    public FileLruCache(String str, Limits limits) {
        this.tag = str;
        this.limits = limits;
        this.directory = new File(FacebookSdk.getCacheDir(), str);
        if (this.directory.mkdirs() || this.directory.isDirectory()) {
            a.a(this.directory);
        }
    }

    private void postTrim() {
        synchronized (this.lock) {
            if (!this.isTrimPending) {
                this.isTrimPending = true;
                FacebookSdk.getExecutor().execute(new r(this));
            }
        }
    }

    public void renameToTargetAndTrim(String str, File file) {
        if (!file.renameTo(new File(this.directory, Utility.md5hash(str)))) {
            file.delete();
        }
        postTrim();
    }

    public void trim() {
        long j;
        synchronized (this.lock) {
            this.isTrimPending = false;
            this.isTrimInProgress = true;
        }
        try {
            Logger.log(LoggingBehavior.CACHE, TAG, "trim started");
            PriorityQueue priorityQueue = new PriorityQueue();
            File[] listFiles = this.directory.listFiles(a.a());
            long j2 = 0;
            if (listFiles != null) {
                long j3 = 0;
                j = 0;
                for (File file : listFiles) {
                    d dVar = new d(file);
                    priorityQueue.add(dVar);
                    Logger.log(LoggingBehavior.CACHE, TAG, "  trim considering time=" + Long.valueOf(dVar.d()) + " name=" + dVar.a().getName());
                    j3 += file.length();
                    j++;
                }
                j2 = j3;
            } else {
                j = 0;
            }
            while (true) {
                if (j2 <= this.limits.getByteCount() && j <= this.limits.getFileCount()) {
                    synchronized (this.lock) {
                        this.isTrimInProgress = false;
                        this.lock.notifyAll();
                    }
                    return;
                }
                File a2 = ((d) priorityQueue.remove()).a();
                Logger.log(LoggingBehavior.CACHE, TAG, "  trim removing " + a2.getName());
                j2 -= a2.length();
                j--;
                a2.delete();
            }
        } catch (Throwable th) {
            synchronized (this.lock) {
                this.isTrimInProgress = false;
                this.lock.notifyAll();
                throw th;
            }
        }
    }

    public void clearCache() {
        File[] listFiles = this.directory.listFiles(a.a());
        this.lastClearCacheTime.set(System.currentTimeMillis());
        if (listFiles != null) {
            FacebookSdk.getExecutor().execute(new q(this, listFiles));
        }
    }

    public InputStream get(String str) throws IOException {
        return get(str, null);
    }

    public String getLocation() {
        return this.directory.getPath();
    }

    public InputStream interceptAndPut(String str, InputStream inputStream) throws IOException {
        return new c(inputStream, openPutStream(str));
    }

    public OutputStream openPutStream(String str) throws IOException {
        return openPutStream(str, null);
    }

    long sizeInBytesForTest() {
        synchronized (this.lock) {
            while (true) {
                if (!this.isTrimPending && !this.isTrimInProgress) {
                    break;
                }
                try {
                    this.lock.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
        File[] listFiles = this.directory.listFiles();
        long j = 0;
        if (listFiles != null) {
            for (File file : listFiles) {
                j += file.length();
            }
        }
        return j;
    }

    public String toString() {
        return "{FileLruCache: tag:" + this.tag + " file:" + this.directory.getName() + "}";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends InputStream {

        /* renamed from: a */
        final InputStream f9280a;

        /* renamed from: b */
        final OutputStream f9281b;

        c(InputStream inputStream, OutputStream outputStream) {
            this.f9280a = inputStream;
            this.f9281b = outputStream;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.f9280a.available();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.f9280a.close();
            } finally {
                this.f9281b.close();
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
            int read = this.f9280a.read(bArr);
            if (read > 0) {
                this.f9281b.write(bArr, 0, read);
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

        @Override // java.io.InputStream
        public int read() throws IOException {
            int read = this.f9280a.read();
            if (read >= 0) {
                this.f9281b.write(read);
            }
            return read;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = this.f9280a.read(bArr, i, i2);
            if (read > 0) {
                this.f9281b.write(bArr, i, read);
            }
            return read;
        }
    }

    public InputStream get(String str, String str2) throws IOException {
        File file = new File(this.directory, Utility.md5hash(str));
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
            try {
                JSONObject a2 = f.a(bufferedInputStream);
                if (a2 == null) {
                    return null;
                }
                String optString = a2.optString(HEADER_CACHEKEY_KEY);
                if (optString != null && optString.equals(str)) {
                    String optString2 = a2.optString(HEADER_CACHE_CONTENT_TAG_KEY, null);
                    if ((str2 == null && optString2 != null) || (str2 != null && !str2.equals(optString2))) {
                        return null;
                    }
                    long time = new Date().getTime();
                    Logger.log(LoggingBehavior.CACHE, TAG, "Setting lastModified to " + Long.valueOf(time) + " for " + file.getName());
                    file.setLastModified(time);
                    return bufferedInputStream;
                }
                return null;
            } finally {
                bufferedInputStream.close();
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public OutputStream openPutStream(String str, String str2) throws IOException {
        File b2 = a.b(this.directory);
        b2.delete();
        if (b2.createNewFile()) {
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new b(new FileOutputStream(b2), new p(this, System.currentTimeMillis(), b2, str)), 8192);
                try {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(HEADER_CACHEKEY_KEY, str);
                        if (!Utility.isNullOrEmpty(str2)) {
                            jSONObject.put(HEADER_CACHE_CONTENT_TAG_KEY, str2);
                        }
                        f.a(bufferedOutputStream, jSONObject);
                        return bufferedOutputStream;
                    } catch (JSONException e2) {
                        Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error creating JSON header for cache file: " + e2);
                        throw new IOException(e2.getMessage());
                    }
                } catch (Throwable th) {
                    bufferedOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e3) {
                Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error creating buffer output stream: " + e3);
                throw new IOException(e3.getMessage());
            }
        }
        throw new IOException("Could not create file at " + b2.getAbsolutePath());
    }

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
            if (inputStream.read() != 0) {
                return null;
            }
            int i = 0;
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
                    return null;
                }
                return (JSONObject) nextValue;
            } catch (JSONException e2) {
                throw new IOException(e2.getMessage());
            }
        }
    }
}
