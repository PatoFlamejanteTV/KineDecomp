package com.google.protobuf;

import android.support.v7.widget.ActivityChooserView;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

/* loaded from: classes2.dex */
public final class RopeByteString extends ByteString {

    /* renamed from: b */
    private static final int[] f18672b;
    private static final long serialVersionUID = 1;
    private final ByteString left;
    private final int leftLength;
    private final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a */
        private final Stack<ByteString> f18673a;

        private a() {
            this.f18673a = new Stack<>();
        }

        private void b(ByteString byteString) {
            int a2 = a(byteString.size());
            int i = RopeByteString.f18672b[a2 + 1];
            if (!this.f18673a.isEmpty() && this.f18673a.peek().size() < i) {
                int i2 = RopeByteString.f18672b[a2];
                ByteString pop = this.f18673a.pop();
                while (!this.f18673a.isEmpty() && this.f18673a.peek().size() < i2) {
                    pop = new RopeByteString(this.f18673a.pop(), pop);
                }
                RopeByteString ropeByteString = new RopeByteString(pop, byteString);
                while (!this.f18673a.isEmpty()) {
                    if (this.f18673a.peek().size() >= RopeByteString.f18672b[a(ropeByteString.size()) + 1]) {
                        break;
                    } else {
                        ropeByteString = new RopeByteString(this.f18673a.pop(), ropeByteString);
                    }
                }
                this.f18673a.push(ropeByteString);
                return;
            }
            this.f18673a.push(byteString);
        }

        public ByteString a(ByteString byteString, ByteString byteString2) {
            a(byteString);
            a(byteString2);
            ByteString pop = this.f18673a.pop();
            while (!this.f18673a.isEmpty()) {
                pop = new RopeByteString(this.f18673a.pop(), pop);
            }
            return pop;
        }

        /* synthetic */ a(P p) {
            this();
        }

