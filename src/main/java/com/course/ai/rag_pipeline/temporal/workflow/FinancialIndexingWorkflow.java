package com.course.ai.rag_pipeline.temporal.workflow;

import java.util.List;

import org.springframework.ai.document.Document;

import com.course.ai.rag_pipeline.temporal.workflow.input.IndexingWorkflowInput;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface FinancialIndexingWorkflow {

    @WorkflowMethod
    List<Document> indexFinancialData(IndexingWorkflowInput source);

}
