[![Maven Build and Test](https://github.com/rippyboii/DD2480-DECIDE-V/actions/workflows/maven-publish.yml/badge.svg)](https://github.com/rippyboii/DD2480-DECIDE-V/actions/workflows/maven-publish.yml)

# DD2480-DECIDE-V

## Summary
DECIDE is a Java implementation of a decision algorithm that analyzes sequences of 2D tracking data to determine whether a hypothetical missile launcher should fire an interceptor. It evaluates a set of predefined geometric conditions (15 LICs) and computes a final Boolean decision by combining them according to logical rules defined in the DECIDE specification.

## Description
This project implements the `DECIDE()` function from the Launch Interceptor Program specifications by J. C. Knight and N. G. Leveson, (adapted by John Regehr and Martin Monperrus). Given up to 100 planar radar tracking points, the system evaluates 15 *Launch Interceptor Conditions* (*LICs*) and stores the result in the *Conditions Met Vector* (*CMV*).

The CMV is then combined with the *Logical Connector Matrix* (*LCM*) to produce the *Preliminary Unlocking Matrix* (*PUM*), which represents how LICs must be logically paired using `ANDD`, `ORR`, or `NOTUSED`.

Finally, the *Preliminary Unlocking Vector* (*PUV*) determines which LICs are relevant for the current launch decision, producing the *Final Unlocking Vector* (*FUV*) that indicates whether to launch or not. The launch signal to `LAUNCH` is issued if and only if all elements of the FUV are true.

This implementation follows the required parameter constraints and computation rules defined in the DECIDE specification.

## Requirements
- Java 21 (JDK)

Verify your Java installation by running:
```bash
java -version
```

This project uses Maven Wrapper, no local Maven installation is required.

## Build and Run
```bash
./mvnw clean test
./mvnw exec:java
```

## Project Structure
- `decide/src/main/java/com/decide/`: Contains all implementation and the `Main.java` entry point.
- `decide/src/main/java/com/decide/model/`: Contains the core data models and logical components.
- `decide/src/main/java/com/decide/geometry/`: Contains geometric helper functions.
- `decide/src/main/java/com/decide/lics/`: Contains all Launch Interceptor Conditions (LICs) implementations.
- `decide/src/test/java/com/decide/`: Contains unit tests for the implementation

## Testing
Unit tests are implemented using JUnit 5. Each LIC and major component has corresponding test cases in the `decide/src/test/java/com/decide/` directory. There are always at least one positive and one negative test case for each class.

## Statement of Contributions
> Fabian W: 
- Implemented functions for PUM, FUV, Demo, and LIC 1-3.

> Apeel Subedi
- Initialized repository setup; added and implemented CI to test and build on every push/pull; LIC(0, 6, 11); geometry helper functions

Carl Isaksson: 
- Geometry helper functions, LICs 8,10, documenting way of working (Essence), License implementation.

> Josef Kahoun
- Implemented CMV evaluation, shared LIC interface, LICs 1, 12, 13, and related geometrical helper functions.

> Alexander Runebou:
> - Initialized maven setup, implemented core classes like Parameters, LICs 5, 9, 14, refactoring, documentation.