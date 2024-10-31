package com.facebook.stetho.websocket;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class WebSocketSession implements SimpleSession {
    private final SimpleEndpoint mEndpoint;
    private final ReadHandler mReadHandler;
    private volatile boolean mSentClose;
    private final WriteHandler mWriteHandler;
    private AtomicBoolean mIsOpen = new AtomicBoolean(false);
    private final ReadCallback mReadCallback = new ReadCallback() { // from class: com.facebook.stetho.websocket.WebSocketSession.1
        AnonymousClass1() {
        }

        private void handleBinaryFrame(byte[] bArr, int i) {
            WebSocketSession.this.mEndpoint.onMessage(WebSocketSession.this, bArr, i);
        }

        private void handleClose(byte[] bArr, int i) {
            int i2;
            String str;
            if (i >= 2) {
                i2 = ((bArr[0] & 255) << 8) | (bArr[1] & 255);
                str = i > 2 ? new String(bArr, 2, i - 2) : null;
            } else {
                i2 = 1006;
                str = "Unparseable close frame";
            }
            if (!WebSocketSession.this.mSentClose) {
                WebSocketSession.this.sendClose(1000, "Received close frame");
            }
            WebSocketSession.this.markAndSignalClosed(i2, str);
        }

        private void handlePing(byte[] bArr, int i) {
            WebSocketSession.this.doWrite(FrameHelper.createPongFrame(bArr, i));
        }

        private void handlePong(byte[] bArr, int i) {
        }

        private void handleTextFrame(byte[] bArr, int i) {
            WebSocketSession.this.mEndpoint.onMessage(WebSocketSession.this, new String(bArr, 0, i));
        }

        @Override // com.facebook.stetho.websocket.ReadCallback
        public void onCompleteFrame(byte b2, byte[] bArr, int i) {
            if (b2 == 1) {
                handleTextFrame(bArr, i);
                return;
            }
            if (b2 != 2) {
                switch (b2) {
                    case 8:
                        handleClose(bArr, i);
                        return;
                    case 9:
                        handlePing(bArr, i);
                        return;
                    case 10:
                        handlePong(bArr, i);
                        return;
                    default:
                        WebSocketSession.this.signalError(new IOException("Unsupported frame opcode=" + ((int) b2)));
                        return;
                }
            }
            handleBinaryFrame(bArr, i);
        }
    };
    private final WriteCallback mErrorForwardingWriteCallback = new WriteCallback() { // from class: com.facebook.stetho.websocket.WebSocketSession.2
        AnonymousClass2() {
        }

        @Override // com.facebook.stetho.websocket.WriteCallback
        public void onFailure(IOException iOException) {
            WebSocketSession.this.signalError(iOException);
        }

        @Override // com.facebook.stetho.websocket.WriteCallback
        public void onSuccess() {
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.facebook.stetho.websocket.WebSocketSession$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements ReadCallback {
        AnonymousClass1() {
        }

        private void handleBinaryFrame(byte[] bArr, int i) {
            WebSocketSession.this.mEndpoint.onMessage(WebSocketSession.this, bArr, i);
        }

        private void handleClose(byte[] bArr, int i) {
            int i2;
            String str;
            if (i >= 2) {
                i2 = ((bArr[0] & 255) << 8) | (bArr[1] & 255);
                str = i > 2 ? new String(bArr, 2, i - 2) : null;
            } else {
                i2 = 1006;
                str = "Unparseable close frame";
            }
            if (!WebSocketSession.this.mSentClose) {
                WebSocketSession.this.sendClose(1000, "Received close frame");
            }
            WebSocketSession.this.markAndSignalClosed(i2, str);
        }

        private void handlePing(byte[] bArr, int i) {
            WebSocketSession.this.doWrite(FrameHelper.createPongFrame(bArr, i));
        }

        private void handlePong(byte[] bArr, int i) {
        }

        private void handleTextFrame(byte[] bArr, int i) {
            WebSocketSession.this.mEndpoint.onMessage(WebSocketSession.this, new String(bArr, 0, i));
        }

        @Override // com.facebook.stetho.websocket.ReadCallback
        public void onCompleteFrame(byte b2, byte[] bArr, int i) {
            if (b2 == 1) {
                handleTextFrame(bArr, i);
                return;
            }
            if (b2 != 2) {
                switch (b2) {
                    case 8:
                        handleClose(bArr, i);
                        return;
                    case 9:
                        handlePing(bArr, i);
                        return;
                    case 10:
                        handlePong(bArr, i);
                        return;
                    default:
                        WebSocketSession.this.signalError(new IOException("Unsupported frame opcode=" + ((int) b2)));
                        return;
                }
            }
            handleBinaryFrame(bArr, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.facebook.stetho.websocket.WebSocketSession$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements WriteCallback {
        AnonymousClass2() {
        }

        @Override // com.facebook.stetho.websocket.WriteCallback
        public void onFailure(IOException iOException) {
            WebSocketSession.this.signalError(iOException);
        }

        @Override // com.facebook.stetho.websocket.WriteCallback
        public void onSuccess() {
        }
    }

    public WebSocketSession(InputStream inputStream, OutputStream outputStream, SimpleEndpoint simpleEndpoint) {
        this.mReadHandler = new ReadHandler(inputStream, simpleEndpoint);
        this.mWriteHandler = new WriteHandler(outputStream);
        this.mEndpoint = simpleEndpoint;
    }

    public void doWrite(Frame frame) {
        if (signalErrorIfNotOpen()) {
            return;
        }
        this.mWriteHandler.write(frame, this.mErrorForwardingWriteCallback);
    }

    public void sendClose(int i, String str) {
        doWrite(FrameHelper.createCloseFrame(i, str));
        markSentClose();
    }

    public void signalError(IOException iOException) {
        this.mEndpoint.onError(this, iOException);
    }

    private boolean signalErrorIfNotOpen() {
        if (isOpen()) {
            return false;
        }
        signalError(new IOException("Session is closed"));
        return true;
    }

    @Override // com.facebook.stetho.websocket.SimpleSession
    public void close(int i, String str) {
        sendClose(i, str);
        markAndSignalClosed(i, str);
    }

    public void handle() throws IOException {
        markAndSignalOpen();
        try {
            this.mReadHandler.readLoop(this.mReadCallback);
        } catch (EOFException unused) {
            markAndSignalClosed(1011, "EOF while reading");
        } catch (IOException e2) {
            markAndSignalClosed(1006, null);
            throw e2;
        }
    }

    @Override // com.facebook.stetho.websocket.SimpleSession
    public boolean isOpen() {
        return this.mIsOpen.get();
    }

    void markAndSignalClosed(int i, String str) {
        if (this.mIsOpen.getAndSet(false)) {
            this.mEndpoint.onClose(this, i, str);
        }
    }

    void markAndSignalOpen() {
        if (this.mIsOpen.getAndSet(true)) {
            return;
        }
        this.mEndpoint.onOpen(this);
    }

    void markSentClose() {
        this.mSentClose = true;
    }

    @Override // com.facebook.stetho.websocket.SimpleSession
    public void sendBinary(byte[] bArr) {
        doWrite(FrameHelper.createBinaryFrame(bArr));
    }

    @Override // com.facebook.stetho.websocket.SimpleSession
    public void sendText(String str) {
        doWrite(FrameHelper.createTextFrame(str));
    }
}
