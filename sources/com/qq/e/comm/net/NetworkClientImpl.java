package com.qq.e.comm.net;

import com.qq.e.comm.net.NetworkClient;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.util.GDTLogger;
import com.umeng.commonsdk.proguard.c;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

/* loaded from: classes3.dex */
public class NetworkClientImpl implements NetworkClient {

    /* renamed from: a */
    private static final HttpClient f25018a;

    /* renamed from: b */
    private static final NetworkClient f25019b = new NetworkClientImpl();

    /* renamed from: d */
    private PriorityBlockingQueue<Runnable> f25021d = new PriorityBlockingQueue<>(15);

    /* renamed from: c */
    private final ExecutorService f25020c = new ThreadPoolExecutor(5, 10, 180, TimeUnit.SECONDS, this.f25021d);

    /* renamed from: com.qq.e.comm.net.NetworkClientImpl$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f25022a = new int[Request.Method.values().length];

        static {
            try {
                f25022a[Request.Method.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25022a[Request.Method.GET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class NetFutureTask<T> extends FutureTask<T> implements Comparable<NetFutureTask<T>> {

        /* renamed from: a */
        private final NetworkClient.Priority f25023a;

        public NetFutureTask(Callable<T> callable, NetworkClient.Priority priority) {
            super(callable);
            this.f25023a = priority;
        }

