# spring-basics-app

Some basics of Spring and Spring Boot Framework and notes for the same.

## Tools and Frameworks
1. [Spring](https://spring.io)
2. [Spring Boot](https://spring.io/projects/spring-boot)
3. [Spring Initializr](https://start.spring.io)
4. [Maven](https://maven.apache.org)

## MVC Architechture

MVC stands for Model-View-Controller. This architecture is followed by Spring Framework.

<img src="https://www.guru99.com/images/1/122118_0445_MVCTutorial1.png" height=300 width=400 alt="https://www.guru99.com/mvc-tutorial.html"> 

Image credits :- "https://www.guru99.com/mvc-tutorial.html"

## Spring Framework
Spring is a framework for Java to create modern applications. It is mostly used for Enterprise solutions. Spring frameworks follows various best practices from industry and is production ready. Spring has many modules in it for RESTful web services, MVC web applications, templating engine, connectivity with various databases (JPA), etc.

## Spring Boot
According to Spring's [official website](https://spring.io/projects/spring-boot) :-

> Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".

The Spring framework is complex. It requires going through a lengthy procedure in order to start a new Spring project. To avoid starting from scratch and save time, Spring Boot can be used. It uses the Spring framework as a foundation.

To know more differences visit [here.](https://www.baeldung.com/spring-vs-spring-boot)

## Spring Initializr
[Spring Initializr](https://start.spring.io/) is used to quickly begin a project. It reduces the manual work of editing xml files for spring projects. We can add all the required dependencies in this phase. Everything else is taken care of by gradle / maven.

## Maven
[Maven](https://maven.apache.org) is used to for building and managing any Java based project. It reduces the work of developers by handling any dependencies of the project as well as helps in easy packaging and deploying of these dependencies. It ensures a uniform build system by using project object model (POM).

# Current Project Implementation :-

<img src="./images/spring-boot-app.png" height=450 width=450 alt="/images">

Currently there is implementation only for a REST service. There is no consumption of REST right now.

The general data flow will be :-

**Request -> Controller -> Service Layer -> Data Access Layer -> Database**

The same will be in the reverse order for a response.

## Why such layers ?

These layers help the project become modular, loosely coupled and make dependency injections easier. The modification of one of the layers doesn't require changes in other layers. This saves time refactoring, testing and is generally considered a good practice.

#### Api / Controller Layer :-
This layer is directly contacted by an external entity and a request is made to it. It is also responsible for routing the requests properly and displaying error messages in case of discrepancies. The controller layer also defines which http methods are to be used, and maps the requests properly as well as any request parameters and body alongwith it.

#### Service Layer :-
The service layer as the name suggests services the requests that have been made to it. The service layer has the complete business logic related to the REST requests. The service layer is however the abstraction of the actual implementation and has various methods which fulfill the business logic. It also defines which data access implementation should be chosen (Dependency Injection).

#### Data Access Layer :-
The data access layer is the one responsible to take the abstraction from the service layer and have a concrete implementation for accessing the data from the database. For every database this implementation may change and hence we use abstraction (Service Layer) to keep the modules loosely coupled. It maps the data models and the actual data retrieved from the database. 

## Directory Structure
```bash
├── api
│   └── PersonController.java   
├── dao
│   ├── FakePersonDataAccessService.java 
│   └── PersonDao.java
├── model
│   └── Person.java
├── service
│   └── PersonService.java
├── DemoApplication.java
```

#### api 
This dir holds all the *Controller* classes in it. It is interface between requests and the service layer as well as database layer (indirectly through service layer). Helps to route all the requests.

#### dao
DAO stands for *Data Access Object*. DAO provides *abstraction* to some persistence or database access. It helps map different database implementations without explicitly exposing what to do. It is like a contract for any class that wants to implement it for persistence.

#### model
This dir holds all the model classes. A model helps describe an *entity* in OOP. They include all the fields, getters and setters, etc.

#### service
Services act as an interface between the DAO and the API controllers. It has a concrete implementation of the DAO interface and maps all the functions to that implementation directly which will be used by the controllers.

## Annotations

**TODO** -> Add annotations information.

### @Repository
It is used in the concrete class that has the implementation of the DAO interface. Generally used in the class that has direct contact with the database. It fulfills the role of *Repository*.

Used in the [*FakePersonDataAccessService.java*](./src/main/java/com/example/peopledemo/dao/FakePersonDataAccessService.java)

### @Service
It is used to denote a Service class to the Spring framework. It tells spring that this is the service layer implmentation for which the methods are *autowired* such as executing business logic, perform calculations and call external APIs. It is used on a class.

Used in the [*PersonService.java*](/src/main/java/com/example/peopledemo/service/PersonService.java)

### @Autowired
It is used for implicit *dependency injection*. This annotation is applied on fields, setter methods, and constructors. When we use it on a constructor, injection happens at the time of object creation. Only one constructor of a Bean class can use @Autowired annotation at a time.

Used in [*PersonController.java*](/src/main/java/com/example/peopledemo/api/PersonController.java) and [*PersonService.java*](/src/main/java/com/example/peopledemo/api/PersonService.java) for a constructor.

### @Qualifier
Used to differentiate between different implementations of the same bean class. We give it the name of the implementation that we want to use. Here we use the name of the @Repository. It used with the @Autowired implementation to give more *control* on dependency injection

Used in [*PersonService.java*](/src/main/java/com/example/peopledemo/service/PersonService.java)

### @RestController
Used to specify that the class is used as a Rest Controller class. The class then can use various annotations like @GetMapping, @PostMapping etc. When we use this annotation there is no need to specify the @ResponseBody explicitly for the RequestMappings. The consumers can get the format in JSON / XML. It is a class level annotation.

Used in [*PersonController.java*](/src/main/java/com/example/peopledemo/api/PersonController.java)

### @JsonProperty
This tells spring, what field of an object belongs to which key in the JSON object and vice versa. This helps to map the object to JSON format and helps in building java objects from JSON. It is a field level annotation.

Used in [*Person.java*](/src/main/java/com/example/peopledemo/model/Person.java)

### @RequestBody
This helps the method parameter to be bound to the incoming HTTP request body. Spring automatically converts the incoming http request body to the corresponding java object by mapping various fields specified by @JsonProperty.

Used in [*PersonController.java*](/src/main/java/com/example/peopledemo/api/PersonController.java)

### @RequestMapping
It can be used at both class level as well as method level. This annotation helps map the incoming https requests to a controller class or a request handler method. Each handler method can have their own @RequestMapping URI. We have to pass a URI to this RequestMapping which should not be fully qualified, rather a relational one. 

Used in [*PersonController.java*](/src/main/java/com/example/peopledemo/api/PersonController.java)

### @PathVariable
This annotation helps get the variables passed in http request's path and convert them to equivalent method arguments of any handler method. The URI can have multiple dynamic path variables, which can be used for different handler methods.

Used in [*PersonController.java*](/src/main/java/com/example/peopledemo/api/PersonController.java)

### @SpringBootApplication
This annotation is used only once to denote the beginning of a SpringBootApplication. This should be declared in the base package only as it performs Components scanning in its sub packages. It handles the creation of DispatcherServlets and other various boilerplate code for us.

Used in [*DemoApplication.java*](/src/main/java/com/example/peopledemo/DemoApplication.java)

### @PostMapping
Helps map *POST* requests to a URI either specified in @RequestMapping at class level / a URI passed to @PostMapping. 

Used in [*PersonController.java*](/src/main/java/com/example/peopledemo/api/PersonController.java)

### @GetMapping
Helps map *GET* requests to a URI either specified in @RequestMapping at class level / a URI passed to @PostMapping. 

Used in [*PersonController.java*](/src/main/java/com/example/peopledemo/api/PersonController.java)

### @PutMapping
Helps map *PUT* requests to a URI either specified in @RequestMapping at class level / a URI passed to @PostMapping. 

Used in [*PersonController.java*](/src/main/java/com/example/peopledemo/api/PersonController.java)

### @DeleteMapping
Helps map *DELETE* requests to a URI either specified in @RequestMapping at class level / a URI passed to @PostMapping. 

Used in [*PersonController.java*](/src/main/java/com/example/peopledemo/api/PersonController.java)

### @Required
This annotation enforces the population of any field in an object. This is similar to the nullability/empty check enforcement. This is used on setter methods of a class. However this annotation is marked *@deprecated*. So as an alternative for this, the constructor injection should be used, which is much clearer and enforces population at the creation itself. It is needed to make fields final, which helps in object immuatability too.

## References
- https://www.youtube.com/watch?v=r-6BwGW4Sr8
- https://spring.io
- https://maven.apache.org
- https://www.guru99.com/mvc-tutorial.html
- https://dzone.com/articles/understanding-the-basics-of-spring-vs-spring-boot
- https://www.baeldung.com/spring-vs-spring-boot
- https://springframework.guru/spring-framework-annotations/
