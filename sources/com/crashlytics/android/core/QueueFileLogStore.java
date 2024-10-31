package com.crashlytics.android.core;

import io.fabric.sdk.android.f;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.w;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/* loaded from: classes.dex */
class QueueFileLogStore implements FileLogStore {
    private w logFile;
    private final int maxLogSize;
    private final File workingFile;

    /* loaded from: classes.dex */
    public class LogBytes {
        public final byte[] bytes;
        public final int offset;

        public LogBytes(byte[] bArr, int i) {
            this.bytes = bArr;
            this.offset = i;
        }
    }

    public QueueFileLogStore(File file, int i) {
        this.workingFile = file;
        this.maxLogSize = i;
    }

    private void doWriteToLog(long j, String str) {
        if (this.logFile == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            int i = this.maxLogSize / 4;
            if (str.length() > i) {
                str = "..." + str.substring(str.length() - i);
            }
            this.logFile.a(String.format(Locale.US, "%d %s%n", Long.valueOf(j), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes("UTF-8"));
            while (!this.logFile.b() && this.logFile.r() > this.maxLogSize) {
                this.logFile.c();
            }
        } catch (IOException e2) {
            f.f().c(CrashlyticsCore.TAG, "There was a problem writing to the Crashlytics log.", e2);
        }
    }

    private LogBytes getLogBytes() {
        if (!this.workingFile.exists()) {
            return null;
        }
        openLogFile();
        w wVar = this.logFile;
        if (wVar == null) {
            return null;
        }
        final int[] iArr = {0};
        final byte[] bArr = new byte[wVar.r()];
        try {
            this.logFile.a(new w.c() { // from class: com.crashlytics.android.core.QueueFileLogStore.1
                @Override // io.fabric.sdk.android.services.common.w.c
                public void read(InputStream inputStream, int i) throws IOException {
                    try {
                        inputStream.read(bArr, iArr[0], i);
                        int[] iArr2 = iArr;
                        iArr2[0] = iArr2[0] + i;
                    } finally {
                        inputStream.close();
                    }
                }
            });
        } catch (IOException e2) {
            f.f().c(CrashlyticsCore.TAG, "A problem occurred while reading the Crashlytics log file.", e2);
        }
        return new LogBytes(bArr, iArr[0]);
    }

    private void openLogFile() {
        if (this.logFile == null) {
            try {
                this.logFile = new w(this.workingFile);
            } catch (IOException e2) {
                f.f().c(CrashlyticsCore.TAG, "Could not open log file: " + this.workingFile, e2);
            }
        }
    }

    @Override // com.crashlytics.android.core.FileLogStore
    public void closeLogFile() {
        CommonUtils.a(this.logFile, "There was a problem closing the Crashlytics log file.");
        this.logFile = null;
    }

    @Override // com.crashlytics.android.core.FileLogStore
    public void deleteLogFile() {
        closeLogFile();
        this.workingFile.delete();
    }

    @Override // com.crashlytics.android.core.FileLogStore
    public ByteString getLogAsByteString() {
        LogBytes logBytes = getLogBytes();
        if (logBytes == null) {
            return null;
        }
        return ByteString.copyFrom(logBytes.bytes, 0, logBytes.offset);
    }

    @Override // com.crashlytics.android.core.FileLogStore
    public byte[] getLogAsBytes() {
        LogBytes logBytes = getLogBytes();
        if (logBytes == null) {
            return null;
        }
        return logBytes.bytes;
    }

    @Override // com.crashlytics.android.core.FileLogStore
    public void writeToLog(long j, String str) {
        openLogFile();
        doWriteToLog(j, str);
    }
}
