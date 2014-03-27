package ex14_10;

import java.util.LinkedList;
import java.util.Queue;

import junit.framework.AssertionFailedError;

/*
 * Copyright (C) 2012, 2013 RICOH Co., Ltd. All rights reserved.
 */

/**
 * Simple Thread Pool class.
 *
 * This class can be used to dispatch an Runnable object to
 * be exectued by a thread.
 *
 * [Instruction]
 *  Implement one constructor and three methods.
 *  Don't forget to write a Test program to test this class. 
 *  Pay attention to @throws tags in the javadoc.
 *  If needed, you can put "synchronized" keyword to methods.
 *  All classes for implementation must be private inside this class.
 *  Don't use java.util.concurrent package.
 */
public class ThreadPool {
    /** thread pool started flag */
    private boolean isStarted = false;
    
    private final Thread[] workers;
    
    private final Queue<Runnable> queue = new LinkedList<>();

	private final int queueSize;
    /**
     * Constructs ThreadPool.
     *
     * @param queueSize the max size of queue
     * @param numberOfThreads the number of threads in this pool.
     *
     * @throws IllegalArgumentException if either queueSize or numberOfThreads
     *         is less than 1
     */
    public ThreadPool(int queueSize, int numberOfThreads) {
        if (queueSize < 1 || numberOfThreads < 1) {
            throw new IllegalArgumentException();
        }
        this.queueSize = queueSize;
        workers = new Thread[numberOfThreads];
        
    }

    /**
     * Starts threads.
     *
     * @throws IllegalStateException if threads has been already started.
     */
    public void start() {
        if (isStarted) {
            throw new IllegalStateException();
        }
        
        /*
        for (Thread t : workers) {
            t = new Worker();
            t.start();
        }
        */
        
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Worker();
            workers[i].start();
        }
        
        isStarted = true;
    }   

    /**
     * Stop all threads and wait for their terminations.
     *
     * @throws IllegalStateException if threads has not been started.
     */
    public void stop() {
        if (!isStarted) {
            throw new IllegalStateException();
        }
        
        synchronized (queue) {
            queue.notifyAll();
        }

        for (Thread t : workers) {
            if (t.isAlive()) {
                t.interrupt();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
        isStarted = false;
    }

    /**
     * Executes the specified Runnable object, using a thread in the pool.
     * run() method will be invoked in the thread. If the queue is full, then
     * this method invocation will be blocked until the queue is not full.
     * 
     * @param runnable Runnable object whose run() method will be invoked.
     *
     * @throws NullPointerException if runnable is null.
     * @throws IllegalStateException if this pool has not been started yet.
     */
    public synchronized void dispatch(Runnable runnable) {
        if (!isStarted) {
            throw new IllegalStateException();
        }
        
        if (runnable == null ) {
            throw new NullPointerException();
        }
        
        synchronized (queue) {
            queue.offer(runnable);
            queue.notifyAll();
        }
    }
    
    private class Worker extends Thread {
        private Runnable r;
        @Override
        public void run() {
            while (!isInterrupted()) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                            
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        r = queue.poll();
                        r.run();
                    }
                    
                }
            }
        }
    }
}
