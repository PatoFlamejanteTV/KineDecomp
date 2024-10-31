package retrofit2;

/* loaded from: classes3.dex */
public class HttpException extends RuntimeException {

    /* renamed from: a */
    private final transient D<?> f29447a;
    private final int code;
    private final String message;

    public HttpException(D<?> d2) {
        super(a(d2));
        this.code = d2.b();
        this.message = d2.d();
        this.f29447a = d2;
    }

    private static String a(D<?> d2) {
        H.a(d2, "response == null");
        return "HTTP " + d2.b() + " " + d2.d();
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public D<?> response() {
        return this.f29447a;
    }
}
