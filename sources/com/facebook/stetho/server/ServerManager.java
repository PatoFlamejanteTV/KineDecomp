package com.facebook.stetho.server;

import com.facebook.stetho.common.LogUtil;
import java.io.IOException;

/* loaded from: classes.dex */
public class ServerManager {
    private static final String THREAD_PREFIX = "StethoListener";
    private final LocalSocketServer mServer;
    private volatile boolean mStarted;

    /* renamed from: com.facebook.stetho.server.ServerManager$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends Thread {
        final /* synthetic */ LocalSocketServer val$server;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, LocalSocketServer localSocketServer) {
            super(str);
            localSocketServer = localSocketServer;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                localSocketServer.run();
            } catch (IOException e2) {
                LogUtil.e(e2, "Could not start Stetho server: %s", localSocketServer.getName());
            }
        }
    }

    public ServerManager(LocalSocketServer localSocketServer) {
        this.mServer = localSocketServer;
    }

    private void startServer(LocalSocketServer localSocketServer) {
        new Thread("StethoListener-" + localSocketServer.getName()) { // from class: com.facebook.stetho.server.ServerManager.1
            final /* synthetic */ LocalSocketServer val$server;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(String str, LocalSocketServer localSocketServer2) {
                super(str);
                localSocketServer = localSocketServer2;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    localSocketServer.run();
                } catch (IOException e2) {
                    LogUtil.e(e2, "Could not start Stetho server: %s", localSocketServer.getName());
                }
            }
        }.start();
    }

    public void start() {
        if (!this.mStarted) {
            this.mStarted = true;
            startServer(this.mServer);
            return;
        }
        throw new IllegalStateException("Already started");
    }
}
