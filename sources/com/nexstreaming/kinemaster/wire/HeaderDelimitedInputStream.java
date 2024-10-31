package com.nexstreaming.kinemaster.wire;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class HeaderDelimitedInputStream extends InputStream {
    private final InputStream baseStream;
    private int fileFormatFourCC;
    private int fileVersion;
    private int sectionFourCC;
    private long sectionBytesRemaining = 0;
    private boolean eof = false;
    private boolean parsedFiledHeader = false;

    public HeaderDelimitedInputStream(InputStream inputStream) {
        this.baseStream = inputStream;
    }

    public static final int FOURCC(char c2, char c3, char c4, char c5) {
        return ((c2 & 255) << 24) | ((c3 & 255) << 16) | ((c4 & 255) << 8) | (c5 & 255);
    }

    private int readInt() throws IOException {
        int read = this.baseStream.read();
        int read2 = this.baseStream.read();
        int read3 = this.baseStream.read();
        int read4 = this.baseStream.read();
        if (read != -1 && read2 != -1 && read3 != -1 && read4 != -1) {
            return ((read & 255) << 24) | ((read2 & 255) << 16) | ((read3 & 255) << 8) | (read4 & 255);
        }
        this.eof = true;
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.baseStream.close();
    }

    public int getFileFormatFourCC() {
        return this.fileFormatFourCC;
    }

    public int getFileVersion() {
        return this.fileVersion;
    }

    public long getSectionBytesRemaining() {
        return this.sectionBytesRemaining;
    }

    public int getSectionFourCC() {
        return this.sectionFourCC;
    }

    public boolean nextSection() throws IOException {
        if (this.eof) {
            return false;
        }
        long j = this.sectionBytesRemaining;
        if (j > 0) {
            this.baseStream.skip(j);
        }
        this.sectionFourCC = readInt();
        this.sectionBytesRemaining = readInt();
        return !this.eof;
    }

    public boolean parseFileHeader() throws IOException {
        if (this.parsedFiledHeader) {
            return true;
        }
        this.fileFormatFourCC = readInt();
        this.fileVersion = readInt();
        this.parsedFiledHeader = !this.eof;
        return this.parsedFiledHeader;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.sectionBytesRemaining < 1) {
            return -1;
        }
        int read = this.baseStream.read();
        if (read >= 0) {
            this.sectionBytesRemaining--;
        }
        return read;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long j2 = this.sectionBytesRemaining;
        if (j2 < 1) {
            return -1L;
        }
        if (j2 < j) {
            j = j2;
        }
        long skip = this.baseStream.skip(j);
        if (skip > 0) {
            this.sectionBytesRemaining -= skip;
        }
        return skip;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.sectionBytesRemaining;
        if (j < 1) {
            return -1;
        }
        if (j < i2) {
            i2 = (int) j;
        }
        int read = this.baseStream.read(bArr, i, i2);
        if (read > 0) {
            this.sectionBytesRemaining -= read;
        }
        return read;
    }

    public HeaderDelimitedInputStream(File file) throws FileNotFoundException {
        this.baseStream = new FileInputStream(file);
    }
}
