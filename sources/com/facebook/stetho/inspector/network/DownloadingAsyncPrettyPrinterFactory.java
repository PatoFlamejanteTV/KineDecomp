package com.facebook.stetho.inspector.network;

import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class DownloadingAsyncPrettyPrinterFactory implements AsyncPrettyPrinterFactory {

    /* renamed from: com.facebook.stetho.inspector.network.DownloadingAsyncPrettyPrinterFactory$1 */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements AsyncPrettyPrinter {
        final /* synthetic */ Future val$response;
        final /* synthetic */ MatchResult val$result;

        AnonymousClass1(Future future, MatchResult matchResult) {
            submit = future;
            matchAndParseHeader = matchResult;
        }

        @Override // com.facebook.stetho.inspector.network.AsyncPrettyPrinter
        public PrettyPrinterDisplayType getPrettifiedType() {
            return matchAndParseHeader.getDisplayType();
        }

        @Override // com.facebook.stetho.inspector.network.AsyncPrettyPrinter
        public void printTo(PrintWriter printWriter, InputStream inputStream) throws IOException {
            try {
                try {
                    try {
                        DownloadingAsyncPrettyPrinterFactory.this.doPrint(printWriter, inputStream, (String) submit.get());
                    } catch (ExecutionException e2) {
                        if (IOException.class.isInstance(e2.getCause())) {
                            DownloadingAsyncPrettyPrinterFactory.doErrorPrint(printWriter, inputStream, "Cannot successfully download schema: " + e2.getMessage());
                            return;
                        }
                        throw e2;
                    }
                } catch (ExecutionException e3) {
                    ExceptionUtil.propagate(e3.getCause());
                    throw null;
                }
            } catch (InterruptedException e4) {
                DownloadingAsyncPrettyPrinterFactory.doErrorPrint(printWriter, inputStream, "Encountered spurious interrupt while downloading schema for pretty printing: " + e4.getMessage());
            }
        }
    }

    /* renamed from: com.facebook.stetho.inspector.network.DownloadingAsyncPrettyPrinterFactory$2 */
    /* loaded from: classes.dex */
    public static class AnonymousClass2 implements AsyncPrettyPrinter {
        final /* synthetic */ String val$headerName;
        final /* synthetic */ String val$headerValue;

        AnonymousClass2(String str, String str2) {
            str = str;
            str2 = str2;
        }

        @Override // com.facebook.stetho.inspector.network.AsyncPrettyPrinter
        public PrettyPrinterDisplayType getPrettifiedType() {
            return PrettyPrinterDisplayType.TEXT;
        }

        @Override // com.facebook.stetho.inspector.network.AsyncPrettyPrinter
        public void printTo(PrintWriter printWriter, InputStream inputStream) throws IOException {
            DownloadingAsyncPrettyPrinterFactory.doErrorPrint(printWriter, inputStream, "[Failed to parse header: " + str + " : " + str2 + " ]");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class MatchResult {
        private final PrettyPrinterDisplayType mDisplayType;
        private final String mSchemaUri;

        public MatchResult(String str, PrettyPrinterDisplayType prettyPrinterDisplayType) {
            this.mSchemaUri = str;
            this.mDisplayType = prettyPrinterDisplayType;
        }

        public PrettyPrinterDisplayType getDisplayType() {
            return this.mDisplayType;
        }

        public String getSchemaUri() {
            return this.mSchemaUri;
        }
    }

    /* loaded from: classes.dex */
    private static class Request implements Callable<String> {
        private URL url;

        public Request(URL url) {
            this.url = url;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) this.url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    return Util.readAsUTF8(inputStream);
                } finally {
                    inputStream.close();
                }
            }
            throw new IOException("Got status code: " + responseCode + " while downloading schema with url: " + this.url.toString());
        }
    }

    public static void doErrorPrint(PrintWriter printWriter, InputStream inputStream, String str) throws IOException {
        printWriter.print(str + "\n" + Util.readAsUTF8(inputStream));
    }

    private static AsyncPrettyPrinter getErrorAsyncPrettyPrinter(String str, String str2) {
        return new AsyncPrettyPrinter() { // from class: com.facebook.stetho.inspector.network.DownloadingAsyncPrettyPrinterFactory.2
            final /* synthetic */ String val$headerName;
            final /* synthetic */ String val$headerValue;

            AnonymousClass2(String str3, String str22) {
                str = str3;
                str2 = str22;
            }

            @Override // com.facebook.stetho.inspector.network.AsyncPrettyPrinter
            public PrettyPrinterDisplayType getPrettifiedType() {
                return PrettyPrinterDisplayType.TEXT;
            }

            @Override // com.facebook.stetho.inspector.network.AsyncPrettyPrinter
            public void printTo(PrintWriter printWriter, InputStream inputStream) throws IOException {
                DownloadingAsyncPrettyPrinterFactory.doErrorPrint(printWriter, inputStream, "[Failed to parse header: " + str + " : " + str2 + " ]");
            }
        };
    }

    @Nullable
    private static URL parseURL(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    protected abstract void doPrint(PrintWriter printWriter, InputStream inputStream, String str) throws IOException;

    @Override // com.facebook.stetho.inspector.network.AsyncPrettyPrinterFactory
    public AsyncPrettyPrinter getInstance(String str, String str2) {
        MatchResult matchAndParseHeader = matchAndParseHeader(str, str2);
        if (matchAndParseHeader == null) {
            return null;
        }
        URL parseURL = parseURL(matchAndParseHeader.getSchemaUri());
        if (parseURL == null) {
            return getErrorAsyncPrettyPrinter(str, str2);
        }
        ExecutorService executorService = AsyncPrettyPrinterExecutorHolder.getExecutorService();
        if (executorService == null) {
            return null;
        }
        return new AsyncPrettyPrinter() { // from class: com.facebook.stetho.inspector.network.DownloadingAsyncPrettyPrinterFactory.1
            final /* synthetic */ Future val$response;
            final /* synthetic */ MatchResult val$result;

            AnonymousClass1(Future future, MatchResult matchAndParseHeader2) {
                submit = future;
                matchAndParseHeader = matchAndParseHeader2;
            }

            @Override // com.facebook.stetho.inspector.network.AsyncPrettyPrinter
            public PrettyPrinterDisplayType getPrettifiedType() {
                return matchAndParseHeader.getDisplayType();
            }

            @Override // com.facebook.stetho.inspector.network.AsyncPrettyPrinter
            public void printTo(PrintWriter printWriter, InputStream inputStream) throws IOException {
                try {
                    try {
                        try {
                            DownloadingAsyncPrettyPrinterFactory.this.doPrint(printWriter, inputStream, (String) submit.get());
                        } catch (ExecutionException e2) {
                            if (IOException.class.isInstance(e2.getCause())) {
                                DownloadingAsyncPrettyPrinterFactory.doErrorPrint(printWriter, inputStream, "Cannot successfully download schema: " + e2.getMessage());
                                return;
                            }
                            throw e2;
                        }
                    } catch (ExecutionException e3) {
                        ExceptionUtil.propagate(e3.getCause());
                        throw null;
                    }
                } catch (InterruptedException e4) {
                    DownloadingAsyncPrettyPrinterFactory.doErrorPrint(printWriter, inputStream, "Encountered spurious interrupt while downloading schema for pretty printing: " + e4.getMessage());
                }
            }
        };
    }

    @Nullable
    protected abstract MatchResult matchAndParseHeader(String str, String str2);
}
