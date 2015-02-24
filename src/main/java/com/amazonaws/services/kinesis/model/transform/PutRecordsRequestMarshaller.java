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
package com.amazonaws.services.kinesis.model.transform;

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
import com.amazonaws.services.kinesis.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;

/**
 * Put Records Request Marshaller
 */
public class PutRecordsRequestMarshaller implements Marshaller<Request<PutRecordsRequest>, PutRecordsRequest> {

    public Request<PutRecordsRequest> marshall(PutRecordsRequest putRecordsRequest) {
    if (putRecordsRequest == null) {
        throw new AmazonClientException("Invalid argument passed to marshall(...)");
    }

        Request<PutRecordsRequest> request = new DefaultRequest<PutRecordsRequest>(putRecordsRequest, "AmazonKinesis");
        String target = "Kinesis_20131202.PutRecords";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);

            jsonWriter.beginObject();

            com.amazonaws.internal.ListWithAutoConstructFlag<PutRecordsRequestEntry> recordsList = (com.amazonaws.internal.ListWithAutoConstructFlag<PutRecordsRequestEntry>)(putRecordsRequest.getRecords());
            if (recordsList != null && !(recordsList.isAutoConstruct() && recordsList.isEmpty())) {

                jsonWriter.name("Records");
                jsonWriter.beginArray();

                for (PutRecordsRequestEntry recordsListValue : recordsList) {
                    if (recordsListValue != null) {
                        jsonWriter.beginObject();
                        if (recordsListValue.getData() != null) {
                            jsonWriter.name("Data").value(recordsListValue.getData());
                        }
                        if (recordsListValue.getExplicitHashKey() != null) {
                            jsonWriter.name("ExplicitHashKey").value(recordsListValue.getExplicitHashKey());
                        }
                        if (recordsListValue.getPartitionKey() != null) {
                            jsonWriter.name("PartitionKey").value(recordsListValue.getPartitionKey());
                        }
                        jsonWriter.endObject();
                    }
                }
                jsonWriter.endArray();
            }
            if (putRecordsRequest.getStreamName() != null) {
                jsonWriter.name("StreamName").value(putRecordsRequest.getStreamName());
            }

            jsonWriter.endObject();

            jsonWriter.close();
            String snippet = stringWriter.toString();
            byte[] content = snippet.getBytes(UTF8);
            request.setContent(new StringInputStream(snippet));
            request.addHeader("Content-Length", Integer.toString(content.length));
            request.addHeader("Content-Type", "application/x-amz-json-1.1");
        } catch(Throwable t) {
            throw new AmazonClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }
}
