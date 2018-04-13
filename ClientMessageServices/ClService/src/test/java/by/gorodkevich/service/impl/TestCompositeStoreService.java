package by.gorodkevich.service.impl;

import by.gorodkevich.service.StoreService;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

public class TestCompositeStoreService {
    @Test
    public void testSrviceHandler() {
        StoreService mongoSenderService = mock(StoreService.class);
        StoreService queueSenderService = mock(StoreService.class);


/*
        CompositeStoreService serviceHandler = new CompositeStoreService(queueSenderService,mongoSenderService);
        serviceHandler.store(anyCollection());
        verify(mongoSenderService, times(1)).store(anyCollection());
        verify(queueSenderService,times(1)).store(anyCollection());*/
    }
}
