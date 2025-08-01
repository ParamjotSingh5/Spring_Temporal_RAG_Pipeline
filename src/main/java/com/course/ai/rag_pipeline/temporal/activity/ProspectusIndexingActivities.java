package com.course.ai.rag_pipeline.temporal.activity;

import java.util.List;

import org.springframework.ai.document.Document;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface ProspectusIndexingActivities {

    @ActivityMethod
    List<Document> processDocument(String resourcePath, List<String> keywords);

}
