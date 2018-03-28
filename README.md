# Retriable

[![Build Status](https://travis-ci.org/michaelruocco/retriable.svg?branch=master)](https://travis-ci.org/michaelruocco/retriable)
[![Coverage Status](https://coveralls.io/repos/github/michaelruocco/retriable/badge.svg?branch=master)](https://coveralls.io/github/michaelruocco/retriable?branch=master)
[![Maven Central](https://img.shields.io/maven-metadata/v/http/central.maven.org/maven2/com/github/michaelruocco/retriable/maven-metadata.xml.svg)](http://repo1.maven.org/maven2/com/github/michaelruocco/retriable)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/7512a910f62e4e8793638571771e175d)](https://www.codacy.com/app/michaelruocco/retriable?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=michaelruocco/retriable&amp;utm_campaign=Badge_Grade)

This provides a couple of commonly used utility classes when performing
an operation that needs to be retried. For example, you might have a test
that writes a file to an S3 bucket, if the operation happens asynchronously
you might have to check that the file has arrived a number of times, with a
given delay to wait in between checks. The library provides a way to perform
a sleep without having to catch a potential InterruptedException and a way to
provide config for the retry, the number of tries, and the wait delay between
attempts.

## Usage

To use the library from a program you will need to add a dependency to your project. In
gradle you would do this by adding the following to your build.gradle file:

```
dependencies {
    compile 'com.github.michaelruocco:retriable:1.0.1'
}
```

### Basic Usage

You can create an instance of the Sleeper class and then pass a number
of milliseconds to sleep for, for example if you wanted to sleep for a
second  you can do the following:

```
Sleeper sleeper = new Sleeper();
sleeper.sleep(1000);
```

You can create an instance of DefaultRetryConfig to provide a maximum
number of retries and a delay that can be used when retrying an operation

```
RetryConfig config = new DefaultRetryConfigBuilder()
    .setMaxAttempts(5)
    .setDelay(1000)
    .build();
```

The above example would return a config object with max attempts of 5
and a delay of 1 second, these are also the default settings so
the above is also the equivalent of:

```
RetryConfig config = new DefaultRetryConfigBuilder().build();
```

## Running the Tests

You can run the tests for this project by running the following command:

```
gradlew clean build
```

## Checking dependencies

You can check the current dependencies used by the project to see whether
or not they are currently up to date by running the following command:

```
gradlew dependencyUpdates
```