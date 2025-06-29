package com.course.ai.rag_pipeline.temporal.activity;

import java.util.List;

import org.springframework.ai.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.course.ai.rag_pipeline.service.RAGVectorIndexingService;
import com.course.ai.rag_pipeline.temporal.constant.TemporalTaskQueues;

import io.temporal.spring.boot.ActivityImpl;

@Component
@ActivityImpl(taskQueues = TemporalTaskQueues.FINANCIAL_INDEXING)
public class FinancialIndexingActivitiesImpl implements FinancialIndexingActivities {

    @Autowired
    private RAGVectorIndexingService ragVectorIndexingService;

    @Override
    public List<Document> processDocument(String resourcePath, List<String> keywords) {
        var resource = new FileSystemResource(resourcePath);

        return ragVectorIndexingService.processDocument(resource, keywords);
    }

}
