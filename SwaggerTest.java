package APIAutomation;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class SwaggerTest {

        @Test
        public void creatingSingleUser(){

            CreateUserRequest request = new CreateUserRequest();
            UserResponse response = new UserResponse();
            request.setId(01);
            request.setUsername("Jayasiri");
            request.setFirstName("Jaya");
            request.setLastName("Siri");
            request.setEmail("siri@test.com");
            request.setPassword("Siri1234");
            request.setPhone("3322117788");
            request.setUserStatus(0);


            UserResponse user1 =
                    given().
                            contentType(ContentType.JSON).body(request).
                            when().log().all().
                            post("https://petstore.swagger.io/v2/user").as(
                                    UserResponse.class);
            user1.printResponseBody();
            Assert.assertEquals(200,user1.getCode());
        }

        @Test
        public void creatingMultipleUsers(){
            ArrayList<CreateUserRequest> multipleUsers = new ArrayList<CreateUserRequest>();

            CreateUserRequest request1 = new CreateUserRequest();
            request1.setId(02);
            request1.setUsername("User2");
            request1.setFirstName("User");
            request1.setLastName("test2");
            request1.setEmail("Usertest2@gmail.com");
            request1.setPassword("user2test");
            request1.setPhone("4433226677");
            request1.setUserStatus(2);
            multipleUsers.add(request1);


            CreateUserRequest request2 = new CreateUserRequest();
            request2.setId(03);
            request2.setUsername("User3");
            request2.setFirstName("User");
            request2.setLastName("test3");
            request2.setEmail("Usertest3@gmail.com");
            request2.setPassword("User3test");
            request2.setPhone("7788995544");
            request2.setUserStatus(3);
            multipleUsers.add(request2);

           UserResponse users =
                    given().
                            contentType(ContentType.JSON).body(multipleUsers).log().body().
                            when().
                            post("https://petstore.swagger.io/v2/user/createWithArray").as(UserResponse.class);
            users.printResponseBody();
            Assert.assertEquals(200,users.getCode());
        }
    }


