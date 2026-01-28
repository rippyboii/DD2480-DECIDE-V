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
- `.github/workflows/maven-publish.yml`: Contains workflow for build and test used by github Actions.

## Testing
Unit tests are implemented using JUnit 5. Each LIC and major component has corresponding test cases in the `decide/src/test/java/com/decide/` directory. There are always at least one positive and one negative test case for each class.
### Test your parameters:

- To run DECIDE with custom inputs, edit    `decide/src/main/java/com/decide/Main.java` and update:
    - `Point[] points`
    - `Parameters parameters`
    - `Connector[][] lcm`
    - `boolean[] puv`

## Statement of Contributions

### Individual Contribution:
#### Dev. Fabian W: 
> Implemented functions for PUM, FUV, Demo, and LIC 2-4,7.


#### Dev. Apeel Subedi
> Initialized repository setup; added and implemented CI to test and build on every push/pull; LIC(0, 6, 11); geometry helper functions


#### Dev. Carl Isaksson: 
> Geometry helper functions, LICs 8,10, documenting way of working (Essence), License implementation.

#### Dev. Josef Kahoun
> Implemented CMV evaluation, shared LIC interface, LICs 1, 12, 13, and related geometrical helper functions.

#### Dev. Alexander Runebou:
>  Initialized maven setup, implemented core classes like Parameters, LICs 5, 9, 14, refactoring, documentation.

### Team Achievement

> **Continuous Integration & Build Status Badge:**  
We introduced a GitHub Actions CI pipeline that builds the project and runs all unit test on every push and pull request (see `.github/workflows/maven-publish.yml`). The badge at the top of this README reflects the latest CI status.

> **Two-Stage Branch Protection (dev -> main):**  
We implemented a two-branch workflow with protection rules on both `dev` and `main`. Feature and fix branches are merged into `dev` via pull requests requiring at least two approvals and a passing CI check. The `main` branch is reserved for stable, reviewed changes. This setup keeps `main` consistently stable while allowing collaborative development on `dev`.

> **Conventional Commits & Consistent Naming:**  
We followed the Conventional Commits specification for commit messages throughout the project (e.g., `feat:`, `fix:`, `refactor:`, `test:`, `docs:`), making the change history easy to scan and review. In addition, we maintained consistent naming conventions across the codebase (classes, methods, variables, and packages) to keep the project readable and predictable for all team members.

## Way of Working
Our team operates at the **In Place** state according to the Essence framework. We have established agreed-upon tools, coding practices, version control, and testing strategies that all team members use and understand. A collaborative environment supports knowledge sharing and continuous feedback. To reach the **Working Well** state, we aim to apply practices more naturally and continuously refine our workflow without conscious effort.

For a detailed description, see our Wiki page at: [Way of Working documentation](https://github.com/rippyboii/DD2480-DECIDE-V/wiki/Way-of-Working).


## License
This project is licensed under the [MIT License](LICENSE). You are free to use, modify, and distribute this software. See the `LICENSE` file for full details.