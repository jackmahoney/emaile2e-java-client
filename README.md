# javaclient

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>com.api.emaile2e</groupId>
    <artifactId>javaclient</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.api.emaile2e:javaclient:1.0.0-SNAPSHOT"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/javaclient-1.0.0-SNAPSHOT.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.InboxControllerApi;

import java.io.File;
import java.util.*;

public class InboxControllerApiExample {

    public static void main(String[] args) {
        
        InboxControllerApi apiInstance = new InboxControllerApi();
        String apiKey = "apiKey_example"; // String | Your API Key. Sign up and find it in your dashboard.
        try {
            ResponseInboxDto result = apiInstance.createUsingPOST(apiKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InboxControllerApi#createUsingPOST");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://api.emaile2e.com*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*InboxControllerApi* | [**createUsingPOST**](docs/InboxControllerApi.md#createUsingPOST) | **POST** /inboxes | Create an inbox
*InboxControllerApi* | [**indexUsingGET**](docs/InboxControllerApi.md#indexUsingGET) | **GET** /inboxes | List your inboxes
*InboxControllerApi* | [**viewUsingGET**](docs/InboxControllerApi.md#viewUsingGET) | **GET** /inboxes/{uuid} | Fetch emails for a given inbox


## Documentation for Models

 - [EmailDto](docs/EmailDto.md)
 - [InboxDto](docs/InboxDto.md)
 - [ResponseInboxDto](docs/ResponseInboxDto.md)
 - [ResponseListEmailDto](docs/ResponseListEmailDto.md)
 - [ResponseListInboxDto](docs/ResponseListInboxDto.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