        @Override // java.lang.Comparable
        public int compareTo(NetFutureTask<T> netFutureTask) {
            if (netFutureTask == null) {
                return 1;
            }
            return this.f25023a.value() - netFutureTask.f25023a.value();
        }
    }

    /* loaded from: classes3.dex */
    public static class TaskCallable implements Callable<Response> {

        /* renamed from: a */
        private Request f25025a;

        /* renamed from: b */
        private NetworkCallBack f25026b;

        public TaskCallable(Request request) {
            this(request, null);
        }

        public TaskCallable(Request request, NetworkCallBack networkCallBack) {
            this.f25025a = request;
            this.f25026b = networkCallBack;
        }

        private void a(HttpRequestBase httpRequestBase) {
            for (Map.Entry<String, String> entry : this.f25025a.getHeaders().entrySet()) {
                httpRequestBase.setHeader(entry.getKey(), entry.getValue());
            }
            httpRequestBase.setHeader(io.fabric.sdk.android.services.common.a.HEADER_USER_AGENT, "GDTADNetClient-[" + System.getProperty("http.agent") + "]");
            httpRequestBase.addHeader("Accept-Encoding", "gzip");
            HttpParams params = httpRequestBase.getParams();
            if (params == null) {
                params = new BasicHttpParams();
            }
            if (this.f25025a.getConnectionTimeOut() > 0) {
                HttpConnectionParams.setConnectionTimeout(params, this.f25025a.getConnectionTimeOut());
            }
            if (this.f25025a.getSocketTimeOut() > 0) {
                HttpConnectionParams.setSoTimeout(params, this.f25025a.getSocketTimeOut());
            }
            httpRequestBase.setParams(params);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0083, code lost:            if (r7.f25025a.isAutoClose() != false) goto L74;     */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0085, code lost:            r1.close();     */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x009a, code lost:            return r1;     */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0097, code lost:            if (r1 != null) goto L74;     */
        @Override // java.util.concurrent.Callable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.qq.e.comm.net.rr.Response call() throws java.lang.Exception {
            /*
                r7 = this;
                r0 = 0
                org.apache.http.client.HttpClient r1 = com.qq.e.comm.net.NetworkClientImpl.a()     // Catch: java.lang.Exception -> L6e
                int[] r2 = com.qq.e.comm.net.NetworkClientImpl.AnonymousClass1.f25022a     // Catch: java.lang.Exception -> L6e
                com.qq.e.comm.net.rr.Request r3 = r7.f25025a     // Catch: java.lang.Exception -> L6e
                com.qq.e.comm.net.rr.Request$Method r3 = r3.getMethod()     // Catch: java.lang.Exception -> L6e
                int r3 = r3.ordinal()     // Catch: java.lang.Exception -> L6e
                r2 = r2[r3]     // Catch: java.lang.Exception -> L6e
                r3 = 1
                if (r2 == r3) goto L2a
                r3 = 2
                if (r2 == r3) goto L1b
                r2 = r0
                goto L63
            L1b:
                org.apache.http.client.methods.HttpGet r2 = new org.apache.http.client.methods.HttpGet     // Catch: java.lang.Exception -> L6e
                com.qq.e.comm.net.rr.Request r3 = r7.f25025a     // Catch: java.lang.Exception -> L6e
                java.lang.String r3 = r3.getUrlWithParas()     // Catch: java.lang.Exception -> L6e
                r2.<init>(r3)     // Catch: java.lang.Exception -> L6e
                r7.a(r2)     // Catch: java.lang.Exception -> L6e
                goto L63
            L2a:
                com.qq.e.comm.net.rr.Request r2 = r7.f25025a     // Catch: java.lang.Exception -> L6e
                java.lang.String r2 = r2.getUrlWithParas()     // Catch: java.lang.Exception -> L6e
                org.apache.http.client.methods.HttpPost r3 = new org.apache.http.client.methods.HttpPost     // Catch: java.lang.Exception -> L6e
                r3.<init>(r2)     // Catch: java.lang.Exception -> L6e
                r7.a(r3)     // Catch: java.lang.Exception -> L6e
                com.qq.e.comm.net.rr.Request r2 = r7.f25025a     // Catch: java.lang.Exception -> L6e
                byte[] r2 = r2.getPostData()     // Catch: java.lang.Exception -> L6e
                if (r2 == 0) goto L4c
                int r4 = r2.length     // Catch: java.lang.Exception -> L6e
                if (r4 <= 0) goto L4c
                org.apache.http.entity.ByteArrayEntity r4 = new org.apache.http.entity.ByteArrayEntity     // Catch: java.lang.Exception -> L6e
                r4.<init>(r2)     // Catch: java.lang.Exception -> L6e
            L48:
                r3.setEntity(r4)     // Catch: java.lang.Exception -> L6e
                goto L62
            L4c:
                com.qq.e.comm.net.rr.Request r2 = r7.f25025a     // Catch: java.lang.Exception -> L6e
                java.util.ArrayList r2 = r2.getPostDataList()     // Catch: java.lang.Exception -> L6e
                if (r2 == 0) goto L62
                int r4 = r2.size()     // Catch: java.lang.Exception -> L6e
                if (r4 <= 0) goto L62
                org.apache.http.client.entity.UrlEncodedFormEntity r4 = new org.apache.http.client.entity.UrlEncodedFormEntity     // Catch: java.lang.Exception -> L6e
                java.lang.String r5 = "UTF-8"
                r4.<init>(r2, r5)     // Catch: java.lang.Exception -> L6e
                goto L48
            L62:
                r2 = r3
            L63:
                org.apache.http.HttpResponse r1 = r1.execute(r2)     // Catch: java.lang.Exception -> L6e
                com.qq.e.comm.net.rr.Request r3 = r7.f25025a     // Catch: java.lang.Exception -> L6e
                com.qq.e.comm.net.rr.Response r1 = r3.initResponse(r2, r1)     // Catch: java.lang.Exception -> L6e
                goto L72
            L6e:
                r1 = move-exception
                r6 = r1
                r1 = r0
                r0 = r6
            L72:
                if (r0 != 0) goto L89
                com.qq.e.comm.net.NetworkCallBack r0 = r7.f25026b
                if (r0 == 0) goto L7d
                com.qq.e.comm.net.rr.Request r2 = r7.f25025a
                r0.onResponse(r2, r1)
            L7d:
                com.qq.e.comm.net.rr.Request r0 = r7.f25025a
                boolean r0 = r0.isAutoClose()
                if (r0 == 0) goto L9a
            L85:
                r1.close()
                goto L9a
            L89:
                com.qq.e.comm.net.NetworkCallBack r2 = r7.f25026b
                if (r2 == 0) goto L9b
                java.lang.String r2 = "NetworkClientException"
                com.qq.e.comm.util.GDTLogger.w(r2, r0)
                com.qq.e.comm.net.NetworkCallBack r2 = r7.f25026b
                r2.onException(r0)
                if (r1 == 0) goto L9a
                goto L85
            L9a:
                return r1
            L9b:
                goto L9d
            L9c:
                throw r0
            L9d:
                goto L9c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.net.NetworkClientImpl.TaskCallable.call():com.qq.e.comm.net.rr.Response");
        }
    }

    static {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, c.f26227d);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(3));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
        HttpProtocolParams.setUserAgent(basicHttpParams, "GDTADNetClient-[" + System.getProperty("http.agent") + "]");
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        f25018a = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
    }

    private NetworkClientImpl() {
    }

    public static NetworkClient getInstance() {
        return f25019b;
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public Future<Response> submit(Request request) {
        return submit(request, NetworkClient.Priority.Mid);
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public Future<Response> submit(Request request, NetworkClient.Priority priority) {
        NetFutureTask netFutureTask = new NetFutureTask(new TaskCallable(request), priority);
        this.f25020c.execute(netFutureTask);
        GDTLogger.d("QueueSize:" + this.f25021d.size());
        return netFutureTask;
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public void submit(Request request, NetworkCallBack networkCallBack) {
        submit(request, NetworkClient.Priority.Mid, networkCallBack);
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public void submit(Request request, NetworkClient.Priority priority, NetworkCallBack networkCallBack) {
        submit(request, priority, networkCallBack, this.f25020c);
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public void submit(Request request, NetworkClient.Priority priority, NetworkCallBack networkCallBack, Executor executor) {
        if (executor == null) {
            GDTLogger.e("Submit failed for no executor");
            return;
        }
        executor.execute(new NetFutureTask(new TaskCallable(request, networkCallBack), priority));
        GDTLogger.d("QueueSize:" + this.f25021d.size());
    }
}
