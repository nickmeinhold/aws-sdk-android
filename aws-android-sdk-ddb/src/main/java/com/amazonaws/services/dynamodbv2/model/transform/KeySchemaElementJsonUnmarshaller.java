/*
 * Copyright 2010-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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

import java.util.Map;
import java.util.Map.Entry;

import com.amazonaws.services.dynamodbv2.model.*;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.json.AwsJsonReader;

/**
 * Key Schema Element JSON Unmarshaller
 */
public class KeySchemaElementJsonUnmarshaller implements Unmarshaller<KeySchemaElement, JsonUnmarshallerContext> {

    public KeySchemaElement unmarshall(JsonUnmarshallerContext context) throws Exception {
        KeySchemaElement keySchemaElement = new KeySchemaElement();

        AwsJsonReader reader = context.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            
            if (name.equals("AttributeName")) {
                keySchemaElement.setAttributeName(StringJsonUnmarshaller.getInstance().unmarshall(context));
            } else 
            if (name.equals("KeyType")) {
                keySchemaElement.setKeyType(StringJsonUnmarshaller.getInstance().unmarshall(context));
            } else 
            {
                reader.skipValue();
            }
            
        }
        reader.endObject();
        
        return keySchemaElement;
    }

    private static KeySchemaElementJsonUnmarshaller instance;
    public static KeySchemaElementJsonUnmarshaller getInstance() {
        if (instance == null) instance = new KeySchemaElementJsonUnmarshaller();
        return instance;
    }
}
    