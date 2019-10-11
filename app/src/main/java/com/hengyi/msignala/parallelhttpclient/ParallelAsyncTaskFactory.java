package com.hengyi.msignala.parallelhttpclient;


import com.turbomanage.httpclient.AsyncCallback;
import com.turbomanage.httpclient.AsyncHttpClient;
import com.turbomanage.httpclient.AsyncRequestExecutor;
import com.turbomanage.httpclient.AsyncRequestExecutorFactory;

/**
 * AsyncTask工厂，用于并发执行http请求
 *
 */
public class ParallelAsyncTaskFactory implements AsyncRequestExecutorFactory {


    @Override
    public AsyncRequestExecutor getAsyncRequestExecutor(AsyncHttpClient client,
            AsyncCallback callback) {
        return new DoParallelHttpRequestTask(client, callback);
    }

}
