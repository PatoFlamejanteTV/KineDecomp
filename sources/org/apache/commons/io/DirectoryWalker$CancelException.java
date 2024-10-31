package org.apache.commons.io;

import java.io.File;
import java.io.IOException;

/* loaded from: classes3.dex */
public class DirectoryWalker$CancelException extends IOException {
    private static final long serialVersionUID = 1347339620135041008L;
    private final int depth;
    private final File file;

    public DirectoryWalker$CancelException(File file, int i) {
        this("Operation Cancelled", file, i);
    }

    public int getDepth() {
        return this.depth;
    }

    public File getFile() {
        return this.file;
    }

    public DirectoryWalker$CancelException(String str, File file, int i) {
        super(str);
        this.file = file;
        this.depth = i;
    }
}
