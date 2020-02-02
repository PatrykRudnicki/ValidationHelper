[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.patrykrudnicki/validation-helper_2.12.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.patrykrudnicki/validation-helper_2.12)

## Validation helper
Helper to make your validation more readable and easier to use.

## License
This code is open source software licensed under the Apache 2.0 License

## Usage

To use this library with sbt add the following code to your library dependencies.

```
libraryDependencies += "io.github.patrykrudnicki" % "validation-helper_2.12" % "0.6.0"
```

## Motivation
Validation helper gives you a possibility to validate elements with an easy and readable way.
Basically, it is implemented to use readable validation inside mapping for forms in Play Framework,
but based on the implementation you can use it in different places.

To represent logical `AND` and `OR` there are two generic methods that take function (`A => Boolean`) or `Boolean` and 
apply logic for it.

Specific validators are only prepared for `String`, but in the future, this library will support other type
(e.g. `Iterable`).

Using popular approach:
```
val mapping = Forms.mapping(
  "someInput" -> text().verifying("Some error", input => input.isEmpty || (input.forall(_.isDigit) && input.length <= 10)
)(SomeClass.apply)(SomeClass.unapply)
```

Validation using this library:
```
val mapping = Forms.mapping(
  "someInput" -> text().verifying("Some error", isEmpty or (isNumeric and noLongerThan(10)))
)(SomeClass.apply)(SomeClass.unapply)
```
