package io.grpc.a.a;

import com.google.common.base.Preconditions;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.MessageLite;
import io.grpc.MethodDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;

/* compiled from: ProtoLiteUtils.java */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ExtensionRegistryLite f27153a = ExtensionRegistryLite.a();

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<Reference<byte[]>> f27154b = new b();

    public static <T extends MessageLite> MethodDescriptor.b<T> a(T t) {
        return new c(t, t.f());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        Preconditions.a(inputStream);
        Preconditions.a(outputStream);
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }
}
