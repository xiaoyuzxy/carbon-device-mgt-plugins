
/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.device.mgt.iot.config.server.datasource;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the org.wso2.carbon.device.mgt.iot.common.config.server.configs package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeviceCloudConfiguration_QNAME = new QName("", "DeviceManagementConfigurations");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:
     * org.wso2.carbon.device.mgt.iot.common.config.server.configs
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeviceManagementConfiguration }
     */
    public DeviceManagementConfiguration createDeviceCloudConfig() {
        return new DeviceManagementConfiguration();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeviceManagementConfiguration }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "DeviceManagementConfigurations")
    public JAXBElement<DeviceManagementConfiguration> createDeviceCloudConfiguration(
            DeviceManagementConfiguration value) {
        return new JAXBElement<DeviceManagementConfiguration>(_DeviceCloudConfiguration_QNAME,
                                                              DeviceManagementConfiguration.class, null, value);
    }

}
