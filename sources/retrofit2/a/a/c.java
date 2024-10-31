package retrofit2.a.a;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import okhttp3.O;
import retrofit2.j;

/* compiled from: GsonResponseBodyConverter.java */
/* loaded from: classes3.dex */
final class c<T> implements j<O, T> {

    /* renamed from: a, reason: collision with root package name */
    private final Gson f29455a;

    /* renamed from: b, reason: collision with root package name */
    private final TypeAdapter<T> f29456b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f29455a = gson;
        this.f29456b = typeAdapter;
    }

    @Override // retrofit2.j
    public T a(O o) throws IOException {
        JsonReader newJsonReader = this.f29455a.newJsonReader(o.a());
        try {
            T read2 = this.f29456b.read2(newJsonReader);
            if (newJsonReader.peek() == JsonToken.END_DOCUMENT) {
                return read2;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            o.close();
        }
    }
}
