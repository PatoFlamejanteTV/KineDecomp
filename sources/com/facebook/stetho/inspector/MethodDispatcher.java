package com.facebook.stetho.inspector;

import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.jsonrpc.protocol.EmptyResult;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.ObjectMapper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import org.json.JSONException;
import org.json.JSONObject;

@ThreadSafe
/* loaded from: classes.dex */
public class MethodDispatcher {
    private final Iterable<ChromeDevtoolsDomain> mDomainHandlers;
    private Map<String, MethodDispatchHelper> mMethods;
    private final ObjectMapper mObjectMapper;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class MethodDispatchHelper {
        private final ChromeDevtoolsDomain mInstance;
        private final Method mMethod;
        private final ObjectMapper mObjectMapper;

        public MethodDispatchHelper(ObjectMapper objectMapper, ChromeDevtoolsDomain chromeDevtoolsDomain, Method method) {
            this.mObjectMapper = objectMapper;
            this.mInstance = chromeDevtoolsDomain;
            this.mMethod = method;
        }

        public JSONObject invoke(JsonRpcPeer jsonRpcPeer, @Nullable JSONObject jSONObject) throws InvocationTargetException, IllegalAccessException, JSONException, JsonRpcException {
            Object invoke = this.mMethod.invoke(this.mInstance, jsonRpcPeer, jSONObject);
            if (invoke != null && !(invoke instanceof EmptyResult)) {
                return (JSONObject) this.mObjectMapper.convertValue((JsonRpcResult) invoke, JSONObject.class);
            }
            return new JSONObject();
        }
    }

    public MethodDispatcher(ObjectMapper objectMapper, Iterable<ChromeDevtoolsDomain> iterable) {
        this.mObjectMapper = objectMapper;
        this.mDomainHandlers = iterable;
    }

    private static Map<String, MethodDispatchHelper> buildDispatchTable(ObjectMapper objectMapper, Iterable<ChromeDevtoolsDomain> iterable) {
        Util.throwIfNull(objectMapper);
        HashMap hashMap = new HashMap();
        Util.throwIfNull(iterable);
        for (ChromeDevtoolsDomain chromeDevtoolsDomain : iterable) {
            Class<?> cls = chromeDevtoolsDomain.getClass();
            String simpleName = cls.getSimpleName();
            for (Method method : cls.getDeclaredMethods()) {
                if (isDevtoolsMethod(method)) {
                    hashMap.put(simpleName + "." + method.getName(), new MethodDispatchHelper(objectMapper, chromeDevtoolsDomain, method));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    private synchronized MethodDispatchHelper findMethodDispatcher(String str) {
        if (this.mMethods == null) {
            this.mMethods = buildDispatchTable(this.mObjectMapper, this.mDomainHandlers);
        }
        return this.mMethods.get(str);
    }

    private static boolean isDevtoolsMethod(Method method) throws IllegalArgumentException {
        if (!method.isAnnotationPresent(ChromeDevtoolsMethod.class)) {
            return false;
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        String str = method.getDeclaringClass().getSimpleName() + "." + method.getName();
        Util.throwIfNot(parameterTypes.length == 2, "%s: expected 2 args, got %s", str, Integer.valueOf(parameterTypes.length));
        Util.throwIfNot(parameterTypes[0].equals(JsonRpcPeer.class), "%s: expected 1st arg of JsonRpcPeer, got %s", str, parameterTypes[0].getName());
        Util.throwIfNot(parameterTypes[1].equals(JSONObject.class), "%s: expected 2nd arg of JSONObject, got %s", str, parameterTypes[1].getName());
        Class<?> returnType = method.getReturnType();
        if (!returnType.equals(Void.TYPE)) {
            Util.throwIfNot(JsonRpcResult.class.isAssignableFrom(returnType), "%s: expected JsonRpcResult return type, got %s", str, returnType.getName());
        }
        return true;
    }

    public JSONObject dispatch(JsonRpcPeer jsonRpcPeer, String str, @Nullable JSONObject jSONObject) throws JsonRpcException {
        MethodDispatchHelper findMethodDispatcher = findMethodDispatcher(str);
        if (findMethodDispatcher != null) {
            try {
                return findMethodDispatcher.invoke(jsonRpcPeer, jSONObject);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                Throwable cause = e3.getCause();
                ExceptionUtil.propagateIfInstanceOf(cause, JsonRpcException.class);
                ExceptionUtil.propagate(cause);
                throw null;
            } catch (JSONException e4) {
                throw new JsonRpcException(new JsonRpcError(JsonRpcError.ErrorCode.INTERNAL_ERROR, e4.toString(), null));
            }
        }
        throw new JsonRpcException(new JsonRpcError(JsonRpcError.ErrorCode.METHOD_NOT_FOUND, "Not implemented: " + str, null));
    }
}
