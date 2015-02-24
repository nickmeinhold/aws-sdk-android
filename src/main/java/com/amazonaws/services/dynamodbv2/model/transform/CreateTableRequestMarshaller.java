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
 * Create Table Request Marshaller
 */
public class CreateTableRequestMarshaller implements Marshaller<Request<CreateTableRequest>, CreateTableRequest> {

    public Request<CreateTableRequest> marshall(CreateTableRequest createTableRequest) {
    if (createTableRequest == null) {
        throw new AmazonClientException("Invalid argument passed to marshall(...)");
    }

        Request<CreateTableRequest> request = new DefaultRequest<CreateTableRequest>(createTableRequest, "AmazonDynamoDBv2");
        String target = "DynamoDB_20120810.CreateTable";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);

            jsonWriter.beginObject();

            com.amazonaws.internal.ListWithAutoConstructFlag<AttributeDefinition> attributeDefinitionsList = (com.amazonaws.internal.ListWithAutoConstructFlag<AttributeDefinition>)(createTableRequest.getAttributeDefinitions());
            if (attributeDefinitionsList != null && !(attributeDefinitionsList.isAutoConstruct() && attributeDefinitionsList.isEmpty())) {

                jsonWriter.name("AttributeDefinitions");
                jsonWriter.beginArray();

                for (AttributeDefinition attributeDefinitionsListValue : attributeDefinitionsList) {
                    if (attributeDefinitionsListValue != null) {
                        jsonWriter.beginObject();
                        if (attributeDefinitionsListValue.getAttributeName() != null) {
                            jsonWriter.name("AttributeName").value(attributeDefinitionsListValue.getAttributeName());
                        }
                        if (attributeDefinitionsListValue.getAttributeType() != null) {
                            jsonWriter.name("AttributeType").value(attributeDefinitionsListValue.getAttributeType());
                        }
                        jsonWriter.endObject();
                    }
                }
                jsonWriter.endArray();
            }
            if (createTableRequest.getTableName() != null) {
                jsonWriter.name("TableName").value(createTableRequest.getTableName());
            }

            com.amazonaws.internal.ListWithAutoConstructFlag<KeySchemaElement> keySchemaList = (com.amazonaws.internal.ListWithAutoConstructFlag<KeySchemaElement>)(createTableRequest.getKeySchema());
            if (keySchemaList != null && !(keySchemaList.isAutoConstruct() && keySchemaList.isEmpty())) {

                jsonWriter.name("KeySchema");
                jsonWriter.beginArray();

                for (KeySchemaElement keySchemaListValue : keySchemaList) {
                    if (keySchemaListValue != null) {
                        jsonWriter.beginObject();
                        if (keySchemaListValue.getAttributeName() != null) {
                            jsonWriter.name("AttributeName").value(keySchemaListValue.getAttributeName());
                        }
                        if (keySchemaListValue.getKeyType() != null) {
                            jsonWriter.name("KeyType").value(keySchemaListValue.getKeyType());
                        }
                        jsonWriter.endObject();
                    }
                }
                jsonWriter.endArray();
            }

            com.amazonaws.internal.ListWithAutoConstructFlag<LocalSecondaryIndex> localSecondaryIndexesList = (com.amazonaws.internal.ListWithAutoConstructFlag<LocalSecondaryIndex>)(createTableRequest.getLocalSecondaryIndexes());
            if (localSecondaryIndexesList != null && !(localSecondaryIndexesList.isAutoConstruct() && localSecondaryIndexesList.isEmpty())) {

                jsonWriter.name("LocalSecondaryIndexes");
                jsonWriter.beginArray();

                for (LocalSecondaryIndex localSecondaryIndexesListValue : localSecondaryIndexesList) {
                    if (localSecondaryIndexesListValue != null) {
                        jsonWriter.beginObject();
                        if (localSecondaryIndexesListValue.getIndexName() != null) {
                            jsonWriter.name("IndexName").value(localSecondaryIndexesListValue.getIndexName());
                        }

                        com.amazonaws.internal.ListWithAutoConstructFlag<KeySchemaElement> keySchema2List = (com.amazonaws.internal.ListWithAutoConstructFlag<KeySchemaElement>)(localSecondaryIndexesListValue.getKeySchema());
                        if (keySchema2List != null && !(keySchema2List.isAutoConstruct() && keySchema2List.isEmpty())) {

                            jsonWriter.name("KeySchema");
                            jsonWriter.beginArray();

                            for (KeySchemaElement keySchema2ListValue : keySchema2List) {
                                if (keySchema2ListValue != null) {
                                    jsonWriter.beginObject();
                                    if (keySchema2ListValue.getAttributeName() != null) {
                                        jsonWriter.name("AttributeName").value(keySchema2ListValue.getAttributeName());
                                    }
                                    if (keySchema2ListValue.getKeyType() != null) {
                                        jsonWriter.name("KeyType").value(keySchema2ListValue.getKeyType());
                                    }
                                    jsonWriter.endObject();
                                }
                            }
                            jsonWriter.endArray();
                        }
                        Projection projection = localSecondaryIndexesListValue.getProjection();
                        if (projection != null) {

                            jsonWriter.name("Projection");
                            jsonWriter.beginObject();

                            if (projection.getProjectionType() != null) {
                                jsonWriter.name("ProjectionType").value(projection.getProjectionType());
                            }

                            com.amazonaws.internal.ListWithAutoConstructFlag<String> nonKeyAttributesList = (com.amazonaws.internal.ListWithAutoConstructFlag<String>)(projection.getNonKeyAttributes());
                            if (nonKeyAttributesList != null && !(nonKeyAttributesList.isAutoConstruct() && nonKeyAttributesList.isEmpty())) {

                                jsonWriter.name("NonKeyAttributes");
                                jsonWriter.beginArray();

                                for (String nonKeyAttributesListValue : nonKeyAttributesList) {
                                    if (nonKeyAttributesListValue != null) {
                                        jsonWriter.value(nonKeyAttributesListValue);
                                    }
                                }
                                jsonWriter.endArray();
                            }
                            jsonWriter.endObject();
                        }
                        jsonWriter.endObject();
                    }
                }
                jsonWriter.endArray();
            }

