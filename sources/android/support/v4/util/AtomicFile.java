package android.support.v4.util;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class AtomicFile {

    /* renamed from: a */
    private final File f1706a;

    /* renamed from: b */
    private final File f1707b;

    public AtomicFile(File file) {
        this.f1706a = file;
        this.f1707b = new File(file.getPath() + ".bak");
    }

    private static boolean a(FileOutputStream fileOutputStream) {
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public void delete() {
        this.f1706a.delete();
        this.f1707b.delete();
    }

    public void failWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            a(fileOutputStream);
            try {
                fileOutputStream.close();
                this.f1706a.delete();
                this.f1707b.renameTo(this.f1706a);
            } catch (IOException e2) {
                Log.w("AtomicFile", "failWrite: Got exception:", e2);
            }
        }
    }

    public void finishWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            a(fileOutputStream);
            try {
                fileOutputStream.close();
                this.f1707b.delete();
            } catch (IOException e2) {
                Log.w("AtomicFile", "finishWrite: Got exception:", e2);
            }
        }
    }

    public File getBaseFile() {
        return this.f1706a;
    }

    public FileInputStream openRead() throws FileNotFoundException {
        if (this.f1707b.exists()) {
            this.f1706a.delete();
            this.f1707b.renameTo(this.f1706a);
        }
        return new FileInputStream(this.f1706a);
    }

    public byte[] readFully() throws IOException {
        FileInputStream openRead = openRead();
        try {
            byte[] bArr = new byte[openRead.available()];
            int i = 0;
            while (true) {
                int read = openRead.read(bArr, i, bArr.length - i);
                if (read <= 0) {
                    return bArr;
                }
                i += read;
                int available = openRead.available();
                if (available > bArr.length - i) {
                    byte[] bArr2 = new byte[available + i];
                    System.arraycopy(bArr, 0, bArr2, 0, i);
                    bArr = bArr2;
                }
            }
        } finally {
            openRead.close();
        }
    }

    public FileOutputStream startWrite() throws IOException {
        if (this.f1706a.exists()) {
            if (!this.f1707b.exists()) {
                if (!this.f1706a.renameTo(this.f1707b)) {
                    Log.w("AtomicFile", "Couldn't rename file " + this.f1706a + " to backup file " + this.f1707b);
                }
            } else {
                this.f1706a.delete();
            }
        }
        try {
            return new FileOutputStream(this.f1706a);
        } catch (FileNotFoundException unused) {
            if (this.f1706a.getParentFile().mkdirs()) {
                try {
                    return new FileOutputStream(this.f1706a);
                } catch (FileNotFoundException unused2) {
                    throw new IOException("Couldn't create " + this.f1706a);
                }
            }
            throw new IOException("Couldn't create directory " + this.f1706a);
        }
    }
}