        private void a(ByteString byteString) {
            if (byteString.isBalanced()) {
                b(byteString);
                return;
            }
            if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                a(ropeByteString.left);
                a(ropeByteString.right);
            } else {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + byteString.getClass());
            }
        }

        private int a(int i) {
            int binarySearch = Arrays.binarySearch(RopeByteString.f18672b, i);
            return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Iterator<ByteString.LeafByteString> {

        /* renamed from: a */
        private final Stack<RopeByteString> f18674a;

        /* renamed from: b */
        private ByteString.LeafByteString f18675b;

        /* synthetic */ b(ByteString byteString, P p) {
            this(byteString);
        }

        private ByteString.LeafByteString a(ByteString byteString) {
            while (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                this.f18674a.push(ropeByteString);
                byteString = ropeByteString.left;
            }
            return (ByteString.LeafByteString) byteString;
        }

        private ByteString.LeafByteString b() {
            while (!this.f18674a.isEmpty()) {
                ByteString.LeafByteString a2 = a(this.f18674a.pop().right);
                if (!a2.isEmpty()) {
                    return a2;
                }
            }
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f18675b != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private b(ByteString byteString) {
            this.f18674a = new Stack<>();
            this.f18675b = a(byteString);
        }

        @Override // java.util.Iterator
        public ByteString.LeafByteString next() {
            ByteString.LeafByteString leafByteString = this.f18675b;
            if (leafByteString != null) {
                this.f18675b = b();
                return leafByteString;
            }
            throw new NoSuchElementException();
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.valueOf(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
        f18672b = new int[arrayList.size()];
        int i4 = 0;
        while (true) {
            int[] iArr = f18672b;
            if (i4 >= iArr.length) {
                return;
            }
            iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
            i4++;
        }
    }

    /* synthetic */ RopeByteString(ByteString byteString, ByteString byteString2, P p) {
        this(byteString, byteString2);
    }

    private static ByteString a(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[size + size2];
        byteString.copyTo(bArr, 0, 0, size);
        byteString2.copyTo(bArr, 0, size, size2);
        return ByteString.wrap(bArr);
    }

    public static ByteString concatenate(ByteString byteString, ByteString byteString2) {
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() == 0) {
            return byteString2;
        }
        int size = byteString.size() + byteString2.size();
        if (size < 128) {
            return a(byteString, byteString2);
        }
        if (byteString instanceof RopeByteString) {
            RopeByteString ropeByteString = (RopeByteString) byteString;
            if (ropeByteString.right.size() + byteString2.size() < 128) {
                return new RopeByteString(ropeByteString.left, a(ropeByteString.right, byteString2));
            }
            if (ropeByteString.left.getTreeDepth() > ropeByteString.right.getTreeDepth() && ropeByteString.getTreeDepth() > byteString2.getTreeDepth()) {
                return new RopeByteString(ropeByteString.left, new RopeByteString(ropeByteString.right, byteString2));
            }
        }
        if (size < f18672b[Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1]) {
            return new a().a(byteString, byteString2);
        }
        return new RopeByteString(byteString, byteString2);
    }

    static RopeByteString newInstanceForTest(ByteString byteString, ByteString byteString2) {
        return new RopeByteString(byteString, byteString2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList arrayList = new ArrayList();
        b bVar = new b(this);
        while (bVar.hasNext()) {
            arrayList.add(bVar.next().asReadOnlyByteBuffer());
        }
        return arrayList;
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int i) {
        ByteString.checkIndex(i, this.totalLength);
        int i2 = this.leftLength;
        if (i < i2) {
            return this.left.byteAt(i);
        }
        return this.right.byteAt(i - i2);
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer byteBuffer) {
        this.left.copyTo(byteBuffer);
        this.right.copyTo(byteBuffer);
    }

    @Override // com.google.protobuf.ByteString
    public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.leftLength;
        if (i4 <= i5) {
            this.left.copyToInternal(bArr, i, i2, i3);
        } else {
            if (i >= i5) {
                this.right.copyToInternal(bArr, i - i5, i2, i3);
                return;
            }
            int i6 = i5 - i;
            this.left.copyToInternal(bArr, i, i2, i6);
            this.right.copyToInternal(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    @Override // com.google.protobuf.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.totalLength != byteString.size()) {
            return false;
        }
        if (this.totalLength == 0) {
            return true;
        }
        int peekCachedHashCode = peekCachedHashCode();
        int peekCachedHashCode2 = byteString.peekCachedHashCode();
        if (peekCachedHashCode == 0 || peekCachedHashCode2 == 0 || peekCachedHashCode == peekCachedHashCode2) {
            return a(byteString);
        }
        return false;
    }

    @Override // com.google.protobuf.ByteString
    public int getTreeDepth() {
        return this.treeDepth;
    }

    @Override // com.google.protobuf.ByteString
    public boolean isBalanced() {
        return this.totalLength >= f18672b[this.treeDepth];
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        int partialIsValidUtf8 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        ByteString byteString = this.right;
        return byteString.partialIsValidUtf8(partialIsValidUtf8, 0, byteString.size()) == 0;
    }

    @Override // com.google.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.a(new c());
    }

    @Override // com.google.protobuf.ByteString
    public InputStream newInput() {
        return new c();
    }

    @Override // com.google.protobuf.ByteString
    public int partialHash(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.leftLength;
        if (i4 <= i5) {
            return this.left.partialHash(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.right.partialHash(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.right.partialHash(this.left.partialHash(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.protobuf.ByteString
    public int partialIsValidUtf8(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.leftLength;
        if (i4 <= i5) {
            return this.left.partialIsValidUtf8(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.right.partialIsValidUtf8(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.right.partialIsValidUtf8(this.left.partialIsValidUtf8(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.totalLength;
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int i, int i2) {
        int checkRange = ByteString.checkRange(i, i2, this.totalLength);
        if (checkRange == 0) {
            return ByteString.EMPTY;
        }
        if (checkRange == this.totalLength) {
            return this;
        }
        int i3 = this.leftLength;
        if (i2 <= i3) {
            return this.left.substring(i, i2);
        }
        if (i >= i3) {
            return this.right.substring(i - i3, i2 - i3);
        }
        return new RopeByteString(this.left.substring(i), this.right.substring(0, i2 - this.leftLength));
    }

    @Override // com.google.protobuf.ByteString
    protected String toStringInternal(Charset charset) {
        return new String(toByteArray(), charset);
    }

    Object writeReplace() {
        return ByteString.wrap(toByteArray());
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream outputStream) throws IOException {
        this.left.writeTo(outputStream);
        this.right.writeTo(outputStream);
    }

    @Override // com.google.protobuf.ByteString
    public void writeToInternal(OutputStream outputStream, int i, int i2) throws IOException {
        int i3 = i + i2;
        int i4 = this.leftLength;
        if (i3 <= i4) {
            this.left.writeToInternal(outputStream, i, i2);
        } else {
            if (i >= i4) {
                this.right.writeToInternal(outputStream, i - i4, i2);
                return;
            }
            int i5 = i4 - i;
            this.left.writeToInternal(outputStream, i, i5);
            this.right.writeToInternal(outputStream, 0, i2 - i5);
        }
    }

    private RopeByteString(ByteString byteString, ByteString byteString2) {
        this.left = byteString;
        this.right = byteString2;
        this.leftLength = byteString.size();
        this.totalLength = this.leftLength + byteString2.size();
        this.treeDepth = Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1;
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(ByteOutput byteOutput) throws IOException {
        this.left.writeTo(byteOutput);
        this.right.writeTo(byteOutput);
    }

    /* loaded from: classes2.dex */
    private class c extends InputStream {

        /* renamed from: a */
        private b f18676a;

        /* renamed from: b */
        private ByteString.LeafByteString f18677b;

        /* renamed from: c */
        private int f18678c;

        /* renamed from: d */
        private int f18679d;

        /* renamed from: e */
        private int f18680e;

        /* renamed from: f */
        private int f18681f;

        public c() {
            b();
        }

        private void a() {
            if (this.f18677b != null) {
                int i = this.f18679d;
                int i2 = this.f18678c;
                if (i == i2) {
                    this.f18680e += i2;
                    this.f18679d = 0;
                    if (this.f18676a.hasNext()) {
                        this.f18677b = this.f18676a.next();
                        this.f18678c = this.f18677b.size();
                    } else {
                        this.f18677b = null;
                        this.f18678c = 0;
                    }
                }
            }
        }

        private int b(byte[] bArr, int i, int i2) {
            int i3 = i;
            int i4 = i2;
            while (true) {
                if (i4 <= 0) {
                    break;
                }
                a();
                if (this.f18677b != null) {
                    int min = Math.min(this.f18678c - this.f18679d, i4);
                    if (bArr != null) {
                        this.f18677b.copyTo(bArr, this.f18679d, i3, min);
                        i3 += min;
                    }
                    this.f18679d += min;
                    i4 -= min;
                } else if (i4 == i2) {
                    return -1;
                }
            }
            return i2 - i4;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return RopeByteString.this.size() - (this.f18680e + this.f18679d);
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            this.f18681f = this.f18680e + this.f18679d;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            if (bArr != null) {
                if (i >= 0 && i2 >= 0 && i2 <= bArr.length - i) {
                    return b(bArr, i, i2);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new NullPointerException();
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            b();
            b(null, 0, this.f18681f);
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            if (j >= 0) {
                if (j > 2147483647L) {
                    j = 2147483647L;
                }
                return b(null, 0, (int) j);
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            a();
            ByteString.LeafByteString leafByteString = this.f18677b;
            if (leafByteString == null) {
                return -1;
            }
            int i = this.f18679d;
            this.f18679d = i + 1;
            return leafByteString.byteAt(i) & 255;
        }

        private void b() {
            this.f18676a = new b(RopeByteString.this);
            this.f18677b = this.f18676a.next();
            this.f18678c = this.f18677b.size();
            this.f18679d = 0;
            this.f18680e = 0;
        }
    }

    private boolean a(ByteString byteString) {
        boolean equalsRange;
        b bVar = new b(this);
        ByteString.LeafByteString next = bVar.next();
        b bVar2 = new b(byteString);
        ByteString.LeafByteString next2 = bVar2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = next.size() - i;
            int size2 = next2.size() - i2;
            int min = Math.min(size, size2);
            if (i == 0) {
                equalsRange = next.equalsRange(next2, i2, min);
            } else {
                equalsRange = next2.equalsRange(next, i, min);
            }
            if (!equalsRange) {
                return false;
            }
            i3 += min;
            int i4 = this.totalLength;
            if (i3 >= i4) {
                if (i3 == i4) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (min == size) {
                next = bVar.next();
                i = 0;
            } else {
                i += min;
                next = next;
            }
            if (min == size2) {
                next2 = bVar2.next();
                i2 = 0;
            } else {
                i2 += min;
            }
        }
    }
}
