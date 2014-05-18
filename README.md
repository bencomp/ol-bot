ol-bot
======

RESTy service (stub) for manipulating [OpenLibrary](https://openlibrary.org) records based on Apache CXF (Java 7 EE).

## What it does

Accept a JSON record via POST and return a fixed version of that record.

## How to use

Build the WAR, deploy on GlassFish 4 or another Java 7 EE application server. The service will then accept JSON objects
representing Authors on relative URLs:

- `olbot/authorname`: returns the record with spaces in the name replaced by underscores
- `olbot/deathdate`: returns the record with the death date cleaned up

## Maven commands

- `mvn test` runs the JUnit tests after building the classes.
- `mvn install` builds the whole WAR and runs tests and integration tests.