            com.amazonaws.internal.ListWithAutoConstructFlag<GlobalSecondaryIndex> globalSecondaryIndexesList = (com.amazonaws.internal.ListWithAutoConstructFlag<GlobalSecondaryIndex>)(createTableRequest.getGlobalSecondaryIndexes());
            if (globalSecondaryIndexesList != null && !(globalSecondaryIndexesList.isAutoConstruct() && globalSecondaryIndexesList.isEmpty())) {

                jsonWriter.name("GlobalSecondaryIndexes");
                jsonWriter.beginArray();

                for (GlobalSecondaryIndex globalSecondaryIndexesListValue : globalSecondaryIndexesList) {
                    if (globalSecondaryIndexesListValue != null) {
                        jsonWriter.beginObject();
                        if (globalSecondaryIndexesListValue.getIndexName() != null) {
                            jsonWriter.name("IndexName").value(globalSecondaryIndexesListValue.getIndexName());
                        }

                        com.amazonaws.internal.ListWithAutoConstructFlag<KeySchemaElement> keySchema2List = (com.amazonaws.internal.ListWithAutoConstructFlag<KeySchemaElement>)(globalSecondaryIndexesListValue.getKeySchema());
                        if (keySchema2List != null && !(keySchema2List.isAutoConstruct() && keySchema2List.isEmpty())) {

                            jsonWriter.name("KeySchema");
                            jsonWriter.beginArray();

                            for (KeySchemaElement keySchema2ListValue : keySchema2List) {
                                if (keySchema2ListValue != null) {
                                    jsonWriter.beginObject();
                                    if (keySchema2ListValue.getAttributeName() != null) {
                                        jsonWriter.name("AttributeName").value(keySchema2ListValue.getAttributeName());
                                    }
                                    if (keySchema2ListValue.getKeyType() != null) {
                                        jsonWriter.name("KeyType").value(keySchema2ListValue.getKeyType());
                                    }
                                    jsonWriter.endObject();
                                }
                            }
                            jsonWriter.endArray();
                        }
                        Projection projection = globalSecondaryIndexesListValue.getProjection();
                        if (projection != null) {

                            jsonWriter.name("Projection");
                            jsonWriter.beginObject();

                            if (projection.getProjectionType() != null) {
                                jsonWriter.name("ProjectionType").value(projection.getProjectionType());
                            }

                            com.amazonaws.internal.ListWithAutoConstructFlag<String> nonKeyAttributesList = (com.amazonaws.internal.ListWithAutoConstructFlag<String>)(projection.getNonKeyAttributes());
                            if (nonKeyAttributesList != null && !(nonKeyAttributesList.isAutoConstruct() && nonKeyAttributesList.isEmpty())) {

                                jsonWriter.name("NonKeyAttributes");
                                jsonWriter.beginArray();

                                for (String nonKeyAttributesListValue : nonKeyAttributesList) {
                                    if (nonKeyAttributesListValue != null) {
                                        jsonWriter.value(nonKeyAttributesListValue);
                                    }
                                }
                                jsonWriter.endArray();
                            }
                            jsonWriter.endObject();
                        }
                        ProvisionedThroughput provisionedThroughput = globalSecondaryIndexesListValue.getProvisionedThroughput();
                        if (provisionedThroughput != null) {

                            jsonWriter.name("ProvisionedThroughput");
                            jsonWriter.beginObject();

                            if (provisionedThroughput.getReadCapacityUnits() != null) {
                                jsonWriter.name("ReadCapacityUnits").value(provisionedThroughput.getReadCapacityUnits());
                            }
                            if (provisionedThroughput.getWriteCapacityUnits() != null) {
                                jsonWriter.name("WriteCapacityUnits").value(provisionedThroughput.getWriteCapacityUnits());
                            }
                            jsonWriter.endObject();
                        }
                        jsonWriter.endObject();
                    }
                }
                jsonWriter.endArray();
            }
            ProvisionedThroughput provisionedThroughput = createTableRequest.getProvisionedThroughput();
            if (provisionedThroughput != null) {

                jsonWriter.name("ProvisionedThroughput");
                jsonWriter.beginObject();

                if (provisionedThroughput.getReadCapacityUnits() != null) {
                    jsonWriter.name("ReadCapacityUnits").value(provisionedThroughput.getReadCapacityUnits());
                }
                if (provisionedThroughput.getWriteCapacityUnits() != null) {
                    jsonWriter.name("WriteCapacityUnits").value(provisionedThroughput.getWriteCapacityUnits());
                }
                jsonWriter.endObject();
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
