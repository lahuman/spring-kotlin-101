# Spring Kotlin 101

> Spring Boot 와 Kotlin 기반으로 개발 환경 구축 하는 101 입니다. 

## WEB REST API 구축 

### 프로젝트 생성 

IntelliJ 와 같은 툴을 사용하거나, https://start.spring.io/ 사이트를 통해서 프로젝트를 생성할 수 있습니다 

아래 명령어는 `Gradle - Kotlin` 기반에 Spring Web, Spring Data JPA, H2 Database, Spring Boot DevTools의 의존성을 가진 프로젝트를 생성합니다. 

```bash
$ mkdir sk101 & cd sk101
$ curl https://start.spring.io/starter.zip -d language=kotlin -d type=gradle-project-kotlin -d dependencies=web,jpa,h2,devtools -d packageName=io.github.lahuman.sk101 -d name=SpringKotlin101 -o sk101.zip
$ unzip sk101.zip
```

H2에서 `user` 등의 키워드를 사용하면 아래 옵션이 `src/main/resources/application.yml`에 추가 되어야 합니다.

```yaml
spring:
  jpa:
    properties:
      hibernate.globally_quoted_identifiers: true
      hibernate.globally_quoted_identifiers_skip_column_definitions: true
```

`src/main/kotlin/io/github/lahuman/sk101/SpringKotlin101Application.kt` 을 실행하면 톰켓 서버가 뜨는 것이 확인 가능합니다. 

각 설정에 대한 상세 설명은 [Building web applications with Spring Boot and Kotlin](https://spring.io/guides/tutorials/spring-boot-kotlin)에서 확인 가능합니다. 

### Hello World 

`src/main/kotlin/io/github/lahuman/sk101/hello/HelloController.kt`에 아래와 같이 Controller를 추가하고 서버를 재기동하면, 

```kotlin
@RestController
@RequestMapping("/api/hello")
class HelloController() {
  @GetMapping
  fun hello() = "Hello World"
}
```
브라우저에서 http://localhost:8080/api/hello 로 접근하면 `Hello World`가 출력 되는 것을 확인 할 수 있습니다. 

또는 curl을 이용해 아래와 같이 테스트 가능 합니다. 

```bash
$ curl http://localhost:8080/api/hello
Hello World%
```

작성된 코드를 테스트 하는 TestCase는 아래와 같이 만들 수 있습니다. 

```kotlin
// src/test/kotlin/io/github/lahuman/sk101/SpringKotlin101ApplicationTests.kt
@AutoConfigureMockMvc
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringKotlin101ApplicationTests {
    @Autowired
    lateinit var mvc: MockMvc
    @Test
    fun `Hello World 호출 테스트`() {
        mvc.perform(MockMvcRequestBuilders.get("/api/hello").contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("Hello World"))
    }
}
```


### Reference Documentation

- [Building web applications with Spring Boot and Kotlin](https://spring.io/guides/tutorials/spring-boot-kotlin)
 