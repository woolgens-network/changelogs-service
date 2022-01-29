package net.woolgens.changelogs;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import net.woolgens.changelogs.model.Changelog;
import net.woolgens.changelogs.repository.ChangelogsRepository;
import net.woolgens.changelogs.resource.ChangelogsResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(ChangelogsResource.class)
public class ChangelogsResourceTest {

    @Inject
    ChangelogsRepository repository;

    Changelog changelog;

    @BeforeEach
    public void setup() {
        changelog = new Changelog();
        changelog.setId(UUID.randomUUID().toString());
        repository.persistOrUpdate(changelog);
    }

    @Test
    public void testGetAllEndpoint() {
        given()
                .when().get("/")
                .then()
                .statusCode(200)
                .body("isEmpty()", is(false));
    }

    @Test
    public void testGetEndpoint() {
        given()
                .when().get("/" + changelog.getId())
                .then()
                .statusCode(200)
                .body("id", is(changelog.getId()));
    }

    @Test
    public void tesPutEndpoint() {
        Changelog changelog = new Changelog();
        changelog.setId(UUID.randomUUID().toString());
        given().body(changelog).contentType(ContentType.JSON)
                .when().put("/")
                .then()
                .statusCode(200)
                .body("id", is(changelog.getId()));
    }


    @Test
    public void tesDeleteEndpoint() {
        given()
                .when().delete("/" + changelog.getId())
                .then()
                .statusCode(200)
                .body(is("true"));
    }

}