package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* compiled from: Exceptions.kt */
/* loaded from: classes3.dex */
public final class NoSuchFileException extends FileSystemException {
    public /* synthetic */ NoSuchFileException(File file, File file2, String str, int i, f fVar) {
        this(file, (i & 2) != 0 ? null : file2, (i & 4) != 0 ? null : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoSuchFileException(File file, File file2, String str) {
        super(file, file2, str);
        h.b(file, "file");
    }
}
