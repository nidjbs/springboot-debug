/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.test.autoconfigure.data.neo4j;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.Neo4jContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration test with custom include filter for {@link DataNeo4jTest @DataNeo4jTest}.
 *
 * @author Eddú Meléndez
 * @author Michael Simons
 */
@Testcontainers(disabledWithoutDocker = true)
@ContextConfiguration(initializers = DataNeo4jTestWithIncludeFilterIntegrationTests.Initializer.class)
@DataNeo4jTest(includeFilters = @Filter(Service.class))
class DataNeo4jTestWithIncludeFilterIntegrationTests {

	@Container
	static final Neo4jContainer<?> neo4j = new Neo4jContainer<>().withoutAuthentication();

	@Autowired
	private ExampleService service;

	@Test
	void testService() {
		assertThat(this.service.hasNode(ExampleGraph.class)).isFalse();
	}

	static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

		@Override
		public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
			TestPropertyValues.of("spring.data.neo4j.uri=" + neo4j.getBoltUrl())
					.applyTo(configurableApplicationContext.getEnvironment());
		}

	}

}
