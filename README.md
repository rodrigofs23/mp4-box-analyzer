# MP4 Box Analyzer assignment

## How to use

1. Make sure you have Java 17 installed.
2. Run on the terminal: `mvn spring-boot:run`
    1. Alternatively, you can just run the Mp4BoxAnalyzerApplication class with the default configuration on your IDE.
3. Easy to test with Swagger OpenAPI exposed in: `http://localhost:9000/swagger-ui/index.html`
    1. Endpoints:
        1. "GET api/v1/mp4-box-analyzer" display the list of all boxes on a given mp4 url.
4. Alternatively, it can also be tested using a curl command:
    1. `curl -X GET http://localhost:9000/api/v1/mp4boxanalyzer\?url\=https://demo.castlabs.com/tmp/text0.mp4`

## Task description

Imagine a customer has asked you to build a tool that can provide data on nearby asteroids using NASA Asteroids API. The
tool is required to have the following features:

1. Show 10 asteroids that passed the closest to Earth between two user-provided dates.
2. Show characteristics of the largest asteroid (estimated diameter) passing Earth during a user-provided year.

In this exercise you will create a Spring Boot-based application with one controller.
This controller should accept a simple HTTP request with a URL as parameter, either a query param or a header or any
other way to signal parameters you deem reasonable. One type of parameter is sufficient.
The application should analyze an mp4 file found at the given URL and return a data structure describing the boxes of
the mp4 file, especially box type and box size. Ideally the data structure should reflect the nested nature of mp4
boxes. The output should be machine-readable, e.g. one of JSON, YAML, or XML. The payload data contained in any boxes
should be ignored.

The following assumptions can be made:

* The box types MOOF and TRAF only contain other boxes.
* All other boxes contain payload and do not contain other boxes.

The application should be built and packaged using maven.
Use any libraries you deem necessary to complete this exercise. Do not use a library for the mp4 analyzer part.
