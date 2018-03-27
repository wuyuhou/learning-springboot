/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2017年5月5日 下午2:23:33
 *******************************************************************************/


package com.primeton.learns.springboot.jpa.demo.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程工具类
 *
 * @author wuyuhou (mailto:wuyh@primeton.com)
 */
public class ThreadUtil {
	
	/**
	 * 取得固定的线程执行器
	 * 
	 * @param nThreads 线程数
	 * @param isDaemon 是否是daemon线程
	 * @param threadNamePrefix 线程名称
	 * @return 线程执行器
	 */
	public static ExecutorService getFixedExecutorService(int nThreads, boolean isDaemon, String threadName) {
		ThreadFactory threadFactory = new DefaultThreadFactory(threadName, isDaemon, nThreads);
		return Executors.newFixedThreadPool(nThreads, threadFactory);
	}
	
	static class DefaultThreadFactory implements ThreadFactory {
        private ThreadGroup group;
        private AtomicInteger threadNumber = new AtomicInteger(1);
        private int nThreads;
        private boolean isDaemon;
        private String threadNamePrefix;

        DefaultThreadFactory(String threadNamePrefix, boolean isDaemon, int nThreads) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.nThreads = nThreads;
            this.isDaemon = isDaemon;
            this.threadNamePrefix = threadNamePrefix;
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, nThreads > 1 ? threadNamePrefix + threadNumber.getAndIncrement() : threadNamePrefix, 0);
            t.setDaemon(isDaemon);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }
}
