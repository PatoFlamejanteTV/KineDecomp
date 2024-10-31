package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* compiled from: Dns.java */
/* loaded from: classes3.dex */
public interface t {

    /* renamed from: a */
    public static final t f29210a = new s();

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
