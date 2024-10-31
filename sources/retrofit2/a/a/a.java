package retrofit2.a.a;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.L;
import okhttp3.O;
import retrofit2.F;
import retrofit2.j;

/* compiled from: GsonConverterFactory.java */
/* loaded from: classes3.dex */
public final class a extends j.a {

    /* renamed from: a, reason: collision with root package name */
    private final Gson f29450a;

    private a(Gson gson) {
        this.f29450a = gson;
    }

    public static a a() {
        return a(new Gson());
    }

    public static a a(Gson gson) {
        if (gson != null) {
            return new a(gson);
        }
        throw new NullPointerException("gson == null");
    }

    @Override // retrofit2.j.a
    public j<O, ?> a(Type type, Annotation[] annotationArr, F f2) {
        return new c(this.f29450a, this.f29450a.getAdapter(TypeToken.get(type)));
    }

    @Override // retrofit2.j.a
    public j<?, L> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, F f2) {
        return new b(this.f29450a, this.f29450a.getAdapter(TypeToken.get(type)));
    }
}
