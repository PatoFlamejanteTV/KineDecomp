package com.facebook.stetho.server;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.BindException;
import java.net.SocketException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nonnull;

/* loaded from: classes.dex */
public class LocalSocketServer {
    private static final int MAX_BIND_RETRIES = 2;
    private static final int TIME_BETWEEN_BIND_RETRIES_MS = 1000;
    private static final String WORKER_THREAD_NAME_PREFIX = "StethoWorker";
    private final String mAddress;
    private final String mFriendlyName;
    private Thread mListenerThread;
    private LocalServerSocket mServerSocket;
    private final SocketHandler mSocketHandler;
    private boolean mStopped;
    private final AtomicInteger mThreadId = new AtomicInteger();

    /* loaded from: classes.dex */
    public static class WorkerThread extends Thread {
        private final LocalSocket mSocket;
        private final SocketHandler mSocketHandler;

        public WorkerThread(LocalSocket localSocket, SocketHandler socketHandler) {
            this.mSocket = localSocket;
            this.mSocketHandler = socketHandler;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                try {
                    this.mSocketHandler.onAccepted(this.mSocket);
                } catch (IOException e2) {
                    LogUtil.w("I/O error: %s", e2);
                }
                try {
                    this.mSocket.close();
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                try {
                    this.mSocket.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
        }
    }

    public LocalSocketServer(String str, String str2, SocketHandler socketHandler) {
        Util.throwIfNull(str);
        this.mFriendlyName = str;
        Util.throwIfNull(str2);
        this.mAddress = str2;
        this.mSocketHandler = socketHandler;
    }

    @Nonnull
    private static LocalServerSocket bindToSocket(String str) throws IOException {
        int i = 2;
        BindException bindException = null;
        while (true) {
            try {
                if (LogUtil.isLoggable(3)) {
                    LogUtil.d("Trying to bind to @" + str);
                }
                return new LocalServerSocket(str);
            } catch (BindException e2) {
                LogUtil.w(e2, "Binding error, sleep 1000 ms...");
                if (bindException == null) {
                    bindException = e2;
                }
                Util.sleepUninterruptibly(1000L);
                int i2 = i - 1;
                if (i <= 0) {
                    throw bindException;
                }
                i = i2;
            }
        }
    }

    private void listenOnAddress(String str) throws IOException {
        this.mServerSocket = bindToSocket(str);
        LogUtil.i("Listening on @" + str);
        while (!Thread.interrupted()) {
            try {
                WorkerThread workerThread = new WorkerThread(this.mServerSocket.accept(), this.mSocketHandler);
                workerThread.setName("StethoWorker-" + this.mFriendlyName + "-" + this.mThreadId.incrementAndGet());
                workerThread.setDaemon(true);
                workerThread.start();
            } catch (InterruptedIOException unused) {
            } catch (SocketException e2) {
                if (Thread.interrupted()) {
                    break;
                } else {
                    LogUtil.w(e2, "I/O error");
                }
            } catch (IOException e3) {
                LogUtil.w(e3, "I/O error initialising connection thread");
            }
        }
        LogUtil.i("Server shutdown on @" + str);
    }

    public String getName() {
        return this.mFriendlyName;
    }

    public void run() throws IOException {
        synchronized (this) {
            if (this.mStopped) {
                return;
            }
            this.mListenerThread = Thread.currentThread();
            listenOnAddress(this.mAddress);
        }
    }

    public void stop() {
        synchronized (this) {
            this.mStopped = true;
            if (this.mListenerThread == null) {
                return;
            }
            this.mListenerThread.interrupt();
            try {
                if (this.mServerSocket != null) {
                    this.mServerSocket.close();
                }
            } catch (IOException unused) {
            }
        }
    }
}