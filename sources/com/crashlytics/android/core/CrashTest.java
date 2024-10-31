package com.crashlytics.android.core;

import android.os.AsyncTask;
import io.fabric.sdk.android.f;

/* loaded from: classes.dex */
public class CrashTest {

    /* renamed from: com.crashlytics.android.core.CrashTest$1 */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ long val$delayMs;

        AnonymousClass1(long j) {
            j = j;
        }

        @Override // android.os.AsyncTask
        public Void doInBackground(Void... voidArr) {
            try {
                Thread.sleep(j);
            } catch (InterruptedException unused) {
            }
            CrashTest.this.throwRuntimeException("Background thread crash");
            return null;
        }
    }

    private void privateMethodThatThrowsException(String str) {
        throw new RuntimeException(str);
    }

    public void crashAsyncTask(long j) {
        new AsyncTask<Void, Void, Void>() { // from class: com.crashlytics.android.core.CrashTest.1
            final /* synthetic */ long val$delayMs;

            AnonymousClass1(long j2) {
                j = j2;
            }

            @Override // android.os.AsyncTask
            public Void doInBackground(Void... voidArr) {
                try {
                    Thread.sleep(j);
                } catch (InterruptedException unused) {
                }
                CrashTest.this.throwRuntimeException("Background thread crash");
                return null;
            }
        }.execute(null);
    }

    public void indexOutOfBounds() {
        int i = new int[2][10];
        f.f().d(CrashlyticsCore.TAG, "Out of bounds value: " + i);
    }

    public int stackOverflow() {
        return stackOverflow() + ((int) Math.random());
    }

    public void throwFiveChainedExceptions() {
        try {
            privateMethodThatThrowsException("1");
            throw null;
        } catch (Exception e2) {
            try {
                throw new RuntimeException("2", e2);
            } catch (Exception e3) {
                try {
                    throw new RuntimeException("3", e3);
                } catch (Exception e4) {
                    try {
                        throw new RuntimeException("4", e4);
                    } catch (Exception e5) {
                        throw new RuntimeException("5", e5);
                    }
                }
            }
        }
    }

    public void throwRuntimeException(String str) {
        throw new RuntimeException(str);
    }
}
