package retrofit2.a.a;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.C;
import okhttp3.L;
import okio.g;
import retrofit2.j;

/* compiled from: GsonRequestBodyConverter.java */
/* loaded from: classes3.dex */
final class b<T> implements j<T, L> {

    /* renamed from: a, reason: collision with root package name */
    private static final C f29451a = C.a("application/json; charset=UTF-8");

    /* renamed from: b, reason: collision with root package name */
    private static final Charset f29452b = Charset.forName("UTF-8");

    /* renamed from: c, reason: collision with root package name */
    private final Gson f29453c;

    /* renamed from: d, reason: collision with root package name */
    private final TypeAdapter<T> f29454d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f29453c = gson;
        this.f29454d = typeAdapter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // retrofit2.j
    public /* bridge */ /* synthetic */ L a(Object obj) throws IOException {
        return a((b<T>) obj);
    }

    @Override // retrofit2.j
    public L a(T t) throws IOException {
        g gVar = new g();
        JsonWriter newJsonWriter = this.f29453c.newJsonWriter(new OutputStreamWriter(gVar.c(), f29452b));
        this.f29454d.write(newJsonWriter, t);
        newJsonWriter.close();
        return L.a(f29451a, gVar.q());
    }
}
