# Spectrum

# Spectrum-service

## Build

### Spectrum service build and deploy Instructions in localhost

1. Clone this repository
2. cd Spectrum
3. ./gradlew clean bootRun

## Development

### Prerequisites

* Java 1.11
* Gradle 

### Build

Build uses standard Gradle lifecycle:

    ./gradlew clean build

### Run

This is a spring Boot Application, so you can run it directly from your IDE by using `com.spectrum.SpectrumApplication`
starter class.

You may run also run Spring boot application from command line or by configuring your IDE to run the following
gradle task:

    ./gradlew clean bootRun

Once application is running open a browser and hit below URL's




Below filters are use to filter the data
-----------------------------------------
sortFiled : organization=organization name, release=organization name and labor=total labor hours
sortType: default 0, where 0=ascending,1=descending

To Export Json data
-----------------------------------------
http://localhost:8080/spectrum/exportJson?sortFiled=release&sortType=0


To Export CSV
-----------------------------------------
http://localhost:8080/spectrum/exportCSV?sortFiled=release&sortType=0
