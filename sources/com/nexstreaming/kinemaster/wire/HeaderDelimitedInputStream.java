package com.nexstreaming.kinemaster.wire;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class HeaderDelimitedInputStream extends InputStream {
    private final InputStream baseStream;
    private int fileFormatFourCC;
    private int fileVersion;
    private int sectionFourCC;
    private long sectionBytesRemaining = 0;
    private boolean eof = false;
    private boolean parsedFiledHeader = false;

    public static final int FOURCC(char c, char c2, char c3, char c4) {
        return ((c & 255) << 24) | ((c2 & 255) << 16) | ((c3 & 255) << 8) | (c4 & 255);
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

    public HeaderDelimitedInputStream(InputStream inputStream) {
        this.baseStream = inputStream;
    }

    public HeaderDelimitedInputStream(File file) throws FileNotFoundException {
        this.baseStream = new FileInputStream(file);
    }

    public boolean parseFileHeader() throws IOException {
        if (this.parsedFiledHeader) {
            return true;
        }
        this.fileFormatFourCC = readInt();
        this.fileVersion = readInt();
        this.parsedFiledHeader = this.eof ? false : true;
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
            return read;
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.sectionBytesRemaining < 1) {
            return -1;
        }
        if (this.sectionBytesRemaining < i2) {
            i2 = (int) this.sectionBytesRemaining;
        }
        int read = this.baseStream.read(bArr, i, i2);
        if (read > 0) {
            this.sectionBytesRemaining -= read;
            return read;
        }
        return read;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        if (this.sectionBytesRemaining < 1) {
            return -1L;
        }
        if (this.sectionBytesRemaining < j) {
            j = this.sectionBytesRemaining;
        }
        long skip = this.baseStream.skip(j);
        if (skip > 0) {
            this.sectionBytesRemaining -= skip;
            return skip;
        }
        return skip;
    }

    public boolean nextSection() throws IOException {
        if (this.eof) {
            return false;
        }
        if (this.sectionBytesRemaining > 0) {
            this.baseStream.skip(this.sectionBytesRemaining);
        }
        this.sectionFourCC = readInt();
        this.sectionBytesRemaining = readInt();
        return !this.eof;
    }

    public long getSectionBytesRemaining() {
        return this.sectionBytesRemaining;
    }

    public int getSectionFourCC() {
        return this.sectionFourCC;
    }

    public int getFileFormatFourCC() {
        return this.fileFormatFourCC;
    }

    public int getFileVersion() {
        return this.fileVersion;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.baseStream.close();
    }
}
