package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import io.grpc.C2403b;
import io.grpc.C2530z;
import io.grpc.S;
import io.grpc.internal.Kc;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DnsNameResolver.java */
/* loaded from: classes3.dex */
public final class Ga extends io.grpc.S {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f27309a = Logger.getLogger(Ga.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f27310b = f();

    /* renamed from: c, reason: collision with root package name */
    private static final Set<String> f27311c = Collections.unmodifiableSet(new HashSet(Arrays.asList("clientLanguage", "percentage", "clientHostname", "serviceConfig")));

    /* renamed from: d, reason: collision with root package name */
    private static final String f27312d = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "false");

    /* renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    static boolean f27313e = Boolean.parseBoolean(f27312d);

    /* renamed from: f, reason: collision with root package name */
    private static String f27314f;

    /* renamed from: g, reason: collision with root package name */
    @VisibleForTesting
    final Zb f27315g;
    private final String j;
    private final String k;
    private final int l;
    private final Kc.b<ExecutorService> m;
    private boolean n;
    private ExecutorService o;
    private boolean p;
    private S.b q;

    /* renamed from: h, reason: collision with root package name */
    private final Random f27316h = new Random();
    private b i = h();
    private final Runnable r = new Fa(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DnsNameResolver.java */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static final class a extends b {

        /* renamed from: a, reason: collision with root package name */
        private final b f27317a;

        /* renamed from: b, reason: collision with root package name */
        private final b f27318b;

        a(b bVar, b bVar2) {
            this.f27317a = bVar;
            this.f27318b = bVar2;
        }

        @Override // io.grpc.internal.Ga.b
        e a(String str) throws Exception {
            List<InetAddress> list = this.f27317a.a(str).f27320a;
            List<String> emptyList = Collections.emptyList();
            List<C2530z> emptyList2 = Collections.emptyList();
            try {
                e a2 = this.f27318b.a(str);
                emptyList = a2.f27321b;
                emptyList2 = a2.f27322c;
            } catch (Throwable th) {
                Ga.f27309a.log(Level.SEVERE, "Failed to resolve TXT results", th);
            }
            return new e(list, emptyList, emptyList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DnsNameResolver.java */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static abstract class b {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract e a(String str) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DnsNameResolver.java */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static final class c extends b {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // io.grpc.internal.Ga.b
        public e a(String str) throws Exception {
            return new e(Arrays.asList(InetAddress.getAllByName(str)), Collections.emptyList(), Collections.emptyList());
        }
    }

    /* compiled from: DnsNameResolver.java */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    static final class e {

        /* renamed from: a, reason: collision with root package name */
        final List<InetAddress> f27320a;

        /* renamed from: b, reason: collision with root package name */
        final List<String> f27321b;

        /* renamed from: c, reason: collision with root package name */
        final List<C2530z> f27322c;

        e(List<InetAddress> list, List<String> list2, List<C2530z> list3) {
            Preconditions.a(list, "addresses");
            this.f27320a = Collections.unmodifiableList(list);
            Preconditions.a(list2, "txtRecords");
            this.f27321b = Collections.unmodifiableList(list2);
            Preconditions.a(list3, "balancerAddresses");
            this.f27322c = Collections.unmodifiableList(list3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ga(@Nullable String str, String str2, C2403b c2403b, Kc.b<ExecutorService> bVar, Zb zb) {
        this.m = bVar;
        URI create = URI.create("//" + str2);
        String authority = create.getAuthority();
        Preconditions.a(authority, "nameUri (%s) doesn't have an authority", create);
        this.j = authority;
        String host = create.getHost();
        Preconditions.a(host, "host");
        this.k = host;
        if (create.getPort() == -1) {
            Integer num = (Integer) c2403b.a(S.a.f27127a);
            if (num != null) {
                this.l = num.intValue();
            } else {
                throw new IllegalArgumentException("name '" + str2 + "' doesn't contain a port, and default port is not set in params");
            }
        } else {
            this.l = create.getPort();
        }
        this.f27315g = zb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g() {
        if (f27314f == null) {
            try {
                f27314f = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e2) {
                throw new RuntimeException(e2);
            }
        }
        return f27314f;
    }

    private b h() {
        c cVar = new c();
        return (f27310b && f27313e) ? new a(cVar, new d()) : cVar;
    }

    private void i() {
        if (this.p || this.n) {
            return;
        }
        this.o.execute(this.r);
    }

    @VisibleForTesting
    static boolean f() {
        if (GrpcUtil.f27339c) {
            return false;
        }
        try {
            Class.forName("javax.naming.directory.InitialDirContext");
            Class.forName("com.sun.jndi.dns.DnsContextFactory");
            return true;
        } catch (ClassNotFoundException e2) {
            f27309a.log(Level.FINE, "Unable to find JNDI DNS resolver, skipping", (Throwable) e2);
            return false;
        }
    }

    @Override // io.grpc.S
    public final synchronized void b() {
        Preconditions.b(this.q != null, "not started");
        i();
    }

    @Override // io.grpc.S
    public final synchronized void c() {
        if (this.n) {
            return;
        }
        this.n = true;
        if (this.o != null) {
            this.o = (ExecutorService) Kc.a(this.m, this.o);
        }
    }

    @Override // io.grpc.S
    public final String a() {
        return this.j;
    }

    @Override // io.grpc.S
    public final synchronized void a(S.b bVar) {
        Preconditions.b(this.q == null, "already started");
        this.o = (ExecutorService) Kc.a(this.m);
        Preconditions.a(bVar, "listener");
        this.q = bVar;
        i();
    }

    @Nullable
    private static final List<String> b(Map<String, Object> map) {
        if (!map.containsKey("clientHostname")) {
            return null;
        }
        List c2 = Hc.c(map, "clientHostname");
        Hc.a((List<Object>) c2);
        return c2;
    }

    @Nullable
    private static final Double c(Map<String, Object> map) {
        if (map.containsKey("percentage")) {
            return Hc.b(map, "percentage");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static List<Map<String, Object>> a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str.startsWith("_grpc_config=")) {
                try {
                    Object a2 = C2473pb.a(str.substring(13));
                    if (a2 instanceof List) {
                        List list2 = (List) a2;
                        Iterator it = list2.iterator();
                        while (it.hasNext()) {
                            if (!(it.next() instanceof Map)) {
                                throw new IOException("wrong element type " + a2);
                            }
                        }
                        arrayList.addAll(list2);
                    } else {
                        throw new IOException("wrong type " + a2);
                    }
                } catch (IOException e2) {
                    f27309a.log(Level.WARNING, "Bad service config: " + str, (Throwable) e2);
                }
            } else {
                f27309a.log(Level.FINE, "Ignoring non service config {0}", new Object[]{str});
            }
        }
        return arrayList;
    }

    @Nullable
    private static final List<String> a(Map<String, Object> map) {
        if (!map.containsKey("clientLanguage")) {
            return null;
        }
        List c2 = Hc.c(map, "clientLanguage");
        Hc.a((List<Object>) c2);
        return c2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    @Nullable
    public static Map<String, Object> a(Map<String, Object> map, Random random, String str) {
        boolean z;
        boolean z2;
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, Object> next = it.next();
            Verify.a(f27311c.contains(next.getKey()), "Bad key: %s", next);
        }
        List<String> a2 = a(map);
        if (a2 != null && !a2.isEmpty()) {
            Iterator<String> it2 = a2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z2 = false;
                    break;
                }
                if ("java".equalsIgnoreCase(it2.next())) {
                    z2 = true;
                    break;
                }
            }
            if (!z2) {
                return null;
            }
        }
        Double c2 = c(map);
        if (c2 != null) {
            int intValue = c2.intValue();
            Verify.a(intValue >= 0 && intValue <= 100, "Bad percentage: %s", c2);
            if (random.nextInt(100) >= intValue) {
                return null;
            }
        }
        List<String> b2 = b(map);
        if (b2 != null && !b2.isEmpty()) {
            Iterator<String> it3 = b2.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                if (it3.next().equals(str)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return null;
            }
        }
        return Hc.d(map, "serviceConfig");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DnsNameResolver.java */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static final class d extends b {

        /* renamed from: a, reason: collision with root package name */
        private static final Pattern f27319a = Pattern.compile("\\s+");

        d() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // io.grpc.internal.Ga.b
        public e a(String str) throws NamingException {
            List list;
            List<String> emptyList = Collections.emptyList();
            String str2 = "_grpc_config." + str;
            char c2 = 0;
            if (Ga.f27309a.isLoggable(Level.FINER)) {
                Ga.f27309a.log(Level.FINER, "About to query TXT records for {0}", new Object[]{str2});
            }
            try {
                emptyList = a("TXT", "dns:///" + str2);
            } catch (NamingException e2) {
                if (Ga.f27309a.isLoggable(Level.FINE)) {
                    Ga.f27309a.log(Level.FINE, "Unable to look up " + str2, e2);
                }
            }
            String str3 = "_grpclb._tcp." + str;
            if (Ga.f27309a.isLoggable(Level.FINER)) {
                Ga.f27309a.log(Level.FINER, "About to query SRV records for {0}", new Object[]{str3});
            }
            List emptyList2 = Collections.emptyList();
            try {
                List<String> a2 = a("SRV", "dns:///" + str3);
                list = new ArrayList(a2.size());
                try {
                    for (String str4 : a2) {
                        try {
                            try {
                                String[] split = f27319a.split(str4);
                                boolean z = split.length == 4;
                                Object[] objArr = new Object[1];
                                objArr[c2] = str4;
                                Verify.a(z, "Bad SRV Record: %s, ", objArr);
                                String str5 = split[3];
                                int parseInt = Integer.parseInt(split[2]);
                                InetAddress[] allByName = InetAddress.getAllByName(str5);
                                ArrayList arrayList = new ArrayList(allByName.length);
                                for (InetAddress inetAddress : allByName) {
                                    arrayList.add(new InetSocketAddress(inetAddress, parseInt));
                                }
                                C2403b.a b2 = C2403b.b();
                                b2.a(Sa.f27503b, str5);
                                list.add(new C2530z((List<SocketAddress>) Collections.unmodifiableList(arrayList), b2.a()));
                            } catch (UnknownHostException e3) {
                                Ga.f27309a.log(Level.WARNING, "Can't find address for SRV record" + str4, (Throwable) e3);
                            }
                        } catch (RuntimeException e4) {
                            Ga.f27309a.log(Level.WARNING, "Failed to construct SRV record" + str4, (Throwable) e4);
                        }
                        c2 = 0;
                    }
                } catch (NamingException e5) {
                    e = e5;
                    if (Ga.f27309a.isLoggable(Level.FINE)) {
                        Ga.f27309a.log(Level.FINE, "Unable to look up " + str2, (Throwable) e);
                    }
                    return new e(Collections.emptyList(), emptyList, Collections.unmodifiableList(list));
                }
            } catch (NamingException e6) {
                e = e6;
                list = emptyList2;
            }
            return new e(Collections.emptyList(), emptyList, Collections.unmodifiableList(list));
        }

        private List<String> a(String str, String str2) throws NamingException {
            Attributes attributes = new InitialDirContext().getAttributes(str2, new String[]{str});
            ArrayList arrayList = new ArrayList();
            NamingEnumeration all = attributes.getAll();
            while (all.hasMore()) {
                try {
                    NamingEnumeration all2 = ((Attribute) all.next()).getAll();
                    while (all2.hasMore()) {
                        try {
                            arrayList.add(Ga.a(String.valueOf(all2.next())));
                        } finally {
                        }
                    }
                    all2.close();
                } finally {
                    all.close();
                }
            }
            return arrayList;
        }
    }

    @VisibleForTesting
    static String a(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        int i = 0;
        boolean z = false;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (z) {
                if (charAt == '\"') {
                    z = false;
                } else {
                    if (charAt == '\\') {
                        i++;
                        charAt = str.charAt(i);
                    }
                    sb.append(charAt);
                }
            } else if (charAt != ' ') {
                if (charAt == '\"') {
                    z = true;
                }
                sb.append(charAt);
            }
            i++;
        }
        return sb.toString();
    }
}
