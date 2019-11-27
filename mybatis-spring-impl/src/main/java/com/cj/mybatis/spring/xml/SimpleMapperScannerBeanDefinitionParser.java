/**
 * Copyright 2010-2019 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cj.mybatis.spring.xml;


import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.ClassUtils;
import org.w3c.dom.Element;


public class SimpleMapperScannerBeanDefinitionParser extends AbstractBeanDefinitionParser {

    private static final String ATTRIBUTE_BASE_PACKAGE = "base-package";

    /**
     * {@inheritDoc}
     *
     * @since 2.0.2
     */
    @Override
    protected AbstractBeanDefinition parseInternal(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(SimpleMapperScannerConfigurer.class);

        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();

        builder.addPropertyValue("basePackage", element.getAttribute(ATTRIBUTE_BASE_PACKAGE));

        return builder.getBeanDefinition();
    }

    /**
     * {@inheritDoc}
     *
     * @since 2.0.2
     */
    @Override
    protected boolean shouldGenerateIdAsFallback() {
        return true;
    }

}
