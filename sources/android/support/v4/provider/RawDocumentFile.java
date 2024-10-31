package android.support.v4.provider;

import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
class RawDocumentFile extends DocumentFile {

    /* renamed from: b */
    private File f1636b;

    public RawDocumentFile(DocumentFile documentFile, File file) {
        super(documentFile);
        this.f1636b = file;
    }

    private static String a(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(lastIndexOf + 1).toLowerCase());
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean canRead() {
        return this.f1636b.canRead();
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean canWrite() {
        return this.f1636b.canWrite();
    }

    @Override // android.support.v4.provider.DocumentFile
    public DocumentFile createDirectory(String str) {
        File file = new File(this.f1636b, str);
        if (file.isDirectory() || file.mkdir()) {
            return new RawDocumentFile(this, file);
        }
        return null;
    }

    @Override // android.support.v4.provider.DocumentFile
    public DocumentFile createFile(String str, String str2) {
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        if (extensionFromMimeType != null) {
            str2 = str2 + "." + extensionFromMimeType;
        }
        File file = new File(this.f1636b, str2);
        try {
            file.createNewFile();
            return new RawDocumentFile(this, file);
        } catch (IOException e2) {
            Log.w("DocumentFile", "Failed to createFile: " + e2);
            return null;
        }
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean delete() {
        a(this.f1636b);
        return this.f1636b.delete();
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean exists() {
        return this.f1636b.exists();
    }

    @Override // android.support.v4.provider.DocumentFile
    public String getName() {
        return this.f1636b.getName();
    }

    @Override // android.support.v4.provider.DocumentFile
    public String getType() {
        if (this.f1636b.isDirectory()) {
            return null;
        }
        return a(this.f1636b.getName());
    }

    @Override // android.support.v4.provider.DocumentFile
    public Uri getUri() {
        return Uri.fromFile(this.f1636b);
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean isDirectory() {
        return this.f1636b.isDirectory();
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean isFile() {
        return this.f1636b.isFile();
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean isVirtual() {
        return false;
    }

    @Override // android.support.v4.provider.DocumentFile
    public long lastModified() {
        return this.f1636b.lastModified();
    }

    @Override // android.support.v4.provider.DocumentFile
    public long length() {
        return this.f1636b.length();
    }

    @Override // android.support.v4.provider.DocumentFile
    public DocumentFile[] listFiles() {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = this.f1636b.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                arrayList.add(new RawDocumentFile(this, file));
            }
        }
        return (DocumentFile[]) arrayList.toArray(new DocumentFile[arrayList.size()]);
    }

    @Override // android.support.v4.provider.DocumentFile
    public boolean renameTo(String str) {
        File file = new File(this.f1636b.getParentFile(), str);
        if (!this.f1636b.renameTo(file)) {
            return false;
        }
        this.f1636b = file;
        return true;
    }

    private static boolean a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return true;
        }
        boolean z = true;
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                z &= a(file2);
            }
            if (!file2.delete()) {
                Log.w("DocumentFile", "Failed to delete " + file2);
                z = false;
            }
        }
        return z;
    }
}
