# Spring Cloud Consul

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/MIT)

## Table of Contents
- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Scheduled Task](#scheduled-task)
- [Contributing](#contributing)
- [License](#license)

## Overview

The repository contains both Kotlin and Java application that utilizes the Spring Boot framework.
The code demonstrates the usage of various Spring Boot annotations and features, including auto-configuration, configuration properties, discovery client, and scheduling.

## Prerequisites

To run this application, you need to have the following prerequisites installed on your system:

- Java Development Kit (JDK) 17 and Kotlin 1.8.21
- Kotlin programming language
- Gradle build tool

## Getting Started

1. Clone this repository to your local machine.
2. Open the project in your preferred Kotlin IDE.
3. Build the project using Maven or Gradle.
4. Run the `main` function in the `KApp` class to start the application.

## Configuration

The application uses Spring Boot's configuration properties to manage external configuration.
The `UserProp` class represents the configuration properties for the application.
It is annotated with `@ConfigurationProperties` and has a prefix of `"api"`.
The `username` and `password` fields can be set through external configuration files or environment variables.

In consul application, change config for following dir;
1. Create `config` folder under `Key/Value` section.
2. Create `myApp` folder under `config` section you just created.
3. Create `data` field and fill it with proper data under `config/myApp` section like following
   ```
    api:
       username: anil1
       password: anil2
   ```

## Scheduled Task

The application includes a scheduled task that runs at a fixed rate. The `reportCurrentTime` function, annotated with `@Scheduled`, is executed every 3 seconds.
It retrieves the `UserProp` instance and prints its value to the console.

## Contributing

Contributions to this repository are welcome.
If you find any issues or want to suggest improvements, please create a pull request or submit an issue.

## License

This code is licensed under the [MIT License](LICENSE).
