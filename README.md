# Spring Boot Tutorial

Tutorial by [Amigoscode](https://www.youtube.com/channel/UC2KfmYEM4KCuA1ZurravgYw).

- [:clapper: Video on YouTube](https://youtu.be/9SGDpanrc8U)

## Table of Contents

- [Table of Contents](#table-of-contents)
- [Description](#description)
- [Project Summary](#project-summary)
- [API Documentation](#api-documentation)
  - [Get Students](#get-students)
    - [Request](#request)
    - [Sample Response (200 OK)](#sample-response-200-ok)
  - [Add Student](#add-student)
    - [Request](#request-1)
    - [Sample Request Body](#sample-request-body)
  - [Remove Student](#remove-student)
    - [Request](#request-2)
  - [Update Student](#update-student)
    - [Request](#request-3)
    - [Request Parameters](#request-parameters)
  - [Errors](#errors)
- [Deployment](#deployment)

## Description

From the YouTube description:

> "This Spring Boot Tutorial will teach how to get started with Spring Boot and Java."

## Project Summary

- Project: Maven
- Java: 16
- Spring Boot: 2.4.4
- Dependencies
  - Spring Data JPA
  - Spring Web
  - PostgreSQL
  - Spring Boot Starter Test
  - Spring Security
  - Bucket4j Spring Boot Starter
  - Spring Cache Abstraction
  - Ehcache
- Plugins
  - Spring Boot Maven Plugin
  - Heroku Maven Plugin

## API Documentation

### Get Students

Retrieves a list of all students.

#### Request

```http
GET /api/v1/student
```

#### Sample Response (200 OK)

```json
[
    {
        "id": "uuid1",
        "name": "Thiago",
        "email": "thiago@example.com",
        "dob": "1872-01-01",
        "age": 149
    },
    {
        "id": "uuid2",
        "name": "Alex",
        "email": "alex@example.com",
        "dob": "1754-01-01",
        "age": 267
    }
]
```

### Add Student

Add a new student to the application.

#### Request

```http
POST /api/v1/student
```

#### Sample Request Body

```json
{
    "name": "new-client",
    "email": "newclient@example.com",
    "dob": "2021-01-01"
}
```

### Remove Student

Remove student from the application.

#### Request

```http
DELETE /api/v1/student/:id
```

### Update Student

Update student information (name and/or email).

#### Request

```http
PUT /api/v1/student/:id
```

#### Request Parameters

| Param   | Description |
| :------ | :---------- |
| `name`  | New name    |
| `email` | New email   |

### Errors

- A student can't be **created** or **updated** if the new `email` already exists in the database.
- A student can't be **removed** or **updated** if the `id` does not exist in the database.

## Deployment

API deployed on [Heroku](https://fast-reaches-65809.herokuapp.com/)
