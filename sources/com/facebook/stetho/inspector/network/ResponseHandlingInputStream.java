package com.facebook.stetho.inspector.network;

import com.facebook.stetho.inspector.console.CLog;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.protocol.module.Console;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class ResponseHandlingInputStream extends FilterInputStream {
    private static final int BUFFER_SIZE = 1024;
    public static final String TAG = "ResponseHandlingInputStream";
    private boolean mClosed;

    @Nullable
    private final CountingOutputStream mDecompressedCounter;
    private boolean mEofSeen;
    private long mLastDecompressedCount;
    private final ChromePeerManager mNetworkPeerManager;
    private final OutputStream mOutputStream;
    private final String mRequestId;
    private final ResponseHandler mResponseHandler;

    @Nullable
    private byte[] mSkipBuffer;

    public ResponseHandlingInputStream(InputStream inputStream, String str, OutputStream outputStream, @Nullable CountingOutputStream countingOutputStream, ChromePeerManager chromePeerManager, ResponseHandler responseHandler) {
        super(inputStream);
        this.mLastDecompressedCount = 0L;
        this.mRequestId = str;
        this.mOutputStream = outputStream;
        this.mDecompressedCounter = countingOutputStream;
        this.mNetworkPeerManager = chromePeerManager;
        this.mResponseHandler = responseHandler;
        this.mClosed = false;
    }

    private synchronized int checkEOF(int i) {
        if (i == -1) {
            closeOutputStreamQuietly();
            this.mResponseHandler.onEOF();
            this.mEofSeen = true;
        }
        return i;
    }

    private synchronized void closeOutputStreamQuietly() {
        if (!this.mClosed) {
            try {
                try {
                    this.mOutputStream.close();
                    reportDecodedSizeIfApplicable();
                } catch (IOException e2) {
                    CLog.writeToConsole(this.mNetworkPeerManager, Console.MessageLevel.ERROR, Console.MessageSource.NETWORK, "Could not close the output stream" + e2);
                }
            } finally {
            }
        }
    }

    @Nonnull
    private byte[] getSkipBufferLocked() {
        if (this.mSkipBuffer == null) {
            this.mSkipBuffer = new byte[1024];
        }
        return this.mSkipBuffer;
    }

    private IOException handleIOException(IOException iOException) {
        this.mResponseHandler.onError(iOException);
        return iOException;
    }

    private void handleIOExceptionWritingToStream(IOException iOException) {
        CLog.writeToConsole(this.mNetworkPeerManager, Console.MessageLevel.ERROR, Console.MessageSource.NETWORK, "Could not write response body to the stream " + iOException);
        closeOutputStreamQuietly();
    }

    private void reportDecodedSizeIfApplicable() {
        CountingOutputStream countingOutputStream = this.mDecompressedCounter;
        if (countingOutputStream != null) {
            long count = countingOutputStream.getCount();
            this.mResponseHandler.onReadDecoded((int) (count - this.mLastDecompressedCount));
            this.mLastDecompressedCount = count;
        }
    }

    private synchronized void writeToOutputStream(int i) {
        if (this.mClosed) {
            return;
        }
        try {
            this.mOutputStream.write(i);
            reportDecodedSizeIfApplicable();
        } catch (IOException e2) {
            handleIOExceptionWritingToStream(e2);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        long j;
        try {
            if (!this.mEofSeen) {
                byte[] bArr = new byte[1024];
                j = 0;
                while (true) {
                    int read = read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        j += read;
                    }
                }
            } else {
                j = 0;
            }
            if (j > 0) {
                CLog.writeToConsole(this.mNetworkPeerManager, Console.MessageLevel.ERROR, Console.MessageSource.NETWORK, "There were " + String.valueOf(j) + " bytes that were not consumed while processing request " + this.mRequestId);
            }
        } finally {
            super.close();
            closeOutputStreamQuietly();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        try {
            int read = ((FilterInputStream) this).in.read();
            checkEOF(read);
            if (read != -1) {
                this.mResponseHandler.onRead(1);
                writeToOutputStream(read);
            }
            return read;
        } catch (IOException e2) {
            handleIOException(e2);
            throw e2;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException("Mark not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        long j2;
        byte[] skipBufferLocked = getSkipBufferLocked();
        j2 = 0;
        while (j2 < j) {
            int read = read(skipBufferLocked, 0, (int) Math.min(skipBufferLocked.length, j - j2));
            if (read == -1) {
                break;
            }
            j2 += read;
        }
        return j2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            int read = ((FilterInputStream) this).in.read(bArr, i, i2);
            checkEOF(read);
            if (read != -1) {
                this.mResponseHandler.onRead(read);
                writeToOutputStream(bArr, i, read);
            }
            return read;
        } catch (IOException e2) {
            handleIOException(e2);
            throw e2;
        }
    }

    private synchronized void writeToOutputStream(byte[] bArr, int i, int i2) {
        if (this.mClosed) {
            return;
        }
        try {
            this.mOutputStream.write(bArr, i, i2);
            reportDecodedSizeIfApplicable();
        } catch (IOException e2) {
            handleIOExceptionWritingToStream(e2);
        }
    }
}
