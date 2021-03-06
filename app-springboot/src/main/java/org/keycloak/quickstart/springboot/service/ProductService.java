/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.keycloak.quickstart.springboot.service;

import java.util.Arrays;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.keycloak.quickstart.springboot.ProductApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductService {
    private static Log logger = LogFactory.getLog(ProductApplication.class);

    @Autowired
    private KeycloakRestTemplate template;


    public List<String> getProducts() {
        ResponseEntity<String[]> response = template.getForEntity("http://localhost:3000/products", String[].class);
        return Arrays.asList(response.getBody());
    }

    public List<String> getPublicProducts() {
        ResponseEntity<String[]> response = template.getForEntity("http://localhost:3000/public", String[].class);
        return Arrays.asList(response.getBody());
    }
}
