package com.ecommerceapi;

import lombok.RequiredArgsConstructor;
import org.hibernate.search.mapper.orm.Search;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Component
public class MassIndex {
    private final EntityManager em;

    @EventListener(ContextRefreshedEvent.class)
    @Transactional(readOnly = true)
    public void doSomethingAfterStartup() {
        System.out.println("hello world, I have just started up");
        try {
            var searchSession = Search.session(em);
            var indexer = searchSession.massIndexer(Item.class)
                    .threadsToLoadObjects(7);
            indexer.startAndWait();
        } catch (InterruptedException exception) {
            throw new RuntimeException("INDEXING FAIL ", exception);
        }
    }
}
