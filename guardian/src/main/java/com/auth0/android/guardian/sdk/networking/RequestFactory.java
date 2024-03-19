/*
 * Copyright (c) 2016 Auth0 (http://auth0.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.auth0.android.guardian.sdk.networking;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import java.lang.reflect.Type;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

public class RequestFactory {

    private final GsonConverter converter;
    private final OkHttpClient client;

    public RequestFactory(@NonNull Gson gson, @NonNull OkHttpClient client) {
        this.converter = new GsonConverter(gson);
        this.client = client;
    }

    public <T> Request<T> newRequest(@NonNull String method,
                                     @NonNull HttpUrl url,
                                     @NonNull Type typeOfT) {
        return new Request<>(method, url, converter, client, typeOfT);
    }
}
