/*
 * Copyright 2010-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.dynamodbv2.model.transform;

import static com.amazonaws.util.StringUtils.UTF8;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.List;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.dynamodbv2.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;

/**
 * Batch Write Item Request Marshaller
 */
public class BatchWriteItemRequestMarshaller implements Marshaller<Request<BatchWriteItemRequest>, BatchWriteItemRequest> {

    public Request<BatchWriteItemRequest> marshall(BatchWriteItemRequest batchWriteItemRequest) {
    if (batchWriteItemRequest == null) {
        throw new AmazonClientException("Invalid argument passed to marshall(...)");
    }

        Request<BatchWriteItemRequest> request = new DefaultRequest<BatchWriteItemRequest>(batchWriteItemRequest, "AmazonDynamoDBv2");
        String target = "DynamoDB_20120810.BatchWriteItem";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);

            jsonWriter.beginObject();
            
            if (batchWriteItemRequest.getRequestItems() != null) {
                jsonWriter.name("RequestItems");
                jsonWriter.beginObject();
                for (Map.Entry<String, java.util.List<WriteRequest>> requestItemsListValue : batchWriteItemRequest.getRequestItems().entrySet()) {
                    if (requestItemsListValue.getValue() != null) {
                        jsonWriter.name(requestItemsListValue.getKey());

                        jsonWriter.beginArray();
                        for (WriteRequest valueListValue : requestItemsListValue.getValue()) {
                            if (valueListValue != null) {
                                jsonWriter.beginObject();
                                PutRequest putRequest = valueListValue.getPutRequest();
                                if (putRequest != null) {

                                    jsonWriter.name("PutRequest");
                                    jsonWriter.beginObject();

                                    if (putRequest.getItem() != null) {
                                        jsonWriter.name("Item");
                                        jsonWriter.beginObject();
                                        for (Map.Entry<String, AttributeValue> itemListValue : putRequest.getItem().entrySet()) {
                                            if (itemListValue.getValue() != null) {
                                                jsonWriter.name(itemListValue.getKey());

                                                AttributeValueJsonMarshaller.getInstance().marshall(itemListValue.getValue(), jsonWriter);
                                            }
                                        }
                                        jsonWriter.endObject();
                                    }
                                    jsonWriter.endObject();
                                }
                                DeleteRequest deleteRequest = valueListValue.getDeleteRequest();
                                if (deleteRequest != null) {

                                    jsonWriter.name("DeleteRequest");
                                    jsonWriter.beginObject();

                                    if (deleteRequest.getKey() != null) {
                                        jsonWriter.name("Key");
                                        jsonWriter.beginObject();
                                        for (Map.Entry<String, AttributeValue> keyListValue : deleteRequest.getKey().entrySet()) {
                                            if (keyListValue.getValue() != null) {
                                                jsonWriter.name(keyListValue.getKey());

                                                AttributeValueJsonMarshaller.getInstance().marshall(keyListValue.getValue(), jsonWriter);
                                            }
                                        }
                                        jsonWriter.endObject();
                                    }
                                    jsonWriter.endObject();
                                }
                                jsonWriter.endObject();
                            }
                        }
                        jsonWriter.endArray();
                    }
                }
                jsonWriter.endObject();
            }
            if (batchWriteItemRequest.getReturnConsumedCapacity() != null) {
                jsonWriter.name("ReturnConsumedCapacity").value(batchWriteItemRequest.getReturnConsumedCapacity());
            }
            if (batchWriteItemRequest.getReturnItemCollectionMetrics() != null) {
                jsonWriter.name("ReturnItemCollectionMetrics").value(batchWriteItemRequest.getReturnItemCollectionMetrics());
            }

            jsonWriter.endObject();

            jsonWriter.close();
            String snippet = stringWriter.toString();
            byte[] content = snippet.getBytes(UTF8);
            request.setContent(new StringInputStream(snippet));
            request.addHeader("Content-Length", Integer.toString(content.length));
            request.addHeader("Content-Type", "application/x-amz-json-1.0");
        } catch(Throwable t) {
            throw new AmazonClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }
}
