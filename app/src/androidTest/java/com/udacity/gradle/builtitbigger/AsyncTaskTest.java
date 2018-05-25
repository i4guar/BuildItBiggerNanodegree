package com.udacity.gradle.builtitbigger;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertTrue;

/**
 * Created by felix on 25-May-18 at 18:00.
 */
public class AsyncTaskTest {
        String taskResult;

    /**
     * Tests if response from EndpointsAsyncTask is not null.
     * @throws InterruptedException if countdown latch fails.
     */
    @Test
        public void testAsyncTaskResponse() throws InterruptedException {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
            endpointsAsyncTask.setListener( new EndpointsAsyncTask.OnFinishedListener() {

                @Override
                public void onFinished(String result) {
                    taskResult = result;
                    countDownLatch.countDown();
                }
            });
            endpointsAsyncTask.execute();
            countDownLatch.await();
            assertTrue(taskResult != null && !taskResult.isEmpty());
        }
}
