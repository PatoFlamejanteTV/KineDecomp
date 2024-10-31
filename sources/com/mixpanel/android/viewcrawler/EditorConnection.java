package com.mixpanel.android.viewcrawler;

import android.util.Log;
import com.mixpanel.android.java_websocket.exceptions.NotSendableException;
import com.mixpanel.android.java_websocket.exceptions.WebsocketNotConnectedException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class EditorConnection {
    private static final ByteBuffer d = ByteBuffer.allocate(0);

    /* renamed from: a */
    private final a f3079a;
    private final b b;
    private final URI c;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void a(JSONObject jSONObject);

        void b();

        void b(JSONObject jSONObject);

        void c(JSONObject jSONObject);

        void d(JSONObject jSONObject);

        void e(JSONObject jSONObject);
    }

    /* loaded from: classes.dex */
    public class EditorConnectionException extends IOException {
        private static final long serialVersionUID = -1884953175346045636L;

        public EditorConnectionException(Throwable th) {
            super(th.getMessage());
        }
    }

    public EditorConnection(URI uri, a aVar, Socket socket) throws EditorConnectionException {
        this.f3079a = aVar;
        this.c = uri;
        try {
            this.b = new b(uri, 5000, socket);
            this.b.c();
        } catch (InterruptedException e) {
            throw new EditorConnectionException(e);
        }
    }

    public boolean a() {
        return (this.b.e() || this.b.f() || this.b.d()) ? false : true;
    }

    public BufferedOutputStream b() {
        return new BufferedOutputStream(new c());
    }

    /* loaded from: classes.dex */
    public class b extends com.mixpanel.android.java_websocket.a.a {
        public b(URI uri, int i, Socket socket) throws InterruptedException {
            super(uri, new com.mixpanel.android.java_websocket.drafts.a(), null, i);
            a(socket);
        }

        @Override // com.mixpanel.android.java_websocket.a.a
        public void a(com.mixpanel.android.java_websocket.b.h hVar) {
            if (com.mixpanel.android.mpmetrics.m.f3036a) {
                Log.v("MixpanelAPI.EditorCnctn", "Websocket connected");
            }
        }

        @Override // com.mixpanel.android.java_websocket.a.a
        public void a(String str) {
            if (com.mixpanel.android.mpmetrics.m.f3036a) {
                Log.v("MixpanelAPI.EditorCnctn", "Received message from editor:\n" + str);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("type");
                if (string.equals("device_info_request")) {
                    EditorConnection.this.f3079a.a();
                    return;
                }
                if (string.equals("snapshot_request")) {
                    EditorConnection.this.f3079a.a(jSONObject);
                    return;
                }
                if (string.equals("change_request")) {
                    EditorConnection.this.f3079a.b(jSONObject);
                    return;
                }
                if (string.equals("event_binding_request")) {
                    EditorConnection.this.f3079a.d(jSONObject);
                } else if (string.equals("clear_request")) {
                    EditorConnection.this.f3079a.c(jSONObject);
                } else if (string.equals("tweak_request")) {
                    EditorConnection.this.f3079a.e(jSONObject);
                }
            } catch (JSONException e) {
                Log.e("MixpanelAPI.EditorCnctn", "Bad JSON received:" + str, e);
            }
        }

        @Override // com.mixpanel.android.java_websocket.a.a
        public void b(int i, String str, boolean z) {
            if (com.mixpanel.android.mpmetrics.m.f3036a) {
                Log.v("MixpanelAPI.EditorCnctn", "WebSocket closed. Code: " + i + ", reason: " + str + "\nURI: " + EditorConnection.this.c);
            }
            EditorConnection.this.f3079a.b();
        }

        @Override // com.mixpanel.android.java_websocket.a.a
        public void a(Exception exc) {
            if (exc != null && exc.getMessage() != null) {
                Log.e("MixpanelAPI.EditorCnctn", "Websocket Error: " + exc.getMessage());
            } else {
                Log.e("MixpanelAPI.EditorCnctn", "Unknown websocket error occurred");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends OutputStream {
        private c() {
        }

        /* synthetic */ c(EditorConnection editorConnection, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws EditorConnectionException {
            write(new byte[]{(byte) i}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws EditorConnectionException {
            write(bArr, 0, bArr.length);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws EditorConnectionException {
            try {
                EditorConnection.this.b.a(Framedata.Opcode.TEXT, ByteBuffer.wrap(bArr, i, i2), false);
            } catch (NotSendableException e) {
                throw new EditorConnectionException(e);
            } catch (WebsocketNotConnectedException e2) {
                throw new EditorConnectionException(e2);
            }
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws EditorConnectionException {
            try {
                EditorConnection.this.b.a(Framedata.Opcode.TEXT, EditorConnection.d, true);
            } catch (NotSendableException e) {
                throw new EditorConnectionException(e);
            } catch (WebsocketNotConnectedException e2) {
                throw new EditorConnectionException(e2);
            }
        }
    }
}
