package io.netty.channel.epoll;

import java.io.IOException;

import io.netty.channel.unix.FileDescriptor;

public class NettyEpollTest {

	public static void main(String[] args) throws IOException {
		FileDescriptor epollFd = Native.newEpollCreate();
		FileDescriptor eventFd = Native.newEventFd();
		Native.epollCtlAdd(epollFd.intValue(), eventFd.intValue(), Native.EPOLLIN);
		FileDescriptor timerFd = Native.newTimerFd();
		EpollEventArray events = new EpollEventArray(4096);
		Native.epollWait(epollFd, events, timerFd, -1, -1);
	}
}
