package com.example.jsontool.observer;

import com.example.jsontool.observer.MetadataLoggerObserver;
import com.example.jsontool.observer.MetadataValidationObserver;
import com.example.jsontool.service.SchemaMetadataServiceImplementation;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObserverConfig {
    public ObserverConfig(SchemaMetadataServiceImplementation metadataService,
                          MetadataLoggerObserver loggerObserver,
                          MetadataValidationObserver validationObserver) {
        metadataService.addObserver(loggerObserver);
        metadataService.addObserver(validationObserver);
    }
}


