package io.grpc.a.a;

import android.support.v7.widget.ActivityChooserView;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import io.grpc.I;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ProtoLiteUtils.java */
/* loaded from: classes3.dex */
public class c<T> implements MethodDescriptor.c<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MessageLite f27151a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Parser f27152b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MessageLite messageLite, Parser parser) {
        this.f27151a = messageLite;
        this.f27152b = parser;
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)Ljava/io/InputStream; */
    @Override // io.grpc.MethodDescriptor.b
    public InputStream a(MessageLite messageLite) {
        return new a(messageLite, this.f27152b);
    }

    /* JADX WARN: Incorrect return type in method signature: (Ljava/io/InputStream;)TT; */
    @Override // io.grpc.MethodDescriptor.b
    public MessageLite a(InputStream inputStream) {
        ThreadLocal threadLocal;
        ThreadLocal threadLocal2;
        if ((inputStream instanceof a) && ((a) inputStream).b() == this.f27152b) {
            try {
                return ((a) inputStream).a();
            } catch (IllegalStateException unused) {
            }
        }
        CodedInputStream codedInputStream = null;
        try {
            if (inputStream instanceof I) {
                int available = inputStream.available();
                if (available > 0 && available <= 4194304) {
                    threadLocal = d.f27154b;
                    byte[] bArr = (byte[]) ((Reference) threadLocal.get()).get();
                    if (bArr == null || bArr.length < available) {
                        bArr = new byte[available];
                        threadLocal2 = d.f27154b;
                        threadLocal2.set(new WeakReference(bArr));
                    }
                    int i = available;
                    while (i > 0) {
                        int read = inputStream.read(bArr, available - i, i);
                        if (read == -1) {
                            break;
                        }
                        i -= read;
                    }
                    if (i == 0) {
                        codedInputStream = CodedInputStream.a(bArr, 0, available);
                    } else {
                        throw new RuntimeException("size inaccurate: " + available + " != " + (available - i));
                    }
                } else if (available == 0) {
                    return this.f27151a;
                }
            }
            if (codedInputStream == null) {
                codedInputStream = CodedInputStream.a(inputStream);
            }
            codedInputStream.e(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            try {
                return a(codedInputStream);
            } catch (InvalidProtocolBufferException e2) {
                throw Status.p.b("Invalid protobuf byte sequence").b(e2).c();
            }
        } catch (IOException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX WARN: Incorrect return type in method signature: (Lcom/google/protobuf/CodedInputStream;)TT; */
    private MessageLite a(CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        ExtensionRegistryLite extensionRegistryLite;
        Parser parser = this.f27152b;
        extensionRegistryLite = d.f27153a;
        MessageLite messageLite = (MessageLite) parser.a(codedInputStream, extensionRegistryLite);
        try {
            codedInputStream.a(0);
            return messageLite;
        } catch (InvalidProtocolBufferException e2) {
            e2.setUnfinishedMessage(messageLite);
            throw e2;
        }
    }
}
