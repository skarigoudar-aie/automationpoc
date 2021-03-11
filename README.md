# Michael Kors test framework #

  Mk Test Framework is a initiative to enable automated testing Michael Kors ecom interfaces (including web clients).

## Tools & Technologies ##

* BDD : Cucumber JVM
* Language : Java
* Web Testing Tool : Selenium Webdriver
* Build Tool : Gradle 
* CI/CD : Jenkins

## Configuration ##

* Install JDK 11 or higher
* Install Gradle 6.0 or higher
* Download chrome or firefox selenium drivers to <User Dir>\drivers 
* clone this repository to a src directory
* Import the src as a Gradle Project into any IDE (Eclipse or IntelliJ IDEA)

## Running tests within IDE ##

 **Running against [REGION] website**

* Edit 'Runner[REGION][PLATFORM].java' (Ex - RunnerEuDesktop.java') and specify the cucumber tags to run
* Using Eclipse: You should already have a Junit run configuration called 'mk tests'. Just run the Junit run configuration to run the tests  
* Using IntelliJ IDEA: You should create a new Junit run configuration pointing to Main in 'Runner.java'

## Running tests via command line ##

 **running against EU website**

* cd to project checkout dir
* based on platform, run the following command: 

```gradle clean cucumberEuDesktop() -Denv=<ENV> -Dlocale=<LOCALE> -Dtags='<TAGS>'```

```gradle clean cucumberEuMobile() -Denv=<ENV> -Dlocale=<LOCALE> -Dtags='<TAGS>' -Dmobile```

**running against Global website**

* same commands as above, with the following replacements:
  
  * cucumberGlobalDesktop()
  
  * cucumberGlobalMobile()

**running against US website**

* same commands as above, with the following replacements:

  * cucumberUsDesktop()

  * cucumberUsMobile()

**running against CA website**

* same commands as above, with the following replacements:

  * cucumberCaDesktop()

  * cucumberCaMobile()


## Reports ##

* HTML reports can be found in the 'build' directory inside the project checkout directory

## Contact ##

Questions? Please contact <skarigoudar@aienterprise.com> or <akumari@aienterprise.com> or <stripati@aienterprise.com> or <npolishetty@aienterprise.com>
