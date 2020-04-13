package com.nosbielc.resource;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import com.nosbielc.DataBaseLifecycle;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@DBUnit
@QuarkusTest
@QuarkusTestResource(DataBaseLifecycle.class)
public class ProductResourceTest {

    @Test
    @DataSet("produtos1.yml")
    public void testProductListAllEndpoint() {
        given()
          .when().get("/products")
          .then()
             .statusCode(200)
             .body(notNullValue());
    }

}