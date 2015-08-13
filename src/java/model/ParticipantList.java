package model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.enterprise.context.ApplicationScoped;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseBroadcaster;

@ApplicationScoped
public class ParticipantList {
    
    private SseBroadcaster broadcaster = new SseBroadcaster();
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();
    
    public void add(EventOutput eo) {
        final Lock wLock = rwLock.writeLock();
        wLock.lock();
        try {
            broadcaster.add(eo);
        } finally {
            wLock.unlock();
        }
    }
    
    public void send(OutboundEvent event) {
        final Lock rLock = rwLock.readLock();
        rLock.lock();
        try {
            System.out.println(">>> sending data");
            broadcaster.broadcast(event);
        } finally {
            rLock.unlock();
        }
    }
}
