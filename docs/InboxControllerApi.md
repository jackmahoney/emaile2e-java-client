# InboxControllerApi

All URIs are relative to *https://api.emaile2e.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUsingPOST**](InboxControllerApi.md#createUsingPOST) | **POST** /inboxes | Create an inbox
[**indexUsingGET**](InboxControllerApi.md#indexUsingGET) | **GET** /inboxes | List your inboxes
[**viewUsingGET**](InboxControllerApi.md#viewUsingGET) | **GET** /inboxes/{uuid} | Fetch emails for a given inbox


<a name="createUsingPOST"></a>
# **createUsingPOST**
> ResponseInboxDto createUsingPOST(apiKey)

Create an inbox

Create a new random inbox and return the id and email address for it. Send emails to this address and they will be stored for this inbox.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InboxControllerApi;


InboxControllerApi apiInstance = new InboxControllerApi();
String apiKey = "apiKey_example"; // String | Your API Key. Sign up and find it in your dashboard.
try {
    ResponseInboxDto result = apiInstance.createUsingPOST(apiKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InboxControllerApi#createUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| Your API Key. Sign up and find it in your dashboard. |

### Return type

[**ResponseInboxDto**](ResponseInboxDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="indexUsingGET"></a>
# **indexUsingGET**
> ResponseListInboxDto indexUsingGET(apiKey)

List your inboxes

Return a list of your inboxes. Each inbox has a uuid and an email address. Emails sent to the email address are stored in the inbox and can be fetched via &#x60;/inboxes/{uuid}&#x60;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InboxControllerApi;


InboxControllerApi apiInstance = new InboxControllerApi();
String apiKey = "apiKey_example"; // String | Your API Key. Sign up and find it in your dashboard.
try {
    ResponseListInboxDto result = apiInstance.indexUsingGET(apiKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InboxControllerApi#indexUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| Your API Key. Sign up and find it in your dashboard. |

### Return type

[**ResponseListInboxDto**](ResponseListInboxDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="viewUsingGET"></a>
# **viewUsingGET**
> ResponseListEmailDto viewUsingGET(apiKey, uuid, waitFor, since)

Fetch emails for a given inbox

Return a list of emails stored in a given inbox. Each email contains various properties including the email body (in eml format), subject, and sender. The &#x60;since&#x60; parameter is a ISO8601 LocalDateTime that will filter for emails received on or after the given DateTime. Note that because an inbox may take 5 to 10 seconds to receive an email, you can use the &#x60;waitFor&#x60; parameter to hold a request open until the desired number of emails is present. If this number is not met after 30 seconds, an error will be returned.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.InboxControllerApi;


InboxControllerApi apiInstance = new InboxControllerApi();
String apiKey = "apiKey_example"; // String | Your API Key. Sign up and find it in your dashboard.
String uuid = "uuid_example"; // String | The inbox's id.
Integer waitFor = 56; // Integer | Wait a maximum of 30 seconds for atleast this many emails in an inbox before returning a result.
DateTime since = new DateTime(); // DateTime | Filter for emails received on or after this ISO8601 LocalDateTime.
try {
    ResponseListEmailDto result = apiInstance.viewUsingGET(apiKey, uuid, waitFor, since);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InboxControllerApi#viewUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| Your API Key. Sign up and find it in your dashboard. |
 **uuid** | **String**| The inbox&#39;s id. |
 **waitFor** | **Integer**| Wait a maximum of 30 seconds for atleast this many emails in an inbox before returning a result. | [optional]
 **since** | **DateTime**| Filter for emails received on or after this ISO8601 LocalDateTime. | [optional]

### Return type

[**ResponseListEmailDto**](ResponseListEmailDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

