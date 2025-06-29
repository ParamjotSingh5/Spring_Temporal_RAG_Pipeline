package com.course.ai.rag_pipeline.temporal.activity;

import java.io.IOException;
import java.util.List;

import org.springframework.ai.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;

import com.course.ai.rag_pipeline.service.RAGVectorIndexingService;
import com.course.ai.rag_pipeline.temporal.constant.TemporalTaskQueues;

import io.temporal.spring.boot.ActivityImpl;

@Component
@ActivityImpl(taskQueues = TemporalTaskQueues.URL_ONE_INDEXING)
public class UrlOneIndexingActivitiesImpl implements UrlOneIndexingActivities {

    @Autowired
    private RAGVectorIndexingService ragVectorIndexingService;

    @Override
    public List<Document> processDocument(String resourcePath, List<String> keywords) throws IOException {
        var resource = new UrlResource(resourcePath);
        return ragVectorIndexingService.processDocument(resource, keywords);
    }

}
